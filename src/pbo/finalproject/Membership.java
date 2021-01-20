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
public class Membership {
    private StringProperty expirationDate;

    public Membership(String expirationDate) {
        this.expirationDate = new SimpleStringProperty(expirationDate);
    }

    public String getExpirationDate() {
        return expirationDate.get();
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = new SimpleStringProperty(expirationDate);
    }
    
    public StringProperty expirationDateProperty() {
        return expirationDate;
    } 
    public void renewMembership(String update) {
        this.expirationDate.set(update);
    }
}
