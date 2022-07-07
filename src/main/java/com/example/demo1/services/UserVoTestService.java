package com.example.demo1.services;

import com.example.demo1.mapper.UserSecRepository;
import com.example.demo1.mapper.UserVoTestRepository;
import com.example.demo1.pojo.UserSec;
import com.example.demo1.pojo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserVoTestService {


    @Autowired
    private UserVoTestRepository userVoTestRepository;



    @Autowired
    private UserSecRepository userSecRepository;

    public Page<UserVO> loadAll(Integer num,Integer size){
        Pageable pageRequest = PageRequest.of(num, size);
        Page<UserVO> all = userVoTestRepository.findAll(pageRequest);
        return all;
    }


    public List<UserVO> listAll(){
        return userVoTestRepository.findAll();
    }



    public void hello(){
//        List<UserSec> all = userSecRepository.findAll();
//        System.out.println(all);
//        List<UserVO> all = userVoTestRepository.findAll();
//        System.out.println(all);
        Specification<UserVO> specification=new Specification<UserVO>() {
            @Override
            public Predicate toPredicate(Root<UserVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates=new ArrayList<>();
                Join<UserVO, UserSec> join = root.join("userSec", JoinType.INNER);
                predicates.add(criteriaBuilder.equal(join.get("uid"),8));
                Predicate[] predicates1 = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicates1));
            }
        };
//        System.out.println("=====================");
//        List<UserVO> all1 = userVoTestRepository.findAll();
//        System.out.println(all1);
        System.out.println("==================");
        System.out.println(specification);
        List<UserVO> all = userVoTestRepository.findAll(specification);
        System.out.println(all);
    }


    public void add(){
        for (int i = 0; i < 10; i++) {
            UserVO userVO=new UserVO();
            userVO.setId((long)i);
            userVO.setUsername("admin"+i);
            userVO.setPassword("123"+i);
            userVO.setRole("admin"+i);
//            UserSec userSec=new UserSec();
//            userSec.setAge(i);
//            userSec.setUid((long) i);
//            userSec.setUsersec("admin"+i);
//            userSecRepository.save(userSec);
            userVoTestRepository.save(userVO);
        }
    }



    public void addUserSec(){
        for (int i = 0; i < 10; i++) {
            UserSec userSec=new UserSec();
            userSec.setUid((long)i);
            userSec.setAge(20+i);
            userSec.setUsersec("addSec"+i);
            userSecRepository.save(userSec);
        }
    }









}
