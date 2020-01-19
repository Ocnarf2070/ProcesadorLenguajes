import java_cup.runtime.*;
%%
//%debug
%cup
%%
(.|\n)+ { return new Symbol(sym.A, yytext() ); }  