%%

%%
[a-zA-Z]*[aeiouAEIOU]{2,2}[a-zA-Z]*[aeiouAEIOU]      |
[a-zA-Z]*[aeiouAEIOU]{2,2}                      {return new Yytoken(Yytoken.TOKEN_A,yytext());}
[a-zA-Z]*[aeiouAEIOU]                           {return new Yytoken(Yytoken.TOKEN_B,yytext());}
[a-zA-Z]*[aeiouAEIOU]{2,2}[a-zA-Z]*[bcdfghjklmnpqrstvwxyzBCDFGHIJKLMNPQRSTVWXYZ]  {return new Yytoken(Yytoken.TOKEN_C,yytext());}
[a-zA-Z]+                                  {return new Yytoken(Yytoken.TOKEN_D,yytext());}
.|\n  {}
