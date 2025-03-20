import java.util.Scanner; //Mengimport scanner untuk input pengguna

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Perpustakaan perpustakaan = new Perpustakaan();

        while(true){ //loop agar program terus berjalan hingga user memilih keluar
            System.out.println("\n====================");
            System.out.println("Sistem Manajemen Perpustakaan");
            System.out.println("======================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Keluar");
            System.out.println("Pilih Opsi:");

            int pilihan;
            if (scanner.hasNextInt()) { //Memeriksa apakah input adalah angka
                pilihan = scanner.nextInt();
                scanner.nextLine();//Membersihkan buffer
            } else {
                System.out.println("Input tidak valid! Masukkan angka 1-3!");
                scanner.nextLine();
                continue; //Kembali ke awal loop
            }
            switch (pilihan) { //Mengeksekusi berdasarkan pilihan user
                case 1 -> {
                    System.out.println("\n Tambah buku");
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine(); //Membaca judul buku
                    
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine(); //Membaca nama penulis
                    
                    System.out.println("Masukkan Tahun Terbit: ");
                    int tahun;
                    if(scanner.hasNextInt()){ //Memastikan input tahun berupa angka
                        tahun = scanner.nextInt();
                        scanner.nextLine(); //Memebrsihkan buffer
                    }else{
                        System.out.println("Tahun harus berupa angka!");
                        scanner.nextLine();
                        break;//Kembali ke menu utama
                    }
                    
                    Buku bukuBaru = new Buku(judul, penulis, tahun); //Instansiasi
                    perpustakaan.tambahBuku(bukuBaru); //Menambah buku ke perpustakaan
                }

                case 2 -> {
                    System.out.println("\n Pilihan Tampilan Buku");
                    System.out.println("1. Tampilkan Judul Saja");
                    System.out.println("2. Tampilkan Detail Buku");
                    System.out.println("Pilih Opsi: ");
                    
                    int opsi;
                    if(scanner.hasNextInt()){ //Memeriksai apakah input adalah angka
                        opsi = scanner.nextInt();
                        scanner.nextLine(); //Membersihkan buffer
                        perpustakaan.tampilkanSemuaBuku(opsi == 2);
                    }else{
                        System.out.println("Input tidak valid! Masukkan angka 1 atau 2.");
                        scanner.nextLine(); //Menghapus input yang salah
                    }
                }

                case 3 -> {
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan! ");
                    scanner.close(); //Menutup scanner
                    return;//Keluar dari program
                }
                default -> System.out.println("Pilihan tida valid! Masukkan angka 1-3.");
                }
            //Mengeksekusi berdasarkan pilihan user
                            }
            }
            }
