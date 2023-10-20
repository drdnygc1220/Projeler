package ATMhesap;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Options extends Account{
    Scanner scan=new Scanner(System.in);
    DecimalFormat paraFormat=new DecimalFormat("'$',###,##0.00");
    //müşterileri müşteri numarası ve pın koduyla kaydedecgim..
    HashMap<Integer,Integer> musteriData=new HashMap<>();
    public void login() {
        boolean flag = true;
        //yanlış möüşteri numarasında tekrar tekrar girsin diye do while döngüsü yapaacgız..

        do {
            try {
                musteriData.put(12345, 123);
                musteriData.put(23456, 234);
                musteriData.put(34567, 345);
                musteriData.put(45678, 456);
                musteriData.put(56789, 567);


                //müşteri numarasını degiştirmem lazım
                System.out.print("lütfen müşteri numaranızı giriniz: ");
                setMüşteriNo(scan.nextInt());

                System.out.println();

                System.out.print("lütfen pın numarasını giriniz: ");
                setPinNo(scan.nextInt());
            } catch (Exception e) {
                System.out.println("lütfen gecerli müşteri ve pın numarasını giriniz,cıkmak için 'Q' tuşuna basınız");
                String cıkış = scan.next();
                if (cıkış.equalsIgnoreCase("Q")) {
                    flag = false;//loop kırılıyor burada
                }

            }
            //kişinin girdiği keylue ve value kısmı dogru mu diye bakmalıyım..
            //entry set =tek tek bakmak yerine sete cevirip musteri no ve pın bir deger olarak düşürür..
            Set<Map.Entry<Integer, Integer>> musteriDataSet = musteriData.entrySet();
            int count=0;
            for (Map.Entry<Integer, Integer> w : musteriDataSet) {
                if (w.getKey() == getMüşteriNo() && w.getValue() == getPinNo()) {
                    //ilerleyebilirsin..
                    işlemSec();
                    flag=false;

                }else{
                    count++;
                }

            }
            if(count==musteriDataSet.size()){
                System.out.println("müşteri numarası veya pın yanlıştır...");
                System.out.println("tekrar denemek için herhangi bir sayıya basınız.");
                System.out.println("çıkmak için u ya basınız..");
                String cıkış=scan.next().toLowerCase();
                if(cıkış.equals("q")){
                    flag=false;
                }
            }


        } while (flag);
    }
    public void işlemSec(){
        System.out.println("aşagıdaki işlemlerden biriniz seciniz: ");
        System.out.println("1-vadesiz hesap işlemleri");
        System.out.println("2-vadeli hesap işlemleri");
        System.out.println("3:çıkış");
        int secim=scan.nextInt();
        switch (secim){
            case 1://vadesiz işlemler
                vadesizİşlemler();


                break;
            case 2://vadeli işlemler
                vadeliİşlemler();

                break;
            case 3://çıkış
                System.out.println("teşekkür ederiz,tekrar bekleriz..");
                break;
            default:
                System.out.println("lütfen gecerli bir secim yapınız..");
                işlemSec();//methodun içinden method cagırdık,yada do while yapardık..
                break;
        }

    }
    public void vadesizİşlemler(){
        do{
            System.out.println("yapmak istediğiniz işlemi seciniz:");
            System.out.println("1-Hesap bakiyesi ");
            System.out.println("2-para cekme");
            System.out.println("3-para yatırma");
            System.out.println("4-cıkış");
            int secim=scan.nextInt();
            if(secim==4){

                break;//ya loop ta yada switch de kullanılır..o yüzden kodun tamamını do while koyduk..
            }
            switch (secim){//4ün dışında birşey yaparsa
                case 1:
                    System.out.println("vadesiz hesap bakiyeniz:"+ paraFormat.format(getVadesiz()));
                    break;
                case 2:
                    vadesizBakiyeParaCektiktenSonra();
                    break;
                case 3:
                vadesizParaYatırdıktanSonra();
                    break;
                    /*
                case  4:(4 secerse loop kırılacak zaten o yüzden yazmadık)
                    System.out.println("iyi günler");
                    break;

                     */
                default:
                    System.out.println("yanlış giriş yaptınız tekrar deneyiniz");
                    System.out.println("1,2,3,4 den birini seciniz..");
            }
        }while (true);
        işlemSec();
    }
    public void vadeliİşlemler(){
        do{
            System.out.println("yapmak istediğiniz işlemi seciniz:");
            System.out.println("1-Hesap bakiyesi ");
            System.out.println("2-para cekme");
            System.out.println("3-para yatırma");
            System.out.println("4-cıkış");
            int secim=scan.nextInt();
            if(secim==4){
                break;
            }
            switch (secim){
                case 1:
                    System.out.println("vadeli hesap bakiyeniz: "+paraFormat.format(getVadeli()));
                    break;
                case 2:
                    vadeliParaCekme();
                    break;
                case 3:
                    vadeliParaYatırma();
                    break;
                default:
                    System.out.println("yanlış giriş yaptınız tekrar deneyiniz..");
                    System.out.println("1,2,3,4 ten birini seciniz..");
            }
        }while(true);
        işlemSec();
    }
}
