package com.android.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd= new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2866595266782247/2642432179");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        ArrayList<Unit> unitsList = new ArrayList<>();

        unitsList.add(new Unit(R.drawable.length,"Length and Distance"));
        unitsList.add(new Unit(R.drawable.mass,"Mass"));
        unitsList.add(new Unit(R.drawable.speed,"Speed"));

        unitsList.add(new Unit(R.drawable.area,"Area"));
        unitsList.add(new Unit(R.drawable.energy, "Energy"));
        unitsList.add(new Unit(R.drawable.frequency,"Frequency"));

        unitsList.add(new Unit(R.drawable.pressure,"Pressure"));
        unitsList.add(new Unit(R.drawable.temperature,"Temperature"));
        unitsList.add(new Unit(R.drawable.time,"Time"));

        unitsList.add(new Unit(R.drawable.volume,"Volume"));
        unitsList.add(new Unit(R.drawable.angle,"Angles"));
        unitsList.add(new Unit(R.drawable.angular_acceleration,"Angular Acceleration"));

        unitsList.add(new Unit(R.drawable.acceleration,"Acceleration"));
        unitsList.add(new Unit(R.drawable.angular_velocity,"Angular Velocity"));
        unitsList.add(new Unit(R.drawable.density,"Density"));

        unitsList.add(new Unit(R.drawable.force,"Force"));
        unitsList.add(new Unit(R.drawable.specific_volume,"Specific Volume"));
        unitsList.add(new Unit(R.drawable.surface_tension,"Surface Tension"));

        unitsList.add(new Unit(R.drawable.viscosity,"Viscosity[kinematic]"));

        UnitsAdapter unitsAdapter = new UnitsAdapter(this, unitsList);

        GridView listView = findViewById(R.id.grid);

        listView.setAdapter(unitsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
                    if (position == 0) {
                        Intent lengthIntent = new Intent(MainActivity.this, LengthDistanceActivity.class);
                        startActivity(lengthIntent);
                    } else if (position == 1) {
                        Intent speedIntent = new Intent(MainActivity.this, MassActivity.class);
                        startActivity(speedIntent);
                    } else if (position == 2) {
                        Intent pressureIntent = new Intent(MainActivity.this, SpeedActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 3) {
                        Intent weightIntent = new Intent(MainActivity.this, AreaActivity.class);
                        startActivity(weightIntent);
                    } else if (position == 4) {
                        Intent speedIntent = new Intent(MainActivity.this, EnergyActivity.class);
                        startActivity(speedIntent);
                    } else if (position == 5) {
                        Intent pressureIntent = new Intent(MainActivity.this, FrequencyActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 6) {
                        Intent weightIntent = new Intent(MainActivity.this, PressureActivity.class);
                        startActivity(weightIntent);
                    } else if (position == 7) {
                        Intent speedIntent = new Intent(MainActivity.this, TemperatureActivity.class);
                        startActivity(speedIntent);
                    } else if (position == 8) {
                        Intent pressureIntent = new Intent(MainActivity.this, TimeActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 9) {
                        Intent pressureIntent = new Intent(MainActivity.this, VolumeActivity.class);
                        startActivity(pressureIntent);
                    }else if (position == 10) {
                        Intent pressureIntent = new Intent(MainActivity.this, AngleActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 11) {
                        Intent pressureIntent = new Intent(MainActivity.this, AngularAccelerationActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 12) {
                        Intent pressureIntent = new Intent(MainActivity.this, AccelerationActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 13) {
                        Intent pressureIntent = new Intent(MainActivity.this, AngularVelocityActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 14) {
                        Intent pressureIntent = new Intent(MainActivity.this, DensityActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 15) {
                        Intent pressureIntent = new Intent(MainActivity.this, ForceActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 16) {
                        Intent pressureIntent = new Intent(MainActivity.this, SpecificVolumeActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 17) {
                        Intent pressureIntent = new Intent(MainActivity.this, SurfaceTensionActivity.class);
                        startActivity(pressureIntent);
                    } else if (position == 18) {
                        Intent pressureIntent = new Intent(MainActivity.this, ViscosityActivity.class);
                        startActivity(pressureIntent);
                    }
                }
        });
    }
}
