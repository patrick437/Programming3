import java.time.LocalDate;
import java.util.ArrayList;

import org.joda.money.Money;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create expense portal objects and expenses to be added to the portal
		ExpensePortal expensePortal = new ExpensePortal();
		Expense exp = new Expense(LocalDate.of(2020,12,12), "Shoes", Expense.Expenses.EQUIPMENT,  Money.parse("EUR 40.00"));
		Expense exp1 = new Expense(LocalDate.of(2020,12,12), "Netflix", Expense.Expenses.ENTERTAINMENT,  Money.parse("USD 25.00"));
		Expense exp2 = new Expense(LocalDate.of(2020,12,12), "Petrol", Expense.Expenses.TRAVELANDSUBSISTENCE,  Money.parse("EUR 70.00"));
		Expense exp3 = new Expense(LocalDate.of(2020,12,12), "insurance", Expense.Expenses.OTHER,  Money.parse("USD 50.00"));
		expensePortal.addNewExpense(exp);  //adding all the expenses to the portal
		expensePortal.addNewExpense(exp1);
		expensePortal.addNewExpense(exp2);
		expensePortal.addNewExpense(exp3);
		
		
		ExpensePrinter simplePrinter = (x)->x.stream().forEach(e->System.out.println(e.toString())); //method to print out the expenses using lamda expressions and for each loop to iterate through arraylist
		expensePortal.printExpense(simplePrinter); //calling the Expense Printer object into theprintExpense class so it prints the array and executes above code
		
		//printing out expenses using the anonymous class
		expensePortal.printExpense(new ExpensePrinter() //class is anonymous as it does not have a name stated here
		{  //method inside anonymous class wgich prints the expenses out
			@Override
			public void print(ArrayList<Expense> expenses) {
				//print f statement																		//methods which calculate the amount of expenses and the total cost of these expenses
				System.out.printf("There are %d expenses in the system totalling to a value of %s \n", expensePortal.getExpenses(), expensePortal.getTotalAmount());	
			}
		});
		
		//creating a printByLabel object
		PrinterByLabel printByLabel = new PrinterByLabel();
		//calling this object into the method so it executes on the interfaced class
		expensePortal.printExpense(printByLabel);
			
	
	}

}
