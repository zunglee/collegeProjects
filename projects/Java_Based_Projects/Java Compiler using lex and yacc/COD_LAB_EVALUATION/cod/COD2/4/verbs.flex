/*** Definition section ***/
%{
/* C code to be copied verbatim */
#include <stdio.h>
#include <stdlib.h>
%}
/* This tells flex to read only one input file */

%option noyywrap
%%



"is"|"am"|"are"|"were"|"was"|"be"|"being"|"been"|"do"|"does"|"did"|"will"|"would"|"should"|"can"|"could"|"has"|"have"|"had"|"go" printf ("Verb : %s\n", yytext); 

"very"|"simply"|"gently"|"quietly"|"calmly"|"angrily" printf ("Adverb: %s\n", yytext); 

"a"|"an"|"the" printf("article : %s\n", yytext);

"allahabad"|"place" printf("noun : %s\n", yytext);


"good"|"great"|"holy" printf("adjective : %s\n", yytext);

.|\n { /* Ignore all other characters. */ }

%%
/*** C Code section ***/
int main(void)
{
/* Call the lexer, then quit. */
yylex();
return 0;
}




