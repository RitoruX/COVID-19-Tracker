package CovidTracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Map;

import static CovidTracker.APILoader.apiRequestList;

public class WorldAPILoader {

    public static ObservableList<Country> getCountry() {
        ObservableList<Country> countries = FXCollections.observableArrayList();
        ArrayList<Map> stats = apiRequestList("https://corona.lmao.ninja/v2/countries?yesterday&sort");
        for (Map country : stats) {
            countries.add(new Country((int) country.get("cases"), (int) country.get("todayCases"), (int) country.get("deaths"),(int) country.get("todayDeaths"),(int) country.get("recovered"),(int) country.get("active"), country.get("country").toString()));
        }
        return countries;
    }

}
