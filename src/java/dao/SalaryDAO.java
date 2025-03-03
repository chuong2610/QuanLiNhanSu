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
import java.time.YearMonth;
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
    
    public Salary findByMonthAndEmployeeId(YearMonth month, int id){
        String sql = "SELECT * FROM SALARY WHERE month=? and year = ? and employeeId=?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, month.getMonthValue());
            ps.setInt(2, month.getYear());
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 rs.getInt("id");
                 rs.getInt("totalSalary");
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
    public int insert(Salary entity) {
        String sql = "INSERT INTO SALARY (id, totalSalary, month, year, employeeId)" + "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getTotalSalary());
            ps.setInt(3, entity.getMonth());
            ps.setInt(4, entity.getYear());
            ps.setInt(5, entity.getEmployeeId());
            int rs=ps.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
           
        } catch (SQLException ex) {
            Logger.getLogger(SalaryDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return 0;
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
                        rs.getInt("totalSalary"),
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
                 rs.getInt("totalSalary");
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
                + "totalSalary = ?, "
                + "month = ?, "
                + "year = ?,"
                + "employeeId = ?,"
                + "WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getTotalSalary());
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
    
     public boolean deleteByEmployeeId(Integer id) {
        String sql = "DELETE FROM SALARY WHERE employeeId = ?";
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
