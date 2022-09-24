package setTheory;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set test = new Set();
		Set testOne = new Set();

		
		MathObjs five = new MathObjs(5);
		MathObjs six = new MathObjs(6);
		test.addElement(five);
		test.addElement(six);
		
		testOne.setArray(test.getSet());
		MathObjs seven = new MathObjs(7);
		testOne.addElement(seven);
		MathObjs eight = new MathObjs(8);
		testOne.addElement(eight);
		System.out.println(test.getLength());
		
		testOne.printSet();
		test.printSet();
		
		System.out.println(testOne.getLength());
	}

}
