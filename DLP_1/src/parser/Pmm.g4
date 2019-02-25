grammar Pmm;	

program: statement+ EOF
       ;
       
       
statement: expression '=' expression ';'
|	'print' expression (',' expression)+ ';'
	;
	
expression: 
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

variable: ID;





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






