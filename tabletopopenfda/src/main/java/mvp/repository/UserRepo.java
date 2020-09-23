package mvp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mvp.jpa.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{}