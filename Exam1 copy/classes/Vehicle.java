
public class Vehicle implements Cloneable {

	private String description;
	
	public Vehicle(String description){
		this.description = description;
	}
	
	
	public class Car extends Vehicle implements Cloneable{
		private Engine engine;
		
		public Car(String description, Engine engine){
			super(description);
			this.engine = engine;
		}
		
		
		
		public Engine getEngine() {
			return engine;
		}



		public void setEngine(Engine engine) {
			this.engine = engine;
		}



		public boolean equals(Object other){
			if(other == this){
				return true;
			}if(other == null){
				return false;
			}if(!(other instanceof Car)){
				return false;
			}
			
			Car c = (Car)other;
			
			if( super.equals(c) && this.engine.equals( c.getEngine()) ){
				return true;
			} else {
				return false;
			}
		}
		
		
		
		
		public Car clone(){

			Car copy = null;
			
			try{
				
				copy = (Car)super.clone();
				copy.engine = this.engine.clone();
				
			} catch(CloneNotSupportedException e){
			return copy;
		}
	}

}



public V find(K key){
  	Node n = helper(k, root);
    if(n == null) {
      return null;
    } else {
      return n.data;
    }
  
  
  public Node helper(K key, Node n){
    if(n == null){
      return null;
    }
    if(n.key == key) {
      return n;
    }
    if (key.compareTo(n.key) < 0) {
      return helper(key, n.left);
    } else {
      return helper(key, n.right);
    }
      
  }

