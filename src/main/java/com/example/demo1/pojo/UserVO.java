package com.example.demo1.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 数据表user映射类
 */

@Entity
@Table(name = "user") //引入@Table注解，name赋值为表名
@NoArgsConstructor
@Data
public class UserVO {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;


    @OneToOne(targetEntity = UserSec.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id",referencedColumnName = "uid")
    private UserSec userSec;




//    @OneToOne(targetEntity = UserSec.class)
//    @JoinColumn(name = "id",referencedColumnName = "id")
//    private UserSec userSec;

//    public UserSec getUserSec() {
//        return userSec;
//    }
//
//    public void setUserSec(UserSec userSec) {
//        this.userSec = userSec;
//    }



}
