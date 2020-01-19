import java_cup.runtime.*;
%%
%cup
%%
"int"	{ return new Symbol(sym.INT); }
"if"	{ return new Symbol(sym.IF); }
"else"	{ return new Symbol(sym.ELSE); }
"while"	{ return new Symbol(sym.WHILE); }
"do"	{ return new Symbol(sym.DO); }
"for"	{ return new Symbol(sym.FOR); }
"to"	{ return new Symbol(sym.TO); }
"downto" { return new Symbol(sym.DOWNTO); }
"step"	{ return new Symbol(sym.STEP); }
"print" { return new Symbol(sym.PRINT); }
\,		{ return new Symbol(sym.COMA); }
"++"	{ return new Symbol(sym.DMAS); }
"--"	{ return new Symbol(sym.DMENOS); }
\+    	{ return new Symbol(sym.MAS); }
\%		{ return new Symbol(sym.MOD); }
\-      { return new Symbol(sym.MENOS); }
\*      { return new Symbol(sym.POR); }
\/      { return new Symbol(sym.DIV); }
\(      { return new Symbol(sym.AP); }
\)      { return new Symbol(sym.CP); }
\}		{ return new Symbol(sym.CL); }
\{		{ return new Symbol(sym.AL); }
"=="	{ return new Symbol(sym.EQ); }
\=		{ return new Symbol(sym.IGUAL); }
"!="	{ return new Symbol(sym.NEQ); }
\!		{ return new Symbol(sym.NOT); }
"<="	{ return new Symbol(sym.LE); }
">="	{ return new Symbol(sym.GE); }
\<		{ return new Symbol(sym.LT); }
\>		{ return new Symbol(sym.GT); }
"&&"	{ return new Symbol(sym.AND); }
"||"	{ return new Symbol(sym.OR); }
\;   	{ return new Symbol(sym.PYC); }

"$t"(0|[1-9][0-9]*) { return new Symbol(sym.error); }
0|[1-9][0-9]*	{ return new Symbol(sym.ENTERO, yytext() ); }

[a-zA-Z][a-zA-Z0-9]* { return new Symbol(sym.IDENT, yytext() ); }
.|\n						{  }   