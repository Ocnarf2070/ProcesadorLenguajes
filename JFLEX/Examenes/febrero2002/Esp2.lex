%%
%%
[Aa](.|\n)*/[Oo] {System.out.print(yytext().substring(1));}
\n {System.out.println();}
. {}
