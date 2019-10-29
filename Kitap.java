package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

class KitapBasligi{
    //Abstract sınıf sadece bir tane olur
    private String isim;
    private String yazar;
    private String ISBN;
    private String baskiTarihi;
    private int baskiNo;
    private List<KutuphaneElemani> kitaplar;


    public KitapBasligi(){
        kitaplar=new ArrayList<KutuphaneElemani>();
    }

    public KitapBasligi(String isim, String yazar, String ISBN, String baskiTarihi, int baskiNo) throws Exception{
        this();
        this.isim = isim;
        this.yazar = yazar;
        this.ISBN = ISBN;
        this.baskiTarihi = setBaskiTarihi(baskiTarihi);
        this.baskiNo = baskiNo;
    }

    public String toString(){
        return "İsim: "+getIsim()+" Yazar :"+getYazar()+" ISBN :"+getISBN()+" Baskı Tarihi : "+getBaskiTarihi()+" Baskı No: "+getBaskiNo();
    }

    public void kitapEkle(KutuphaneElemani ke){
        kitaplar.add(ke);
    }
    public void kitapListele(){
        System.out.println("------Kitaplar Listeleniyor...----");
        for (KutuphaneElemani ke:kitaplar) {
            System.out.println(ke);
        }
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBaskiTarihi() {
        return baskiTarihi;
    }

    public String setBaskiTarihi(String sDate1)throws Exception {

        String pattern = "MMMMM yyyy ";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("tr", "TR"));
        Date date2=new SimpleDateFormat("MM/yyyy").parse(sDate1);
        return this.baskiTarihi = simpleDateFormat.format(date2);
    }

    public int getBaskiNo() {
        return baskiNo;
    }

    public void setBaskiNo(int baskiNo) {
        this.baskiNo = baskiNo;
    }

}
class KutuphaneElemani{
    //Occurence sınıf birden fazla olabilir
    private String barkodNo;
    private KitapBasligi kitapBasligi;

    public KutuphaneElemani(){
    }

    public KutuphaneElemani(String barkodNo){
        this.barkodNo=barkodNo;
    }
    public KutuphaneElemani(KitapBasligi kitapBasligi){
        this.kitapBasligi=kitapBasligi;
    }
    public KutuphaneElemani(String barkodNo,KitapBasligi kitapBasligi){
        this.kitapBasligi=kitapBasligi;
        this.barkodNo=barkodNo;
    }

    public void setBarkodNo(String barkodNo) {
        this.barkodNo = barkodNo;
    }

    public void setKitapBasligi(KitapBasligi kitapBasligi) {
        this.kitapBasligi = kitapBasligi;
    }

    public String getBarkodNo() {
        return barkodNo;
    }

    public KitapBasligi getKitapBasligi() {
        return kitapBasligi;
    }
    public String toString(){
        return "Barkod no:"+getBarkodNo();
    }
}

public class Kitap {
    public static void main(String[] args) throws Exception {

        KitapBasligi javaProgramlamaDiliYazilimTasarimi=new KitapBasligi();
        javaProgramlamaDiliYazilimTasarimi.setBaskiNo(7);
        javaProgramlamaDiliYazilimTasarimi.setBaskiTarihi("09/2016");
        javaProgramlamaDiliYazilimTasarimi.setISBN("978-975-6797-40-2");
        javaProgramlamaDiliYazilimTasarimi.setIsim("Java ve Yazılım Tasarımı");
        javaProgramlamaDiliYazilimTasarimi.setYazar("Altuğ B. ALTINTAŞ");

        //Birinci kullanım örneği
        KutuphaneElemani kutuphaneElemani1=new KutuphaneElemani(javaProgramlamaDiliYazilimTasarimi);
        kutuphaneElemani1.setBarkodNo("9789756797402");
        System.out.println(kutuphaneElemani1.getKitapBasligi());// kütüphane elemanından başlığa erişim oluyor..
        javaProgramlamaDiliYazilimTasarimi.kitapEkle(kutuphaneElemani1);
        //İkinci Kullanım örneği
        KutuphaneElemani kutuphaneElemani2=new KutuphaneElemani("9789756797403");
        kutuphaneElemani2.setKitapBasligi(javaProgramlamaDiliYazilimTasarimi);
        javaProgramlamaDiliYazilimTasarimi.kitapEkle(kutuphaneElemani2);
        //Üçüncü kullanım Örneği 1 satırda işlem yapılıyor
        javaProgramlamaDiliYazilimTasarimi.kitapEkle(new KutuphaneElemani("9789756797404",javaProgramlamaDiliYazilimTasarimi));
        // kitaplar listeleniyor
        javaProgramlamaDiliYazilimTasarimi.kitapListele();
        // 2. Kitap oluşturuluyor
        KitapBasligi androidProgramlamaEgitimi=new KitapBasligi("Android Programlama Eğitimi","Aykut Taşdelen","978-605-64608-4-5","10/2017",5);
        androidProgramlamaEgitimi.kitapEkle(new KutuphaneElemani("9786056460845",androidProgramlamaEgitimi));
        androidProgramlamaEgitimi.kitapEkle(new KutuphaneElemani("9786056460846",androidProgramlamaEgitimi));
        System.out.println(androidProgramlamaEgitimi);
        androidProgramlamaEgitimi.kitapListele();


    }

}
