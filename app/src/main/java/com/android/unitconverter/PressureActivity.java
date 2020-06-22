package com.android.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class PressureActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {
    private AdView mAdView;

    private Spinner spinnerA, spinnerB;
    private EditText editTextA;
    private EditText editTextB;
    //    private TextView editTextB;
    private double mDouble2;
    private double conversionFactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversion_page);

        MobileAds.initialize(this, new OnInitializationCompleteListener(){

            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        TextView unitName = findViewById(R.id.unit);
        unitName.setText("Pressure");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("bar");
        spinnerArray.add("pascal");
        spinnerArray.add("pound per square inch");
        spinnerArray.add("standard atmosphere");
        spinnerArray.add("torr");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        editTextA = findViewById(R.id.textfield_a);
        editTextB = findViewById(R.id.textfield_b);

//        String text= editTextA.getText().toString();
//
//        mDouble1 = Double.parseDouble(text);


        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextA.getText().toString().equals("")){
                    editTextA.setText(".0");
                }
                mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                editTextB.setText(String.valueOf(mDouble2));

            }
        });

        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String a = String.valueOf(spinnerA.getSelectedItem());
        String b = String.valueOf(spinnerB.getSelectedItem());

        if (a.equals("bar")){
            switch (b) {
                case "bar":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pascal":
                    conversionFactor = 100000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound per square inch":
                    conversionFactor = 14.5038;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "standard atmosphere":
                    conversionFactor = 0.986923;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "torr":
                    conversionFactor = 750.062;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;

            }
        }

        if (a.equals("pascal")){
            switch (b) {
                case "bar":
                    conversionFactor = 1e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pascal":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound per square inch":
                    conversionFactor = 0.000145038;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "standard atmosphere":
                    conversionFactor = 9.8692e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "torr":
                    conversionFactor = 0.00750062;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;

            }
        }

        if (a.equals("pound per square inch")){
            switch (b) {
                case "bar":
                    conversionFactor = 0.0689476;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pascal":
                    conversionFactor = 6894.76;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound per square inch":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "standard atmosphere":
                    conversionFactor = 0.068046;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "torr":
                    conversionFactor = 51.7149;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;

            }
        }

        if (a.equals("standard atmosphere")){
            switch (b) {
                case "bar":
                    conversionFactor = 1.01325;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pascal":
                    conversionFactor = 101325;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound per square inch":
                    conversionFactor = 14.6959;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "standard atmosphere":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "torr":
                    conversionFactor = 760;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;

            }
        }

        if (a.equals("torr")){
            Toast.makeText(this, "Same as mmHg", Toast.LENGTH_LONG).show();
            switch (b) {
                case "bar":
                    conversionFactor = 0.00133322;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pascal":
                    conversionFactor = 133.322;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound per square inch":
                    conversionFactor = 0.0193368;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "standard atmosphere":
                    conversionFactor = 0.00131579;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "torr":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;

            }
        }
//
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
