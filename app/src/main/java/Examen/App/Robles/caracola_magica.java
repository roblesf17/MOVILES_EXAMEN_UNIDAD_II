package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

public class caracola_magica extends AppCompatActivity implements   AIListener {

    //DIALOGFLOW
    private TextToSpeech mTextToSpeech;
    private AIService mAIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_caracola_magica );




        //dialogflow

        final ai.api.android.AIConfiguration config = new ai.api.android.AIConfiguration("aede6a2870454455a5d45d718555e9dd", ai.api.android.AIConfiguration.SupportedLanguages.Spanish, AIConfiguration.RecognitionEngine.System);
        mAIService = AIService.getService(this, config);
        mAIService.setListener( this );
        mTextToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });

//

    }


    public void onclick_preguntame(View v)
    {
        mAIService.startListening();

    }


    public void onResult(AIResponse response) {
        Result result = response.getResult();
        mTextToSpeech.speak(result.getFulfillment().getSpeech(), TextToSpeech.QUEUE_FLUSH, null, null);

        //


        int numero = (int) (Math.random() * 10) + 1;
        String puntos_ganados = Integer.toString( numero );


        ImageView mimage = (ImageView) findViewById( R.id.caracolaimg );


        if (puntos_ganados.equals( "0" ))
        {
            mimage.setImageResource(R.drawable.veacoins0);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "1" ))
        {
            mimage.setImageResource(R.drawable.veacoins1);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "2" ))
        {
            mimage.setImageResource(R.drawable.veacoins1);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "3" ))
        {
            mimage.setImageResource(R.drawable.veacoins3);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "4" ))
        {
            mimage.setImageResource(R.drawable.veacoins4);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "5" ))
        {
            mimage.setImageResource(R.drawable.veacoins5);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "6" ))
        {
            mimage.setImageResource(R.drawable.veacoins6);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "7" ))
        {
            mimage.setImageResource(R.drawable.veacoins7);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "8" ))
        {
            mimage.setImageResource(R.drawable.veacoins8);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "9" ))
        {
            mimage.setImageResource(R.drawable.veacoins9);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }

        if (puntos_ganados.equals( "10" ))
        {
            mimage.setImageResource(R.drawable.veacoins10);

            Toast.makeText(getApplicationContext(),"Ganaste " + puntos_ganados + " Vea Coins .", Toast.LENGTH_SHORT).show();
            Login.puntos_principal_temporal = Login.puntos_principal_temporal + numero;
        }
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

}
