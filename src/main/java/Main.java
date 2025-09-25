import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();

        while (true) {
            System.out.println("\n--- Book Manager ---");
            System.out.println("1. Add a Book");
            System.out.println("2. Search a Book");
            System.out.println("3. Show All Books");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    manager.addBook(title, author);
                    System.out.println("Book added!");
                    break;
 case 2:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book found = manager.searchBook(searchTitle);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    System.out.println("Books in library:");
                    for (Book book : manager.getAllBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
