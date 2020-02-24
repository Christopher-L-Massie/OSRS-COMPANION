package com.example.OSRSCOMPANION.models.data;

import com.example.OSRSCOMPANION.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
}
