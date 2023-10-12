package atm.simulator;

import java.util.Scanner;

/**
 *
 * @author gamze
 */
public class ATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sifre = "3401";
         
        while(true){
                System.out.println("Şifrenizi giriniz..");
                sifre = scanner.nextLine();// nextLine()  kullanıcının girdiği tam satırı (boşluklar dahil) alır,next() ise yalnızca ilk kelimeyi alır.

                if(sifre.equals("3401")){
                     System.out.println("Şifreniz doğru giriş yapılıyor..."); break;
                } 
                else if (!sifre.equals("3401")){

                    System.out.println("şifre hatalı tekrar deneyin");
                }      
        }
       
        double bakiye = 2000;
        String islemler =   "1.işlem: Bakiye öğrenme \n"  +
                            "2.işlem: Para Çekme \n" +
                            "3.işlem: Para Yatırma \n" +
                            "çıkış için q ya basınız";
        System.out.println("**************************************");
        System.out.println("İşlemler\n"  +  islemler);
        System.out.println("**************************************");

        OUTER: //label: döngünün dışındaki  kontrol noktası,case q durumunda döngüden yani tamamen switch-case yapısından çıkmayı sağlar.
        while (true) {
            System.out.println(" İşlem seçiniz ");
            String islem = scanner.nextLine();
            switch (islem) { //Neden switch case yapısını kullandım?Çünkü if else ile komplex oluyor ve hata verebiliyor bazı koşulları sunamıyordum.
                case "q":
                        System.out.println("Programdan çıkılıyor");
                        break OUTER;
                case "1":
                        System.out.println(" Bakiyeniz : " +  bakiye);
                        break;
                case "2":

                        System.out.println("Çekmek istediğiniz tutarı girin");
                        int tutar = scanner.nextInt();
                        scanner.nextLine();
                        if (bakiye - tutar < 0) {

                            System.out.println("Yeterli Bakiye Yok . Bakiyeniz : " + bakiye);
                        }
                        else {
                            bakiye -= tutar;
                            System.out.println("Yeni bakiyeniz : " + bakiye); //güncel bakiyeyi de kullanıcıya gösterelim.
                        }      break;

                case "3":

                        System.out.print("Yatırmak istediğiniz tutar : ");
                        int miktar = scanner.nextInt();
                        scanner.nextLine();
                        bakiye += miktar;
                        System.out.println("Yeni Bakiyeniz  : " + bakiye);
                        break;

                default:// üstteki durumlar uymazsa default  çalışır.
                        System.out.println("Geçersiz İşlem"); 
                        break;
            }  
        }  
    }
}

