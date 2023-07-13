/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class forgetmodel {
    String username,newpassword,confirmpassword;
    
    public forgetmodel(String username, String newpassword, String confirmpassword)
    {
        this.username=username;
        this.newpassword=newpassword;
        this.confirmpassword=confirmpassword;
       
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getnewPassword() {
        return newpassword;
    }

    public void setnewPassword(String newpassword) {
        this.newpassword = newpassword;
    }
    
   
}
