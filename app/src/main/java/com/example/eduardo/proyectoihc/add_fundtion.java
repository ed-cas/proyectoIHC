package com.example.eduardo.proyectoihc;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class add_fundtion extends AppCompatActivity {

    base sqlh;
    SQLiteDatabase db;
    EditText edit_name, edit_description,edit_direction,edit_telephone,edit_discapacidad;
    ImageView image_preview;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_fundtion);
        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_description = (EditText)findViewById(R.id.edit_description);
        edit_direction = (EditText)findViewById(R.id.edit_direction);
        edit_telephone = (EditText)findViewById(R.id.edit_telephone);
        edit_discapacidad = (EditText)findViewById(R.id.edit_discapacidad);
        image_preview = (ImageView)findViewById(R.id.image_preview);
        btn1 = (Button)findViewById(R.id.btn1);
        getSupportActionBar().hide();
    }

    public void add(){

        //(id INTEGER not null primary key autoincrement, nombre TEXT, direccion TEXT, telefono TEXT, descripcion TEXT, tipo TEXT, img BLOB)";

        sqlh = new base(this,"dbinstitucion", null,1);
        db = sqlh.getReadableDatabase();
        db.execSQL("INSERT INTO institucion(nombre, direccion, telefono, descripcion, tipo) values('" +edit_name.getText().toString()+ "','" + edit_direction.getText().toString() +"','"+edit_telephone.getText().toString()+"','"+edit_description.getText().toString()+ "','"+edit_discapacidad.getText().toString()+"')");
    }
}
