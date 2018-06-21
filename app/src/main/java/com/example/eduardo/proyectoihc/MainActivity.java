package com.example.eduardo.proyectoihc;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.eduardo.proyectoihc.adapters.RecyclerView_adapterdirectory;
import com.example.eduardo.proyectoihc.objects.fundation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView_fundations;
    private RecyclerView_adapterdirectory adapter_fundation;
    private FloatingActionButton f_butron_add, f_buttom_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        recyclerView_fundations=(RecyclerView)findViewById(R.id.recyclerView_fundation);
        recyclerView_fundations.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));


        adapter_fundation= new RecyclerView_adapterdirectory(obtener_fundaciones());
        recyclerView_fundations.setAdapter(adapter_fundation);

        f_buttom_search=(FloatingActionButton)findViewById(R.id.floating_Search);
        f_butron_add=(FloatingActionButton)findViewById(R.id.floating_plus);

        recyclerView_fundations.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0 && f_butron_add.getVisibility() == View.VISIBLE){
                    f_butron_add.hide();
                    f_buttom_search.hide();
                }else if(dy < 0 && f_butron_add.getVisibility() != View.VISIBLE){
                    f_butron_add.show();
                    f_buttom_search.show();
                }
            }
        });
    }


    public List<fundation> obtener_fundaciones(){
        List<fundation> fundations= new ArrayList<>();
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));
        fundations.add(new fundation("Fundacion SA","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1"));

        return fundations;
    }
}
