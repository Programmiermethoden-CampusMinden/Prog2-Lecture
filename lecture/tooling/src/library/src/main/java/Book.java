public class Book {
    private final String id;
    private final String title;
    private boolean available = true;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void markLent() {
        available = false;
    }

    public void markReturned() {
        available = true;
    }

    @Override
    public String toString() {
        return id + " - " + title + (available ? " (available)" : " (lent)");
    }
}
