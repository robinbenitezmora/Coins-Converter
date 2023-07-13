import javax.swing.*;

public class CurrencyConverter {
  public static void main(String[] args) {
    String[] choices = {
        "Dollars to Pesos",
        "Pesos to Dollars",
        "Euros to Pesos",
        "Pesos to Euros",
        "Esterlines to Pesos",
        "Pesos to Esterlines",
        "Yens to Pesos",
        "Pesos to Yens",
        "Won to Pesos",
        "Pesos to Won",
        "Exit"
    };

    String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "Menu",
        JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]); // Initial choice

    while (input != "Exit") {
      if (input == "Dollars to Pesos") {
        String dollars = JOptionPane.showInputDialog("Enter the amount of dollars");
        double dollars2 = Double.parseDouble(dollars);
        double pesos = dollars2 * 4500;
        JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
      } else if (input == "Pesos to Dollars") {
        String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
        double pesos2 = Double.parseDouble(pesos);
        double dollars = pesos2 / 4500;
        JOptionPane.showMessageDialog(null, "The amount of dollars is " + dollars);
      } else if (input == "Euros to Pesos") {
        String euros = JOptionPane.showInputDialog("Enter the amount of euros");
        double euros2 = Double.parseDouble(euros);
        double pesos = euros2 * 5000;
        JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
      } else if (input == "Pesos to Euros") {
        String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
        double pesos2 = Double.parseDouble(pesos);
        double euros = pesos2 / 5000;
        JOptionPane.showMessageDialog(null, "The amount of euros is " + euros);
      } else if (input == "Esterlines to Pesos") {
        String esterlines = JOptionPane.showInputDialog("Enter the amount of esterlines");
        double esterlines2 = Double.parseDouble(esterlines);
        double pesos = esterlines2 * 5400;
        JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
      } else if (input == "Pesos to Esterlines") {
        String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
        double pesos2 = Double.parseDouble(pesos);
        double esterlines = pesos2 / 5400;
        JOptionPane.showMessageDialog(null, "The amount of esterlines is " + esterlines);
      } else if (input == "Yens to Pesos") {
        String yens = JOptionPane.showInputDialog("Enter the amount of yens");
        double yens2 = Double.parseDouble(yens);
        double pesos = yens2 * 28.9;
        JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
      } else if (input == "Pesos to Yens") {
        String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
        double pesos2 = Double.parseDouble(pesos);
        double yens = pesos2 / 28.9;
        JOptionPane.showMessageDialog(null, "The amount of yens is " + yens);
      } else if (input == "Won to Pesos") {
        String won = JOptionPane.showInputDialog("Enter the amount of won");
        double won2 = Double.parseDouble(won);
        double pesos = won2 * 0.31;
        JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
      } else if (input == "Pesos to Won") {
        String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
        double pesos2 = Double.parseDouble(pesos);
        double won = pesos2 / 0.31;
        JOptionPane.showMessageDialog(null, "The amount of won is " + won);
      } else {
        JOptionPane.showMessageDialog(null, "Invalid option");
      }
      input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
          JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
    }

    JOptionPane.showMessageDialog(null, "Thanks for using the program");
  }
}
