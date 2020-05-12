package CovidTracker;

import javafx.scene.chart.XYChart;


import java.util.*;

public class CountryAPILoader {

    public XYChart.Series loadStats(String country, String category) {
        String url = LinkAPI.getInstance().getCountryAPI_1() + country + LinkAPI.getInstance().getCountryAPI_2();
        APILoader apiLoader = new APILoader();
        Map stats = apiLoader.apiRequestMap(url);
        LinkedHashMap timeline = (LinkedHashMap) stats.get("timeline");
        LinkedHashMap innerStats = (LinkedHashMap) timeline.get(category);
        XYChart.Series series = new XYChart.Series();
        series.setName(category.toUpperCase());
        for (Object date : innerStats.keySet()) {
            series.getData().add(new XYChart.Data(date, innerStats.get(date)));
        }
        return series;
    }

}
