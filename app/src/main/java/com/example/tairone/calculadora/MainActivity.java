package com.example.tairone.calculadora;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    boolean decimal = false;
    boolean soma = false;
    boolean sub = false;
    boolean mult = false;
    boolean div = false;
    boolean igual = false;
    boolean raiz = false;
    boolean apaga = false;
    boolean raizcub = false;
    Double[] numero = new Double[10];
    Double resultado = 0.0;
    Double respar = 0.0;
    Double M = null;
    int i =0;
    NumberFormat format = new DecimalFormat(".####"); //numero de casas decimais aceitas apos a virgula

    private Button btclear, btapaga, btsair, btmen, btraiz, btporcen, btraizcub, btigual,  btsoma, btsub, btmult, btdiv,btponto;
    private Button btzero, btum, btdois, bttres, btquatro, btcinco, btseis, btsete, btoito, btnove;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btzero = (Button)findViewById(R.id.btzero);
        btzero.setOnClickListener(this);
        btum = (Button)findViewById(R.id.btum);
        btum.setOnClickListener(this);
        btdois = (Button)findViewById(R.id.btdois);
        btdois.setOnClickListener(this);
        bttres = (Button)findViewById(R.id.bttres);
        bttres.setOnClickListener(this);
        btquatro = (Button)findViewById(R.id.btquatro);
        btquatro.setOnClickListener(this);
        btcinco = (Button)findViewById(R.id.btcinco);
        btcinco.setOnClickListener(this);
        btseis = (Button)findViewById(R.id.btseis);
        btseis.setOnClickListener(this);
        btsete = (Button)findViewById(R.id.btsete);
        btsete.setOnClickListener(this);
        btoito = (Button)findViewById(R.id.btoito);
        btoito.setOnClickListener(this);
        btnove = (Button)findViewById(R.id.btnove);
        btnove.setOnClickListener(this);

        btponto = (Button)findViewById(R.id.btponto);
        btponto.setOnClickListener(this);

        btsoma = (Button)findViewById(R.id.btsoma);
        btsoma.setOnClickListener(this);
        btsub = (Button)findViewById(R.id.btsub);
        btsub.setOnClickListener(this);
        btmult = (Button)findViewById(R.id.btmult);
        btmult.setOnClickListener(this);
        btdiv = (Button)findViewById(R.id.btdiv);
        btdiv.setOnClickListener(this);
        btigual = (Button)findViewById(R.id.btigual);
        btigual.setOnClickListener(this);

        btclear = (Button)findViewById(R.id.btclear);
        btclear.setOnClickListener(this);
        btapaga = (Button)findViewById(R.id.btapaga);
        btapaga.setOnClickListener(this);
        btsair = (Button)findViewById(R.id.btsair);
        btsair.setOnClickListener(this);

        btmen = (Button)findViewById(R.id.btmen);
        btmen.setOnClickListener(this);
        btraiz = (Button)findViewById(R.id.btraiz);
        btraiz.setOnClickListener(this);
        btraizcub = (Button)findViewById(R.id.btraizbub);
        btraizcub.setOnClickListener(this);
        btporcen = (Button)findViewById(R.id.btporcen);
        btporcen.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView display = (TextView)findViewById(R.id.txres);
        TextView displaycalc = (TextView)findViewById(R.id.txcalcs);
        TextView displaym = (TextView)findViewById(R.id.txm);
           int selecionado = v.getId();
           String a = display.getText().toString();
           AlertDialog.Builder alert = new AlertDialog.Builder(this);

        try {
            switch (selecionado) {
                case R.id.btzero:
                    display.setText(a+"0");
                    break;
                case R.id.btum:
                    display.setText(a+"1");
                    break;
                case R.id.btdois:
                    display.setText(a+"2");
                    break;
                case R.id.bttres:
                    display.setText(a+"3");
                    break;
                case R.id.btquatro:
                    display.setText(a+"4");
                    break;
                case R.id.btcinco:
                    display.setText(a+"5");
                    break;
                case R.id.btseis:
                    display.setText(a+"6");
                    break;
                case R.id.btsete:
                    display.setText(a+"7");
                    break;
                case R.id.btoito:
                    display.setText(a+"8");
                    break;
                case R.id.btnove:
                    display.setText(a+"9");
                    break;
                case R.id.btponto:
                    if (decimal == false) {
                         display.setText(a+".");
                         decimal = true;
                    }else{return;}
                    break;
                case R.id.btsoma:
                    soma = true;
                    decimal = false;
                    if(numero[0] == null){
                        numero[0] = Double.parseDouble(a);
                            if (numero[0]==numero[0].intValue()){
                                displaycalc.setText(String.valueOf(Integer.parseInt(a)));
                                display.setText(" ");
                                alert.setMessage(a);
                            }
                            if(numero[0]!=numero[0].intValue()){
                                displaycalc.setText(format.format(numero[0]));
                                display.setText(" ");
                            }
                    }
                    else if(numero[0] != null){
                        numero[1] = Double.parseDouble(a);
                        respar = numero[0] + numero[1];
                            if(respar==respar.intValue()){
                                displaycalc.setText(String.valueOf(respar.intValue()));
                                display.setText(" ");
                            }
                            if(respar!=respar.intValue()){
                                displaycalc.setText(format.format(respar));
                                display.setText(" ");
                            }
                        numero[0] = respar;
                        respar = null;
                    }
                   break;
                case R.id.btsub:
                     break;
                case R.id.btmult:
                    mult = true;
                    decimal = false;
                    numero[0] = Double.parseDouble(a);
                    displaycalc.setText(a+"*");
                    display.setText(" ");
                    break;
                case R.id.btdiv:
                    div = true;
                    decimal = false;
                    numero[0] = Double.parseDouble(a);
                    displaycalc.setText(a+"/");
                    display.setText(null);
                    break;
                case R.id.btclear:
                    display.setText(null);
                    displaycalc.setText(null);
                    respar = null;
                    resultado = null;
                    numero[0] = null;
                    numero[1] = null;
                    decimal = false;
                    soma = false;
                    sub = false;
                    igual = false;
                    mult = false;
                    div = false;
                    raiz = false;
                    raizcub = false;
                    apaga = false;
                    break;
                case R.id.btapaga:
                    apaga = true;
                    char d = '.';
                    for(i=0;i< a.length();i++){
                        if(a.charAt(i) == d){
                            decimal = false;
                        }
                    }
                    if(a.length() > 0) {
                           a = a.substring(0, a.length() - 1);
                           if (a.length() != 0) {
                               display.setText(a.toString());
                           } else {
                               display.setText(null);
                           }
                    }
                    break;
                case R.id.btsair:
                      finish();
                      System.exit(0);
                      break;
                case R.id.btmen:
                    //não esta retornando o valor de M
                    if (M == null || M == 0.0) {
                          if(resultado != 0.0 || resultado != null) {
                             M = resultado;
                             displaym.setText("M");
                              display.setText(" ");
                          }else if(resultado == 0.0 || resultado == null){
                              M = Double.parseDouble(a);
                              displaym.setText("M");
                              display.setText(" ");
                          }
                    }else if(M!=null){
                          if(M == M.intValue()){
                              display.setText(M.intValue());
                              displaym.setText(" ");
                              M = null;
                          }else if(M != M.intValue()){
                              display.setText(M.toString());
                              displaym.setText(" ");
                              M = null;
                          }
                    }
                      break;
                case R.id.btraiz:
                    raiz = true;
                    numero[0] = Double.parseDouble(a);
                    displaycalc.setText("Raiz "+String.valueOf(numero[0]));
                    resultado = Math.sqrt(numero[0]);
                    break;
                case R.id.btporcen:
                    display.setText(a+"%");
                    break;
                case R.id.btraizbub:
                    raizcub = true;
                    numero[0] = Double.parseDouble(a);
                    displaycalc.setText("Raiz "+String.valueOf(numero[0]));
                    resultado = Math.cbrt(numero[0]);
                    break;
                case R.id.btigual:
                    numero[1] = Double.parseDouble(a);
                          if(soma == true){
                               resultado = numero[0] + numero[1];
                               if(resultado == resultado.intValue()){
                                      displaycalc.setText(null);
                                      display.setText(String.valueOf(resultado.intValue()));
                               }else{
                                     displaycalc.setText(null);
                                     display.setText(String.valueOf(resultado));
                                    }
                          }else if(sub == true){
                               resultado = numero[0] - numero[1];
                                   if(resultado == resultado.intValue()){
                                         displaycalc.setText(null);
                                         display.setText(String.valueOf(resultado.intValue()));
                                   }else{
                                        displaycalc.setText(null);
                                        display.setText(String.valueOf(resultado));
                                       }
                          }else if(mult == true){
                                 resultado = numero[0] * numero[1];
                                    if(resultado == resultado.intValue()){
                                        displaycalc.setText(null);
                                        display.setText(String.valueOf(resultado.intValue()));
                                    }else{
                                        displaycalc.setText(null);
                                        display.setText(String.valueOf(resultado));
                                    }
                          }else if(div == true) {
                                 resultado = numero[0] / numero[1];
                                    if (resultado == resultado.intValue()) {
                                        displaycalc.setText(null);
                                        display.setText(String.valueOf(resultado.intValue()));
                                    }else {
                                        displaycalc.setText(null);
                                        display.setText(String.valueOf(resultado));
                                    }
                          }else if(raiz == true) {
                              if (resultado == resultado.intValue()) {
                                  displaycalc.setText(null);
                                  display.setText(String.valueOf(resultado.intValue()));
                              } else {
                                  displaycalc.setText(null);
                                  display.setText(String.valueOf(resultado));
                              }
                          }
                   // }
                    decimal = false;
                    soma = false;
                    sub = false;
                    mult = false;
                    div = false;
                    apaga = false;
                    numero[0] = 0.0;
                    numero[1] = 0.0;
                    resultado = 0.0;
                    respar = 0.0;
                    break;
            }
        }catch (Exception e){
            for(i=0; i<10;i++){

                display.setText("ERROR!!");
            }
            display.setText(" ");

        }
    }
}