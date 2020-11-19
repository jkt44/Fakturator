import java.util.ArrayList;
import java.util.Scanner;

public class Product {
  public String name;
  public double price;

  public Product(Scanner s, ArrayList<Product> products) throws Exception {
    System.out.println("Podaj nazwe przedmiotu");
    name = s.nextLine();
    for (Product item : products) {
      if (name.equals(item.name)) {
        throw new Exception();
      }
    }
    System.out.println("Podaj cene");
    price = Double.parseDouble(s.nextLine());
    products.add(this);
  }

}
