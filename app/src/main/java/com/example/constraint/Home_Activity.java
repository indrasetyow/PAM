package com.example.constraint;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;

    private ListViewAdapter adapter;
   // private ListViewAdapter adapter;

    SearchView searchview;

    String[] listNama ;
    String[] nomor;

    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    Bundle bundle = new Bundle();
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        searchview = findViewById(R.id.searchbar);


/**
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Home_Activity.this.adapter.getFilter().filter(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Home_Activity.this.adapter.getFilter().filter(newText);
                return false;
            }
        });
*/
        listNama = new String[]{"arip", "fikri","indro", "aan","dika","riska", "dita"};

        nomor = new String[]{"087788789679", "0877887876479","087785689679", "087756565669","0898772476546","0877887874679", "087788789549"};


        list = findViewById(R.id.lisKontak);

        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);

            classNamaArrayList.add(classNama);
        }

        //adapter = new ArrayAdapter<String>(this,R.layout.activity_home, R.id.lisKontak,listNama);
        //adapter = new ArrayAdapter<String>(this,R.layout.activity_home, R.id.lisKontak,listNama);
        adapter = new ListViewAdapter(this);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a", nama.trim());


                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                pm.setOnMenuItemClickListener(Home_Activity.this);

                pm.inflate(R.menu.popup_menu);

                pm.show();
            }


        });

    }
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()){


            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
               Toast.makeText(Home_Activity.this,"nomor telpon",Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
