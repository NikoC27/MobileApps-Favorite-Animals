package course.examples.UI.Project02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;


//This application uses some deprecated methods. 
//See UIViewPager for a more modern version of this application

public class GridLayoutActivity extends Activity {

	protected static final String EXTRA_RES_ID = "POS"; // Key for image position
	protected static String ANIMAL_KEY = "Animal";		// Key for animal name
	protected GridView gridview;						// Gridview for thumbnails
	private HashMap<String, String> wikis;				// Map for animal wiki websites

	// Initialize thumbnails
	private ArrayList<Integer> mThumbIdsAnimals = new ArrayList<Integer>(
			Arrays.asList(R.drawable.lion, R.drawable.wolf,
					R.drawable.moose, R.drawable.zebra, R.drawable.wolverine,
					R.drawable.bear, R.drawable.beaver, R.drawable.penguin));

	// Initialize animal names
	private ArrayList<String> animalNames = new ArrayList(
			AnimalHelper.getAnimalNames());

	// Initialize the urls
	private ArrayList<String> urls = new ArrayList<>(AnimalHelper.getUrls());


	// Initialize the wiki map
	private void initMap(){
		assert(animalNames.size() == urls.size());
		wikis = new HashMap<>();
		for(int i = 0; i < animalNames.size(); i++){
			wikis.put(animalNames.get(i), urls.get(i));
		}
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initMap(); // Create map

		// Get grid id from main xml file
		gridview = (GridView) findViewById(R.id.gridview);

		// Create a new AnimalAdapter and set it as the Adapter for this GridView
		gridview.setAdapter(new AnimalAdapter(this, mThumbIdsAnimals, animalNames));

		// Register context menu for gridview
		registerForContextMenu(gridview);

		// Set an setOnItemClickListener on the GridView
		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);

				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) id);
				intent.putExtra(ANIMAL_KEY, animalNames.get(position));

				// Start the ImageViewActivity
				startActivity(intent);
			}
		});
	}

	// Create context menu for gridview
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
		super.onCreateContextMenu(menu,v,menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.context_menu, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item){
		// Get the info from the gridview
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

		// Check which item was clicked in context menu
		switch (item.getItemId()){
			case R.id.big_picture:
				// Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(GridLayoutActivity.this,
						ImageViewActivity.class);

				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) info.id);
				intent.putExtra(ANIMAL_KEY, animalNames.get(info.position));

				// Start the activity
				startActivity(intent);
				return true;
			case R.id.animal_info:
				// Create intent for animal info
				Intent animalIntent = new Intent(GridLayoutActivity.this,
						InfoActivity.class);

				// Pass animal name in intent
				animalIntent.putExtra(ANIMAL_KEY, animalNames.get(info.position));

				// Start animal info activity
				startActivity(animalIntent);
				return true;
			case R.id.wiki_page:
				// Create intent for animal website
				String name = animalNames.get(info.position);
				Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(wikis.get(name)));

				// Start wiki page activity
				startActivity(urlIntent);
				return true;
			default:
				return super.onContextItemSelected(item);
		}
	}


}