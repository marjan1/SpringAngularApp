package nl.datavisual.service;

import nl.datavisual.domain.entity.OrganizationSubunit;
import nl.datavisual.domain.repo.UserRepository;
import nl.datavisual.dto.User;
import nl.datavisual.spec.bilder.UserSpecificationsBuilder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    Logger log = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<User> searchUser(Integer companyId, Integer roleId, String email, String name, String username, Integer statusCode) {
        log.debug("Search User by email = {}, name ={}, username = {}, statusCode = {}, companyId = {}, roleId = {}", email, name, username, statusCode, companyId, roleId);

             List<User> users = userRepository.findUsersByParams(email,name,statusCode,username,companyId,roleId)
                     .stream().map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
//                userRepository.findAll(userSpecificationsBuilder.build()).stream()
//                .map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
        return users;
    }

    public List<OrganizationSubunit> getAllOrganizationSubunitsForUserByUsername(String username) {
        log.debug("Get all organizational subunits for user by username ={}", username);
        return userRepository.getAllOrganizationSubunitsForUserByUsername(username);
    }

    public List<User> getAllUsersByEmailPart(String emailPart) {
        log.debug("Get user by email that contains [{}]", emailPart);
        return userRepository.findUsersByEmailPart(emailPart).stream()
                .map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
    }

    public User create(User user) {

        final nl.datavisual.domain.entity.User savedUser = userRepository.save(modelMapper.map(user, nl.datavisual.domain.entity.User.class));
        return modelMapper.map(savedUser, User.class);
    }

    public User delete(long id) {
        nl.datavisual.domain.entity.User user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return modelMapper.map(user, User.class);
    }

    public List<User> findAll() {

        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
    }

    public User findById(long id) {
        return modelMapper.map(userRepository.findOne(id), User.class);
    }

    public User update(User user) {
        if (userRepository.exists(user.getIdUsers())) {
            userRepository.save(modelMapper.map(user, nl.datavisual.domain.entity.User.class));
        }
        return modelMapper.map(user, User.class);
    }
}

