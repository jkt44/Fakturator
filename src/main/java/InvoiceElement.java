import java.util.ArrayList;
import java.util.Scanner;

public class InvoiceElement {
  private Product elementProduct;
  private double quantity;
  public double wartosc;

  public InvoiceElement(Scanner s, ArrayList<InvoiceElement> elements, ArrayList<Product> products)
          throws Exception {
    System.out.println("Podaj nazwe przedmiotu");
    String tempName = s.nextLine();
    int flag = 0;
    for (Product product : products) {
      if (product.name.equals(tempName)) {
        elementProduct = product;
        flag = 1;
        break;
      }
    }
    if (flag == 0) {
      throw new Exception();
    }
    System.out.println("Podaj ilosc");
    quantity = Double.parseDouble(s.nextLine());
    wartosc = elementProduct.price * quantity;
    elements.add(this);
  }

  public void printElement() {
    System.out.println("nazwa przedmiotu: " + elementProduct.name + " cena przedmiotu: "
            + elementProduct.price + " ilosc: " + quantity + " wartosc: " + wartosc);
  }
}
