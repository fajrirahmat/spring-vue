package com.message.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.message.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

}
