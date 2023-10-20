package TestAtm;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Seçenekler extends Hesap {
    Scanner scan=new Scanner(System.in);
    DecimalFormat paraFormat=new DecimalFormat("'$',###,##0.00");

    HashMap<Integer,Integer>musteriData=new HashMap<>();
    public void login(){
        boolean flag=true;
        do{
            try {
                musteriData.put(12345, 123);
                musteriData.put(23456, 234);
                musteriData.put(34567, 345);
                musteriData.put(45678, 456);
                musteriData.put(56789, 567);


                System.out.print("lütfen müşteri numarasını giriniz: ");
                setMüşteriNo(scan.nextInt());
                System.out.println();
                System.out.println("lütfen pın kodunuzu giriniz: ");
                setPın(scan.nextInt());

            }catch (Exception e){
                System.out.println("lütfen gecerli müşteri no ve pın giriniz..");
                System.out.println("Çıkmak için lütfen 'Q' tuşun basınız: ");
                String cıkış= scan.next();
                if(cıkış.equalsIgnoreCase("q")){
                    flag=false;
                }

            }
            Set<Map.Entry<Integer,Integer>>musteriDataSet=musteriData.entrySet();
            int count=0;
            for (Map.Entry<Integer,Integer>w:musteriDataSet){
                if(w.getKey()==getMüşteriNo() && w.getValue()==getPın()){
                    işlemler();
                   flag=false;
                }else{
                  count++;
                }
            }
            if(count==musteriDataSet.size()){
                System.out.println("lütfen gecerli pın ve no giriniz..");
                System.out.println("cıkmak için u tusuna basınız:");
                String cıkıs=scan.next().toLowerCase();
                if(cıkıs.equals("u")){
                    System.out.println("iyi günler dileriz..");
                    flag=false;
                }

            }


        }while (flag);
    }
    public void işlemler(){
        System.out.println("lütfen yapmak istediğiniz işlemi seciniz");
        System.out.println("1-Vadesiz Hesap İşlemleri");
        System.out.println("2-Vadeli Hesap İşemleri");
        System.out.println("3-Çıkış ");
        int işlem=scan.nextInt();
        switch (işlem){
            case 1://vadesiz işlemler
                vadesizİşlemler();
                break;
            case 2://vadeli işlemler
                vadeliİşlemler();
                break;
            case 3:
                System.out.println("iyi günler..");
                break;
            default:
                System.out.println("lütfen gecerli işlem yapınız..");
                işlemler();
                break;

        }
    }
    public void vadesizİşlemler(){
        do{
            System.out.println("Yapmak istediğiniz işlem seciniz..");
            System.out.println("1-Hesap görüntüleme");
            System.out.println("2-Para yatırma");
            System.out.println("3-Para çekme");
            System.out.println("4-çıkış");
            int işlem=scan.nextInt();
            if(işlem==4){
                break;
        }
            switch (işlem){
                case 1:
                    System.out.println("hesap bakiyeniz: "+paraFormat.format(getVadesiz()));
                    break;
                case 2:
                    vadesizParaYatırdıktanSonra();
                    break;
                case 3:
                    vadesizParaCektiktenSonra();
                    break;
                default:
                    System.out.println("lütfen 1,2,3,4 bu numaralardan birine basınız");
            }


        }while (true);
        System.out.println("iyi günler dileriz...");


    }
    public void vadeliİşlemler(){
        do{
            System.out.println("lütfen yapmak istediğiniz işlemi seciniz..");
            System.out.println("1-hesap bakiye");
            System.out.println("2-para yatırma");
            System.out.println("3-para çekme");
            System.out.println("4-çıkış");
            int secim= scan.nextInt();
            if(secim==4) {
                break;
            }
            switch (secim){
                case 1:
                    System.out.println("hesap bakiyeniz: "+paraFormat.format(getVadeli()));
                    break;
                case 2:
                    vadeliParaYatırdıktanSonra();
                    break;
                case 3:
                    vadeliParaCektiktenSonra();
                    break;
                default:
                    System.out.println("lütfen 1,2,3,4 bunlardan birine basınız..");
            }
        }while (true);
        System.out.println("iyi günler dileriz..");



    }

}
