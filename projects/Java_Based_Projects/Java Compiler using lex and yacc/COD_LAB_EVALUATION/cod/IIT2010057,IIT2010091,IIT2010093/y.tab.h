
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     INT = 258,
     FLOAT = 259,
     CHAR = 260,
     DOUBLE = 261,
     VOID = 262,
     STRING = 263,
     FOR = 264,
     WHILE = 265,
     IF = 266,
     ELSE = 267,
     PRINTF = 268,
     STRUCT = 269,
     NUM = 270,
     ID = 271,
     INCLUDE = 272,
     DOT = 273,
     PUBLIC = 274,
     STATIC = 275,
     MAIN = 276,
     SYSTEM = 277,
     OUT = 278,
     PRINTLN = 279,
     NEW = 280,
     OR = 281,
     AND = 282,
     GT = 283,
     LT = 284,
     NE = 285,
     EQ = 286,
     GE = 287,
     LE = 288
   };
#endif
/* Tokens.  */
#define INT 258
#define FLOAT 259
#define CHAR 260
#define DOUBLE 261
#define VOID 262
#define STRING 263
#define FOR 264
#define WHILE 265
#define IF 266
#define ELSE 267
#define PRINTF 268
#define STRUCT 269
#define NUM 270
#define ID 271
#define INCLUDE 272
#define DOT 273
#define PUBLIC 274
#define STATIC 275
#define MAIN 276
#define SYSTEM 277
#define OUT 278
#define PRINTLN 279
#define NEW 280
#define OR 281
#define AND 282
#define GT 283
#define LT 284
#define NE 285
#define EQ 286
#define GE 287
#define LE 288




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


