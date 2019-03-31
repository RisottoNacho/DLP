// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;

    import ast.*;
    import ast.definitions.*;
    import ast.expressions.*;
    import ast.statements.*;
    import ast.types.*;
    import java.lang.String;
    

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
import java.util.List;
    import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, LINE_COMMENT=38, 
		COMMENT=39, WHITESPACE=40, REAL_CONSTANT=41, INT_CONSTANT=42, ID=43, CHAR_CONSTANT=44;
	public static final int
		RULE_program = 0, RULE_listDefinition = 1, RULE_listDefFunction = 2, RULE_main = 3, 
		RULE_expression = 4, RULE_listExpression = 5, RULE_type = 6, RULE_defVariable = 7, 
		RULE_parameter = 8, RULE_listParameter = 9, RULE_field = 10, RULE_fieldList = 11, 
		RULE_defFunction = 12, RULE_listStatement = 13, RULE_statement = 14;
	public static final String[] ruleNames = {
		"program", "listDefinition", "listDefFunction", "main", "expression", 
		"listExpression", "returnType", "defVariable", "parameter", "listParameter",
		"field", "fieldList", "defFunction", "listStatement", "statement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "'!'", "'-'", 
		"'['", "']'", "'.'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", "'>='", 
		"'<='", "'=='", "'!='", "'&&'", "'||'", "','", "'int'", "'double'", "'char'", 
		"'struct'", "';'", "'='", "'if'", "'else'", "'while'", "'print'", "'input'", 
		"'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "LINE_COMMENT", "COMMENT", "WHITESPACE", "REAL_CONSTANT", 
		"INT_CONSTANT", "ID", "CHAR_CONSTANT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public ListDefinitionContext a;
		public MainContext m;
		public TerminalNode EOF() { return getToken(PmmParser.EOF, 0); }
		public ListDefinitionContext listDefinition() {
			return getRuleContext(ListDefinitionContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((ProgramContext)_localctx).a = listDefinition();
			setState(31);
			((ProgramContext)_localctx).m = main();
			setState(32);
			match(EOF);

				List<Definition> ls = new ArrayList<Definition>();
				ls.addAll(((ProgramContext)_localctx).a.ast);
				ls.add(((ProgramContext)_localctx).m.ast);
				((ProgramContext)_localctx).ast =  new Program(0,0,ls);

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListDefinitionContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public DefVariableContext a;
		public DefFunctionContext b;
		public List<DefVariableContext> defVariable() {
			return getRuleContexts(DefVariableContext.class);
		}
		public DefVariableContext defVariable(int i) {
			return getRuleContext(DefVariableContext.class,i);
		}
		public List<DefFunctionContext> defFunction() {
			return getRuleContexts(DefFunctionContext.class);
		}
		public DefFunctionContext defFunction(int i) {
			return getRuleContext(DefFunctionContext.class,i);
		}
		public ListDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDefinition; }
	}

	public final ListDefinitionContext listDefinition() throws RecognitionException {
		ListDefinitionContext _localctx = new ListDefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_listDefinition);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(41);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(35);
						((ListDefinitionContext)_localctx).a = defVariable();

								_localctx.ast.addAll(((ListDefinitionContext)_localctx).a.ast);

						}
						break;
					case T__0:
						{
						setState(38);
						((ListDefinitionContext)_localctx).b = defFunction();

								_localctx.ast.add(((ListDefinitionContext)_localctx).b.ast);

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListDefFunctionContext extends ParserRuleContext {
		public List<FunctionDefinition> ast = new ArrayList<FunctionDefinition>();
		public DefFunctionContext d;
		public List<DefFunctionContext> defFunction() {
			return getRuleContexts(DefFunctionContext.class);
		}
		public DefFunctionContext defFunction(int i) {
			return getRuleContext(DefFunctionContext.class,i);
		}
		public ListDefFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDefFunction; }
	}

	public final ListDefFunctionContext listDefFunction() throws RecognitionException {
		ListDefFunctionContext _localctx = new ListDefFunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listDefFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(46);
				((ListDefFunctionContext)_localctx).d = defFunction();
				_localctx.ast.add(((ListDefFunctionContext)_localctx).d.ast);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Token id;
		public ListParameterContext c;
		public DefVariableContext a;
		public StatementContext b;
		public ListParameterContext listParameter() {
			return getRuleContext(ListParameterContext.class,0);
		}
		public List<DefVariableContext> defVariable() {
			return getRuleContexts(DefVariableContext.class);
		}
		public DefVariableContext defVariable(int i) {
			return getRuleContext(DefVariableContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_main);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{

				List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
				List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
				List<Statement> lsStatement = new ArrayList<Statement>();

			setState(55);
			match(T__0);
			setState(56);
			((MainContext)_localctx).id = match(T__1);
			setState(57);
			match(T__2);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(58);
				((MainContext)_localctx).c = listParameter();
				lsParam.addAll(((MainContext)_localctx).c.ast);
				}
			}

			setState(63);
			match(T__3);
			setState(64);
			match(T__4);
			setState(65);
			match(T__5);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					((MainContext)_localctx).a = defVariable();
					lsVar.addAll(((MainContext)_localctx).a.ast);
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(74);
				((MainContext)_localctx).b = statement();
				lsStatement.addAll(((MainContext)_localctx).b.ast);
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__6);

				((MainContext)_localctx).ast =  new FunctionDefinition(((MainContext)_localctx).id.getLine(),((MainContext)_localctx).id.getCharPositionInLine()+1,(((MainContext)_localctx).id!=null?((MainContext)_localctx).id.getText():null),lsVar,lsStatement,new Function(((MainContext)_localctx).id.getLine(),((MainContext)_localctx).id.getCharPositionInLine()+1,lsParam,null));
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression ast;
		public ExpressionContext e1;
		public ExpressionContext iz;
		public TypeContext t;
		public ExpressionContext e;
		public Token ID;
		public ListExpressionContext l;
		public Token INT_CONSTANT;
		public Token CHAR_CONSTANT;
		public Token REAL_CONSTANT;
		public Token op;
		public ExpressionContext e2;
		public ExpressionContext de;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public ListExpressionContext listExpression() {
			return getRuleContext(ListExpressionContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(PmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(PmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(86);
				match(T__2);
				setState(87);
				((ExpressionContext)_localctx).t = type();
				setState(88);
				match(T__3);
				setState(89);
				((ExpressionContext)_localctx).e = expression(16);
				((ExpressionContext)_localctx).ast =  new Cast((((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getLine(),(((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast,((ExpressionContext)_localctx).t.ast);
				}
				break;
			case 2:
				{
				setState(92);
				match(T__2);
				setState(93);
				((ExpressionContext)_localctx).e = expression(0);
				setState(94);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast; 
				}
				break;
			case 3:
				{
				setState(97);
				match(T__7);
				setState(98);
				((ExpressionContext)_localctx).e = expression(14);
				((ExpressionContext)_localctx).ast =  new UnaryNot((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(),(((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 4:
				{
				setState(101);
				match(T__8);
				setState(102);
				((ExpressionContext)_localctx).e = expression(13);
				((ExpressionContext)_localctx).ast =  new UnaryMinus((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(),(((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 5:
				{
				setState(105);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(106);
				match(T__2);
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					setState(107);
					((ExpressionContext)_localctx).l = listExpression();
					}
				}

				setState(110);
				match(T__3);
				((ExpressionContext)_localctx).ast =  new FunctionProcedure(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null),((ExpressionContext)_localctx).l.ast);
				}
				break;
			case 6:
				{
				setState(112);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 7:
				{
				setState(114);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(),((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 8:
				{
				setState(116);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			case 9:
				{
				setState(118);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(123);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						((ExpressionContext)_localctx).e2 = expression(10);
						((ExpressionContext)_localctx).ast =  new Arithmetic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.iz = _prevctx;
						_localctx.iz = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(128);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__15) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						((ExpressionContext)_localctx).de = expression(9);
							((ExpressionContext)_localctx).ast =  new Arithmetic((((ExpressionContext)_localctx).iz!=null?(((ExpressionContext)_localctx).iz.start):null).getLine(),(((ExpressionContext)_localctx).iz!=null?(((ExpressionContext)_localctx).iz.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).iz.ast,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).de.ast);
						          
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(133);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(134);
						((ExpressionContext)_localctx).e2 = expression(8);
						((ExpressionContext)_localctx).ast =  new Comparison((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(138);
						((ExpressionContext)_localctx).op = match(T__22);
						}
						setState(139);
						((ExpressionContext)_localctx).e2 = expression(7);
						((ExpressionContext)_localctx).ast =  new Logic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(143);
						((ExpressionContext)_localctx).op = match(T__23);
						}
						setState(144);
						((ExpressionContext)_localctx).e2 = expression(6);
						((ExpressionContext)_localctx).ast =  new Logic((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null),((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(148);
						match(T__9);
						setState(149);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(150);
						match(T__10);
						((ExpressionContext)_localctx).ast =  new ArrayAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,((ExpressionContext)_localctx).e2.ast);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(154);
						match(T__11);
						setState(155);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new StructAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ListExpressionContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExpression; }
	}

	public final ListExpressionContext listExpression() throws RecognitionException {
		ListExpressionContext _localctx = new ListExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			((ListExpressionContext)_localctx).e1 = expression(0);
			_localctx.ast.add(((ListExpressionContext)_localctx).e1.ast);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(164);
				match(T__24);
				setState(165);
				((ListExpressionContext)_localctx).e2 = expression(0);
				_localctx.ast.add(((ListExpressionContext)_localctx).e2.ast);
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public Token a;
		public FieldContext b;
		public TypeContext t;
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TerminalNode INT_CONSTANT() { return getToken(PmmParser.INT_CONSTANT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		int _la;
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				((TypeContext)_localctx).a = match(T__25);
				((TypeContext)_localctx).ast =  new Int(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				((TypeContext)_localctx).a = match(T__26);
				((TypeContext)_localctx).ast =  new Real(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				((TypeContext)_localctx).a = match(T__27);
				((TypeContext)_localctx).ast =  new Char(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				List<Field> ls = new ArrayList<Field>();
				setState(180);
				((TypeContext)_localctx).a = match(T__28);
				setState(181);
				match(T__5);
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					((TypeContext)_localctx).b = field();
					ls.addAll(((TypeContext)_localctx).b.ast);
					setState(184);
					match(T__29);
					}
					}
					setState(188); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(190);
				match(T__6);
				((TypeContext)_localctx).ast =  new Struct(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1, ls);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				match(T__9);
				setState(194);
				((TypeContext)_localctx).a = match(INT_CONSTANT);
				setState(195);
				match(T__10);
				setState(196);
				((TypeContext)_localctx).t = type();
				((TypeContext)_localctx).ast =  new Array(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1,LexerHelper.lexemeToInt((((TypeContext)_localctx).a!=null?((TypeContext)_localctx).a.getText():null)), ((TypeContext)_localctx).t.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefVariableContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public Token a;
		public Token b;
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DefVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defVariable; }
	}

	public final DefVariableContext defVariable() throws RecognitionException {
		DefVariableContext _localctx = new DefVariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_defVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			((DefVariableContext)_localctx).a = match(ID);

				_localctx.ast.add(new VariableDefinition(((DefVariableContext)_localctx).a.getLine(),((DefVariableContext)_localctx).a.getCharPositionInLine()+1,
				(((DefVariableContext)_localctx).a!=null?((DefVariableContext)_localctx).a.getText():null)));
				
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(203);
				match(T__24);
				setState(204);
				((DefVariableContext)_localctx).b = match(ID);
				_localctx.ast.add(new VariableDefinition(((DefVariableContext)_localctx).a.getLine(),((DefVariableContext)_localctx).a.getCharPositionInLine()+1,
					(((DefVariableContext)_localctx).b!=null?((DefVariableContext)_localctx).b.getText():null)));
					
				}
				}
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			match(T__4);
			setState(212);
			((DefVariableContext)_localctx).t = type();
			setState(213);
			match(T__29);

				for(VariableDefinition a : _localctx.ast){
					a.setType(((DefVariableContext)_localctx).t.ast);
				}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public VariableDefinition ast;
		public Token ID;
		public TypeContext t;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			((ParameterContext)_localctx).ID = match(ID);
			setState(217);
			match(T__4);
			setState(218);
			((ParameterContext)_localctx).t = type();

					((ParameterContext)_localctx).ast =  new VariableDefinition(((ParameterContext)_localctx).ID.getLine(),((ParameterContext)_localctx).ID.getCharPositionInLine()+1,(((ParameterContext)_localctx).ID!=null?((ParameterContext)_localctx).ID.getText():null));
					_localctx.ast.type = ((ParameterContext)_localctx).t.ast;
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListParameterContext extends ParserRuleContext {
		public List<VariableDefinition> ast = new ArrayList<VariableDefinition>();
		public ParameterContext p1;
		public ParameterContext p2;
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ListParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listParameter; }
	}

	public final ListParameterContext listParameter() throws RecognitionException {
		ListParameterContext _localctx = new ListParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_listParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			((ListParameterContext)_localctx).p1 = parameter();

					_localctx.ast.add(((ListParameterContext)_localctx).p1.ast);
					
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(223);
				match(T__24);
				setState(224);
				((ListParameterContext)_localctx).p2 = parameter();

						_localctx.ast.add(((ListParameterContext)_localctx).p2.ast);
						
				}
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList<Field>();
		public Token i1;
		public Token i2;
		public TypeContext t;
		public List<TerminalNode> ID() { return getTokens(PmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PmmParser.ID, i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			((FieldContext)_localctx).i1 = match(ID);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(233);
				match(T__24);
				setState(234);
				((FieldContext)_localctx).i2 = match(ID);

							boolean rep = false;
							Field f = new Field(((FieldContext)_localctx).i2.getLine(),((FieldContext)_localctx).i2.getCharPositionInLine()+1,(((FieldContext)_localctx).i2!=null?((FieldContext)_localctx).i2.getText():null));
							if(_localctx.ast.contains(f)){
								rep = true;
								f.setType(new ErrorType(((FieldContext)_localctx).i2.getLine(),((FieldContext)_localctx).i2.getCharPositionInLine()+1,"Two or more variables with same ID"));
								_localctx.ast.add(f);
							}else
								_localctx.ast.add(new Field(((FieldContext)_localctx).i2.getLine(),((FieldContext)_localctx).i2.getCharPositionInLine()+1,(((FieldContext)_localctx).i2!=null?((FieldContext)_localctx).i2.getText():null)));	
						
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			match(T__4);
			setState(242);
			((FieldContext)_localctx).t = type();

						boolean rep = false;
						Field f = new Field(((FieldContext)_localctx).i1.getLine(),((FieldContext)_localctx).i1.getCharPositionInLine()+1,(((FieldContext)_localctx).i1!=null?((FieldContext)_localctx).i1.getText():null));
							if(_localctx.ast.contains(f))
								rep = true;
						if(rep){
							f.setType(new ErrorType(((FieldContext)_localctx).i1.getLine(),((FieldContext)_localctx).i1.getCharPositionInLine()+1,"Two or more variables with same ID"));
							_localctx.ast.add(f);
						}else
							_localctx.ast.add(new Field(((FieldContext)_localctx).i1.getLine(),((FieldContext)_localctx).i1.getCharPositionInLine()+1,(((FieldContext)_localctx).i1!=null?((FieldContext)_localctx).i1.getText():null)));	
					for(Field fl : _localctx.ast)
							if(!_localctx.ast.isEmpty() && fl.type == null)
								fl.type = ((FieldContext)_localctx).t.ast;
						
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldListContext extends ParserRuleContext {
		public List<Field> ast = new ArrayList();
		public FieldContext f1;
		public FieldContext f2;
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public FieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldList; }
	}

	public final FieldListContext fieldList() throws RecognitionException {
		FieldListContext _localctx = new FieldListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(245);
			((FieldListContext)_localctx).f1 = field();

				_localctx.ast.addAll(((FieldListContext)_localctx).f1.ast);

			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(247);
				match(T__24);
				setState(248);
				((FieldListContext)_localctx).f2 = field();

					_localctx.ast.addAll(((FieldListContext)_localctx).f2.ast);

				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefFunctionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Token id;
		public ListParameterContext c;
		public TypeContext t;
		public DefVariableContext a;
		public StatementContext b;
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListParameterContext listParameter() {
			return getRuleContext(ListParameterContext.class,0);
		}
		public List<DefVariableContext> defVariable() {
			return getRuleContexts(DefVariableContext.class);
		}
		public DefVariableContext defVariable(int i) {
			return getRuleContext(DefVariableContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defFunction; }
	}

	public final DefFunctionContext defFunction() throws RecognitionException {
		DefFunctionContext _localctx = new DefFunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_defFunction);
		int _la;
		try {
			int _alt;
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{

					List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
					List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
					List<Statement> lsStatement = new ArrayList<Statement>();

				setState(257);
				match(T__0);
				setState(258);
				((DefFunctionContext)_localctx).id = match(ID);
				setState(259);
				match(T__2);
				setState(263);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(260);
					((DefFunctionContext)_localctx).c = listParameter();
					lsParam.addAll(((DefFunctionContext)_localctx).c.ast);
					}
				}

				setState(265);
				match(T__3);
				setState(266);
				match(T__4);
				setState(267);
				((DefFunctionContext)_localctx).t = type();
				setState(268);
				match(T__5);
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(269);
						((DefFunctionContext)_localctx).a = defVariable();
						lsVar.addAll(((DefFunctionContext)_localctx).a.ast);
						}
						} 
					}
					setState(276);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(277);
					((DefFunctionContext)_localctx).b = statement();
					lsStatement.addAll(((DefFunctionContext)_localctx).b.ast);
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(285);
				match(T__6);

					((DefFunctionContext)_localctx).ast =  new FunctionDefinition(((DefFunctionContext)_localctx).id.getLine(),((DefFunctionContext)_localctx).id.getCharPositionInLine()+1,(((DefFunctionContext)_localctx).id!=null?((DefFunctionContext)_localctx).id.getText():null),lsVar,lsStatement,new Function(((DefFunctionContext)_localctx).id.getLine(),((DefFunctionContext)_localctx).id.getCharPositionInLine()+1,lsParam,((DefFunctionContext)_localctx).t.ast));
					
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{

					List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
					List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
					List<Statement> lsStatement = new ArrayList<Statement>();

				setState(289);
				match(T__0);
				setState(290);
				((DefFunctionContext)_localctx).id = match(ID);
				setState(291);
				match(T__2);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(292);
					((DefFunctionContext)_localctx).c = listParameter();
					lsParam.addAll(((DefFunctionContext)_localctx).c.ast);
					}
				}

				setState(297);
				match(T__3);
				setState(298);
				match(T__4);
				setState(299);
				match(T__5);
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(300);
						((DefFunctionContext)_localctx).a = defVariable();
						lsVar.addAll(((DefFunctionContext)_localctx).a.ast);
						}
						} 
					}
					setState(307);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(308);
					((DefFunctionContext)_localctx).b = statement();
					lsStatement.addAll(((DefFunctionContext)_localctx).b.ast);
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				match(T__6);

					((DefFunctionContext)_localctx).ast =  new FunctionDefinition(((DefFunctionContext)_localctx).id.getLine(),((DefFunctionContext)_localctx).id.getCharPositionInLine()+1,(((DefFunctionContext)_localctx).id!=null?((DefFunctionContext)_localctx).id.getText():null),lsVar,lsStatement,new Function(((DefFunctionContext)_localctx).id.getLine(),((DefFunctionContext)_localctx).id.getCharPositionInLine()+1,lsParam,null));
					
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListStatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext s;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ListStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listStatement; }
	}

	public final ListStatementContext listStatement() throws RecognitionException {
		ListStatementContext _localctx = new ListStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(320);
				((ListStatementContext)_localctx).s = statement();
				_localctx.ast.addAll(((ListStatementContext)_localctx).s.ast);
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public DefVariableContext v;
		public Token ID;
		public ListExpressionContext l;
		public ExpressionContext a;
		public ListStatementContext l1;
		public StatementContext l2;
		public ListStatementContext l3;
		public ListStatementContext s;
		public ListStatementContext l5;
		public StatementContext s1;
		public StatementContext l6;
		public ListStatementContext s2;
		public StatementContext l7;
		public StatementContext s3;
		public ListStatementContext l4;
		public ListExpressionContext a2;
		public ListExpressionContext a3;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DefVariableContext defVariable() {
			return getRuleContext(DefVariableContext.class,0);
		}
		public TerminalNode ID() { return getToken(PmmParser.ID, 0); }
		public List<ListExpressionContext> listExpression() {
			return getRuleContexts(ListExpressionContext.class);
		}
		public ListExpressionContext listExpression(int i) {
			return getRuleContext(ListExpressionContext.class,i);
		}
		public List<ListStatementContext> listStatement() {
			return getRuleContexts(ListStatementContext.class);
		}
		public ListStatementContext listStatement(int i) {
			return getRuleContext(ListStatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				((StatementContext)_localctx).e1 = expression(0);
				setState(329);
				match(T__30);
				setState(330);
				((StatementContext)_localctx).e2 = expression(0);
				setState(331);
				match(T__29);
				_localctx.ast.add(new Assignment((((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getLine(),(((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).e1.ast,((StatementContext)_localctx).e2.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				((StatementContext)_localctx).v = defVariable();
				setState(335);
				match(T__29);
				_localctx.ast.addAll(((StatementContext)_localctx).v.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				List<Expression> ls = new ArrayList<Expression>();
				setState(339);
				((StatementContext)_localctx).ID = match(ID);
				setState(340);
				match(T__2);
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(341);
					((StatementContext)_localctx).l = listExpression();
					ls.addAll(((StatementContext)_localctx).l.ast);
					}
					}
					setState(348);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(349);
				match(T__3);
				setState(350);
				match(T__29);
				_localctx.ast.add(new FunctionCall(((StatementContext)_localctx).ID.getLine(),((StatementContext)_localctx).ID.getCharPositionInLine()+1,(((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null),ls));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(352);
				match(T__31);
				setState(353);
				((StatementContext)_localctx).a = expression(0);
				setState(354);
				match(T__4);
				setState(355);
				match(T__5);
				setState(356);
				((StatementContext)_localctx).l1 = listStatement();
				setState(357);
				match(T__6);
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l1.ast,null));
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(360);
				match(T__31);
				setState(361);
				((StatementContext)_localctx).a = expression(0);
				setState(362);
				match(T__4);
				setState(363);
				((StatementContext)_localctx).l2 = statement();
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l2.ast,null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(366);
				match(T__31);
				setState(367);
				((StatementContext)_localctx).a = expression(0);
				setState(368);
				match(T__4);
				{
				setState(369);
				match(T__5);
				setState(370);
				((StatementContext)_localctx).l3 = listStatement();
				setState(371);
				match(T__6);
				}
				setState(373);
				match(T__32);
				{
				setState(374);
				match(T__5);
				setState(375);
				((StatementContext)_localctx).s = listStatement();
				setState(376);
				match(T__6);
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l3.ast,((StatementContext)_localctx).s.ast));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(380);
				match(T__31);
				setState(381);
				((StatementContext)_localctx).a = expression(0);
				setState(382);
				match(T__4);
				{
				setState(383);
				match(T__5);
				setState(384);
				((StatementContext)_localctx).l5 = listStatement();
				setState(385);
				match(T__6);
				}
				setState(387);
				match(T__32);
				{
				setState(388);
				((StatementContext)_localctx).s1 = statement();
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l5.ast,((StatementContext)_localctx).s1.ast));
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(391);
				match(T__31);
				setState(392);
				((StatementContext)_localctx).a = expression(0);
				setState(393);
				match(T__4);
				{
				setState(394);
				((StatementContext)_localctx).l6 = statement();
				}
				setState(395);
				match(T__32);
				{
				setState(396);
				match(T__5);
				setState(397);
				((StatementContext)_localctx).s2 = listStatement();
				setState(398);
				match(T__6);
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l6.ast,((StatementContext)_localctx).s2.ast));
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(402);
				match(T__31);
				setState(403);
				((StatementContext)_localctx).a = expression(0);
				setState(404);
				match(T__4);
				{
				setState(405);
				((StatementContext)_localctx).l7 = statement();
				}
				setState(406);
				match(T__32);
				{
				setState(407);
				((StatementContext)_localctx).s3 = statement();
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l7.ast,((StatementContext)_localctx).s3.ast));
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(410);
				match(T__33);
				setState(411);
				((StatementContext)_localctx).a = expression(0);
				setState(412);
				match(T__4);
				setState(413);
				match(T__5);
				setState(414);
				((StatementContext)_localctx).l4 = listStatement();
				setState(415);
				match(T__6);
				_localctx.ast.add(new While((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l4.ast));
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(418);
				match(T__34);
				setState(419);
				((StatementContext)_localctx).a2 = listExpression();
				setState(420);
				match(T__29);
				_localctx.ast.add(new Print((((StatementContext)_localctx).a2!=null?(((StatementContext)_localctx).a2.start):null).getLine(),(((StatementContext)_localctx).a2!=null?(((StatementContext)_localctx).a2.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a2.ast));
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(423);
				match(T__35);
				setState(424);
				((StatementContext)_localctx).a3 = listExpression();
				setState(425);
				match(T__29);
				_localctx.ast.add(new Input((((StatementContext)_localctx).a3!=null?(((StatementContext)_localctx).a3.start):null).getLine(),(((StatementContext)_localctx).a3!=null?(((StatementContext)_localctx).a3.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a3.ast));
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(428);
				match(T__36);
				setState(429);
				((StatementContext)_localctx).a = expression(0);
				setState(430);
				match(T__29);
				_localctx.ast.add(new Return((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6o\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6{\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a0\n\6\f\6\16\6\u00a3\13\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00ab\n\7\f\7\16\7\u00ae\13\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u00bd\n\b\r\b\16\b\u00be\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ca\n\b\3\t\3\t\3\t\3\t\3\t\7\t\u00d1\n"+
		"\t\f\t\16\t\u00d4\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\7\13\u00e6\n\13\f\13\16\13\u00e9\13\13\3\f\3\f"+
		"\3\f\3\f\7\f\u00ef\n\f\f\f\16\f\u00f2\13\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u00fe\n\r\f\r\16\r\u0101\13\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u010a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0113"+
		"\n\16\f\16\16\16\u0116\13\16\3\16\3\16\3\16\7\16\u011b\n\16\f\16\16\16"+
		"\u011e\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u012a"+
		"\n\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0132\n\16\f\16\16\16\u0135\13"+
		"\16\3\16\3\16\3\16\7\16\u013a\n\16\f\16\16\16\u013d\13\16\3\16\3\16\5"+
		"\16\u0141\n\16\3\17\3\17\3\17\7\17\u0146\n\17\f\17\16\17\u0149\13\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\7\20\u015b\n\20\f\20\16\20\u015e\13\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u01b4\n\20\3\20"+
		"\2\3\n\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\5\3\2\17\21\4\2\13"+
		"\13\22\22\3\2\23\30\2\u01db\2 \3\2\2\2\4-\3\2\2\2\6\65\3\2\2\2\b8\3\2"+
		"\2\2\nz\3\2\2\2\f\u00a4\3\2\2\2\16\u00c9\3\2\2\2\20\u00cb\3\2\2\2\22\u00da"+
		"\3\2\2\2\24\u00df\3\2\2\2\26\u00ea\3\2\2\2\30\u00f7\3\2\2\2\32\u0140\3"+
		"\2\2\2\34\u0147\3\2\2\2\36\u01b3\3\2\2\2 !\5\4\3\2!\"\5\b\5\2\"#\7\2\2"+
		"\3#$\b\2\1\2$\3\3\2\2\2%&\5\20\t\2&\'\b\3\1\2\',\3\2\2\2()\5\32\16\2)"+
		"*\b\3\1\2*,\3\2\2\2+%\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2"+
		".\5\3\2\2\2/-\3\2\2\2\60\61\5\32\16\2\61\62\b\4\1\2\62\64\3\2\2\2\63\60"+
		"\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\7\3\2\2\2\67\65"+
		"\3\2\2\289\b\5\1\29:\7\3\2\2:;\7\4\2\2;?\7\5\2\2<=\5\24\13\2=>\b\5\1\2"+
		">@\3\2\2\2?<\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\6\2\2BC\7\7\2\2CI\7\b\2\2"+
		"DE\5\20\t\2EF\b\5\1\2FH\3\2\2\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2"+
		"\2JQ\3\2\2\2KI\3\2\2\2LM\5\36\20\2MN\b\5\1\2NP\3\2\2\2OL\3\2\2\2PS\3\2"+
		"\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\t\2\2UV\b\5\1\2V\t\3"+
		"\2\2\2WX\b\6\1\2XY\7\5\2\2YZ\5\16\b\2Z[\7\6\2\2[\\\5\n\6\22\\]\b\6\1\2"+
		"]{\3\2\2\2^_\7\5\2\2_`\5\n\6\2`a\7\6\2\2ab\b\6\1\2b{\3\2\2\2cd\7\n\2\2"+
		"de\5\n\6\20ef\b\6\1\2f{\3\2\2\2gh\7\13\2\2hi\5\n\6\17ij\b\6\1\2j{\3\2"+
		"\2\2kl\7-\2\2ln\7\5\2\2mo\5\f\7\2nm\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\6"+
		"\2\2q{\b\6\1\2rs\7-\2\2s{\b\6\1\2tu\7,\2\2u{\b\6\1\2vw\7.\2\2w{\b\6\1"+
		"\2xy\7+\2\2y{\b\6\1\2zW\3\2\2\2z^\3\2\2\2zc\3\2\2\2zg\3\2\2\2zk\3\2\2"+
		"\2zr\3\2\2\2zt\3\2\2\2zv\3\2\2\2zx\3\2\2\2{\u00a1\3\2\2\2|}\f\13\2\2}"+
		"~\t\2\2\2~\177\5\n\6\f\177\u0080\b\6\1\2\u0080\u00a0\3\2\2\2\u0081\u0082"+
		"\f\n\2\2\u0082\u0083\t\3\2\2\u0083\u0084\5\n\6\13\u0084\u0085\b\6\1\2"+
		"\u0085\u00a0\3\2\2\2\u0086\u0087\f\t\2\2\u0087\u0088\t\4\2\2\u0088\u0089"+
		"\5\n\6\n\u0089\u008a\b\6\1\2\u008a\u00a0\3\2\2\2\u008b\u008c\f\b\2\2\u008c"+
		"\u008d\7\31\2\2\u008d\u008e\5\n\6\t\u008e\u008f\b\6\1\2\u008f\u00a0\3"+
		"\2\2\2\u0090\u0091\f\7\2\2\u0091\u0092\7\32\2\2\u0092\u0093\5\n\6\b\u0093"+
		"\u0094\b\6\1\2\u0094\u00a0\3\2\2\2\u0095\u0096\f\16\2\2\u0096\u0097\7"+
		"\f\2\2\u0097\u0098\5\n\6\2\u0098\u0099\7\r\2\2\u0099\u009a\b\6\1\2\u009a"+
		"\u00a0\3\2\2\2\u009b\u009c\f\r\2\2\u009c\u009d\7\16\2\2\u009d\u009e\7"+
		"-\2\2\u009e\u00a0\b\6\1\2\u009f|\3\2\2\2\u009f\u0081\3\2\2\2\u009f\u0086"+
		"\3\2\2\2\u009f\u008b\3\2\2\2\u009f\u0090\3\2\2\2\u009f\u0095\3\2\2\2\u009f"+
		"\u009b\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\13\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\5\n\6\2\u00a5\u00ac"+
		"\b\7\1\2\u00a6\u00a7\7\33\2\2\u00a7\u00a8\5\n\6\2\u00a8\u00a9\b\7\1\2"+
		"\u00a9\u00ab\3\2\2\2\u00aa\u00a6\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\r\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b0\7\34\2\2\u00b0\u00ca\b\b\1\2\u00b1\u00b2\7\35\2\2\u00b2\u00ca\b"+
		"\b\1\2\u00b3\u00b4\7\36\2\2\u00b4\u00ca\b\b\1\2\u00b5\u00b6\b\b\1\2\u00b6"+
		"\u00b7\7\37\2\2\u00b7\u00bc\7\b\2\2\u00b8\u00b9\5\26\f\2\u00b9\u00ba\b"+
		"\b\1\2\u00ba\u00bb\7 \2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b8\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2"+
		"\2\2\u00c0\u00c1\7\t\2\2\u00c1\u00c2\b\b\1\2\u00c2\u00ca\3\2\2\2\u00c3"+
		"\u00c4\7\f\2\2\u00c4\u00c5\7,\2\2\u00c5\u00c6\7\r\2\2\u00c6\u00c7\5\16"+
		"\b\2\u00c7\u00c8\b\b\1\2\u00c8\u00ca\3\2\2\2\u00c9\u00af\3\2\2\2\u00c9"+
		"\u00b1\3\2\2\2\u00c9\u00b3\3\2\2\2\u00c9\u00b5\3\2\2\2\u00c9\u00c3\3\2"+
		"\2\2\u00ca\17\3\2\2\2\u00cb\u00cc\7-\2\2\u00cc\u00d2\b\t\1\2\u00cd\u00ce"+
		"\7\33\2\2\u00ce\u00cf\7-\2\2\u00cf\u00d1\b\t\1\2\u00d0\u00cd\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2"+
		"\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7\5\16\b\2\u00d7"+
		"\u00d8\7 \2\2\u00d8\u00d9\b\t\1\2\u00d9\21\3\2\2\2\u00da\u00db\7-\2\2"+
		"\u00db\u00dc\7\7\2\2\u00dc\u00dd\5\16\b\2\u00dd\u00de\b\n\1\2\u00de\23"+
		"\3\2\2\2\u00df\u00e0\5\22\n\2\u00e0\u00e7\b\13\1\2\u00e1\u00e2\7\33\2"+
		"\2\u00e2\u00e3\5\22\n\2\u00e3\u00e4\b\13\1\2\u00e4\u00e6\3\2\2\2\u00e5"+
		"\u00e1\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\25\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00f0\7-\2\2\u00eb\u00ec"+
		"\7\33\2\2\u00ec\u00ed\7-\2\2\u00ed\u00ef\b\f\1\2\u00ee\u00eb\3\2\2\2\u00ef"+
		"\u00f2\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2"+
		"\2\2\u00f2\u00f0\3\2\2\2\u00f3\u00f4\7\7\2\2\u00f4\u00f5\5\16\b\2\u00f5"+
		"\u00f6\b\f\1\2\u00f6\27\3\2\2\2\u00f7\u00f8\5\26\f\2\u00f8\u00ff\b\r\1"+
		"\2\u00f9\u00fa\7\33\2\2\u00fa\u00fb\5\26\f\2\u00fb\u00fc\b\r\1\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u0100\31\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103"+
		"\b\16\1\2\u0103\u0104\7\3\2\2\u0104\u0105\7-\2\2\u0105\u0109\7\5\2\2\u0106"+
		"\u0107\5\24\13\2\u0107\u0108\b\16\1\2\u0108\u010a\3\2\2\2\u0109\u0106"+
		"\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\7\6\2\2\u010c"+
		"\u010d\7\7\2\2\u010d\u010e\5\16\b\2\u010e\u0114\7\b\2\2\u010f\u0110\5"+
		"\20\t\2\u0110\u0111\b\16\1\2\u0111\u0113\3\2\2\2\u0112\u010f\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u011c\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0118\5\36\20\2\u0118\u0119\b\16\1\2\u0119"+
		"\u011b\3\2\2\2\u011a\u0117\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0120\7\t\2\2\u0120\u0121\b\16\1\2\u0121\u0141\3\2\2\2\u0122\u0123\b"+
		"\16\1\2\u0123\u0124\7\3\2\2\u0124\u0125\7-\2\2\u0125\u0129\7\5\2\2\u0126"+
		"\u0127\5\24\13\2\u0127\u0128\b\16\1\2\u0128\u012a\3\2\2\2\u0129\u0126"+
		"\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\7\6\2\2\u012c"+
		"\u012d\7\7\2\2\u012d\u0133\7\b\2\2\u012e\u012f\5\20\t\2\u012f\u0130\b"+
		"\16\1\2\u0130\u0132\3\2\2\2\u0131\u012e\3\2\2\2\u0132\u0135\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u013b\3\2\2\2\u0135\u0133\3\2"+
		"\2\2\u0136\u0137\5\36\20\2\u0137\u0138\b\16\1\2\u0138\u013a\3\2\2\2\u0139"+
		"\u0136\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\7\t\2\2\u013f"+
		"\u0141\b\16\1\2\u0140\u0102\3\2\2\2\u0140\u0122\3\2\2\2\u0141\33\3\2\2"+
		"\2\u0142\u0143\5\36\20\2\u0143\u0144\b\17\1\2\u0144\u0146\3\2\2\2\u0145"+
		"\u0142\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0145\3\2\2\2\u0147\u0148\3\2"+
		"\2\2\u0148\35\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014b\5\n\6\2\u014b\u014c"+
		"\7!\2\2\u014c\u014d\5\n\6\2\u014d\u014e\7 \2\2\u014e\u014f\b\20\1\2\u014f"+
		"\u01b4\3\2\2\2\u0150\u0151\5\20\t\2\u0151\u0152\7 \2\2\u0152\u0153\b\20"+
		"\1\2\u0153\u01b4\3\2\2\2\u0154\u0155\b\20\1\2\u0155\u0156\7-\2\2\u0156"+
		"\u015c\7\5\2\2\u0157\u0158\5\f\7\2\u0158\u0159\b\20\1\2\u0159\u015b\3"+
		"\2\2\2\u015a\u0157\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015f\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0160\7\6"+
		"\2\2\u0160\u0161\7 \2\2\u0161\u01b4\b\20\1\2\u0162\u0163\7\"\2\2\u0163"+
		"\u0164\5\n\6\2\u0164\u0165\7\7\2\2\u0165\u0166\7\b\2\2\u0166\u0167\5\34"+
		"\17\2\u0167\u0168\7\t\2\2\u0168\u0169\b\20\1\2\u0169\u01b4\3\2\2\2\u016a"+
		"\u016b\7\"\2\2\u016b\u016c\5\n\6\2\u016c\u016d\7\7\2\2\u016d\u016e\5\36"+
		"\20\2\u016e\u016f\b\20\1\2\u016f\u01b4\3\2\2\2\u0170\u0171\7\"\2\2\u0171"+
		"\u0172\5\n\6\2\u0172\u0173\7\7\2\2\u0173\u0174\7\b\2\2\u0174\u0175\5\34"+
		"\17\2\u0175\u0176\7\t\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7#\2\2\u0178"+
		"\u0179\7\b\2\2\u0179\u017a\5\34\17\2\u017a\u017b\7\t\2\2\u017b\u017c\3"+
		"\2\2\2\u017c\u017d\b\20\1\2\u017d\u01b4\3\2\2\2\u017e\u017f\7\"\2\2\u017f"+
		"\u0180\5\n\6\2\u0180\u0181\7\7\2\2\u0181\u0182\7\b\2\2\u0182\u0183\5\34"+
		"\17\2\u0183\u0184\7\t\2\2\u0184\u0185\3\2\2\2\u0185\u0186\7#\2\2\u0186"+
		"\u0187\5\36\20\2\u0187\u0188\b\20\1\2\u0188\u01b4\3\2\2\2\u0189\u018a"+
		"\7\"\2\2\u018a\u018b\5\n\6\2\u018b\u018c\7\7\2\2\u018c\u018d\5\36\20\2"+
		"\u018d\u018e\7#\2\2\u018e\u018f\7\b\2\2\u018f\u0190\5\34\17\2\u0190\u0191"+
		"\7\t\2\2\u0191\u0192\3\2\2\2\u0192\u0193\b\20\1\2\u0193\u01b4\3\2\2\2"+
		"\u0194\u0195\7\"\2\2\u0195\u0196\5\n\6\2\u0196\u0197\7\7\2\2\u0197\u0198"+
		"\5\36\20\2\u0198\u0199\7#\2\2\u0199\u019a\5\36\20\2\u019a\u019b\b\20\1"+
		"\2\u019b\u01b4\3\2\2\2\u019c\u019d\7$\2\2\u019d\u019e\5\n\6\2\u019e\u019f"+
		"\7\7\2\2\u019f\u01a0\7\b\2\2\u01a0\u01a1\5\34\17\2\u01a1\u01a2\7\t\2\2"+
		"\u01a2\u01a3\b\20\1\2\u01a3\u01b4\3\2\2\2\u01a4\u01a5\7%\2\2\u01a5\u01a6"+
		"\5\f\7\2\u01a6\u01a7\7 \2\2\u01a7\u01a8\b\20\1\2\u01a8\u01b4\3\2\2\2\u01a9"+
		"\u01aa\7&\2\2\u01aa\u01ab\5\f\7\2\u01ab\u01ac\7 \2\2\u01ac\u01ad\b\20"+
		"\1\2\u01ad\u01b4\3\2\2\2\u01ae\u01af\7\'\2\2\u01af\u01b0\5\n\6\2\u01b0"+
		"\u01b1\7 \2\2\u01b1\u01b2\b\20\1\2\u01b2\u01b4\3\2\2\2\u01b3\u014a\3\2"+
		"\2\2\u01b3\u0150\3\2\2\2\u01b3\u0154\3\2\2\2\u01b3\u0162\3\2\2\2\u01b3"+
		"\u016a\3\2\2\2\u01b3\u0170\3\2\2\2\u01b3\u017e\3\2\2\2\u01b3\u0189\3\2"+
		"\2\2\u01b3\u0194\3\2\2\2\u01b3\u019c\3\2\2\2\u01b3\u01a4\3\2\2\2\u01b3"+
		"\u01a9\3\2\2\2\u01b3\u01ae\3\2\2\2\u01b4\37\3\2\2\2\35+-\65?IQnz\u009f"+
		"\u00a1\u00ac\u00be\u00c9\u00d2\u00e7\u00f0\u00ff\u0109\u0114\u011c\u0129"+
		"\u0133\u013b\u0140\u0147\u015c\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}