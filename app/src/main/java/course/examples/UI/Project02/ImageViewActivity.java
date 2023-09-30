package course.examples.UI.Project02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {

	protected static String ANIMAL_KEY = "Animal";  // Key for animal names
	private String animal;                          // Gets the animal name

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Get the Intent used to start this Activity
        Intent intent = getIntent();

        // Make a new ImageView
        // Example of programmatic layout definition
        ImageView imageView = new ImageView(getApplicationContext());

        // Get the ID of the image to display and set it as the image for this ImageView
        imageView.setImageResource(intent.getIntExtra(GridLayoutActivity.EXTRA_RES_ID, 0));

        setContentView(imageView); // Shows full image on second screen

        // Get animal name passed from Grid Layout Activity
        animal = intent.getStringExtra(GridLayoutActivity.ANIMAL_KEY);

        // Start animal info activity when user clicks image
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infoIntent = new Intent(ImageViewActivity.this, InfoActivity.class);
                infoIntent.putExtra(ANIMAL_KEY, animal);
                startActivity(infoIntent);
            }
        });
    }
}