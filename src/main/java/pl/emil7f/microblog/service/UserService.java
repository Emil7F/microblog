package pl.emil7f.microblog.service;

import pl.emil7f.microblog.model.User;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User findUserById(Long id);

    List<User> findAllUsers();

    User updateUser(Long id, User user);
}
