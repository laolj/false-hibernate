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
    @Column(name = "uid", nullable = false)
    private Long uid;

    @Column(name = "age")
    private Integer age;


    @Column(name = "usersec")
    private String usersec;







//    @OneToOne(targetEntity = UserVO.class)
//    @JoinColumn(name = "id",referencedColumnName = "id")
//    private UserVO userVO;
//
//    public UserVO getUserVO() {/**/
//        return userVO;
//    }
//
//    public void setUserVO(UserVO userVO) {
//        this.userVO = userVO;
//    }


}
