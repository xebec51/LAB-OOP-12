package APP.model;

import java.util.List;
import java.util.ArrayList;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<LibraryItem> getBorrowedItemsList() {
        return borrowedItems;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia.");
        }
        borrowedItems.add(item);
        return item.borrowItem(days);
    }

    public String returnItem(LibraryItem item, int daysLate) {
        borrowedItems.remove(item);
        String result = item.returnItem();
        double denda = item.calculateFine(daysLate);
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", denda);
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
        } else {
            System.out.println("+-----+----------------------------+");
            System.out.println("| ID  | Judul                      |");
            System.out.println("+-----+----------------------------+");
            for (LibraryItem item : borrowedItems) {
                System.out.printf("| %-3d | %-26s |\n", item.getItemId(), item.getTitle());
            }
            System.out.println("+-----+----------------------------+");
        }
    }
}