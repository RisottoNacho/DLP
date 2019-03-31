grammar Pmm;	

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
    import java.lang.String;
    
}

program returns [Program ast]: a=listDefinition m=main EOF
{
	List<Definition> ls = new ArrayList<Definition>();
	ls.addAll($a.ast);
	ls.add($m.ast);
	$ast = new Program(0,0,ls);
}
	;

listDefinition returns [List<Definition> ast = new ArrayList<Definition>()]:
		(a=defVariable
		{
		$ast.addAll($a.ast);
}
		  | b=defFunction
		  {
		$ast.add($b.ast);
})*
	;

       
listDefFunction returns [List<FunctionDefinition> ast = new ArrayList<FunctionDefinition>()]   :
	(d=defFunction
	{$ast.add($d.ast);}
	)*
;

main returns [FunctionDefinition ast]:
{
	List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
	List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
	List<Statement> lsStatement = new ArrayList<Statement>();
}
	'def' id='main' '('(c=listParameter{lsParam.addAll($c.ast);})?')' ':' '{'(a=defVariable{lsVar.addAll($a.ast);})* (b=statement{lsStatement.addAll($b.ast);})* '}'
	
	{
	$ast = new FunctionDefinition($id.getLine(),$id.getCharPositionInLine()+1,$id.text,lsVar,lsStatement,new Function($id.getLine(),$id.getCharPositionInLine()+1,lsParam,null));
	}

	;

expression returns [Expression ast]: 
	'('t=type')' e=expression	{$ast = new Cast($t.start.getLine(),$t.start.getCharPositionInLine()+1,$e.ast,$t.ast);}
|	'('e=expression')'	{$ast = $e.ast; }
|	'!' e=expression	{$ast = new UnaryNot($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	'-' e=expression	{$ast = new UnaryMinus($e.start.getLine(),$e.start.getCharPositionInLine()+1,$e.ast);}
|	e1=expression'['e2=expression']'	{$ast = new ArrayAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
|	e1=expression'.'ID		{$ast = new StructAccess($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$ID.text);}
|	ID'('l=listExpression?')'		{$ast = new FunctionProcedure($ID.getLine(),$ID.getCharPositionInLine()+1,new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text),$l.ast);}
|	e1=expression op=('*'|'/'|'%') e2=expression {$ast = new Arithmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
|	iz = expression op=('+'|'-') de = expression 
{	$ast = new Arithmetic($iz.start.getLine(),$iz.start.getCharPositionInLine()+1,$iz.ast,$op.text,$de.ast);
}
|	e1=expression op=('>'|'<'|'>='|'<='|'=='|'!=') e2=expression	{$ast = new Comparison($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
|	e1=expression (op='&&')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
|	e1=expression (op='||')  e2=expression	{$ast = new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
|	ID {$ast = new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
|	INT_CONSTANT {$ast = new IntLiteral($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
|	CHAR_CONSTANT	{$ast = new CharLiteral($CHAR_CONSTANT.getLine(),$CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar($CHAR_CONSTANT.text));}
|	REAL_CONSTANT	{$ast = new RealLiteral($REAL_CONSTANT.getLine(),$REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal($REAL_CONSTANT.text));}	
	;

listExpression returns [List<Expression> ast = new ArrayList<Expression>()]: e1=expression	{$ast.add($e1.ast);}
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
|{List<Field> ls = new ArrayList<Field>();}		a='struct' '{'(b=field{ls.addAll($b.ast);}';')+'}'	{$ast = new Struct($a.getLine(),$a.getCharPositionInLine()+1, ls);}	
|	'['a=INT_CONSTANT']' t=type		{$ast = new Array($a.getLine(),$a.getCharPositionInLine()+1,LexerHelper.lexemeToInt($a.text), $t.ast);}	
	;
	

defVariable returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	a=ID{
	$ast.add(new VariableDefinition($a.getLine(),$a.getCharPositionInLine()+1,
	$a.text));
	} (','b=ID
	{$ast.add(new VariableDefinition($a.getLine(),$a.getCharPositionInLine()+1,
	$b.text));
	})* ':' t=type ';'
	{
	for(VariableDefinition a : $ast){
		a.setType($t.ast);
	}
}
	;
	
parameter returns[VariableDefinition ast]:
		ID ':' t=type 
	{
		$ast = new VariableDefinition($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);
		$ast.type = $t.ast;
	}
;	

listParameter returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()]:
	p1=parameter{
		$ast.add($p1.ast);
		}(','p2=parameter{
		$ast.add($p2.ast);
		})*
;
	
field returns [List<Field> ast = new ArrayList<Field>()]:
	i1=ID(','i2=ID
		{
			Field f = new Field($i2.getLine(),$i2.getCharPositionInLine()+1,$i2.text);
			if($ast.contains(f)){
				f.setType(new ErrorType($i2.getLine(),$i2.getCharPositionInLine()+1,"Two or more variables with same ID"));
			}
			$ast.add(f);
		}
	)* ':' t=type 
		{
			Field f = new Field($i1.getLine(),$i1.getCharPositionInLine()+1,$i1.text);
				if($ast.contains(f)){
				    f.setType(new ErrorType($i1.getLine(),$i1.getCharPositionInLine()+1,"Two or more variables with same ID"));
			}
			$ast.add(f);
		for(Field fl : $ast)
				if(!$ast.isEmpty() && fl.type == null)
					fl.type = $t.ast;
			
		}
	
	;	
	
fieldList returns [List<Field> ast = new ArrayList()]: 
	(f1=field{
	$ast.addAll($f1.ast);
}
	(','f2=field{
	$ast.addAll($f2.ast);
}
	)*) 
;
	
defFunction returns [FunctionDefinition ast]:
{
	List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
	List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
	List<Statement> lsStatement = new ArrayList<Statement>();
}
	'def' id=ID '('(c=listParameter{lsParam.addAll($c.ast);})?')' ':' t=type '{'(a=defVariable{lsVar.addAll($a.ast);})* (b=statement{lsStatement.addAll($b.ast);})* '}'
	{
	$ast = new FunctionDefinition($id.getLine(),$id.getCharPositionInLine()+1,$id.text,lsVar,lsStatement,new Function($id.getLine(),$id.getCharPositionInLine()+1,lsParam,$t.ast));
	}
|	{
	List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
	List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
	List<Statement> lsStatement = new ArrayList<Statement>();
}
	'def' id=ID '('(c=listParameter{lsParam.addAll($c.ast);})?')' ':' '{'(a=defVariable{lsVar.addAll($a.ast);})* (b=statement{lsStatement.addAll($b.ast);})* '}'
	{
	$ast = new FunctionDefinition($id.getLine(),$id.getCharPositionInLine()+1,$id.text,lsVar,lsStatement,new Function($id.getLine(),$id.getCharPositionInLine()+1,lsParam,null));
	}
	;

listStatement returns [List<Statement> ast = new ArrayList<Statement>()]:
	(s=statement {$ast.addAll($s.ast);})*
	;

statement returns [List<Statement> ast = new ArrayList<Statement>()]:
	e1=expression '=' e2=expression';'	{$ast.add(new Assignment($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast));}
|	v=defVariable';'	{$ast.addAll($v.ast);}
|{List<Expression> ls = new ArrayList<Expression>();}	ID '('(l=listExpression{ls.addAll($l.ast);})*')'';'	{$ast.add(new FunctionCall($ID.getLine(),$ID.getCharPositionInLine()+1,new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text),ls));}
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






