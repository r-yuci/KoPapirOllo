package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonKo, buttonPapir, buttonOllo;
    private ImageView imageViewTeValasztasod, imageViewGepValasztasa;
    private TextView textViewEmberSzamlalo, textViewComputerSzamlalo;
    private Random random;
    private ArrayList computerJateka;
    private int sorsolas, enPontok, gepPontok;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        enPontok = 0;
        gepPontok =0;
        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewTeValasztasod.setImageResource(R.drawable.rock);
                computerJateka();

                if(sorsolas == 1){
                    gepPontok++;
                    textViewComputerSzamlalo.setText(String.valueOf(gepPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört a gép nyerte", Toast.LENGTH_SHORT).show();
                }
                if(sorsolas == 2){
                    enPontok++;
                    textViewEmberSzamlalo.setText(String.valueOf(enPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewTeValasztasod.setImageResource(R.drawable.paper);
                computerJateka();

                if(sorsolas == 0){
                    enPontok++;
                    textViewEmberSzamlalo.setText(String.valueOf(enPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                }
                if(sorsolas == 2){
                    gepPontok++;
                    textViewComputerSzamlalo.setText(String.valueOf(gepPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört a gép nyerte", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewTeValasztasod.setImageResource(R.drawable.scissors);
                computerJateka();

                if(sorsolas == 0){
                    gepPontok++;
                    textViewComputerSzamlalo.setText(String.valueOf(gepPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört a gép nyerte", Toast.LENGTH_SHORT).show();
                }
                if(sorsolas == 1){
                    enPontok++;
                    textViewEmberSzamlalo.setText(String.valueOf(enPontok));
                    Toast.makeText(MainActivity.this, "Ezt a kört te nyerted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void init(){

        buttonKo = findViewById(R.id.buttonKo);
        buttonOllo = findViewById(R.id.buttonOllo);
        buttonPapir = findViewById(R.id.buttonPapir);
        imageViewTeValasztasod = findViewById(R.id.imageViewTeValasztasod);
        imageViewGepValasztasa = findViewById(R.id.imageViewGepvalasztasa);
        textViewEmberSzamlalo = findViewById(R.id.textViewEmberSzamlalo);
        textViewComputerSzamlalo = findViewById(R.id.textViewComputerSzamlalo);
        alertDialog();



    }

    private void computerJateka(){
        ArrayList<Integer> computerJateka = new ArrayList<Integer>();
        computerJateka.add(R.drawable.rock);
        computerJateka.add(R.drawable.paper);
        computerJateka.add(R.drawable.scissors);
        sorsolas = (int) (Math.random()*computerJateka.size());
        imageViewGepValasztasa.setImageResource(computerJateka.get(sorsolas));
    }

    private void alertDialog(){
        if(textViewEmberSzamlalo.equals("3")){
            alertDialog = new AlertDialog.Builder(MainActivity.this);
            alertDialog.setTitle("Nyertél!");
            alertDialog.setMessage("Szeretnél új játékot?");
            alertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    textViewComputerSzamlalo.setText("0");
                    textViewEmberSzamlalo.setText("0");
                }
            });
            alertDialog.create();
            alertDialog.show();
        }
    }
}