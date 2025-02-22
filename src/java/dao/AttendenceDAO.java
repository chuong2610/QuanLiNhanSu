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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory.Result;
import model.Attendence;
import model.Employee;
import ultils.DBUltils;

/**
 *
 * @author tranm
 */
public class AttendenceDAO implements IDAO<Attendence, Integer>{

    @Override
    public Attendence insert(Attendence entity) {
        String sql = "INSERT INTO ATTENDNECE(id, totalTime, timeCheckIn, timeCheckOut, employeeId )" 
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setInt(2, (int) entity.getTotalTime());
            ps.setObject(3, entity.getTimeCheckIn());
            ps.setObject(4, entity.getTimeCheckOut());
            ps.setInt(5, entity.getEmployeeId());
            ps.executeUpdate();
            return entity;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
            return entity;
        } catch (SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }

    @Override
    public List<Attendence> findAll() {
      List<Attendence> attendence = new ArrayList<>();
      String sql = "SELECT * FROM ATTENDENCE";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs =  ps.executeQuery();
             while (rs.next()) {
                Attendence att = new Attendence(
                    rs.getInt("id"),
                    rs.getInt("totalTime"), 
                    rs.getObject("timeCheckIn", LocalDateTime.class), 
                    rs.getObject("timeCheckOut", LocalDateTime.class),
                    rs.getInt("employeeId")
                );
                attendence.add(att);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Attendence findByID(Integer id) {
        String sql = "SELECT * FROM ATTENDENCE WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                return new Attendence(
                    rs.getInt("id"),
                    rs.getInt("totalTime"), 
                    rs.getObject("timeCheckIn", LocalDateTime.class), 
                    rs.getObject("timeCheckOut", LocalDateTime.class),
                    rs.getInt("employeeId")
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(Attendence entity) {
         String sql = "UPDATE ATTENDENCE SET "
                + "totalTime = ?, "
                + "timeCheckIn = ?, "
                + "timeCheckOut = ?,"
                + "employeeId = ?,"
                + "WHERE id = ?";
          try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (int) entity.getTotalTime());
            ps.setObject(2, entity.getTimeCheckIn());
            ps.setObject(3, entity.getTimeCheckOut());
            ps.setInt(4, entity.getEmployeeId());
            ps.setInt(5, entity.getId());
            int n = ps.executeUpdate();
            return n > 0;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
         String sql = "DELETE FROM ATTENDENCE WHERE id = ?";
        try {
            Connection conn = DBUltils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int n = ps.executeUpdate();
            return n > 0;
            
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AttendenceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
}