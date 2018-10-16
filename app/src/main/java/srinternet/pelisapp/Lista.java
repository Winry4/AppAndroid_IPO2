package srinternet.pelisapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

public class Lista extends AppCompatActivity {
    GridView gridView;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        mTextMessage = (TextView) findViewById(R.id.message);
        Memoria.ListaPeliculas.clear();


        Peliculas p=new Peliculas("Deadpool2", "120min", 4);
        Peliculas p2=new Peliculas("Infinity War", "125 min",5);
        Peliculas p3=new Peliculas("sharknado", "100min", 0);
        Memoria.ListaPeliculas.add(p);
        Memoria.ListaPeliculas.add(p2);
        Memoria.ListaPeliculas.add(p3);
        Memoria.ListaPeliculas.clear();

        ListaAdapter listaAdapter = new ListaAdapter(Memoria.ListaPeliculas, this, this.getBaseContext());
        gridView = (GridView) findViewById(R.id.ListaPelis);
        gridView.setAdapter(listaAdapter);
        listaAdapter.notifyDataSetChanged();
    }
    protected void onPostExecute(String s){
        ListaAdapter listaAdapter = new ListaAdapter(Memoria.ListaPeliculas, this, this.getBaseContext());
    }

}
