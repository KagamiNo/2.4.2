package com.qursed.CRUDTask.DAO;

import com.qursed.CRUDTask.Models.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public User getUserByLogin(String login) {
        return (User) entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login")
                .setParameter("login", login)
                .getSingleResult();
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Transactional
    public void update(int id, User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Transactional
    public void delete(int id) {
        entityManager.remove(show(id));
        entityManager.flush();
    }
}
