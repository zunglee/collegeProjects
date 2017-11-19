%
#include<stdio.h>
%
%%
(id) [0-9]+

{id} {printf("Yepii");}
%%

int main()
{
yylex();
return 0;

}