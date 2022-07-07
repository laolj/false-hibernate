package com.example.demo1.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_sec")
@NoArgsConstructor
@Data
public class UserSec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer age;
    private String usersec;

    @OneToOne(mappedBy = "UserVO")
    private UserVO userVO;

//    @OneToOne(targetEntity = UserVO.class)
//    @JoinColumn(name = "id",referencedColumnName = "id")
//    private UserVO userVO;
//
//    public UserVO getUserVO() {
//        return userVO;
//    }
//
//    public void setUserVO(UserVO userVO) {
//        this.userVO = userVO;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsersec() {
        return usersec;
    }

    public void setUsersec(String usersec) {
        this.usersec = usersec;
    }
}
