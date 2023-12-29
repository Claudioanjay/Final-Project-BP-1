package uas_dio_fix;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UAS_DIO_FIX {

    static int[] harga = {12000, 18000, 17000, 24000, 20000, 13000, 21000, 15000, 22000, 29000};
    static String[] roti = {"Twist Donut", "Choco Donut Pretzel", "Sausage Donut", "Bulgogi Qroquete", "Choco Pastry", "Real Ganache", "Messy Choco", "Salt Butter Roll", "Premium Toast", "Pan Bread"};
    static String[] PaketPemesananRoti = {"\n30 Twist Donut\n30 Sausage Donut\nGratis Box\nGratis Air Mineral Gelas", "\n35 Salt Butter Roll\n35 Choco Pastry\nGratis Box\nGratis Air Mineral Gelas", "\n40 Twist Donut\n40 Real Ganache\n40 Bulgogi Qroquete\nGratis Box\nGratis Air Mineral Gelas", "\n50 Premium Toast\n50 Messy Choco\n50 Pan Bread\nGratis Box\nGratis Air Mineral Gelas"};
    static int[] HargaPaketPemesananRoti = {1000000, 1300000, 2100000, 3800000};
    static String[] NamaPaketPemesanan = {"Paket 1", "Paket 2", "Paket 3", "Paket 4"};
    static String[] MetodeBayar = {"BCA", "BNI", "Qris", "Tunai"};
    static int[] KeranjangJumlah = new int[roti.length];
    static String[] KeranjangRoti = new String[roti.length];
    static int[] SubTotal = new int[roti.length];
    static int[] Pesanan = new int[roti.length];
    static int Total = 0;
    static String[] NamaSatpam = {"Suyono", "Satria", "Mahatir", "Sambo", "Dudung"};
    static LocalDateTime currentDateTime = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("--------- SELAMAT DATANG ---------");
        System.out.println("     TOKO ROTI DIO LES JOURS     ");
        System.out.println("Pilihan Menu");
        System.out.println("1. Beli Roti\n2. Pemesanan Roti\n3. Call Center\n4. Keluar");
        System.out.print("Pilih Menu : ");
        int pilih = s.nextByte();
        switch (pilih) {
            case 1:
                BeliRoti();
                break;
            case 2:
                PemesananRoti();
                break;
            case 3:
                CallCenter();
                break;
            case 4:
                Keluar();
                break;
            default:
                System.out.println("Menu Tidak ada");
                break;
        }
    }

    public static int BeliRoti() {
        int PilihanMenuRoti;
        Scanner s = new Scanner(System.in);
        System.out.println("---------------- Daftar Menu ----------------");
        for (int i = 0; i < roti.length; i++) {
            System.out.printf("%-2d. %-25s = Rp %3d\n",
                    (i + 1), roti[i], harga[i]);
        }
        System.out.println(" \nPilihan Roti");
        boolean beli = false;

        while (beli == false) {
            System.out.print("Pilihan Menu Roti : ");
            PilihanMenuRoti = s.nextInt();
            System.out.print("Jumlah Pilihan Menu Roti : ");
            int JumlahPilihan = s.nextInt();
            for (int i = 0; i < roti.length; i++) {

                if (PilihanMenuRoti - 1 == i) {
                    Pesanan[i] = i;
                    KeranjangRoti[i] = roti[i];
                    KeranjangJumlah[i] = JumlahPilihan;
                    SubTotal[i] = harga[i] * JumlahPilihan;
                    Total += SubTotal[i];
                    System.out.println("Pilihan menu roti adalah " + KeranjangJumlah[i] + " " + roti[i] + " dengan harga Rp " + SubTotal[i]);
                }

            }
            JumlahPilihan = 0;
            System.out.println("Apakah ada tambahan? \n1. Ya\n2. Tidak");
            System.out.print("Pilihan : ");
            int tambahanbeli = s.nextInt();
            if (tambahanbeli == 1) {
                beli = false;
            } else if (tambahanbeli == 2) {
                beli = true;
                System.out.println("Lanjut ke pembayaran\nSilahkan pilih metode pembayaran : \n1. BCA\n2. BNI\n3. Qris\n4. Tunai");
                System.out.print("Pilihan Metode Pembayaran : ");
                int metodepembayaran = s.nextInt();
                if (metodepembayaran == 1) {
                    System.out.println("Transfer ke Nomor Rekening BCA 01879085 a.n Claudio Tanadi");
                } else if (metodepembayaran == 2) {
                    System.out.println("Transfer ke Nomor Rekening BNI 456903429 a.n Claudio Tanadi");
                } else if (metodepembayaran == 3) {
                    System.out.println("Silahkan Scan Barcode Qris yang Telah Disediakan");
                } else if (metodepembayaran == 4) {
                    System.out.println("Bayar di kasir");
                } else {
                    System.out.println("Tidak ada");
                }
                System.out.println("Menu Lanjutan\n1. Cetak Struk\n2. Keluar");
                System.out.print("Pilihan : ");
                int PilihanPembayaran = s.nextInt();
                if (PilihanPembayaran == 1) {
                    System.out.println("------------------------------------");
                    System.out.println("       TOKO ROTI DIO LES JOURS      ");
                    System.out.println("  Jalan Pangeran Diponegoro No. 21  ");
                    System.out.println("         Telp. 0852 3670 2463       ");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
                    String formattedDateTime = currentDateTime.format(formatter);
                    System.out.println("  Waktu  :  " + formattedDateTime);
                    System.out.println("");
                    for (int i = 0; i < roti.length; i++) {
                        if (KeranjangJumlah[i] > 0) {
                            System.out.println(KeranjangJumlah[i] + " " + KeranjangRoti[i]);
                            System.out.println("Rp " + SubTotal[i]);
                            System.out.println("");
                        }

                    }
                    System.out.println("Total Belanja            : Rp " + Total);

                    for (int i = metodepembayaran; i < MetodeBayar.length; i++) {
                        System.out.println("Metode Pembayaran        : " + MetodeBayar[i - 1]);
                        break;
                    }
                    System.out.println("");
                    System.out.println("TERIMA KASIH TELAH BERBELANJA DI\n    TOKO ROTI DIO LES JOURS    \n      SELAMAT MENIKMATI");
                    System.out.println("------------------------------------");
                } else if (PilihanPembayaran == 2) {
                    System.out.println("TERIMA KASIH");
                }
            }

        }
        return Total;
    }

    public static void PemesananRoti() {
        Scanner s = new Scanner(System.in);
        String nama, hari, bulan;
        int tanggal, tahun;
        System.out.println("Silahkan Masukkan Nama Pemesan, Hari, dan Tanggal Pemesanan : ");
        System.out.print("Nama : ");
        nama = s.next();
        System.out.print("Hari : ");
        hari = s.next();
        System.out.print("Tanggal : ");
        tanggal = s.nextInt();
        System.out.print("Bulan (Nama Bulan) : ");
        bulan = s.next();
        System.out.print("Tahun : ");
        tahun = s.nextInt();
        System.out.println("");
        System.out.println("------------- Paket Roti -------------");
        for (int i = 0; i < PaketPemesananRoti.length; i++) {
            System.out.printf("%-2d. %-100s",
                    (i + 1), NamaPaketPemesanan[i]);
            System.out.println(PaketPemesananRoti[i]);
            System.out.println("Harga : " + HargaPaketPemesananRoti[i]);
            System.out.println("");
        }
        System.out.println("");
        System.out.print("Pillihan Paket Pemesanan : ");
        int PesanPaket = s.nextInt();
        System.out.println("Lanjut ke pembayaran\nSilahkan pilih metode pembayaran : \n1. BCA\n2. BNI\n3. Qris\n4. Tunai");
        System.out.print("Pilihan Metode Pembayaran : ");
        int metodepembayaran = s.nextInt();
        if (metodepembayaran == 1) {
            System.out.println("Transfer ke Nomor Rekening BCA 01879085 a.n Claudio Tanadi");
        } else if (metodepembayaran == 2) {
            System.out.println("Transfer BNI ke Nomor Rekening BNI 456903429 a.n Claudio Tanadi");
        } else if (metodepembayaran == 3) {
            System.out.println("Silahkan Scan Barcode Qris yang Telah Disediakan");
        } else if (metodepembayaran == 4) {
            System.out.println("Bayar di kasir");
        } else {
            System.out.println("Tidak ada");
        }
        System.out.println("Selanjutnya\n1. Cetak Struk\n2. Keluar");
        System.out.print("Pilihan : ");
        int PilihanPesan = s.nextInt();
        if (PilihanPesan == 1) {
            System.out.println("------------------------------------");
            System.out.println("       TOKO ROTI DIO LES JOURS      ");
            System.out.println("  Jalan Pangeran Diponegoro No. 21  ");
            System.out.println("         Telp. 0852 3670 2463       ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            System.out.println("   Waktu : " + formattedDateTime);
            System.out.println("");
            System.out.println("           PEMESANAN ROTI           ");
            System.out.println("");
            System.out.println("Nama Pemesan    : " + nama);
            System.out.println("Hari            : " + hari);
            System.out.println("Tanggal         : " + tanggal + " " + bulan + " " + tahun);
            for (int i = PesanPaket; i <= PaketPemesananRoti.length; i++) {
                System.out.println("\nPilihan paket adalah " + NamaPaketPemesanan[i - 1]);
                System.out.println(PaketPemesananRoti[i - 1] + "");
                System.out.println("");
                System.out.println("Total Harga             : Rp " + HargaPaketPemesananRoti[i - 1]);
                break;
            }
            for (int j = metodepembayaran; j <= MetodeBayar.length; j++) {
                System.out.println("Metode Pembayaran       : " + MetodeBayar[j - 1]);
                System.out.println("");
                System.out.println("TERIMA KASIH TELAH BERBELANJA DI\n    TOKO ROTI DIO LES JOURS    \n      SELAMAT MENIKMATI");
                System.out.println("------------------------------------");
                break;

            }
        } else if (PilihanPesan == 2) {
            System.out.println("TERIMA KASIH");
        } else {
            System.out.println("Menu Tidak Ada");
        }
    }

    public static void CallCenter() {
        Scanner s = new Scanner(System.in);
        System.out.println("Selamat Datang di Menu Call Center\nMasukkan Keluhan Anda : ");
        System.out.println("1. Program Kasir Error\n2. Panggil Security\n3. Keluar");
        System.out.print("Pilihan Menu : ");
        int MenuCallCenter = s.nextInt();
        s.nextLine();
        if (MenuCallCenter == 1) {
            System.out.println("Masukkan keluhan program kasir yang error : ");
            String keluhan = s.nextLine();
            System.out.println("Keluhan masalah : " + keluhan);
            System.out.println("Keluhan telah disampaikan ke pusat informasi, harap tunggu sebentar. Masalah akan segera diselesaikan. Apabila ada kendala lagi dapat memanggil satpam.");
        } else if (MenuCallCenter == 2) {
            boolean ketemu = false;

            System.out.println("Masukkan kendala yang terjadi : ");
            String kendala = s.nextLine();
            while (ketemu == false) {
                int i;
                System.out.print("Masukkan nama satpam yang ingin dipanggil : ");
                String CariSatpam = s.next();
                for (i = 0; i < NamaSatpam.length; i++) {
                    if (NamaSatpam[i].compareToIgnoreCase(CariSatpam) == 0) {
                        ketemu = true;
                        break;
                    }
                }
                if (ketemu == true) {
                    System.out.println("");
                    System.out.println("Kendala : " + kendala);
                    System.out.println("Satpam " + NamaSatpam[i] + " akan menuju ke kasir anda");
                } else if (ketemu == false) {
                    System.out.println("Satpam tidak ada. Apakah ingin panggil ulang?\n1. Ya\n2 Tidak");
                    System.out.print("Pilihan : ");
                    int pilihan = s.nextInt();
                    if (pilihan == 1) {
                        ketemu = false;
                    } else if (pilihan == 2) {
                        System.out.println("Terima Kasih");
                    } else {
                        System.out.println("Menu Tidak Ada");
                    }
                }
            }

        } else if (MenuCallCenter == 3) {
            System.out.println("TERIMA KASIH, HUBUNGI CALL CENTER BILA ADA KENDALA");
        } else {
            System.out.println("Menu Tidak Ada");
        }
    }

    public static void Keluar() {
        System.out.println("TERIMA KASIH");
    }
}
