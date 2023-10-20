package UÇUSmüşteri;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Musteri {
    //müşteri ile ilgili özellikler,methodlar
    private String isim;//insana, objeye ait
    private String musteriId;
    private static int musteriPassword = 3000;//static yapınca gökteki ay gibi durmadan artırınca her müşteri farklı alacak
    private static int id = 1000;
    //static olanlar classa ait olmayanlar objeye aittir..
    private static int flightNo = 9000;//unıque olması lazım

    //müşteri ile diyaloğa girecegim o yüzden scanner yapmamız lazım
    Scanner scan = new Scanner(System.in);
    //ALİ CAN=AC1001 YADA ALİ CAN=3000 yapmak için HASHMAP yapmak lazım
    HashMap<String, String> isimId = new HashMap<>();
    HashMap<String, Integer> isimPwd = new HashMap<>();//bu bilgileri database den cekeriz suan hashmap ler database gibi kullanıyorum


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(String musteriId) {
        id++;
        String arr[] = getIsim().split(" ");//isim ve soy adın sadece baş harfini almaya calışıyorum
        // 1-stringe cevirmeliyiz başına boşluk koyarız,ama bu genelde istenmez
        this.musteriId = "" + arr[0].charAt(0) + arr[1].charAt(0) + 1001;
        //2.yol bütün kodun başına String.ValueOf() alıp yapabilirz..
        //this.musteriId = String.valueOf(arr[0].charAt(0)+arr[1].charAt(0)+1001);
    }

    public static int getMusteriPassword() {
        return musteriPassword;
    }

    public static void setMusteriPassword(int musteriPassword) {
        Musteri.musteriPassword = musteriPassword;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Musteri.id = id;
    }

    public static int getFlightNo() {
        return flightNo;
    }

    public static void setFlightNo(int flightNo) {
        Musteri.flightNo = flightNo;
    }

    //HASHMAP deposuna müşteri ekleme methodu
    public void musteriEkle() {//tek başına calışmaz birşeyin içine koyacagız
        isimId.put(getIsim(), getMusteriId());//ismi ıd put methoduyla ekledik
        isimPwd.put(getIsim(), getMusteriPassword());
    }

    //musteri ekleme olayını personel yapsın
    public void signId() {//sign=kaydolmak imza kimliği
        do {//tek müşteriye calışmamak için döngüye aldık..
            System.out.println("Musteri eklemek ister misiniz? (E/H)");
            //adam hayır derse break yapacagım
            char onay = scan.next().toLowerCase().charAt(0);//büyük harf ihmal etmek için tolowercase..en sona cahrda koyamayız
            if (onay == 'h') {
                break;
            } else if (onay == 'e') {
                System.out.print("lütfen tam isminizi giriniz: ");
                scan.nextLine();//next() den sonra nextlıne sıkntı veriyor..
                setIsim(scan.nextLine());//müşteri ali can girecet set methodu onu alican yapacak degiştirecek yani
                try {
                    //isim eklemeyi try içine koydum dogrıysa eklenecek yanlışsa eklenmeyecek
                    setMusteriId(musteriId);//adama sen oluştur demiyoruz..otomatik ıd oluşacak.set de düzeltme yaptık
                    setMusteriPassword(++musteriPassword);//aynı classta oldugum için get demesemde olur
                    musteriEkle();
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("soyadınızı da girmelisiniz");
                }


            } else {
                System.out.println("lütfen 'E' veya 'H' harflerinden birini giriniz..");
            }
        } while (true);
        System.out.println(isimId);
        System.out.println(isimPwd);

    }

    public void updatePassword() {//pasword degiştirme
        int newPassword;//oluşturacagım paswordu almak için variable oluşturuyorum
        String musteriId = "";
        String isim = "";
        int varOLanPassword = 0;
        //bunları ver şifre degiştirmene izin veriyorum
        do {
            System.out.println("password oluşturmak için isminizi giriniz: ");
            System.out.println("password oluşturmayı sonlandırmak için 'Q' basınız.. ");
            scan.nextLine();
            isim = scan.nextLine();
            if (isim.equalsIgnoreCase("Q")) {
                System.out.println("Güvenlik Uyarısı: passwordunuz değştirilmemiştir ");
                break;
            }
            //eski passwordunu baktık eşit mi diye
            System.out.println("eski passwordunuzu giriniz: ");
            int eskiPasword = 0;
            try {
                eskiPasword = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("password rakamlardan oluşmalı..");

            }

            try {

                varOLanPassword = isimPwd.get(isim);
            } catch (NullPointerException e) {
                varOLanPassword = -1;
            }
            if (!(eskiPasword == varOLanPassword)) {
                System.out.println("Passwordunuz veya isminiz gecersizdir");
                //break; koymuyorum adama tekrar hak verdim bir hatada kovmayalım adamı

            } else {
                //şifre degiştirmeye geldik
                System.out.println("yeni passwordunuzu giriniz: ");
                newPassword = scan.nextInt();
                scan.nextLine();
                isimPwd.put(isim, newPassword);
                break;
            }
        } while (true);
        if (!(varOLanPassword == -1)) {
            System.out.println(isim + "Yeni Password:" + isimPwd.get(isim));

        }
    }

    //ankaradan erzuruma 2020/12/23 UCUS NUMARASI=AE201223 YAPACAGIZ...
    public String setUcusNo(String nereden, String nereye, String tarih) {
        String ucusNo=""+nereden.charAt(0)+nereye.charAt(0)+tarih.substring(2,4)+
                tarih.substring(5,7)+tarih.substring(8);
        //charların arasına + koyarsak matematiksel işlem olarak algılar ;
        //2 yol var:1- char kullanırsak başına boş string koyarsak concatıon yapar
        //2:char yerine substring kullanırsınız
        return ucusNo;


    }
}




















