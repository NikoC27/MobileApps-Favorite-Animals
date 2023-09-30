package course.examples.UI.Project02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoActivity extends Activity {

    protected static String ANIMAL_KEY = "Animal";          // Key for animal names
    private ArrayList<String> animalNames = new ArrayList(  // List of animal names
            AnimalHelper.getAnimalNames());
    private ArrayList<String> animalInfo = new ArrayList(   // List of animal info
            AnimalHelper.getInfo());
    private HashMap<String,String> info;                    // Map for animal info
    protected TextView title;                               // Title text
    protected TextView infoText;                            // Info text

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        // Get intent from Grid and Image activity
        Intent infoIntent = getIntent();

        // Create info map
        initMap();

        // Set title and infoText to the xml file ids
        title = (TextView) findViewById(R.id.title_view);
        infoText = (TextView) findViewById(R.id.info_view);

        // Initialize title and infoText
        String animal = infoIntent.getStringExtra(ANIMAL_KEY);
        title.setText(animal);
        infoText.setText(info.get(animal));
    }

    // Initialize the info hashmap
    private void initMap(){
        assert(animalNames.size() == animalInfo.size());
        info = new HashMap<>();
        for(int i = 0; i < animalNames.size(); i++){
            info.put(animalNames.get(i), animalInfo.get(i));
        }
    }

}
