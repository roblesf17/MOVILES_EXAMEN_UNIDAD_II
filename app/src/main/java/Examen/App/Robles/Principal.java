package Examen.App.Robles;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AIListener {

    //crea objeto para la autenticacion
    private FirebaseAuth mAuth;


    //DIALOGFLOW
    private TextToSpeech mTextToSpeech;
    private AIService mAIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                */
                mAIService.startListening();



            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);





        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);



        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);




//dialogflow

        final ai.api.android.AIConfiguration config = new ai.api.android.AIConfiguration("0f96f5a7f23c49b6a9e16d6d0ce2b4dd", ai.api.android.AIConfiguration.SupportedLanguages.Spanish, AIConfiguration.RecognitionEngine.System);
        mAIService = AIService.getService(this, config);
       mAIService.setListener( this );
        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

//

    }


    public void onResult(AIResponse response) {
        Result result = response.getResult();
        mTextToSpeech.speak(result.getFulfillment().getSpeech(), TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @Override
    public void onError(AIError error)
    {

    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen( GravityCompat.START)) {
            drawer.closeDrawer( GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);

        //CARGARAN LOS NOMBRES TEMPORALES CARGADOS DESDE EL MAIN ACTIVITY
        TextView mtitulo = (TextView) findViewById(R.id.titulo_nav);
        TextView mcorreo = (TextView) findViewById(R.id.correo_nav);

        mtitulo.setText(Login.nombre_Temporal);
        mcorreo.setText(Login.correo_Temporal);
        //
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(Principal.this ,
                    "Soy una aplicación de fidelizacion" , Toast.LENGTH_SHORT).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            startActivity(new Intent(Principal.this , MainActivityProductos.class));
        } else if (id == R.id.nav_gallery) {

            startActivity(new Intent(Principal.this , caracola_magica.class));

        } else if (id == R.id.nav_slideshow) {

            startActivity(new Intent(Principal.this , Mis_puntos.class));

        } else if (id == R.id.nav_tools) {

            startActivity(new Intent(Principal.this , MainActivityBanoFree.class));

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(Principal.this , MainActivity_maps.class));

        } else if (id == R.id.nav_send) {

           //mAuth.signOut();
            startActivity(new Intent(Principal.this , Login.class));
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer( GravityCompat.START);
        return true;
    }
}
