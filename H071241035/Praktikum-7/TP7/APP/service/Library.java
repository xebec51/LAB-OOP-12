package APP.service;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import APP.model.Member;
import APP.model.LibraryItem;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public boolean isItemIdExists(int id) {
        return items.stream().anyMatch(i -> i.getItemId() == id);
    }
    public boolean isMemberIdExists(int id) {
        return members.stream().anyMatch(m -> m.getMemberId() == id);
    }


    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(item -> item.getItemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan."));
    }
    public Member findMemberById(int memberId) {
        return members.stream()
                .filter(member -> member.getMemberId() == memberId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan."));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+----------------------------+-----------+\n");
        sb.append("| ID  | Judul                      | Status    |\n");
        sb.append("+-----+----------------------------+-----------+\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-3d | %-26s | %-9s |\n", item.getItemId(), item.getTitle(), status));
        }

        sb.append("+-----+----------------------------+-----------+");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Member> getMembers() {
        return members;
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
