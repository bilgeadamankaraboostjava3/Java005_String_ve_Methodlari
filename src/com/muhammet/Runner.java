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
		// �NEML� -> bilgisayar sisteminde ba�lang�� say� index de�erimiz 0(s�f�r) d�r.
		String ifade = "  Bu g�n    hava �ok ama �ok ya���l� olacak m�� .";
		//              0 ....                                          48 = 49 adet karakter
		String tekharf = "a"; // char[] dizi -> {'a'}
		System.out.println(ifade);
		/**
		 * byte -> 8bit
		 * short -> 16bit
		 */
		/**
		 * String in uzunlu�u
		 * de�i�ken.length() -> ifadenin uzunlu�unu int t�r�nden verir. 
		 */
		int ifadeninUzunlugu = ifade.length(); //2 -> int uzunluk = 2
		System.out.println("tekharf uzunluk...: "+ ifadeninUzunlugu);
		System.out.println("ifade uzunluk...: "+ ifade.length());
		
		/**
		 * Getting a single char
		 */
		// ifadenin index numaras� 13 olan karakterini al
		// ��RENMED�K -> char[] karakterdisizi = new char[10]; -> karakterdizisi[2]
		System.out.println("13. karakter nedir?....: "+ ifade.charAt(13));
		// dizinini uzunlu�undaki de�i�kene e�itim yapabilir miyim?
		System.out.println(ifadeninUzunlugu+ ". de�ere eri�im...: "+ ifade.charAt(ifadeninUzunlugu-1));
		//  Dizi gibi de�erine ola��lamaz System.out.println("13. karakter nedir?....: "+ ifade[2]);
		
		/**
		 * Finding index
		 */
		// ifadenin i�inde aran�lan de�erin ilk ge�ti�i index numaras�n� int olarak d�ner.
		// NOT!!!! -> E�er aran�lan de�er bulunamaz ise -1 de�eri d�ner.
		System.out.println("a harfi ilk nerede ge�mektedir?....: "+ ifade.indexOf("a"));
		System.out.println("a harfi ilk nerede ge�mektedir?....: "+ ifade.indexOf('a'));
		System.out.println("a harfi ilk nerede ge�mektedir?....: "+ ifade.indexOf('a',(ifadeninUzunlugu/2)));
	
		System.out.println("a� harfi ilk nerede ge�mektedir?....: "+ ifade.indexOf("a�"));
		
		// bu g�n hava �ok ya���l� -> 3,4,
		
		/**
		 * Getting a Substring
		 * substring(beginindex, endindex) -- kapsama dahil de�i�dir.
		 * "ahmet yaman".substring(2,7) -> "met y" 
		 * substring(beginindex);
		 * "ahmet yaman".substring(3) -> "et yaman" 
		 */
		
		System.out.println("kesilecekifade");
		System.out.println("kesilecekifade.substring(2,6)...: "+ "kesilecekifade.substring(2,6)...: ".substring(2, 6));
		System.out.println("ifadenin yar�s�...: "+ ifade.substring(0,(ifadeninUzunlugu/2) ));// [0,20)
		String yarimIfade = ifade.substring(0, ifadeninUzunlugu/2);
		System.out.println("a harfini ara...: "+ yarimIfade.indexOf("a",16));
		System.out.println("istenilen konumdan kesme...: "+ ifade.substring(20));
		
		/**
		 * trim() -> bir ifadenin ba��nda ve sonunda olan bo�lujklar� siliyor.
		 */
		// ka:    kgjgfkh
		// �f:   74358
		String sf="admin",ka="Admin";
		if(sf.trim() == "admin" && ka == "admin") {}
		
		/**
		 * Adjusting Case
		 * toUpperCase() -> a = A, A = A 
		 * toLowerCase() -> A = a, a = a
		 * toUpperCase(Locale.ENGLISH)  // ingilizce de i-> I  
		 * toLowerCase(Locale.ROOT) // t�rk�e de i -> �
		 * Uygulamalar�n�z bir server �zerinde �al��acak. dili -> Eng, T�rk�e
		 * ADM�N -> 
		 * 
		 */
		//     true     ve     true   = true
		System.out.println("Kullan�c� ad� Upper...: "+ ka.toUpperCase());
		System.out.println("Kullan�c� ad� Lower...: "+ ka.toLowerCase());
		System.out.println("Kullan�c�ad� ToLower..: "+ ka.toLowerCase(Locale.forLanguageTag("tr-TR")));
		System.out.println("Kullan�c�ad� ToLower..: "+ ka.toLowerCase(Locale.ENGLISH));
		// equalsIgnore
		//------------------------
		System.out.println("----------------------------------");
		System.out.println(ka.toLowerCase());
		System.out.println("admin".toLowerCase());
		System.out.println("-----------------------------------");
		
		
		if(ka.toLowerCase() == "admin".toLowerCase() && sf == "admin") {
			System.out.println("Giri� yapt�n�z");
		} else {
			System.out.println("Yanl�� k.s ya da �f.");
		}
		
		
		//******  �NEML�  ********
		// bir yerde(Database, File) kullan�c� biglierini tuttu�umuzu d���nelim.
		String dbEmail= "Muhammet@gmail.com";
		String dbSifrem = "1234**";
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("******************************");
		System.out.println("**** MUHAMMET OTOMASYON  *****");
		System.out.println("******    LOG�N     ***********");
		System.out.println("******************************");
		System.out.println();
		System.out.print("Kullan�c�(email) ad�.....: ");
		String scEmail = scanner.nextLine();// metin girip "enter" a bas�l�nca de�eri string olarak al�r
		
		System.out.print("Kullan�c� �ifre..........: ");
		String scSifre = scanner.nextLine();
		// trim() -> bo�luklar� al�r. -> "  selam   arkada�lar   ".trim(); -> "selam   arkada�lar"
		// toLowerCase()
		// System.out.println(dbEmail.toLowerCase());
		// System.out.println(scEmail.trim().toLowerCase());
		/*
		// Bu Kullan�m bu senaryo i�in do�ru de�ildir
		if(dbEmail.toLowerCase() == scEmail.trim().toLowerCase()) { // ko�ul do�ru ise bunu yap
			System.out.println("Sisteme Giri� Yap�ld�");
		}else {
			System.out.println("Kullan�c� ad� ya da �ifre hatal�d�r.");
		}
		*/
		// -> "ahmet".equals("ahmet") -> true
		// D�KKAT -> nesir yaz� yazar gibi kod yazmay�n.
		// 2. Ad�m -> �ifrenin de do�ru oldu�u durum eklenmeli.
		// Mobilde -> dsfsdh 
		// dbSifrem.equals(scSifre.trim())
		//if(  dbEmail.toLowerCase().equals(scEmail.trim().toLowerCase()) &&  dbSifrem.equals(scSifre.trim()) ) 
		if(  dbEmail.toLowerCase().equals(scEmail.trim().toLowerCase()) // email olarak girilen bilgiyi kontrol ettik
			 &&  // VE
			 dbSifrem.equals(scSifre.trim()) // �ifre bilgisini kontrol ettik.   
			) { // ahmet == ahmet ->true/false
			System.out.println("Sisteme Giri� Yap�ld�");
		}else {
			System.out.println("Kullan�c� ad� ya da �ifre hatal�d�r.");
		}
		
		/**
		 * Replacing Values
		 * Default replace -> t�m e�le�en de�erleri de�i�tirir.
		 * "Ay�e bize Geldi".replace('�','s') -> "Ayse bize Geldi"
		 * "Ay�e bize Geldi".replace("�","s") -> "Ayse bize Geldi"
		 */
		/**
		 * 1- �rnek bir kira s�zle�mesi olsun. tarflar olsun. isim d�i�ecek.
		 */
		String sozlesme = "Ahmet bey evini Hasan KO� isimli ki�iye .....tl ye kiralad�.";
		String yenisozlesme_asli = sozlesme.replace("Hasan KO�", "Asl� BA�");
		System.out.println("Yein s�zle�me....: "+ yenisozlesme_asli);
		
		/**
		 * 2- web url -> bo�luk, t�rk�e katakter sorun ��kart�r.		 * 
		 * 3- https://www.isbasvurusu.org/muhammethoca i� ba�vurusu.pdf -> 404 hatas�na sebep olabilir.
		 * 
		 */
		String dosyaadi = "muhammethoca i� ba�vurusu.pdf";
		dosyaadi = dosyaadi.replace(" ", "-") // "muhammethoca-i�-ba�vurusu.pdf"
							.replace("�", "s");
		System.out.println(dosyaadi);
		
		/**
		 * Bir string i�inde aran�lan bir de�erin olup olmad���n� s�yler -> true/false
		 * "bug�n hava �ok ya���l�".contains("��") -> true
		 */
		String yeniIfade = "Bug�n hava �ok ya���l� ama ben d��ar� ��ka��m";
		System.out.println("Aranan(en).....: "+ yeniIfade.contains("en"));
		System.out.println("Aranan(en).....: "+ yeniIfade.contains(" en"));
		System.out.println("Aranan(en).....: "+ yeniIfade.contains("en "));
		
		
		// "Ahmet DENeme".equalsIgnoreCase("ahmet deneme") -> 
		// "Ahmet DENeme".equals("ahmet deneme") -> false
		System.out.println("Ahmet DENeme".equalsIgnoreCase("ahmet deneme"));
		
		/**
		 * startsWidth,endsWidth
		 * *** Dizi kullan�m�nda -> split()
		 */
		// "abcd".startsWith("a") -> true
		// "abcd".startsWith("A") -> false
		// "abcd".endsWith("d") -> true
		// "abcd".endsWith("D") -> false
		/**
		 * split(",") -> aranan ifadeye [regex] e g�re metni string array haline getirir. 
		 */
		String isimListesi= "Ahmet,Hakan,Burcu,Ceyda,Bahar";// {"Ahmet","Hakan","Burcu"....}	
		System.out.println(isimListesi.split(","));
		String[] isimler = isimListesi.split(",");
		System.out.println("2. ki�i.....: "+ isimler[1]);
		
		String ogrenciListesi= "OKL1,Ahmet,12;OKL2,Bahar,13;OKL3,Deniz,11";
		String[] ogrenciler = ogrenciListesi.split(";"); // OKL1,Ahmet,12 - OKL2,Bahar,13 - OKL3,Deniz,11
		String[] ogrenciBilgisi = ogrenciler[1].split(",");// OKL2 - Bahar - 13
		for(String ogrenci: ogrenciBilgisi)
			System.out.println(ogrenci);
		
		
		
				/*
		ifade = "  Bu g�n    hava �ok ama �ok ya���l� olacak m�� . ".trim();
		int index=0,sayac=0,index2=0; 
		while(index!=-1) {
			index2 = ifade.indexOf(' ',index+1);
			if(index2!=-1 && ifade.charAt(index+1)!=' ') sayac++;
			index = index2;
		}
		System.out.println("Kelime say�s�...: "+ (sayac+1));
		*/
	}

}
