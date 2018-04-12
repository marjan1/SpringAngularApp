package nl.datavisual.domain.repo;

import nl.datavisual.domain.repo.custom.UserRepositoryCustom;
import nl.datavisual.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom, QueryDslPredicateExecutor<User> {
    User findFirstByIdUsers(Long idUser);
}
