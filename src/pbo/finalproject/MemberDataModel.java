/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import pbo.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MemberDataModel {
    public final Connection conn;

    public MemberDataModel() throws SQLException {
        this.conn = DBConnection.getConnection();
    }
    public void addMember(Individual holder) throws SQLException{
        String insertMember = "INSERT INTO member (id, name, phonenum)"
                + " VALUES (?,?,?)";
        String insertIndividual = "INSERT INTO individual (id, birthdate)"
                + " VALUES (?,?)";
        String insertMembership = "INSERT INTO membership (id, expiration_date)"
                + " VALUES (?,?)";
        PreparedStatement stmtMember = conn.prepareStatement(insertMember);
        stmtMember.setInt(1, holder.getId());
        stmtMember.setString(2, holder.getName());
        stmtMember.setLong(3, holder.getPhonenum());
        stmtMember.execute();
        
        PreparedStatement stmtIndividual = conn.prepareStatement(insertIndividual);
        stmtIndividual.setInt(1, holder.getId());
        stmtIndividual.setString(2, holder.getBirthdate());
        stmtIndividual.execute();
        
        PreparedStatement stmtMembership = conn.prepareStatement(insertMembership);
        stmtMembership.setInt(1, holder.getId());
        stmtMembership.setString(2, holder.getMembership().getExpirationDate());
        stmtMembership.execute();
    }
    
    public void addMember(ApartementOwner holder) throws SQLException{
        String insertMember = "INSERT INTO Member (id, name, phonenum)"
                + " VALUES (?,?,?)";
        String insertApartementOwner = "INSERT INTO apartement_owner (id, apartement_num)"
                + " VALUES (?,?)";
        String insertMembership = "INSERT INTO membership (id, expiration_date)"
                + " VALUES (?,?)";
        PreparedStatement stmtMember = conn.prepareStatement(insertMember);
        stmtMember.setInt(1, holder.getId());
        stmtMember.setString(2, holder.getName());
        stmtMember.setLong(3, holder.getPhonenum());
        stmtMember.execute();
        
        PreparedStatement stmtIndividual = conn.prepareStatement(insertApartementOwner);
        stmtIndividual.setInt(1, holder.getId());
        stmtIndividual.setInt(2, holder.getApartementnum());
        stmtIndividual.execute();
        
        PreparedStatement stmtMembership = conn.prepareStatement(insertMembership);
        stmtMembership.setInt(1, holder.getId());
        stmtMembership.setString(2, holder.getMembership().getExpirationDate());
        stmtMembership.execute();
    }
    
    public ObservableList <Individual> getIndividual() {
        ObservableList <Individual> akun = FXCollections.observableArrayList();
        String sqlCommand = "SELECT id, name, phonenum, birthdate "
                + "FROM member NATURAL JOIN individual "
                + "ORDER BY id";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sqlCommand);
            while (rs.next()) {
                String sqlmembership = "SELECT id, expiration_date "
                        + "FROM membership "
                        + "WHERE id=" + rs.getInt(1);

                ResultSet rsMembership = conn.createStatement().executeQuery(sqlmembership);
                Membership memberships = new Membership(rsMembership.getString(2));
                akun.add(new Individual(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), memberships));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return akun;
    }
    
    public ObservableList <ApartementOwner> getApartementOwner() {
        ObservableList <ApartementOwner> akun = FXCollections.observableArrayList();
        String sqlCommand = "SELECT id, name, phonenum, apartement_num "
                + "FROM member NATURAL JOIN apartement_owner "
                + "ORDER BY id";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sqlCommand);
            while (rs.next()) {
                String sqlmembership = "SELECT id, expiration_date "
                        + "FROM membership "
                        + "WHERE id=" + rs.getInt(1);

                ResultSet rsMembership = conn.createStatement().executeQuery(sqlmembership);
                Membership memberships = new Membership(rsMembership.getString(2));
                akun.add(new ApartementOwner(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getInt(4), memberships));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return akun;
    }
    
    public void renewMembership(Member holder) throws SQLException {
        String updateExpDate = "UPDATE membership SET expiration_date = ?"
                + " WHERE id = ? ";
        
        PreparedStatement stmtRenew = conn.prepareStatement(updateExpDate);
        stmtRenew.setString(1, holder.membership.getExpirationDate());
        stmtRenew.setInt(2, holder.getId());
        stmtRenew.execute();
    }
//    public ObservableList<Membership> getMemberships(int holderID){
//        ObservableList<Membership> data = FXCollections.observableArrayList();
//        String sql="SELECT `acc_number`, `balance` "
//                + "FROM `membership` "
//                + "WHERE id="+holderID;
//        try {
//            ResultSet rs = conn.createStatement().executeQuery(sql);
//            while (rs.next()){
//                data.add(new Membership(rs.getString(1)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(MemberDataModel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return data;
//    }
    
    public int nextMemberID() throws SQLException{
        String sql = "SELECT MAX(id) from individual";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?10001:rs.getInt(1)+1;
            }
        return 10001;
    }
    
    public int nextMemberOwnerID() throws SQLException{
        String sql = "SELECT MAX(id) from member";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?20001:rs.getInt(1)+1;
            }
        return 20001;
    }
//    public int nextMembershipNumber(int holderID) throws SQLException{
//        String sql="SELECT MAX(acc_number) FROM membership WHERE id="+holderID;
//        ResultSet rs = conn.createStatement().executeQuery(sql);
//        while (rs.next()){
//                return rs.getInt(1)+1;
//            }
//        return 0;
//    }
//    
//    public void addMembership(int holderID, Membership acc) throws SQLException{
//        String insertMember = "INSERT INTO membership (id, acc_number, balance)"
//                + " VALUES (?,?,?)";
//  
//        PreparedStatement stmtMember = conn.prepareStatement(insertMember);
//        stmtMember.setInt(1, holderID);
//        stmtMember.setString(2, acc.getExpirationDate());
//        stmtMember.execute();
//        
//    }
}
