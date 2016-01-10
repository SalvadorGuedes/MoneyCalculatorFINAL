package moneycalculator.model;

import java.util.ArrayList;
import java.util.List;

public class CurrencySet {

    private final List<Currency> list = new ArrayList<Currency>();

    public CurrencySet() {
        list.add(new Currency("USD", "Dolar americano", "$"));
        list.add(new Currency("EUR", "Euro", "€"));
        list.add(new Currency("GPB", "Libra britanica", "£"));
        list.add(new Currency("JPY","Yen","¥"));
        list.add(new Currency("CNY", "Yuan", "元"));
    }
    
    public Currency get(String text) {
        for (Currency currency : list) 
            if (
                    currency.getCode().equals(text) || 
                    currency.getName().contains(text) || 
                    currency.getSymbol().equals(text)
                ) return currency;
        return null;
    }
    
    public Object[] getCurrencyList() {
        Object[] currencyList = new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            currencyList[i]=list.get(i).getCode();
        }
        return currencyList;
    }
}
