package com.myhotel.myhotel.api.repository;


import com.myhotel.myhotel.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String username);
}
