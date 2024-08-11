import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input jumlah data yang ingin dimasukkan
        System.out.print("Masukkan jumlah data yang ingin dimasukkan: ");
        int jumlahData = scanner.nextInt();
        scanner.nextLine();  // Membaca newline

        Mahasiswa[] mahasiswaArray = new Mahasiswa[jumlahData];

        // Meminta input nim, nama, dan nilai
        for (int i = 0; i < jumlahData; i++) {
            System.out.println("Masukkan data mahasiswa ke-" + (i + 1));

            // Meminta input NIM
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            // Meminta input Nama dengan validasi
            String nama;
            while (true) {
                System.out.print("Nama (3-20 karakter): ");
                nama = scanner.nextLine();
                Mahasiswa mahasiswaRepo = new Mahasiswa(nim, nama, 0);
                if (mahasiswaRepo.isNamaValid()) {
                    break;
                } else {
                    System.out.println("Nama harus antara 3 hingga 20 karakter.");
                }
            }

            // Meminta input Nilai dengan validasi
            int nilai;
            while (true) {
                System.out.print("Nilai (0-100): ");
                nilai = scanner.nextInt();
                scanner.nextLine();  // Membaca newline
                Mahasiswa mahasiswaRepo = new Mahasiswa(nim, nama, nilai);
                if (mahasiswaRepo.isNilaiValid()) {
                    break;
                } else {
                    System.out.println("Nilai harus di antara 0 hingga 100.");
                }
            }

            // Menyimpan data mahasiswa ke dalam array
            mahasiswaArray[i] = new Mahasiswa(nim, nama, nilai);
        }

        // Mencari mahasiswa dengan nilai tertinggi
        Mahasiswa mahasiswaTerbaik = mahasiswaArray[0];
        for (Mahasiswa mhs : mahasiswaArray) {
            if (mhs.nilai() > mahasiswaTerbaik.nilai()) {
                mahasiswaTerbaik = mhs;
            }
        }

        // Menampilkan mahasiswa dengan nilai tertinggi
        System.out.println("\nMahasiswa dengan nilai tertinggi:");
        mahasiswaTerbaik.displayInfo();

        scanner.close();
    }
}
