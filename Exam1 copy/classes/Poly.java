import java.util.*;


public class Poly {
	private String name;
	private int age;
	private double salary;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	
	public Poly(String name){
		this.name = name;
	}
	
	
	public Poly(String name, int age, double Salary, ArrayList<Integer> x){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.list = x;
	}
	
	
	public int concat(){
		return age + (int)salary;
	}
	
	
	public boolean checkStuff(){
		if(name == "Jamie" && age == 27){
			return true;
		}else{
			return false;
		}
	}
	
	
	public void myMessage(){
		System.out.println("Hello World!");
	}
	
	
	public String myMeth(String s){
		return s;
	}
	
}
