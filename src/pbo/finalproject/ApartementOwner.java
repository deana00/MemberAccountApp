/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author CIKA
 */
public class ApartementOwner extends Member {
    IntegerProperty apartementnum;

    public ApartementOwner(int id, String name, long phonenum, int apartementnum, Membership membership) {
        super(id, name, phonenum, membership);
        this.apartementnum = new SimpleIntegerProperty(apartementnum);
    }

    public int getApartementnum(){
        return apartementnum.get();
    }

    public void setApartementnum(int apartementnum) {
        this.apartementnum = new SimpleIntegerProperty(apartementnum);
    }
    
    public IntegerProperty apartementnumProperty() {
        return apartementnum;
    }
}
