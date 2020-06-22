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

public class SpecificVolumeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Specific Volume");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("cubic metre/kilogram");
        spinnerArray.add("cubic centimetre/gram");
        spinnerArray.add("square decimetre");
        spinnerArray.add("litre/kilogram");
        spinnerArray.add("litre/gram");
        spinnerArray.add("cubic foot/kilogram");
        spinnerArray.add("cubic foot/pound");
        spinnerArray.add("gallon[US]/pound");
        spinnerArray.add("gallon[UK]/pound");

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
        if (a.equals("cubic metre/kilogram") || a.equals("litre/gram")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 1;
                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 1000;
                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 35.31466672;
                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/pound":
                    conversionFactor =16.01846353;
//                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                case "gallon[US]/pound":
                    conversionFactor = 119.826435935;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 99.77637365;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("cubic centimetre/gram") || a.equals("litre/kilogram")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 0.001;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 1;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 0.035314667;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/pound":
                    conversionFactor = 0.016018464;
                    //                    editTextA.getText().toString();
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                case "gallon[US]/pound":
                    conversionFactor = 0.119826436;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 0.099776374;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("cubic foot/kilogram")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 0.028316847;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 28.316846593;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/pound":
                    conversionFactor = 0.453592374;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                case "gallon[US]/pound":
                    conversionFactor = 3.393106804;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 2.825352266;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("cubic foot/pound")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 0.06242796;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 62.427959968;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 2.2046226;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/pound":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                case "gallon[US]/pound":
                    conversionFactor = 7.480519946;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 6.22883546;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("gallon[US]/pound")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 0.008345404;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 8.345403852;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 0.294715156;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot/pound":
                    conversionFactor = 0.133680547;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                case "gallon[US]/pound":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 0.832674133;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("gallon[UK]/pound")) {
            switch (b) {
                case "cubic metre/kilogram":
                case "litre/gram":
                    conversionFactor = 0.010022413;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "cubic centimetre/gram":
                case "litre/kilogram":
                    conversionFactor = 10.022412756;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "cubic foot/kilogram":
                    conversionFactor = 0.353938166;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "cubic foot/pound":
                    conversionFactor = 0.160543653;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                case "gallon[US]/pound":
                    conversionFactor = 1.20095;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "gallon[UK]/pound":
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
            }
        }


    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}