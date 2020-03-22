package com.doddd.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 18:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shiro_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String permission;
}
