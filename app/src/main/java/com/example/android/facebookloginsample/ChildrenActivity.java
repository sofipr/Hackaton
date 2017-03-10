package com.example.android.facebookloginsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ChildrenActivity extends Activity {
    ListView childrenListView;
    ToggleButton genderToggle;
    View addChildBtn;
    TextView birthDateTv;
    List<Child> children;


    private void prepareChildrenListView() {
        ChildrenAdapter childrenAdapter = new ChildrenAdapter(this, children);
        childrenListView.setAdapter(childrenAdapter);
    }

    private void prepareGenderToggle() {
        genderToggle.setText(getString(R.string.girl));
        genderToggle.setTextOff(getString(R.string.girl));
        genderToggle.setTextOn(getString(R.string.boy));
    }

    private Date getBirthDateFromFrom() {
        String dateStr = birthDateTv.getText().toString();
        Date birthDate = null;
        try {
            birthDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateStr);
        } catch (Exception e) {
            //TODO: handle this
        }

        return birthDate;
    }

    private void prepareAddChildBtn() {
        addChildBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateChildDetails()) {
                    char gender = genderToggle.isChecked() ? 'm' : 'f';
                    String dateStr = birthDateTv.getText().toString();
//                    Date birthDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(dateStr));
                    Date birthDate = new Date(); //TODO: change this
                    Child newChild = new Child(gender, birthDate);
                    children.add(newChild);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children);

        childrenListView = (ListView) findViewById(R.id.childrenListView);
        genderToggle = (ToggleButton) findViewById(R.id.gender_toggle);
        addChildBtn = findViewById(R.id.add_child_btn);
        birthDateTv = (TextView) findViewById(R.id.birth_date_tv);
        children = new ArrayList<>();

        prepareChildrenListView();
        prepareGenderToggle();
        prepareAddChildBtn();
    }

    private boolean validateChildDetails() {
        //TODO:
        return true;
    }
}
