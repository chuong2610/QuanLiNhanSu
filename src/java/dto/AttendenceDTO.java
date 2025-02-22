/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDateTime;

/**
 *
 * @author ADMIN
 */
public class AttendenceDTO {
     private LocalDateTime timeCheckIn;
    private LocalDateTime timeCheckOut;
    private int employeeId;

    public AttendenceDTO() {
    }

    public AttendenceDTO(LocalDateTime timeCheckIn, LocalDateTime timeCheckOut, int employeeId) {
        this.timeCheckIn = timeCheckIn;
        this.timeCheckOut = timeCheckOut;
        this.employeeId = employeeId;
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
