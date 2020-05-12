package CovidTracker;

public class LinkAPI {

    private String worldAPI = "https://corona.lmao.ninja/v2/countries?yesterday&sort";
    private String countryAPI_1 = "https://corona.lmao.ninja/v2/historical/";
    private String countryAPI_2 = "?lastdays=60";

    private static LinkAPI instance;

    public static LinkAPI getInstance() {
        if (instance == null) {
            instance = new LinkAPI();
        }return instance;
    }

    public String getWorldAPI() {
        return worldAPI;
    }

    public String getCountryAPI_1() {
        return countryAPI_1;
    }

    public String getCountryAPI_2() {
        return countryAPI_2;
    }
}
