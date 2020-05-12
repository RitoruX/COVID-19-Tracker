package CovidTracker;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Country class that contain infected ,death ,recovered and today stats.
 * @author Pittayut Benjamasutin
 */
public class Country {

    private final SimpleIntegerProperty recovered, hospitalize, infected, death, todayInfected, todayDeath;
    private final SimpleStringProperty country;
    private Button button;

    public Country(int infected, int todayInfected, int death, int todayDeath, int recovered, int hospitalize, String country) {
        this.infected = new SimpleIntegerProperty(infected);
        this.death = new SimpleIntegerProperty(death);
        this.todayDeath = new SimpleIntegerProperty(todayDeath);
        this.todayInfected = new SimpleIntegerProperty(todayInfected);
        this.recovered = new SimpleIntegerProperty(recovered);
        this.hospitalize = new SimpleIntegerProperty(hospitalize);
        this.country = new SimpleStringProperty(country);
        this.button = new Button("More Info.");

        button.setOnAction(event -> {{
            try {
                GraphController.setCountry(this.getCountry());
                CovidTracker moreInfoScene = new CovidTracker();
                Stage stage = new Stage();
                moreInfoScene.setFXML("graph_ui.fxml");
                stage.setTitle(this.getCountry() + " Historical.");
                moreInfoScene.start(stage);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        });

    }

    public int getRecovered() { return recovered.get(); }
    public void setRecovered(int amount) { recovered.set(amount); }


    public int getHospitalize() { return hospitalize.get(); }
    public void setHospitalize(int amount) { hospitalize.set(amount); }

    public int getInfected() { return infected.get(); }
    public void setInfected(int amount) { infected.set(amount); }

    public int getTodayInfected() { return todayInfected.get(); }
    public void setTodayInfected(int amount) { todayInfected.set(amount); }

    public int getTodayDeath() { return todayDeath.get(); }
    public void setTodayDeath(int amount) { todayDeath.set(amount); }

    public int getDeath() { return death.get(); }
    public void setDeath(int amount) { death.set(amount); }

    public String getCountry() { return country.get(); }
    public void setCountry(String amount) { country.set(amount); }

    public Button getButton() { return button; }
    public void setButton(Button amount) { this.button = amount; }

}
