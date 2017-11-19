/*** Definition section ***/

%{
/* C code to be copied verbatim */
#include <stdio.h>
#include <string.h>
%}

/* This tells flex to read only one input file */
%option noyywrap

%%

[0-9]+ {
	int len,i,a=0;
	len=strlen(yytext);
	if(len==4)
	{
		for(i=0;i<len;i++)
		{
			a=a*10+(yytext[i]-'0');
		}
		if(a%5==0)
		printf("Divisible by 5 : %d\n", a);
		else
		printf("Not Divisible by 5\n");
	}
	else
	printf("Not Saw\n");
}

%%
/*** C Code section ***/

int main(void)
{
    yylex();
    return 0;
}