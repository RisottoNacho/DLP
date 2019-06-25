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
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
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
		RULE_parameter = 8, RULE_listParameter = 9, RULE_field = 10, RULE_defFunction = 11, 
		RULE_listStatement = 12, RULE_statement = 13;
	public static final String[] ruleNames = {
		"program", "listDefinition", "listDefFunction", "main", "expression", 
		"listExpression", "type", "defVariable", "parameter", "listParameter", 
		"field", "defFunction", "listStatement", "statement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'def'", "'main'", "'('", "')'", "':'", "'{'", "'}'", "'.'", "'!'", 
		"'-'", "'['", "']'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", "'>='", 
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
			setState(28);
			((ProgramContext)_localctx).a = listDefinition();
			setState(29);
			((ProgramContext)_localctx).m = main();
			setState(30);
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
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(39);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ID:
						{
						setState(33);
						((ListDefinitionContext)_localctx).a = defVariable();

								_localctx.ast.addAll(((ListDefinitionContext)_localctx).a.ast);

						}
						break;
					case T__0:
						{
						setState(36);
						((ListDefinitionContext)_localctx).b = defFunction();

								_localctx.ast.add(((ListDefinitionContext)_localctx).b.ast);

						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(43);
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
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(44);
				((ListDefFunctionContext)_localctx).d = defFunction();
				_localctx.ast.add(((ListDefFunctionContext)_localctx).d.ast);
				}
				}
				setState(51);
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

			setState(53);
			match(T__0);
			setState(54);
			((MainContext)_localctx).id = match(T__1);
			setState(55);
			match(T__2);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(56);
				((MainContext)_localctx).c = listParameter();
				lsParam.addAll(((MainContext)_localctx).c.ast);
				}
			}

			setState(61);
			match(T__3);
			setState(62);
			match(T__4);
			setState(63);
			match(T__5);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(64);
					((MainContext)_localctx).a = defVariable();
					lsVar.addAll(((MainContext)_localctx).a.ast);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(72);
				((MainContext)_localctx).b = statement();
				lsStatement.addAll(((MainContext)_localctx).b.ast);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
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
		public List<ListExpressionContext> listExpression() {
			return getRuleContexts(ListExpressionContext.class);
		}
		public ListExpressionContext listExpression(int i) {
			return getRuleContext(ListExpressionContext.class,i);
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
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(84);
				match(T__2);
				setState(85);
				((ExpressionContext)_localctx).t = type();
				setState(86);
				match(T__3);
				setState(87);
				((ExpressionContext)_localctx).e = expression(15);
				((ExpressionContext)_localctx).ast =  new Cast((((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getLine(),(((ExpressionContext)_localctx).t!=null?(((ExpressionContext)_localctx).t.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast,((ExpressionContext)_localctx).t.ast);
				}
				break;
			case 2:
				{
				setState(90);
				match(T__2);
				setState(91);
				((ExpressionContext)_localctx).e = expression(0);
				setState(92);
				match(T__3);
				((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast; 
				}
				break;
			case 3:
				{
				setState(95);
				match(T__8);
				setState(96);
				((ExpressionContext)_localctx).e = expression(13);
				((ExpressionContext)_localctx).ast =  new UnaryNot((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(),(((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 4:
				{
				setState(99);
				match(T__9);
				setState(100);
				((ExpressionContext)_localctx).e = expression(12);
				((ExpressionContext)_localctx).ast =  new UnaryMinus((((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getLine(),(((ExpressionContext)_localctx).e!=null?(((ExpressionContext)_localctx).e.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e.ast);
				}
				break;
			case 5:
				{
				List<Expression> ls = new ArrayList<Expression>();
				setState(104);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(105);
				match(T__2);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(106);
					((ExpressionContext)_localctx).l = listExpression();
					ls.addAll(((ExpressionContext)_localctx).l.ast);
					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(T__3);
				((ExpressionContext)_localctx).ast =  (new FunctionProcedure(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,new Variable(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)),ls));
				}
				break;
			case 6:
				{
				setState(116);
				((ExpressionContext)_localctx).ID = match(ID);
				((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(),((ExpressionContext)_localctx).ID.getCharPositionInLine()+1,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
				}
				break;
			case 7:
				{
				setState(118);
				((ExpressionContext)_localctx).INT_CONSTANT = match(INT_CONSTANT);
				((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).INT_CONSTANT.getLine(),((ExpressionContext)_localctx).INT_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToInt((((ExpressionContext)_localctx).INT_CONSTANT!=null?((ExpressionContext)_localctx).INT_CONSTANT.getText():null)));
				}
				break;
			case 8:
				{
				setState(120);
				((ExpressionContext)_localctx).CHAR_CONSTANT = match(CHAR_CONSTANT);
				((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CHAR_CONSTANT.getLine(),((ExpressionContext)_localctx).CHAR_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CHAR_CONSTANT!=null?((ExpressionContext)_localctx).CHAR_CONSTANT.getText():null)));
				}
				break;
			case 9:
				{
				setState(122);
				((ExpressionContext)_localctx).REAL_CONSTANT = match(REAL_CONSTANT);
				((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).REAL_CONSTANT.getLine(),((ExpressionContext)_localctx).REAL_CONSTANT.getCharPositionInLine()+1,LexerHelper.lexemeToReal((((ExpressionContext)_localctx).REAL_CONSTANT!=null?((ExpressionContext)_localctx).REAL_CONSTANT.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(161);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(127);
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
						setState(128);
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
						setState(131);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(132);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__15) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(133);
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
						setState(136);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(137);
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
						setState(138);
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
						setState(141);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						{
						setState(142);
						((ExpressionContext)_localctx).op = match(T__22);
						}
						setState(143);
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
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						{
						setState(147);
						((ExpressionContext)_localctx).op = match(T__23);
						}
						setState(148);
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
						setState(151);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(152);
						match(T__7);
						setState(153);
						((ExpressionContext)_localctx).ID = match(ID);
						((ExpressionContext)_localctx).ast =  new StructAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,(((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null));
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(156);
						match(T__10);
						setState(157);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(158);
						match(T__11);
						((ExpressionContext)_localctx).ast =  new ArrayAccess((((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getLine(),(((ExpressionContext)_localctx).e1!=null?(((ExpressionContext)_localctx).e1.start):null).getCharPositionInLine()+1,((ExpressionContext)_localctx).e1.ast,((ExpressionContext)_localctx).e2.ast);
						}
						break;
					}
					} 
				}
				setState(165);
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
			setState(166);
			((ListExpressionContext)_localctx).e1 = expression(0);
			_localctx.ast.add(((ListExpressionContext)_localctx).e1.ast);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(168);
				match(T__24);
				setState(169);
				((ListExpressionContext)_localctx).e2 = expression(0);
				_localctx.ast.add(((ListExpressionContext)_localctx).e2.ast);
				}
				}
				setState(176);
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
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((TypeContext)_localctx).a = match(T__25);
				((TypeContext)_localctx).ast =  new Int(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				((TypeContext)_localctx).a = match(T__26);
				((TypeContext)_localctx).ast =  new Real(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				((TypeContext)_localctx).a = match(T__27);
				((TypeContext)_localctx).ast =  new Char(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 4);
				{
				List<Field> ls = new ArrayList<Field>();
				setState(184);
				((TypeContext)_localctx).a = match(T__28);
				setState(185);
				match(T__5);
				setState(190); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(186);
					((TypeContext)_localctx).b = field();
					ls.addAll(((TypeContext)_localctx).b.ast);
					setState(188);
					match(T__29);
					}
					}
					setState(192); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				setState(194);
				match(T__6);
				((TypeContext)_localctx).ast =  new Struct(((TypeContext)_localctx).a.getLine(),((TypeContext)_localctx).a.getCharPositionInLine()+1, ls);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 5);
				{
				setState(197);
				match(T__10);
				setState(198);
				((TypeContext)_localctx).a = match(INT_CONSTANT);
				setState(199);
				match(T__11);
				setState(200);
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
			setState(205);
			((DefVariableContext)_localctx).a = match(ID);

				_localctx.ast.add(new VariableDefinition(((DefVariableContext)_localctx).a.getLine(),((DefVariableContext)_localctx).a.getCharPositionInLine()+1,
				(((DefVariableContext)_localctx).a!=null?((DefVariableContext)_localctx).a.getText():null)));
				
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(207);
				match(T__24);
				setState(208);
				((DefVariableContext)_localctx).b = match(ID);
				_localctx.ast.add(new VariableDefinition(((DefVariableContext)_localctx).a.getLine(),((DefVariableContext)_localctx).a.getCharPositionInLine()+1,
					(((DefVariableContext)_localctx).b!=null?((DefVariableContext)_localctx).b.getText():null)));
					
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
			match(T__4);
			setState(216);
			((DefVariableContext)_localctx).t = type();
			setState(217);
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
			setState(220);
			((ParameterContext)_localctx).ID = match(ID);
			setState(221);
			match(T__4);
			setState(222);
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
			setState(225);
			((ListParameterContext)_localctx).p1 = parameter();

					_localctx.ast.add(((ListParameterContext)_localctx).p1.ast);
					
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(227);
				match(T__24);
				setState(228);
				((ListParameterContext)_localctx).p2 = parameter();

						_localctx.ast.add(((ListParameterContext)_localctx).p2.ast);
						
				}
				}
				setState(235);
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
			setState(236);
			((FieldContext)_localctx).i1 = match(ID);

						Field f = new Field(((FieldContext)_localctx).i1.getLine(),((FieldContext)_localctx).i1.getCharPositionInLine()+1,(((FieldContext)_localctx).i1!=null?((FieldContext)_localctx).i1.getText():null));
			          			if(_localctx.ast.contains(f)){
			          				f.setType(new ErrorType(((FieldContext)_localctx).i1.getLine(),((FieldContext)_localctx).i1.getCharPositionInLine()+1,"Two or more variables with same ID"));
			          			}
			          			_localctx.ast.add(f);

			          			
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__24) {
				{
				{
				setState(238);
				match(T__24);
				setState(239);
				((FieldContext)_localctx).i2 = match(ID);

							f = new Field(((FieldContext)_localctx).i2.getLine(),((FieldContext)_localctx).i2.getCharPositionInLine()+1,(((FieldContext)_localctx).i2!=null?((FieldContext)_localctx).i2.getText():null));
								if(_localctx.ast.contains(f)){
								    f.setType(new ErrorType(((FieldContext)_localctx).i2.getLine(),((FieldContext)_localctx).i2.getCharPositionInLine()+1,"Two or more variables with same ID"));
							}
							_localctx.ast.add(f);
						
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
			match(T__4);
			setState(247);
			((FieldContext)_localctx).t = type();

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
		enterRule(_localctx, 22, RULE_defFunction);
		int _la;
		try {
			int _alt;
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{

					List<VariableDefinition> lsParam = new ArrayList<VariableDefinition>();
					List<VariableDefinition> lsVar = new ArrayList<VariableDefinition>();
					List<Statement> lsStatement = new ArrayList<Statement>();

				setState(251);
				match(T__0);
				setState(252);
				((DefFunctionContext)_localctx).id = match(ID);
				setState(253);
				match(T__2);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(254);
					((DefFunctionContext)_localctx).c = listParameter();
					lsParam.addAll(((DefFunctionContext)_localctx).c.ast);
					}
				}

				setState(259);
				match(T__3);
				setState(260);
				match(T__4);
				setState(261);
				((DefFunctionContext)_localctx).t = type();
				setState(262);
				match(T__5);
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(263);
						((DefFunctionContext)_localctx).a = defVariable();
						lsVar.addAll(((DefFunctionContext)_localctx).a.ast);
						}
						} 
					}
					setState(270);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(271);
					((DefFunctionContext)_localctx).b = statement();
					lsStatement.addAll(((DefFunctionContext)_localctx).b.ast);
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
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

				setState(283);
				match(T__0);
				setState(284);
				((DefFunctionContext)_localctx).id = match(ID);
				setState(285);
				match(T__2);
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(286);
					((DefFunctionContext)_localctx).c = listParameter();
					lsParam.addAll(((DefFunctionContext)_localctx).c.ast);
					}
				}

				setState(291);
				match(T__3);
				setState(292);
				match(T__4);
				setState(293);
				match(T__5);
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(294);
						((DefFunctionContext)_localctx).a = defVariable();
						lsVar.addAll(((DefFunctionContext)_localctx).a.ast);
						}
						} 
					}
					setState(301);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(302);
					((DefFunctionContext)_localctx).b = statement();
					lsStatement.addAll(((DefFunctionContext)_localctx).b.ast);
					}
					}
					setState(309);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(310);
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
		enterRule(_localctx, 24, RULE_listStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
				{
				{
				setState(314);
				((ListStatementContext)_localctx).s = statement();
				_localctx.ast.addAll(((ListStatementContext)_localctx).s.ast);
				}
				}
				setState(321);
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
		public StatementContext l9;
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
		enterRule(_localctx, 26, RULE_statement);
		int _la;
		try {
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				((StatementContext)_localctx).e1 = expression(0);
				setState(323);
				match(T__30);
				setState(324);
				((StatementContext)_localctx).e2 = expression(0);
				setState(325);
				match(T__29);
				_localctx.ast.add(new Assignment((((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getLine(),(((StatementContext)_localctx).e1!=null?(((StatementContext)_localctx).e1.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).e1.ast,((StatementContext)_localctx).e2.ast));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				((StatementContext)_localctx).v = defVariable();
				setState(329);
				match(T__29);
				_localctx.ast.addAll(((StatementContext)_localctx).v.ast);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				List<Expression> ls = new ArrayList<Expression>();
				setState(333);
				((StatementContext)_localctx).ID = match(ID);
				setState(334);
				match(T__2);
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << T__9) | (1L << REAL_CONSTANT) | (1L << INT_CONSTANT) | (1L << ID) | (1L << CHAR_CONSTANT))) != 0)) {
					{
					{
					setState(335);
					((StatementContext)_localctx).l = listExpression();
					ls.addAll(((StatementContext)_localctx).l.ast);
					}
					}
					setState(342);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(343);
				match(T__3);
				setState(344);
				match(T__29);
				_localctx.ast.add(new FunctionCall(((StatementContext)_localctx).ID.getLine(),((StatementContext)_localctx).ID.getCharPositionInLine()+1,new Variable(((StatementContext)_localctx).ID.getLine(),((StatementContext)_localctx).ID.getCharPositionInLine()+1,(((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)),ls));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(346);
				match(T__31);
				setState(347);
				((StatementContext)_localctx).a = expression(0);
				setState(348);
				match(T__4);
				setState(349);
				match(T__5);
				setState(350);
				((StatementContext)_localctx).l1 = listStatement();
				setState(351);
				match(T__6);
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l1.ast,null));
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(354);
				match(T__31);
				setState(355);
				((StatementContext)_localctx).a = expression(0);
				setState(356);
				match(T__4);
				setState(357);
				((StatementContext)_localctx).l2 = statement();
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l2.ast,null));
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(360);
				match(T__31);
				setState(361);
				((StatementContext)_localctx).a = expression(0);
				setState(362);
				match(T__4);
				{
				setState(363);
				match(T__5);
				setState(364);
				((StatementContext)_localctx).l3 = listStatement();
				setState(365);
				match(T__6);
				}
				setState(367);
				match(T__32);
				{
				setState(368);
				match(T__5);
				setState(369);
				((StatementContext)_localctx).s = listStatement();
				setState(370);
				match(T__6);
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l3.ast,((StatementContext)_localctx).s.ast));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(374);
				match(T__31);
				setState(375);
				((StatementContext)_localctx).a = expression(0);
				setState(376);
				match(T__4);
				{
				setState(377);
				match(T__5);
				setState(378);
				((StatementContext)_localctx).l5 = listStatement();
				setState(379);
				match(T__6);
				}
				setState(381);
				match(T__32);
				{
				setState(382);
				((StatementContext)_localctx).s1 = statement();
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l5.ast,((StatementContext)_localctx).s1.ast));
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(385);
				match(T__31);
				setState(386);
				((StatementContext)_localctx).a = expression(0);
				setState(387);
				match(T__4);
				{
				setState(388);
				((StatementContext)_localctx).l6 = statement();
				}
				setState(389);
				match(T__32);
				{
				setState(390);
				match(T__5);
				setState(391);
				((StatementContext)_localctx).s2 = listStatement();
				setState(392);
				match(T__6);
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l6.ast,((StatementContext)_localctx).s2.ast));
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(396);
				match(T__31);
				setState(397);
				((StatementContext)_localctx).a = expression(0);
				setState(398);
				match(T__4);
				{
				setState(399);
				((StatementContext)_localctx).l7 = statement();
				}
				setState(400);
				match(T__32);
				{
				setState(401);
				((StatementContext)_localctx).s3 = statement();
				}
				_localctx.ast.add(new IfElse((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l7.ast,((StatementContext)_localctx).s3.ast));
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(404);
				match(T__33);
				setState(405);
				((StatementContext)_localctx).a = expression(0);
				setState(406);
				match(T__4);
				setState(407);
				match(T__5);
				setState(408);
				((StatementContext)_localctx).l4 = listStatement();
				setState(409);
				match(T__6);
				_localctx.ast.add(new While((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l4.ast));
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(412);
				match(T__33);
				setState(413);
				((StatementContext)_localctx).a = expression(0);
				setState(414);
				match(T__4);
				setState(415);
				((StatementContext)_localctx).l9 = statement();
				_localctx.ast.add(new While((((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getLine(),(((StatementContext)_localctx).a!=null?(((StatementContext)_localctx).a.start):null).getCharPositionInLine()+1,((StatementContext)_localctx).a.ast,((StatementContext)_localctx).l9.ast));
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
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
			case 13:
				enterOuterAlt(_localctx, 13);
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
			case 14:
				enterOuterAlt(_localctx, 14);
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
			return precpred(_ctx, 16);
		case 6:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01b6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3*\n\3\f\3\16\3-\13\3\3\4\3\4\3\4\7\4\62\n\4\f\4\16\4"+
		"\65\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5>\n\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5F\n\5\f\5\16\5I\13\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6p\n\6\f\6\16\6s\13\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\177\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00a4\n\6\f\6\16\6\u00a7"+
		"\13\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00af\n\7\f\7\16\7\u00b2\13\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b\u00c1\n\b\r\b\16\b"+
		"\u00c2\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ce\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\7\t\u00d5\n\t\f\t\16\t\u00d8\13\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ea\n\13\f\13\16\13\u00ed"+
		"\13\13\3\f\3\f\3\f\3\f\3\f\7\f\u00f4\n\f\f\f\16\f\u00f7\13\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0104\n\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\7\r\u010d\n\r\f\r\16\r\u0110\13\r\3\r\3\r\3\r\7\r\u0115\n\r\f\r"+
		"\16\r\u0118\13\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0124\n\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u012c\n\r\f\r\16\r\u012f\13\r\3\r\3\r\3\r"+
		"\7\r\u0134\n\r\f\r\16\r\u0137\13\r\3\r\3\r\5\r\u013b\n\r\3\16\3\16\3\16"+
		"\7\16\u0140\n\16\f\16\16\16\u0143\13\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0155\n\17\f\17"+
		"\16\17\u0158\13\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u01b4\n\17\3\17"+
		"\2\3\n\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\5\3\2\17\21\4\2\f\f\22"+
		"\22\3\2\23\30\2\u01dc\2\36\3\2\2\2\4+\3\2\2\2\6\63\3\2\2\2\b\66\3\2\2"+
		"\2\n~\3\2\2\2\f\u00a8\3\2\2\2\16\u00cd\3\2\2\2\20\u00cf\3\2\2\2\22\u00de"+
		"\3\2\2\2\24\u00e3\3\2\2\2\26\u00ee\3\2\2\2\30\u013a\3\2\2\2\32\u0141\3"+
		"\2\2\2\34\u01b3\3\2\2\2\36\37\5\4\3\2\37 \5\b\5\2 !\7\2\2\3!\"\b\2\1\2"+
		"\"\3\3\2\2\2#$\5\20\t\2$%\b\3\1\2%*\3\2\2\2&\'\5\30\r\2\'(\b\3\1\2(*\3"+
		"\2\2\2)#\3\2\2\2)&\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2-+"+
		"\3\2\2\2./\5\30\r\2/\60\b\4\1\2\60\62\3\2\2\2\61.\3\2\2\2\62\65\3\2\2"+
		"\2\63\61\3\2\2\2\63\64\3\2\2\2\64\7\3\2\2\2\65\63\3\2\2\2\66\67\b\5\1"+
		"\2\678\7\3\2\289\7\4\2\29=\7\5\2\2:;\5\24\13\2;<\b\5\1\2<>\3\2\2\2=:\3"+
		"\2\2\2=>\3\2\2\2>?\3\2\2\2?@\7\6\2\2@A\7\7\2\2AG\7\b\2\2BC\5\20\t\2CD"+
		"\b\5\1\2DF\3\2\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HO\3\2\2\2I"+
		"G\3\2\2\2JK\5\34\17\2KL\b\5\1\2LN\3\2\2\2MJ\3\2\2\2NQ\3\2\2\2OM\3\2\2"+
		"\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\t\2\2ST\b\5\1\2T\t\3\2\2\2UV\b\6"+
		"\1\2VW\7\5\2\2WX\5\16\b\2XY\7\6\2\2YZ\5\n\6\21Z[\b\6\1\2[\177\3\2\2\2"+
		"\\]\7\5\2\2]^\5\n\6\2^_\7\6\2\2_`\b\6\1\2`\177\3\2\2\2ab\7\13\2\2bc\5"+
		"\n\6\17cd\b\6\1\2d\177\3\2\2\2ef\7\f\2\2fg\5\n\6\16gh\b\6\1\2h\177\3\2"+
		"\2\2ij\b\6\1\2jk\7-\2\2kq\7\5\2\2lm\5\f\7\2mn\b\6\1\2np\3\2\2\2ol\3\2"+
		"\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\6\2\2u\177"+
		"\b\6\1\2vw\7-\2\2w\177\b\6\1\2xy\7,\2\2y\177\b\6\1\2z{\7.\2\2{\177\b\6"+
		"\1\2|}\7+\2\2}\177\b\6\1\2~U\3\2\2\2~\\\3\2\2\2~a\3\2\2\2~e\3\2\2\2~i"+
		"\3\2\2\2~v\3\2\2\2~x\3\2\2\2~z\3\2\2\2~|\3\2\2\2\177\u00a5\3\2\2\2\u0080"+
		"\u0081\f\13\2\2\u0081\u0082\t\2\2\2\u0082\u0083\5\n\6\f\u0083\u0084\b"+
		"\6\1\2\u0084\u00a4\3\2\2\2\u0085\u0086\f\n\2\2\u0086\u0087\t\3\2\2\u0087"+
		"\u0088\5\n\6\13\u0088\u0089\b\6\1\2\u0089\u00a4\3\2\2\2\u008a\u008b\f"+
		"\t\2\2\u008b\u008c\t\4\2\2\u008c\u008d\5\n\6\n\u008d\u008e\b\6\1\2\u008e"+
		"\u00a4\3\2\2\2\u008f\u0090\f\b\2\2\u0090\u0091\7\31\2\2\u0091\u0092\5"+
		"\n\6\t\u0092\u0093\b\6\1\2\u0093\u00a4\3\2\2\2\u0094\u0095\f\7\2\2\u0095"+
		"\u0096\7\32\2\2\u0096\u0097\5\n\6\b\u0097\u0098\b\6\1\2\u0098\u00a4\3"+
		"\2\2\2\u0099\u009a\f\22\2\2\u009a\u009b\7\n\2\2\u009b\u009c\7-\2\2\u009c"+
		"\u00a4\b\6\1\2\u009d\u009e\f\r\2\2\u009e\u009f\7\r\2\2\u009f\u00a0\5\n"+
		"\6\2\u00a0\u00a1\7\16\2\2\u00a1\u00a2\b\6\1\2\u00a2\u00a4\3\2\2\2\u00a3"+
		"\u0080\3\2\2\2\u00a3\u0085\3\2\2\2\u00a3\u008a\3\2\2\2\u00a3\u008f\3\2"+
		"\2\2\u00a3\u0094\3\2\2\2\u00a3\u0099\3\2\2\2\u00a3\u009d\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\13\3\2\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\5\n\6\2\u00a9\u00b0\b\7\1\2\u00aa\u00ab"+
		"\7\33\2\2\u00ab\u00ac\5\n\6\2\u00ac\u00ad\b\7\1\2\u00ad\u00af\3\2\2\2"+
		"\u00ae\u00aa\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1"+
		"\3\2\2\2\u00b1\r\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b4\7\34\2\2\u00b4"+
		"\u00ce\b\b\1\2\u00b5\u00b6\7\35\2\2\u00b6\u00ce\b\b\1\2\u00b7\u00b8\7"+
		"\36\2\2\u00b8\u00ce\b\b\1\2\u00b9\u00ba\b\b\1\2\u00ba\u00bb\7\37\2\2\u00bb"+
		"\u00c0\7\b\2\2\u00bc\u00bd\5\26\f\2\u00bd\u00be\b\b\1\2\u00be\u00bf\7"+
		" \2\2\u00bf\u00c1\3\2\2\2\u00c0\u00bc\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\7\t"+
		"\2\2\u00c5\u00c6\b\b\1\2\u00c6\u00ce\3\2\2\2\u00c7\u00c8\7\r\2\2\u00c8"+
		"\u00c9\7,\2\2\u00c9\u00ca\7\16\2\2\u00ca\u00cb\5\16\b\2\u00cb\u00cc\b"+
		"\b\1\2\u00cc\u00ce\3\2\2\2\u00cd\u00b3\3\2\2\2\u00cd\u00b5\3\2\2\2\u00cd"+
		"\u00b7\3\2\2\2\u00cd\u00b9\3\2\2\2\u00cd\u00c7\3\2\2\2\u00ce\17\3\2\2"+
		"\2\u00cf\u00d0\7-\2\2\u00d0\u00d6\b\t\1\2\u00d1\u00d2\7\33\2\2\u00d2\u00d3"+
		"\7-\2\2\u00d3\u00d5\b\t\1\2\u00d4\u00d1\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d9\u00da\7\7\2\2\u00da\u00db\5\16\b\2\u00db\u00dc\7 \2\2\u00dc"+
		"\u00dd\b\t\1\2\u00dd\21\3\2\2\2\u00de\u00df\7-\2\2\u00df\u00e0\7\7\2\2"+
		"\u00e0\u00e1\5\16\b\2\u00e1\u00e2\b\n\1\2\u00e2\23\3\2\2\2\u00e3\u00e4"+
		"\5\22\n\2\u00e4\u00eb\b\13\1\2\u00e5\u00e6\7\33\2\2\u00e6\u00e7\5\22\n"+
		"\2\u00e7\u00e8\b\13\1\2\u00e8\u00ea\3\2\2\2\u00e9\u00e5\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\25\3\2\2"+
		"\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7-\2\2\u00ef\u00f5\b\f\1\2\u00f0\u00f1"+
		"\7\33\2\2\u00f1\u00f2\7-\2\2\u00f2\u00f4\b\f\1\2\u00f3\u00f0\3\2\2\2\u00f4"+
		"\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2"+
		"\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7\7\2\2\u00f9\u00fa\5\16\b\2\u00fa"+
		"\u00fb\b\f\1\2\u00fb\27\3\2\2\2\u00fc\u00fd\b\r\1\2\u00fd\u00fe\7\3\2"+
		"\2\u00fe\u00ff\7-\2\2\u00ff\u0103\7\5\2\2\u0100\u0101\5\24\13\2\u0101"+
		"\u0102\b\r\1\2\u0102\u0104\3\2\2\2\u0103\u0100\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\u0106\7\6\2\2\u0106\u0107\7\7\2\2\u0107"+
		"\u0108\5\16\b\2\u0108\u010e\7\b\2\2\u0109\u010a\5\20\t\2\u010a\u010b\b"+
		"\r\1\2\u010b\u010d\3\2\2\2\u010c\u0109\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0116\3\2\2\2\u0110\u010e\3\2"+
		"\2\2\u0111\u0112\5\34\17\2\u0112\u0113\b\r\1\2\u0113\u0115\3\2\2\2\u0114"+
		"\u0111\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2"+
		"\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a\7\t\2\2\u011a"+
		"\u011b\b\r\1\2\u011b\u013b\3\2\2\2\u011c\u011d\b\r\1\2\u011d\u011e\7\3"+
		"\2\2\u011e\u011f\7-\2\2\u011f\u0123\7\5\2\2\u0120\u0121\5\24\13\2\u0121"+
		"\u0122\b\r\1\2\u0122\u0124\3\2\2\2\u0123\u0120\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0126\7\6\2\2\u0126\u0127\7\7\2\2\u0127"+
		"\u012d\7\b\2\2\u0128\u0129\5\20\t\2\u0129\u012a\b\r\1\2\u012a\u012c\3"+
		"\2\2\2\u012b\u0128\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u0135\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\5\34"+
		"\17\2\u0131\u0132\b\r\1\2\u0132\u0134\3\2\2\2\u0133\u0130\3\2\2\2\u0134"+
		"\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\u0138\3\2"+
		"\2\2\u0137\u0135\3\2\2\2\u0138\u0139\7\t\2\2\u0139\u013b\b\r\1\2\u013a"+
		"\u00fc\3\2\2\2\u013a\u011c\3\2\2\2\u013b\31\3\2\2\2\u013c\u013d\5\34\17"+
		"\2\u013d\u013e\b\16\1\2\u013e\u0140\3\2\2\2\u013f\u013c\3\2\2\2\u0140"+
		"\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\33\3\2\2"+
		"\2\u0143\u0141\3\2\2\2\u0144\u0145\5\n\6\2\u0145\u0146\7!\2\2\u0146\u0147"+
		"\5\n\6\2\u0147\u0148\7 \2\2\u0148\u0149\b\17\1\2\u0149\u01b4\3\2\2\2\u014a"+
		"\u014b\5\20\t\2\u014b\u014c\7 \2\2\u014c\u014d\b\17\1\2\u014d\u01b4\3"+
		"\2\2\2\u014e\u014f\b\17\1\2\u014f\u0150\7-\2\2\u0150\u0156\7\5\2\2\u0151"+
		"\u0152\5\f\7\2\u0152\u0153\b\17\1\2\u0153\u0155\3\2\2\2\u0154\u0151\3"+
		"\2\2\2\u0155\u0158\3\2\2\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7\6\2\2\u015a\u015b\7 "+
		"\2\2\u015b\u01b4\b\17\1\2\u015c\u015d\7\"\2\2\u015d\u015e\5\n\6\2\u015e"+
		"\u015f\7\7\2\2\u015f\u0160\7\b\2\2\u0160\u0161\5\32\16\2\u0161\u0162\7"+
		"\t\2\2\u0162\u0163\b\17\1\2\u0163\u01b4\3\2\2\2\u0164\u0165\7\"\2\2\u0165"+
		"\u0166\5\n\6\2\u0166\u0167\7\7\2\2\u0167\u0168\5\34\17\2\u0168\u0169\b"+
		"\17\1\2\u0169\u01b4\3\2\2\2\u016a\u016b\7\"\2\2\u016b\u016c\5\n\6\2\u016c"+
		"\u016d\7\7\2\2\u016d\u016e\7\b\2\2\u016e\u016f\5\32\16\2\u016f\u0170\7"+
		"\t\2\2\u0170\u0171\3\2\2\2\u0171\u0172\7#\2\2\u0172\u0173\7\b\2\2\u0173"+
		"\u0174\5\32\16\2\u0174\u0175\7\t\2\2\u0175\u0176\3\2\2\2\u0176\u0177\b"+
		"\17\1\2\u0177\u01b4\3\2\2\2\u0178\u0179\7\"\2\2\u0179\u017a\5\n\6\2\u017a"+
		"\u017b\7\7\2\2\u017b\u017c\7\b\2\2\u017c\u017d\5\32\16\2\u017d\u017e\7"+
		"\t\2\2\u017e\u017f\3\2\2\2\u017f\u0180\7#\2\2\u0180\u0181\5\34\17\2\u0181"+
		"\u0182\b\17\1\2\u0182\u01b4\3\2\2\2\u0183\u0184\7\"\2\2\u0184\u0185\5"+
		"\n\6\2\u0185\u0186\7\7\2\2\u0186\u0187\5\34\17\2\u0187\u0188\7#\2\2\u0188"+
		"\u0189\7\b\2\2\u0189\u018a\5\32\16\2\u018a\u018b\7\t\2\2\u018b\u018c\3"+
		"\2\2\2\u018c\u018d\b\17\1\2\u018d\u01b4\3\2\2\2\u018e\u018f\7\"\2\2\u018f"+
		"\u0190\5\n\6\2\u0190\u0191\7\7\2\2\u0191\u0192\5\34\17\2\u0192\u0193\7"+
		"#\2\2\u0193\u0194\5\34\17\2\u0194\u0195\b\17\1\2\u0195\u01b4\3\2\2\2\u0196"+
		"\u0197\7$\2\2\u0197\u0198\5\n\6\2\u0198\u0199\7\7\2\2\u0199\u019a\7\b"+
		"\2\2\u019a\u019b\5\32\16\2\u019b\u019c\7\t\2\2\u019c\u019d\b\17\1\2\u019d"+
		"\u01b4\3\2\2\2\u019e\u019f\7$\2\2\u019f\u01a0\5\n\6\2\u01a0\u01a1\7\7"+
		"\2\2\u01a1\u01a2\5\34\17\2\u01a2\u01a3\b\17\1\2\u01a3\u01b4\3\2\2\2\u01a4"+
		"\u01a5\7%\2\2\u01a5\u01a6\5\f\7\2\u01a6\u01a7\7 \2\2\u01a7\u01a8\b\17"+
		"\1\2\u01a8\u01b4\3\2\2\2\u01a9\u01aa\7&\2\2\u01aa\u01ab\5\f\7\2\u01ab"+
		"\u01ac\7 \2\2\u01ac\u01ad\b\17\1\2\u01ad\u01b4\3\2\2\2\u01ae\u01af\7\'"+
		"\2\2\u01af\u01b0\5\n\6\2\u01b0\u01b1\7 \2\2\u01b1\u01b2\b\17\1\2\u01b2"+
		"\u01b4\3\2\2\2\u01b3\u0144\3\2\2\2\u01b3\u014a\3\2\2\2\u01b3\u014e\3\2"+
		"\2\2\u01b3\u015c\3\2\2\2\u01b3\u0164\3\2\2\2\u01b3\u016a\3\2\2\2\u01b3"+
		"\u0178\3\2\2\2\u01b3\u0183\3\2\2\2\u01b3\u018e\3\2\2\2\u01b3\u0196\3\2"+
		"\2\2\u01b3\u019e\3\2\2\2\u01b3\u01a4\3\2\2\2\u01b3\u01a9\3\2\2\2\u01b3"+
		"\u01ae\3\2\2\2\u01b4\35\3\2\2\2\34)+\63=GOq~\u00a3\u00a5\u00b0\u00c2\u00cd"+
		"\u00d6\u00eb\u00f5\u0103\u010e\u0116\u0123\u012d\u0135\u013a\u0141\u0156"+
		"\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}