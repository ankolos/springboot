package com.letscode.simple.repos;

import com.letscode.simple.models.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    Iterable<Message> findByTag(String tag);
}
