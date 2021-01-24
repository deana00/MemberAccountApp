/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author CIKA
 */
public abstract class Member {
     private IntegerProperty id;
     private StringProperty name;
     private LongProperty phonenum;
     Membership membership;

    public Member(int id, String name, long phonenum, Membership membership) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.phonenum = new SimpleLongProperty(phonenum);
        this.membership = membership;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public long getPhonenum() {
        return phonenum.get();
    }

    public void setPhonenum(long phonenum) {
        this.phonenum = new SimpleLongProperty(phonenum);
    }
     
    public void setMembership(Membership membership){
        this.membership = membership;
    }
    
    public Membership getMembership(){
        return membership;
    }
     
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public LongProperty phonenumProperty() {
        return phonenum;
    }
}
