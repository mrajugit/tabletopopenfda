package mvp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mvp.exception.MvpException;
import mvp.jpa.User;
import mvp.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
 
	@Autowired
    UserService us;   
 
    @GetMapping("/users")
    public List<User> getUsers() throws MvpException{
        try {
			return us.getAllUsers();
		} catch (Exception e) {
			throw new MvpException(e);
		}
    }
    
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) throws MvpException{        
    	try {
			return us.getUser(Long.valueOf(id));
		} catch (Exception e) {
			throw new MvpException(e);
		}
    }
 
    @PostMapping("/users")
    public void addUser(@RequestBody User user) throws MvpException{   	
    	try {
			us.addUser(user);
		} catch (Exception e) {
			throw new MvpException(e);
		}    	
    }
    
    
    @PutMapping("/users/{id}")
    public void replaceUser(@RequestBody User newValue, @PathVariable String id) throws MvpException{
    	try {
			us.editUser(newValue, Long.valueOf(id));
		} catch (Exception e) {
			throw new MvpException(e);
		}
    	
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) throws MvpException{
    	try {
			us.deleteUser(Long.valueOf(id));
		} catch (Exception e) {
			throw new MvpException(e);
		} 
    }
}