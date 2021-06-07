package com.qursed.CRUDTask.DAO;

import com.qursed.CRUDTask.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> users = new ArrayList<>();
    {
        users.add(new User("Alexander", "Koromyslov", 1500));
        users.add(new User("Egor", "Zakurin", 2500));
    }

    public List<User> index(){
        return users;
    }
    public User show(int id){
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
