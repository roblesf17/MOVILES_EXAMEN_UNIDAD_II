package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class DetailsActivity_productos extends AppCompatActivity {

    private Film_productos mFilm;

    public static String Producto_temporal ;
    public static String Puntos_Temporales ;
    public static String imagen_temporal ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_details_productos );



        Bundle b = getIntent().getExtras();
        mFilm = (Film_productos) b.getSerializable("film");

        setContentView(R.layout.activity_details_productos);
        TextView titleTextView = this.findViewById(R.id.title);
        TextView descTextView = this.findViewById(R.id.description);
        ImageView imageImageView = this.findViewById(R.id.image);

        titleTextView.setText(mFilm.getTitle());
        descTextView.setText(mFilm.getDescription());
        imageImageView.setImageResource(mFilm.getImage());


        //video
        VideoView videoView = (VideoView) findViewById(R.id.videodetalle);
        Uri path = Uri.parse("android.resource://Examen.App.Robles/"+R.raw.videodetalle);
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(path);
        videoView.requestFocus();
        videoView.start();
        //



        //obtener los puntos
        String puntos_textos_completo = (String) titleTextView .getText();

        String string = puntos_textos_completo;
        String[] parts = string.split(" ");

        String part1 = parts[0]; // 123
        String part2 = parts[1]; // 654321
        //


        //obtener descripcion del producto
        Producto_temporal = (String) descTextView .getText();
        Puntos_Temporales = parts[0] ;




    }

    public  void onclic_canjear_puntos (View v )
    {

        startActivity(new Intent(DetailsActivity_productos.this , MainActivity_QR.class));
        finish();
    }


    public  void onclick_canjear_txt (View v )
    {

        startActivity(new Intent(DetailsActivity_productos.this , MainActivity_QR.class));
        finish();
    }
}
