package com.muhammet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner_BurcYorumu {

	/**
	 * BURC YORUM
	 * 1-Sitenin içeriði almak 
	 * 2-Gelen içeriði satýr satýr okumalýyým.
	 * 3-Ýlilgi yorumlarý bulabilmek için aktif Ay' ýn bulunduðu satýrý tespit et
	 */
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		String ay = "Haziran";
		System.out.println("***************************************");
		System.out.println("****** GÜNLÜK BURÇ YORUMLARI **********");
		System.out.println("***************************************");
		System.out.println();
		
		Scanner scannerSecim = new Scanner(System.in); 
		System.out.print("Lütfen burcunuzu seçiniz.....: ");
		String secim = scannerSecim.nextLine();
		Scanner scannerSite = new Scanner(
				new URL("https://www.elle.com.tr/astroloji/"+secim).openStream() // Bu parametre bir url adresinden siteye ait html kodlarýný string olarak çeker.
				, "UTF-8"
				);
		// bir sayý giriniz...: 5 -> nextInt()
		// "fjjfdsfksl": nextLine();
		// scanner -> satýr, satýr okuyor. okunulan deðerin sonuna geldin mi?-> hasNext() -> return true/false
		// for(int i=0;i<4547;i++) bu efektif deðil
		/**
		 * while-> sonraki satýr varmý
		 * var ise okumaya devam et
		 * yok ise döngüden çýk
		 */
		// List<String> yorumList = new ArrayList<String>();
		boolean flag= false;
		StringBuilder alinanYorumListesi = new StringBuilder();
		while(scannerSite.hasNext()) {   // -> parantezin içi doðru ise devam et
			String satir = scannerSite.nextLine();
			// contains -> bu deðeri içeriyor ise -> true  ++
			// charAt   -> aradýðýn deðerin konumu -> int  ++			
			// split    -> özel bir belirtece göre parçalýyor -> T[] dizi dönüyor ++
			// tüm harflar küçük ise 
			if(satir.contains(ay.toLowerCase()))
				flag = true;
			if(satir.contains("<p>") && flag) { // eðer satýrda "<p>" var ise buldum
				alinanYorumListesi.append(satir.replace("&rsquo;", "' ").replace("</p>", "").replace("<p>", "").replace("<br>", "")+"~");
				flag=false;
			}
		
		}
		// String dizisi  -> önceden boyutlarýný belirlemelisiniz.
		String[] yorumListesi = alinanYorumListesi.toString().split("~");// {"yorum","yorum"}
		System.out.println("Günlük Burç yorumunuz....: "+ yorumListesi[0]);
		System.out.println("PROGRAM SONLANDI.");
	}

}
