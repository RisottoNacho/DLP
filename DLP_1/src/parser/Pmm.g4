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
       
       

main:
	'def' 'main' '('fieldList?')' ':' '{'listDefVariable statement* '}'
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

listExpression: expression(','expression)*;

/**
variable returns[Variable ast]: ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,
	$ID
);};
**/

type: 'int'
|	'double'
|	'char'
|	
|	'string'
|	'struct' '{'fieldList'}'
|	'['INT_CONSTANT']' type
	;
	
listDefVariable returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	(v=defVariable {$ast.addAll($v.ast);} ';')*
	;

defVariable returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	a=ID{
	$ast.add($a = new VariableDefinition($a.getLine(),$a.getCharPositionInLine()+1,
	$a),t);
	} (','b=ID{$ast.add($a = new VariableDefinition($b.getLine(),$b.getCharPositionInLine()+1,
	$b),t);
	})* ':' t=type
	;
	
field returns [Field ast]:
	ID ':' t=type {$ast = new Field($ID.getLine(),$ID.getCharPositionInLine()+1,$ID,$t.ast);}
	;	
	
fieldList returns [List<Field> ast = new ArrayList()]: 
	(f1=field{
	$ast.add($f1.ast);
}
	(','f2=field{
	$ast.add($f2.ast);
}
	)*) 
;
	
defFuncion returns [FunctionDefinition ast]:
	'def' ID '('fieldList?')' ':' (type '{'a=listDefVariable b=listStatement '}')?
	{
	ast = newFunctionDefinition($a.start.getLine(),$a.start.getCharPositionInLine()+1,$ID,);
	} // SEGUIR AQUI FINALIZAR CREACION DEFINICION FUNCION
	;

listStament returns [List<Statement> ast = new ArrayList<Statement>()]:
	(s=statement {$ast.add($s.ast)})*
	;

statement:
	expression '=' expression
|	defVariable';'
|	ID '('listExpression?')'
|	'if' expression ':' '{'statement* '}'
|	'if' expression ':' statement
|	'if' expression ':' ('{'statement* '}'| statement) 'else'( '{'statement* '}'| statement)
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






