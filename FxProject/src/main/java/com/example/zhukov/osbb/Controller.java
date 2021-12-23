package com.example.zhukov.osbb;


import com.example.zhukov.osbb.core.org.condominiums.model.House;
import com.example.zhukov.osbb.core.org.condominiums.model.Inhabitant;
import com.example.zhukov.osbb.core.org.condominiums.service.CondominiumsService;
import com.example.zhukov.osbb.core.org.condominiums.util.CondominiumsUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EnterButton;

    @FXML
    private Label Text2Field;

    @FXML
    private Button ExitButton;

    @FXML
    private Label Text1Filed;

    @FXML
    private Button OtherButtonsButton;

    @FXML
    private AnchorPane AnchorPaneMain;

    @FXML
    private PasswordField ps_field;

    @FXML
    private Button RegButton;
    @FXML
    private Button Addinh;
    @FXML
    private Button BackButton;

    @FXML
    private TextField LoginFiled;
    private Stage stage;

    @FXML
    private Button RegEnter1;

    @FXML
    private Button Add_balance;

    @FXML
    private Button dell;
    @FXML
    private Button inh_list_button;

    @FXML
    private TextField deleteId;

    @FXML
    private TextField addBalanceId;

    @FXML
    private TextField addBalanceValue;

    @FXML
    private TextField addId;

    @FXML
    private TextField addName;

    @FXML
    private TextField addLastName;

    @FXML
    private TextField addBalance;

    @FXML
    private TextField addAge;

    @FXML
    private TextArea list;

    private static House house = new House();

    static {
        CondominiumsUtil.fillHouse(house, 20);
    }


    private static CondominiumsService condominiumsService = new CondominiumsService(house);

    @FXML
    private void first_handleButtonAction(ActionEvent event) throws IOException {
        //Close current
        Stage stage = (Stage) EnterButton.getScene().getWindow();
        // do what you have to do
        stage.close();
        String check = ps_field.getText().toString();
        String check_tf = LoginFiled.getId();

        boolean circle = false;
        switch (ps_field.getText()) {
            case ("admin"):
                switch (LoginFiled.getText()) {
                    case ("admin"):
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.setTitle("Menu");
                        stage.setScene(new Scene(root1));
                        stage.setResizable(false);
                        stage.show();
                        break;
                    default:
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Wrong password/login");
                        alert.setHeaderText("You have entered wrond password/login");
                        alert.showAndWait();
                        FXMLLoader fxmlLoader_2 = new FXMLLoader(Controller.class.getResource("hello-view.fxml"));
                        Scene scene = new Scene(fxmlLoader_2.load(), 325, 410);
                        stage.setTitle("OSBB");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                        break;
                }
                break;

            default:

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong password/login");
                alert.setHeaderText("You have entered wrond password/login");
                alert.showAndWait();
                FXMLLoader fxmlLoader_2 = new FXMLLoader(Controller.class.getResource("hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader_2.load(), 325, 410);
                stage.setTitle("OSBB");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
                break;
        }


    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void second_handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) RegButton.getScene().getWindow();
        // do what you have to do
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registration.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();

    }

    @FXML
    private void third_handleButtonAction(ActionEvent event) throws IOException {
        long id = Long.parseLong(addId.getText());
        String name = addName.getText();
        String lastName = addLastName.getText();
        double balance = Double.parseDouble(addBalance.getText());
        int age = Integer.parseInt(addAge.getText());
        condominiumsService.addInhabitant(new Inhabitant(id, name, lastName, false, balance, age));
        Stage stage = (Stage) RegEnter1.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registration");
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void back_handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("OSBB");
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void open_addinh(ActionEvent event) throws IOException {
        Stage stage = (Stage) Addinh.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void open_addbalance(ActionEvent event) throws IOException {
        Stage stage = (Stage) Add_balance.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addBalance.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    private void open_dell(ActionEvent event) throws IOException {
        Stage stage = (Stage) dell.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Delete.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();

    }


    @FXML
    private void open_showlist(ActionEvent event) throws IOException {
        Stage stage = (Stage) inh_list_button.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ShotList.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();

    }


    @FXML
    private void addBalance() throws IOException {
        long id = Long.parseLong(addBalanceId.getText());
        long sum = Long.parseLong(addBalanceValue.getText());
        condominiumsService.addBalance(id, sum);
        exitBalance();
    }

    @FXML
    private void showList() {
        list.setText("id name lastname registration balance age\n" + condominiumsService.getListInhabitant().stream().map(Inhabitant::toString).collect(Collectors.joining("\n")));
    }


    @FXML
    private void exitList() throws IOException {
        Stage stage = (Stage) list.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void exitBalance() throws IOException {
        Stage stage = (Stage) addBalanceValue.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    void openVideo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vpk.fxml"));
        Scene scene = new Scene(root, 730, 600);
        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setTitle("Video Player");
        //Image icon = new Image("/Users/Роман/IdeaProjects/Addressbook/src/main/resources/com/example/addressbook/icon2.pg");
        //stage.getIcons().add(icon);
        //stage.setResizable(false);

        stage.setScene(scene);

        stage.show();

    }
}












