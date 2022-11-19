package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Salario;
    TextView SalarioFinal;
    Button Guardar;
    ImageButton Gasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Salario = findViewById(R.id.Registro_salario);
        SalarioFinal = findViewById(R.id.TV_SalarioFinal);
        Guardar = findViewById(R.id.Btn_Guardar);
        Gasto = findViewById(R.id.Btn_Nuevo);
        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Salario.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor Ingresa el salario", Toast.LENGTH_SHORT).show();
                } else{
                    int salario = Integer.parseInt(Salario.getText().toString());
                    SalarioFinal.setText(salario);
                }
            }
        });
        Gasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
            }
        });


    }
}