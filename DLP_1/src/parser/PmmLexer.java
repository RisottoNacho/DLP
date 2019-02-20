// Generated from src/parser/Pmm.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, LINE_COMMENT=8, 
		COMMENT=9, WHITESPACE=10, REAL_CONSTANT=11, INT_CONSTANT=12, ID=13, CHAR_CONSTANT=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "LINE_COMMENT", 
		"COMMENT", "WHITESPACE", "DIGIT", "LETTER", "EXPONENT", "REAL_CONSTANT", 
		"INT_CONSTANT", "ID", "CHAR_CONSTANT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'*'", "'/'", "'%'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "LINE_COMMENT", "COMMENT", 
		"WHITESPACE", "REAL_CONSTANT", "INT_CONSTANT", "ID", "CHAR_CONSTANT"
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


	public PmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20\u00b1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\7\t\66\n\t\f\t\16\t9\13\t\3\t\5\t<\n\t\3\t\5\t?\n\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\7\nH\n\n\f\n\16\nK\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\6\13T"+
		"\n\13\r\13\16\13U\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\5\16`\n\16\3\16"+
		"\6\16c\n\16\r\16\16\16d\3\17\6\17h\n\17\r\17\16\17i\3\17\3\17\3\17\7\17"+
		"o\n\17\f\17\16\17r\13\17\5\17t\n\17\3\17\6\17w\n\17\r\17\16\17x\3\17\3"+
		"\17\6\17}\n\17\r\17\16\17~\3\17\3\17\3\17\3\17\6\17\u0085\n\17\r\17\16"+
		"\17\u0086\5\17\u0089\n\17\3\20\6\20\u008c\n\20\r\20\16\20\u008d\3\21\3"+
		"\21\5\21\u0092\n\21\3\21\3\21\3\21\7\21\u0097\n\21\f\21\16\21\u009a\13"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\6\22\u00a2\n\22\r\22\16\22\u00a3\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b0\n\22\4\67I\2"+
		"\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\2\35\r"+
		"\37\16!\17#\20\3\2\b\3\3\f\f\5\2\13\f\17\17\"\"\3\2\62;\4\2C\\c|\4\2G"+
		"Ggg\4\2--//\2\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'"+
		"\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\13-\3\2\2\2\r/\3\2\2\2\17\61\3\2\2\2\21"+
		"\63\3\2\2\2\23B\3\2\2\2\25S\3\2\2\2\27Y\3\2\2\2\31[\3\2\2\2\33]\3\2\2"+
		"\2\35\u0088\3\2\2\2\37\u008b\3\2\2\2!\u0091\3\2\2\2#\u00af\3\2\2\2%&\7"+
		"?\2\2&\4\3\2\2\2\'(\7=\2\2(\6\3\2\2\2)*\7,\2\2*\b\3\2\2\2+,\7\61\2\2,"+
		"\n\3\2\2\2-.\7\'\2\2.\f\3\2\2\2/\60\7-\2\2\60\16\3\2\2\2\61\62\7/\2\2"+
		"\62\20\3\2\2\2\63\67\7%\2\2\64\66\13\2\2\2\65\64\3\2\2\2\669\3\2\2\2\67"+
		"8\3\2\2\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\2:<\7\17\2\2;:\3\2\2\2;<\3"+
		"\2\2\2<>\3\2\2\2=?\t\2\2\2>=\3\2\2\2?@\3\2\2\2@A\b\t\2\2A\22\3\2\2\2B"+
		"C\7$\2\2CD\7$\2\2DE\7$\2\2EI\3\2\2\2FH\13\2\2\2GF\3\2\2\2HK\3\2\2\2IJ"+
		"\3\2\2\2IG\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7$\2\2MN\7$\2\2NO\7$\2\2OP\3"+
		"\2\2\2PQ\b\n\2\2Q\24\3\2\2\2RT\t\3\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2U"+
		"V\3\2\2\2VW\3\2\2\2WX\b\13\2\2X\26\3\2\2\2YZ\t\4\2\2Z\30\3\2\2\2[\\\t"+
		"\5\2\2\\\32\3\2\2\2]_\t\6\2\2^`\t\7\2\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2"+
		"ac\5\27\f\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\34\3\2\2\2fh\5\27"+
		"\f\2gf\3\2\2\2hi\3\2\2\2ig\3\2\2\2ij\3\2\2\2js\3\2\2\2kt\5\33\16\2lp\7"+
		"\60\2\2mo\5\27\f\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qt\3\2\2\2r"+
		"p\3\2\2\2sk\3\2\2\2sl\3\2\2\2t\u0089\3\2\2\2uw\5\27\f\2vu\3\2\2\2wx\3"+
		"\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3\2\2\2z|\7\60\2\2{}\5\27\f\2|{\3\2\2\2}"+
		"~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\5\33\16"+
		"\2\u0081\u0089\3\2\2\2\u0082\u0084\7\60\2\2\u0083\u0085\5\27\f\2\u0084"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0089\3\2\2\2\u0088g\3\2\2\2\u0088v\3\2\2\2\u0088\u0082\3\2"+
		"\2\2\u0089\36\3\2\2\2\u008a\u008c\t\4\2\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e \3\2\2\2\u008f"+
		"\u0092\7a\2\2\u0090\u0092\5\31\r\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\u0098\3\2\2\2\u0093\u0097\5\31\r\2\u0094\u0097\5\27\f\2\u0095"+
		"\u0097\7a\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2"+
		"\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\"\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7)\2\2\u009c\u009d\13\2\2\2"+
		"\u009d\u00b0\7)\2\2\u009e\u009f\7)\2\2\u009f\u00a1\7^\2\2\u00a0\u00a2"+
		"\5\27\f\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2"+
		"\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7)\2\2\u00a6\u00b0"+
		"\3\2\2\2\u00a7\u00a8\7)\2\2\u00a8\u00a9\7^\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00b0\7)\2\2\u00ab\u00ac\7)\2\2\u00ac\u00ad\7^\2\2\u00ad\u00ae\7v\2\2"+
		"\u00ae\u00b0\7)\2\2\u00af\u009b\3\2\2\2\u00af\u009e\3\2\2\2\u00af\u00a7"+
		"\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0$\3\2\2\2\27\2\67;>IU_dipsx~\u0086\u0088"+
		"\u008d\u0091\u0096\u0098\u00a3\u00af\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}