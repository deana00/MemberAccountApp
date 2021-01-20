/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo.finalproject;

import java.net.URL;
import java.util.ResourceBundle;
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
    void handleClearIndividu(ActionEvent event) {

    }

    @FXML
    void handleClearOwner(ActionEvent event) {

    }

    @FXML
    void handleReloadIndividu(ActionEvent event) {

    }

    @FXML
    void handleReloadOwner(ActionEvent event) {

    }

    @FXML
    void handleSaveIndividu(ActionEvent event) {

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
        // TODO
    }    
    
}
