
%{
#include <stdio.h>
%}

digit [0-9]+
CommentStart     "/*"
id [a-zA-Z][a-zA-Z0-9]*

%%

"int"|"float"|"double"|"long long int" {

printf("Saw an keyword: %s\n", yytext);
}
{digit} {
printf("Saw an digit: %s\n", yytext);
}
{id} {
printf("Saw an identifier: %s\n", yytext);
}
.|\n|"/*"[a-zA-Z][a-zA-Z0-9]*|" "|"+"[a-zA-Z][a-zA-Z0-9]*|"-"[a-zA-Z][a-zA-Z0-9]*|"*"|[>]*[a-zA-Z][a-zA-Z0-9]*|">"*[a-zA-Z][a-zA-Z0-9]*|"*/" 
"+"|"-"|"*"|"/"|"<<"|">>"|";"|","|"#"|"<"|">"|"{"|"}" printf( "An operator or punctuation: %s\n", yytext );



%%
/*** C Code section ***/
int main(void)
{
/* Call the lexer, then quit. */
yylex();
return 0;
}