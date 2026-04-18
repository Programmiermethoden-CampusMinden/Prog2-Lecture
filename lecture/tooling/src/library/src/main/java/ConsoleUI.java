import java.util.Scanner;

public class ConsoleUI {
    private final LibraryService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(LibraryService service) {
        this.service = service;
    }

    public void run() {
        IO.println("Simple Library");

        IO.print("Enter new book id: ");
        String id = scanner.nextLine();
        IO.print("Enter title: ");
        String title = scanner.nextLine();
        service.addBook(new Book(id, title));

        IO.print("Lend which book id? ");
        String lendId = scanner.nextLine();
        boolean success = service.lendBook(lendId);
        IO.println(success ? "Lent successfully." : "Could not lend.");
    }
}
