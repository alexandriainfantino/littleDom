import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author Alexandria Infantino
/**
 * $Id: TextObject.java,v 1.3 2014/03/04 22:55:43 asi8443 Exp $
 * 
 * $Log: TextObject.java,v $
 * Revision 1.3  2014/03/04 22:55:43  asi8443
 * comments finished
 *
 * Revision 1.2  2014/03/04 20:08:03  asi8443
 * finished methods
 *
 *creates new instance of private string text and sets this.text equal to the text 
 *passed within the params
 */
public class TextObject implements DocObject {
	private String text;
	List<DocObject> childList = new ArrayList<DocObject>();
	TextObject(String text){
		this.text = text;
	}
	//returns the text
	public String getText(){
		return text;
	}
	//returns the text since this is the leaf node that needs tags
	public String generateHTML(){
		return text;
	}
	//counts the ammount of non white space characters within the text, returns
	//a long representing that number
	public long characterCount(){
		long numChar = 0;
		String str = generateHTML();
		for(char s: str.toCharArray()){
			if(s != ' '){
				numChar++;	
			}
		}
		return numChar;
	}
	//checks if string is contained within text
	public boolean contains(java.lang.String s){
		String str = generateHTML();
		if(str.contains(s)==true){
			return true;
		}
		return false;
	}
	//creates list of children and returns an unmodifiable list since
	//text Object can contain no children
	public java.util.List<DocObject> children(){
		List<DocObject> childList = new ArrayList<DocObject>();
		return Collections.unmodifiableList(childList);
	}
	//replaces string values in text
	public void replace(java.lang.String oldS, java.lang.String newS){
		text = text.replaceAll(oldS, newS);
	}
	//does nothing since textObject contains no docObjects
	public void replace(DocObject oldObj, DocObject newObj){
		
	}
	//cannot add child so throws exception
	public void addChild(int before, DocObject dObj){
		throw new BadChildException();
	}
	//returns false since textObject is not a root Object
	public boolean isRoot(){
		return false;
	}
	

}
