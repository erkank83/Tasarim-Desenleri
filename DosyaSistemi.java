package com.company;

import java.util.ArrayList;
import java.util.List;

class DosyaElemani{
    String isim;
    DosyaElemani Klasor;

    public DosyaElemani(){}

    public DosyaElemani(String isim){
        this.isim=isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getIsim() {
        return isim;
    }

    public String toString(){
        return getIsim();
    }
}
class Dosya extends DosyaElemani{

    String uzanti="";

    public String getUzanti() {
        return uzanti;
    }

    public void setUzanti(String uzanti) {
        this.uzanti = uzanti;
    }

    public Dosya(String isim){
        super(isim);
    }
    public Dosya(String isim,String uzanti){
        super(isim);
        this.uzanti=uzanti;
    }
    public String toString(){
        String donen=getIsim();
        if (!(getUzanti().isBlank()))
        donen= getIsim()+"."+getUzanti();
        return donen;
    }
}
class Klasor extends DosyaElemani{
    public Klasor(String isim){
        super(isim);
    }

    List<DosyaElemani> altlari=new ArrayList<DosyaElemani>();
    public void ekleDosyaElemani(DosyaElemani alt){
        altlari.add(alt);
        alt.Klasor=this;
    }

    public void listeleAltlari(){
        System.out.println(this.getIsim()+" adlı klasörün altındaki dosya elemanları");
        for (DosyaElemani c:altlari) {
            System.out.println(c);
        }
    }
    public void kacDosyaElemaniVar(){
        System.out.println(getIsim()+" adlı klasörün \t"+altlari.size()+" dosya elemani var");
    }

}

public class DosyaSistemi {
    public static void main(String[] args) {
        //Klsörler
        Klasor computer=new Klasor("/");
        Klasor bin=new Klasor("bin");
        Klasor boot=new Klasor("boot");
        Klasor cdrom=new Klasor("cdrom");
        Klasor dev=new Klasor("dev");
        Klasor etc=new Klasor("etc");
        Klasor home=new Klasor("home");
        Klasor lib=new Klasor("lib");
        Klasor lib64=new Klasor("lib64");
        Klasor grup=new Klasor("grup");
        Klasor cpu=new Klasor("cpu");
        Klasor disk= new Klasor("disk");
        Klasor usb= new Klasor("usb");
        //Dosyalar
        Dosya bash=new Dosya("bash");
        Dosya cat=new Dosya("cat");
        Dosya ls=new Dosya("ls");
        Dosya mv=new Dosya("mv");
        Dosya memtest86=new Dosya("memtest86+","elf");
        Dosya memtest86_=new Dosya("memtest86+","bin");
        Dosya microcode=new Dosya("microcode");
        //bin klasöre ekleme işlemi yapııyor
        bin.ekleDosyaElemani(bash);
        bin.ekleDosyaElemani(cat);
        bin.ekleDosyaElemani(ls);
        bin.ekleDosyaElemani(mv);
        //boot klasöre ekleme işlemi yapılıyor
        boot.ekleDosyaElemani(grup);
        boot.ekleDosyaElemani(memtest86);
        boot.ekleDosyaElemani(memtest86_);
        // dev/cpu altına dosya elemanı ekleniyor
        usb.ekleDosyaElemani(microcode);
        //dev klasöre ekleme işlemi yapılıyor
        dev.ekleDosyaElemani(cpu);
        dev.ekleDosyaElemani(disk);
        dev.ekleDosyaElemani(usb);
        // (/) Ana klsöre ekleme işlemi yapılıyor
        computer.ekleDosyaElemani(bin);
        computer.ekleDosyaElemani(boot);
        computer.ekleDosyaElemani(cdrom);
        computer.ekleDosyaElemani(dev);
        computer.ekleDosyaElemani(etc);
        computer.ekleDosyaElemani(home);
        computer.ekleDosyaElemani(lib);
        computer.ekleDosyaElemani(lib64);
        //Listeleme işlemi yapılıyor
        computer.listeleAltlari();
        bin.listeleAltlari();
        boot.listeleAltlari();
        dev.listeleAltlari();
        usb.listeleAltlari();
        //Kaç eleman var
        computer.kacDosyaElemaniVar();
        bin.kacDosyaElemaniVar();
        boot.kacDosyaElemaniVar();
        dev.kacDosyaElemaniVar();
        usb.kacDosyaElemaniVar();
    }
}
