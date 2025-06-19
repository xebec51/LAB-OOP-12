package APP.model;

public class DVD extends LibraryItem {
    private int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ",durasi: " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) throw new IllegalArgumentException("DVD ini sudah dipinjam");
        if (days > 7) throw new IllegalArgumentException("DVD ini tidak dapat dipinjam lebih dari 7 hari");
        isBorrowed = true;
        return "DVD " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

}