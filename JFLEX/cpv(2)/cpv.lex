%%
%{
  int A;
  int B;
  int C;
  int D;
%}
LETRAS = [a-zA-Z]
VOCALES = [aeiouAEIOU]
CONSONANTES = !({VOCALES}|!{LETRAS})
SIGNOS = [.,;:\ \n\r\t]
%%
{LETRAS}*{VOCALES}{2}({LETRAS}*{VOCALES})? {A++;}
{LETRAS}*{VOCALES} {B++;}
{LETRAS}*{VOCALES}{2}{LETRAS}*{CONSONANTES} {C++;}
{LETRAS}+ {D++;}
.|\n {}
