package mvp;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mvp.jpa.User;
import mvp.repository.UserRepo;

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
        System.out.println( "Done! " );
    }
    
    @Bean
    ApplicationRunner init(UserRepo userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User();
                user.setName(name);
                user.setEmail(name.toLowerCase() + "@domain.com");               
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
}
