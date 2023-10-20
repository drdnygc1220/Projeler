package ATMhesap;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int müşteriNo;
    private int pinNo;
    private double vadesiz;
    private double vadeli;
    Scanner scan=new Scanner(System.in);
    DecimalFormat paraFormat=new DecimalFormat("'$'###,##0.00");


    public int getMüşteriNo() {
        return müşteriNo;
    }

    public void setMüşteriNo(int müşteriNo) {
        this.müşteriNo = müşteriNo;
    }

    public int getPinNo() {
        return pinNo;
    }

    public void setPinNo(int pinNo) {
        this.pinNo = pinNo;
    }

    public double getVadesiz() {
        return vadesiz;
    }

    public void setVadesiz(double vadesiz) {
        this.vadesiz = vadesiz;
    }

    public double getVadeli() {
        return vadeli;
    }

    public void setVadeli(double vadeli) {
        this.vadeli = vadeli;
    }
    //vadesize para cekme ve yatırma işlemi yaptık
    public double paraCekVadesizden(double miktar){
        vadesiz=vadesiz-miktar;
        return vadesiz;

    }
    public double paraYatırVadesize(double miktar){
        vadesiz=vadesiz+miktar;
        return vadesiz;

    } public double paraCekVadeli(double miktar){
        vadeli=vadeli-miktar;
        return vadeli;

    }
    public double paraYatırVadeli(double miktar){
        vadeli=vadeli+miktar;
        return vadeli;

    }
    public void vadesizBakiyeParaCektiktenSonra(){
        System.out.println("Vadesiz hesap bakiyeniz:"+paraFormat.format(vadesiz));
        System.out.print("Lütfen cekmek istediğiniz miktarı giriniz: ");
        double miktar= scan.nextDouble();
      if(vadesiz>=miktar){
            paraCekVadesizden(miktar);
            System.out.println("Çektiğiniz miktar: "+miktar);
            System.out.println("Vadesiz hesap bakiyeniz:"+paraFormat.format(vadesiz));
        }else{
            System.out.println("hesabınızda yeteerli bakiye bullunmamaktır..");
        }
    }

    public void vadesizParaYatırdıktanSonra(){
        System.out.println("Vadesiz hesap bakiyeniz:"+paraFormat.format(vadesiz));
        System.out.print("lütfen yatırmak istediğiniz miktarı giriniz..");
        double miktar=scan.nextDouble();


            paraYatırVadesize(miktar);
            System.out.print("Yatırdıgınız miktar:"+ miktar);
            System.out.println("Vadesiz hesap bakiyeniz:"+paraFormat.format(vadesiz));




    }
    public void vadeliParaCekme(){
        System.out.println("Vadeli hesap bakiyeniz:"+paraFormat.format(vadeli));
        System.out.print("Lütfen cekmek istediğiniz mikatrı giriniz: ");
        double miktar= scan.nextDouble();
        if (vadeli>=miktar){
            paraCekVadeli(miktar);
            System.out.println("çektiğiniz miktar: "+ miktar);
            System.out.println("Vadeli hesap bakiyeniz:"+paraFormat.format(vadeli));
        }else{
            System.out.println("yeterli bkiyeniz yoktur ");
        }

    }
    public void vadeliParaYatırma(){
        System.out.println("Vadeli hesap bakiyeniz:"+paraFormat.format(vadeli));
        System.out.print("lütfen yatırmak istediğiniz miktarı giriniz..");
        double miktar=scan.nextDouble();
        if(miktar>0){
            paraYatırVadeli(miktar);
            System.out.println("yatırdıgınız miktar: "+miktar);
            System.out.println("Vadeli hesap bakiyeniz:"+paraFormat.format(vadeli));

        }else{
            System.out.println("Yetersiz bakiye..");
        }

    }
}
