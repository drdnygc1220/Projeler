package UÇUSmüşteri;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Musteri musteri=new Musteri();//obje isimi diğer classın ismi
        //musteri.signId();
        //musteri.updatePassword();
        Scanner scan=new Scanner(System.in);
        //nereden nereye dediğimizde liste vermemiz gerekiyor her yere ucak yok sonucta
        System.out.println("nereden ucacaksınız");
        String nereden=scan.next();
        System.out.println("nereye ucacaksınız");
        String nereye=scan.next();
        System.out.println("hangi tarihte ucacaksınız? (yyyy/mm/dd)");
        String tarih=scan.next();
        //methodu cagıralım
        //set methodu oldugu için soutun içine yazdık..
        System.out.println(musteri.setUcusNo(nereden,nereye,tarih));

    }
}
