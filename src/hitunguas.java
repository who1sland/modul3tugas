import java.util.Scanner;

class HitungLuasLingkaran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jari-jari lingkaran: ");
        double jariJari = scanner.nextDouble();

        double luas = Math.PI * Math.pow(jariJari, 2);
        System.out.println("Luas lingkaran: " + luas);

        // Menutup scanner
        scanner.close();
    }
}