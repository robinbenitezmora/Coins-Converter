public class TestCurrency {
 public static void main(String[] args) {
  Currency c1 = new Currency(1, 50);
  Currency c2 = new Currency(2, 25);
  Currency c3 = new Currency(1, 50);
  System.out.println(c1.equals(c2));
  System.out.println(c1.equals(c3));
  System.out.println(c1.equals("abc"));
 }
}
