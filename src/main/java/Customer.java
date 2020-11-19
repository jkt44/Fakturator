import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
  public int id;

  public Customer(Scanner s, ArrayList<Customer> customers) throws Exception {
    System.out.println("Podaj id klienta");
    id = Integer.parseInt(s.nextLine());
    for (Customer customer : customers) {
      if (customer.id == id) {
        throw new Exception();
      }
    }
    customers.add(this);
  }
}
