%%
//%debug
%int
%{
	String variable="";
	String valor="";
	boolean seen = false;
	TablaSimbolos tb = new TablaSimbolos();
%}
%x ASIG
%x VAL
%x SYSO
VAR = [a-zA-Z_][a-zA-Z0-9_]*
%%
"class".*/\  {System.out.print(yytext()+"_rmj");}
"String ".+"[]) {" {System.out.print(yytext());}
"String" {yybegin(ASIG);}
"System.out.print"("ln")?[\ \t]*\( {System.out.print(yytext());yybegin(SYSO);}
{VAR}/[\ \t]*= {variable=yytext();yybegin(ASIG);}
.|\n {System.out.print(yytext());}
<ASIG> {
	{VAR}/[\ \t]*= {variable=yytext();}
	= {yybegin(VAL);}
	.|\n {}
}
<VAL>{
	{VAR} {if(!seen)valor+=tb.get(yytext());else valor+=tb.get(yytext()).substring(1);}
	(\")?[\ \t]*\+ {seen=true;}
	\"[^\"+;]*/\" {if(!seen)valor+=yytext();
			else valor+=yytext().substring(1);}
	\"[\ \t]*; {tb.put(variable,valor);
			variable=""; valor=""; seen=false; 
			yybegin(YYINITIAL);}
	\; {tb.put(variable,valor);
			variable=""; valor=""; seen=false; 
			yybegin(YYINITIAL);}
	.|\n {}
}	
<SYSO>{
	{VAR} {System.out.print(tb.get(yytext()));}
	\"[\ \t]*\+ {seen=true;}
	\"[^\"+]*/\" {if(!seen)System.out.print(yytext());
			else System.out.print(yytext().substring(1));}
	(\")?[\ \t]*\); {System.out.print("\");");seen=false;yybegin(YYINITIAL);}
	.|\n {System.out.print(yytext());}
}