%%
%%
[048]|[0-9]*([02468][048]|[1375][26]) {return INT4;}
[0-9]*[24680] {return INT2NO4;}
[0-9]+ {return INTNO2;}
.|\n ;
