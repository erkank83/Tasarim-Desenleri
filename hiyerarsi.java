package com.company;

import java.util.ArrayList;
import java.util.List;

class Calisan{
    String isim;
    Calisan Yonetici;

    public Calisan(){}

    public Calisan(String isim){
        this.isim=isim;
    }
    public Calisan(Calisan yonetici){
        this.Yonetici=yonetici;
    }

    public Calisan(String isim,Calisan Yonetici){
        this.isim=isim;
        this.Yonetici=Yonetici;
    }

    public String toString(){
        return getIsim();
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Calisan getYonetici() {
        return Yonetici;
    }

    public void setYonetici(Calisan yonetici) {
        Yonetici = yonetici;
    }
}

class Ogretmen  extends Calisan{
    public Ogretmen(String isim){
        super(isim);
    }
}
class Hemsire extends Calisan{
    public Hemsire(String isim){
        super(isim);
    }
}
class Yonetici  extends Calisan{

    public Yonetici(){}
    public Yonetici(String isim){
        super(isim);
    }

    List<Calisan> altlari=new ArrayList<Calisan>();
    public void ekleCalisan(Calisan alt){
        altlari.add(alt);
        alt.Yonetici=this;
    }
    public void listeleAltlari(){
        System.out.println(this.getIsim()+" adlı kullanıcının altındaki personel");
        for (Calisan c:altlari) {
            System.out.println(c);
        }
    }
    public void kacCalisaniVar(){
        System.out.println(getIsim()+" adlı kullanıcının "+altlari.size()+" çalışanı var");
    }

}

public class hiyerarsi {
    public static void main(String[] args) {

        Yonetici ismailBalim   =new Yonetici("İsmail Balım");
        Yonetici mehmetAri     =new Yonetici("Mehmet Ari");
        Yonetici bahtiyarKatmer=new Yonetici("Bahtiyar Katmer");
        Yonetici mehmetMolla   =new Yonetici("Mehmet Molla");
        // okul müdürü başmüdür yardımcısı ekler
        ismailBalim.ekleCalisan(mehmetAri);
        //Müdür başyardımcısı diğer müdür yardımcılarını ekler
        mehmetAri.ekleCalisan(bahtiyarKatmer);
        mehmetAri.ekleCalisan(mehmetMolla);
        //Öğretmenler
        Ogretmen erkanKocaman    =new Ogretmen("Erkan Kocaman");
        Ogretmen ramazanKarabatak=new Ogretmen("Ramazan Karabatak");
        Ogretmen abdurrahmanKazan=new Ogretmen("Abdurrahman Kazan");
        Ogretmen muratOzkan      =new Ogretmen("Murat Özkan");
        Ogretmen tanerTasova     =new Ogretmen("Taner Taşova");
        Ogretmen ibrahimBayrak   =new Ogretmen("İbrahim Bayrak");
        Ogretmen sabanPasaOglu   =new Ogretmen("Şaban Paşaoğlu");
        Ogretmen metinToprak     =new Ogretmen("Metin Toprak");
        Ogretmen umitYurttas     =new Ogretmen("Ümit Yurttaş");
        Ogretmen ozlemGollu      =new Ogretmen("Özlem Göllü");
        Ogretmen aliKaragul      =new Ogretmen("Ali Karagül");
        Ogretmen suleymanKir     =new Ogretmen("Süleyman Kır");
        Ogretmen eyupHakverdi    =new Ogretmen("Eyüp Hakverdi");
        Ogretmen goksalKaradas   =new Ogretmen("Göksal Karadaş");
        Ogretmen mesutKaya       =new Ogretmen("Mesut Kaya");
        Ogretmen oguzOzbas       =new Ogretmen("Oğuz Özbaş");
        Ogretmen osmanYildirim   =new Ogretmen("Osman Yıldırım");
        Ogretmen mustafaErtanTunga=new Ogretmen("Mustafa Ertan Tunga");
        Ogretmen ozlemCimen      =new Ogretmen("Özlem Çimen");
        Ogretmen sevilayTunc     =new Ogretmen("Sevilay Tunç");
        Ogretmen beyzaDemirci    =new Ogretmen("Beyza Demirci");
        Ogretmen rabiaKaradeniz  =new Ogretmen("Rabia Karadeniz");
        Ogretmen hulyaOzen       =new Ogretmen("Hülya Özen");
        //Hemşire
        Hemsire gulsumKaymazAltintas=new Hemsire("Gülsüm Kaymaz Altıntaş");
        // Mehmet molla müdür yardımcısının personelleri
        mehmetMolla.ekleCalisan(erkanKocaman);
        mehmetMolla.ekleCalisan(ramazanKarabatak);
        mehmetMolla.ekleCalisan(abdurrahmanKazan);
        mehmetMolla.ekleCalisan(muratOzkan);
        mehmetMolla.ekleCalisan(tanerTasova);
        mehmetMolla.ekleCalisan(ibrahimBayrak);
        mehmetMolla.ekleCalisan(sabanPasaOglu);
        mehmetMolla.ekleCalisan(metinToprak);
        mehmetMolla.ekleCalisan(umitYurttas);
        mehmetMolla.ekleCalisan(ozlemGollu);
        mehmetMolla.ekleCalisan(aliKaragul);
        mehmetMolla.ekleCalisan(suleymanKir);
        mehmetMolla.ekleCalisan(eyupHakverdi);
        mehmetMolla.ekleCalisan(goksalKaradas);
        mehmetMolla.ekleCalisan(mesutKaya);
        mehmetMolla.ekleCalisan(oguzOzbas);
        mehmetMolla.ekleCalisan(osmanYildirim);
        mehmetMolla.ekleCalisan(mustafaErtanTunga);
        mehmetMolla.ekleCalisan(ozlemCimen);
        mehmetMolla.ekleCalisan(sevilayTunc);
        mehmetMolla.ekleCalisan(beyzaDemirci);
        mehmetMolla.ekleCalisan(rabiaKaradeniz);
        mehmetMolla.ekleCalisan(hulyaOzen);
        //bahtiyar katmer müdür yardımcısının personelleri
        bahtiyarKatmer.ekleCalisan(gulsumKaymazAltintas);

        ismailBalim.listeleAltlari();
        mehmetAri.listeleAltlari();
        mehmetMolla.listeleAltlari();
        bahtiyarKatmer.listeleAltlari();

        ismailBalim.kacCalisaniVar();
        mehmetAri.kacCalisaniVar();
        mehmetMolla.kacCalisaniVar();
        bahtiyarKatmer.kacCalisaniVar();

    }
}
