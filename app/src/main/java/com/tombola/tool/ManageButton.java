package com.tombola.tool;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tombola.R;
import java.util.ArrayList;

public class ManageButton{

    private Context context;
    private ArrayList<Integer> white;
    private ArrayList<Integer> black;

    public ManageButton(Context context) {
        this.context = context;
        white = new ArrayList<>(3);
        black = new ArrayList<>(3);
        white.add(255);
        white.add(255);
        white.add(255);
        black.add(0);
        black.add(0);
        black.add(0);
    }

    public void setButton(Button casella, ArrayList<Integer> bordi, ArrayList<Integer> padding, ArrayList<Integer> colore_bordo, ArrayList<Integer> colore_sfondo, ArrayList<Integer> colore_testo, float textSize){
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(context, R.drawable.casella);
        layerDrawable.setLayerInset(1, casella.getWidth()/bordi.get(0), casella.getHeight()/bordi.get(1), casella.getWidth()/bordi.get(2),casella.getHeight()/bordi.get(3));
        GradientDrawable bordo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.bordo);
        bordo.setColor(Color.rgb(colore_bordo.get(0),colore_bordo.get(1),colore_bordo.get(2)));
        GradientDrawable sfondo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.sfondo);
        sfondo.setColor(Color.rgb(colore_sfondo.get(0),colore_sfondo.get(1),colore_sfondo.get(2)));
        try {
            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) casella.getLayoutParams();
            lp.setMargins(casella.getWidth() / padding.get(0), casella.getHeight() / padding.get(1), casella.getWidth() / padding.get(2), casella.getHeight() / padding.get(3));
            casella.setLayoutParams(lp);
        }
        catch (Exception e){
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) casella.getLayoutParams();
            lp.setMargins(casella.getWidth() / padding.get(0), casella.getHeight() / padding.get(1), casella.getWidth() / padding.get(2), casella.getHeight() / padding.get(3));
            casella.setLayoutParams(lp);
        }
        casella.setBackground(layerDrawable);
        casella.setTextSize((casella.getHeight()-casella.getHeight()/padding.get(1))/textSize);
        casella.setTextColor(Color.rgb(colore_testo.get(0),colore_testo.get(1),colore_testo.get(2)));
    }

    //left, top, rigth, bottom
    public ArrayList<Integer> preparaBordi(int numero_casella){
        ArrayList<Integer> bordi = new ArrayList<>(4);
        if (numero_casella <= 90) {
            //LEFT
            if (numero_casella == 1 || (numero_casella - 1) % 10 == 0)
                bordi.add(context.getResources().getInteger(R.integer.bordo_grande));
            else {
                if (numero_casella % 10 == 6)
                    bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(0, context.getResources().getInteger(R.integer.bordo_piccolo));
            }
            //TOP
            if (numero_casella >= 1 && numero_casella <= 10)
                bordi.add(context.getResources().getInteger(R.integer.bordo_grande));
            else {
                if ((numero_casella >= 31 && numero_casella <= 40) || (numero_casella >= 61 && numero_casella <= 70))
                    bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(context.getResources().getInteger(R.integer.bordo_piccolo));
            }
            //RIGTH
            if (numero_casella % 10 == 0)
                bordi.add(context.getResources().getInteger(R.integer.bordo_grande));
            else {
                if (numero_casella % 10 == 5)
                    bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(context.getResources().getInteger(R.integer.bordo_piccolo));
            }
            //BOTTOM
            if (numero_casella >= 81 && numero_casella <= 90)
                bordi.add(context.getResources().getInteger(R.integer.bordo_grande));
            else {
                if ((numero_casella >= 21 && numero_casella <= 30) || (numero_casella >= 51 && numero_casella <= 60))
                    bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(context.getResources().getInteger(R.integer.bordo_piccolo));
            }
        }
        else {
            //GIRO
            if (numero_casella == 100) {
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
            }
            //ULTIMO ESTRATTO
            if (numero_casella == 101) {
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
            }
            //PENULTIMO ESTRATTO
            if (numero_casella == 102 || numero_casella == 103) {
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
            }
            if (numero_casella == 110) {
                bordi.add(60);
                bordi.add(9);
                bordi.add(60);
                bordi.add(9);
            }
            if (numero_casella == 111) {
                bordi.add(context.getResources().getInteger(R.integer.bordo_piccolo));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
                bordi.add(context.getResources().getInteger(R.integer.bordo_piccolo));
                bordi.add(context.getResources().getInteger(R.integer.bordo_medio));
            }
        }
        return bordi;
    }

    public ArrayList<Integer> preparaPadding(int tipologia){
        ArrayList<Integer> padding = new ArrayList<>(4);
        if (tipologia == 1){
            padding.add(context.getResources().getInteger(R.integer.padding_nullo));
            padding.add(context.getResources().getInteger(R.integer.padding_nullo));
            padding.add(context.getResources().getInteger(R.integer.padding_nullo));
            padding.add(context.getResources().getInteger(R.integer.padding_nullo));
        }
        if (tipologia == 2){
            padding.add(context.getResources().getInteger(R.integer.padding_piccolo));
            padding.add(context.getResources().getInteger(R.integer.padding_piccolo));
            padding.add(context.getResources().getInteger(R.integer.padding_piccolo));
            padding.add(context.getResources().getInteger(R.integer.padding_piccolo));
        }
        if (tipologia == 3){
            padding.add(context.getResources().getInteger(R.integer.padding_medio));
            padding.add(context.getResources().getInteger(R.integer.padding_piccolo));
            padding.add(context.getResources().getInteger(R.integer.padding_medio));
            padding.add(context.getResources().getInteger(R.integer.padding_nullo));
        }
        return padding;
    }

    public ArrayList<Integer> getWhite() {
        return white;
    }

    public ArrayList<Integer> getBlack() {
        return black;
    }
}
