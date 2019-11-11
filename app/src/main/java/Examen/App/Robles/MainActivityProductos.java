package Examen.App.Robles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityProductos extends AppCompatActivity implements OnRecyclerViewItemListener_productos {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private MyAdapter_productos mAdapter;

    private List<Film_productos> myFilms = new ArrayList<Film_productos>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main_productos );


        loadFilms();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter_productos(myFilms,this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void loadFilms() {
        myFilms.add(new Film_productos(1, "25 Vea Coins",R.drawable.producto_1, "Gomitas Frugelé AMBROSOLI Ambrujos Paquete 301g."));
        myFilms.add(new Film_productos(2, "75 Vea Coins", R.drawable.producto_2, "Pañales para Bebé BABYSEC Súper Premium Talla XG Paquete 92 unidades."));
        myFilms.add(new Film_productos(3, "4 Vea Coins", R.drawable.producto_3, "Trozos de Atún FRESCOMAR Aceite Vegetal Lata 170g."));
        myFilms.add(new Film_productos(4, "5 Vea Coins", R.drawable.producto_4, "Chupetes GLOBO POP!! Con chicle sabores surtidos Bolsa 480Gr."));
        myFilms.add(new Film_productos(5, "20 Vea Coins", R.drawable.producto_5, "Cojín Infantil VIVA HOME Animales Surtidos."));
        myFilms.add(new Film_productos(6, "9 Vea Coins", R.drawable.producto_6, "Crema Dental COLGATE Triple Acción Paquete 3un Tubo 60ml."));
        myFilms.add(new Film_productos(7, "6 Vea Coins", R.drawable.producto_7, "Gomitas AMBROSOLI Ambrujos Cerebros Paquete 300g."));
        myFilms.add(new Film_productos(8, "57 Vea Coins", R.drawable.producto_8, "Cerveza PILSEN 12Pack Lata 355ml Pack 2 unidades."));
    }


    private void showFilmDetails() {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position) {
        openFilmDetails(position);
    }

    private void openFilmDetails(int id) {


        Intent intent = new Intent(MainActivityProductos.this, DetailsActivity_productos.class);
        Bundle b = new Bundle();
        b.putSerializable("film", myFilms.get(id));
        intent.putExtras(b);

        startActivity(intent);

    }
}
