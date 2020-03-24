package org.launchcode.todo.repositories;


import org.launchcode.todo.models.User;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

    @Override
    List<User> findAll();
}