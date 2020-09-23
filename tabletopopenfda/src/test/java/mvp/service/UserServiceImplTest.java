package mvp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mvp.jpa.User;
import mvp.repository.UserRepo;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {
	
	
    private UserServiceImpl userService;
    private User newUser = new User();
    private User john = new User();
    private User bob = new User();
    private User alex = new User();

	@MockBean
    private UserRepo userRepository;
    
	@Before
    public void setUp() {
	  userService = new UserServiceImpl(userRepository);

      
      //john.setId(1L);
      john.setName("John");
      john.setEmail("john@domain.com");
      
     
      //bob.setId(2L);
      bob.setName("Bob");
      bob.setEmail("bob@domain.com");

     
     // alex.setId(3L);
      alex.setName("Alex");
      alex.setEmail("alex@domain.com");
      
     
     // newUser.setId(4L);
      newUser.setName("New");
      newUser.setEmail("new@domain.com");

      List<User> allUsers = Arrays.asList(john, bob, alex);

      Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(john)); 
      Mockito.when(userRepository.findAll()).thenReturn(allUsers);
      Mockito.when(userRepository.save(newUser)).thenReturn(newUser);
    
  
    }


	@Test
	public void testDeleteUser() throws Exception {
		john.setId(1L);
		userService.deleteUser(1L);		
		verify(userRepository,times(1)).deleteById(1L);
	}

	@Test
	public void testEditNotFoundUser() throws Exception {
		userService.editUser(newUser, 4L);
		verify(userRepository,times(1)).findById(4L);	
		verify(userRepository,times(0)).save(newUser);			
	}
	
	@Test
	public void testEditUser() throws Exception {
		john.setId(1L);
		userService.editUser(john, 1L);
		verify(userRepository,times(1)).findById(1L);	
		verify(userRepository,times(1)).save(john);
		
	}

	@Test
	public void testAddUser() throws Exception {
		 userService.addUser(newUser);
		 verify(userRepository,times(1)).save(newUser);		 
	}

	@Test
	public void testGetUserFound() throws Exception {
        User found = userService.getUser(1L);
        assertThat(found.getName()).isEqualTo("John");
	}
	
	@Test
	public void testGetUserNotFound() throws Exception {
        User notfound = userService.getUser(5L);
        assertThat(notfound).isEqualTo(null);
	}

	@Test
	public void testGetAllUsers() throws Exception {
		List<User> allUsers = userService.getAllUsers();
		assertThat(allUsers.size()).isEqualTo(3);
	}


	

}
