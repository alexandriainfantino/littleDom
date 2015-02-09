import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 */

/**
 * @author Alexandria Infantino
/**
 * $Id: Sequence.java,v 1.3 2014/03/04 22:55:42 asi8443 Exp $
 * 
 * $Log: Sequence.java,v $
 * Revision 1.3  2014/03/04 22:55:42  asi8443
 * comments finished
 *
 * Revision 1.2  2014/03/04 20:08:02  asi8443
 * finished methods
 *
 *arraylist childlist is instantiated
 */
public class Sequence implements DocObject {
	ArrayList<DocObject> childList = new ArrayList<DocObject>();
	public Sequence(){
	}
	/**
	 * html is generated for each object within childlist
	 */
	public String generateHTML(){
		String str = "";
		for(DocObject doc : childList){
			str += ""+doc.generateHTML()+"";
		}
		//System.out.println(str);
		return str;
	}
	/**
	 * for each object in childLisrt count is incremented by the number of non whitespace
	 * characters the text object contains. count is returned as a long
	 */
	public long characterCount(){
		long count = 0;
		for(DocObject d : childList){
			count += d.characterCount();
		}
		return count;
	}
	/**
	 * generates string version of doc object and checks if a string is present, if it is
	 * true is returned, otherwise false is returned
	 */
	public boolean contains(String s){
		String search = generateHTML();
		if(search.contains(s)){
			return true;
		}
		return false;
	}
	//returns an unmodifieable list of children, childList is a global variable in this class
	public java.util.List<DocObject> children(){
		return Collections.unmodifiableList(childList);
	}
	/**
	 * for each object in childList, if the object contains the oldS, its replaced with the 
	 * new string
	 */
	public void replace(String oldS,String newS){
		for(DocObject obj: childList){
			if (obj.contains(oldS)){
				obj.replace(oldS,newS);
			}
		}
	}
	/**
	 * for each object in childList replace is called on that object, if the html is equal to
	 * the html of the object looking to be replaced the index of the current object is 
	 * found and replaced by the new object
	 */
	public void replace(DocObject oldObj, DocObject newObj){
		for(DocObject obj: childList){
			obj.replace(oldObj, newObj);
			if(obj.generateHTML().equals(oldObj.generateHTML())){
				int value = childList.indexOf(oldObj);
				childList.set(value,newObj);
			}
		}
	}
	/**
	 * adds an object into the list of objects at the index "before"
	 */
	public void addChild(int before,DocObject dObj){
		childList.add(before, dObj);
	}
	//returns false since listObject is not the root
	public boolean isRoot(){
		return false;
	}



	
}
