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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;
    private String role;

    @OneToOne
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "userame: " + username + ", password: " + password + ", role: " + role;
    }

}
