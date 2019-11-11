package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivityBanoFree extends AppCompatActivity {

    String TAG = "GenerateQrCode";
    Spinner spinner;
    ImageView qrimg;
    Button start;
    Bitmap bitmap;

    String inputvalue;
    QRGEncoder qrgEncoder;

    public static String genero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_bano_free );

        qrimg = (ImageView) findViewById( R.id.qrcode_bano );
        start = (Button) findViewById( R.id.createbtn_bano );
         spinner = (Spinner) findViewById(R.id.spinner);

        String[] letra = {"Seleccione su sexo ...","Masculino","Femenino","No especificar"};


        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, letra);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

                String item;
                item = (String) parent.getItemAtPosition(position);
                if(item.equals("Masculino"))
                {
                    genero = "Masculino";
                }

                if(item.equals("Femenino"))
                {
                    genero = "Femenino";
                }
                if(item.equals("Seleccione su sexo ..."))
                {
                    genero = "Seleccione su sexo ...";
                }
                if(item.equals("No especificar"))
                {
                    genero = "No especificar";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void onclick_canjear_bano(View v)
    {
        inputvalue = genero + "banofree" + Login.correo_Temporal;
        if(genero.equals("Masculino") || genero.equals("Femenino"))
        {
            WindowManager manager = (WindowManager) getSystemService( WINDOW_SERVICE );
            Display display = manager.getDefaultDisplay();
            Point point = new Point(  );
            display.getSize( point );
            int width = point.x ;
            int heigth = point.y;
            int smallerdimension = width<heigth ? width:heigth;
            smallerdimension=smallerdimension*3/4;
            qrgEncoder = new QRGEncoder( inputvalue , null , QRGContents.Type.TEXT,smallerdimension );
            try
            {
                Integer puntos_detalle = 20;

                if (Login.puntos_principal_temporal>=puntos_detalle)
                {
                    bitmap = qrgEncoder.encodeAsBitmap();
                    qrimg.setImageBitmap( bitmap );

                    TextView titulo = (TextView) findViewById( R.id.title_qr_compra_bano );
                    titulo.setText( " ¡FELICIDADES! \n \n Acerquese con este codigo a los SSHH para entrar libremente.");


                    Login.puntos_principal_temporal = Login.puntos_principal_temporal - puntos_detalle;

                    String puntos_string = String.valueOf(  Login.puntos_principal_temporal );

                    Toast.makeText(MainActivityBanoFree.this ,
                            "Te quedan : " + puntos_string + " vea coins ", Toast.LENGTH_SHORT).show();


                    start.setEnabled(false);

                    //////////////////



                    //////////////////

                }

                else
                {
                    Toast.makeText(MainActivityBanoFree.this ,
                            "No cuenta con los Vea Coins suficientes para el canje", Toast.LENGTH_SHORT).show();


                }



            }
            catch (WriterException e)
            {
                Log.v(TAG,e.toString());
            }
        }

        else
        {


            Toast.makeText(MainActivityBanoFree.this ,
                    "El Codigo QR se creara cuando seleccione su sexo" , Toast.LENGTH_LONG).show();
        }
    }



}
