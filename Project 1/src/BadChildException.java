/*
 * BadChildException.java
 * 
 * Version:
 * $Id: BadChildException.java,v 1.1 2014/02/27 04:48:29 asi8443 Exp $
 */

/**
 * The exception raised when code attempts to add a document object to another
 * document object that is primitive, i.e., cannot take children, or has a
 * single fixed child.
 * 
 * @author James Heliotis
 * @version $Id: BadChildException.java,v 1.1 2014/02/27 04:48:29 asi8443 Exp $
 */
public class BadChildException extends RuntimeException {

    private static final long serialVersionUID = 4936919450156123253L;

}
