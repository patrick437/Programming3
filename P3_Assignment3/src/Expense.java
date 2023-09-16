import java.time.LocalDate; //need the local date library

import org.joda.money.Money; //need the money library

public class Expense {
	
	LocalDate localDate;
	String description;
	Expenses expense;
	boolean approved;
	Money amount;
	
	public Expense(LocalDate localDate, String description, Expenses expense, Money amount)
	{
		this.localDate = localDate;   //expense constructor
		this.description = description;
		this.expense = expense;
		this.amount = amount;
		approved = false; //setting approved expense to false
	}
	
	public enum Expenses //creating the enum
	{
		TRAVELANDSUBSISTENCE,
		SUPPLIES,
		ENTERTAINMENT,
		EQUIPMENT,
		OTHER;
	}
	
	public void approvePayment(boolean approved) //method to approve the payment
	{
		approved = true;
	}
	
	public LocalDate getDate()     //all the getters and setters of class
	{
		return localDate;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public Expenses getExpense()
	{
		return expense;
	}
	
	public Money getAmount()
	{
		return amount;
	}
	
	public String toString()  //to string which prints out the information about the expense
	{
		String toString = "";
		toString += localDate;
		toString += ":";
		toString += description;
		toString += "-";
		toString += expense;
		toString += "-";
		toString += amount;
		return toString;
	}

}
