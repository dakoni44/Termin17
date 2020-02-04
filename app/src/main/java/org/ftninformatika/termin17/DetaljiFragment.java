package org.ftninformatika.termin17;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetaljiFragment extends Fragment {

    private TextView tvName;
    private String name=null;

    public DetaljiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalji, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName=view.findViewById(R.id.tvName);
        if(name!=null){
            tvName.setText(name);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateName(String name){
        setName(name);
        tvName.setText(name);
    }
}
