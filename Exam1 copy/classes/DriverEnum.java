
public class DriverEnum {

	public static void main(String[] args) {
		for(MyEnum x : MyEnum.values()){
			System.out.println(x.getName() + " was " + x.getDescr() + " when I was " + x.getMyAge());
		}

	}

}
