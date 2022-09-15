public class Set{
	public ArrayList<MathObjs> set = new ArrayList();
	private boolean isEmpty;
	private int len;
	
	public Set() {
		this.set = setAsEmpty(this.set);
		this.isEmpty = true;
		this.len = 0;
	}
	
	//get methods
	public Set getSet() {
		return this.set;
	}
	public boolean getIsEmpty() {
		return this.isEmpty;
	}
	public int getLength() {
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
		else {
			break;
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
		this.add(element);
	}
	public void removeElement(int i) {
		this.set.remove(i);
	}
	public Set union(Set someSet) { //The union of the object and another set
		Set join = new Set();
		int otherLen = someSet.getLength();
		for(i=0; i < otherLen; i++) {
			join.addElement(someSet.getElement(i));
		}
		for (i=0; i<this.set.getLength(); i++) {
			join.addElement(this.set.get(i)));
		}
		for(i = 0; i < join.getLength(); )
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
		int otherLen = someSet.getLength();
		Set joined = new Set();
		Set longest = new Set();
		Set shortest = new Set();
		longest.setArray(isLonger(this.set, someSet));
		shortest.setArray(isShorter(this.set, someSet));
		if(longest.isEmpty || shortest.isEmpty) {
			return joined; //the intersection of any set with the empty set is the empty set
		}
		for(i=0; i < longest.getLength(); i++) {
			for(j = 0; j < shortest.length(); j++) {
				if(shortest[i] != longest[j]) {
					joined.addElement(shortest[i]);
					joined.addElement(longest[j]);
					joined.isEmpty = false;
				}else {
					joined.addElement(shortest[i]);
					joined.isEmpty = false;
				}
			}
		}
		return joined;
	}
}