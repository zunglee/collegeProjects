%{

#include <stdio.h>
#include <stdlib.h>

extern FILE *fp;

int *cut;
%}

%token INT FLOAT CHAR DOUBLE VOID
%token FOR WHILE 
%token IF ELSE PRINTF SCANF COUT CIN
%token STRUCT 
%token NUM ID
%token INCLUDE
%token DOT
%token HF HFF
%token HFC HFFC
%token HD CLASS
%token UNS CM
%token RET LTT RTT OP  
%right '='
%left AND OR 
%left '<' '>' LE GE EQ NE LT GT
%%
start:	Function 
	| Declaration start
	| headerb start
	| header start
	| headerbc { printf("Warning : At Line no. %d \t Header File name has .h extension , may be its of C language \n",(((*cut)+1)/2));} start
	| headerc { printf("Warning : At Line no. %d \t Header File name has .h extension , may be its of C language \n",(((*cut)+1)/2));} start
	| unis start
	| hdf start
	;
hdf: HD 
	;
/* Declaration block */
Declaration: Type Assignment ';'
	| Assignment ';'  	
	| FunctionCall ';' 	
	| ArrayUsage ';'	
	| Type ArrayUsage ';'  
	| StructStmt ';'
	| ClassStmt ';'
	| error ';'
	;
header: HF 
	;
headerb: HFF 
	;
headerc: HFC 
	;
headerbc: HFFC 
	;
reut: RET
	;
unis: UNS ';'
	;
/* Assignment block */
Assignment: ID '=' Assignment
	| ID '=' FunctionCall
	| ID '=' ArrayUsage
	| ArrayUsage '=' Assignment
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

/* Array Usage */
ArrayUsage : ID'['Assignment']'
	;

/* Function block */
Function: Type ID '(' ArgListOpt ')' CompoundStmt 
	;
ArgListOpt: ArgList
	|
	;
ArgList:  ArgList ',' Arg
	| Arg
	;
Arg:	Type ID
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
	| reut
	| ';'
	;

/* Type Identifier block */
Type:	INT
	| FLOAT
	| CHAR
	| DOUBLE
	| VOID 
	;

/* Loop Blocks */ 
WhileStmt: WHILE '(' Expr ')' Stmt  
	| WHILE '(' Expr ')' CompoundStmt 
	;

/* For Block */
ForStmt: FOR '(' Expr ';' Expr ';' Expr ')' Stmt 
       | FOR '(' Expr ';' Expr ';' Expr ')' CompoundStmt 
       | FOR '(' Expr ')' Stmt 
       | FOR '(' Expr ')' CompoundStmt 
	;

/* IfStmt Block */
IfStmt : IF '(' Expr ')' Stmt 
		| IF '(' Expr ')' CompoundStmt 
	;

sb: Declaration sb
	| 
	;
/* Struct Statement */
StructStmt : STRUCT ID '{' sb '}'  { printf("Warning : At Line no. %d \t Struct used , which is of C language \n",(((*cut)+1)/2));}
	;

cb:  Function cb
	| Declaration cb 
	|	
	;
ClassStmt : CLASS ID '{' cb '}'
    ;
	
rul: LTT Expr rul
	| LTT CM ID CM rul
	|
	;
var: RTT ID var
	|
	;
/* Print Function */
PrintFunc : PRINTF { printf("Error : At Line no. %d \t Printf used , which is of C language \n",(((*cut)+1)/2));}
	|       SCANF { printf("Error : At Line no. %d \t Scanf used , which is of C language \n",(((*cut)+1)/2));}
	|		CIN var ';'
	|		COUT rul ';' 
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
	| ArrayUsage
	;
%%
#include"lex.yy.c"
#include<ctype.h>
int count=0;

int main(int argc, char *argv[])
{
	yyin = fopen("test.txt", "r");
     cut=&yylineno;
   if(!yyparse())
		printf("\nParsing complete\n");
	else
		printf("\nParsing failed\n");

	fclose(yyin);
    return 0;
}
         
yyerror(char *s) {
    
	 
	printf("You got error at line no. %d : %s %s\n", (yylineno+1)/2, s, yytext );
}     