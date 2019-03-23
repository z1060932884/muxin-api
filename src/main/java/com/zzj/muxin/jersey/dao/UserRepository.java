package com.zzj.muxin.jersey.dao;

import com.zzj.muxin.db.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, String> {



    @Query(value = "SELECT u FROM User u WHERE name=:name")
    public User findName(@Param("name") String name);

}
