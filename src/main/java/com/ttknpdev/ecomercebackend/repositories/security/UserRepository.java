package com.ttknpdev.ecomercebackend.repositories.security;

import com.ttknpdev.ecomercebackend.entities.security.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

// If you use passed @Service. it do not need to use @Repository
public interface UserRepository extends CrudRepository<User,Long> {
    // behind the sens ... auto
    User findByUsername(String username);

    // *** for query on my own (work for set default rule field)
    @Transactional
    @Modifying
    @Query(value = "insert into users(username,password) values(:username , :password) ", nativeQuery = true)
    void addUser(@Param("username") String username , @Param("password") String password);
}
