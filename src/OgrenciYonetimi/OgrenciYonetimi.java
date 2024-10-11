package OgrenciYonetimi;

import java.util.Scanner;

public class OgrenciYonetimi {
	static Scanner input = new Scanner(System.in);
	static final int OGRENCIKAPASITE = 5;
	static int ogrenciSayi;
	
	
	public static void main(String[] args) {
		String[][] ogrencilerDizi = new String[OGRENCIKAPASITE][4];
		
		menuDeger(ogrencilerDizi);
	}
	
	private static int anaMenu() {
		
		System.out.println("Öğrenci Not Yönetim Sistemi");
		System.out.println("1. Öğrenci Ekle");
		System.out.println("2. Öğrencileri Listele");
		System.out.println("3. Öğrenci Notunu Güncelle");
		System.out.println("4. Ortalama Hesapla");
		System.out.println("5. Öğrenci Sil");
		System.out.println("6. Belirli Notun Altındaki Öğrencileri Listele");
		System.out.println("0. Çıkış");
		
		
		return input.nextInt();
		
	}
	
	public static void menuDeger(String[][] ogrencilerDizi) {
		while (true) {
			int secim = anaMenu();
			switch (secim) {
				case 1:
					ogrenciEkle(ogrencilerDizi);
					break;
				case 2:
					ogrenciListele(ogrencilerDizi);
					break;
				case 3:
					ogrenciNotDegis(ogrencilerDizi);
					break;
				case 4:
					ogrenciOrtalmaAl(ogrencilerDizi);
					break;
				case 5:
					ogrenciSil(ogrencilerDizi);
					break;
				case 6:
					notAltıListele(ogrencilerDizi);
					break;
				case 0:
					System.out.println("Çıkış Yapılıyor");
					return;
				default:
					System.out.println("Geçersiz Karakter Tekrar Deneyin");
				
			}
		}
	}
	
	public static void ogrenciEkle(String[][] ogrenciDizi) {
		
		input.nextLine();
		
		System.out.println("Öğrenci Ekle Menüsü");
		
		System.out.println();
		
		
		System.out.println("bölüme " + (ogrenciSayi + 1) + ". öğrenciyi girmektesiniz.");
		int eklenebilecekOgrenciSayisi = (OGRENCIKAPASITE - ogrenciSayi);
		System.out.println("Eklenebilecek öğrenci sayısı :" + eklenebilecekOgrenciSayisi);
		
		if (eklenebilecekOgrenciSayisi <= 0) {
			System.out.println("Sınıf Dolu! Daha fazla Öğrenci ekleyemezsiniz.");
			return;
		}
		
		
		ogrenciDizi[ogrenciSayi][0] = String.valueOf(ogrenciSayi);
		System.out.println("Öğrenci Adını Girin:");
		ogrenciDizi[ogrenciSayi][1] = input.nextLine();
		System.out.println("Ders Adını Girin:");
		ogrenciDizi[ogrenciSayi][2] = input.nextLine();
		System.out.println("Notu Girin:");
		ogrenciDizi[ogrenciSayi][3] = String.valueOf(input.nextInt());
		
		ogrenciSayi++;
		
		
	}
	
	
	public static void ogrenciListele(String[][] ogrencilerDizi) {
		
		input.nextInt();
		if (ogrenciSayi == 0) {
			System.out.println("Listelenecek Öğrenci Bulunamadı.");
			return;
		}
		
		System.out.println("ID\t\tAD\t\tDERS\t\tNOT");
		
		for (int i = 0; i < ogrenciSayi; i++) {
			for (int j = 0; j < ogrencilerDizi[0].length; j++) {
				System.out.print(ogrencilerDizi[i][j] + "\t\t");
			}
			System.out.println(" ");
		}
		
	}
	
	public static void ogrenciNotDegis(String[][] ogrencilerDizi) {
		input.nextInt();
		System.out.println("Notunu Güncellemek İstediğiniz Öğrencinin ID Girin");
		
		int degisId = input.nextInt();
		
		System.out.println("Yeni Notu Girin");
		int yeniNot = input.nextInt();
		
		ogrencilerDizi[degisId][3] = String.valueOf(yeniNot);
		
	}
	
	public static void ogrenciOrtalmaAl(String[][] ogrencilerDizi) {
		input.nextInt();
		if (ogrenciSayi == 0) {
			System.out.println("Ortalamasını Alacağınız Öğrenci Bulunamamaktadır");
			return;
		}
		
		
		double notToplam = 0;
		
		for (int i = 0; i < ogrenciSayi; i++) {
			notToplam += Double.valueOf(ogrencilerDizi[i][3]);
		}
		
		System.out.println("Mevcut Öğrencilerin Not Ortalaması: " + (notToplam / ogrenciSayi));
	}
	
	public static void ogrenciSil(String[][] ogrencilerDizi) {
		input.nextInt();
		System.out.println("Kaldırmak İstediğiniz Öğrencinin ID numarasını Girin:");
		
		String[][] yeniDizi = new String[OGRENCIKAPASITE][4];
		
		int silId = input.nextInt();
		
		if (silId < 0 || silId >= ogrenciSayi) {
			System.out.println("Geçersiz ID");
			return;
		}
		
		for (int i = silId; i < ogrenciSayi - 1; i++) {
			ogrencilerDizi[i] = ogrencilerDizi[i + 1];
		}
		
		ogrenciSayi--;
		
		ogrencilerDizi[ogrenciSayi] = new String[4];
		
		
		/*
		System.out.println("Silmek istediğiniz Öğrenci IDsini Girin");
		
		String id = input.next();
		boolean silId = false;
		
		for (int i = 0; i < ogrenciSayi; i++) {
			if (ogrencilerDizi[i][0] != null && ogrencilerDizi[i][0].equals(id)){
				for (int j = i; j < ogrenciSayi - 1; j++) {
					ogrencilerDizi[j] = ogrencilerDizi[j + 1];
				}
				ogrencilerDizi[ogrenciSayi - 1] = null;
				ogrenciSayi--;
				silId = true;
				System.out.println("Öğrenci Silindi");
				break;
			}
		} if (!silId) {
			System.out.println("Öğrenci Bulunamadı");
		}
		
		 */
	}
	
	public static void notAltıListele(String[][] ogrencilerDizi) {
		input.nextInt();
		System.out.println("Hangi Değerden küçük Notları Listelemek İstersiniz");
		int kucuk = input.nextInt();
		
		System.out.println("ID\t\tAD\t\tDERS\t\tNOT");
		
		
		for (int i = 0; i < ogrenciSayi; i++) {
			for (int j = 0; j < ogrencilerDizi[0].length; j++) {
				if (Integer.valueOf(ogrencilerDizi[i][3]) <= kucuk) {
					System.out.print(ogrencilerDizi[i][j] + "\t\t");
				}
			}
			System.out.println(" ");
		}
		
	}
}