alpha [a-zA-Z]
digit [0-9]
%option yylineno
%option noyywrap
%%
[ \t]		;
[ \n]  { yylineno = yylineno + 1;} 
int	return INT;
float return FLOAT;
char return CHAR;
void return VOID;
double return DOUBLE;
for 	return FOR;
while	return WHILE;
if	return IF;
else	return ELSE;
"printf"(" ")*\((.)*\)";" return PRINTF;
"scanf"(" ")*\((.)*\)";" return SCANF;
"cout" return COUT;
"cin" return CIN;
struct 	return STRUCT;
class return CLASS;
"#"(" ")*"define"(" ")+[A-Z,a-z]+(" ")+([0-9])+ return HD;
"#"(" ")*"include"(" ")*(\")(.+)("\.h")(" ")*(\") return HFC ;
"#"(" ")*"include"(" ")*("<")(.+)("\.h")(" ")*(">") return HFFC ;
"#"(" ")*"include"(" ")*(\")(.+)(\") return HF ;
"#"(" ")*"include"(" ")*("<")(.+)(">") return HFF ;
"using"(" ")*"namespace "([a-z,A-Z,0-9])* return UNS;
"return"(" ")*([a-z,A-Z,0-9])*(" ")* return RET;
{digit}+       return NUM;
{alpha}({alpha}|{digit})* return ID;
"<<" return LTT;
">>" return RTT;
(\") return CM;
"<="    return LE;
">="    return GE;
"=="    return EQ;
"!="    return NE;
">"	return GT;
"<"	return LT;
"."     return DOT;
"&&"  return OP;
\/\/.* ;
\/\*(.*\n)*.*\*\/ ;
.       return yytext[0];
%%
