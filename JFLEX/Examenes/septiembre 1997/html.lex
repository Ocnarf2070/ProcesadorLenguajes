%%
%x TITLE
%%
"<TITLE>" {yybegin(TITLE);}
<TITLE> {
	"<H1> " {}
	" </H1>" {}
	\n {}
	"&ntilde;" {System.out.print("ñ");}
	&[aeiou]"acute"; { switch(yytext().charAt(1)){
				case 'a' : System.out.print("á");
					break;
				case 'e' : System.out.print("é");
					break;
				case 'i' : System.out.print("í");
					break;
				case 'o' : System.out.print("ó");
					break;
				case 'u' : System.out.print("ú");
					break;
				}
			}
	"</TITLE>" {yybegin(YYINITIAL);}
	. {System.out.print(yytext());}
	}	
.|\n {}
