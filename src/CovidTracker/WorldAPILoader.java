package CovidTracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Map;

public class WorldAPILoader {

    public ObservableList<Country> getCountry() {
        ObservableList<Country> countries = FXCollections.observableArrayList();
        APILoader apiLoader = new APILoader();
        ArrayList<Map> stats = apiLoader.apiRequestList(LinkAPI.getInstance().getWorldAPI());
        for (Map country : stats) {
            countries.add(new Country((int) country.get("cases"), (int) country.get("todayCases"), (int) country.get("deaths"),(int) country.get("todayDeaths"),(int) country.get("recovered"),(int) country.get("active"), country.get("country").toString()));
        }
        return countries;
    }

}
