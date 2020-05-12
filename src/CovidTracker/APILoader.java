package CovidTracker;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

/**
 * APILoader is class that contain methods be used in api loading from the internet.
 * @author Pittayut Benjamasutin.
 */
public class APILoader {

    /**
     * Method request stats from api URL.
     * @param api_url is api URL from database.
     * @return  ArrayList<Map> contains map of data.
     */
    public ArrayList<Map> apiRequestList(String api_url) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(api_url);
            ArrayList<Map> stats = mapper.readValue(url,ArrayList.class);
            return stats;
        }catch (IOException e) { System.out.println(e.getMessage()); }
        return null;
    }

    /**
     * Method request stats from api URL.
     * @param api_url is api URL from database.
     * @return  Map<String, Object> contains stat.
     */
    public Map<String, Object> apiRequestMap(String api_url) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            URL url = new URL(api_url);
            Map stats = mapper.readValue(url, Map.class);
            return stats;
        }catch (IOException e) { System.out.println(e.getMessage()); }
        return null;
    }
}
