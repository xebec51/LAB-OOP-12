import java.util.*;

public class Member {
    private String name;
    private String memberId;
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia.");
        }
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) {
            return "Item tidak ditemukan dalam daftar pinjaman.";
        }
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
            System.out.println("+------+----------------------+\n| ID   | Judul                |\n+------+----------------------+" );
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-4d | %-20s |%n", item.itemId, item.getTitle());
            }
            System.out.println("+------+----------------------+" );
        }
    }

    public String getName() {
        return name;
    }

    public String getMemberId() {
        return memberId;
    }
}
