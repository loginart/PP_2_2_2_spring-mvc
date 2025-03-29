package web.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

//
public interface UserService {

    public void addUser(User employee);

    public List<User> getAllUser();

    public void deleteUser(Integer employeeId);

    public User updateUser(Integer id, User updateUser);

    public User getUser (Integer id);


}
