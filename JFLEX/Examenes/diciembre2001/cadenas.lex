%%
%{
 int p1=0;
 int p2=0;
 int p3=0;
 int t1=0; // total 1
 int t2=0; // total 2
 int t3=0; // total 3
%} 
%%
[01]*1111+[01]*  {}
0*1 	{p1+=yylength()-1;t1++;}
0*11 	{p2+=yylength()-2;t2++;}
0*111 	{p3+=yylength()-3;t3++;}
.|\n {}
