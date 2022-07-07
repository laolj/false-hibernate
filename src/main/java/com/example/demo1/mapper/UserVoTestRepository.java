package com.example.demo1.mapper;

import com.example.demo1.pojo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVoTestRepository extends JpaRepository<UserVO, Long>, JpaSpecificationExecutor<UserVO> {

}
