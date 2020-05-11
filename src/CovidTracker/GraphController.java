package CovidTracker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {

    @FXML
    private BorderPane Plane;

    @FXML
    private LineChart<?, ?> Stats_Graph;

    @FXML
    private HBox H_Box;

    @FXML
    private Button Back;

    @FXML
    private Button Exit;

    public static String country;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Stats_Graph.setTitle(country);
        XYChart.Series cases = CountryAPILoader.loadStats(country, "cases");
        XYChart.Series deaths = CountryAPILoader.loadStats(country, "deaths");
        XYChart.Series recovered = CountryAPILoader.loadStats(country, "recovered");
        Stats_Graph.getData().addAll(cases, deaths, recovered);
        Exit.setOnAction(this::exitHandler);
    }

    public static void setCountry(String n_country) { country = n_country; }
    private void exitHandler(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }
}
