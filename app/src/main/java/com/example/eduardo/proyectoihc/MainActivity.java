package com.example.eduardo.proyectoihc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    base sqlh;
    SQLiteDatabase db;
    String nomb="",dir="",tel="",desc="",tipo="";

    private RecyclerView recyclerView_fundations;
    private RecyclerView_adapterdirectory adapter_fundation;
    private FloatingActionButton f_button_add;
    //private FloatingActionButton f_button_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.consutlta();

        recyclerView_fundations=(RecyclerView)findViewById(R.id.recyclerView_fundation);
        recyclerView_fundations.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));


        adapter_fundation= new RecyclerView_adapterdirectory(obtener_fundaciones(nomb, dir,  tel, desc,  tipo));
        recyclerView_fundations.setAdapter(adapter_fundation);

        //f_buttom_search=(FloatingActionButton)findViewById(R.id.floating_Search);
        f_button_add=(FloatingActionButton)findViewById(R.id.floating_plus);

        recyclerView_fundations.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0 && f_button_add.getVisibility() == View.VISIBLE){
                    f_button_add.hide();
                    //f_buttom_search.hide();
                }else if(dy < 0 && f_button_add.getVisibility() != View.VISIBLE){
                    f_button_add.show();
                    //f_buttom_search.show();
                }
            }
        });



        f_button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this,"añadir", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,add_fundtion.class);
                startActivity(intent);
            }
        });

    }

    public void consutlta(){
        sqlh = new base(this, "dbinstitucion", null, 1);
        db = sqlh.getWritableDatabase();
        Cursor c = db.rawQuery("select * from institucion ",null);

        Byte img;
        if(c.moveToFirst()){
            do{
                nomb=c.getString(c.getColumnIndex("nombre"));
                dir=c.getString(c.getColumnIndex("direccion"));
                tel=c.getString(c.getColumnIndex("telefono"));
                desc=c.getString(c.getColumnIndex("descripcion"));
                tipo=c.getString(c.getColumnIndex("tipo"));
                obtener_fundaciones(nomb,dir,tel,desc,tipo);


            }while (c.moveToNext());
        }
    }

    public List<fundation> obtener_fundaciones(String nomb, String dir, String tel, String desc, String tipo){
        List<fundation> fundations= new ArrayList<>();
        fundations.add(new fundation(nomb,dir,tel,desc,tipo));
        return fundations;
    }
    /*public List<fundation> obtener_fundaciones(String nomb, String dir, String tel, String desc, String tipo){
        List<fundation> fundations= new ArrayList<>();
        fundations.add(new fundation("Fundacion SA1","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA2","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA3","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA4","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA5","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA6","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        fundations.add(new fundation("Fundacion SA7","Fundacion dedicada a ayudar a jovenes con discapacidad visual auditiva que deseen aprender a leer y escribir en braille","1.1","01 222 229 5500 Ext 7390","Solo Mujeres","Av. San Claudio y 14 Sur 72592 Puebla de Zaragoza"));
        return fundations;
    }*/
}
