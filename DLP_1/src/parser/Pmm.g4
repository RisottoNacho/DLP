grammar Pmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expresions.*;
    import ast.statements.*;
    import ast.types.*;
}

program returns [Program ast]: a=listDefVariable b=listDefFunction m=main EOF
{
	List<Definition> ls = new ArrayList<Definition>();
	la.addAll($a.ast);
	la.addAll($b.ast);
	ls.add($m.ast);
	$ast = new Program(0,0,ls);
}
       ;
       
listDefFunction returns [List<FunctionDefinition> ast = new ArrayList<FunctionDefinition>())]   :
	(d=defFuncion
	{$ast.add($d.ast);}
	)*
;

main returns [FunctionDefinition ast]:
	'def' id='main' '('c=fieldList?')' ':' '{'a=listDefVariable b=listStament '}'
	{
	$ast = new FunctionDefinition($id.start.getLine(),$id.start.getCharPositionInLine()+1,$id.text,$a.ast,$b.ast,$c.ast);
}
	;

expression returns [Expresion ast]: 
	'('t=type')' e=expression	{ast = new Cast($t.start.getLine(),$t.start.getCharPositionInLine()+1,$e.ast,$t.ast);}
|	'('e=expression')'	{$ast = $e.start.ast; }
|	'!' e=expression	{$ast = new UnaryNot($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	'-' e=expression	{$ast = new UnaryMinus($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	e1=expression'['e2=expression']'	{$ast = new ArrayAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
|	e1=expression'.'e2=expression		{$ast = new StructAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
|	e1=expression op=('*'|'/'|'%') e2=expression {$ast = new Arithmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	iz = expression op=('+'|'-') de = expression 
{	$ast = new Arithmetic($iz.start.getLine(),$iz.start.getCharPositionInLine()+1,$iz.ast,$op.text,$de.ast);
}
|	e1=expression op=('>'|'<'|'>='|'<='|'=='|'!=') e2=expression	{$ast = new Comparison($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	e1=expression op=('&&')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	e1=expression op=('||')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
|	INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
|	CHAR_CONSTANT	{$ast = new CharLiteral($CHAR_CONSTANT.getLine(),$CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
|	REAL_CONSTANT	{$ast = new RealLiteral($REAL_CONSTANT.getLine(),$REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal($REAL_CONSTANT.text));}	
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
	$a.text),t);
	} (','b=ID{$ast.add($a = new VariableDefinition($b.start.getLine(),$b.start.getCharPositionInLine()+1,
	$b),t);
	})* ':' t=type
	;
	
field returns [Field ast]:
	ID ':' t=type {$ast = new Field($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$t.ast);}
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
	'def' ID '('c=fieldList?')' ':' (type '{'a=listDefVariable b=listStatement '}')?
	{
	ast = newFunctionDefinition($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$a.ast,$b.ast,c.ast);
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






