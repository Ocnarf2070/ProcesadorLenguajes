

%%

%xstate COMENTARIO

%%
<YYINITIAL>[a-z]+  {
                  System.out.print("A");
                  }
[0-9]+            {
                  System.out.print("B");
                  }
.|\n              {
                  System.out.print("C");
                  }
<YYINITIAL> "/*"  {
                  System.out.print("D");
                  yybegin(COMENTARIO);
                  }

<COMENTARIO> {    .|\n  {
                        System.out.print("E");
                        }
                  "*/"  {
                        System.out.print("F");
                        yybegin(YYINITIAL);
                        }
              }
