//Patrick Noonan(20355426)

public class WarehouseCollector extends Thread{
	
	private String name;
	private int ID;
	private OnlineShop onlineShop;
	private int mug = 0, tshirt = 0, hoodie = 0, orders = 0;
	
	/**
	 *Constructor for the WarehouseCollector object
	 *@param name which is the name of the collector
	 *@param ID is the ID associated with the collector
	 *@param onlineShop is the OnlineShop object to give us access to all of the methods in the object
	 */
	public WarehouseCollector( String name, int ID, OnlineShop onlineShop)
	{
		this.name = name;
		this.ID = ID;
		this.onlineShop = onlineShop;
	}
	
	/**
	 *Run method
	 *this is the methd that will be called when the thread is asked to start in the main method
	 */
	public void run()
	{
		
		boolean cont = false;
		
			do
			{
				cont = false;
				
				//iterator for the amount of orders being colllected
				orders++;
				
				//string variable of the order being removed from the que
				String collector = onlineShop.completeCollectorOrder();
				
				if(collector.contains("Mug"))//if statement to check on the type of order that is being collected
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
				
				//print out telling us who collected what ordeer
				System.out.println(" Collector " + name + " has collected order "+ collector);
				
				
				
				randomDelay();
				for(int i =0;i<20;i++) {//for loop which causes the collector to check multiple times to see if the que is empty
					
					if(!onlineShop.isCollectorOrderEmpty()) {
						cont = true;
					}
				}
			}while(cont); //if que is empty cont does not get changed back to true so it then breaks out of the loop
		
			//while loop which makes sure totals aren't printed out till the very end
			while(!onlineShop.isCollectorOrderEmpty())
			{
				
			}
		
		System.out.println("Collector " + name + " collected a total of " + orders + " orders. With " + mug + " mugs, " + tshirt + " tshirts, " + hoodie + " hoodies. " );
		
	}
	
	/**
	 *RandomDelay
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
