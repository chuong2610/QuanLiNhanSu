/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Role {
    private int id;
    private String name;
    private int roleSalary;

    public Role() {
    }

    public Role(int id, String name, int roleSalary) {
        this.id = id;
        this.name = name;
        this.roleSalary = roleSalary;
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

    public float getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(int roleSalary) {
        this.roleSalary = roleSalary;
    }
    
    
}
