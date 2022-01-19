package com.example.fast.repository;

import com.example.fast.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where account = ? << test03, test04 등등 account를 통해 검색
    Optional<User> findByAccount(String account);

    Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ? << 두 가지 정보를 통해 검색
    Optional<User> findByAccountAndEmail(String account, String email);
}
