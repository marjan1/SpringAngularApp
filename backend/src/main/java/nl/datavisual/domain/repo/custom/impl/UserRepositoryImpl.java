package nl.datavisual.domain.repo.custom.impl;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import nl.datavisual.domain.repo.custom.UserRepositoryCustom;
import nl.datavisual.domain.entity.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findUsersByEmailPart(String emailPart) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        final QUser user = QUser.user;

        List<User> userList = queryFactory.selectFrom(user)
                .where(user.email.contains(emailPart)).fetch();

        return userList;
    }

    public Company getCompanyByUsername(String username) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QCompany company = QCompany.company;
        QUser user = QUser.user;
//        BooleanBuilder builder = new BooleanBuilder();
//        builder.and(company.users.contains(user));
//        builder.and(user.email.contains(username));

        User user1 = queryFactory.selectFrom(user).where(user.username.eq(username)).fetchFirst();
        return user1.getCompany();
    }

    public List<OrganizationSubunit> getAllOrganizationSubunitsForUserByUsername(String username) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QOrganizationSubunit organisationSubunit = QOrganizationSubunit.organizationSubunit;

        List<OrganizationSubunit> organizationSubunitList = queryFactory.selectFrom(organisationSubunit)
                .where(organisationSubunit.organizationUnit.company.users.any().username.eq(username)).fetch();

        return organizationSubunitList;
    }

    public List<Tuple> getNumberOfUsersPerCompany() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QCompany company = QCompany.company;
        QUser user = QUser.user;


        List<Tuple> usersPerCompany = queryFactory.select(company.companyName, user.idUsers.count())
                .from(user)
                .innerJoin(user.company, company)
                .groupBy(company.companyName)
                .orderBy(company.companyName.desc())
                .fetch();


        return usersPerCompany;
    }

    @Override
    public List<User> geCompanyUsersPerRole(Role roleParam, Company companyParam) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUser user = QUser.user;
        QRole role = new QRole("t");



        List<User> usersPerCompany = queryFactory
                .selectFrom(user)
                .leftJoin(user.roles, role)
                .where(role.eq(roleParam).and(user.company.eq(companyParam)))
                .distinct().fetch();


        return usersPerCompany;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUser user = QUser.user;
        queryFactory.delete(user).where(user.idUsers.eq(id)).execute();

    }

    @Override
    @Transactional
    public long updateOrganizationSubunitsForUserByUsername(String username) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QOrganizationSubunit organisationSubunit = QOrganizationSubunit.organizationSubunit;

        long rowsUpdated = queryFactory
                .update(organisationSubunit)
                .where(organisationSubunit.organizationUnit.company.users.any().username.eq(username))
                .set(organisationSubunit.code,"updated_Code")
                .set(organisationSubunit.name,"updated_Name")
                .execute();

        return rowsUpdated;
    }





}
