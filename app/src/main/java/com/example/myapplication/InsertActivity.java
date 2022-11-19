package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;

public class InsertActivity extends AppCompatActivity implements InsertActivityValues {
    Context contexto;
    EditText costo, descripcion;
    Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        costo = findViewById(R.id.Costo);
        descripcion = findViewById(R.id.Detalle);
        registrar = findViewById(R.id.Btn_Registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataActivity administrator = new DataActivity(InsertActivity.this, "DataBase", null, 1);
                SQLiteDatabase DataBase = administrator.getWritableDatabase();
                String valor = costo.getText().toString();
                String detalle = descripcion.getText().toString();
                if (valor.isEmpty() || detalle.isEmpty()){
                    Toast.makeText(InsertActivity.this, "Por favor llene ambos campos", Toast.LENGTH_SHORT).show();
                }else{
                    ContentValues register = new ContentValues();
                    int cost = Integer.parseInt(valor);
                    register.put("valor", cost);
                    register.put("detalle", detalle);
                    DataBase.insert("gastos", null, register);
                    DataBase.close();
                    costo.setText("");
                    descripcion.setText("");
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    LayoutInflater inflater;
    public  InsertActivity (Context contexto, EditText cost, EditText Description){
        this.contexto = contexto;
        this.costo= cost;
        this.descripcion = Description;
        inflater = LayoutInflater.from(contexto);
    }
    @Override
    public int getCount() {
        return costo.getLineCount();
    }

    @Override
    public Object getItem(int i) {return null;}

    @Override
    public long getItemId(int i) {return 0;}

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_main, null);
        TextView valor = view.findViewById(R.id.valor);
        TextView titulo = view.findViewById(R.id.titulo);
        TextView hora = view.findViewById(R.id.tv_fecha);
        return view;
    }
}
