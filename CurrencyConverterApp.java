import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class CurrencyConverterApp extends JFrame {
    private JLabel welcomeLabel;
    private JLabel amountLabel;
    private JLabel resultLabel;
    private JComboBox<String> currencyComboBox;
    private JTextField amountTextField;
    private JButton convertButton;
    private JButton exitButton;

    private static final double COP_TO_USD = 3566.20;
    private static final double COP_TO_EUR = 4198.61;
    private static final double COP_TO_GBP = 4953.13;
    private static final double COP_TO_JPY = 32.48;
    private static final double COP_TO_KRW = 0.31;

    private static final double USD_TO_COP = 0.00028;
    private static final double EUR_TO_COP = 0.00024;
    private static final double GBP_TO_COP = 0.00020;
    private static final double JPY_TO_COP = 0.030;
    private static final double KRW_TO_COP = 0.00032;

    public CurrencyConverterApp() {
        super("Currency Converter");

        // Set up the GUI components
        welcomeLabel = new JLabel("Welcome to Currency Converter!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        amountLabel = new JLabel("Enter amount:");
        resultLabel = new JLabel();

        currencyComboBox = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "KRW" });
        amountTextField = new JTextField(10);

        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");

        // Set the layout
        setLayout(new GridLayout(4, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to the frame
        add(welcomeLabel);
        add(new JLabel()); // Empty label for spacing
        add(amountLabel);
        add(amountTextField);
        add(currencyComboBox);
        add(resultLabel);
        add(convertButton);
        add(exitButton);

        // Set component styles
        currencyComboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        amountTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        convertButton.setFont(new Font("Arial", Font.BOLD, 14));
        exitButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Add event listeners
        convertButton.addActionListener(new ConvertButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void setBorder(Border createEmptyBorder) {
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCurrency = currencyComboBox.getSelectedItem().toString();
            double amount;

            try {
                amount = Double.parseDouble(amountTextField.getText());

                double convertedAmount;
                String currencySymbol;

                switch (selectedCurrency) {
                    case "USD":
                        convertedAmount = amount * COP_TO_USD;
                        currencySymbol = "$";
                        break;
                    case "EUR":
                        convertedAmount = amount * COP_TO_EUR;
                        currencySymbol = "€";
                        break;
                    case "GBP":
                        convertedAmount = amount * COP_TO_GBP;
                        currencySymbol = "£";
                        break;
                    case "JPY":
                        convertedAmount = amount * COP_TO_JPY;
                        currencySymbol = "¥";
                        break;
                    case "KRW":
                        convertedAmount = amount * COP_TO_KRW;
                        currencySymbol = "₩";
                        break;
                    case "COP":
                        convertedAmount = amount * USD_TO_COP;
                        currencySymbol = "$";
                        break;
                    default:
                        convertedAmount = 0;
                        currencySymbol = "";
                }

                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                String formattedAmount = decimalFormat.format(convertedAmount);

                resultLabel.setText("Converted amount: " + currencySymbol + formattedAmount + " " + selectedCurrency);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount entered!");
            }
        }
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(CurrencyConverterApp.this,
                    "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(CurrencyConverterApp::new);
    }
}
