package jflex;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.Symbol;
import java.lang.*;
import java.io.InputStreamReader;

%%

%unicode
%class Lexer
%public
%cup
%implements sym

%line
%column
 
%{
private String lastToken = " ";


/*
Check if two IDs, NUMs, and keywords are delimited with other token than IDs, NUMs, and keywords.
Otherwise return error with the "merged" ID.
*/
private boolean checkSeparator() {
   if(Character.isDigit(lastToken.charAt(lastToken.length() - 1))
      ||
      Character.isLetter(lastToken.charAt(lastToken.length() - 1))) {

      System.out.println("ERROR");
      error(lastToken + yytext());
      return false;
   }
   else {
      return true;
   }
}

public Lexer(ComplexSymbolFactory sf, java.io.InputStream is){
	this(is);
	symbolFactory = sf;
}

public Lexer(ComplexSymbolFactory sf, java.io.Reader reader){
	this(reader);
	symbolFactory = sf;
}

private StringBuffer sb;
private ComplexSymbolFactory symbolFactory;
private int csline, cscolumn;

public Symbol symbol(String name, int code) {
    return symbolFactory.newSymbol(name, code,
    				new Location(yyline + 1, yycolumn + 1, yychar),
    				new Location(yyline + 1, yycolumn + yylength(), yychar + yylength())
    				);
}

public Symbol symbol(String name, int code, Object lexem) {
    return symbolFactory.newSymbol(name, code,
    				new Location(yyline + 1, yycolumn + 1, yychar),
    				new Location(yyline + 1, yycolumn + yylength(), yychar + yylength()), lexem
    				);
}

private void error(String message) {
   System.out.println("Error at line "+ (yyline+1) + ", column " + (yycolumn+ 1)+ " : "+message);
}
%}

LineEnd = [\r\n]|\r\n
WhiteSpace = {LineEnd} | [ \t\f]

Comment = "/*" ~"*/"

Id = [a-zA-Z][a-zA-Z0-9_]*

Num = [0-9]+

%%
<YYINITIAL> {
   /* Arithmetic Operations */
   "-" { return symbol("SUB", SUB);}
   "+" { return symbol("ADD", ADD); }
   "*" { return symbol("MULT", MULT); }
   "/" { return symbol("DIV", DIV); }

   "<" { return symbol("LT", LT); }
   ">" { return symbol("GT", GT); }
   ">=" { return symbol("GTEQ", GTEQ); }
   "<=" { return symbol("LTEQ", LTEQ); }

   "==" { return symbol("EQ", EQ); }
   "!=" { return symbol("NOTEQ", NOTEQ); }

   "=" { return symbol("ASSIGN", ASSIGN); }
   ";" { return symbol("SEMICOL", SEMICOL); }
   "," { return symbol("COMMA", COMMA); }

   /* Keywords */
   "if" {
      if(checkSeparator()){

         return symbol("IF", IF);
      }
   }

   "int"     {
      if(checkSeparator()){

         return symbol("INT", INT);
      }
   }

   "void"    {
      if(checkSeparator()){

         return symbol("VOID", VOID);
      }
   }

   "else"    {
      if(checkSeparator()){

         return symbol("ELSE", ELSE);
      }
   }

   "while"   {
      if(checkSeparator()){

         return symbol("WHILE", WHILE);
      }
   }

   "return"  {
      if(checkSeparator()){

         return symbol("RETURN", RETURN);
      }
   }

   "(" { return symbol("LPAREN", LPAREN); }
   ")" { return symbol("RPAREN", RPAREN); }
   "[" { return symbol("LSQBKT", LSQBKT); }
   "]" { return symbol("RSQBKT", RSQBKT); }
   "{" { return symbol("LBRKT", LBRKT); }
   "}" { return symbol("RBRKTS", RBRKT); }

   <<EOF>>		{ return symbol("EOF", EOF); }
   
   {Comment} {/* Ignore */}
   {Id} {
         if(checkSeparator()){

               return symbol("ID", ID, yytext());
         }
      }

   {Num} {
         if(checkSeparator()){

            return symbol("NUM", NUM, new Integer(Integer.parseInt(yytext())));
         }
      }

   {WhiteSpace} { lastToken = " ";/* Ignore */ }

 }

.|\n { System.out.println("ERROR");error(yytext());}