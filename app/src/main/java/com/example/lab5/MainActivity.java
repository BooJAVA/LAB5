package com.example.lab5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    public String clickedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView list = findViewById(R.id.sarasas);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ricardas Lukasevicius");
        arrayList.add("Tekstas su A ir a raidemis");
        arrayList.add("text without the letters");
        arrayList.add("medismedis medismedis");
        arrayList.add("AaAaa");
        arrayList.add("telefons");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedItem=(String) list.getItemAtPosition(position);
                if(skaiciuotiARaides(clickedItem)>0) atverkFragmenta(new PirmasFragment());
                if(skaiciuotiARaides(clickedItem)==0) atverkFragmenta(new Fragment2());
            }
        });
    }

    private void atverkFragmenta(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putString("aRaides", String.valueOf((skaiciuotiARaides(clickedItem))));
        bundle.putString("zodis", clickedItem);
        fragment.setArguments(bundle);

        FragmentManager fm = getSupportFragmentManager();//

        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack("back");
        fragmentTransaction.commit(); // I
    }

    public int skaiciuotiARaides(String str){
        int charCount = 0;
        char temp;

        for( int i = 0; i < str.length( ); i++ )
        {
            temp = str.charAt( i );

            if( temp == 'a' || temp == 'A')
                charCount++;
        }
        return charCount;
    }
}