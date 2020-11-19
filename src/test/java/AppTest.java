import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class AppTest {
  @Test
  public void testElement() {
    Scanner s1 = new Scanner("Produkt\n10\nProdukt2\n144\n");
    Scanner s2 = new Scanner("Produkt\n5\n");
    ArrayList<InvoiceElement> elements = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    try {
      Product product = new Product(s1, products);
      assertTrue(products.contains(product));
    } catch(Exception ex)	{
      System.out.println("Element tablicy nie został dodany prawidłowo");
    }

    try {
      InvoiceElement element = new InvoiceElement(s2, elements, products);
      assertEquals(50, element.wartosc, 0);
    } catch(Exception ex)	{
      System.out.println("System nie przelicza wartości w sposób prawidłowy");
    }

  }
}