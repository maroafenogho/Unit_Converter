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

public class TemperatureActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private AdView mAdView;

    private Spinner spinnerA, spinnerB;
    private EditText editTextA;
    private TextView editTextB;
    private double mDouble1;
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
        unitName.setText("Temperature");


        spinnerA = findViewById(R.id.spinner_a);
        spinnerB = findViewById(R.id.spinner_b);

        ArrayList<String> spinnerArray = new ArrayList<>();

        spinnerArray.add("celsius");
        spinnerArray.add("kelvin");
        spinnerArray.add("fahrenheit");
        spinnerArray.add("rankine");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapter);
        spinnerB.setAdapter(adapter);

        editTextA = findViewById(R.id.textfield_a);
        editTextB = findViewById(R.id.textfield_b);

//        String text= editTextA.getText().toString();
//
//        mDouble1 = Double.parseDouble(text);

        mDouble1 = Double.parseDouble(editTextA.getText().toString());
//        mDouble2 = Double.parseDouble(editTextB.getText().toString());


//        editTextA.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (editTextA.getText().toString().equals("")) {
//                    editTextA.setText("0");
//                }
//
//
//                mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
//                editTextB.setText(String.valueOf(mDouble2));
//
//            }
//        });

        spinnerA.setOnItemSelectedListener(this);
        spinnerB.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String a = String.valueOf(spinnerA.getSelectedItem());
        String b = String.valueOf(spinnerB.getSelectedItem());

        if (a.equals("celsius")) {
            switch (b) {
                case "celsius":
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
                                editTextA.setText("0");
                            }
                            conversionFactor = 1;
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "kelvin":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = Double.parseDouble(editTextA.getText().toString()) + 273.15;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = Double.parseDouble(editTextA.getText().toString()) + 273.15;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "fahrenheit":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString()) * 9/5) + 32;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString()) * 9/5) + 32;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "rankine":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = Double.parseDouble(editTextA.getText().toString()) *  9/5 + 491.67 ;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = Double.parseDouble(editTextA.getText().toString()) *  9/5 + 491.67 ;
                    editTextB.setText(String.valueOf(mDouble2));

                    break;
            }
        }

        if (a.equals("kelvin")) {
            switch (b) {
                case "kelvin":
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
                                editTextA.setText("0");
                            }
                            conversionFactor = 1;
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "celsius":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = Double.parseDouble(editTextA.getText().toString()) - 273.15;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = Double.parseDouble(editTextA.getText().toString()) - 273.15;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "fahrenheit":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString()) *273.15) * 9/5 + 32;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString()) *273.15) * 9/5 + 32;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "rankine":
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
                                editTextA.setText("0");
                            }
                            conversionFactor = 1.8;
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    conversionFactor = 1.8;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
            }
        }

        if (a.equals("fahrenheit")) {
            switch (b) {
                case "fahrenheit":
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
                                editTextA.setText("0");
                            }
                            conversionFactor = 1;
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "kelvin":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString()) - 32) * 5/9 + 273.15;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString()) - 32) * 5/9 + 273.15;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "celsius":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString()) - 32) * 5/9;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString()) - 32) * 5/9;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "rankine":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = Double.parseDouble(editTextA.getText().toString())  + 459.67;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = Double.parseDouble(editTextA.getText().toString())  + 459.67;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
            }
        }

        if (a.equals("rankine")) {
            switch (b) {
                case "rankine":
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
                                editTextA.setText("0");
                            }
                            conversionFactor = 1;
                            mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    conversionFactor = 1;
                    mDouble2 = conversionFactor * Double.parseDouble(editTextA.getText().toString());
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "kelvin":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString()) * 5/9);
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString()) * 5/9);
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "celsius":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = (Double.parseDouble(editTextA.getText().toString())  - 491.67) * 5/9;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = (Double.parseDouble(editTextA.getText().toString())  - 491.67) * 5/9;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
                case "fahrenheit":
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
                                editTextA.setText("0");
                            }
                            mDouble2 = Double.parseDouble(editTextA.getText().toString()) - 459.67;
                            editTextB.setText(String.valueOf(mDouble2));
                        }
                    });
                    mDouble2 = Double.parseDouble(editTextA.getText().toString()) - 459.67;
                    editTextB.setText(String.valueOf(mDouble2));
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
