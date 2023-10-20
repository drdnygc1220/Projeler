package InterviewSorusu;
/*
int arr[]={3,5,1,2,7,9,2,3,5,7};
Verilen arrayi kullnarak asagıdaki gibi bir list return eden bir method yazınız
[arr'in ilk elemanı,arr'in 2. ve 3. elemanları toplamı
,arr'in 4.5.6. elemanları toplamı,arr'in 7.8.9.10. elemanları toplamı...]
//başlangı indexi,bitiş indexi var
 */

import java.util.ArrayList;
import java.util.List;

/*
                 0 ,  1 2,  3 4 5 , 6 7 8 9,
                {3,  (5,1),(2,7,9),(2,3,5,7)}
  baslangıç degerini bu formullle bulacagım:üçgensel sayı n.(n+1)/2....n yerine 0,1,2,3..
  bitiş degerini de indexin bir fazlasını kullanarak halledecegim (n+1)*(n+2)/2
başlangı indexi= 0-   1-      3-      6
bitiş indexi   = 0-   2-      5-      9
 */
public class interview1 {
    public static void main(String[] args) {
        int arr[]={3,5,1,2,7,9,2,3,5,7};
        toplama(arr);

    }

    public static void toplama(int arr[]) {
        List<Integer>list=new ArrayList<Integer>();//sum bulduktan sonra liste eklemem lazım
        int i = 0;//0,1,2,3,...

        while (i<arr.length) {
            int bas = i * (i+1) / 2;
            int bts = (i + 1) * (i + 2) / 2;
            //bitiş degeri lenghti gecerse sıkıntı olur bu yüzden if() yapıp loopu kırmalıyım
            if(bts>arr.length){
                break;
            }
            int sum = 0;
            for (; bas < bts; bas++) {//başlangıcı artıracak  bitie gelince loop kırılmalı,
                // loop kırılınca ben bir tane artırmalıyım,i yi artırınca başa dönmeliyim,while döngüsü yapmalıyız
                sum = sum + arr[bas];
            }
            list.add(sum);
            i++;
        }
        System.out.println(list);
    }
}
