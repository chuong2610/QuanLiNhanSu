/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class Employee {
    private int id;
    private String name;
    private String phone;
    private String email;
    private LocalDate Date;
    private String userName;
    private String password;
    private Role role;
    private String img;

    public Employee() {
    }

    public Employee(int id, String name, String phone, String email, LocalDate Date, String userName, String password, Role role,String img) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.Date = Date;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.img=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate Date) {
        this.Date = Date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

    
    
    
}
