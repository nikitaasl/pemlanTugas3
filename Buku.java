class Buku{
    private final String judul;
    private final String penulis;
    private final int tahunTerbit;

    //Constructor untuk menginisialisasi atribut buku
    public Buku(String judul, String penulis, int tahunTerbit){
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }
    //Method untuk menampilkan informasi buku
    public void tampilkanInfo (boolean detail) {
        if (detail) {
           //Jika detail = true -> Tampilkan semua informasi buku
           System.out.println(judul + "-" + penulis + " (" + tahunTerbit + ")");
        }else{
            //Jika detail = false -> hanya tampilkan judul saja
            System.out.println(judul);
        }
        }

        //Format data untuk disimpan ke file
        public String formatData(){
            return judul + "," + penulis + "," + tahunTerbit;
        }
    }