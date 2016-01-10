package moneycalculator.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import moneycalculator.model.CurrencySet;
import moneycalculator.model.Money;

public class MoneyRequest implements MoneyDialog {
    private JFrame frame;
    private JPanel topPanel,halfPanel,lowerPanel;
    private JComboBox currencyComboBox;
    private JTextField amountTextField;
    private int amount;
    private String currencyCode;
    private boolean pulseOk;
    
    public MoneyRequest() {
        topPanel = makeTopPanel();
        halfPanel = makeHalfPanel();
        lowerPanel = makeLowerPanel();
        makesuperPanel();
    }

    @Override
    public Money get() {
        frame.pack();
        frame.setVisible(true);  
        pulseOk=false;
        while(!pulseOk){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoneyRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new Money(amount, new CurrencySet().get(currencyCode));
    }

    private JPanel makeTopPanel() {   
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.add(new JLabel("    "));
        topPanel.add(new JLabel("Introduzaca cantidad"));
        topPanel.add(new JLabel("    "));
        amountTextField = new JTextField(10);
        topPanel.add(amountTextField);
        topPanel.add(new JLabel("    "));
        return topPanel;
    }

    private JPanel makeHalfPanel() {
        JPanel halfPanel = new JPanel();
        halfPanel.setLayout(new BoxLayout(halfPanel, BoxLayout.X_AXIS));
        halfPanel.add(new JLabel("    "));
        halfPanel.add(new JLabel("Seleccione divisa"));
        halfPanel.add(new JLabel("    "));
        currencyComboBox = new JComboBox(new CurrencySet().getCurrencyList());
        halfPanel.add(currencyComboBox);
        halfPanel.add(new JLabel("    "));
        return halfPanel;
    }

    private JPanel makeLowerPanel() {
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.X_AXIS));
        lowerPanel.add(okButton());
        lowerPanel.add(new JLabel("    "));
        lowerPanel.add(new JButton("Cancelar"));
        return lowerPanel;
    }

    private void makesuperPanel() {
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS) );
        frame.add(new JLabel("      "));
        frame.add(topPanel);
        frame.add(new JLabel("      "));
        frame.add(halfPanel);
        frame.add(new JLabel("      "));
        frame.add(lowerPanel);
        frame.add(new JLabel("      "));
        frame.setSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   
    }

    private JButton okButton() {
        JButton ok = new JButton ("Ok");
        ok.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e)
            {
                amount = Integer.parseInt(amountTextField.getText());
                currencyCode = (String) currencyComboBox.getSelectedItem();
                pulseOk=true;
                frame.setVisible(false);
            }
        }); 
        return ok;
    }
}
