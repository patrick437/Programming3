import java.math.BigDecimal;  //math functions required to convert currency
import java.math.RoundingMode;
import java.util.ArrayList;  //need arraylist library

import org.joda.money.CurrencyUnit; //need the money libraries to get currency unit and use money
import org.joda.money.Money;

public class ExpensePortal {
	
	public ExpensePortal()
	{
		
	}
	
	ArrayList<Expense> expenses = new ArrayList<Expense>(); //arraylist which contains all the expenses
	
	public void addNewExpense(Expense expense)
	{
		expenses.add(expense); //method which adds new expense to the arraylist
	}
	
	public void printExpense(ExpensePrinter printer)
	{
		printer.print(expenses);  //the class from the interface which calls in the object to print the expenses
	}
	
	public static Money conversion(Money money) //conversion method
	{
		
		CurrencyUnit unit = money.getCurrencyUnit();
		Money moneyEuro = Money.parse("EUR 0");
		moneyEuro = money; //have to set to values equal to each other outside if so euro values can still be returned through converter
		if(unit == CurrencyUnit.of("USD"))
		{    //conversion rate is in BIGDEcimal format
			BigDecimal conversionRate = BigDecimal.valueOf( 1.02);
			moneyEuro = money.convertedTo(CurrencyUnit.EUR, conversionRate, RoundingMode.HALF_UP);
			
		}
		return moneyEuro;
	}
	
	public int getExpenses() //method which returns number of expenses in the arraylist
	{
		return expenses.size();
	}
	
	public Money getTotalAmount() //method to get total cost of every item in the arraylist
	{
		Money total = Money.parse("EUR 0");
		
		for(int i = 0; i<expenses.size(); i++)
		{						//have to convert everything to euro before they are added together
			total = total.plus(conversion(expenses.get(i).getAmount())); //addition method .plus found on joda money website
			
		}
		return total; //return the total amount added up
	}

	
}
