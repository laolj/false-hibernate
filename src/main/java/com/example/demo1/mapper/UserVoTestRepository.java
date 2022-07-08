package com.example.demo1.mapper;

import com.example.demo1.pojo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 继承JpaRepository 实现分页增删改查功能
 * 继承JpaSpecificationExecutor 实现复杂的多表查询功能
 */
@Repository
public interface UserVoTestRepository extends JpaRepository<UserVO, Long>, JpaSpecificationExecutor<UserVO> {

    //登录
    @Query(value = "select id,username,password,role from user where username = :username and password = :password",nativeQuery = true)
    List<Map<String,Object>> findByUsernameAndPassword(@Param("username")String username,@Param("password") String password);
}
