import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        return items.stream()
            .filter(item -> item.itemId == itemId)
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
    }

    public Member findMemberById(String memberId) {
        return members.stream()
            .filter(m -> m.getMemberId().equals(memberId))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan"));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+------+----------------------+------------+\n");
        sb.append(String.format("| %-4s | %-20s | %-10s |\n", "ID", "Judul", "Status"));
        sb.append("+------+----------------------+------------+\n");
        for (LibraryItem item : items) {
            sb.append(String.format("| %-4d | %-20s | %-10s |\n",
                    item.itemId,
                    item.getTitle(),
                    item.isBorrowed() ? "Dipinjam" : "Tersedia"));
        }
        sb.append("+------+----------------------+------------+");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
