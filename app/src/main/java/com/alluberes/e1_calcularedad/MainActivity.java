package com.alluberes.e1_calcularedad;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private EditText nombre_persona;
    private DatePicker date_of_birth;
    private Button  calcular_edad;
    private EditText edad_actual;
    private TextView resultado;





    int diaA =0, mesA=0, anoA =0;
    int ano=0, mes=0, dia= 0 ;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre_persona = (EditText) findViewById(R.id.edt_nombre_persona);
        date_of_birth = (DatePicker) findViewById(R.id.edt_date_of_birth);
        calcular_edad = (Button) findViewById(R.id.btn_calcular_edad);
        edad_actual = (EditText) findViewById(R.id.edt_edad_actual);
        resultado = (TextView) findViewById(R.id.tvresultado);





        calcular_edad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dato();

            }
        });
    }

    private void Dato() {

        Calendar ca = Calendar.getInstance();
        ano = ca.get(Calendar.YEAR);
        mes = ca.get(Calendar.MONTH);
        dia = ca.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                edad_actual.setText(year + month+ day);
              calcular(year,month,day);

            }
        },ano,mes,dia);
        datePickerDialog.show();
    }

    private void calcular(int yearN, int monthN, int dayN) {




        Calendar ca = Calendar.getInstance();
        anoA = ca.get(Calendar.YEAR);
        mesA = ca.get(Calendar.MONTH);
        diaA = ca.get(Calendar.DAY_OF_MONTH);

        int edad = anoA- yearN;
        if(monthN > mesA){
            edad--;

        } else if (mesA == monthN){

            if (dayN> diaA){
                edad--;
            }
        }
        edad_actual.setText(nombre_persona + "tiene" + edad +"años de edad");


    }


    }




























