grammar Pmm;

@header{
    import ast.*;
    import ast.definitions.*;
    import ast.expresions.*;
    import ast.sentences.*;
    import ast.types.*;
}

program returns [Program ast]:
        vars=listDefVariable {List<FuncDef> lista =new ArrayList<FuncDef>();} (func=defFuncion{lista.add($func.ast);})* main  {lista.add($main.ast);}EOF   { $ast =new Program($vars.ast,lista);}
       ;
       
listDefVariable returns [List<VarDefinition> ast]:
        {$ast = new ArrayList<VarDefinition>();}(def=defVariable{$ast.add($def.ast);}';')*
		;

defVariable returns [VarDefinition ast]:
        id1=ID (','id2=ID)* ':'  tipo=type {$ast=new VarDefinition($id1.getLine(),$id1.getCharPositionInLine()+1,$tipo.ast,$id1.text);}
		;

		
type    returns [Type ast]:
        'int'               { $ast =new IntType();}
        | 'double'          { $ast =new RealType();}
        | 'char'            { $ast =new CharType();}
        |                   { $ast =new VoidType();}
        | 'string'            { $ast =new StringType();}
        |'struct''{'camps=listCampos'}'  { $ast =new StructType($camps.start.getLine(),$camps.start.getCharPositionInLine()+1,$camps.ast);}
        |'['INT_CONSTANT']' tipo=type        { $ast =new VectorType($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,$tipo.ast,LexerHelper.lexemeToInt($INT_CONSTANT.text));}
		;
listCampos returns [List<Campo> ast]:
        {$ast = new ArrayList<Campo>();}(def=defCampo{$ast.add($def.ast);}';')*
        ;
defCampo returns [Campo ast]:
        id=ID ':'  tipo=type {$ast=new Campo($id.getLine(),$id.getCharPositionInLine()+1,$id.text,$tipo.ast);}
        ;

main returns [FuncDef ast]:
        'def' 'main' {List<VarDefinition> vars =new ArrayList<VarDefinition>();}
        '(' (def1=defVariable{vars.add($def1.ast);} (','def2=defVariable{vars.add($def2.ast);} )*)?
         ')'':'type'{'{List<Sentence> sentences =new ArrayList<Sentence>();}
         (s1=statement {sentences.add($s1.ast);})* '}'              {$ast=new FuncDef($type.start.getLine(),$type.start.getCharPositionInLine()+1,"main",vars,sentences,$type.ast);}
       ;

defFuncion returns [FuncDef ast]:
        'def' ID {List<VarDefinition> vars =new ArrayList<VarDefinition>();}
        '(' (def1=defVariable{vars.add($def1.ast);} (','def2=defVariable{vars.add($def2.ast);} )*)?
         ')'':'type'{'{List<Sentence> sentences =new ArrayList<Sentence>();}
         (s1=statement {sentences.add($s1.ast);})* '}'              {$ast=new FuncDef($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text,vars,sentences,$type.ast);}
       ;
       
expression returns [Expresion ast]:
            '(' expression ')'                                                    { $ast=$expression.ast;}
			|e1=expression'.'ID                                                   { $ast =new StructAccess($ID.getLine(),$ID.getCharPositionInLine()+1,$e1.ast,$ID.text);}
			|v=expression'['n=expression']'                                   { $ast =new ArrayAccess($v.start.getLine(),$v.start.getCharPositionInLine()+1,$v.ast,$n.ast);}
			|'('tipo=type')' expression                                         { $ast =new Cast($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$tipo.ast,$expression.ast);}
			|variable '(' {List<Expresion> expressions=new ArrayList<Expresion>();} (e1=expression{expressions.add($e1.ast);} (','e2=expression{expressions.add($e2.ast);} )*)? ')'                       {$ast = new CallFuncExpr($variable.start.getLine(),$variable.start.getCharPositionInLine()+1,$variable.ast,expressions);}
			|'-'expression                                                   { $ast =new Unary($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast);}
			|'!'expression                                                  { $ast =new Not($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast);}
			|e1=expression op=('*'|'/'|'%') e2=expression                               { $ast =new Aritmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
			|e1=expression op=('+'|'-') e2=expression                        { $ast =new Aritmetic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
		   	|e1=expression op=('>'|'<'|'>='|'<='|'=='|'!=') e2=expression              { $ast =new Comparation($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
		  	|e1=expression op=('||'|'&&') e2=expression	   	                          { $ast =new Logic($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$op.text,$e2.ast);}
		   	|variable                                                        { $ast =$variable.ast;}
		   	|CHAR_CONSTANT                                            { $ast =new Char($CHAR_CONSTANT.getLine(),$CHAR_CONSTANT.getCharPositionInLine()+1,$CHAR_CONSTANT.text);}
		   	|REAL_CONSTANT                                           { $ast =new Real($REAL_CONSTANT.getLine(),$REAL_CONSTANT.getCharPositionInLine()+1,$REAL_CONSTANT.text);}
		   	|INT_CONSTANT		                                     { $ast =new LitEnt($INT_CONSTANT.getLine(),$INT_CONSTANT.getCharPositionInLine()+1,$INT_CONSTANT.text);}
		;

variable returns [Variable ast]:
             ID                                                        { $ast =new Variable($ID.getLine(),$ID.getCharPositionInLine()+1,$ID.text);}
            ;
statement returns [Sentence ast]
 :
           e1=expression '=' e2=expression ';'                             {$ast = new Asignation($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,$e2.ast);}
		   |def=defVariable ';'                                            {$ast = $def.ast;}
		   |variable '(' {List<Expresion> expressions=new ArrayList<Expresion>();} (e1=expression{expressions.add($e1.ast);} (','e2=expression{expressions.add($e2.ast);} )*)? ')'';'                        {$ast = new CallFuncSent($variable.start.getLine(),$variable.start.getCharPositionInLine()+1,$variable.ast,expressions);}
		   |'return' e1=expression ';'                                        {$ast = new Return($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast);}
		   |'if' expression ':' {List<Sentence> listif=new ArrayList<Sentence>();} if1=statement {listif.add($if1.ast);} 'else' {List<Sentence> listelse=new ArrayList<Sentence>();}else1=statement {listelse.add($else1.ast);}                    {$ast = new If($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast,listif,listelse);}
		   |'if' expression  ':' '{' {List<Sentence> listif=new ArrayList<Sentence>();} if1=statement {listif.add($if1.ast);} (if2=statement {listif.add($if2.ast);})+'}' 'else' '{' {List<Sentence> listelse=new ArrayList<Sentence>();}else1=statement {listelse.add($else1.ast);} (else2=statement {listelse.add($else2.ast);})*'}'               {$ast = new If($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast,listif,listelse);}
		   |'if' expression  ':'  {List<Sentence> listif=new ArrayList<Sentence>();} if1=statement {listif.add($if1.ast);}  'else' '{' {List<Sentence> listelse=new ArrayList<Sentence>();}else1=statement {listelse.add($else1.ast);} (else2=statement {listelse.add($else2.ast);})*'}'                {$ast = new If($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast,listif,listelse);}
		   |'if' expression  ':' '{' {List<Sentence> listif=new ArrayList<Sentence>();} if1=statement {listif.add($if1.ast);} (if2=statement {listif.add($if2.ast);})+'}' 'else' {List<Sentence> listelse=new ArrayList<Sentence>();}else1=statement {listelse.add($else1.ast);}                    {$ast = new If($expression.start.getLine(),$expression.start.getCharPositionInLine()+1,$expression.ast,listif,listelse);}
		   |'while' e1=expression ':' {List<Sentence> lista =new ArrayList<Sentence>();}'{' (s1=statement{lista.add($s1.ast);})* '}'                         {$ast = new While($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,$e1.ast,lista);}
		   |'print' e1=expression{List<Expresion> lista =new ArrayList<Expresion>();lista.add($e1.ast);} (','e2=expression{lista.add($e2.ast);})* ';'       {$ast =new Print($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,lista);}
		   |'input' e1=expression{List<Expresion> lista =new ArrayList<Expresion>();lista.add($e1.ast);} (','e2=expression{lista.add($e2.ast);})* ';'        {$ast =new Input($e1.start.getLine(),$e1.start.getCharPositionInLine()+1,lista);}
		;

       
       
       
/*****************************************LEXER***********************************************************/       
  		 
  		 
  		 
  		 
INT_CONSTANT: [0-9]+
            ;
            
ID: [a-zA-Z_]+[a-zA-Z0-9_]*
            ; 
                      
CHAR_CONSTANT: '\''.*?'\''
            ;              
                     
REAL_CONSTANT:	[0-9]+'.'[0-9]*|[0-9]*'.'[0-9]+
		|[0-9]+'.'?[0-9]*'E''-'?[0-9]+|[0-9]+'.'?[0-9]*'e''-'?[0-9]+
			;

			
WHITESPACE: [ \t\r\n]+ -> skip
			;
COMMENT:    '#' ~[\r\n]* -> skip
			;

			
COMMENT_MULT_LINEA:'"""' .*? '"""'  -> skip
			;		
			