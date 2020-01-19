
%%
%%
ab+	{ System.out.print( yytext()+"-" ); }
[a+b]+	{ System.out.print( yytext()+"-" ); }
(ab)+	{ System.out.print( yytext()+"-" ); }
.|\n	{}
