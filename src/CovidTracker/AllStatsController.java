package CovidTracker;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.*;


public class AllStatsController<Icon> implements Initializable {

    @FXML
    private TableView<Country> StatsTable;

    @FXML
    private TableColumn<?, ?> CountryName;

    @FXML
    private TableColumn<?, ?> Infected;

    @FXML
    private TableColumn<?, ?> TodayInfected;

    @FXML
    private TableColumn<?, ?> Death;

    @FXML
    private TableColumn<?, ?> TodayDeath;

    @FXML
    private TableColumn<?, ?> Hospitalized;

    @FXML
    private TableColumn<?, ?> Recovered;

    @FXML
    private TableColumn<?, ?> MoreInfo;

    @FXML
    private Button Exit;

    private ObservableList<Country> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WorldAPILoader worldAPILoader = new WorldAPILoader();
        data = worldAPILoader.getCountry();
        StatsTable.setItems(data);
        Recovered.setCellValueFactory(new PropertyValueFactory<>("recovered"));
        Infected.setCellValueFactory(new PropertyValueFactory<>("infected"));
        CountryName.setCellValueFactory(new PropertyValueFactory<>("country"));
        Death.setCellValueFactory(new PropertyValueFactory<>("death"));
        Hospitalized.setCellValueFactory(new PropertyValueFactory<>("hospitalize"));
        TodayDeath.setCellValueFactory(new PropertyValueFactory<>("todayDeath"));
        TodayInfected.setCellValueFactory(new PropertyValueFactory<>("todayInfected"));
        MoreInfo.setCellValueFactory(new PropertyValueFactory<>("button"));
        Exit.setOnAction(this::exitHandler);
    }

    private void exitHandler(ActionEvent event) {
        Platform.exit();
    }

}

