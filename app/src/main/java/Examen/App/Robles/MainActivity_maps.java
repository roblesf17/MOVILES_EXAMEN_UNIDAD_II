package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity_maps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_maps );



        MapFragment mapFragment = new MapFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.activityyyyyy, mapFragment).commit();

    }
}
