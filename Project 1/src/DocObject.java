/**
 * $Id: DocObject.java,v 1.4 2014/03/04 22:55:42 asi8443 Exp $
 * 
 * $Log: DocObject.java,v $
 * Revision 1.4  2014/03/04 22:55:42  asi8443
 * comments finished
 *
 * Revision 1.3  2014/03/04 20:08:02  asi8443
 * finished methods
 *
 */

/**
 * @author Alexandria Infantino
 *An element in a document. DocObjects form a tree. Some implementors can have 
 *multiple children; others wrap a single other DocObject, whereas the TextObject 
 *class is a leaf -- no children.
 */
public interface DocObject {
	//Convert this subtree of the document to plain-text HTML.
	//returns: a string containing legal XHTML that represents the doc tree rooted at this node
	java.lang.String generateHTML();
	//How many printable characters are in this subtree of the document?
	//returns:the number of non-whitespace characters below this node in the tree
	long characterCount();
	//Search for a given character sequence in this subtree of the document
	//params: s - the search string
	//returns:true iff the search string is found in a single node of the tree rooted 
	//at this document node
	boolean contains(java.lang.String s);
	//What are the subtrees of this document node? 
	//Postcondition: returned list is unmodifiable.
	//returns: a list of the direct descendant document object nodes of this node, 
	//preserving the order in which they were inserted. If this node's type is one 
	//that does not have children, an empty list is returned. If this node's type 
	//has a single subordinate DocObject, that single node is returned in a singleton list.
	java.util.List<DocObject> children();
	//Replace all occurrences of the search string with a new string. As in the contains 
	//method, the search string must exist completely within one document object node.
	//params:oldS - the search string, newS - the string that replaces each occurrence of 
	//the search string
	void replace(java.lang.String oldS, java.lang.String newS);
	//Replace all occurrences of the search object with a new object. The equality
	//operator "==" (not the equals method) is used to identify the search object 
	//in the document tree. No objects are copied in the execution of this method. 
	//If this node's type is one that does not have children, this method is a no-op.
	//params:oldObj - the search object, newObj - the object that replaces each 
	//occurrence of the search object
	void replace(DocObject oldObj, DocObject newObj);
	// Insert a new document object node into the list of children of this node.
	//If this node's type is one that does not have children, or that has a fixed number 
	//of children when created, a BadChildException (a descendant of RuntimeException) 
	//will occur.
	//params: before - the index that the new document object will have, i.e., its 
	//ordinal position in the child list. All children formally at that or greater 
	//position will have their position numbers increased by one.
	//dObj - the new document object to be inserted
	void addChild(int before, DocObject dObj);
	//Is this the root of the document tree?
	// returns: true iff this is an instance of RootObject.
	boolean isRoot();
}
