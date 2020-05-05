package com.android.unitconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class UnitsAdapter extends ArrayAdapter<Unit> {
    public UnitsAdapter(Context context, ArrayList<Unit> units) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, units);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.units, parent, false);
        }
        Unit currentUnit = getItem(position);

        TextView unit = listItemView.findViewById(R.id.unit_name);
        assert currentUnit != null;
        unit.setText(currentUnit.getUnit());

        ImageView unitImage = listItemView.findViewById(R.id.unit_img);
        unitImage.setImageResource(currentUnit.getUnitPhoto());

            return listItemView;
    }
}
