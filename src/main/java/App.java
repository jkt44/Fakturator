import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    InvoiceManager manager = new InvoiceManager();
    Scanner scanner = new Scanner(System.in);
    int chosenOption = 0;

    while (true) {
      System.out.println("------------------------------------------------");
      System.out.println("Witaj w programie Fakturator!");
      System.out.println("1 - Wyświetl faktury");
      System.out.println("2 - Dodaj faktury");
      System.out.println("3 - Dodaj produkt");
      System.out.println("4 - Dodaj klienta");
      System.out.println("5 - Wyjdź");

      try {
        chosenOption = Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException ex) {
        System.out.println("Podaj liczbę naturalną odpowiadającą instrukcji");
      }

      switch (chosenOption) {
        case 1 -> manager.showInvoices();
        case 2 -> manager.addInvoice();
        case 3 -> manager.addProduct();
        case 4 -> manager.addCustomer();
        case 5 -> {
          System.out.println("Do widzenia!");
          return;
        }
        default -> System.out.println("Błąd, wybierz jedną z opcji opisanych powyżej.");
      }
    }
  }
}
