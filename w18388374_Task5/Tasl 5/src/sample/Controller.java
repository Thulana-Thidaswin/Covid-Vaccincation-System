package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {
    String varFName=" ";
    String varSName=" ";
    int varAge=0;
    String varCity=" ";
    String varNIC=" ";
    String varVtype=" ";
    String time=" ";
    @FXML
    private TextField firstName;
    @FXML
    private TextField secondName;
    @FXML
    private TextField age;
    @FXML
    private TextField city;
    @FXML
    private TextField NIC;
    @FXML
    private SplitMenuButton vType;

    @FXML
    public void AstraZeneca(ActionEvent A){
        varVtype="AstraZeneca";
        vType.setText(varVtype);
    }
    @FXML
    public void Sinopharm(ActionEvent S){
        varVtype="Sinopharm";
        vType.setText(varVtype);
    }
    @FXML
    public void Pfizer(ActionEvent P){
        varVtype="Pfizer";
        vType.setText(varVtype);
    }


    @FXML
    public void generateR(ActionEvent e ) throws IOException {
        Node node=(Node) e.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Scene scene= stage.getScene();
        time=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        varFName=firstName.getText();
        varSName=secondName.getText();
        try {
            varAge = Integer.parseInt(age.getText());
        }catch(NumberFormatException F ){
            System.out.println("Enter a Number");
            return;
        }
        varCity=city.getText();
        varNIC=NIC.getText();
        if (varVtype.equals(" ")){
            System.out.println("Please Enter a Vaccine type");
            return;
        }

        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("outputGUI.fxml"));
        Parent loader=(Parent) fxmlLoader.load();

        Label pname =(Label) loader.lookup("#flabel");
        pname.setText(varFName);
        Label pSname =(Label) loader.lookup("#slabel");
        pSname.setText(varSName);
        Label pAge =(Label) loader.lookup("#alabel");
        pAge.setText(String.valueOf(varAge));
        Label pCity =(Label) loader.lookup("#clabel");
        pCity.setText(varCity);
        Label pVtype =(Label) loader.lookup("#vTlabel");
        pVtype.setText(varVtype);
        Label pNIC =(Label) loader.lookup("#nlabel");
        pNIC.setText(varNIC);
        Label pTime=(Label) loader.lookup(("#tlabel"));
        pTime.setText(time);

        stage.setTitle("Your receipt Sir ");

        stage.setScene(new Scene(loader,600,400));
        stage.show();



    }
}
