import java.util.Scanner;

import APP.model.*;
import APP.service.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU PERPUSTAKAAN =====");
            System.out.println("1. Tambah item");
            System.out.println("2. Tambah member");
            System.out.println("3. Pinjam item");
            System.out.println("4. Kembalikan item");
            System.out.println("5. Lihat status perpustakaan");
            System.out.println("6. Lihat log aktivitas");
            System.out.println("7. Lihat item yang dipinjam anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- Tambah Item ---");
                    System.out.print("Jenis (1 = Book, 2 = DVD): ");
                    int jenis = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Judul: ");
                    String title = sc.nextLine();

                    System.out.print("ID Item: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (library.isItemIdExists(id)) {
                        System.out.println("ID item sudah digunakan.");
                        break;
                    }

                    if (jenis == 1) {
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        Book book = new Book(title, id, author);
                        System.out.println(library.addItem(book));
                        library.getLogger().logActivity(book.getTitle() + " berhasil ditambahkan");
                    } else if (jenis == 2) {
                        System.out.print("Durasi (menit): ");
                        int durasi = sc.nextInt();
                        sc.nextLine();
                        DVD dvd = new DVD(title, id, durasi);
                        System.out.println(library.addItem(dvd));
                        library.getLogger().logActivity(dvd.getTitle() + " berhasil ditambahkan");
                    } else {
                        System.out.println("Jenis tidak valid.");
                    }
                    break;
                case 2:
                    System.out.println("\n--- Tambah Anggota ---");
                    System.out.print("Nama Member: ");
                    String name = sc.nextLine();

                    System.out.print("ID Member: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    if (library.isMemberIdExists(memberId)) {
                        System.out.println("ID member sudah digunakan.");
                        break;
                    }

                    Member member = new Member(name, memberId);
                    library.getMembers().add(member);
                    System.out.println("Member berhasil ditambahkan.");
                    library.getLogger().logActivity("Member " + member.getName() + " ditambahkan");
                    break;
                case 3:
                    System.out.println("\n--- Pinjam Item ---");
                    System.out.print("ID Member: ");
                    int borrowerId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID Item: ");
                    int itemId = sc.nextInt();

                    System.out.print("Lama pinjam (hari): ");
                    int days = sc.nextInt();
                    sc.nextLine();

                    try {
                        Member m = library.findMemberById(borrowerId);
                        LibraryItem item = library.findItemById(itemId);
                        String result = m.borrow(item, days);
                        library.getLogger().logActivity(item.getTitle() + " dipinjam oleh " + m.getName());
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Gagal meminjam: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("\n--- Kembalikan Item ---");
                    System.out.print("ID Member: ");
                    int returnerId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID Item: ");
                    int returnItemId = sc.nextInt();

                    System.out.print("Jumlah hari keterlambatan: ");
                    int daysLate = sc.nextInt();
                    sc.nextLine();

                    try {
                        Member m = library.findMemberById(returnerId);
                        LibraryItem item = library.findItemById(returnItemId);
                        String result = m.returnItem(item, daysLate);
                        library.getLogger().logActivity(item.getTitle() + " dikembalikan oleh " + m.getName());
                        System.out.println(result);
                    } catch (Exception e) {
                        System.out.println("Gagal mengembalikan: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\n--- Status Perpustakaan ---");
                    System.out.println(library.getLibraryStatus());
                    break;
                case 6:
                    System.out.println("\n--- Log Aktivitas ---");
                    String logs = library.getAllLogs().trim();
                    if (logs.isEmpty()) {
                        System.out.println("Belum ada aktivitas tercatat.");
                    } else {
                        System.out.println(logs);
                    }
                    break;
                case 7:
                    System.out.println("\n--- Item yang Dipinjam Anggota ---");
                    System.out.print("ID Member: ");
                    int idMemberCari = sc.nextInt();
                    sc.nextLine();

                    try {
                        Member targetMember = library.findMemberById(idMemberCari);
                       targetMember.getBorrowedItems();
                    } catch (Exception e) {
                        System.out.println("Gagal menampilkan: " + e.getMessage());
                    }
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}
