package mvp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mvp.jpa.User;
@Service("userService")
public interface UserService {
	void deleteUser(long id) throws Exception;
	void editUser(User modUser, long id) throws Exception;
	void addUser(User user) throws Exception;
	User getUser(long id) throws Exception;
	List<User> getAllUsers()  throws Exception;
}
