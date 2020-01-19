
%%


%%
\n|\$ {return new Yytoken(Yytoken.LINEA,"l");}
[^\n\ \t]+ {return new Yytoken(Yytoken.PALABRA,yytext());}
. {return new Yytoken(Yytoken.SEPARADOR,"s");}
