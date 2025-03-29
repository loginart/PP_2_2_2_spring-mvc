package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
//
@Component
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
   private EntityManager entityManager;


    @Override
    public void addUser(User employee) {
        entityManager.persist(employee);

    }

    @Override
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteUser(Integer employeeId) {
        entityManager.remove(entityManager.find(User.class, employeeId));
    }

    @Override
    public User updateUser( Integer id, User updateUser) {
        User existingUser  = entityManager.find(User.class, id);

        if (existingUser  != null) {

            existingUser.setName(updateUser.getName());
            existingUser.setLastName(updateUser.getLastName());
            existingUser.setAge(updateUser.getAge());
            return existingUser ;
        } else {

            return null;
        }
    }


    @Override
    public User getUser (Integer id) {

       return entityManager.find(User.class, id);
    }
}
