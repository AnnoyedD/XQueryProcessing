package xqueryprocessor.yili_yu;

//import ANTLR's runtime libraries
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.tree.gui.TreeViewer;

import xml.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import org.w3c.dom.*;

public class XQuery {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name for XQuery: ");
		String inFileName = scanner.nextLine();
		System.out.println("Whether to show the XQuery tree [y/n]: ");
		String toShow = scanner.nextLine();
		
		//read XQuery and rewrite
		File file = new File(inFileName);
		FileInputStream fis = new FileInputStream(file);
		ANTLRInputStream input = new ANTLRInputStream(fis);
		XQueryLexer lexer = new XQueryLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XQueryParser parser = new XQueryParser(tokens);
		ParseTree tree = parser.xq(); // begin parsing at xq rule
		
		MyRewrittor rewtr = new MyRewrittor();
		String newQuery = rewtr.visit(tree);
		
		ArrayList<Node> result = null;
		long start_time = 0, end_time = 0;
		MyVisitor eval = new MyVisitor();
		
		if (newQuery==null){
			System.out.println("No need to rewrite.");
			
			start_time = System.currentTimeMillis();
			result = eval.visit(tree);
			end_time = System.currentTimeMillis();
			
			if (toShow.equals("y")){
				drawParseTree(parser, tree, "old.jpg");
			}
		}
		else{
			System.out.println("Need to rewrite.");
			
			File file2 = new File("temp.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			fos.write(newQuery.getBytes());
		
			FileInputStream fis2 = new FileInputStream(file2);
			ANTLRInputStream input2 = new ANTLRInputStream(fis2);
			XQueryLexer lexer2 = new XQueryLexer(input2);
			CommonTokenStream tokens2 = new CommonTokenStream(lexer2);
			XQueryParser parser2 = new XQueryParser(tokens2);
			ParseTree tree2 = parser2.xq(); 
			
			start_time = System.currentTimeMillis();
			result = eval.visit(tree2);
			end_time = System.currentTimeMillis();
			
			if (toShow.equals("y")){
				drawParseTree(parser2, tree2, "new.jpg");
			}
		}	
		
		System.out.println("Time to process the XQuery (in ms): "+(end_time-start_time));
		
		eval.generateResult(result);

		System.out.println("SUCCESS!");
	}
	
	private static void drawParseTree(XQueryParser parser, ParseTree tree, String name) throws IOException{
		JFrame frame = new JFrame("Antlr AST");
        JPanel panel = new JPanel();
        TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
        viewr.setScale(0.8);//scale a little
        panel.add(viewr);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400,700);
        frame.setVisible(true);
        //save the image
        BufferedImage img = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics(); 
        frame.paint(g2d); 
        ImageIO.write(img,"jpg", new File(name));
	}
}

