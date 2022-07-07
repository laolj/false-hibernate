package com.example.demo1.mapper;

import com.example.demo1.pojo.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSecRepository extends JpaRepository<UserSec,Long> {
}
