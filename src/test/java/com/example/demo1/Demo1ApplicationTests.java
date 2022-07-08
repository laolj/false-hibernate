package com.example.demo1;

import com.example.demo1.mapper.UserSecRepository;
import com.example.demo1.mapper.UserVoTestRepository;
import com.example.demo1.pojo.UserSec;
import com.example.demo1.pojo.UserVO;
import com.example.demo1.services.UserVoTestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private UserVoTestRepository userVoTestRepository;

    @Autowired
    private UserSecRepository userSecRepository;

    @Resource
    private UserVoTestService userVoTestService;

    @Test
    void contextLoads() {
        List<UserVO> all = userVoTestRepository.findAll(
                (user, cq, cb) -> {
                    Predicate id1 = cb.equal(user.join("userSec", JoinType.LEFT).get("id"), 7);
                    return id1;
                }
        );
        System.out.println(all);

    }

    @Test
    void context1(){
        List<UserSec> all = userSecRepository.findAll();
        System.out.println(all);
    }


    @Test
    void context2(){
        userVoTestService.lambdaLogin();
    }

}
