/*** Definition section ***/

%{
/* C code to be copied verbatim */
#include <stdio.h>
%}

/* This tells flex to read only one input file */
%option noyywrap
alphabet [a-z,A-Z]+

num [0-9]+

flt {num}+[.]{num}

id ({alphabet}+[0-9]*)+

relop [< |  > | = ]

term {id}|{num}

expr ({term}{relop}{term})|{term}


stmt ((if)[" "]+{expr}[" "]+(then)[" "]+{expr})

%%
    /*** Rules section ***/

    /* [0-9]+ matches a string of one or more digits */
{stmt}  {
            /* yytext is a string containing the matched text. */
            printf("Saw a stmt: %s\n", yytext);
        }


.|\n    {   /* Ignore all other characters. */   }

%%
/*** C Code section ***/

int main(void)
{
    /* Call the lexer, then quit. */
    yylex();
    return 0;
}
