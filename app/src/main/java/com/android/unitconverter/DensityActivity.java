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

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DensityActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Density");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("kilogram/cubic metre");
        spinnerArray.add("kilogram/cubic centimetre");
        spinnerArray.add("gram/cubic metre");
        spinnerArray.add("gram/cubic centimetre");
        spinnerArray.add("gram/cubic millimetre");
        spinnerArray.add("kilogram/litre");
        spinnerArray.add("gram/litre");
        spinnerArray.add("pound/cubic inch");
        spinnerArray.add("pound/cubic foot");
        spinnerArray.add("pound/gallon[US]");
        spinnerArray.add("pound/gallon[UK]");



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
        if (a.equals("kilogram/cubic metre")|| a.equals("gram/litre")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.000001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.000036127;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 0.062427961;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 0.008345404;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 0.010022413;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("kilogram/cubic centimetre")|| a.equals("gram/cubic millimetre")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 1000000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 1000000000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 36.127292;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 62427.960576173;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 8345.404452031;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 10022.412854961;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("gram/cubic metre")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.000000001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 0.000001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.000000036;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 0.000062428;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 0.000008345;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 0.000010022;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("gram/cubic centimetre")|| a.equals("kilogram/litre")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 1000000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.036127292;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 62.427960576;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 8.345404452;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 10.022412855;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("pound/cubic inch")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 27679.904710191;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.027679905;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 27679904.710191;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 27.67990471;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 1728;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 231;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 277.419432791;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("pound/cubic foot")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 16.018463374;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.000016018;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 16018.463373953;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 0.016018463;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.000578704;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 0.133680556;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 0.160543653;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("pound/gallon[US]")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 119.826427317;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.000119826;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 119826.42731672;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 0.119826427;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.004329004;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 7.480519481;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
                    conversionFactor = 1.200949926;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("pound/gallon[UK]")) {
            switch (b) {
                case "kilogram/cubic metre":
                case "gram/litre":
                    conversionFactor = 99.776372663;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "kilogram/cubic centimetre":
                case "gram/cubic millimetre":
                    conversionFactor = 0.000099776;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic metre":
                    conversionFactor = 99776.372663102;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "gram/cubic centimetre":
                case "kilogram/litre":
                    conversionFactor = 0.099776373;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic inch":
                    conversionFactor = 0.00360465;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/cubic foot":
                    conversionFactor = 6.228835459;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[US]":
                    conversionFactor = 0.832674185;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "pound/gallon[UK]":
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