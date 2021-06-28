package by.tms.service;

import by.tms.entity.User;
import by.tms.storage.UserStorage;

public class UserService {
    private UserStorage userStorage = new UserStorage();

    public boolean add(User user){
        if(userStorage.existsByUsername(user.getUsername())){
            return false;
        } else {
            userStorage.add(user);
            return true;
        }
    }

    public User findByUsername(String username){
        if(userStorage.existsByUsername(username)){
            return userStorage.getByUsername(username);
        }
        return null;
    }

    public void deleteUser(User u){
        userStorage.delete(u);
    }

    public void renameUser(User u, String newUsername){
        User byUsername = userStorage.getByUsername(u.getUsername());
        byUsername.setUsername(newUsername);
    }

    public void changePassword(User u, String newPassword){
        userStorage.getByUsername(u.getUsername()).setPassword(newPassword);
    }

    public User getByUser(User u){
        return userStorage.getByUsername(u.getUsername());
    }
}
