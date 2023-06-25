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
    String  staffname, position;
    int staffid;
    public StaffModel(int staffid, String staffname, String position)
    {
        this.staffid=staffid;
        this.staffname =staffname;
        this.position=position;  
    } 

    public int getCategoryId() {
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
}
