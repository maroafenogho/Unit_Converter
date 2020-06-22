package com.android.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class SurfaceTensionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AdView mAdView;

    private Spinner spinnerA, spinnerB;
    private EditText editTextA;
    private EditText editTextB;
    //    private TextView editTextB;
    private double mDouble2;
    private double conversionFactor;

    @SuppressLint("SetTextI18n")
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
        unitName.setText("Surface tension");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("newton/metre");
        spinnerArray.add("gram-force/centimetre");
        spinnerArray.add("dyne/centimetre");
        spinnerArray.add("pound-force/inch");
        spinnerArray.add("erg/square cm");
        spinnerArray.add("erg/square millimetre");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        editTextA = findViewById(R.id.textfield_a);
        editTextB = findViewById(R.id.textfield_b);

        // Textwatcher for the EditText field that takes in the input.
        // This watcher helps ensure that the values entered are being calculated in real time to give the converted values of each.
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

        // Selection listeners for both spinners. For this to work effectively, you need to implement AdapterView.OnItemSelectedListener
        // in the main class.
        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);
    }

    // onItemSelected method for the spinners. This method combines both spinners.
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String a = String.valueOf(spinnerA.getSelectedItem());
        String b = String.valueOf(spinnerB.getSelectedItem());

        // nested loop that checks the value of one unit against all others, multiplying by the conversion factor.
        if (a.equals("newton/metre")) {
            switch (b) {
                case "newton/metre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram-force/centimetre":
                    conversionFactor = 1.019716213;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "dyne/centimetre":
                case "erg/square centimetre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound-force/inch":
                    conversionFactor = 0.005710147;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "erg/square millimetre":
                    conversionFactor = 10;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("gram-force/centimetre")) {
            switch (b) {
                case "newton/metre":
                    conversionFactor = 0.980665;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram-force/centimetre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "dyne/centimetre":
                case "erg/square centimetre":
                    conversionFactor = 980.664999979;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound-force/inch":
                    conversionFactor = 0.005599741;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "erg/square millimetre":
                    conversionFactor = 9.80665;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("dyne/centimetre") || a.equals("erg/square centimetre")) {
            switch (b) {
                case "newton/metre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram-force/centimetre":
                    conversionFactor = 0.001019716;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "dyne/centimetre":
                case "erg/square centimetre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound-force/inch":
                    conversionFactor = 0.00000571;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "erg/square millimetre":
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("pound-force/inch")) {
            switch (b) {
                case "newton/metre":
                    conversionFactor = 175.126836986;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram-force/centimetre":
                    conversionFactor = 178.579675006;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "dyne/centimetre":
                case "erg/square centimetre":
                    conversionFactor = 175126.83698643;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound-force/inch":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "erg/square millimetre":
                    conversionFactor = 1751.268369864;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("erg/square millimetre")) {
            switch (b) {
                case "newton/metre":
                    conversionFactor = 0.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram-force/centimetre":
                    conversionFactor = 0.101971621;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "dyne/centimetre":
                case "erg/square centimetre":
                    conversionFactor = 100;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound-force/inch":
                    conversionFactor = 0.000571015;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "erg/square millimetre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}