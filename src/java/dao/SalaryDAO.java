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
import model.Salary;
import ultils.DBUltils;

/**
 *
 * @author ADMIN
 */
public class SalaryDAO implements IDAO<Salary, Integer>{

    @Override
    public Salary insert(Salary entity) {
        String sql = "INSERT INTO SALARY (id, totaltime, month, year, employeeId)" + "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getTotaltime());
            ps.setInt(3, entity.getMonth());
            ps.setInt(4, entity.getYear());
            ps.setInt(5, entity.getEmployeeId());
            ps.executeUpdate();
            return entity;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }

    @Override
    public List<Salary> findAll() {
      List<Salary> salary = new ArrayList<>();
      String sql = "SELECT * FROM SALARY";
      try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Salary sl = new Salary(
                        rs.getInt("id"),
                        rs.getInt("totalTime"),
                        rs.getInt("month"),
                        rs.getInt("year"),
                        rs.getInt("employeeId")
                );
                salary.add(sl);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return salary;
    }

    @Override
    public Salary findByID(Integer id) {
        String sql = "SELECT * FROM SALARY WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 rs.getInt("id");
                 rs.getInt("totalTime");
                 rs.getInt("month");
                 rs.getInt("year");
                 rs.getInt("employeeId");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Salary entity) {
      String sql = "UPDATE SALARY SET"
                + "totalTime = ?, "
                + "month = ?, "
                + "year = ?,"
                + "employeeId = ?,"
                + "WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getTotaltime());
            ps.setInt(2, entity.getMonth());
            ps.setInt(3, entity.getYear());
            ps.setInt(4, entity.getEmployeeId());
            ps.setInt(5, entity.getId());
             int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM SALARY WHERE id = ?";
         try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
}
