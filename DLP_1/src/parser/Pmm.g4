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
	'def' id='main' '('c=fieldList?')' ':' '{'a=listDefVariable b=listStatement '}'
	{
	$ast = new FunctionDefinition($c.start.getLine(),$c.start.getCharPositionInLine()+1,$id.text,$a.ast,$b.ast,$c.ast);
}
	;

expression returns [Expresion ast]: 
	'('t=type')' e=expression	{ast = new Cast($t.start.getLine(),$t.start.getCharPositionInLine()+1,$e.ast,$t.ast);}
|	'('e=expression')'	{$ast = $e.start.ast; }
|	'!' e=expression	{$ast = new UnaryNot($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	'-' e=expression	{$ast = new UnaryMinus($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	e1=expression'['e2=expression']'	{$ast = new ArrayAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
|	e1=expression'.'e2=expression		{$ast = new StructAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
|	ID'('l=listExpression?')'		{$ast = new FunctionCall($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$l.ast);}
|	e1=expression op=('*'|'/'|'%') e2=expression {$ast = new Arithmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	iz = expression op=('+'|'-') de = expression 
{	$ast = new Arithmetic($iz.start.getLine(),$iz.start.getCharPositionInLine()+1,$iz.ast,$op.text,$de.ast);
}
|	e1=expression op=('>'|'<'|'>='|'<='|'=='|'!=') e2=expression	{$ast = new Comparison($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	e1=expression (op='&&')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	e1=expression (op='||')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op,$e2.ast);}
|	ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
|	INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
|	CHAR_CONSTANT	{$ast = new CharLiteral($CHAR_CONSTANT.getLine(),$CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
|	REAL_CONSTANT	{$ast = new RealLiteral($REAL_CONSTANT.getLine(),$REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal($REAL_CONSTANT.text));}	
	;

listExpression returns [List<Expresion> ast = new ArrayList<Expresion>]: e1=expression	{$ast.add($e1.ast);}
(','e2=expression{$ast.add($e2.ast);})*;

/**
variable returns[Variable ast]: ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,
	$ID
);};
**/

type returns [Type ast]: 
	a='int'		{$ast = new Int($a.getLine(),$a.getCharPositionInLine()+1);}
|	a='double'	{$ast = new Real($a.getLine(),$a.getCharPositionInLine()+1);}
|	a='char'		{$ast = new Char($a.getLine(),$a.getCharPositionInLine()+1);}
|	a='string'	{$ast = new String($a.getLine(),$a.getCharPositionInLine()+1);}
|	a='struct' '{'b=fieldList'}'	{$ast = new Struct($a.getLine(),$a.getCharPositionInLine()+1, $b.ast);}	
|	'['a=INT_CONSTANT']' t=type		{$ast = new Array($a.getLine(),$a.getCharPositionInLine()+1,LexerHelper.lexemeToInt($a.text), $t.ast);}	
	;
	
listDefVariable returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	(v=defVariable {$ast.addAll($v.ast);} ';')*
	;

defVariable returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	a=ID{
	$ast.add($a = new VariableDefinition($a.getLine(),$a.getCharPositionInLine()+1,
	$a.text,$t.ast));
	} (','b=ID{$ast.add($a = new VariableDefinition($a.getLine(),$a.getCharPositionInLine()+1,
	$b,$t.ast));
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
	'def' ID '('c=fieldList?')' ':' t=type '{'a=listDefVariable b=listStatement '}'
	{
	$ast = newFunctionDefinition($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$c.ast,$a.ast,$b.ast,new Function($a.start.getLine(),$a.start.getCharPositionInLine()+1,$t.ast));
	}
|	'def' ID '('c=fieldList?')' ':' '{'a=listDefVariable b=listStatement '}'
	{
	$ast = newFunctionDefinition($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$c.ast,$a.ast,$b.ast,new Function($a.start.getLine(),$a.start.getCharPositionInLine()+1,null));
	}
	;

listStatement returns [List<Statement> ast = new ArrayList<Statement>()]:
	(s=statement {$ast.addAll($s.ast)})*
	;

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
	e1=expression '=' e2=expression';'	{$ast.add(new Assignment($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast));}
|	v=defVariable';'	{$ast.addAll($v.ast);}
|	ID '('l=listExpression?')'';'	{$ast.add(new FunctionCall($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,$l.ast));}
|	'if' a=expression ':' '{'l1=listStatement '}'	{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l1.ast,null));}
|	'if' a=expression ':' l2=statement		{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l2.ast,null));}
|	'if' a=expression ':' ('{'l3=listStatement '}') 'else'( '{'s=listStatement '}')	{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l3.ast,$s.ast));}
|	'if' a=expression ':' ('{'l5=listStatement '}') 'else'(s1=statement)	{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l5.ast,$s1.ast));}
|	'if' a=expression ':' (l6=statement) 'else'( '{'s2=listStatement '}')	{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l6.ast,$s2.ast));}
|	'if' a=expression ':' (l7=statement) 'else'(s3=statement)	{$ast.add(new IfElse($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l7.ast,$s3.ast));}
|	'while' a=expression ':' '{'l4=listStatement'}'	{$ast.add(new While($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast,$l4.ast));}
|	'print' a2=listExpression';'	{$ast.add(new Print($a2.start.getLine(),$a2.start.getCharPositionInLine()+1,$a2.ast));}
|	'input'	a3=listExpression';'	{$ast.add(new Input($a3.start.getLine(),$a3.start.getCharPositionInLine()+1,$a3.ast));}
|	'return' a=expression';'	{$ast.add(new Return($a.start.getLine(),$a.start.getCharPositionInLine()+1,$a.ast));}
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






