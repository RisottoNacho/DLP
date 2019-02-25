grammar Pmm;	

program: listDefVariable defFuncion* main EOF
       ;
       
       
statement: expression '=' expression ';'
|	'print' expression (',' expression)+ ';'
	;

main:
	'def' 'main' '('(campo(,campo)*)?')' ':' type '{'listDefVariable statement* '}'
	;

expression: 
	'('type')' expression 
|	'('expression')'
|	'!' expression
|	'-' expression
|	expression'['expression']'
|	expression'.'expression
|	expression ('*'|'/'|'%') expression
|	expression ('+'|'-') expression
|	expression ('>'|'<'|'>='|'<='|'=='|'!=') expression
|	expression ('||'|'&&')  expression
|	ID
|	INT_CONSTANT
|	CHAR_CONSTANT
|	REAL_CONSTANT
	;

listExpression: expression(,expression)*

variable: ID;

type: 'int'
|	'double'
|	'char'
|	'void'
|	'string'
|	'struct'
|	'['INT_CONSTANT']' type
	;
	
listDefVariable:
	(defVariable ';')*
	;

defVariable:
	ID (,ID)* ':' type
	;
	
campo:
	ID : type
	;	
	
defFuncion:
	'def' ID '('(campo(,campo)*)?')' ':' type '{'listDefVariable statement* '}'
	;

statement:
	expression '=' expression
|	defVariable';'
|	ID '('listExpression?')'
|	'if' expression ':' '{'statement* '}'
|	'if' expression ':' '{'statement* '}' 'else' '{'statement* '}'
|	'while' expression ':' '{'statement* '}'
|	'print' listExpression
|	'input'	listExpression
	;

/*****************************************LEXER***********************************************************/ 

LINE_COMMENT: '#'.*?'\r'?('\n'|EOF) -> skip;
COMMENT: '"""'.*?'"""' -> skip;
WHITESPACE: [ \t\r\n]+ -> skip;

fragment
DIGIT: [0-9];
fragment            
LETTER: [a-zA-Z];
fragment
EXPONENT: [eE][+-]?DIGIT+;

REAL_CONSTANT: DIGIT+(EXPONENT|('.'DIGIT*))|DIGIT+'.'DIGIT+EXPONENT|'.'DIGIT+;		 
INT_CONSTANT: [0-9]+ ;
ID: ('_'|LETTER)(LETTER|DIGIT|'_')*;
CHAR_CONSTANT: ('\''.'\'')|('\'''\\'DIGIT+'\'')|('\'''\\''n''\'')|('\'''\\''t''\'');






