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
	 * 1-Sitenin i�eri�i almak 
	 * 2-Gelen i�eri�i sat�r sat�r okumal�y�m.
	 * 3-�lilgi yorumlar� bulabilmek i�in aktif Ay' �n bulundu�u sat�r� tespit et
	 */
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		String ay = "Haziran";
		System.out.println("***************************************");
		System.out.println("****** G�NL�K BUR� YORUMLARI **********");
		System.out.println("***************************************");
		System.out.println();
		
		Scanner scannerSecim = new Scanner(System.in); 
		System.out.print("L�tfen burcunuzu se�iniz.....: ");
		String secim = scannerSecim.nextLine();
		Scanner scannerSite = new Scanner(
				new URL("https://www.elle.com.tr/astroloji/"+secim).openStream() // Bu parametre bir url adresinden siteye ait html kodlar�n� string olarak �eker.
				, "UTF-8"
				);
		// bir say� giriniz...: 5 -> nextInt()
		// "fjjfdsfksl": nextLine();
		// scanner -> sat�r, sat�r okuyor. okunulan de�erin sonuna geldin mi?-> hasNext() -> return true/false
		// for(int i=0;i<4547;i++) bu efektif de�il
		/**
		 * while-> sonraki sat�r varm�
		 * var ise okumaya devam et
		 * yok ise d�ng�den ��k
		 */
		// List<String> yorumList = new ArrayList<String>();
		boolean flag= false;
		StringBuilder alinanYorumListesi = new StringBuilder();
		while(scannerSite.hasNext()) {   // -> parantezin i�i do�ru ise devam et
			String satir = scannerSite.nextLine();
			// contains -> bu de�eri i�eriyor ise -> true  ++
			// charAt   -> arad���n de�erin konumu -> int  ++			
			// split    -> �zel bir belirtece g�re par�al�yor -> T[] dizi d�n�yor ++
			// t�m harflar k���k ise 
			if(satir.contains(ay.toLowerCase()))
				flag = true;
			if(satir.contains("<p>") && flag) { // e�er sat�rda "<p>" var ise buldum
				alinanYorumListesi.append(satir.replace("&rsquo;", "' ").replace("</p>", "").replace("<p>", "").replace("<br>", "")+"~");
				flag=false;
			}
		
		}
		// String dizisi  -> �nceden boyutlar�n� belirlemelisiniz.
		String[] yorumListesi = alinanYorumListesi.toString().split("~");// {"yorum","yorum"}
		System.out.println("G�nl�k Bur� yorumunuz....: "+ yorumListesi[0]);
		System.out.println("PROGRAM SONLANDI.");
	}

}
