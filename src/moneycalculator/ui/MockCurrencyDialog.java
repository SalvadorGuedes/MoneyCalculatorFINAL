package moneycalculator.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencySet;

public class MockCurrencyDialog implements CurrencyDialog {

    private JFrame frame;
    private boolean pulseOk;
    private String currencyCode;
    private JComboBox currencyComboBox;
    
    @Override
    public Currency get() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("Seleccione divisa"), BorderLayout.NORTH);
        frame.add(okButton(), BorderLayout.AFTER_LAST_LINE);
        currencyComboBox = new JComboBox(new CurrencySet().getCurrencyList());
        frame.add(currencyComboBox,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);  
        while(!pulseOk){
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MoneyRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new CurrencySet().get(currencyCode);
    }
    
    private JButton okButton() {
        JButton ok = new JButton ("Ok");
        ok.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e)
            {
                pulseOk = true;
                currencyCode = (String) currencyComboBox.getSelectedItem();
                frame.setVisible(false);
            }
        }); 
        return ok;
    }

}
