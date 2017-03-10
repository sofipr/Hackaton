package com.example.android.facebookloginsample;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Danielle on 10/03/2017.
 */
public class ChildrenAdapter extends ArrayAdapter<Child> {
    private Context context;
    private List<Child> children;

    public ChildrenAdapter(Context context, List<Child> children) {
        super(context, R.layout.child_list_item, children);
        this.context = context;
        this.children = children;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.child_list_item, parent, false);
        TextView birthDate = (TextView) rowView.findViewById(R.id.birth_date_item);
        Button deleteChild = (Button) rowView.findViewById(R.id.deleteChildBtn);

        Child child = children.get(position);
        birthDate.setText(child.getBirthDate().toString());
        birthDate.setTextColor(child.getGender() == 'f' ? Color.RED : Color.BLUE);

//        deleteChild.setOnClickListener();

        return rowView;
    }
}
