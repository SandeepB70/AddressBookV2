/**
 * Represents an Address for an individual by storing their street name, city, state, and zipCode.
 * @author Sandeep Bindra
 * @version 2.0
 */

public class Address {
	private String street; //Street the individual lives on.
	private String city; //City the individual lives in
	private String state; //State the individual lives in
	private String zipCode; //Zip code of the city the individual lives in
	
	/**
	 * Default constructor for creating an empty address
	 */
	public Address() {
		this.street = "";
		this.city = "";
		this.state= "";
		this.zipCode = "";
	}
	
	/**
	 * Creates an address with the supplied information. 
	 * @param street Street name
	 * @param city City name
	 * @param state The state
	 * @param zipCode Represents the zip code.
	 */
	public Address(String street, String city, String state, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	/**
	 * Changes the street name for an individual
	 * @param street Name the street will be changed to.
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @return The name of an individual's street
	 */
	public String getStreet() {
		return this.street;
	}
	
	/**
	 * Changes the city of an individual
	 * @param city The name the city will be changed to.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Returns the name of an individual's city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Changes the individual's state
	 * @param state The new state
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return The state an individual lives in.
	 */
	public String getState() {
		return this.state;
	}
	
	/**
	 * Changes the zip code of an individual
	 * @param zipCode The new zip code.
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * @return The zip code of the individual
	 */
	public String getZipCode() {
		return this.zipCode;
	}
	
	/**
	 * Creates a copy of the Address and returns it.
	 * @return An Address that contains the same information as the calling object. 
	 */
	public Address copy() {
		Address copy = new Address(this.street, this.city, this.state, this.zipCode);
		return copy;
	}
	
	/**
	 * Checks if two Addresses are equal to each other. Relies on the equals() method from the String class.
	 * @param add The address the calling object will be compared to.
	 * @return true if the two addresses match on every field, otherwise false.
	 */
	public boolean equals(Address add) {
		if (this.street.equals(add.street) && 
			this.city.equals(add.street) && 
			this.state.equals(add.state) && 
			this.zipCode.equals(add.zipCode)) {
				return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return A string that hold the address information of the individual.
	 */
	public String toString() {
		String str = "Address: " + this.street + " " + this.city + " " + this.state + " " + this.zipCode;
		return str;
	}
}