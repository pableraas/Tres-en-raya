package com.example.tresenraya;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tresenraya.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ActivityResultLauncher<Intent> launcher;
    private ActivityResultLauncher<Intent> launcher2;
    String jugador1;
    String jugador2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        ///////////////////////////////////////////
        //Jugador VS Jugador
        ///////////////////////////////////////////
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                    }
                });
        ///////////////////////////////////////////
        Intent intent1 = new Intent(this, Partida.class);
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jugador1 = binding.editText1.getText().toString();
                jugador2 = binding.editText2.getText().toString();
                intent1.putExtra("jugador1", jugador1);
                intent1.putExtra("jugador2", jugador2);
                intent1.putExtra("botonPresionado", "boton1");
                //intent1.putStringArrayListExtra("datos", listaDatos);
                launcher.launch(intent1);

            }
        });
        ///////////////////////////////////////////
        //Jugador VS Maquina
        ///////////////////////////////////////////
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent1.putExtra("jugador1", jugador1);
                intent1.putExtra("jugador2", jugador2);
                //intent1.putStringArrayListExtra("datos", listaDatos);
                launcher.launch(intent1);
                intent1.putExtra("botonPresionado", "boton2");

            }
        });
        ///////////////////////////////////////////
        //Estaísticas
        ///////////////////////////////////////////
        Intent intent2 = new Intent(this, Estadisticas.class);
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
        ///////////////////////////////////////////
    }
}
