package com.tombola.tool;

import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Objects;

public class ManageXml {

    private InputStream ist;
    private FileOutputStream ost;
    private XmlPullParser xrp;
    private ArrayList<Integer> colore_casella_libera_testo;
    private ArrayList<Integer> colore_casella_libera_sfondo;
    private ArrayList<Integer> colore_casella_tappata_testo;
    private ArrayList<Integer> colore_casella_tappata_sfondo;
    private ArrayList<Integer> colore_bordo;
    private ArrayList<Integer> mio_colore_casella_libera_testo;
    private ArrayList<Integer> mio_colore_casella_libera_sfondo;
    private ArrayList<Integer> mio_colore_casella_tappata_testo;
    private ArrayList<Integer> mio_colore_casella_tappata_sfondo;
    private ArrayList<Integer> mio_colore_bordo;
    private int tempo;

    public ManageXml(){
        colore_casella_libera_testo = new ArrayList<>(3);
        colore_casella_libera_sfondo = new ArrayList<>(3);
        colore_casella_tappata_testo = new ArrayList<>(3);
        colore_casella_tappata_sfondo = new ArrayList<>(3);
        colore_bordo = new ArrayList<>(3);
        mio_colore_casella_libera_testo = new ArrayList<>(3);
        mio_colore_casella_libera_sfondo = new ArrayList<>(3);
        mio_colore_casella_tappata_testo = new ArrayList<>(3);
        mio_colore_casella_tappata_sfondo = new ArrayList<>(3);
        mio_colore_bordo = new ArrayList<>(3);
        tempo = 0;
    }

    public void writeXml() {
        XmlSerializer xmlSerializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();
        try {
            xmlSerializer.setOutput(writer);
            xmlSerializer.startDocument("UTF-8", true);
            xmlSerializer.startTag("", "settings");
            xmlSerializer.startTag("", "casella_libera");
            xmlSerializer = colorXml( xmlSerializer,"sfondo", colore_casella_libera_sfondo, mio_colore_casella_libera_sfondo);
            xmlSerializer = colorXml(xmlSerializer, "testo", colore_casella_libera_testo, mio_colore_casella_libera_testo);
            xmlSerializer.endTag("", "casella_libera");
            xmlSerializer.startTag("", "casella_tappata");
            xmlSerializer = colorXml( xmlSerializer,"sfondo", colore_casella_tappata_sfondo, mio_colore_casella_tappata_sfondo);
            xmlSerializer = colorXml(xmlSerializer, "testo", colore_casella_tappata_testo, mio_colore_casella_tappata_testo);
            xmlSerializer.endTag("", "casella_tappata");
            xmlSerializer.startTag("", "bordo");
            xmlSerializer = colorXml( xmlSerializer,"", colore_bordo, mio_colore_bordo);
            xmlSerializer.endTag("", "bordo");
            xmlSerializer.startTag("", "tempo");
            xmlSerializer.attribute("","t", Integer.toString(tempo));
            xmlSerializer.endTag("", "tempo");
            xmlSerializer.endTag("", "settings");
            xmlSerializer.endDocument();
            ost.write(writer.toString().getBytes());
            ost.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private XmlSerializer colorXml(XmlSerializer xmlSerializer, String tag, ArrayList<Integer> colore, ArrayList<Integer> my_color) throws IOException {
        if (!Objects.equals(tag, ""))
            xmlSerializer.startTag("", tag);
        xmlSerializer.startTag("", "color");
        xmlSerializer.attribute("", "r", colore.get(0).toString());
        xmlSerializer.attribute("", "g", colore.get(1).toString());
        xmlSerializer.attribute("", "b", colore.get(2).toString());
        xmlSerializer.endTag("", "color");
        xmlSerializer.startTag("", "my_color");
        xmlSerializer.attribute("", "r", my_color.get(0).toString());
        xmlSerializer.attribute("", "g", my_color.get(1).toString());
        xmlSerializer.attribute("", "b", my_color.get(2).toString());
        xmlSerializer.endTag("", "my_color");
        if (!Objects.equals(tag, ""))
            xmlSerializer.endTag("", tag);
        return xmlSerializer;
    }

    public void readXml(boolean my_config){
        boolean casella_libera = false;
        boolean casella_tappata = false;
        boolean bordo_tag = false;
        boolean testo = false;
        boolean sfondo = false;
        try {
            if (my_config){
                xrp = Xml.newPullParser();
                xrp.setInput(ist, null);
            }
            int event = xrp.getEventType();
            while (event != XmlPullParser.END_DOCUMENT)  {
                String name=xrp.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        if(name.equals("tempo"))
                            tempo = Integer.parseInt(xrp.getAttributeValue(0));
                        if(name.equals("casella_libera"))
                            casella_libera = true;
                        if(name.equals("casella_tappata"))
                            casella_tappata = true;
                        if(name.equals("bordo"))
                            bordo_tag = true;
                        if(name.equals("testo"))
                            testo = true;
                        if(name.equals("sfondo"))
                            sfondo = true;
                        if (name.equals("color")){
                            if (casella_libera && testo){
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_libera && sfondo){
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && testo){
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && sfondo){
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (bordo_tag){
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                        }
                        if (name.equals("my_color")){
                            if (casella_libera && testo) {
                                testo = false;
                                casella_libera = false;
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_libera && sfondo) {
                                sfondo = false;
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && testo){
                                testo = false;
                                casella_tappata = false;
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && sfondo) {
                                sfondo = false;
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));}
                            if (bordo_tag) {
                                bordo_tag = false;
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                        }
                        break;
                }
                event = xrp.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }

    public void setXrp(XmlPullParser xrp) {
        this.xrp = xrp;
    }

    public void setIst(InputStream ist) {
        this.ist = ist;
    }

    public void setOst(FileOutputStream ost) {
        this.ost = ost;
    }

    public ArrayList<Integer> getColore_casella_libera_testo() {
        return colore_casella_libera_testo;
    }

    public ArrayList<Integer> getColore_casella_libera_sfondo() {
        return colore_casella_libera_sfondo;
    }

    public ArrayList<Integer> getColore_casella_tappata_testo() {
        return colore_casella_tappata_testo;
    }

    public ArrayList<Integer> getColore_casella_tappata_sfondo() {
        return colore_casella_tappata_sfondo;
    }

    public ArrayList<Integer> getColore_bordo() {
        return colore_bordo;
    }

    public ArrayList<Integer> getMio_colore_casella_libera_testo() {
        return mio_colore_casella_libera_testo;
    }

    public ArrayList<Integer> getMio_colore_casella_libera_sfondo() {
        return mio_colore_casella_libera_sfondo;
    }

    public ArrayList<Integer> getMio_colore_casella_tappata_testo() {
        return mio_colore_casella_tappata_testo;
    }

    public ArrayList<Integer> getMio_colore_casella_tappata_sfondo() {
        return mio_colore_casella_tappata_sfondo;
    }

    public ArrayList<Integer> getMio_colore_bordo() {
        return mio_colore_bordo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
