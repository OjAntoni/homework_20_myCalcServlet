package by.tms.storage;

import by.tms.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static final List<User> users = new ArrayList<>();

    public void add(User u){
        if(u==null) return;
        users.add(u);
    }

    public void delete(User u){
        if(u==null) return;
        users.remove(u);
    }

    public User getByUsername(String surname){
        for(User u : users){
            if(u.getUsername().equals(surname))
                return u;
        }
        return null;
    }

    public boolean existsByUsername(String surname){
        return users.stream().anyMatch(t->t.getUsername().equals(surname));
    }
}
