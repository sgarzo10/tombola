package com.tombola.gui.main;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.tombola.tool.ManageButton;
import com.tombola.tool.ManageXml;
import com.tombola.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class ActivityMain  extends AppCompatActivity {

    private boolean start = false;
    private ArrayList<Button> caselle;
    private ImageButton cinquina;
    private ImageButton decima;
    private ImageButton tombola;
    private Button ultimo;
    private Button penultimo;
    private Button terzultimo;
    private Button giro;
    private TableLayout layoutTabellone;
    private LinearLayout layoutComandi;
    private FrameLayout layoutLogo;
    private AlertDialog dialog;
    private ManageXml manageXml;
    private ManageButton manageButton;
    private TextView testo_tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manageButton = new ManageButton(this);
        start = true;
        layoutTabellone=(TableLayout) findViewById(R.id.LTabellone);
        layoutComandi=(LinearLayout) findViewById(R.id.LComandi);
        layoutLogo=(FrameLayout) findViewById(R.id.logo);
        ultimo = (Button) findViewById(R.id.casella_ultimo_numero);
        penultimo = (Button) findViewById(R.id.casella_penultimo_numero);
        terzultimo = (Button) findViewById(R.id.casella_terzultimo_numero);
        giro = (Button) findViewById(R.id.casella_giro);
        ImageButton piu = (ImageButton) findViewById(R.id.piu);
        ImageButton meno = (ImageButton) findViewById(R.id.meno);
        ImageButton annulla = (ImageButton) findViewById(R.id.annulla);
        ImageButton impostazioni = (ImageButton) findViewById(R.id.set);
        ImageButton reset = (ImageButton) findViewById(R.id.reset);
        cinquina =(ImageButton)findViewById(R.id.cinquina);
        decima =(ImageButton)findViewById(R.id.decima);
        tombola =(ImageButton)findViewById(R.id.tombola);
        testo_tempo = (TextView) findViewById(R.id.testo_tempo);
        caselle = new ArrayList<>(90);
        AscoltatoreActivityMain ascoltatore = new AscoltatoreActivityMain(this);
        caselle.add((Button) findViewById(R.id.casella0));
        caselle.add((Button) findViewById(R.id.casella1));
        caselle.add((Button) findViewById(R.id.casella2));
        caselle.add((Button) findViewById(R.id.casella3));
        caselle.add((Button) findViewById(R.id.casella4));
        caselle.add((Button) findViewById(R.id.casella5));
        caselle.add((Button) findViewById(R.id.casella6));
        caselle.add((Button) findViewById(R.id.casella7));
        caselle.add((Button) findViewById(R.id.casella8));
        caselle.add((Button) findViewById(R.id.casella9));
        caselle.add((Button) findViewById(R.id.casella10));
        caselle.add((Button) findViewById(R.id.casella11));
        caselle.add((Button) findViewById(R.id.casella12));
        caselle.add((Button) findViewById(R.id.casella13));
        caselle.add((Button) findViewById(R.id.casella14));
        caselle.add((Button) findViewById(R.id.casella15));
        caselle.add((Button) findViewById(R.id.casella16));
        caselle.add((Button) findViewById(R.id.casella17));
        caselle.add((Button) findViewById(R.id.casella18));
        caselle.add((Button) findViewById(R.id.casella19));
        caselle.add((Button) findViewById(R.id.casella20));
        caselle.add((Button) findViewById(R.id.casella21));
        caselle.add((Button) findViewById(R.id.casella22));
        caselle.add((Button) findViewById(R.id.casella23));
        caselle.add((Button) findViewById(R.id.casella24));
        caselle.add((Button) findViewById(R.id.casella25));
        caselle.add((Button) findViewById(R.id.casella26));
        caselle.add((Button) findViewById(R.id.casella27));
        caselle.add((Button) findViewById(R.id.casella28));
        caselle.add((Button) findViewById(R.id.casella29));
        caselle.add((Button) findViewById(R.id.casella30));
        caselle.add((Button) findViewById(R.id.casella31));
        caselle.add((Button) findViewById(R.id.casella32));
        caselle.add((Button) findViewById(R.id.casella33));
        caselle.add((Button) findViewById(R.id.casella34));
        caselle.add((Button) findViewById(R.id.casella35));
        caselle.add((Button) findViewById(R.id.casella36));
        caselle.add((Button) findViewById(R.id.casella37));
        caselle.add((Button) findViewById(R.id.casella38));
        caselle.add((Button) findViewById(R.id.casella39));
        caselle.add((Button) findViewById(R.id.casella40));
        caselle.add((Button) findViewById(R.id.casella41));
        caselle.add((Button) findViewById(R.id.casella42));
        caselle.add((Button) findViewById(R.id.casella43));
        caselle.add((Button) findViewById(R.id.casella44));
        caselle.add((Button) findViewById(R.id.casella45));
        caselle.add((Button) findViewById(R.id.casella46));
        caselle.add((Button) findViewById(R.id.casella47));
        caselle.add((Button) findViewById(R.id.casella48));
        caselle.add((Button) findViewById(R.id.casella49));
        caselle.add((Button) findViewById(R.id.casella50));
        caselle.add((Button) findViewById(R.id.casella51));
        caselle.add((Button) findViewById(R.id.casella52));
        caselle.add((Button) findViewById(R.id.casella53));
        caselle.add((Button) findViewById(R.id.casella54));
        caselle.add((Button) findViewById(R.id.casella55));
        caselle.add((Button) findViewById(R.id.casella56));
        caselle.add((Button) findViewById(R.id.casella57));
        caselle.add((Button) findViewById(R.id.casella58));
        caselle.add((Button) findViewById(R.id.casella59));
        caselle.add((Button) findViewById(R.id.casella60));
        caselle.add((Button) findViewById(R.id.casella61));
        caselle.add((Button) findViewById(R.id.casella62));
        caselle.add((Button) findViewById(R.id.casella63));
        caselle.add((Button) findViewById(R.id.casella64));
        caselle.add((Button) findViewById(R.id.casella65));
        caselle.add((Button) findViewById(R.id.casella66));
        caselle.add((Button) findViewById(R.id.casella67));
        caselle.add((Button) findViewById(R.id.casella68));
        caselle.add((Button) findViewById(R.id.casella69));
        caselle.add((Button) findViewById(R.id.casella70));
        caselle.add((Button) findViewById(R.id.casella71));
        caselle.add((Button) findViewById(R.id.casella72));
        caselle.add((Button) findViewById(R.id.casella73));
        caselle.add((Button) findViewById(R.id.casella74));
        caselle.add((Button) findViewById(R.id.casella75));
        caselle.add((Button) findViewById(R.id.casella76));
        caselle.add((Button) findViewById(R.id.casella77));
        caselle.add((Button) findViewById(R.id.casella78));
        caselle.add((Button) findViewById(R.id.casella79));
        caselle.add((Button) findViewById(R.id.casella80));
        caselle.add((Button) findViewById(R.id.casella81));
        caselle.add((Button) findViewById(R.id.casella82));
        caselle.add((Button) findViewById(R.id.casella83));
        caselle.add((Button) findViewById(R.id.casella84));
        caselle.add((Button) findViewById(R.id.casella85));
        caselle.add((Button) findViewById(R.id.casella86));
        caselle.add((Button) findViewById(R.id.casella87));
        caselle.add((Button) findViewById(R.id.casella88));
        caselle.add((Button) findViewById(R.id.casella89));
        for (int i =0;i<caselle.size();i++){
            caselle.get(i).setOnClickListener(ascoltatore);
            caselle.get(i).setText(String.format("%s",i+1));
        }
        cinquina.setOnClickListener(ascoltatore);
        decima.setOnClickListener(ascoltatore);
        tombola.setOnClickListener(ascoltatore);
        piu.setOnClickListener(ascoltatore);
        meno.setOnClickListener(ascoltatore);
        annulla.setOnClickListener(ascoltatore);
        impostazioni.setOnClickListener(ascoltatore);
        reset.setOnClickListener(ascoltatore);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Reset Tabellone");
        builder.setMessage("Sei sicuro di voler resettare il tabellone?");
        builder.setPositiveButton("Si", ascoltatore);
        builder.setNegativeButton(android.R.string.cancel, ascoltatore);
        dialog = builder.create();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manageXml = new ManageXml();
        File f = new File(getFilesDir(), "config.xml");
        if (f.exists()) {
            try {
                manageXml.setIst(openFileInput("config.xml"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            manageXml.readXml(true);
        }
        else{
            manageXml.setXrp(getResources().getXml(R.xml.config));
            manageXml.readXml(false);
        }
        updatetabellone();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (start) {
            start=false;
            resetGrafica();
        }
    }

    public void nascondiLayout(float wC, float wT, float wL)
    {
        layoutComandi.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wC));
        layoutTabellone.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wT));
        layoutLogo.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wL));
    }

    public void resetGrafica() {
        TypedValue outValue = new TypedValue();
        getResources().getValue(R.dimen.testo_float, outValue, true);
        manageButton.setButton(giro, manageButton.preparaBordi(100), manageButton.preparaPadding(3), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),outValue.getFloat());
        manageButton.setButton(ultimo, manageButton.preparaBordi(101), manageButton.preparaPadding(2),manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),outValue.getFloat());
        manageButton.setButton(penultimo, manageButton.preparaBordi(102), manageButton.preparaPadding(2),manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),outValue.getFloat());
        manageButton.setButton(terzultimo, manageButton.preparaBordi(103), manageButton.preparaPadding(2),manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),outValue.getFloat());
        ultimo.setText("");
        penultimo.setText("");
        terzultimo.setText("");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.cinquina_verde);
        cinquina.setContentDescription("verde");
        cinquina.setImageBitmap(b);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.decima_verde);
        decima.setContentDescription("verde");
        decima.setImageBitmap(b);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.tombola_verde);
        tombola.setContentDescription("verde");
        tombola.setImageBitmap(b);
        layoutTabellone.setPadding(layoutTabellone.getWidth()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getHeight()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getWidth()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getHeight()/getResources().getInteger(R.integer.padding_minuscolo));
        for (int i = 0; i < caselle.size(); i++) {
            caselle.get(i).setContentDescription("libera");
            caselle.get(i).setClickable(true);
        }
        updatetabellone();
    }

    public void updatetabellone(){

        for (int i = 0; i < caselle.size(); i++){
            if (Objects.equals(caselle.get(i).getContentDescription().toString(), "libera"))
                manageButton.setButton(caselle.get(i), manageButton.preparaBordi(i+1),manageButton.preparaPadding(1), manageXml.getColore_bordo(), manageXml.getColore_casella_libera_sfondo(), manageXml.getColore_casella_libera_testo(),getResources().getInteger(R.integer.testo_medio));
            if (Objects.equals(caselle.get(i).getContentDescription().toString(), "tappata"))
                manageButton.setButton(caselle.get(i), manageButton.preparaBordi(i+1),manageButton.preparaPadding(1), manageXml.getColore_bordo(), manageXml.getColore_casella_tappata_sfondo(), manageXml.getColore_casella_tappata_testo(),getResources().getInteger(R.integer.testo_medio));
        }
    }

    public ManageButton getManageButton() {
        return manageButton;
    }

    public TextView getTesto_tempo() {
        return testo_tempo;
    }

    public ManageXml getManageXml() {
        return manageXml;
    }

    public AlertDialog getDialog() { return dialog; }

    public TextView getUltimo() { return ultimo;}

    public TextView getPenultimo() { return penultimo; }

    public TextView getTerzultimo() { return terzultimo; }

    public TextView getGiro() { return giro; }

    public ArrayList<Button> getCaselle() { return caselle; }

    public ImageButton getCinquina() {
        return cinquina;
    }

    public ImageButton getDecima() {
        return decima;
    }

    public ImageButton getTombola() {
        return tombola;
    }
}
