package la.oja.eventify;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {

    private ListView mListViewNoticias;
    private List<Evento> mListaEventos;


    public NoticiasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewFragmento = inflater.inflate(R.layout.fragment_noticias, container, false);

        mListViewNoticias = (ListView) viewFragmento.findViewById(R.id.miListView);

        mListaEventos = new ArrayList<>();

        /**
        * zona de conexion con Backendless
        */
        Backendless.Persistence.of( Evento.class).find( new AsyncCallback<BackendlessCollection<Evento>>(){
            @Override
            public void handleResponse( BackendlessCollection<Evento> listaEventosBack )
            {
                Log.i("MENSAJES","Obtenidos " + listaEventosBack.getCurrentPage().size() + " eventos");

                for(Evento el : listaEventosBack.getCurrentPage()){

                    mListaEventos.add(el);
                }

                mListViewNoticias.setAdapter(new AdaptadorEventos());
            }


            @Override
            public void handleFault( BackendlessFault fault )
            {
                Log.i("MENSAJES","Error num " + fault.getCode());
                // an error has occurred, the error code can be retrieved with fault.getCode()
            }
        });

        mListViewNoticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Evento eventoPresionado = mListaEventos.get(i);
                String enlace = eventoPresionado.getEnlace();
                abrirNavegador(enlace);
            }
        });


        return viewFragmento;
    }

    public void abrirNavegador(String enlace){
        Intent intentNavegador = new Intent(Intent.ACTION_VIEW, Uri.parse(enlace));
        startActivity(intentNavegador);
    }

    private class AdaptadorEventos extends BaseAdapter{

        @Override
        public int getCount() {
            return mListaEventos.size();
        }

        @Override
        public Object getItem(int i) {
            return mListaEventos.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View filaView = getActivity().getLayoutInflater().inflate(R.layout.fila,null);

            Evento nuevoEvento = mListaEventos.get(i);

            TextView tvFila = (TextView) filaView.findViewById(R.id.textView);
            tvFila.setText(nuevoEvento.getTitulo());

            ImageView imageViewFila = (ImageView) filaView.findViewById(R.id.imageViewNoticia);
            Picasso.with(getActivity()).load(nuevoEvento.getEnlaceImagen()).into(imageViewFila);

            return filaView;
        }
    }

}
