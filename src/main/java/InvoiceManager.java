import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceManager {
  private ArrayList<Customer> customers = new ArrayList<>();
  private ArrayList<Product> products = new ArrayList<>();
  private ArrayList<Invoice> invoices = new ArrayList<>();
  Scanner scanner = new Scanner(System.in);

  public void showInvoices() {
    System.out.println("Podaj id faktury");
    int id = 0;

    try {
      id = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException ex) {
      System.out.println("nie jest liczba");
    }
    for (Invoice invoice : invoices) {
      if (id == invoice.id) {
        invoice.printInvoice();
        break;
      }
    }
  }

  public void addInvoice() {
    try {
      Invoice newInvoice = new Invoice(scanner, invoices, customers, products);
    } catch (IllegalArgumentException ex) {
      System.out.println("nie ma takiego klienta");
    } catch (Exception ex) {
      System.out.println("jest juz taka faktura");
    }
  }

  public void addProduct() {
    try {
      Product product = new Product(scanner, products);
    } catch (Exception e) {
      System.out.println("Istnieje już taki produkt.");
    }
  }

  public void addCustomer() {
    try {
      Customer newCustomer = new Customer(scanner, customers);
    } catch (Exception e) {
      System.out.println("Istnieje już taki klient.");
    }

  }
}
