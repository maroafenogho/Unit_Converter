package com.android.unitconverter;

//import android.support.v7.app.AppCompatActivity;
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

public class VolumeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
        unitName.setText("Volume");


        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("US liquid gallon");
        spinnerArray.add("US liquid quart");
        spinnerArray.add("US liquid pint");
        spinnerArray.add("US legal cup");
        spinnerArray.add("US fluid ounce");
        spinnerArray.add("US tablespoon");
        spinnerArray.add("US teaspoon");
        spinnerArray.add("cubic metre");
        spinnerArray.add("litre");
        spinnerArray.add("barrel (oil)");
        spinnerArray.add("centilitre");
        spinnerArray.add("millilitre");
        spinnerArray.add("imperial gallon");
        spinnerArray.add("imperial quart");
        spinnerArray.add("imperial pint");
        spinnerArray.add("imperial cup");
        spinnerArray.add("imperial fluid ounce");
        spinnerArray.add("imperial tablespoon");
        spinnerArray.add("imperial teaspoon");
        spinnerArray.add("cubic foot");
        spinnerArray.add("cubic inch");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        editTextA = findViewById(R.id.textfield_a);
        editTextB = findViewById(R.id.textfield_b);


        editTextA.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (editTextA.getText().toString().equals("")) {
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

        if (a.equals("barrel (oil)")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 42;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 168;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 336;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 672;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 5376;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 10752;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 32256;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.158987295;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 158.987294928;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 15898.7294928;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 158987.294928;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 34.972315754;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 139.889263018;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 279.778526035;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 559.557052071;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 5595.570520707;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 8952.912833131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 26858.738499393;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 5.614583333;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 9702;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US liquid gallon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.023809524;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 4;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 15.7725;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 128;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 256;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 768;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.00378541;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 3.78541;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 378.541;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "millilitre":
                    conversionFactor = 3785.41;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.832674;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 3.3307;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 6.66139;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 13.3228;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 133.228;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 213.165;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 639.494;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.133681;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 231;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US liquid quart")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.005952381;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.25;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 2;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 3.94314;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 32;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 64;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 192;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.000946353;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.946353;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 94.6353;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 946.353;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.208169;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.832674;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 1.66535;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 3.3307;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 33.307;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 53.2911;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 159.873;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.0334201;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 57.75;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US liquid pint")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.00297619;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 1.97157;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 16;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 32;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 96;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.000473176;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.473176;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 47.3176;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 473.176;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.104084;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.416337;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.832674;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 1.66535;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 16.6535;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 26.6456;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 79.9367;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.0167101;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 28.875;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US liquid cup")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.001488095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.0634013;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.253605;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.50721;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 8.11537;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 16.2307;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 48.6922;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.00024;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.24;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 24;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 240;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.0527926;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.21117;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.422341;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.844682;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 8.44682;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 13.5149;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 40.5447;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.00847552;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 14.6457;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US liquid ounce")) {
            switch (b) {
                case "barrel (oil)":
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.0078125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.03125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.123223;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 2;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 2.9574e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.0295735;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 2.95735;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 29.5735;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00650527;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.0260211;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.0520421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.104084;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 1.04084;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 1.66535;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 4.99604;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US tablespoon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000093006;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00390625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.015625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.03125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0616115;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 3;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1.4787e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.0147868;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 1.47868;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 14.7868;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00325263;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.0130105;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.0260211;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0520421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.520421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.832674;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 2.49802;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.00052219;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 0.902344;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("US teaspoon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000031002;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00130208;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.00520833;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0104167;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0205372;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.166667;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 0.333333;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 4.9289e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.00492892;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 0.492892;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 4.92892;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00108421;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.00433684;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.00867369;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0173474;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.173474;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.277558;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 0.832674;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.000174063;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 0.300781;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("cubic metre")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 6.28981077;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 264.172;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 1056.69;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 2113.38;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 4166.67;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 33814;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 67628;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 202884;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 100000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 1e+6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 219.969;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 879.877;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 1759.75;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 3519.51;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 35195.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 56312.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 168936;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 35.3147;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 61023.7;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("litre")) {
            switch (b) {
                case "US liquid gallon":
                    conversionFactor = 0.264172;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 1.05669;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 2.11338;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 4.16667;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 33.814;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 67.628;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 202.884;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "barrel (oil)":
                    conversionFactor = 0.006289811;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 100;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 1000;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.219969;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.879877;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 1.75975;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 3.51951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 35.1951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 56.3121;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 168.936;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.0353147;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 61.0237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("centilitre")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000062898;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00264172;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.0105669;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0211338;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0416667;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.33814;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 0.67628;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 2.02884;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.01;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 10;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00219969;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.00879877;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.0175975;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0351951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.351951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.563121;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 1.68936;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.000353147;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 0.610237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("millilitre")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.00000629;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.000264172;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.00105669;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.00211338;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.00416667;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.033814;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 0.067628;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 0.202884;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.001;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 0.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.000219969;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.000879877;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.00175975;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "imperial cup":
                    conversionFactor = 0.00351951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.0351951;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.0563121;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 0.168936;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 3.5315e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 0.0610237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial gallon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.028594046;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 1.20095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 4.8038;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 9.6076;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 18.942;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 153.722;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 307.443;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 922.33;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.00454609;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 4.54609;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 454.609;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 4546.09;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 4;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 16;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 160;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 256;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 768;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.160544;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 277.419;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial quart")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.007148511;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.300237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 1.20095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 2.4019;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 4.73551;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 38.4304;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 76.8608;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 230.582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.00113652;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 1.13652;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 113.652;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 1136.52;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.25;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 2;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 4;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 40;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 64;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 192;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.0401359;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 69.3549;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial pint")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.003574256;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.150119;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.600475;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 1.20095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 2.36776;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 19.2152;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 38.4304;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 115.291;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.000568261;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.568261;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 56.8261;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 568.261;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 2;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 20;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "imperial tablespoon":
                    conversionFactor = 32;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 96;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.020068;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 34.6774;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial cup")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.001787128;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.0750594;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.300237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.600475;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 1.18388;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 9.6076;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 19.2152;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 57.6456;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.000284131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.284131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 28.4131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 284.131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.0625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.25;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 10;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 16;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 48;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.010034;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 17.3387;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial fluid ounce")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000178713;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00750594;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.0300237;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0600475;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.118388;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.96076;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "US tablespoon":
                    conversionFactor = 1.92152;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "US teaspoon":
                    conversionFactor = 5.76456;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 2.8413e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.0284131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 2.84131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 28.4131;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.025;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.05;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 1.6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 4.8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.0010034;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 1.73387;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial tablespoon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000111695;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00469121;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.0187649;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0375297;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0739924;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.600475;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 1.20095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 3.60285;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1.7758e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.0177582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 1.77582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 17.7582;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00390625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.015625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.03125;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.625;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 3;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.000627124;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 1.08367;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("imperial teaspoon")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000037232;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.00156374;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.00625495;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.0125099;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0246641;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.200158;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 0.400317;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 1.20095;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 5.9194e-6;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.00591939;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 0.591939;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 5.91939;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00130208;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.00520834;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.0104167;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0208333;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.208333;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.333333;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.000209041;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 0.361223;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("cubic foot")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.178107607;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 7.48052;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 29.9221;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 59.8442;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 117.987;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 957.506;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 1915.01;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 5745.04;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 0.0283168;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 28.3168;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 2831.68;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 28316.8;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 6.22884;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 24.9153;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 49.8307;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 99.6614;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 996.614;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 1594.58;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 4783.74;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 1;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
                    conversionFactor = 1728;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
            }
        }

        if (a.equals("cubic inch")) {
            switch (b) {
                case "barrel (oil)":
                    conversionFactor = 0.000103072;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid gallon":
                    conversionFactor = 0.004329;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid quart":
                    conversionFactor = 0.017316;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US liquid pint":
                    conversionFactor = 0.034632;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US legal cup":
                    conversionFactor = 0.0682794;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US fluid ounce":
                    conversionFactor = 0.554113;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US tablespoon":
                    conversionFactor = 1.10823;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "US teaspoon":
                    conversionFactor = 3.32468;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic metre":
                    conversionFactor = 1.6387e-5;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "litre":
                    conversionFactor = 0.0163871;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "centilitre":
                    conversionFactor = 1.63871;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "millilitre":
                    conversionFactor = 16.3871;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial gallon":
                    conversionFactor = 0.00360465;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial quart":
                    conversionFactor = 0.0144186;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial pint":
                    conversionFactor = 0.0288372;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial cup":
                    conversionFactor = 0.0576744;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial fluid ounce":
                    conversionFactor = 0.576744;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial tablespoon":
                    conversionFactor = 0.92279;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "imperial teaspoon":
                    conversionFactor = 2.76837;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic foot":
                    conversionFactor = 0.000578704;
                    if (editTextA.getText().toString().length() > 0) {
                        mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                        editTextB.setText(String.valueOf(mDouble2));}
                    break;
                case "cubic inch":
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