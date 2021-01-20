/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author CIKA
 */
public class Individual extends Member {
    StringProperty birthdate;

    public Individual(int id, String name, int phonenum, String birthdate, Membership membership) {
        super(id, name, phonenum, membership);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = new SimpleStringProperty(birthdate);
    }
    
    public StringProperty birthdateProperty() {
        return birthdate;
    }
}
