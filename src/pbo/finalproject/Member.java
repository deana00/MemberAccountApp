/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author CIKA
 */
public class Member {
     private IntegerProperty id;
     private StringProperty name;
     private IntegerProperty phonenum;

    public Member(int id, String name, int phonenum) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.phonenum = new SimpleIntegerProperty(phonenum);
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

    public int getPhonenum() {
        return phonenum.get();
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = new SimpleIntegerProperty(phonenum);
    }
     
    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public IntegerProperty phonenumProperty() {
        return phonenum;
    }
}
