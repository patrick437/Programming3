import java.util.ArrayList;

public class PrinterByLabel implements ExpensePrinter {
	
	public PrinterByLabel()
	{
		
	}

	@Override //class from the interface
	public void print(ArrayList<Expense> expenses) {
		//iniatilizing arrays to place the expenses into
		ArrayList<Expense> travelAndSubsistence= new ArrayList<Expense>();
		ArrayList<Expense> supplies= new ArrayList<Expense>();
		ArrayList<Expense> entertainment = new ArrayList<Expense>();
		ArrayList<Expense> equipment= new ArrayList<Expense>();
		ArrayList<Expense> other = new ArrayList<Expense>();
		
		for(int i=0; i<expenses.size();i++)
		{
			if(expenses.get(i).getExpense() == Expense.Expenses.TRAVELANDSUBSISTENCE) //if expense is equal to each ENUM put it into that arraylist
			{
				travelAndSubsistence.add(expenses.get(i));
			}
			else if(expenses.get(i).getExpense() == Expense.Expenses.SUPPLIES)
			{	
				supplies.add(expenses.get(i));
			}
			else if(expenses.get(i).getExpense() == Expense.Expenses.ENTERTAINMENT)
			{
				entertainment.add(expenses.get(i));
			}
			else if(expenses.get(i).getExpense() == Expense.Expenses.EQUIPMENT)
			{
				equipment.add(expenses.get(i));
			}
			else if(expenses.get(i).getExpense() == Expense.Expenses.OTHER)
			{
				other.add(expenses.get(i));
			}
		}
		
		//print methods saying each ENUM variable and then printing each arraylist with the expenses using for each loop and lamda expressions
		System.out.println("TRAVEL AND SUBSISTENCE");
		travelAndSubsistence.forEach((n) -> System.out.println(n));
		System.out.println();
		System.out.println("Supplies");
		supplies.forEach((n) -> System.out.println(n));
		System.out.println();
		System.out.println("Entertainment");
		entertainment.forEach((n) -> System.out.println(n));
		System.out.println();
		System.out.println("Equipment");
		equipment.forEach((n) -> System.out.println(n));
		System.out.println();
		System.out.println("Other");
		other.forEach((n) -> System.out.println(n));
		System.out.println();
	}

}
