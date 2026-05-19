import java.util.ArrayList;
import java.util.Scanner;

class Book {

    String title;

    Book(String title) {
        this.title = title;
    }
}

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();

                    books.add(new Book(title));

                    System.out.println("Book Added");
                    break;

                case 2:

                    System.out.println("\nBooks in Library:");

                    for(Book b : books) {
                        System.out.println("- " + b.title);
                    }

                    break;

                case 3:

                    System.out.print("Enter title to search: ");
                    String search = sc.nextLine();

                    boolean found = false;

                    for(Book b : books) {

                        if(b.title.equalsIgnoreCase(search)) {

                            found = true;
                            System.out.println("Book Found");
                            break;
                        }
                    }

                    if(!found) {
                        System.out.println("Book Not Found");
                    }

                    break;

                case 4:

                    System.out.print("Enter title to remove: ");
                    String remove = sc.nextLine();

                    books.removeIf(b -> b.title.equalsIgnoreCase(remove));

                    System.out.println("Book Removed");

                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }
}