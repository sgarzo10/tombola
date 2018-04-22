package com.tombola.gui.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tombola.R;
import com.tombola.tool.ManageButton;
import java.util.Objects;


public class ActivitySetting extends AppCompatActivity
{
    private Button my_color;
    private Button run_color;
    private Button casella_in_gioco;
    private Button casella_estratta;
    private Button bordo;
    private Button impostazioni_pausa;
    private Button sfondo;
    private Button testo;
    private Button salva;
    private Button imposta;
    private Button salva_tempo;
    private EditText valore_tempo;
    private SeekBar rosso;
    private SeekBar verde;
    private SeekBar blu;
    private TextView value_rosso;
    private TextView value_verde;
    private TextView value_blu;
    private LinearLayout barraVerde;
    private LinearLayout barraRosso;
    private LinearLayout barraBlu;
    private LinearLayout colori;
    private LinearLayout pausa;
    private ManageButton manageButton;
    private boolean start = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        start = true;
        manageButton = new ManageButton(this);
        Button orange = (Button) findViewById(R.id.orange);
        Button azure = (Button) findViewById(R.id.azure);
        Button green = (Button) findViewById(R.id.green);
        Button gray = (Button) findViewById(R.id.gray);
        Button red = (Button) findViewById(R.id.red);
        Button yellow = (Button) findViewById(R.id.yellow);
        salva_tempo = (Button) findViewById(R.id.salva_tempo);
        imposta = (Button) findViewById(R.id.imposta);
        salva = (Button) findViewById(R.id.salva);
        my_color = (Button) findViewById(R.id.my_color);
        run_color= (Button) findViewById(R.id.run_color);
        casella_in_gioco= (Button) findViewById(R.id.casella_libera);
        casella_estratta = (Button) findViewById(R.id.casella_tap);
        bordo = (Button) findViewById(R.id.bordo);
        impostazioni_pausa = (Button) findViewById(R.id.pausa);
        sfondo = (Button) findViewById(R.id.sfondo);
        testo = (Button) findViewById(R.id.testo);
        rosso = (SeekBar) findViewById(R.id.rosso);
        verde = (SeekBar) findViewById(R.id.verde);
        blu = (SeekBar) findViewById(R.id.blu);
        value_rosso = (TextView) findViewById(R.id.value_rosso);
        value_verde = (TextView) findViewById(R.id.value_verde);
        value_blu = (TextView) findViewById(R.id.value_blu);
        valore_tempo = (EditText) findViewById(R.id.valore_tempo);
        barraVerde = (LinearLayout) findViewById(R.id.barra_verde);
        barraRosso = (LinearLayout) findViewById(R.id.barra_rosso);
        barraBlu = (LinearLayout) findViewById(R.id.barra_blu);
        colori = (LinearLayout) findViewById(R.id.colori);
        pausa = (LinearLayout) findViewById(R.id.impostazioni_pausa);
        AscoltatoreActivitySettings ascoltatore = new AscoltatoreActivitySettings(this, getIntent().getExtras().getString("page"));
        imposta.setOnClickListener(ascoltatore);
        salva.setOnClickListener(ascoltatore);
        orange.setOnClickListener(ascoltatore);
        azure.setOnClickListener(ascoltatore);
        green.setOnClickListener(ascoltatore);
        gray.setOnClickListener(ascoltatore);
        red.setOnClickListener(ascoltatore);
        yellow.setOnClickListener(ascoltatore);
        my_color.setOnClickListener(ascoltatore);
        casella_estratta.setOnClickListener(ascoltatore);
        casella_in_gioco.setOnClickListener(ascoltatore);
        bordo.setOnClickListener(ascoltatore);
        impostazioni_pausa.setOnClickListener(ascoltatore);
        sfondo.setOnClickListener(ascoltatore);
        testo.setOnClickListener(ascoltatore);
        salva_tempo.setOnClickListener(ascoltatore);
        rosso.setOnSeekBarChangeListener(ascoltatore);
        verde.setOnSeekBarChangeListener(ascoltatore);
        blu.setOnSeekBarChangeListener(ascoltatore);
        if (Objects.equals(getIntent().getExtras().getString("page"), "pausa"))
        {
            modificaLayout();
            sfondo.setVisibility(View.INVISIBLE);
            testo.setVisibility(View.INVISIBLE);
        }
        if (Objects.equals(getIntent().getExtras().getString("page"), "bordo"))
        {
            sfondo.setVisibility(View.INVISIBLE);
            testo.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {super.onResume();}

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (start) {
            resetButton();
            if (Objects.equals(getIntent().getExtras().getString("page"), "libera")) {
                manageButton.setButton(casella_in_gioco, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(), getResources().getInteger(R.integer.testo_piccolo));
                manageButton.setButton(sfondo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(), getResources().getInteger(R.integer.testo_medio));
                manageButton.setButton(testo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(), getResources().getInteger(R.integer.testo_medio));
            }
            if (Objects.equals(getIntent().getExtras().getString("page"), "tappata")) {
                manageButton.setButton(casella_estratta, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(),getResources().getInteger(R.integer.testo_piccolo));
                manageButton.setButton(sfondo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(),getResources().getInteger(R.integer.testo_medio));
                manageButton.setButton(testo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),getResources().getInteger(R.integer.testo_medio));
            }
            if (Objects.equals(getIntent().getExtras().getString("page"), "bordo"))
                manageButton.setButton(bordo,manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(),getResources().getInteger(R.integer.testo_piccolo));
            if (Objects.equals(getIntent().getExtras().getString("page"), "pausa"))
                manageButton.setButton(impostazioni_pausa,manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(),getResources().getInteger(R.integer.testo_piccolo));
            manageButton.setButton(sfondo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getWhite(), manageButton.getBlack(), manageButton.getWhite(), getResources().getInteger(R.integer.testo_medio));
            manageButton.setButton(testo, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(), getResources().getInteger(R.integer.testo_medio));
            manageButton.setButton(imposta, manageButton.preparaBordi(110), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(), getResources().getInteger(R.integer.testo_medio));
            manageButton.setButton(salva, manageButton.preparaBordi(110), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(), getResources().getInteger(R.integer.testo_piccolo));
            manageButton.setButton(salva_tempo, manageButton.preparaBordi(111), manageButton.preparaPadding(2), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(), getResources().getInteger(R.integer.testo_piccolo));
            start = false;
        }
    }

    public void modificaLayout()
    {
        barraBlu.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0));
        barraVerde.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0));
        barraRosso.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0));
        colori.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 0));
        pausa.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 7.5f));
    }

    private void resetButton(){
        manageButton.setButton(casella_in_gioco,manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),getResources().getInteger(R.integer.testo_piccolo));
        manageButton.setButton(casella_estratta, manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),getResources().getInteger(R.integer.testo_piccolo));
        manageButton.setButton(bordo,manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),getResources().getInteger(R.integer.testo_piccolo));
        manageButton.setButton(impostazioni_pausa,manageButton.preparaBordi(100), manageButton.preparaPadding(1), manageButton.getBlack(), manageButton.getWhite(), manageButton.getBlack(),getResources().getInteger(R.integer.testo_piccolo));
    }
    public SeekBar getRosso() {
        return rosso;
    }

    public SeekBar getVerde() {
        return verde;
    }

    public SeekBar getBlu() {
        return blu;
    }

    public Button getMy_color() {
        return my_color;
    }

    public Button getRun_color() {
        return run_color;
    }

    public Button getSfondo() {
        return sfondo;
    }

    public Button getTesto() {
        return testo;
    }

    public TextView getValue_rosso() {
        return value_rosso;
    }

    public TextView getValue_verde() {
        return value_verde;
    }

    public TextView getValue_blu() {
        return value_blu;
    }

    public EditText getValore_tempo() {
        return valore_tempo;
    }

    public ManageButton getManageButton() {
        return manageButton;
    }

}
