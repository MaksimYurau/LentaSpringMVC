package by.andrew.storage;

import by.andrew.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {
    private List<User> users = new ArrayList<>();

    public  boolean save (User user){
        return  users.add(user);

    }
    public User getByLogin(String login){
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }

        }
      return null;
    }

}
