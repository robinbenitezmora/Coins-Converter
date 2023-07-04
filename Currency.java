
public class Currency {
 private int dollars;
 private int cents;

 public Currency(int d, int c) {
  dollars = d;
  cents = c;
 }

 public int getDollars() {
  return dollars;
 }

 public int getCents() {
  return cents;
 }

 public boolean equals(Object o) {
  if (o instanceof Currency) {
   Currency other = (Currency) o;
   return (dollars == other.dollars) && (cents == other.cents);
  } else {
   return false;
  }
 }
}
