package org.ftninformatika.termin17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListaFragment.OnNameClickListener {

    private boolean isLandscape=false;
    private DetaljiFragment detaljiFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList();
        if(findViewById(R.id.flDetail)!=null){
            isLandscape=true;
            detaljiFragment=new DetaljiFragment();
            detaljiFragment.setName(NamesProvider.getName().get(0));
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flDetail,detaljiFragment);
            transaction.commit();
        }
    }

    private void showList(){
        ListaFragment fragment=new ListaFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFrame,fragment);
        transaction.commit();
    }

    private void showName(String name){
        //Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
        if(isLandscape){
            detaljiFragment.updateName(name);
        }else {
            DetaljiFragment fragment = new DetaljiFragment();
            fragment.setName(name);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flFrame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    @Override
    public void onNameClicked(String name) {
        showName(name);
    }
}
