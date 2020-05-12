package TrackerApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Pittayut Benjamsutin.
 */
public class GraphController implements Initializable {

    @FXML
    private BorderPane Plane;

    @FXML
    private AreaChart<?, ?> Stats_Graph;

    @FXML
    private HBox H_Box;

    @FXML
    private Button Back;

    @FXML
    private Button Exit;

    public static String country;


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Stats_Graph.setTitle(country);
        CountryAPILoader countryAPILoader = new CountryAPILoader();
        XYChart.Series cases = countryAPILoader.loadStats(country, "cases");
        XYChart.Series deaths = countryAPILoader.loadStats(country, "deaths");
        XYChart.Series recovered = countryAPILoader.loadStats(country, "recovered");
        Stats_Graph.getData().addAll(cases, deaths, recovered);
        Exit.setOnAction(this::exitHandler);
    }

    public static void setCountry(String n_country) { country = n_country; }
    private void exitHandler(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

}
