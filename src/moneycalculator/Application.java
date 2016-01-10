package moneycalculator;

import moneycalculator.control.ExchangeCommand;
import moneycalculator.persistence.MockExchangeRateReader;
import moneycalculator.ui.MockCurrencyDialog;
import moneycalculator.ui.MoneyExchangeDisplay;
import moneycalculator.ui.MoneyRequest;

public class Application {

    public static void main(String[] args) {
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                new MoneyRequest(),
                new MockCurrencyDialog(),
                new MockExchangeRateReader(), 
                new MoneyExchangeDisplay()
        ); 
        exchangeCommand.execute();
                
    }
    
}
