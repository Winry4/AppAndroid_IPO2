package srinternet.pelisapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rebeca on 21/05/2018.
 */

public class ListaAdapter extends BaseAdapter{
    private List<Peliculas> listaPelis;
    GridView gridView;
    private LayoutInflater inflater;
    Activity a;
    Context c;
    private int j;
    private float firstTouchX, lasttouch;
    static final int MIN_DISTANCE = 150;

    public ListaAdapter(List<Peliculas> listaPelis, Activity a, Context c) {
        this.listaPelis = listaPelis;
        this.a=a;
        this.c=c;
    }

    @Override
    public int getCount() {
       return listaPelis.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater==null){
            inflater=(LayoutInflater)a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view==null){
            view=inflater.inflate(R.layout.lista_pelis,null);
        }
        RelativeLayout relativeLayout=(RelativeLayout) inflater.inflate(R.layout.activity_main,null);
        gridView=(GridView)relativeLayout.findViewById(R.id.ListaPelis);

        final ImageView image = (ImageView) view.findViewById(R.id.fotoPeli);
        TextView nombre=(TextView) view.findViewById(R.id.titulo);
        TextView duracion=(TextView) view.findViewById(R.id.duracion);
        ImageView estrella1=(ImageView)view.findViewById(R.id.estrella1);
        ImageView estrella2=(ImageView)view.findViewById(R.id.estrella2);
        ImageView estrella3=(ImageView)view.findViewById(R.id.estrella3);
        ImageView estrella4=(ImageView)view.findViewById(R.id.estrella4);
        ImageView estrella5=(ImageView)view.findViewById(R.id.estrella5);

        final Peliculas la=listaPelis.get(i);

        //image.setImageBitmap(la.getImagen());
        nombre.setText(la.getNombre());
        duracion.setText(la.getDuracion());

        switch (la.getValoración()){
            case 0:
                estrella1.setImageResource(R.drawable.estrella0);
                estrella2.setImageResource(R.drawable.estrella0);
                estrella3.setImageResource(R.drawable.estrella0);
                estrella4.setImageResource(R.drawable.estrella0);
                estrella5.setImageResource(R.drawable.estrella0);
                break;
            case 1:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella0);
                estrella3.setImageResource(R.drawable.estrella0);
                estrella4.setImageResource(R.drawable.estrella0);
                estrella5.setImageResource(R.drawable.estrella0);
                break;
            case 2:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                estrella3.setImageResource(R.drawable.estrella0);
                estrella4.setImageResource(R.drawable.estrella0);
                estrella5.setImageResource(R.drawable.estrella0);
                break;
            case 3:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                estrella3.setImageResource(R.drawable.estrella);
                estrella4.setImageResource(R.drawable.estrella0);
                estrella5.setImageResource(R.drawable.estrella0);
                break;
            case 4:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                estrella3.setImageResource(R.drawable.estrella);
                estrella4.setImageResource(R.drawable.estrella);
                estrella5.setImageResource(R.drawable.estrella0);
                break;
            case 5:
                estrella1.setImageResource(R.drawable.estrella);
                estrella2.setImageResource(R.drawable.estrella);
                estrella3.setImageResource(R.drawable.estrella);
                estrella4.setImageResource(R.drawable.estrella);
                estrella5.setImageResource(R.drawable.estrella);
                break;
        }
        final boolean [] irvolver= new boolean[Memoria.ListaPeliculas.size()];
        for(int o=0;o<irvolver.length;o++){
            irvolver[o]=true;
        }
        final View vi = view;
        RelativeLayout r=(RelativeLayout) view.findViewById(R.id.RelativeItem);
        r.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                        j = event.getActionIndex();
                        //Aqui guardas en una variable privada de clase las coordenadas del primer toque:
                        firstTouchX = event.getX();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        lasttouch = event.getX();
                        if (Math.abs(lasttouch - firstTouchX) > MIN_DISTANCE) {
                            //Hacia la izquierda
                            if (irvolver[j]) {
                                Animation slide = AnimationUtils.loadAnimation(c, R.anim.translate);
                                RelativeLayout l1 = (RelativeLayout) v.findViewById(R.id.RelativeItem);
                                ImageView cancelar = (ImageView) vi.findViewById(R.id.eliminar);
                                l1.startAnimation(slide);
                                cancelar.setVisibility(View.VISIBLE);
                                irvolver[j] = false;
                            }

                        }else{
                            if(irvolver[j]==false) {
                                Animation slide = AnimationUtils.loadAnimation(c, R.anim.translate2);
                                RelativeLayout l1 = (RelativeLayout) v.findViewById(R.id.RelativeItem);
                                ImageView cancelar = (ImageView) vi.findViewById(R.id.eliminar);
                                l1.startAnimation(slide);
                                cancelar.setVisibility(View.INVISIBLE);
                                irvolver[j] = true;
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        lasttouch = event.getX();
                        if (Math.abs(lasttouch - firstTouchX) > MIN_DISTANCE) {
                            //Hacia la izquierda
                            if (irvolver[j]) {
                                Animation slide = AnimationUtils.loadAnimation(c, R.anim.translate);
                                RelativeLayout l1 = (RelativeLayout) v.findViewById(R.id.RelativeItem);
                                ImageView cancelar = (ImageView) vi.findViewById(R.id.eliminar);
                                l1.startAnimation(slide);
                                cancelar.setVisibility(View.VISIBLE);
                                irvolver[j] = false;
                            }

                        }else{
                            if(irvolver[j]==false) {
                                Animation slide = AnimationUtils.loadAnimation(c, R.anim.translate2);
                                RelativeLayout l1 = (RelativeLayout) v.findViewById(R.id.RelativeItem);
                                ImageView cancelar = (ImageView) vi.findViewById(R.id.eliminar);
                                l1.startAnimation(slide);
                                cancelar.setVisibility(View.INVISIBLE);
                                irvolver[j] = true;
                            }
                        }
                        break;

                }
                return true;
            }

        });
        return view;
    }
    public Bitmap redimensionarImagenMaximo(Bitmap mBitmap, float newWidth, float newHeigth){
        //Redimensionamos
        int width = mBitmap.getWidth();
        int height = mBitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeigth) / height;
        // create a matrix for the manipulation
        Matrix matrix = new Matrix();
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);
        // recreate the new Bitmap
        return Bitmap.createBitmap(mBitmap, 0, 0, width, height, matrix, false);
    }
}
