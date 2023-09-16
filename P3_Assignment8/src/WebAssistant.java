//Patrick Noonan(20355426)

public class WebAssistant extends Thread {
	
	private String name;
	private int ID;
	private OnlineShop onlineShop;
	private int mug = 0, tshirt = 0, hoodie = 0, orders = 0;
	
	/**
	 *Constructor for the WebAsssitant object
	 *@param name this is a string variable which represents the assistants name
	 *@param ID is the ID which recognizes the assistant
	 *@param onlineShop is an OnlineShop object which gives this class access to all the methods
	 */
	public WebAssistant(String name, int ID, OnlineShop onlineShop)
	{
		this.name = name;
		this.ID = ID;
		this.onlineShop = onlineShop;
	}
	
	
	/**
	 *Class run
	 *this is the class which executes when the thread is called to start in the main method which allows the assistant to process orders
	 */
	public void run()
	{
		boolean cont = false;
				do{
					cont = false;
			//iterator for amount of orders that are received 
			orders++;
			//method which removes order from web assistants que and returns it as string variable
			String collector = onlineShop.processWebsiteOrder();
			if(collector.contains("Mug")) //string variable being checked for what type of order it is and iterating this order
			{
				mug++;
			}
			else if(collector.contains("TShirt"))
			{
				tshirt++;
			}
			else if(collector.contains("Hoodie"))
			{
				hoodie++;
			}
			
			//add the string that was removed from the assistance que to the collectors que
			onlineShop.addToCollectorOrder(collector);
			
			//print out that order has been processed
			System.out.println(" Assistant " + name + " has processed order "+ collector);
			randomDelay();
			
			//for statement which checks multiple times to see if the que is empty as was having problem at the end of the que assistances were recognising empty que
			for(int i =0;i<10;i++) {
				
				if(!onlineShop.isWebsiteOrdersEmpty()) {
					cont = true;
				}
			}
			
		}while(cont);//if the web orders que is empty the cont boolean wont be changed to true so it will break out of loop

			
				//while loop which makes sure totals aren't printed out till the very end
			while(!onlineShop.isCollectorOrderEmpty())
			{
				
			}
			System.out.println("Assistant " + name + " processed a total of " + orders + " orders. With " + mug + " mugs, " + tshirt + " tshirts, " + hoodie + " hoodies. " );
		
	}
	
	/**
	 *Random Delay
	 *method which creates a random delay
	 */
	public void randomDelay() {
	    // Simulate a random delay
	    try {
	      Thread.sleep((long) (Math.random()*200));
	    }
	    catch (InterruptedException ex)
	    {
	      System.out.println("Thread interrupted...");
	    }
	  }

}
