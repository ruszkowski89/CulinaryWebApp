package ruszkowski89.springmvc.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ruszkowski89.springmvc.model.Recipe;
import ruszkowski89.springmvc.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUserName (String userName);
    User findById (long id);
    boolean existsByUserName (String userName);
    boolean existsByEmail (String email);

}
