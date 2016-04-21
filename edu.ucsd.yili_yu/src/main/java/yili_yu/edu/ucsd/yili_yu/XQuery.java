package yili_yu.edu.ucsd.yili_yu;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class XQuery {
	public static void main(String[] args) throws Exception {
		//create a CharStream that reads from standard input
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		//create a lexer that feeds off of input CharStream
		XQueryLexer lexer = new XQueryLexer(input);
		//create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//create a parser that feeds off the tokens buffer
		XQueryParser parser = new XQueryParser(tokens);
		ParseTree tree = parser.xq(); // begin parsing at init rule
		System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		
		// Create a generic parse tree walker that can trigger callbacks
		ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks
		walker.walk(new XQueryProcessor(), tree);
		System.out.println(); // print a \n after translation
	}
}
