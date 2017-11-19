#include<stdio.h>
int main(int argc,char *argv[])
{
FILE *f;
int flag;
f = fopen("input.txt","r");
while(!feof(f))
{
char ch = fgetc(f),flag = 0;
if(ch == '/')
{
ch = fgetc(f);
if(ch == '*')
{
flag = 1;
while(1)
if(fgetc(f) == '*' && fgetc(f) == '/')
break;
}
else if(ch == '/')
{
flag = 1;
while(fgetc(f)!= '/n');
}
else
printf("/");// if it s division operator
}
if(!flag )
printf("%c",ch);
}
fclose(f);
}
/*
Run d prog as
>./a.out file_name.cpp
*/
