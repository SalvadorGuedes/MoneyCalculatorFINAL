package moneycalculator.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import moneycalculator.model.Money;

public class MoneyExchangeDisplay implements MoneyDisplay {

    @Override
    public void show(Money money) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(new JLabel("      "),BorderLayout.NORTH);
        frame.add(new JLabel("      "),BorderLayout.EAST);
        frame.add(new JLabel(money.getAmount()+" "+money.getCurrency().getCode()),BorderLayout.CENTER);
        frame.add(new JLabel("      "),BorderLayout.SOUTH);
        frame.add(new JLabel("      "),BorderLayout.WEST);
        frame.setSize(new Dimension(500, 500));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        frame.pack();
        frame.setVisible(true);  
    }
}
