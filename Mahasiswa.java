public record Mahasiswa(String nim, String nama, int nilai) {

    public boolean isNamaValid() {
        return nama.length() >= 3 && nama.length() <= 20;
    }

    // Metode untuk memvalidasi nilai (antara 0-100)
    public boolean isNilaiValid() {
        return nilai >= 0 && nilai <= 100;
    }

    // Metode untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Nilai: " + nilai);
    }

    // Method to return nilai
    public int nilai() {
        return this.nilai;
    }
}
