/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
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
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author CIKA
 */
public class MemberFormController implements Initializable {
    

    @FXML
    private MenuItem file_close;

    @FXML
    private MenuItem edit_delete;

    @FXML
    private MenuItem help_about;
    
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
    private TableView<Individual> tblMemberIndividu;

    @FXML
    private TableColumn<Individual, Integer> colIDIIndividu;

    @FXML
    private TableColumn<Individual, String> colNamaLengkapIndividu;

    @FXML
    private TableColumn<Individual, Long> colPhoneNumIndividu;

    @FXML
    private TableColumn<Individual, String> colBirthdateIndividu;

    @FXML
    private TableColumn<Individual, String> colExpDateIndividu;

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
    private TableView<ApartementOwner> tblMemberOwner;

    @FXML
    private TableColumn<ApartementOwner, Integer> colIDOwner;

    @FXML
    private TableColumn<ApartementOwner, String> colNameOwner;

    @FXML
    private TableColumn<ApartementOwner, Long> colPhoneNumOwner;

    @FXML
    private TableColumn<ApartementOwner, Integer> colApartmentNumOwner;

    @FXML
    private TableColumn<ApartementOwner, String> colExpDateOwner;

    @FXML
    private Label labelDBStatus;

    @FXML
    private Label labelSetStatusIndividual;

    @FXML
    private Label labelSetStatusOwner;

    MemberDataModel MDM;

    @FXML
    void handleCloseProgram(ActionEvent event) {
        System.exit(0);
    }
    
    @FXML
    void handleClearIndividu(ActionEvent event) {
        try {
            tfIDIndividual.setText("" + MDM.nextMemberID());
        } catch (SQLException ex) {
            Logger.getLogger(MemberDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDate BD = dpBirthdateIndividu.getValue();
        String birthdate = String.format("%d-%02d-%02d", BD.getYear(), BD.getMonthValue(), BD.getDayOfMonth());
        LocalDate EXP = dpExpDateIndividu.getValue();
        String ExpirationDate = String.format("%d-%02d-%02d", EXP.getYear(), EXP.getMonthValue(), EXP.getDayOfMonth());
        tfIDIndividual.setDisable(true);
        tfNamaLengkapIndividu.setText("");
        tfPhoneNumIndividu.setText("");
        labelSetStatusIndividual.setText("");
    }

    @FXML
    void handleClearOwner(ActionEvent event) {
        try {
            tfIDOwner.setText("" + MDM.nextMemberOwnerID());
        } catch (SQLException ex) {
            Logger.getLogger(MemberDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        LocalDate EXP = dpExpDateOwner.getValue();
        String ExpirationDate = String.format("%d-%02d-%02d", EXP.getYear(), EXP.getMonthValue(), EXP.getDayOfMonth());
        tfIDOwner.setDisable(true);
        tfNameOwner.setText("");
        tfPhoneNumOwner.setText("");
        tfApartmentNumOwner.setText("");
        labelSetStatusOwner.setText("");
    }

    @FXML
    void handleReloadIndividu(ActionEvent event) {
        ObservableList<Individual> akun = MDM.getIndividual();
        colIDIIndividu.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaLengkapIndividu.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNumIndividu.setCellValueFactory(new PropertyValueFactory<>("phonenum"));
        colBirthdateIndividu.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        colExpDateIndividu.setCellValueFactory(cellData -> cellData.getValue().membership.expirationDateProperty());
        tblMemberIndividu.setItems(null);
        tblMemberIndividu.setItems(akun);
    }

    @FXML
    void handleReloadOwner(ActionEvent event) {
        ObservableList<ApartementOwner> akun = MDM.getApartementOwner();
        colIDOwner.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameOwner.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneNumOwner.setCellValueFactory(new PropertyValueFactory<>("phonenum"));
        colApartmentNumOwner.setCellValueFactory(new PropertyValueFactory<>("apartementnum"));
        colExpDateOwner.setCellValueFactory(cellData -> cellData.getValue().membership.expirationDateProperty());
        tblMemberOwner.setItems(null);
        tblMemberOwner.setItems(akun);
    }

    @FXML
    void handleSaveIndividu(ActionEvent event) {
        LocalDate BD = dpBirthdateIndividu.getValue();
        String birthdate = String.format("%d-%02d-%02d", BD.getYear(), BD.getMonthValue(), BD.getDayOfMonth());
        LocalDate EXP = dpExpDateIndividu.getValue();
        String ExpirationDate = String.format("%d-%02d-%02d", EXP.getYear(), EXP.getMonthValue(), EXP.getDayOfMonth());
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
    void handleSaveOwner(ActionEvent event) {
        LocalDate EXP = dpExpDateOwner.getValue();
        String ExpirationDate = String.format("%d-%02d-%02d", EXP.getYear(), EXP.getMonthValue(), EXP.getDayOfMonth());
        ApartementOwner member = new ApartementOwner(Integer.parseInt(tfIDOwner.getText()),
                tfNameOwner.getText(),
                Long.parseLong(tfPhoneNumOwner.getText()),
                Integer.parseInt(tfApartmentNumOwner.getText()),
                new Membership(ExpirationDate));
        try {
            MDM.addMember(member);
            labelSetStatusOwner.setText("Berhasil Menambah Member");
            btnReloadOwner.fire();
        } catch (SQLException ex) {
            labelSetStatusOwner.setText("Gagal Menambah Member");
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblMemberIndividu.setEditable(true);
        tblMemberOwner.setEditable(true);
        colExpDateIndividu.setCellFactory(TextFieldTableCell.forTableColumn());
        colExpDateOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        
        
        try {
            MDM = new MemberDataModel();
            labelDBStatus.setText(MDM.conn == null ? "Not Connected" : "Connected");
            tfIDIndividual.setText("" + MDM.nextMemberID());
            dpExpDateIndividu.setValue(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth()));
            dpBirthdateIndividu.setValue(LocalDate.of(LocalDate.now().getYear() - 27, LocalDate.now().getMonthValue(),
                    LocalDate.now().getDayOfMonth()));
            btnReloadIndividu.fire();
        } catch (SQLException ex) {
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tblMemberIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblMemberIndividu.getSelectionModel().getSelectedItem() != null) {
                Individual akun = tblMemberIndividu.getSelectionModel().getSelectedItem();
            }
        });

        try {
            tfIDOwner.setText(""+MDM.nextMemberOwnerID());
            dpExpDateOwner.setValue(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 
                    LocalDate.now().getDayOfMonth()));
            btnReloadOwner.fire();
        } catch (SQLException ex) {
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblMemberOwner.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblMemberOwner.getSelectionModel().getSelectedItem() != null) {
                ApartementOwner akun = tblMemberOwner.getSelectionModel().getSelectedItem();
            }
        });
    }
    public void editExpDate(CellEditEvent eddittedcell) throws SQLException{
        Member memberselected = tblMemberIndividu.getSelectionModel().getSelectedItem();
        memberselected.getMembership().setExpirationDate(eddittedcell.getNewValue().toString());
        MDM.renewMembership(memberselected);
    }
    public void editExpDateOwner(CellEditEvent eddittedcell) throws SQLException{
        Member memberselected = tblMemberOwner.getSelectionModel().getSelectedItem();
        memberselected.getMembership().setExpirationDate(eddittedcell.getNewValue().toString());
        MDM.renewMembership(memberselected);
    }
}
