package com.stockapp.restfulapi.User;


import org.springframework.data.repository.CrudRepository;
import com.stockapp.restfulapi.User.User;

public interface UserRepository extends CrudRepository<User, Integer>{
}
