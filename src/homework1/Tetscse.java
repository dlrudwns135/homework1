package homework1;

public class Tetscse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicClassProvider.register("Trident", "M", "kr.cnu.plas.apl.Printable1");
		
		Object O = DynamicClassProvider.newInstance("Trident", "M");
		((IPrintable)O).printName();
	}
}
