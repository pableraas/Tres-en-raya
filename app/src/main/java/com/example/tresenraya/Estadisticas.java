package com.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tresenraya.databinding.ActivityEstadisticasBinding;
import com.example.tresenraya.databinding.ActivityPartidaBinding;

public class Estadisticas extends AppCompatActivity {
    private ActivityEstadisticasBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstadisticasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ///////////////////////////////////////////
        //Volver
        ///////////////////////////////////////////
        Intent intent = new Intent(this, MainActivity.class);
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
        ///////////////////////////////////////////
    }
}