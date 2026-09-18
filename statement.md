Problem Statement — Book Reading Tracker System
Objective

Design and develop a console-based Java application that helps a user manage the books they are currently reading, track their daily reading progress, and view a summary report of their overall reading habits.

Background

Many students and casual readers start multiple books but struggle to keep track of how far they've read in each one, or how much they've read overall. This project solves that problem with a lightweight, menu-driven Java program that requires no external database — all data is kept in memory for the duration of the program's run.

Requirements
1. Book Management
The system must allow the user to add a new book by entering:
Title
Author
Total number of pages
The system must allow the user to delete a book using its unique ID.
The system must allow the user to view all books, along with each book's current progress and status (In Progress / Completed).
2. Progress Tracking
The user must be able to log pages read for a specific book (identified by ID) after a reading session.
The system must automatically calculate the percentage of the book completed.
Once the pages read reach or exceed the total page count, the book must automatically be marked as Completed.
3. Reporting Module
The system must generate a summary report showing:
Total number of books added
Number of books completed
Number of books still in progress
Total pages read across all books vs. total pages overall
Overall completion percentage
4. General Constraints
The application must run entirely from the command line/terminal.
Input validation is required (e.g., invalid menu choices, non-numeric input for pages) so the program does not crash on bad input.
The program should loop continuously, showing a menu, until the user chooses to exit.
Expected Program Flow
Program starts and displays a welcome message.
Menu is displayed with options: Add Book, Delete Book, View All Books, Log Reading Progress, View Report, Exit.
User selects an option and the corresponding action is performed.
After each action, the menu is shown again until the user exits.
Technologies to Use
Java (JDK 17 or later)
Standard input/output via Scanner
No external libraries or databases required
Deliverables
Book.java — model class representing a single book
BookService.java — business logic for managing the book collection
ReportService.java — logic for generating the summary report
BookTrackerMain.java — entry point containing the console menu
README.md — project documentation
statement.md — this problem statement
Evaluation Criteria
Correctness of add/delete/view/update operations
Accuracy of the reading progress calculation and report
Code readability and use of proper Java OOP principles (encapsulation, separation of concerns across classes)
Handling of edge cases (e.g., deleting a non-existent book, empty book list, invalid numeric input)
Future Scope
Persist book data to a file or database (MySQL/SQLite) so progress is saved between runs
Build a graphical interface using JavaFX or Swing
Add reading goals, deadlines, and reminder notifications
Add visual charts for weekly/monthly reading trends
