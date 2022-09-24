package setTheory;
import java.util.ArrayList;
//naive set theory with integers
public class Set{
	public ArrayList<MathObjs> set;
	private boolean isEmpty;
	private int len;
	private String asString;
	public Set() {
		this.set = new ArrayList<MathObjs>();
		this.isEmpty = true;
		this.len = 0;
	}
	
	//get methods
	public ArrayList<MathObjs> getSet() {
		return this.set;
	}
	

	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	public void setLength(int num) {
		this.len = num;
	}
	public int getLength() {
		if(this.len != this.set.size()) {
			this.setLength(this.set.size());
		}
		return this.len;
	}
	public MathObjs getElement(int i) {
		return this.set.get(i);
	}
	
	//set methods
	public void setAsEmpty() {
		this.isEmpty = false;
		if(!this.getIsEmpty()) {
			int initLen = this.len;
			for (int i =0; i< initLen; i++) {
				this.set.remove(i);
			}
		}
		
	}
	public void setArray(ArrayList<MathObjs> newSet) { //sets an array to the current object
		this.set = newSet;
		if(newSet.size() != 0) {
			this.isEmpty = false;
		}else {
			this.isEmpty = true;
		}
		this.len = newSet.size();
	}
	
	//set operations
	public void addElement(MathObjs element) { //adds element to the current set
		this.set.add(element);
	}
	public void removeElement(int i) {
		this.set.remove(i);
	}
	public Set union(Set someSet) { //The union of the object and another set
		Set join = new Set();
		int otherLen = someSet.getLength();
		for(int i=0; i < otherLen; i++) {
			join.addElement(someSet.getElement(i));
		}
		for (int i=0; i<this.getLength(); i++) {
			join.addElement(this.set.get(i));
		}
		return join;
	}
	public static Set isLonger(Set setOne, Set setTwo) {
		int lenOne = setOne.getLength();
		int lenTwo = setTwo.getLength();
		if(lenOne != lenTwo) {
			if(lenTwo > lenOne) {
				return setTwo;
			}else {
				return setOne;
			}
		}else {
			return null;
		}
	}
	public static Set isShorter(Set setOne, Set setTwo) {
		int lenOne = setOne.getLength();
		int lenTwo = setTwo.getLength();
		if(lenOne != lenTwo) {
			if(lenTwo < lenOne) {
				return setTwo;
			}else {
				return setOne;
			}
		}else {
			return null;
		}
	}
	public  static int sizeCompare(Set setOne, Set setTwo) { //compares two sets
		//returns 0 if they are equal, returns a positive value if setOne is longer than setTwo, and the opposite for opposite case
		return setOne.getLength() - setTwo.getLength();
	
	}
	public Set intersect(Set someSet) { //The intersection of the object and some other set
		Set joined = new Set();
		Set longest = new Set();
		Set shortest = new Set();
		
		longest.setArray(isLonger(this, someSet).set);
		shortest.setArray(isShorter(this, someSet).set);
		if(longest.isEmpty || shortest.isEmpty) {
			return joined; //the intersection of any set with the empty set is the empty set
		}
		for(int i=0; i < longest.getLength(); i++) {
			for(int j = 0; j < shortest.getLength(); j++) {
				if(shortest.getElement(i) != longest.getElement(i)) {
					joined.addElement(shortest.getElement(i));
					joined.addElement(longest.getElement(i));
					joined.isEmpty = false;
				}else {
					joined.addElement(shortest.getElement(i));
					joined.isEmpty = false;
				}
			}
		}
		return joined;
	}
	public void printSet() {
		this.asString = "{";
		for(int i = 0; i < this.len; i++) {
			this.asString += this.getElement(i).getValue() + ", ";
		}
		this.asString += "}";
		System.out.println(asString);
	}

}