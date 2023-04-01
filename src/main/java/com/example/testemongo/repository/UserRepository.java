package com.example.testemongo.repository;

import com.example.testemongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String>
{
    @Query("{_id: '?0'}")
    User findUserById(String _id);
}
