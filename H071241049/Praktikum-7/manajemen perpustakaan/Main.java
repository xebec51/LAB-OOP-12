import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        Member member = new Member("Andi", "M001");
        library.addMember(member);
        library.addItem(new Book("Buku 1", 1, "Tereliye"));
        library.addItem(new DVD("DVD 2", 2, 90));

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah item");
            System.out.println("2. Tambah anggota");
            System.out.println("3. Pinjam item");
            System.out.println("4. Kembalikan item");
            System.out.println("5. Lihat status perpustakaan");
            System.out.println("6. Lihat log aktivitas");
            System.out.println("7. Lihat item yang dipinjam anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            try {
                switch (pilihan) {
                    case 1:
                        System.out.print("Judul: ");
                        String title = sc.nextLine();
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Jenis: ");
                        String type = sc.nextLine();
                        if (type.equalsIgnoreCase("book")) {
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            library.addItem(new Book(title, id, author));
                        } else {
                            System.out.print("Durasi (menit): ");
                            int durasi = sc.nextInt();
                            library.addItem(new DVD(title, id, durasi));
                        }
                        break;
                    case 2:
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("ID Anggota: ");
                        String mid = sc.nextLine();
                        library.addMember(new Member(nama, mid));
                        break;
                    case 3:
                        System.out.print("ID item: ");
                        int idPinjam = sc.nextInt();
                        System.out.print("Lama pinjam (hari): ");
                        int hari = sc.nextInt();
                        LibraryItem itemPinjam = library.findItemById(idPinjam);
                        System.out.println(member.borrow(itemPinjam, hari));
                        library.getLogger().logActivity(itemPinjam.getTitle() + " dipinjam oleh " + member.getName());
                        break;
                    case 4:
                        System.out.print("ID item: ");
                        int idKembali = sc.nextInt();
                        System.out.print("Keterlambatan (hari): ");
                        int terlambat = sc.nextInt();
                        LibraryItem itemKembali = library.findItemById(idKembali);
                        System.out.println(member.returnItem(itemKembali, terlambat));
                        library.getLogger().logActivity(itemKembali.getTitle() + " dikembalikan oleh " + member.getName());
                        break;
                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;
                    case 6:
                        System.out.println(library.getAllLogs());
                        break;
                    case 7:
                        member.getBorrowedItems();
                        break;
                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem");
                        sc.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
