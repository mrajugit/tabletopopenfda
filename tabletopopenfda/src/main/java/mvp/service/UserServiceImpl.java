package mvp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mvp.jpa.User;
import mvp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	 private UserRepo userRepository ;
	    
    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }


	@Override
	public void deleteUser(long id) throws Exception{
		userRepository.deleteById(id);		
	}

	@Override
	public void editUser(User modUser, long id) throws Exception{
		User user = userRepository.findById(id).orElse(null);
    	if(user !=  null) {    		
    		User existingUser = new User();
    		existingUser.setId(id);
    		existingUser.setEmail(modUser.getEmail());
    		existingUser.setName(modUser.getName());
    		userRepository.save(existingUser);    	 
    	} 
		
	}

	@Override
	public void addUser(User user) throws Exception{
		userRepository.save(user);  
	}

	@Override
	public User getUser(long id) throws Exception{
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() throws Exception{
		return (List<User>) userRepository.findAll();
	}

}
