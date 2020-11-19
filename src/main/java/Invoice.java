import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {
  public int id;
  private Customer customerIn;
  private ArrayList<InvoiceElement> elements;

  public Invoice(Scanner s, ArrayList<Invoice> invoices, ArrayList<Customer> customers,
                 ArrayList<Product> items) throws Exception {
    elements = new ArrayList<>();
    System.out.println("Podaj id faktury");
    id = Integer.parseInt(s.nextLine());
    for (Invoice invoice : invoices) {
      if (invoice.id == id) {
        throw new Exception();
      }
    }

    /*USTAWIANIE KLIENTA*/

    System.out.println("Podaj id klienta");
    int tempId = Integer.parseInt(s.nextLine());
    int flag = 0;
    for (Customer customer : customers) {
      if (customer.id == tempId) {
        customerIn = customer;
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      throw new IllegalArgumentException();
    }
    /*DODAWANIE ELEMENTOW */
    while (true) {
      System.out.println("1: Dodaj element");
      System.out.println("2: Zakoncz dodawanie");

      if (Integer.parseInt(s.nextLine()) == 1) {
        try {
          InvoiceElement newElement = new InvoiceElement(s, elements, items);
        } catch (Exception ex) {
          System.out.println("nie ma takiego przedmiotu");
        }
      } else {
        break;
      }
    }
    invoices.add(this);
  }

  public void printInvoice() {
    for (InvoiceElement element : elements) {
      element.printElement();
    }
  }
}