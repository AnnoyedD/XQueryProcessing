package yili_yu.edu.ucsd.yili_yu;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class XQuery {
	public static void main(String[] args) throws Exception {
		//create a CharStream that reads from standard input
		File file = new File("querySample2.txt");
		 FileInputStream fis = new FileInputStream(file);
		ANTLRInputStream input = new ANTLRInputStream(fis);
		//create a lexer that feeds off of input CharStream
		XQueryLexer lexer = new XQueryLexer(input);
		//create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//create a parser that feeds off the tokens buffer
		XQueryParser parser = new XQueryParser(tokens);
		ParseTree tree = parser.xq(); // begin parsing at init rule
		//System.out.println(tree.toStringTree(parser)); // print LISP-style tree
		/*
		JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(
                parser.getRuleNames()),tree);
        viewr.setScale(1.2);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,700);
        frame.setVisible(true);
        BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics(); 
        frame.paint(g2d); 
        ImageIO.write(img,"jpg", new File("long.jpg"));
		*/
        System.out.println("========"+tree.getText());
		// Create a generic parse tree walker that can trigger callbacks
		//ParseTreeWalker walker = new ParseTreeWalker();
		// Walk the tree created during the parse, trigger callbacks
		//XQueryProcessor xqprocessor= new XQueryProcessor();
		//walker.walk(xqprocessor, tree);
		//System.out.println(); // print a \n after translation
	}
}

