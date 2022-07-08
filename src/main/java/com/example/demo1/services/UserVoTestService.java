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
import java.util.Map;

@Service
public class UserVoTestService {


    @Autowired
    private UserVoTestRepository userVoTestRepository;



    @Autowired
    private UserSecRepository userSecRepository;



    //采用query语句的方法
    public List<Map<String,Object>> login(String username, String password){
        return userVoTestRepository.findByUsernameAndPassword(username,password);
    }

    //采用lambda表达式的方法,纯Java语言
    public List<UserVO>  lambdaLogin(String username,String password){
        List<UserVO> all = userVoTestRepository.findAll(new Specification<UserVO>() {
            @Override
            public Predicate toPredicate(Root<UserVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate conjunction = criteriaBuilder.conjunction();
                Predicate predicate = criteriaBuilder.and(conjunction, criteriaBuilder.equal(root.get("username"), username), criteriaBuilder.equal(root.get("password"), password));
                return predicate;
            }
        });
        System.out.println(all);
        return all;
    }


    /**
     * 分页查询
     * @param num  第几页开始
     * @param size 一页多少个数据
     * @return
     */
    public Page<UserVO> loadAll(Integer num,Integer size){
        Pageable pageRequest = PageRequest.of(num, size);
        Page<UserVO> all = userVoTestRepository.findAll(pageRequest);
        return all;
    }


    public void learn(){
        List<UserVO> all = userVoTestRepository.findAll(new Specification<UserVO>() {
            @Override
            public Predicate toPredicate(Root<UserVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<UserVO, UserSec> userSec = root.join("userSec", JoinType.LEFT);
                Predicate username = criteriaBuilder.like(root.get("username"), "admin1%");
                return username;
            }
        });
        System.out.println(all);
    }


    /**
     * 查询所有数据
     * @return
     */
    public List<UserVO> listAll(){
        return userVoTestRepository.findAll();
    }


    /**
     * 复杂查询
     */
    public void hello(){
//        List<UserSec> all = userSecRepository.findAll();
//        System.out.println(all);
//        List<UserVO> all = userVoTestRepository.findAll();
//        System.out.println(all);
        Specification<UserVO> specification = new Specification<UserVO>() {
            @Override
            public Predicate toPredicate(Root<UserVO> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Join<UserVO, UserSec> join = root.join("userSec", JoinType.INNER);
                predicates.add(criteriaBuilder.equal(join.get("uid"), 8));
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
            UserVO userVO = new UserVO();
            userVO.setId((long) i);
            userVO.setUsername("admin" + i);
            userVO.setPassword("123" + i);
            userVO.setRole("admin" + i);
            String ls;
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


    /**
     * 基哥 教我的 写法  采用匿名内部类的方法 lambda表达式
     */
    public void getOneToOne(){
        List<UserVO> all = userVoTestRepository.findAll(
                (root, cq, cb) -> {
                    //级联那些表？选择实体类中添加的属性名->这个属性名级联到的就是另外一个表名,后面再加多表连接方式
                    Join<UserVO, UserSec> userSec = root.join("userSec", JoinType.INNER);
                    //下面这个语句的底层使用的sql语句为：select uservo0_.id as id1_0_, uservo0_.password as password2_0_, uservo0_.role as role3_0_, uservo0_.username as username4_0_ from user uservo0_ inner join user_sec usersec1_ on uservo0_.id=usersec1_.uid where usersec1_.uid=8;
                    Predicate uid = cb.equal(userSec.get("uid"), 8);//这个8的地方可以传一个参数进来，表示要查询的条件
                    return cb.and(uid);
                }
        );
        System.out.println(all);
    }









}
