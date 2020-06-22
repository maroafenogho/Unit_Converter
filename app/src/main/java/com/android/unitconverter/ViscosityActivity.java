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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class ViscosityActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Viscosity[kinematic]");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("square metre per second");
        spinnerArray.add("square metre per hour");
        spinnerArray.add("square foot per second");
        spinnerArray.add("square foot per hour");
        spinnerArray.add("square inch per second");
        spinnerArray.add("square cm per second");
        spinnerArray.add("square mm per second");



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
        if (a.equals("square metre per second")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 10.763910417;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 38750.077500155;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 1550.003100006;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 10000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 1000000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square metre per hour")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "square foot per second":
                    conversionFactor = 0.002989975;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "square foot per hour":
                    conversionFactor = 10.763910417;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 0.430556417;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 2.777777778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 277.777777778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square foot per second")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.09290304;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 334.450944;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 3600.000000003;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 144;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 929.030400001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 92903.040000084;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square foot per hour")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.000025806;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 0.09290304;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 0.04;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 0.258064;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 25.8064;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square inch per second")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.00064516;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 2.322576;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 0.006944444;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 25;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 6.4516;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 645.16;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square cm per second")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.0001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 0.36;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 0.001076391;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 3.87500775;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 0.15500031;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
                    conversionFactor = 100;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("square mm per second")) {
            switch (b) {
                case "square metre per second":
                    conversionFactor = 0.000001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square metre per hour":
                    conversionFactor = 0.0036;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per second":
                    conversionFactor = 0.000010764;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square foot per hour":
                    conversionFactor = 0.038750078;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square inch per second":
                    conversionFactor = 0.001550003;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square cm per second":
                    Toast.makeText(this, "Same as stoke", Toast.LENGTH_LONG).show();
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "square mm per second":
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