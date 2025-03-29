package web.dao;

import web.model.User;

import java.util.List;

//
public interface UserDao {

    public void addUser(User employee);

    public List<User> getAllUser();

    public void deleteUser(Integer employeeId);

    public User updateUser(Integer id, User updateUser);

    public User getUser (Integer id);

}


