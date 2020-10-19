package jflex;

import java_cup.runtime.Symbol;
%%

%unicode
%class Lexer
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

private Symbol symbol(int sym) {
    lastToken = yytext();

    return new Symbol(sym, yyline+1, yycolumn+1);
}

private Symbol symbol(int sym, Object val) {
   lastToken = yytext();

   return new Symbol(sym, yyline+1, yycolumn+1, val);
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
   "-" { return symbol(SUB);}
   "+" { return symbol(ADD); }
   "*" { return symbol(MULT); }
   "/" { return symbol(DIV); }

   "<" { return symbol(LT); }
   ">" { return symbol(GT); }
   ">=" { return symbol(GTEQ); }
   "<=" { return symbol(LTEQ); }

   "==" { return symbol(EQ); }
   "!=" { return symbol(NOTEQ); }

   "!" { return symbol(NOT); }
   "=" { return symbol(ASSIGN); }
   ";" { return symbol(SEMICOL); }
   "," { return symbol(COMMA); }

   /* Keywords */
   "if" {
      if(checkSeparator()){

         return symbol(IF);
      }
   }

   "int"     {
      if(checkSeparator()){

         return symbol(INT);
      }
   }

   "void"    {
      if(checkSeparator()){

         return symbol(VOID);
      }
   }

   "else"    {
      if(checkSeparator()){

         return symbol(ELSE);
      }
   }

   "while"   {
      if(checkSeparator()){

         return symbol(WHILE);
      }
   }

   "return"  {
      if(checkSeparator()){

         return symbol(RETURN);
      }
   }

   "(" { return symbol(LPAREN); }
   ")" { return symbol(RPAREN); }
   "[" { return symbol(LSQBKT); }
   "]" { return symbol(RSQBKT); }
   "{" { return symbol(LBRKT); }
   "}" { return symbol(RBRKT); }

   {Comment} {/* Ignore */}
   {Id} {
         if(checkSeparator()){

               return symbol(ID, yytext());
         }
      }

   {Num} {
         if(checkSeparator()){

            return symbol(NUM, new Integer(Integer.parseInt(yytext())));
         }
      }

   {WhiteSpace} { lastToken = " ";/* Ignore */ }

 }

.|\n { System.out.println("ERROR");error(yytext());}