package com.letscode.simple.repos;

import com.letscode.simple.models.Message;
import com.letscode.simple.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
