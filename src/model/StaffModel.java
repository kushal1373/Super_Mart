/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class StaffModel {
    String  staffname, position, gender;
    int staffid;
    public StaffModel(int staffid, String staffname, String position, String gender)
    {
        this.staffid=staffid;
        this.staffname =staffname;
        this.position=position;  
        this.gender= gender;
    } 

    public int getstaffid() {
        return staffid;
    }

    public void setstaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getstaffname() {
        return staffname;
    }

    public void setstaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getposition() {
        return position;
    }

    public void setposition(String position) {
        this.position = position;
    }
    
    public String getgender() {
        return gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }
}
