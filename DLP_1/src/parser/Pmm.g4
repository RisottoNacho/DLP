grammar Pmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expresions.*;
    import ast.statements.*;
    import ast.types.*;
}

program: listDefVariable defFuncion* main EOF
       ;
       
       
statement: expression '=' expression ';'
|	'print' expression (',' expression)+ ';'
	;

main:
	'def' 'main' '('(campo(,campo)*)?')' ':' '{'listDefVariable statement* '}'
	;

expression returns [Expresion ast]: 
	'('type')' expression 
|	'('expression')'
|	'!' expression
|	'-' expression
|	expression'['expression']'
|	expression'.'expression
|	expression ('*'|'/'|'%') expression
|	iz = expression op=('+'|'-') de = expression 
{	$ast = new Aritmetic($iz.start.getLine(),$iz.start.getCharPositionInLine()+1,$iz.ast,$op.text,$de.ast);
}
|	expression ('>'|'<'|'>='|'<='|'=='|'!=') expression
|	expression ('||'|'&&')  expression
|	ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
|	INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
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
	
defFuncion returns [FunctionDefinition ast]:
	'def' ID '('(campo(,campo)*)?')' ':' type '{'listDefVariable listStatement '}'
	{
	ast = newFunctionDefinition();
	}
	;

listStament returns [List<Statement> ast = new ArrayList<Statement>()]:
	(s=statement {$as.add($s.ast)})*
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






