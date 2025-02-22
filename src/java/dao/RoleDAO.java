/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Role;
import ultils.DBUltils;



/**
 *
 * @author ADMIN
 */
public class RoleDAO implements IDAO<Role,Integer> {

    @Override
    public Role insert(Role entity) {
        String sql = "INSERT INTO ROLE (id, name, roleSalary)" + "VALUES (?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setInt(3, (int) entity.getRoleSalary());
            ps.executeUpdate();
            return entity;
            
        } catch (ClassNotFoundException ex ) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public List<Role> findAll() {
         List<Role> rl = new ArrayList<>();
        String sql = "SELECT * FROM ROLE";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("roleSalary")
                );
                rl.add(role);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rl;
    }

    @Override
    public Role findByID(Integer id) {
        String sql = "SELECT * FROM ROLE WHERE id = ?";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                 return new Role(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("roleSalary")
                    );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Role entity) {
          String sql = "UPDATE ROLE SET "
                + "name = ?, "
                + "roleSalary = ?, "
                + "WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, entity.getName());
            ps.setInt(2, (int) entity.getRoleSalary());
            ps.setInt(3, entity.getId());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
       String sql = "DELETE FROM ROLE WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

}
