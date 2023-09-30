package course.examples.UI.Project02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AnimalAdapter extends BaseAdapter {

	private Context mContext;          // This will have to be passed to the ImageView
	private LayoutInflater inflater;   // Inflater for each animal image
	private List<Integer> mThumbIds;   // Adapter must store AdapterView's items
	private List<String> animalNames;  // List of animal names

	// Save the list of image IDs and the context
	public AnimalAdapter(Context c, List<Integer> ids, List<String> names) {
		mContext = c;
		this.mThumbIds = ids;
		this.animalNames = names;
	}

	// Return the number of items in the Adapter
	@Override
	public int getCount() {
		return mThumbIds.size();
	}

	// Return the data item at position
	@Override
	public Object getItem(int position) {
		return mThumbIds.get(position);
	}

	// Will get called to provide the ID that
	// is passed to OnItemClickListener.onItemClick()
	@Override
	public long getItemId(int position) {
		return mThumbIds.get(position);
	}

	// Return an ImageView for each item referenced by the Adapter
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		// Initialize inflater
		if(inflater == null){
			inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		// Initialize convert view
		if(convertView == null){
			convertView = inflater.inflate(R.layout.item, null);
		}

		// Get the image of and name of each animal
		ImageView imageView = convertView.findViewById(R.id.image_view);
		TextView textView = convertView.findViewById(R.id.text_view);
		imageView.setImageResource(mThumbIds.get(position));
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		textView.setText(animalNames.get(position));

		return convertView;
	}
}
