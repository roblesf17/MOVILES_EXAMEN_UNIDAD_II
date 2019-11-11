package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.WriterException;

import java.io.File;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class MainActivity_QR extends AppCompatActivity {

    String TAG = "GenerateQrCode";
    EditText edttxt;
    ImageView qrimg;
    Button start;
    Bitmap bitmap;

    String inputvalue;
    QRGEncoder qrgEncoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main__qr );


        qrimg = (ImageView) findViewById( R.id.qrcode );
        edttxt = (EditText)findViewById( R.id.edittex );
        start = (Button) findViewById( R.id.createbtn );

        edttxt.setInputType(InputType.TYPE_CLASS_NUMBER);

        start.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                inputvalue = edttxt.getText().toString().trim() + DetailsActivity_productos.Producto_temporal + DetailsActivity_productos.Puntos_Temporales;
                if(edttxt.length()>0)
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
                        Integer puntos_detalle = Integer.valueOf(DetailsActivity_productos.Puntos_Temporales);

                        if (Login.puntos_principal_temporal>=puntos_detalle)
                        {
                            bitmap = qrgEncoder.encodeAsBitmap();
                            qrimg.setImageBitmap( bitmap );

                            TextView titulo = (TextView) findViewById( R.id.title_qr_compra );
                            titulo.setText( " ¡FELICIDADES! \n \n Acerquese con este codigo a nuestras tiendas mas cercanas y reciba su canje.");


                            Login.puntos_principal_temporal = Login.puntos_principal_temporal - puntos_detalle;

                            String puntos_string = String.valueOf(  Login.puntos_principal_temporal );

                            Toast.makeText(MainActivity_QR.this ,
                                    "Te quedan : " + puntos_string + " vea coins ", Toast.LENGTH_SHORT).show();


                            edttxt.setEnabled(false);
                            start.setEnabled(false);

                            //////////////////



                            //////////////////

                        }

                        else
                        {
                            Toast.makeText(MainActivity_QR.this ,
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
                    edttxt.setError( "Requerido" );

                    Toast.makeText(MainActivity_QR.this ,
                            "El Codigo QR se creara cuando halla ingresado su DNI" , Toast.LENGTH_LONG).show();
                }
            }
        } );


        ImageView imageImageView = this.findViewById(R.id.qrcode);
        imageImageView.setImageResource(R.drawable.qr_stop);

        TextView titulo = (TextView) findViewById( R.id.title_qr_compra );
        titulo.setText( " ¡EN HORA BUENA! \n \n Esta a un paso de canjear sus puntos por " + DetailsActivity_productos.Producto_temporal
        + " a " + DetailsActivity_productos.Puntos_Temporales + " Vea Coins \n");


        Toast.makeText(MainActivity_QR.this ,
                "Ingrese su DNI" , Toast.LENGTH_LONG).show();




    }
}
