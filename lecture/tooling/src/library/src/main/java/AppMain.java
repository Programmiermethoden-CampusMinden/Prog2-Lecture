public class AppMain {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        ConsoleUI ui = new ConsoleUI(service);
        ui.run();
    }
}
