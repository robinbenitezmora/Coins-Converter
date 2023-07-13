import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterApp extends JFrame {
    private JLabel welcomeLabel;
    private JLabel amountLabel;
    private JLabel resultLabel;
    private JComboBox<String> currencyComboBox;
    private JTextField amountTextField;
    private JButton convertButton;
    private JButton exitButton;

    private static final double COP_TO_USD = 0.00028;
    private static final double COP_TO_EUR = 0.00024;
    private static final double COP_TO_GBP = 0.00020;
    private static final double COP_TO_JPY = 0.030;
    private static final double COP_TO_KRW = 0.00032;

    public CurrencyConverterApp() {
        super("Currency Converter");

        // Set up the GUI components
        welcomeLabel = new JLabel("Welcome to Currency Converter!");
        amountLabel = new JLabel("Enter amount in Colombian Pesos (COP):");
        resultLabel = new JLabel();

        currencyComboBox = new JComboBox<>(new String[] { "USD", "EUR", "GBP", "JPY", "KRW" });
        amountTextField = new JTextField(10);

        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");

        // Set the layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(welcomeLabel);
        add(new JLabel()); // Empty label for spacing
        add(amountLabel);
        add(amountTextField);
        add(currencyComboBox);
        add(resultLabel);
        add(convertButton);
        add(exitButton);

        // Add event listeners
        convertButton.addActionListener(new ConvertButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setVisible(true);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedCurrency = (String) currencyComboBox.getSelectedItem();
            double amount;

            try {
                amount = Double.parseDouble(amountTextField.getText());

                if (selectedCurrency.equals("USD")) {
                    double convertedAmount = amount * COP_TO_USD;
                    resultLabel.setText(String.format("Converted amount: %.2f USD", convertedAmount));
                } else if (selectedCurrency.equals("EUR")) {
                    double convertedAmount = amount * COP_TO_EUR;
                    resultLabel.setText(String.format("Converted amount: %.2f EUR", convertedAmount));
                } else if (selectedCurrency.equals("GBP")) {
                    double convertedAmount = amount * COP_TO_GBP;
                    resultLabel.setText(String.format("Converted amount: %.2f GBP", convertedAmount));
                } else if (selectedCurrency.equals("JPY")) {
                    double convertedAmount = amount * COP_TO_JPY;
                    resultLabel.setText(String.format("Converted amount: %.2f JPY", convertedAmount));
                } else if (selectedCurrency.equals("KRW")) {
                    double convertedAmount = amount * COP_TO_KRW;
                    resultLabel.setText(String.format("Converted amount: %.2f KRW", convertedAmount));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid amount entered!");
            }
        }
    }

    private class ExitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(CurrencyConverterApp.this,
                    "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CurrencyConverterApp());
    }
}
