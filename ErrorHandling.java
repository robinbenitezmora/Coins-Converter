import javax.swing.*;

public class ErrorHandling {
 public static void main(String[] args) {
  try {
   int numerator = Integer.parseInt(JOptionPane.showInputDialog("Enter the numerator"));
   int denominator = Integer.parseInt(JOptionPane.showInputDialog("Enter the denominator"));
   int result = numerator / denominator;

   JOptionPane.showMessageDialog(null, "The result is " + result);
  } catch (NumberFormatException e) {
   JOptionPane.showMessageDialog(null, "You must enter a number");
  } catch (ArithmeticException e) {
   JOptionPane.showMessageDialog(null, "You cannot divide by zero");
  } catch (Exception e) {
   JOptionPane.showMessageDialog(null, "An error has ocurred");
  }
 }
}
