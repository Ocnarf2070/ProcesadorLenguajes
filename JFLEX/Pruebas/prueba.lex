import java.io.*;
%%
%states A, B
%xstates C
%%
<YYINITIAL> ab/cd	{ yybegin(A); System.out.print("/AB"); }
<YYINITIAL, A> (.|\n)	{ System.out.print(yytext()); }
<A> {
  ba			{ System.out.print("BA"); }
  <B,C> ab/cd           { System.out.print("/BC"); yybegin(C);}
}
<C> {
  d/ab			{System.out.print("/D"); yybegin(YYINITIAL);}
  .{2}			{String var = yytext().toUpperCase();System.out.print(var);}
}
