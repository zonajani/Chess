package com.example.zonaj.chess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_localGame, btn_multiplayer, btn_help, btn_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        OnClickListeners();
    }

    public void init(){
        btn_localGame = (Button) findViewById(R.id.btn_localGame);
        btn_multiplayer = (Button) findViewById(R.id.btn_multiplayer);
        btn_help = (Button) findViewById(R.id.btn_help);
        btn_exit = (Button) findViewById(R.id.btn_exit);
    }

    public void OnClickListeners() {
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new Intent(MainActivity.this,Help.class);
                startActivity(help);

            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    }

