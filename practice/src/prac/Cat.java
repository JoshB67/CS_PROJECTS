package prac;

import java.util.*;


public class Cat<T> implements Comparable<T>{
 
  private T any;
  
  public Cat(T any){
    this.any = any;
  }
  
  
  public T getAny(){
    return this.any;
  }
  
  
  public void setAny(T any){
    this.any = any;
  }
  
  
  @Override
  public int compareTo(int other){
    if(this.getAny() > other.getAny()){
      return 1;
    }
    if(this.getAny() < other.getAny()){
      return -1;
    } else {
      return 0;
    }
  }
  
  @Override
  public String toString(){
    return "(" + this.any + ")";
  }
  
  public static void main(String[] args){
    ArrayList<Cat<Integer>> catList = new ArrayList<Cat<Integer>>();
  
    catList.add(new Cat(12));
    catList.add(new Cat(42));
    catList.add(new Cat(1));
    catList.add(new Cat(7));
                
    Collections.sort(catList);
    
	for(Cat x : catList){
      System.out.println(x);
    }

  }
}