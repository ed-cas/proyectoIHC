package com.example.eduardo.proyectoihc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eduardo.proyectoihc.objects.fundation;

import org.w3c.dom.Text;

public class details_fundation extends AppCompatActivity {

    private TextView namefundation;
    private ImageView img_fundation;
    private TextView fundation_type;
    private TextView fundation_description;
    private TextView telephone;
    private TextView fundation_direction;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details_fundation);
        getSupportActionBar().hide();

        namefundation=(TextView) findViewById(R.id.namefundation);
        img_fundation=(ImageView)findViewById(R.id.img_fundation);
        fundation_type=(TextView) findViewById(R.id.fundation_type);
        fundation_description=(TextView)findViewById(R.id.fundation_description);
        telephone=(TextView)findViewById(R.id.telephone);
        fundation_direction=(TextView)findViewById(R.id.fundation_direction);

        Bundle b=this.getIntent().getExtras();
        if(b != null){
            fundation f= (fundation) b.get("object");
            namefundation.setText(f.getTitle());
            //img_fundation=
            fundation_type.setText(f.getType());  ///a;adir a interfaz en xml de este msimo layout
            fundation_description.setText(f.getDescription());
            telephone.setText(f.getTelephone());
            fundation_direction.setText(f.getDirection());

            //Toast.makeText(getApplicationContext(),f.getTitle()+f.getDescription(),Toast.LENGTH_SHORT).show();
        }

    }
}
