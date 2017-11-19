/*** Definition section ***/

%{
/* C code to be copied verbatim */
#include <stdio.h>
#include <string.h>
#include <math.h>
%}

/* This tells flex to read only one input file */
%option noyywrap

%%
    /*** Rules section ***/

    /* [0-9]+ matches a string of one or more digits */

-?[0-9]+['.'][0-9]+  {
            /* yytext is a string containing the matched text. */
            printf("Saw a Float: %s\n", yytext);
            double a=0,j=1;
            int len=strlen(yytext),i,pointpos;
            for (i=0;i<len;i++){
            	if (yytext[i]=='.'){
            		pointpos=i;
            		break;
            	}
            }

            for (i=pointpos-1;i>=0;i--){
            	a+=(yytext[i]-'0')*j;
            	j*=10;
            }
            j=0.1;
            for (i = pointpos+1; i < len; ++i){
            	a+=(double)(yytext[i]-'0')*j;
            	j/=10;
            }

            if (a>2000 || a<-2000)
            	printf("OUT OF RANGE\n");
            else 
            	printf("IN RANGE\n");


}

-?[0-9]+  {
            
            printf("Saw an integer: %s\n", yytext);
            int a=0,len=strlen(yytext),j=1,i;
			
			if(yytext[0]=='-')
			{
			for (i=len-1;i>=1;i--){
            	a+=(yytext[i]-'0')*j;
            	j*=10;
            }
			}
			else
			{
				for (i=len-1;i>=0;i--){
					a+=(yytext[i]-'0')*j;
					j*=10;
            }
			}
            
            if (a>1000 || a<-1000)
            	printf("OUT OF RANGE\n");
            else 
            	printf("IN RANGE\n");
        }



.    { printf("Not an integer");    }

%%
/*** C Code section ***/

int conv(char arr)
{

}

int main(void)
{
    /* Call the lexer, then quit. */
    yylex();
    return 0;
}