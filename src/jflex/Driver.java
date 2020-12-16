package jflex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.Symbol;
import astClasses.Program;

public class Driver {
    static HashMap<Integer, String> tokenClass = new HashMap<Integer, String> ();

    public static void initHash()
    {
        tokenClass.put(sym.INT    , "INT");
        tokenClass.put(sym.IF     , "IF");
        tokenClass.put(sym.ELSE   , "ELSE");
        tokenClass.put(sym.VOID   , "VOID");
        tokenClass.put(sym.RETURN , "RETURN");
        tokenClass.put(sym.WHILE  , "WHILE");
        tokenClass.put(sym.EQ     , "EQ");
        tokenClass.put(sym.NOTEQ  , "NOTEQ");
        tokenClass.put(sym.GT     , "GT");
        tokenClass.put(sym.LT     , "LT");
        tokenClass.put(sym.GTEQ   , "GTEQ");
        tokenClass.put(sym.LTEQ   , "LTEQ");
        tokenClass.put(sym.COMMA  , "COMMA");
        tokenClass.put(sym.ADD    , "ADD");
        tokenClass.put(sym.MULT   , "MULT");
        tokenClass.put(sym.DIV    , "DIV");
        tokenClass.put(sym.SEMICOL, "SEMICOL");
        tokenClass.put(sym.SUB    , "SUB");
        tokenClass.put(sym.ASSIGN , "ASSIGN");
        tokenClass.put(sym.LBRKT  , "LBRKT");
        tokenClass.put(sym.RBRKT  , "RBRKT");
        tokenClass.put(sym.RSQBKT , "RSQBKT");
        tokenClass.put(sym.LSQBKT , "LSQBKT");
        tokenClass.put(sym.RPAREN , "RPAREN");
        tokenClass.put(sym.LPAREN , "LPAREN");
        tokenClass.put(sym.ID     , "ID");
        tokenClass.put(sym.NUM    , "NUM");
        tokenClass.put(sym.error  , "error");
        tokenClass.put(sym.EOF    , "EOF");
        tokenClass.put(sym.WHITESPACE, "WHITESPACE");
    }

    public static void main (String[] args) {

        Driver.initHash();

        FileReader inputFile;
        try {
            inputFile = new FileReader("test.c");
            BufferedReader br = new BufferedReader(inputFile);
			
            Lexer l = new Lexer (new ComplexSymbolFactory(), br);
            
            System.out.println("Lexical analyser:\n");
            
            try {
                Symbol sCrt;
                do
                {
                    sCrt = l.next_token();

                    if (sCrt.sym != sym.EOF)
                    {
                        //Print the Symbol class, the line and the column
                        System.out.print(Driver.tokenClass.get(sCrt.sym));// + " " + sCrt.left + ":" + sCrt.right);

                        //print the value of the NUM or the name of the ID
                        if(Driver.tokenClass.get(sCrt.sym).compareTo("ID") == 0
                                ||
                           Driver.tokenClass.get(sCrt.sym).compareTo("NUM") == 0) {
                            System.out.print(" value: " + l.yytext());
                        }

                        //new line for the next token
                        System.out.println();
                    }
                }while(sCrt.sym != sym.EOF);
                System.out.println("EOF");
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            System.out.println("\n\nSyntax Tree:\n");
            Parser parser = new Parser();
			try {				
	            Symbol root = parser.parse();
	            Program program = (Program) root.value;
//	            program.print();
	            System.out.println(root.value);
	            
	            program.printTree(0);
			}
			catch(Exception e) {
				System.out.println("Invalid Syntax");
				//e.printStackTrace();
			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

	public static void parseTree(Symbol root) {
		
	}

}