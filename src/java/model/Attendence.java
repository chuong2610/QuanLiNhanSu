/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class Attendence {
    private int id;
    private float totalTime;
    private LocalDateTime timeCheckIn;
    private LocalDateTime timeCheckOut;
    private int employeeId;

    public Attendence() {
    }

    public Attendence(int id, float totalTime, LocalDateTime timeCheckIn, LocalDateTime timeCheckOut, int employeeId) {
        this.id = id;
        this.totalTime = totalTime;
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
        this.employeeId = employeeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(float totalTime) {
        this.totalTime = totalTime;
    }

    public LocalDateTime getTimeCheckIn() {
        return timeCheckIn;
    }

    public void setTimeCheckIn(LocalDateTime timeCheckIn) {
        this.timeCheckIn = timeCheckIn;
    }

    public LocalDateTime getTimeCheckOut() {
        return timeCheckOut;
    }

    public void setTimeCheckOut(LocalDateTime timeCheckOut) {
        this.timeCheckOut = timeCheckOut;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    
}
