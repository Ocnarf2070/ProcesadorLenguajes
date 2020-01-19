%%

%%
([1-9]*[0-9][lL])|(0[0-7]+[lL])|(0x[0-9A-Fa-f]+[lL]) {return new Yytoken(Yytoken.TOKEN_CTE_ENTERO_LARGO,yytext());}
([1-9]*[0-9])|(0[0-7]+)|(0x[0-9A-Fa-f]+) {return new Yytoken(Yytoken.TOKEN_CTE_ENTERO,yytext());}
[0-9]+[dD]|([0-9]+\.[0-9]*|[0-9]*\.[0-9]+)[dD]? {return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO,yytext());}
([0-9]+(\.[0-9]*)?*|[0-9]*(\.[0-9]+)?)E[+-]?[0-9]+[dD]? {return new Yytoken(Yytoken.TOKEN_CTE_REAL_LARGO,yytext());}
([0-9]+|[0-9]+\.[0-9]*|[0-9]*\.[0-9]+)[fF] {return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO,yytext());}
([0-9]+(\.[0-9]*)?*|[0-9]*(\.[0-9]+)?)E[+-]?[0-9]+[fF] {return new Yytoken(Yytoken.TOKEN_CTE_REAL_CORTO,yytext());}
[^\ \n\t\r]+ {return new Yytoken(Yytoken.TOKEN_ERROR,yytext());}
.|\n {}	
