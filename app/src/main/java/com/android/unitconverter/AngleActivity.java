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

public class AngleActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Angles");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("degree");
        spinnerArray.add("radian");
        spinnerArray.add("grad");
        spinnerArray.add("minute");
        spinnerArray.add("sign");
        spinnerArray.add("mil");
        spinnerArray.add("revolution");
        spinnerArray.add("quadrant");
        spinnerArray.add("sextant");


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
        if (a.equals("degree")) {
            switch (b) {
                case "degree":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 0.017453293;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 1.111111111;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 0.033333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 17.777777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.002777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.011111111;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("radian")) {
            switch (b) {
                case "degree":
                    conversionFactor = 57.295779513;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 63.661977237;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 3437.746770785;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 1.909859317;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 1018.591635788;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.159154943;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.636619772;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 0.954929659;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("grad")) {
            switch (b) {
                case "degree":
                    conversionFactor = 0.9;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 0.015707963;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 54;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 0.03;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 16;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.0025;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 0.015;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("sign")) {
            switch (b) {
                case "degree":
                    conversionFactor = 30;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 0.523598776;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 33.333333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 1800;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 533.333333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.083333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.333333333;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 0.5;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("mil")) {
            switch (b) {
                case "degree":
                    conversionFactor = 0.05625;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 0.000981748;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 0.0625;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 3.375;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 0.001875;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.00015625;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.000625;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 0.0009375;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("minute")) {
            switch (b) {
                case "degree":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 0.000290888;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 0.018518519;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 0.000555556;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 0.296296296;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.000046296;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.000185185;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "sextant":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("revolution")) {
            switch (b) {
                case "degree":
                    conversionFactor = 360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 6.283185307;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 21600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 12;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 6400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 4;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 6;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("quadrant")) {
            switch (b) {
                case "degree":
                    conversionFactor = 90;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 1.570796327;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 100;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 5400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 3;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 1600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.25;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
                    conversionFactor = 1.5;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("quadrant")) {
            switch (b) {
                case "degree":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian":
                    conversionFactor = 1.047197551;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "grad":
                    conversionFactor = 66.666666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "minute":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sign":
                    conversionFactor = 2;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "mil":
                    conversionFactor = 1066.666666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution":
                    conversionFactor = 0.166666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "quadrant":
                    conversionFactor = 0.666666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "sextant":
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