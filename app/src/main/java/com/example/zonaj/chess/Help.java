package com.example.zonaj.chess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class Help extends AppCompatActivity {

    private Button btn_helpBack;
    private TextView txtV_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        init();
        OnClickListeners();
    }

    public void init() {
        txtV_help = (TextView) findViewById(R.id.txtV_help);
        btn_helpBack = (Button) findViewById(R.id.btn_helpBack);

        txtV_help.setMovementMethod(new ScrollingMovementMethod());
        //btn_helpBack.setMovementMethod(new ScrollingMovementMethod());
        txtV_help.setText("Sakk szabályok\n" +
                "\n" +
                "Alapok\n" +
                "A sakkot két játékos játsza egymás ellen. Egyik játékos a sötét, a másik a világos bábukat irányítja. Mindkét játékosnak 16 bábuja van kezdésnél: egy király, egy királynõ, két bástya, két futó, két huszár és nyolc gyalog.\n" +
                "\n" +
                "A játék célja\n" +
                "A játék célja, hogy az ellenfél királyát olyan helyzetbe kényszerítse, melyben az meg van támadva és ez a támadás az ellenfél semmilyen következõ szabályos lépésével sem hárítható. Az a játékos amelyik ezt eléri, \"bemattolja\" ellenfelét, és ezzel megnyeri a játszmát. Az ellenfél, aki a mattot kapta, elvesztette a játszmát.\n" +
                "\n" +
                "A játék kezdete\n" +
                "A játékot az alábbi ábra alapján felálított 8x8-as sakktáblán kezdjük. A világos bábukat irányító játékos lép elõször, ezt követõen a játékosok feltváltva lépnek.\n" +
                "\n" +
                "A játék menete\n" +
                "A lépés azt jelenti, hogy az egyik saját bábunkat egy másik mezõre helyezzük a bábok menetmódjának megfelelõen. \n" +
                "Egyetlen bábbal sem léphetünk olyan mezõre, melyen ugyanolyan színû báb áll mint amelyikkel lépni szeretnénk. Ha olyan mezõre lépünk, melyet ellentétes színû foglalt addig el, akkor azt leütjük és ugyanazon lépés részeként eltávolítjuk a sakktábláról.\n" +
                "\n" +
                "Sakk\n" +
                "Akkor mondjuk hogy a király sakkban van, ha az egy vagy több ellenséges báb által támadva van, még akkor is, ha ezek a bábok nem tudnak lépni. Olyan lépést tilos tenni, mely a királyt sakkba helyezi, vagy sakkban hagyja. A sakk elhárításának három módja:\n" +
                "A sakkadó báb leütése\n" +
                "A sakkadó báb és a király közé egy másik bábu helyezése, blokkolás (megj.: huszárt nem tudunk blokkolni)\n" +
                "A királlyal egy meg nem támadott mezõre lépünk.\n" +
                "\n" +
                "Matt\n" +
                "A sakk játék célja az ellenfél mattolása. Ha a játékos nem tudja a király támadását elháratani, mattot kapott, és a játszmának azonnal vége a matott adó játékos gyõzelmével.\n" +
                "\n" +
                "Patt\n" +
                "A játszma döntetlen, ha a soron következo játékos nem tud szabályos lépst tenni, de a királya nem áll sakban. Ezt nevezzük patt-nak. A játszmának ebben az esetben is azzonal vége döntetlen eredménnyel."
        );
    }

    public void OnClickListeners() {
        btn_helpBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpBack = new Intent(Help.this, MainActivity.class);
                startActivity(helpBack);
                finish();

            }
        });
    }
}