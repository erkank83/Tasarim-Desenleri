package com.company;

import java.util.ArrayList;
import java.util.List;

class TvDizisi{
    //Abstract sınıf sadece bir tane olur
    private String isim;
    private String yapimci;
    private List<Bolum> bolumler;

    public TvDizisi() {
        this.bolumler = new ArrayList<Bolum>();
    }

    public TvDizisi(String isim,String yapimci){
        this();
        this.isim=isim;
        this.yapimci=yapimci;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setYapimci(String yapimci) {
        this.yapimci = yapimci;
    }

    public String getIsim() {
        return isim;
    }

    public String getYapimci() {
        return yapimci;
    }

    public void bolumEkle(Bolum b){
        bolumler.add(b);
    }

    public void bolumListe(){
        System.out.println("----Bölümler-----");
        for (Bolum b:bolumler) {
            System.out.println(b);
        }
    }
}
class Bolum{

    //Occurence sınıf birden fazla olabilir

    private String bolumIsim="";
    private int bolumNumarasi;
    private TvDizisi dizi=new TvDizisi();

    public Bolum(){}

    public Bolum(TvDizisi dizi){
        this.dizi=dizi;
    }

    public Bolum(String bolumIsim,int bolumNumarasi){
        this.bolumIsim=bolumIsim;
        this.bolumNumarasi=bolumNumarasi;
    }

    public void setBolumIsim(String bolumIsim) {

        this.bolumIsim = bolumIsim;
    }

    public void setBolumNumarasi(int bolumNumarasi) {
        this.bolumNumarasi = bolumNumarasi;
    }

    public int getBolumNumarasi() {
        return bolumNumarasi;
    }

    public String getBolumIsim() {
        if (bolumIsim.isBlank())
            bolumIsim="Boş";
        return bolumIsim;
    }

    public String toString(){
        return "Bölüm ismi:"+getBolumIsim()+", Bölüm numarasi: "+getBolumNumarasi();
    }


    public String getTvIsmi(){
       return this.dizi.getIsim();
    }

    public String getYapimci(){
        return this.dizi.getYapimci();
    }
}


public class Main {

    public static void main(String[] args) {

       // TvDizisi sınıfından parametresiz bir nesne oluşturuluyor....
       TvDizisi guldurGuldur=new TvDizisi();
       guldurGuldur.setIsim("Güldür güldür");
       guldurGuldur.setYapimci("BKM");
       // bolum1a oluşturuluyor...
       Bolum bolum1a=new Bolum();
       bolum1a.setBolumIsim("Düşman Dünürler");
       bolum1a.setBolumNumarasi(1);
       //bolum 1b oluşturuluyor..
        Bolum bolum1b=new Bolum();
        bolum1b.setBolumIsim("Korku Seansı");
        bolum1b.setBolumNumarasi(1);

        //Bölüm nesnesine soyut sınıf(TvDizisi) referans ediliyor ve yapımcı çağrılıyor
        Bolum bolum212=new Bolum(guldurGuldur);
        bolum212.setBolumNumarasi(212);
        bolum212.setBolumIsim("Kılık Değiştirme");
        System.out.println("Dizi Adı:"+bolum212.getTvIsmi());
        System.out.println("Yapımcı:"+bolum212.getYapimci());

        //bölümler guldurGuldur nesnesine ekleniyor..
        guldurGuldur.bolumEkle(bolum1a);
        guldurGuldur.bolumEkle(bolum1b);
        guldurGuldur.bolumEkle(bolum212);

        // guldurGuldur nesnesine parametreli bolüm ekleniyor..
        guldurGuldur.bolumEkle(new Bolum("Tatil Dönüşü",1));
        guldurGuldur.bolumEkle(new Bolum("Aile Evi",2));
        //guldurGuldur nesnesine Tvdizi nesnesi de referans gönderiliyor
        guldurGuldur.bolumListe();

       TvDizisi bizimkiler=new TvDizisi("Bizimkiler","Bugay Yapım");
       // ilk bölüm oluşturuluyor ve TvDizisi sınıfındaki isim ve yapımcı değerlerine ulaşılıyor
       Bolum bolum1=new Bolum(bizimkiler);
       bolum1.setBolumNumarasi(1);
       System.out.println("Dizi Adı:"+bolum1.getTvIsmi());
       System.out.println("Yapımcı:"+bolum1.getYapimci());
       bizimkiler.bolumEkle(bolum1);
       // İkinci bölüm oluşturuluyor
        Bolum bolum2=new Bolum();
        bolum2.setBolumNumarasi(2);
        bizimkiler.bolumEkle(bolum2);
        // Üçüncü bölüm oluşturuluyor
        bizimkiler.bolumEkle(new Bolum("",3));
        bizimkiler.bolumListe();

    }
}
