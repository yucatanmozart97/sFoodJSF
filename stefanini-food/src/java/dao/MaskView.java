/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author ymcassandri
 */
@Named
@RequestScoped
public class MaskView {
    
    private String date;
    private String phone;
    
    public String getDate(){
    return date;
    }
    
    public void setDate(String date){
    this.date = date;
    }
    
    public String getPhone(){
    return phone;
    }
    
    public void setPhone(String phone) {
    this.phone = phone;
    }
}
