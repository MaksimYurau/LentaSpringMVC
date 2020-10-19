package by.andrew.service;

import by.andrew.domain.User;
import by.andrew.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    UserStorage userStorage;


    public boolean save (User user){
     return userStorage.save(user);
    }

    public  User getByLogin(String login){
       return userStorage.getByLogin(login);
    }
}
