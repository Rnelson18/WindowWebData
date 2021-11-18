package bsu.comp152.example.windowwebdata;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

public class UniDisplayController implements Initializable {
    @FXML
    private TextField NameField;
    @FXML
    private TextField UniversityCountryField;
    @FXML
    private TextField websiteDisplayField;
    @FXML
    private ListView<DataHandler.UniversityDataType> ListControl;
    private DataHandler Model;

    public void loadData(){
        var site = "http://universities.hipolabs.com/search?name=";
        String param = getQueryParam();
        var wholeSite = site+param;
        Model = new DataHandler(wholeSite);
        var universities = Model.getData();
        ObservableList<DataHandler.UniversityDataType> UnivList =
                FXCollections.observableArrayList(universities);
        ListControl.setItems(UnivList);

    }

    private String getQueryParam() {
        var inputDialog = new TextInputDialog("Young");
        inputDialog.setContentText("What University should we Search For");
        inputDialog.setHeaderText("Gathering Information");
        var response = inputDialog.showAndWait();
        if(response.isEmpty()){
            return "";
        }
        else {
            return response.get();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData();
        ListControl.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<DataHandler.UniversityDataType>() {
                    @Override
                    public void changed(ObservableValue<? extends DataHandler.UniversityDataType> observableValue, DataHandler.UniversityDataType universityDataType, DataHandler.UniversityDataType t1) {
                        NameField.setText(t1.name);
                        UniversityCountryField.setText(t1.country);
                        websiteDisplayField.setText((t1.web_pages.toString()));
                    }

                });
    }
}