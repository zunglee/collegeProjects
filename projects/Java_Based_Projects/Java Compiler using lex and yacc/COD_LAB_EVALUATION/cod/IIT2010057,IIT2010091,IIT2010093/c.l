alpha [a-zA-Z]
digit [0-9]
%option yylineno
%option noyywrap
%%
[ \t]		;
[ \n]   { yylineno = yylineno + 1;}
int	return INT;
float return FLOAT;
char return CHAR;
String return STRING;
double return DOUBLE;
for 	return FOR;
while	return WHILE;
if	return IF;
else	return ELSE;
struct 	return STRUCT;
public return PUBLIC;
static return STATIC;
System return SYSTEM;
out return OUT;
println return PRINTLN;
void return VOID;
main return MAIN;
new return NEW;
^"#include ".+ ;
{digit}+       return NUM;
{alpha}({alpha}|{digit})* return ID;
"<="    return LE;
">="    return GE;
"=="    return EQ;
"!="    return NE;
">"	return GT;
"<"	return LT;
"."     return DOT;
\/\/.* ;
\/\*(.*\n)*.*\*\/ ;
.       return yytext[0];
%%