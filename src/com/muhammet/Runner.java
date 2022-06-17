package com.muhammet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class Runner {

	public static void main(String[] args) {
		//char dizisi    :  {' ',' ','B','u',' ','g' .....} dizi
		// index dizilimi:    0 , 1 , 2 , ....  
		// ÖNEMLÝ -> bilgisayar sisteminde baþlangýç sayý index deðerimiz 0(sýfýr) dýr.
		String ifade = "  Bu gün    hava Çok ama çok yaðýþlý olacak mýþ .";
		//              0 ....                                          48 = 49 adet karakter
		String tekharf = "a"; // char[] dizi -> {'a'}
		System.out.println(ifade);
		/**
		 * byte -> 8bit
		 * short -> 16bit
		 */
		/**
		 * String in uzunluðu
		 * deðiþken.length() -> ifadenin uzunluðunu int türünden verir. 
		 */
		int ifadeninUzunlugu = ifade.length(); //2 -> int uzunluk = 2
		System.out.println("tekharf uzunluk...: "+ ifadeninUzunlugu);
		System.out.println("ifade uzunluk...: "+ ifade.length());
		
		/**
		 * Getting a single char
		 */
		// ifadenin index numarasý 13 olan karakterini al
		// ÖÐRENMEDÝK -> char[] karakterdisizi = new char[10]; -> karakterdizisi[2]
		System.out.println("13. karakter nedir?....: "+ ifade.charAt(13));
		// dizinini uzunluðundaki deðiþkene eðitim yapabilir miyim?
		System.out.println(ifadeninUzunlugu+ ". deðere eriþim...: "+ ifade.charAt(ifadeninUzunlugu-1));
		//  Dizi gibi deðerine olaþýlamaz System.out.println("13. karakter nedir?....: "+ ifade[2]);
		
		/**
		 * Finding index
		 */
		// ifadenin içinde aranýlan deðerin ilk geçtiði index numarasýný int olarak döner.
		// NOT!!!! -> Eðer aranýlan deðer bulunamaz ise -1 deðeri döner.
		System.out.println("a harfi ilk nerede geçmektedir?....: "+ ifade.indexOf("a"));
		System.out.println("a harfi ilk nerede geçmektedir?....: "+ ifade.indexOf('a'));
		System.out.println("a harfi ilk nerede geçmektedir?....: "+ ifade.indexOf('a',(ifadeninUzunlugu/2)));
	
		System.out.println("að harfi ilk nerede geçmektedir?....: "+ ifade.indexOf("að"));
		
		// bu gün hava çok yaðýþlý -> 3,4,
		
		/**
		 * Getting a Substring
		 * substring(beginindex, endindex) -- kapsama dahil deðiþdir.
		 * "ahmet yaman".substring(2,7) -> "met y" 
		 * substring(beginindex);
		 * "ahmet yaman".substring(3) -> "et yaman" 
		 */
		
		System.out.println("kesilecekifade");
		System.out.println("kesilecekifade.substring(2,6)...: "+ "kesilecekifade.substring(2,6)...: ".substring(2, 6));
		System.out.println("ifadenin yarýsý...: "+ ifade.substring(0,(ifadeninUzunlugu/2) ));// [0,20)
		String yarimIfade = ifade.substring(0, ifadeninUzunlugu/2);
		System.out.println("a harfini ara...: "+ yarimIfade.indexOf("a",16));
		System.out.println("istenilen konumdan kesme...: "+ ifade.substring(20));
		
		/**
		 * trim() -> bir ifadenin baþýnda ve sonunda olan boþlujklarý siliyor.
		 */
		// ka:    kgjgfkh
		// þf:   74358
		String sf="admin",ka="Admin";
		if(sf.trim() == "admin" && ka == "admin") {}
		
		/**
		 * Adjusting Case
		 * toUpperCase() -> a = A, A = A 
		 * toLowerCase() -> A = a, a = a
		 * toUpperCase(Locale.ENGLISH)  // ingilizce de i-> I  
		 * toLowerCase(Locale.ROOT) // türkçe de i -> Ý
		 * Uygulamalarýnýz bir server üzerinde çalýþacak. dili -> Eng, Türkçe
		 * ADMÝN -> 
		 * 
		 */
		//     true     ve     true   = true
		System.out.println("Kullanýcý adý Upper...: "+ ka.toUpperCase());
		System.out.println("Kullanýcý adý Lower...: "+ ka.toLowerCase());
		System.out.println("Kullanýcýadý ToLower..: "+ ka.toLowerCase(Locale.forLanguageTag("tr-TR")));
		System.out.println("Kullanýcýadý ToLower..: "+ ka.toLowerCase(Locale.ENGLISH));
		// equalsIgnore
		//------------------------
		System.out.println("----------------------------------");
		System.out.println(ka.toLowerCase());
		System.out.println("admin".toLowerCase());
		System.out.println("-----------------------------------");
		
		
		if(ka.toLowerCase() == "admin".toLowerCase() && sf == "admin") {
			System.out.println("Giriþ yaptýnýz");
		} else {
			System.out.println("Yanlýþ k.s ya da þf.");
		}
		
		
		//******  ÖNEMLÝ  ********
		// bir yerde(Database, File) kullanýcý biglierini tuttuðumuzu düþünelim.
		String dbEmail= "Muhammet@gmail.com";
		String dbSifrem = "1234**";
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("******************************");
		System.out.println("**** MUHAMMET OTOMASYON  *****");
		System.out.println("******    LOGÝN     ***********");
		System.out.println("******************************");
		System.out.println();
		System.out.print("Kullanýcý(email) adý.....: ");
		String scEmail = scanner.nextLine();// metin girip "enter" a basýlýnca deðeri string olarak alýr
		
		System.out.print("Kullanýcý þifre..........: ");
		String scSifre = scanner.nextLine();
		// trim() -> boþluklarý alýr. -> "  selam   arkadaþlar   ".trim(); -> "selam   arkadaþlar"
		// toLowerCase()
		// System.out.println(dbEmail.toLowerCase());
		// System.out.println(scEmail.trim().toLowerCase());
		/*
		// Bu Kullaným bu senaryo için doðru deðildir
		if(dbEmail.toLowerCase() == scEmail.trim().toLowerCase()) { // koþul doðru ise bunu yap
			System.out.println("Sisteme Giriþ Yapýldý");
		}else {
			System.out.println("Kullanýcý adý ya da Þifre hatalýdýr.");
		}
		*/
		// -> "ahmet".equals("ahmet") -> true
		// DÝKKAT -> nesir yazý yazar gibi kod yazmayýn.
		// 2. Adým -> þifrenin de doðru olduðu durum eklenmeli.
		// Mobilde -> dsfsdh 
		// dbSifrem.equals(scSifre.trim())
		//if(  dbEmail.toLowerCase().equals(scEmail.trim().toLowerCase()) &&  dbSifrem.equals(scSifre.trim()) ) 
		if(  dbEmail.toLowerCase().equals(scEmail.trim().toLowerCase()) // email olarak girilen bilgiyi kontrol ettik
			 &&  // VE
			 dbSifrem.equals(scSifre.trim()) // Þifre bilgisini kontrol ettik.   
			) { // ahmet == ahmet ->true/false
			System.out.println("Sisteme Giriþ Yapýldý");
		}else {
			System.out.println("Kullanýcý adý ya da Þifre hatalýdýr.");
		}
		
		/**
		 * Replacing Values
		 * Default replace -> tüm eþleþen deðerleri deðiþtirir.
		 * "Ayþe bize Geldi".replace('þ','s') -> "Ayse bize Geldi"
		 * "Ayþe bize Geldi".replace("þ","s") -> "Ayse bize Geldi"
		 */
		/**
		 * 1- Örnek bir kira sözleþmesi olsun. tarflar olsun. isim dðiþecek.
		 */
		String sozlesme = "Ahmet bey evini Hasan KOÇ isimli kiþiye .....tl ye kiraladý.";
		String yenisozlesme_asli = sozlesme.replace("Hasan KOÇ", "Aslý BAÞ");
		System.out.println("Yein sözleþme....: "+ yenisozlesme_asli);
		
		/**
		 * 2- web url -> boþluk, türkçe katakter sorun çýkartýr.		 * 
		 * 3- https://www.isbasvurusu.org/muhammethoca iþ baþvurusu.pdf -> 404 hatasýna sebep olabilir.
		 * 
		 */
		String dosyaadi = "muhammethoca iþ baþvurusu.pdf";
		dosyaadi = dosyaadi.replace(" ", "-") // "muhammethoca-iþ-baþvurusu.pdf"
							.replace("þ", "s");
		System.out.println(dosyaadi);
		
		/**
		 * Bir string içinde aranýlan bir deðerin olup olmadýðýný söyler -> true/false
		 * "bugün hava çok yaðýþlý".contains("ýþ") -> true
		 */
		String yeniIfade = "Bugün hava çok yaðýþlý ama ben dýþarý çýkaðým";
		System.out.println("Aranan(en).....: "+ yeniIfade.contains("en"));
		System.out.println("Aranan(en).....: "+ yeniIfade.contains(" en"));
		System.out.println("Aranan(en).....: "+ yeniIfade.contains("en "));
		
		
		// "Ahmet DENeme".equalsIgnoreCase("ahmet deneme") -> 
		// "Ahmet DENeme".equals("ahmet deneme") -> false
		System.out.println("Ahmet DENeme".equalsIgnoreCase("ahmet deneme"));
		
		/**
		 * startsWidth,endsWidth
		 * *** Dizi kullanýmýnda -> split()
		 */
		// "abcd".startsWith("a") -> true
		// "abcd".startsWith("A") -> false
		// "abcd".endsWith("d") -> true
		// "abcd".endsWith("D") -> false
		/**
		 * split(",") -> aranan ifadeye [regex] e göre metni string array haline getirir. 
		 */
		String isimListesi= "Ahmet,Hakan,Burcu,Ceyda,Bahar";// {"Ahmet","Hakan","Burcu"....}	
		System.out.println(isimListesi.split(","));
		String[] isimler = isimListesi.split(",");
		System.out.println("2. kiþi.....: "+ isimler[1]);
		
		String ogrenciListesi= "OKL1,Ahmet,12;OKL2,Bahar,13;OKL3,Deniz,11";
		String[] ogrenciler = ogrenciListesi.split(";"); // OKL1,Ahmet,12 - OKL2,Bahar,13 - OKL3,Deniz,11
		String[] ogrenciBilgisi = ogrenciler[1].split(",");// OKL2 - Bahar - 13
		for(String ogrenci: ogrenciBilgisi)
			System.out.println(ogrenci);
		
		
		
				/*
		ifade = "  Bu gün    hava Çok ama çok yaðýþlý olacak mýþ . ".trim();
		int index=0,sayac=0,index2=0; 
		while(index!=-1) {
			index2 = ifade.indexOf(' ',index+1);
			if(index2!=-1 && ifade.charAt(index+1)!=' ') sayac++;
			index = index2;
		}
		System.out.println("Kelime sayýsý...: "+ (sayac+1));
		*/
	}

}
