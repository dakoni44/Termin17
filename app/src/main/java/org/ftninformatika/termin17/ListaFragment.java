package org.ftninformatika.termin17;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.jar.Attributes;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    private ListView lvLista;
    private List<String> data;
    private OnNameClickListener listener= null;


    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnNameClickListener)context;
        }catch (ClassCastException e){
            Toast.makeText(context,"Implementiraj interfejs",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvLista=view.findViewById(R.id.lvLista);
        data=NamesProvider.getName();
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,data);
        lvLista.setAdapter(adapter);
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(listener!=null) {
                    listener.onNameClicked(data.get(position));
                }
            }
        });
    }

    public interface OnNameClickListener {
        void onNameClicked(String name);
    }
}
