package TestAtm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Hesap {
   private int müşteriNo;
    private int pın;
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

    public int getPın() {
        return pın;
    }

    public void setPın(int pın) {
        this.pın = pın;
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

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public DecimalFormat getParaFormat() {
        return paraFormat;
    }

    public void setParaFormat(DecimalFormat paraFormat) {
        this.paraFormat = paraFormat;
    }
    public double paraCekVadesizden(double miktar){
        vadesiz=vadesiz-miktar;
        return vadesiz;

    }
    public double paraYatırVadesize(double miktar){
        vadesiz=vadesiz+miktar;
        return vadeli;

    }
    public double paraCekVadeli(double miktar){
        vadeli=vadeli-miktar;
        return vadeli;

    }
    public double paraYatırVadeli(double miktar){
        vadeli=vadeli+miktar;
        return vadeli;

    }
    public void vadesizParaCektiktenSonra(){
        System.out.println("Vadesiz hesap bakiyeniz: "+paraFormat.format(vadesiz));
        System.out.println("Çekmek istediğiniz tutarı giriniz: ");
        double miktar= scan.nextDouble();
        if(vadesiz>miktar){
            paraCekVadesizden(miktar);
            System.out.println("çektiğiniz miktar: "+miktar);
            System.out.println("Vadesiz hesap bakiyeniz: "+paraFormat.format(vadesiz));
        }else{
            System.out.println("yeterli bakiyeniz bulunmamaktadır...");
        }

    }
    public void vadesizParaYatırdıktanSonra(){
        System.out.println("vadesiz hesap bakiyeniz: "+paraFormat.format(vadesiz));
        System.out.println("lütfen yatırmak istediğiniz miktarı giriniz: ");
        double miktar= scan.nextDouble();
        paraYatırVadesize(miktar);
        System.out.println("yatırdıgınız miktar: "+miktar);
        System.out.println("vadesiz hesap bakiyeniz: "+paraFormat.format(vadesiz));

    }
    public void vadeliParaCektiktenSonra(){
        System.out.println("Vadeli hesap bakiyeniz: "+paraFormat.format(vadeli));
        System.out.println("çekmek istediğiniz miktarı giriniz:");
        double miktar= scan.nextDouble();
        if(vadeli>miktar){
            paraCekVadeli(miktar);
            System.out.println("çektiğiniz miktar: "+miktar);
            System.out.println("vadeli hesap bakiyeniz: "+paraFormat.format(vadeli));

        }else{
            System.out.println("yeterli bakiyeniz bulunmamaktadır..");
        }


    }
    public void vadeliParaYatırdıktanSonra(){
        System.out.println("vadeli hesap bakiyeniz: "+paraFormat.format(vadeli));
        System.out.println("lütfen yatırmak istediğiniz miktarını giriniz:");
        double miktar= scan.nextDouble();
        paraYatırVadeli(miktar);
        System.out.println("yatırdıgınız miktar: "+miktar);
        System.out.println("vadeli hesap bakiyeniz: "+paraFormat.format(vadeli));

    }
}
