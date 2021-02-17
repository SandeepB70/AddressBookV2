/**
 * Represents a record for an individual by storing their name, address, and phone number.
 * @author Sandeep Bindra
 * @version 2.0
 */
public class PersonRecord implements Comparable<PersonRecord> {
	
    private String name; //Name of the individual
    private Address address; //Address of the individual
    private String phone; //Phone Number of the individual.
    
    /**
     * Constructor for creating an empty PersonRecord object.
     */
    public PersonRecord() {
    	name = "";
    	address = new Address();
    	phone = "";
    }
    
    /**
     * Constructor for creating a PersonRecord with the supplied information.
     * @param name Name of the individual
     * @param address Address of the individual 
     * @param phone Phone number of the individual
     */
    public PersonRecord(String name, Address address, String phone) {
    	this.name = name;
    	this.address = address;
    	this.phone = phone;
    }
    
    /**
     * Sets the name of the individual.
     * @param name Name the stored within the PersonRecord
     */
    public void setName(String name) {
    	this.name = name;
    }
    
    /**
     * @return The name of the individual
     */
    public String getName() {
    	return this.name;
    }
    
    /**
     * Changes the address of the individual
     * @param address What the address will be set to.
     */
    public void setAddress(Address address) {
    	this.address = address;
    }
    
    /**
     * @return A copy of the individual's address
     */
    public Address getAddress() {
    	return this.address.copy();
    }
    
    /**
     * Changes the individual's phone number
     * @param phone What the phone number will be set to.
     */
    public void setPhone(String phone) {
    	this.phone = phone;
    }
    
    /**
     * @return The individual's phone number
     */
    public String getPhone() {
    	return this.phone;
    }
    
    /**
     * Compares two PersonRecords by comparing using their name. Relies on the compareTo() method of the String class.
     * @param otherRecord The PersonRecord object the calling instance will be compared to.
     * @return 0 If the two PersonRecords have the same name. 1 if the calling PersonRecord object has a name 
     * 			greater than parameter's according to the String compareTo() method. -1 if the calling PersonRecord
     * 			has a name considered less than the parameter's according to the String compareTo() method.
     */
    public int compareTo(PersonRecord person2) {
    	
    	int compare = this.name.compareTo(person2.name);
    	if (compare < 0) {
    		return -1;
    	} else if (compare > 0) {
    		return 1;
    	} else {
    		return 0;
    	}
    }
    
    /**
     * @return A string holding the individual's name, address, and phone number.
     */
    public String toString() {
    	String str = "Name: " + this.name +
    					"\n" + this.address +
    					"\nPhone Number: " + this.phone;
    	return str;
    }
}