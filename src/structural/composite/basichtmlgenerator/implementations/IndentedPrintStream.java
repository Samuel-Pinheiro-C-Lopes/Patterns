package structural.composite.basichtmlgenerator.implementations;

import java.io.PrintStream;

public class IndentedPrintStream extends PrintStream {
	private static int ident = 0;
	
	public static void incrementIndent() { ident++; }
	public static void decrementIdent() { ident--; }
	public static void resetIdent() { ident = 0;}
	
    public IndentedPrintStream(PrintStream out) {
        super(out);
    }
    
    @Override
    public void println(String str) {
    	String indentation = "";
    	
    	for (int i = 0; i < ident; i++)
    		indentation = indentation.concat("    ");
    	
    	super.println(indentation.concat(str));
    }
}

