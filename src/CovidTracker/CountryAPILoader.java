package CovidTracker;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import javafx.scene.chart.XYChart;
import com.google.gson.Gson;


import java.util.LinkedHashMap;
import java.util.Map;

public class CountryAPILoader {

    public static XYChart.Series loadStats(String country, String category) {
        String url = "https://corona.lmao.ninja/v2/historical/" + country + "?lastdays=60";
        Map stats = APILoader.apiRequestMap(url);
        LinkedHashMap timeline = (LinkedHashMap) stats.get("timeline");
        LinkedHashMap innerStats = (LinkedHashMap) timeline.get(category);
        XYChart.Series series = new XYChart.Series();
        series.setName(category.toUpperCase());
        for (Object date : innerStats.keySet()) {
            series.getData().add(new XYChart.Data(date, innerStats.get(date)));
//            System.out.println("Date : " + date + "Status : " + innerStats.get(date) );
        }
        return series;
    }

}
