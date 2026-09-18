/**
 * Represents a single book being tracked by the reader.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private int totalPages;
    private int pagesRead;
    private boolean completed;

    public Book(int id, String title, String author, int totalPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.pagesRead = 0;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void addPagesRead(int pages) {
        pagesRead += pages;
        if (pagesRead >= totalPages) {
            pagesRead = totalPages;
            completed = true;
        }
    }

    public double getProgressPercentage() {
        if (totalPages == 0) {
            return 0;
        }
        return (pagesRead * 100.0) / totalPages;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "In Progress";
        return String.format(
            "ID: %d | \"%s\" by %s | Pages: %d/%d (%.1f%%) | Status: %s",
            id, title, author, pagesRead, totalPages, getProgressPercentage(), status
        );
    }
}
