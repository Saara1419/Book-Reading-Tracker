import java.util.List;

/**
 * Generates summary reports about the reader's overall progress.
 */
public class ReportService {

    public void printSummary(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books added yet. Nothing to report.");
            return;
        }

        int totalBooks = books.size();
        int completedBooks = 0;
        int totalPagesRead = 0;
        int totalPagesOverall = 0;

        for (Book b : books) {
            if (b.isCompleted()) {
                completedBooks++;
            }
            totalPagesRead += b.getPagesRead();
            totalPagesOverall += b.getTotalPages();
        }

        double overallPercentage = totalPagesOverall == 0
            ? 0
            : (totalPagesRead * 100.0) / totalPagesOverall;

        System.out.println("===== Reading Progress Report =====");
        System.out.println("Total books added      : " + totalBooks);
        System.out.println("Books completed         : " + completedBooks);
        System.out.println("Books in progress       : " + (totalBooks - completedBooks));
        System.out.println("Total pages read        : " + totalPagesRead + " / " + totalPagesOverall);
        System.out.printf("Overall completion       : %.1f%%%n", overallPercentage);
        System.out.println("====================================");
    }
}
