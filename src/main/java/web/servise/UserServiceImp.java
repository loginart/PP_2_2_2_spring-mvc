package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;
import java.util.List;
//
@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void addUser(User user) {
    userDao.addUser(user);
    }


    @Override
    public List<User> getAllUser() {
       return userDao.getAllUser();
    }

    @Override
    public void deleteUser(Integer userId) {
    userDao.deleteUser(userId);
    }

    @Override
    public User updateUser(Integer id, User updateUser) {
        return userDao.updateUser(id,updateUser);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}
