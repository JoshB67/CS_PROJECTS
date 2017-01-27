package cloneExamples;

public class Address implements Cloneable {
	private String street, city, state;

	public Address(String street, String city, String state) {
		this.street = street;
		this.city = city;
		this.state = state;
	}

	/* This makes the class MUTABLE */
	public void changeStreet(String street) {
		this.street = street;
	}
	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if ( !(other instanceof Address)) {
			return false;
		}
		Address a = (Address) other;
		return a.street.equals(street) && a.city.equals(city) && a.state.equals(state);
	}
	
	public Address clone() {
		Address theCopy = null;
		try {
			theCopy = (Address)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return theCopy;
	}
}
