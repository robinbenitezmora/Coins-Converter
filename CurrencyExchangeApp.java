// import javax.swing.*;
// import java.lang.Error;

// public class CurrencyConverter {
//   public static void main(String[] args) {
//     String[] choices = {
//         "Dollars to Pesos",
//         "Pesos to Dollars",
//         "Euros to Pesos",
//         "Pesos to Euros",
//         "Esterlines to Pesos",
//         "Pesos to Esterlines",
//         "Yens to Pesos",
//         "Pesos to Yens",
//         "Won to Pesos",
//         "Pesos to Won",
//         "Exit"
//     };

//     String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "Menu",
//         JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]); // Initial choice

//     while (input != "Exit") {
//       if (input == "Dollars to Pesos") {
//         String dollars = JOptionPane.showInputDialog("Enter the amount of dollars");
//         double dollars2 = Double.parseDouble(dollars);
//         double pesos = dollars2 * 4500;
//         JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
//       } else if (input == "Pesos to Dollars") {
//         String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
//         double pesos2 = Double.parseDouble(pesos);
//         double dollars = pesos2 / 4500;
//         JOptionPane.showMessageDialog(null, "The amount of dollars is " + dollars);
//       } else if (input == "Euros to Pesos") {
//         String euros = JOptionPane.showInputDialog("Enter the amount of euros");
//         double euros2 = Double.parseDouble(euros);
//         double pesos = euros2 * 5000;
//         JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
//       } else if (input == "Pesos to Euros") {
//         String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
//         double pesos2 = Double.parseDouble(pesos);
//         double euros = pesos2 / 5000;
//         JOptionPane.showMessageDialog(null, "The amount of euros is " + euros);
//       } else if (input == "Esterlines to Pesos") {
//         String esterlines = JOptionPane.showInputDialog("Enter the amount of esterlines");
//         double esterlines2 = Double.parseDouble(esterlines);
//         double pesos = esterlines2 * 5400;
//         JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
//       } else if (input == "Pesos to Esterlines") {
//         String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
//         double pesos2 = Double.parseDouble(pesos);
//         double esterlines = pesos2 / 5400;
//         JOptionPane.showMessageDialog(null, "The amount of esterlines is " + esterlines);
//       } else if (input == "Yens to Pesos") {
//         String yens = JOptionPane.showInputDialog("Enter the amount of yens");
//         double yens2 = Double.parseDouble(yens);
//         double pesos = yens2 * 28.9;
//         JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
//       } else if (input == "Pesos to Yens") {
//         String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
//         double pesos2 = Double.parseDouble(pesos);
//         double yens = pesos2 / 28.9;
//         JOptionPane.showMessageDialog(null, "The amount of yens is " + yens);
//       } else if (input == "Won to Pesos") {
//         String won = JOptionPane.showInputDialog("Enter the amount of won");
//         double won2 = Double.parseDouble(won);
//         double pesos = won2 * 0.31;
//         JOptionPane.showMessageDialog(null, "The amount of pesos is " + pesos);
//       } else if (input == "Pesos to Won") {
//         String pesos = JOptionPane.showInputDialog("Enter the amount of pesos");
//         double pesos2 = Double.parseDouble(pesos);
//         double won = pesos2 / 0.31;
//         JOptionPane.showMessageDialog(null, "The amount of won is " + won);
//       } else {
//         JOptionPane.showMessageDialog(null, "Invalid option");
//       }
//       input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
//           JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
//     }

//     JOptionPane.showMessageDialog(null, "Bye!");
//   }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyExchangeApp extends JFrame {
 private JComboBox<String> currencyMenu;
 private JTextField inputField;

 public CurrencyExchangeApp() {
  createAndShowGUI();
 }

 private void createAndShowGUI() {
  // Create and configure the main frame
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setTitle("Currency Exchange App");

  // Create the currency menu
  String[] currencies = {
    "Dollars to Pesos",
    "Pesos to Dollars",
    "Euros to Pesos",
    "Pesos to Euros",
    "Esterlines to Pesos",
    "Pesos to Esterlines",
    "Yens to Pesos",
    "Pesos to Yens",
    "Won to Pesos",
    "Pesos to Won"
  };
  currencyMenu = new JComboBox<String>(currencies);

  // Create the input field
  inputField = new JTextField(10);

  // Create the finish button
  JButton finishButton = new JButton("Finish");
  finishButton.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit",
      JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
     String selectedCurrency = (String) currencyMenu.getSelectedItem();
     String inputData = inputField.getText();
     try {
      double amount = Double.parseDouble(inputData);
      double result = 0;
      switch (selectedCurrency) {
       case "Dollars to Pesos":
        result = amount * 4500;
        break;
       case "Pesos to Dollars":
        result = amount / 4500;
        break;
       case "Euros to Pesos":
        result = amount * 5000;
        break;
       case "Pesos to Euros":
        result = amount / 5000;
        break;
       case "Esterlines to Pesos":
        result = amount * 5400;
        break;
       case "Pesos to Esterlines":
        result = amount / 5400;
        break;
       case "Yens to Pesos":
        result = amount * 28.9;
        break;
       case "Pesos to Yens":
        result = amount / 28.9;
        break;
       case "Won to Pesos":
        result = amount * 0.31;
        break;
       case "Pesos to Won":
        result = amount / 0.31;
        break;
      }
      JOptionPane.showMessageDialog(null, "The result is " + result);
     } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "You must enter a number");
     }
    }
   }
  });
  // Create the panel and add the components
  JPanel panel = new JPanel();
  panel.add(currencyMenu);
  panel.add(inputField);
  panel.add(finishButton);

  // Add the panel to the frame
  getContentPane().add(panel, BorderLayout.CENTER);

  // Set frame properties
  pack();
  setVisible(true);
 }

 public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    new CurrencyExchangeApp();
   }
  });
 }
}