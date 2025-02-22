/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author ADMIN
 */
public class RoleDTO {
    private String name;
    private int roleSalary;

    public RoleDTO() {
    }

    public RoleDTO(String name, int roleSalary) {
        this.name = name;
        this.roleSalary = roleSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(int roleSalary) {
        this.roleSalary = roleSalary;
    }
    
    
    
    
}
