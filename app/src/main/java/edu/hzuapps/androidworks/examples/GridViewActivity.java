package edu.hzuapps.androidworks.examples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import edu.hzuapps.androidworks.R;
import edu.hzuapps.androidworks.homeworks.BackActivity;

public class GridViewActivity extends BackActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getApplicationContext(), GridViewOneActivity.class);

                // Pass image index
                intent.putExtra("id", position);
                startActivity(intent);
            }
        });
    }

}

class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.javaforkids,
            R.drawable.ltpwm,
            R.drawable.ltpws,
            R.drawable.swiftforkids,
            R.drawable.teachkids,
            R.drawable.javaforkids,
            R.drawable.ltpwm,
            R.drawable.ltpws,
            R.drawable.swiftforkids,
            R.drawable.teachkids,
            R.drawable.javaforkids,
            R.drawable.ltpwm,
            R.drawable.ltpws,
            R.drawable.swiftforkids,
            R.drawable.teachkids
    };
}