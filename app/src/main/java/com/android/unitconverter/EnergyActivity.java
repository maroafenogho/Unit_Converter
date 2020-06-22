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

public class EnergyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
        unitName.setText("Energy");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("Joule");
        spinnerArray.add("Kilojoule");
        spinnerArray.add("Gram calorie");
        spinnerArray.add("Kilo calorie");
        spinnerArray.add("Watt hour");
        spinnerArray.add("Kilowatt hour");
        spinnerArray.add("Electronvolt");
        spinnerArray.add("British Thermal Unit");
        spinnerArray.add("US therm");
        spinnerArray.add("Foot-pound");



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        editTextA = findViewById(R.id.textfield_a);
        editTextB = findViewById(R.id.textfield_b);

//        String text= editTextA.getText().toString();
//
//        mDouble1 = Double.parseDouble(text);

//        double mDouble1 = Double.parseDouble(editTextA.getText().toString());
//        mDouble2 = Double.parseDouble(editTextB.getText().toString());

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
        if (a.equals("Joule")) {

                switch (b) {
                    case "Joule":
                        conversionFactor = 1;
                        if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Kilojoule":
                        conversionFactor = 0.001;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Gram calorie":
                        conversionFactor = 0.239006;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Kilo calorie":
                        conversionFactor = 0.000239006;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Watt hour":
                        conversionFactor = 0.000277778;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Kilowatt hour":
                        conversionFactor = 2.7778e-7;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Electronvolt":
                        conversionFactor = 6.242e+18;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "British Thermal Unit":
                        conversionFactor = 0.000947817;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "US therm":
                        conversionFactor = 9.4804e-9;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                    case "Foot-pound":
                        conversionFactor = 0.737562;
                        if (editTextA.getText().toString().length() > 0) {
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));}
                        break;
                }
        }

        if (a.equals("Kilojoule")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 239.006;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 0.239006;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 0.277778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 6.242e+21;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 0.947817;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 9.4804e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 737.562;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Gram calorie")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 4.184;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 0.004184;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 0.00116222;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 1.1622e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 2.611e+19;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 0.00396567;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 3.9666e-8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 3.08596;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Kilo calorie")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 4184;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 4.184;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "Gram calorie":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 1.16222;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 0.00116222;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 2.611e+22;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 3.96567;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 3.9666e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 3085.96;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Watt hour")) {
            switch (b) {
                case "Joule":
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 3.6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 860.421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 0.860421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 1.16222;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 0.00116222;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 2.611e+22;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 3.41214;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 3.413e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 2655.22;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Kilowatt hour")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 3.6e+6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 860421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 860.421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 2.247e+25;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 3412.14;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 0.0341296;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 2.655e+6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Electronvolt")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 1.6022e-19;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 1.6022e-22;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 3.8293e-20;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 3.8293e-23;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 4.4505e-23;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 4.4505e-26;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 1.5186e-22;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 1.5189e-27;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 1.1817e-19;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("British Thermal Unit")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 1055.06;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 1.05506;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 252.164;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 0.252164;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 0.293071;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 0.000293071;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 6.585e+21;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 1.0002e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 778.169;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US therm")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 1.055e+8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 105480;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 2.521e+7;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 25210.4;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 29300.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 29.3001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 6.584e+26;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 99976.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
                    conversionFactor = 7.78e+7;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("Foot-pound")) {
            switch (b) {
                case "Joule":
                    conversionFactor = 1.35582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilojoule":
                    conversionFactor = 0.00135582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Gram calorie":
                    conversionFactor = 0.324048;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilo calorie":
                    conversionFactor = 0.000324048;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Watt hour":
                    conversionFactor = 0.000376616;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Kilowatt hour":
                    conversionFactor = 3.7662e-7;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Electronvolt":
                    conversionFactor = 8.462e+18;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "British Thermal Unit":
                    conversionFactor = 0.00128507;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US therm":
                    conversionFactor = 1.2854e-8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "Foot-pound":
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