package UÇUSmüşteri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ucuslar{
    //ucusları kaydetmek için hashmap yapıyoruz,develooper lar database koyacak
    HashMap<String,String>ucuslar=new HashMap<>();
    //key kısmına;ankara-erzurum:value kısmına;tarihler yazılacak
    List<String>locations=new ArrayList<>();
    List<String>ucusSaati=new ArrayList<>();

    //iller için method
    public List setLocations(){
        locations.add("ankara");
        locations.add("erzurum");
        locations.add("istanbul");
        return locations;
    }
    //saatler için maethod yazdık,tarihleri kullanıcıdan alacagım..
    public List setSaati(){
        ucusSaati.add("06:00");
        ucusSaati.add("09:00");
        ucusSaati.add("11:00");
        ucusSaati.add("21:30");
        ucusSaati.add("23:20");
        return ucusSaati;
    }
    //hashmap döndüren method
    public HashMap setUcus(){
        setLocations();//bu method calıştıgında hava alanları calışsım
        setSaati();//saat de olmalı
        ucuslar.put(locations.get(0)+"==>"+locations.get(1),ucusSaati.get(0));
        ucuslar.put(locations.get(1)+"==>"+locations.get(0),ucusSaati.get(1));
        ucuslar.put(locations.get(0)+"==>"+locations.get(2),ucusSaati.get(4));
        ucuslar.put(locations.get(2)+"==>"+locations.get(0),ucusSaati.get(0));
        ucuslar.put(locations.get(1)+"==>"+locations.get(2),ucusSaati.get(2));
        ucuslar.put(locations.get(2)+"==>"+locations.get(1),ucusSaati.get(5));
        return ucuslar;

    }
}
