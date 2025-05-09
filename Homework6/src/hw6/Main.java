package hw6;
//import scanner
import java.util.Scanner;
//main class
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Display All Books");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Check Out Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();

                    if (library.addBook(new Book(title, author, isbn))) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Book with this ISBN already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter ISBN of book to remove: ");
                    isbn = sc.nextLine();
                    if (library.removeBook(isbn)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    library.displayAllBooks();
                    break;
                case 4:
                    System.out.print("Enter title to search: ");
                    title = sc.nextLine();
                    library.searchByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter author to search: ");
                    author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 6:
                    System.out.print("Enter ISBN to check out: ");
                    isbn = sc.nextLine();
                    if (library.checkOutBook(isbn)) {
                        System.out.println("Book checked out.");
                    } else {
                        System.out.println("Book not available or not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter ISBN to return: ");
                    isbn = sc.nextLine();
                    if (library.returnBook(isbn)) {
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Book not found or already available.");
                    }
                    break;
                case 8:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
/*Library class
package rrPck;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getIsbn().equals(book.getIsbn())) {
                return false; // Duplicate ISBN
            }
        }
        books.add(book);
        return true;
    }

    public boolean removeBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                books.remove(b);
                return true;
            }
        }
        return false;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No book found with that title.");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) System.out.println("No book found by that author.");
    }

    public boolean checkOutBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isAvailable()) {
                    b.setAvailable(false);
                    return true;
                }
                return false; // already checked out
            }
        }
        return false; // not found
    }

    public boolean returnBook(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (!b.isAvailable()) {
                    b.setAvailable(true);
                    return true;
                }
                return false; // already available
            }
        }
        return false; // not found
    }
}

*/

/*Book Class
package rrPck;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true; // default to available
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("Title: %s | Author: %s | ISBN: %s | %s",
                title, author, isbn, (isAvailable ? "Available" : "Checked Out"));
    }
}
*/