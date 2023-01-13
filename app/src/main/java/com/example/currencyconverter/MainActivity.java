package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton delete, delete_all, replace, divide, seven, eight, nine, six, five, four,
    three, two, one, zero, comma, plus, minus, multiply, equals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer sound = MediaPlayer.create(this, R.raw.calculator_button_press_single_002_11984);
        MaterialButton playsound = (MaterialButton) this.findViewById(R.id.divide);
        playsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound.start();
            }
        });
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
    }
}
