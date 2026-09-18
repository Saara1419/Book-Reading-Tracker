# Book-Reading-Tracker
# 📚 Book Reading Tracker

A simple Java console application to help a student (or anyone!) keep
track of the books they're reading, log their page-by-page progress,
and view a summary report of their reading habits.

## 📌 Features

### ✔ Book Management
- Add a book (title, author, total pages)
- Delete a book
- View all books with progress and status

### ✔ Progress Tracking
- Log the number of pages read in a session
- Automatically marks a book as "Completed" once all pages are read

### ✔ Reporting Module
- Total books added, completed, and in progress
- Total pages read vs. total pages across all books
- Overall completion percentage

## 📂 Project Structure

```
BookReadingTracker/
│
├── Book.java             # Model class representing a single book
├── BookService.java       # Business logic: add/delete/view/update books
├── ReportService.java     # Generates the reading summary report
└── BookTrackerMain.java   # Console menu and program entry point
```

## 🧰 Technologies Used
- Java (JDK 17+)
- Command Prompt / Terminal
- Git & GitHub

## ▶ How to Run

1. Open a terminal inside the project folder:
   ```
   cd BookReadingTracker
   ```
2. Compile the project:
   ```
   javac *.java
   ```
3. Run the program:
   ```
   java BookTrackerMain
   ```

## 🧪 Testing Notes
- Tested all menu options manually
- Validated behavior with empty book list
- Tested deleting a non-existing book ID
- Verified that progress logging correctly marks a book "Completed"
  once pages read reaches total pages

## 📈 Future Enhancements
- Persist books to a file or database (MySQL/SQLite)
- Add a GUI using JavaFX or Swing
- Add reading goals/deadlines and reminders
- Weekly/monthly reading charts
