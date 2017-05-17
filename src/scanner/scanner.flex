package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z][a-zA-Z0-9]*
NUMERAL = [0-9]+
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" [^"\n"]* "\n" 
Comment = {TraditionalComment} | {EndOfLineComment}

%%

// discard whitespace information
{Comment}     { }
{WhiteSpace}  { }

// token definition
"!="		{ return sym(Terminals.NOEQ); }
"<"		{ return sym(Terminals.LE); }
">"		{ return sym(Terminals.GR); }
">="		{ return sym(Terminals.GREQ);}
"<="		{ return sym(Terminals.LEEQ);}
"=="		{ return sym(Terminals.EQEQ);}
"/"		{ return sym(Terminals.DIV); }
"*"		{ return sym(Terminals.MUL); }
"%"		{ return sym(Terminals.MOD); }
"-"		{ return sym(Terminals.SUB); }
"+"		{ return sym(Terminals.ADD); }
"while"		{ return sym(Terminals.WHILE); }
"="		{ return sym(Terminals.EQ); }
"else"		{ return sym(Terminals.ELSE); }
"if"		{ return sym(Terminals.IF); }
"return"	{ return sym(Terminals.RETURN); }
","		{ return sym(Terminals.COMMA); }
";"		{ return sym(Terminals.SEMICOLON); }
"int"		{ return sym(Terminals.INT); }
"("		{ return sym(Terminals.LPAREN); }
")"		{ return sym(Terminals.RPAREN); }
"{"		{ return sym(Terminals.LCURLY); }
"}"		{ return sym(Terminals.RCURLY); }
{ID}	        { return sym(Terminals.ID); }
{NUMERAL}	{ return sym(Terminals.NUMERAL); }
<<EOF>> 	{ return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
