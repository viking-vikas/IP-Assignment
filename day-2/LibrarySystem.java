import java.util.ArrayList;
import java.util.Scanner;

interface LibraryOperations {
  void issueBook(int id);
  void returnBook(int id);
  void showStatus();
}

class Book {
  int id;
  String title;
  String author;
  boolean isIssued;

  public Book(int id, String title, String author) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.isIssued = false;
  }
}

class Library implements LibraryOperations {
  private ArrayList<Book> books = new ArrayList<>();

  public void addBook(Book book) {
    books.add(book);
    System.out.println("Book added successfully.");
  }

  @Override
  public void issueBook(int id) {
    Book book = findBookById(id);

    if (book == null) {
      System.out.println("Book not found.");
      return;
    }

    if (book.isIssued) {
      System.out.println("Book is already issued.");
    } else {
      book.isIssued = true;
      System.out.println("Book issued successfully.");
    }
  }

  @Override
  public void returnBook(int id) {
    Book book = findBookById(id);

    if (book == null) {
      System.out.println("Book not found.");
      return;
    }

    if (!book.isIssued) {
      System.out.println("Book was not issued.");
    } else {
      book.isIssued = false;
      System.out.println("Book returned successfully.");
    }
  }

  @Override
  public void showStatus() {
    if (books.isEmpty()) {
      System.out.println("No books in library.");
      return;
    }

    System.out.println("ID | Title | Author | Status");
    for (Book b : books) {
      System.out.println(b.id + " | " + b.title + " | " + b.author + " | " +
                         (b.isIssued ? "Issued" : "Available"));
    }
  }

  private Book findBookById(int id) {
    for (Book b : books) {
      if (b.id == id) {
        return b;
      }
    }
    return null;
  }
}

public class LibrarySystem {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    int choice;

    do {
      System.out.println("\nLibrary Menu");
      System.out.println("1. Add Book");
      System.out.println("2. Issue Book");
      System.out.println("3. Return Book");
      System.out.println("4. Show All Books");
      System.out.println("0. Exit");
      System.out.print("Enter choice: ");

      choice = sc.nextInt();

      switch (choice) {
      case 1:
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        library.addBook(new Book(id, title, author));
        break;

      case 2:
        System.out.print("Enter Book ID to issue: ");
        library.issueBook(sc.nextInt());
        break;

      case 3:
        System.out.print("Enter Book ID to return: ");
        library.returnBook(sc.nextInt());
        break;

      case 4:
        library.showStatus();
        break;

      case 0:
        System.out.println("Exiting Library System.");
        break;

      default:
        System.out.println("Invalid choice.");
      }

    } while (choice != 0);

    sc.close();
  }
}
