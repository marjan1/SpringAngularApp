package nl.datavisual.api;

import nl.datavisual.dto.User;
import nl.datavisual.service.CompanyService;
import nl.datavisual.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private CompanyService companyService;


    public UserController(UserService userService, CompanyService companyService) {
        this.userService = userService;
        this.companyService = companyService;
    }


    @GetMapping(path = "/search")
    public List<User> searchUser(@RequestParam(required = false) Integer companyId,
                                 @RequestParam(required = false) Integer roleId,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) String username,
                                 @RequestParam(required = false) Integer statusCode) {

        return userService.searchUser(companyId, roleId, email, name, username, statusCode);
    }


    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping(path = {"/{id}"})
    public User findOne(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(path = {"/{id}"})
    public User delete(@PathVariable("id") int id) {

        return userService.delete(id);
    }

    @GetMapping
    public List<User> findAll() {
        Iterable<User> users = userService.findAll();
        List<User> listOfUsers = (List<User>) users;
        return listOfUsers;
    }
}