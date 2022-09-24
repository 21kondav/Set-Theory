package setTheory;
import java.util.ArrayList;

//TODO rebuild for abstraction
public class MathObjs {
	private int value;
	public 	ArrayList<Integer> realNums= new ArrayList<Integer>();
	public MathObjs() { //takes other mathematical objects
		
	}
	public MathObjs(int val){ //takes real numbers
		this.value = val;
		this.realNums.add(val);
	}
	public float getValue() {
		return this.value;
	}
	public void setValue(int newVal) {
		this.value = newVal;
	}
	public void clearList() {
		for (int i=0; i< this.realNums.size(); i++){
			realNums.remove(i);
		}
	}
}
//class Vector extends MathObjs {
//class Reals extends MathObjs
