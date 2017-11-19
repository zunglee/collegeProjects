%{
#include <stdio.h>
#include <stdlib.h>

extern FILE *fp;

%}

%token INT FLOAT CHAR DOUBLE VOID STRING
%token FOR WHILE 
%token IF ELSE PRINTF 
%token STRUCT 
%token NUM ID
%token INCLUDE
%token DOT
%token PUBLIC
%token STATIC
%token MAIN
%token SYSTEM
%token OUT
%token PRINTLN
%token NEW
%right '='
%left AND OR
%left '<' '>' LE GE EQ NE LT GT
%%

start:	 MainFunc 
	| Declaration
	;

/* Declaration block */
Declaration: Type Assignment ';'
	| Type '[' ']' ID hello ';'
	| Assignment ';'  	
	| FunctionCall ';' 		
	| StructStmt ';'	
	;

hello : '=' NEW Type'[' NUM ']' 
	 |
/* Assignment block */
Assignment: ID '=' Assignment
	| ID '=' FunctionCall
	| ID ',' Assignment
	| NUM ',' Assignment
	| ID '+' Assignment
	| ID '-' Assignment
	| ID '*' Assignment
	| ID '/' Assignment	
	| NUM '+' Assignment
	| NUM '-' Assignment
	| NUM '*' Assignment
	| NUM '/' Assignment
	| '\'' Assignment '\''	
	| '(' Assignment ')'
	| '-' '(' Assignment ')'
	| '-' NUM
	| '-' ID
	|   NUM
	|   ID	
	;

/* Function Call Block */
FunctionCall : ID'('')'
	| ID'('Assignment')'
	;


MainFunc: MainFunction
		;
/* Function block */
MainFunction: PUBLIC STATIC VOID MAIN '(' ArgListOpt ')' CompoundStmt  Function
		| VOID MAIN '(' ArgListOpt ')' CompoundStmt 
		| STATIC VOID MAIN '(' ArgListOpt ')' CompoundStmt
		| PUBLIC VOID MAIN '(' ArgListOpt ')' CompoundStmt 
	;
	
/* Function block */
Function: PUBLIC STATIC Type ID '(' ArgListOpt ')' CompoundStmt   Function
		| Type ID '(' ArgListOpt ')' CompoundStmt 
		| STATIC Type ID '(' ArgListOpt ')' CompoundStmt
		| PUBLIC Type ID '(' ArgListOpt ')' CompoundStmt 
		|

	;	
	

ArgListOpt: ArgList
	|
	;
ArgList:  ArgList ',' Arg
	| Arg
	;
Arg:	Type Ang
	;

Ang: ID| '['']'ID 
	;
CompoundStmt:	'{' StmtList '}'
	;
StmtList:	StmtList Stmt
	|
	;
Stmt:	WhileStmt
	| Declaration
	| ForStmt
	| IfStmt
	| PrintFunc
	| ';'
	;

/* Type Identifier block */
Type:	INT 
	| FLOAT
	| CHAR
	| DOUBLE
	| VOID 
	| STRING
	;

/* Loop Blocks */ 
WhileStmt: WHILE '(' Expr ')' Stmt  
	| WHILE '(' Expr ')' CompoundStmt 
	;

/* For Block */
ForStmt: FOR '(' Expr ';' Expr ';' Expr ')' Stmt 
       | FOR '(' Expr ';' Expr ';' Expr ')' CompoundStmt 
	   |FOR '(' Type Expr ';' Expr ';' Expr ')' Stmt 
       | FOR '(' Type Expr ';' Expr ';' Expr ')' CompoundStmt
       | FOR '(' Expr ')' Stmt 
       | FOR '(' Expr ')' CompoundStmt 
	;

/* IfStmt Block */
IfStmt : IF '(' Expr ')' Stmt 
		| IF '(' Expr ')' CompoundStmt
	;

/* Struct Statement */
StructStmt : STRUCT ID '{' Type Assignment '}'  
	;


/* Print Function */
PrintFunc : SYSTEM DOT OUT DOT PRINTLN '(' '"' ID '"' PrintFun ')' ';' | SYSTEM DOT OUT DOT PRINTLN '(' '"' NUM '"' PrintFun ')'  ';' | SYSTEM DOT OUT DOT PRINTLN '(' NUM PrintFun ')' ';'|SYSTEM DOT OUT DOT PRINTLN '(' ID PrintFun ')' ';'
	;
PrintFun : '+'Prin
		|
		;

Prin : '"' ID '"' PrintFun | ID PrintFun |'"' NUM '"' PrintFun | NUM PrintFun 
		;

/*Expression Block*/
Expr:	
	| Expr LE Expr 
	| Expr GE Expr
	| Expr NE Expr
	| Expr EQ Expr
	| Expr GT Expr
	| Expr LT Expr
	| Assignment
	;
%%
#include"lex.yy.c"
#include<ctype.h>
int count=0;

int main(int argc, char *argv[])
{
	yyin = fopen("test.java", "r");

   if(!yyparse())
		printf("\nParsing complete\n");
	else
		printf("\nParsing failed\n");

	fclose(yyin);
    return 0;
}
         
yyerror(char *s) {
	printf("%d : %s %s\n", yylineno, s, yytext );
}         