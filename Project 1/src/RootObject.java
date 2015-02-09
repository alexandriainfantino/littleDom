/**
 * author: Alexandria Infantino
 * 
 * $Id: RootObject.java,v 1.3 2014/03/04 22:55:43 asi8443 Exp $
 * 
 * $Log: RootObject.java,v $
 * Revision 1.3  2014/03/04 22:55:43  asi8443
 * comments finished
 *
 * Revision 1.2  2014/03/04 20:08:03  asi8443
 * finished methods
 *
 *creates new instance of private String title as well as private DocObject dObj
 *this.title and this.dObj is set equal to the title and object passed into the 
 *parameters
 */

import java.util.ArrayList;
import java.util.Collections;


public class RootObject implements DocObject {
	private String title;
	private DocObject dObj;
	RootObject(String title, DocObject dObj){
		this.title = title;
		this.dObj = dObj;
	}
	/**Convert this subtree of the document to plain-text HTML.
	*returns: a string containing legal XHTML that represents the doc tree rooted at this node
	*appropriate tags with object
	*/
	public String generateHTML(){
		String str = "<html><head><title>"+title+"</title></head><body>";
		str += ""+dObj.generateHTML()+"";
		str += "</body></html>";
		//System.out.println(str);
		return str;
	}
	/**
	 * returns characterCount on docobject since it is not at the leaf node level
	 */
	public long characterCount(){
		return dObj.characterCount();
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
	/**
	 * creates an array and adds the docobject to said array since it is unable to have 
	 * multiple children returns array as an unmodifieable list.
	 */
	public java.util.List<DocObject> children(){
		ArrayList<DocObject> childList = new ArrayList<DocObject>();
		childList.add(dObj);
		return Collections.unmodifiableList(childList);
	}
	/**
	 * search docObject for a string calls recursively on docObject since it is not at
	 * the leaf node
	 */
	public void replace(String oldS,String newS){
		dObj.replace(oldS, newS);
	}
	/**
	 * checks if the docObject matches the docObject being searched for, if it does the
	 * current docObject is set to the new docObject otherwise replace is called 
	 * recursively on the docObject
	 */
	public void replace(DocObject oldObj, DocObject newObj){
			if(dObj == oldObj){
				dObj = newObj;
		}
			else{
				dObj.replace(oldObj, newObj);
			}
	}
	
	/**
	 * exception is thrown since header object can not have multiple children
	 */
	public void addChild(int before, DocObject dObj){
		throw new BadChildException();
	}
	//returns true since this is the root object
	public boolean isRoot(){
		return true;
	}
}
