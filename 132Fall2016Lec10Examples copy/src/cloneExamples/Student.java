package cloneExamples;

public class Student implements Cloneable {
	private int id;
	private String name;
	private Address address;
	
	public Student(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public boolean equals(Object other) {
		if  (this == other) {
			return true;
		}
		if ( !(other instanceof Student)) {
			return false;
		}
		
		Student s = (Student)other;
		return s.id == id && s.name.equals(name) && s.address.equals(address);
	}
	
	public Address getAddress() {
		return address;
	}
	
	public Student clone() {
		Student theCopy = null;
		try {
			theCopy = (Student)super.clone();
			theCopy.address = address.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return theCopy;
	}
	
	public String toString() {
		String res = "Id: " + id + ", ";
		res += "Name: " + name + ", ";
		return res += "Address: " + address;
	}

}
