//Patrick Noonan(20355426)

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class OnlineShop{
	
	private String order;
	private int ID;
	
	private int capacityOfQueue = 100;
	private LinkedBlockingQueue<String> websiteOrders = new LinkedBlockingQueue<String>(capacityOfQueue);
	private LinkedBlockingQueue<String> collectorsOrders = new LinkedBlockingQueue<String>(capacityOfQueue);;
	
	/**
	 *Constructor for the Online Shop
	 */
	public OnlineShop()
	{
	
	}

	/**
	 *method which makes a random delay
	 */
	public void makeDelay()
	{
		try {
		      Thread.sleep((long) (Math.random()*1000));
		    }
		    catch (InterruptedException ex)
		    {
		      System.out.println("Thread interrupted...");
		    }
	}
	
	/**
	 *Main method of the program
	 */
	public static void main( String args[]) throws IOException
	{
		OnlineShop notAmazon = new OnlineShop();
		
		WebAssistant AssistantKirsty = new WebAssistant("Kirsty", 1, notAmazon);
		WebAssistant AssistantPhil = new WebAssistant("Phil", 2, notAmazon);
		
		WarehouseCollector CollectorTristan = new WarehouseCollector("Tristain", 3, notAmazon);
		WarehouseCollector CollectorWillow = new WarehouseCollector("Willow", 4, notAmazon);
		
		notAmazon.intakeOrders();
		notAmazon.makeDelay();
		
		
		AssistantKirsty.start();
		AssistantPhil.start();
		notAmazon.makeDelay();
		CollectorTristan.start();
		CollectorWillow.start();
		
		try {
			AssistantKirsty.join();
			AssistantPhil.join();
			CollectorTristan.join();
			CollectorWillow.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	/**
	 *Intake Order method
	 *method which intakes the order from the text file and calls a method to place them into the web assistants que
	 */
	public void intakeOrders() {
		
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\Patrick Noonan\\P3_Assignment8\\ordersList.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = null;
		
		try {
			while((line = in.readLine()) != null)
			{
				
				Scanner scan = new Scanner( new StringReader(line));
				
				
					while(scan.hasNext())
					{
						//calling method to put orders into web assitants que								
						addWebsiteOrder(line);
						//moving onto next line of the text file
						scan.nextLine();
					}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
	}
	
	/**
	 *Method which checks if the web assistants que is empty or not and returns a boolean variable
	 *@return boolean which states if que is empty or full
	 */
	public boolean isWebsiteOrdersEmpty()
	{
		if( websiteOrders.remainingCapacity() == capacityOfQueue)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *Method which checks if the collectors que is empty or not and returns a boolean variable
	 *@return boolean which states if que is empty or full
	 */
	public boolean isCollectorOrderEmpty()
	{
		if( collectorsOrders.remainingCapacity() == capacityOfQueue)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 *Method which adds all the strings that are being callled in from the text file to the web assistants que
	 *@param String line this is the string to be added to the que
	 */
	public void addWebsiteOrder(String line)
	{
		synchronized(websiteOrders) {
			
			websiteOrders.add(line);
		}
	}
	
	/**
	 *method which processes the website orders and removes them from the assistants que
	 *@return String which is the String that has just been removed from the que
	 */
	public String processWebsiteOrder()
	{
		synchronized( websiteOrders) {
			
			return websiteOrders.remove();
			
			
		}
	}
	
	/**
	 *Method which adds the string variables to the collectors que after the web assistant has processed them
	 *@param String websiteOrder String to be added to the que
	 */
	public void addToCollectorOrder(String websiteOrder)
	{
		synchronized(collectorsOrders){
			
			collectorsOrders.add(websiteOrder);
			
		}
	}
	
	/**
	 *method which tells us the order has been collected from warehouse and removes string from the que
	 *@return String the string that has just been removed from the que
	 */
	public String completeCollectorOrder()
	{
		synchronized(collectorsOrders){
			
			return collectorsOrders.remove();
			
		}
	}

}
