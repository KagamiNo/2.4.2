package com.qursed.CRUDTask.Service;

import com.qursed.CRUDTask.DAO.UserDAO;
import com.qursed.CRUDTask.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.index();
    }

    @Transactional
    public User show(int id) {
        return userDAO.show(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        userDAO.update(id, updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

}
