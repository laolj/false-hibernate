package com.example.demo1.mapper;

import com.example.demo1.pojo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * 继承JpaRepository 实现分页增删改查功能
 * 继承JpaSpecificationExecutor 实现复杂的多表查询功能
 */
@Repository
public interface UserVoTestRepository extends JpaRepository<UserVO, Long>, JpaSpecificationExecutor<UserVO> {

}
