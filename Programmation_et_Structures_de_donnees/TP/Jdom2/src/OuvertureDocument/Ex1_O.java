package OuvertureDocument;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.*;


public class Ex1_O {
  public static void main(String[] args) throws IOException {
  
    if (args.length == 0) {
      System.out.println("Usage: java JDOMP file1 file2..."); 
    } 
    // tester Exercice2.xml comme argument
      
    SAXBuilder builder = new SAXBuilder();
     
    // start parsing... 
    for (int i = 0; i < args.length; i++) {
      
      // command line should offer URIs or file names
      try {
        builder.build(args[i]);
        // If there are no well-formedness errors, 
        // then no exception is thrown
        System.out.println(args[i] + " is well formed.");
      }
      catch (JDOMException e) { // indicates a well-formedness or other error
        System.out.println(args[i] + " is not well formed.");
        System.out.println(e.getMessage());
      }
      
    }   
  
  }

}