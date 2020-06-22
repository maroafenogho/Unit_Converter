package com.android.unitconverter;


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

public class AccelerationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Acceleration");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("metre/square second");
        spinnerArray.add("kilometre/square second");
        spinnerArray.add("centimetre/square second");
        spinnerArray.add("mile/square second");
        spinnerArray.add("foot/square second");
        spinnerArray.add("inch/square second");
        spinnerArray.add("gal");
        spinnerArray.add("acceleration of gravity");



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
        if (a.equals("metre/square second")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 100;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.000621371;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 3.280839895;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "inch/square second":
                    conversionFactor = 39.37007874;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "acceleration of gravity":
                    conversionFactor = 0.101971621;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("kilometre/square second")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.000006214;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "foot/square second":
                    conversionFactor = 0.032808399;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "inch/square second":
                    conversionFactor = 0.393700787;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 0.001019716;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("centimetre/square second")||a.equals("gal")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 0.00001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.000006214;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 0.032808399;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "inch/square second":
                    conversionFactor = 0.393700787;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 0.001019716;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("mile/square second")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 1609.344;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 1.609344;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 160934.4;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 5280;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "inch/square second":
                    conversionFactor = 63360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 164.107416906;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("foot/square second")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 0.3048;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 0.0003048;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 30.48;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.000189394;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "inch/square second":
                    conversionFactor = 12;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 0.03108095;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("inch/square second")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 0.0254;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 0.0000254;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 2.54;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.000015783;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 0.083333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "inch/square second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 0.002590079;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("acceleration of gravity")) {
            switch (b) {
                case "metre/square second":
                    conversionFactor = 9.80665;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilometre/square second":
                    conversionFactor = 0.00980665;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centimetre/square second":
                case "gal":
                    conversionFactor = 980.665;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mile/square second":
                    conversionFactor = 0.00609357;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "foot/square second":
                    conversionFactor = 32.174048556;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "inch/square second":
                    conversionFactor = 386.088582677;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "acceleration of gravity":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
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
