import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Perpustakaan {
    private static final String FILE_BUKU = "dataBuku.txt"; //Nama file penyimpanan
    private final ArrayList<Buku> daftarBuku;

    //Constructor untuk menginisialisasi daftar buku
    public Perpustakaan() {
        daftarBuku = new ArrayList<>();
        bacaDariFile(); //Load data dari file saat program dijalankan
    }

    //Method untuk menambahkan buku ke daftar
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);//Menambahkan objek buku
        simpanKeFile(); //Simpan daftar buku ke file
        System.out.println("Buku berhasil ditambahkan!");
    }
    
    //Menyimpan daftar buku ke file
    private void simpanKeFile() {
        try (FileWriter writer = new FileWriter(FILE_BUKU)) {
            for (Buku buku : daftarBuku) {
                writer.write(buku.formatData() + "\n");
            }
        }catch (IOException e) {
            System.out.println("Gagal menyimpan data buku");
        }
        }

    //Membaca buku dari file dan memuatnya ke daftar
    private void bacaDariFile() {
        File file = new File(FILE_BUKU);
        if(!file.exists()) return; //Jika file tidak ada, langsung keluar

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(";");
                if (data.length == 3) {
                    String judul = data[0];
                    String penulis = data[1];
                    int tahunTerbit = Integer.parseInt(data[2]);
                    daftarBuku.add(new Buku(judul, penulis, tahunTerbit));
                }
            }
        }catch(IOException e) {
            System.out.println("Gagal membaca data buku.");
        }
    }
    public void tampilkanSemuaBuku(boolean detail) {
        if (daftarBuku.isEmpty()){
            System.out.println("Tidak ada buku di perpustakaan.");
            return;
        }
        System.out.println("\nDaftar Buku di Perpustakaan: ");
        for (Buku buku : daftarBuku) {
            buku.tampilkanInfo(detail);
        }
    }
}