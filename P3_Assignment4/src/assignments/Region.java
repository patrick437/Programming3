package assignments;

/**
 * ENUM class called regions which is a list of all the possible regions a piece of land can contain
 * @author Patrick Noonan(20355426)
 */
public enum Region{
	
	
		STATE("State"),
		BORDER("Border"),
		MIDLAND("Midland"),
		WEST("West"),
		DUBLIN("Dublin"),
		MIDWEST("Mid-West"),
		SOUTHEAST("Sounth-East"),
		SOUTHWEST("South-West"),
		MIDEAST("Mid-East"),
		OTHER("other");
		
		
		private String enums;

		/**
		 * Constructor which creates each enum variable
		 * @param enums String which is associated with each enum variable
		 */
		private Region(String enums) {
			this.enums = enums;
		}	
		
		/**
		 * a method which returns the string associated with each enum
		 * @return enums the string version of the enum
		 */
		public String getEnum() {
			return enums;
		}
		
		/**
		 * Method for taking in the string version of the enum and returning its Enum variable if the string is incorrect it will just assign it to OTHER enum
		 * @param region the string associated with each enum variable
		 * @return r the Enum variable itself
		 */
		public static Region getRegion(String region) {
			
			for(Region r: Region.values()) {
			
				if(r.getEnum().equals(region)) {
				return r;
				}
			
				
			}
			
			return OTHER;
			
		}
	
	

}			
		

	


