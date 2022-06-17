package com.muhammet;

import java.util.Scanner;

public class Runner_Ornek {

	public static void main(String[] args) {
/**
 * Bir algoritmanýn karmaþýklýðý ve zamaný nasýl bilirim?
 */
		long start = System.currentTimeMillis();  // 15/06/2022 12.01.55.124 -> long
		String ifade = "Ahmet Gel";
		Scanner scanner = new Scanner(System.in);
		//System.out.print("Ýþlem adedi giriniz...: ");
		//int islemAdedi = scanner.nextInt();
		int islemAdedi = 100_000;
		for(int i=0;i<islemAdedi;i++) {
			ifade = ifade + i; // 0 -> Ahmet Gel0 // 1 -> Ahmet Gel01  // 2-> Ahmet Gel012 
		}
		long end = System.currentTimeMillis();
		System.out.println("Ýþlem süresi....: "+ (end-start)+ ". milisaniye sürdü.");
		System.out.println("Ýdadenin uzunluðu.....: "+ ifade.length());

		start = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder();
		islemAdedi = 100_000;
		stringBuilder.append("Ahmet Gel");
		for(int i=0;i<islemAdedi;i++) {
			stringBuilder.append(i); 
		}
		end = System.currentTimeMillis();
		System.out.println("Ýþlem süresi....: "+ (end-start)+ ". milisaniye sürdü.");
		System.out.println("Ýdadenin uzunluðu.....: "+ stringBuilder.toString().length());
	}

}
