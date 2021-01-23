/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author CIKA
 */
public class MemberFormController implements Initializable {
    

    @FXML
    private TextField tfIDIndividual;

    @FXML
    private TextField tfNamaLengkapIndividu;

    @FXML
    private TextField tfPhoneNumIndividu;

    @FXML
    private DatePicker dpExpDateIndividu;

    @FXML
    private Button btnSaveIndividu;

    @FXML
    private Button btnReloadIndividu;

    @FXML
    private Button btnClearFormIndividu;

    @FXML
    private DatePicker dpBirthdateIndividu;

    @FXML
    private TableView<?> tblMemberIndividu;

    @FXML
    private TableColumn<?, ?> colIDIIndividu;

    @FXML
    private TableColumn<?, ?> colNamaLengkapIndividu;

    @FXML
    private TableColumn<?, ?> colPhoneNumIndividu;

    @FXML
    private TableColumn<?, ?> colBirthdateIndividu;

    @FXML
    private TableColumn<?, ?> colExpDateIndividu;

    @FXML
    private TableView<?> tblShowIndividu;

    @FXML
    private TableColumn<?, ?> colShowIDIndividu;

    @FXML
    private TableColumn<?, ?> colShowNamaIndividu;

    @FXML
    private TableColumn<?, ?> colShowExpDateIndividu;

    @FXML
    private TextField tfIDIndividu2;

    @FXML
    private DatePicker dpExpDateIndividu2;

    @FXML
    private Button btnSaveIndividu2;

    @FXML
    private TextField tfIDOwner;

    @FXML
    private TextField tfNameOwner;

    @FXML
    private TextField tfPhoneNumOwner;

    @FXML
    private DatePicker dpExpDateOwner;

    @FXML
    private Button btnSaveOwner;

    @FXML
    private Button btnReloadOwner;

    @FXML
    private Button btnClearOwner;

    @FXML
    private TextField tfApartmentNumOwner;

    @FXML
    private TableView<?> tblMemberOwner;

    @FXML
    private TableColumn<?, ?> colIDOwner;

    @FXML
    private TableColumn<?, ?> colNameOwner;

    @FXML
    private TableColumn<?, ?> colPhoneNumOwner;

    @FXML
    private TableColumn<?, ?> colApartmentNumOwner;

    @FXML
    private TableColumn<?, ?> colExpDateOwner;

    @FXML
    private TableView<?> tblShowOwner;

    @FXML
    private TableColumn<?, ?> colShowIDOwner;

    @FXML
    private TableColumn<?, ?> colShowNameOwner2;

    @FXML
    private TableColumn<?, ?> tblShowExpDateOwner2;

    @FXML
    private TextField tfIDOwner2;

    @FXML
    private DatePicker dpExpDateOwner2;

    @FXML
    private Button btnSaveOwner2;

    @FXML
    private Label labelDBStatus;
    
    @FXML
    private Label labelSetStatusIndividual;

    MemberDataModel MDM;
    
    @FXML
    void handleClearIndividu(ActionEvent event) {

    }

    @FXML
    void handleClearOwner(ActionEvent event) {

    }

    @FXML
    void handleReloadIndividu(ActionEvent event) {
//        ObservableList<Individual> data = MDM.getIndividual();
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("holderID"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
//        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));
//        bdColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
//        numAccColumn.setCellValueFactory(new PropertyValueFactory<>("numAccounts"));
//        tblAccountHolder.setItems(null);
//        tblAccountHolder.setItems(data);
//        btnAddAccount.setDisable(true);
    }

    @FXML
    void handleReloadOwner(ActionEvent event) {

    }

    @FXML
    void handleSaveIndividu(ActionEvent event) {
        LocalDate BD = dpBirthdateIndividu.getValue();
        String birthdate = String.format("%d-%02d-%02d", BD.getYear(),BD.getMonthValue(),BD.getDayOfMonth());
        LocalDate EXP = dpExpDateIndividu.getValue();
        String ExpirationDate = String.format("%d-%02d-%02d", EXP.getYear(),EXP.getMonthValue(),EXP.getDayOfMonth());
        Individual member = new Individual(Integer.parseInt(tfIDIndividual.getText()),
                tfNamaLengkapIndividu.getText(), 
                Long.parseLong(tfPhoneNumIndividu.getText()),
                birthdate,
                new Membership(ExpirationDate));
        try {
            MDM.addMember(member);
            labelSetStatusIndividual.setText("Berhasil Menambah Member");
            btnReloadIndividu.fire();
        } catch (SQLException ex) {
            labelSetStatusIndividual.setText("Gagal Menambah Member");
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void handleSaveIndividu2(ActionEvent event) {

    }

    @FXML
    void handleSaveOwner(ActionEvent event) {

    }

    @FXML
    void handleSaveOwner2(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            MDM = new MemberDataModel();
            labelDBStatus.setText(MDM.conn==null?"Not Connected":"Connected");
            tfIDIndividual.setText(""+MDM.nextMemberID());
            dpExpDateIndividu.setValue(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 
                    LocalDate.now().getDayOfMonth()));
            dpBirthdateIndividu.setValue(LocalDate.of(LocalDate.now().getYear()-27, LocalDate.now().getMonthValue(), 
                    LocalDate.now().getDayOfMonth()));
        } catch (SQLException ex) {
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
