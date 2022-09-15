import java.util.ArrayList;


public class MathObjs {
	private float value;
	public 	ArrayList<Float> realNums= new ArrayList();
	public MathObjs() { //takes other mathematical objects
		
	}
	public MathObjs(float val){ //takes real numbers
		this.value = val;
		this.realNums.add(val);
	}
	public float getValue() {
		return this.value;
	}
	public float setValue(float newVal) {
		this.value = newValue
	}
	public void clearList() {
		for (int i=0; i< this.realNums.size(); i++){
			realNums.remove(i);
		}
	}
}
//class Vector extends MathObjs {
