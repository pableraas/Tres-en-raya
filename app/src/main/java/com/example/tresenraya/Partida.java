package com.example.tresenraya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tresenraya.databinding.ActivityMainBinding;
import com.example.tresenraya.databinding.ActivityPartidaBinding;

    public class Partida extends AppCompatActivity {

        private ActivityPartidaBinding binding;
        private TresEnRaya juego = new TresEnRaya();
        private int turno = 1;
        boolean ganador1 = false;
        boolean ganador2 = false;

        String jugador1;
        String jugador2;
        String botonPulsado;

        final boolean comienzo = juego.empiezaUsuario1();

        boolean flag2 = true;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityPartidaBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
            Intent intentRecibido = getIntent();
            jugador1 = intentRecibido.getStringExtra("jugador1");
            jugador2 = intentRecibido.getStringExtra("jugador2");
            botonPulsado = intentRecibido.getStringExtra("botonPresionado");
            //if(botonPulsado.equals("boton2"))   {
                //jugadorContraMaquina();
            //}
            ///////////////////////////////////////////
            //Volver
            ///////////////////////////////////////////
            Intent intent = new Intent(this, MainActivity.class);
            binding.button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //intent.putStringArrayListExtra("resultado", datosDevueltos);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
            ///////////////////////////////////////////
            binding.celda1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(0, binding.celda1);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(1, binding.celda2);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(2, binding.celda3);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(3, binding.celda4);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(4, binding.celda5);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(5, binding.celda6);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(6, binding.celda7);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.celda8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(7, binding.celda8);
                    finJuego();
                }
            });
            binding.celda9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    movimiento(8, binding.celda9);
                    finJuego();
                }
            });
            ///////////////////////////////////////////
            binding.button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.tw2.setText("");
                    binding.celda1.setImageDrawable(null);
                    binding.celda2.setImageDrawable(null);
                    binding.celda3.setImageDrawable(null);
                    binding.celda4.setImageDrawable(null);
                    binding.celda5.setImageDrawable(null);
                    binding.celda6.setImageDrawable(null);
                    binding.celda7.setImageDrawable(null);
                    binding.celda8.setImageDrawable(null);
                    binding.celda9.setImageDrawable(null);
                    juego.iniciar();
                }
            });
        }
        public void finJuego()  {
            ganador1 = juego.ganaJugador1();
            ganador2 = juego.ganaJugador2();
            if(!juego.quedanCasillas()) {
                String empate = "EMPATE";
                binding.tw2.setText(empate);
                //return true;
            } else if(ganador1)    {
                String textoGanador = jugador1 + " ha ganado";
                binding.tw2.setText(textoGanador);
               // return true;
            } else if (ganador2) {
                String textoGanador = jugador2 + " ha ganado";
                binding.tw2.setText(textoGanador);
               // return true;
            }
           // return false;
        }
        ///////////////////////////////////////////
        public void movimiento(int pos, ImageView image) {
           // boolean flag = finJuego();
            //if()   {
                if(comienzo)    {
                    if(turno % 2 != 0)    {     //Mueve primero
                        juego.mueveJugador1(pos);
                        image.setImageResource(R.drawable.equis);
                        turno++;

                    } else {                    //Mueve segundo
                        juego.mueveJugador2(pos);
                        image.setImageResource(R.drawable.circulo);
                        turno++;
                    }
                } else {
                    if(turno % 2 != 0)    {     //Mueve primero
                        juego.mueveJugador1(pos);
                        image.setImageResource(R.drawable.circulo);
                        turno++;

                    } else {                    //Mueve segundo
                        juego.mueveJugador2(pos);
                        image.setImageResource(R.drawable.equis);
                        turno++;
                    }
                }
            }
        }
        ///////////////////////////////////////////
        //public void jugadorContraMaquina()  {
        //}

    //}