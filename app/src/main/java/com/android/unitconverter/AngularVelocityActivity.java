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

public class AngularVelocityActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        unitName.setText("Angular Velocity");

        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("radian/second");
        spinnerArray.add("radian/minute");
        spinnerArray.add("radian/hour");
        spinnerArray.add("radian/day");
        spinnerArray.add("degree/second");
        spinnerArray.add("degree/minute");
        spinnerArray.add("degree/hour");
        spinnerArray.add("degree/day");
        spinnerArray.add("revolution/second");
        spinnerArray.add("revolution/minute");
        spinnerArray.add("revolution/hour");
        spinnerArray.add("revolution/day");

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
        if (a.equals("radian/second")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 86400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 57.295779513;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 3437.746770785;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 206264.8062471;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 4950355.3499303;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.159154943;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 9.549296586;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 572.957795131;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 13750.98708314;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("radian/minute")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 1440;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.954929659;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 57.295779513;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 3437.746770785;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 82505.922498839;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.002652582;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.159154943;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 9.549296586;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 229.183118052;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("radian/hour")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 24;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.015915494;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 0.954929659;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 57.295779513;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 1375.098708314;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.00004421;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.002652582;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.159154943;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 3.819718634;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("radian/day")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000011574;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.000694444;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 0.041666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.000663146;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 0.039788736;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 2.387324146;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 57.295779513;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000001842;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.000110524;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.006631456;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 0.159154943;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("degree/second")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.017453293;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 1.047197551;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 62.831853072;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 1507.964473723;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 86400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.002777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.166666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 10;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 240;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("degree/minute")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000290888;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.017453293;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 1.047197551;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 25.132741229;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "degree/second":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 1440;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000046296;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.002777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.166666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 4;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("degree/hour")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000004848;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.000290888;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "radian/hour":
                    conversionFactor = 0.017453293;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "radian/day":
                    conversionFactor = 0.41887902;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 24;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000000772;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.000046296;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.002777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 0.066666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("degree/day")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000000202;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.00001212;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 0.000727221;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 0.017453293;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.000011574;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 0.000694444;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 0.041666667;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "degree/day":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000000032;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.000001929;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.000115741;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 0.002777778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("revolution/second")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 6.283185307;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 376.991118431;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 22619.467105846;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 542867.21054032;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 21600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 1296000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 31104000;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 3600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 86400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("revolution/minute")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.104719755;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 6.283185307;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 376.991118431;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 9047.786842339;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 6;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 21600;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 518400;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 60;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 1440;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("revolution/hour")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.001745329;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.104719755;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 6.283185307;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 150.796447372;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 6;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 8640;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000277778;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.016666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
                    conversionFactor = 24;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }
        if (a.equals("revolution/day")) {
            switch (b) {
                case "radian/second":
                    conversionFactor = 0.000072722;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/minute":
                    conversionFactor = 0.004363323;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/hour":
                    conversionFactor = 0.261799388;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "radian/day":
                    conversionFactor = 6.283185307;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/second":
                    conversionFactor = 0.004166667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/minute":
                    conversionFactor = 0.25;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/hour":
                    conversionFactor = 15;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "degree/day":
                    conversionFactor = 360;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/second":
                    conversionFactor = 0.000011574;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/minute":
                    conversionFactor = 0.000694444;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/hour":
                    conversionFactor = 0.041666667;
                    if (editTextA.getText().toString().length() > 0){
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "revolution/day":
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