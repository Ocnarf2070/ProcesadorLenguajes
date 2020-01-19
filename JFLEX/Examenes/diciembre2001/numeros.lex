%%
%%
([1-9]{2})*[1-9][0248]	{System.out.print("CLASE ñA "+yytext()+" ");}
([1-9]{2})*[0248]	{System.out.print("CLASE B "+yytext()+" ");}
([1-9]{2})+		{System.out.print("CLASE C "+yytext()+" ");}
[1-9]+			{System.out.print("CLASE D "+yytext()+" ");}
[0-9]+			{}
\n			{System.out.println();}
. 			{}
