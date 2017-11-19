/*** Definition section ***/
%{
/* C code to be copied verbatim */
#include <stdio.h>
%}
/* This tells flex to read only one input file */
digit [0-1]+
digit2 [0-9]+
id [a-z][a-z0-9]*
%option noyywrap
%%

{digit} {
printf("Accepted %s\n", yytext);
}
{digit2} {
printf("Not Accepted %s\n", yytext);
}
{id} {
printf("Saw an identifier: %s\n", yytext);
}
"," printf( "An comma: %s\n", yytext );
"+"|"-"|"*"|"/"|"<<"|">>"|";"|"#"|"<"|">"|"{"|"}" printf( "An operator or punctuation: %s\n", yytext );


.|\n { /* Ignore all other characters. */ }
%%
/*** C Code section ***/
int main(void)
{
/* Call the lexer, then quit. */
yylex();
return 0;
}