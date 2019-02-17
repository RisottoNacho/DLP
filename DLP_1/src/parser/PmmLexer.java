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
		LINE_COMMENT=1, COMMENT=2, WHITESPACE=3, REAL_CONSTANT=4, INT_CONSTANT=5, 
		ID=6, CHAR_CONSTANT=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LINE_COMMENT", "COMMENT", "WHITESPACE", "DIGIT", "LETTER", "EXPONENT", 
		"REAL_CONSTANT", "INT_CONSTANT", "ID", "CHAR_CONSTANT"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LINE_COMMENT", "COMMENT", "WHITESPACE", "REAL_CONSTANT", "INT_CONSTANT", 
		"ID", "CHAR_CONSTANT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u0095\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\5\2 \n\2\3\2\5\2#\n\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\6\48\n\4\r\4\16\49\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\5\7D\n\7\3"+
		"\7\6\7G\n\7\r\7\16\7H\3\b\6\bL\n\b\r\b\16\bM\3\b\3\b\3\b\7\bS\n\b\f\b"+
		"\16\bV\13\b\5\bX\n\b\3\b\6\b[\n\b\r\b\16\b\\\3\b\3\b\6\ba\n\b\r\b\16\b"+
		"b\3\b\3\b\3\b\3\b\6\bi\n\b\r\b\16\bj\5\bm\n\b\3\t\6\tp\n\t\r\t\16\tq\3"+
		"\n\3\n\5\nv\n\n\3\n\3\n\3\n\7\n{\n\n\f\n\16\n~\13\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\6\13\u0086\n\13\r\13\16\13\u0087\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\5\13\u0094\n\13\4\33-\2\f\3\3\5\4\7\5\t\2\13\2"+
		"\r\2\17\6\21\7\23\b\25\t\3\2\b\3\3\f\f\5\2\13\f\17\17\"\"\3\2\62;\4\2"+
		"C\\c|\4\2GGgg\4\2--//\2\u00a8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5&\3\2\2"+
		"\2\7\67\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17l\3\2\2\2\21o\3\2"+
		"\2\2\23u\3\2\2\2\25\u0093\3\2\2\2\27\33\7%\2\2\30\32\13\2\2\2\31\30\3"+
		"\2\2\2\32\35\3\2\2\2\33\34\3\2\2\2\33\31\3\2\2\2\34\37\3\2\2\2\35\33\3"+
		"\2\2\2\36 \7\17\2\2\37\36\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!#\t\2\2\2\"!"+
		"\3\2\2\2#$\3\2\2\2$%\b\2\2\2%\4\3\2\2\2&\'\7$\2\2\'(\7$\2\2()\7$\2\2)"+
		"-\3\2\2\2*,\13\2\2\2+*\3\2\2\2,/\3\2\2\2-.\3\2\2\2-+\3\2\2\2.\60\3\2\2"+
		"\2/-\3\2\2\2\60\61\7$\2\2\61\62\7$\2\2\62\63\7$\2\2\63\64\3\2\2\2\64\65"+
		"\b\3\2\2\65\6\3\2\2\2\668\t\3\2\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2\2"+
		"9:\3\2\2\2:;\3\2\2\2;<\b\4\2\2<\b\3\2\2\2=>\t\4\2\2>\n\3\2\2\2?@\t\5\2"+
		"\2@\f\3\2\2\2AC\t\6\2\2BD\t\7\2\2CB\3\2\2\2CD\3\2\2\2DF\3\2\2\2EG\5\t"+
		"\5\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\16\3\2\2\2JL\5\t\5\2KJ\3"+
		"\2\2\2LM\3\2\2\2MK\3\2\2\2MN\3\2\2\2NW\3\2\2\2OX\5\r\7\2PT\7\60\2\2QS"+
		"\5\t\5\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UX\3\2\2\2VT\3\2\2\2W"+
		"O\3\2\2\2WP\3\2\2\2Xm\3\2\2\2Y[\5\t\5\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2"+
		"\2\\]\3\2\2\2]^\3\2\2\2^`\7\60\2\2_a\5\t\5\2`_\3\2\2\2ab\3\2\2\2b`\3\2"+
		"\2\2bc\3\2\2\2cd\3\2\2\2de\5\r\7\2em\3\2\2\2fh\7\60\2\2gi\5\t\5\2hg\3"+
		"\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lK\3\2\2\2lZ\3\2\2\2lf\3"+
		"\2\2\2m\20\3\2\2\2np\t\4\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r"+
		"\22\3\2\2\2sv\7a\2\2tv\5\13\6\2us\3\2\2\2ut\3\2\2\2v|\3\2\2\2w{\5\13\6"+
		"\2x{\5\t\5\2y{\7a\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2"+
		"\2|}\3\2\2\2}\24\3\2\2\2~|\3\2\2\2\177\u0080\7)\2\2\u0080\u0081\13\2\2"+
		"\2\u0081\u0094\7)\2\2\u0082\u0083\7)\2\2\u0083\u0085\7^\2\2\u0084\u0086"+
		"\5\t\5\2\u0085\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\7)\2\2\u008a\u0094\3\2"+
		"\2\2\u008b\u008c\7)\2\2\u008c\u008d\7^\2\2\u008d\u008e\7p\2\2\u008e\u0094"+
		"\7)\2\2\u008f\u0090\7)\2\2\u0090\u0091\7^\2\2\u0091\u0092\7v\2\2\u0092"+
		"\u0094\7)\2\2\u0093\177\3\2\2\2\u0093\u0082\3\2\2\2\u0093\u008b\3\2\2"+
		"\2\u0093\u008f\3\2\2\2\u0094\26\3\2\2\2\27\2\33\37\"-9CHMTW\\bjlquz|\u0087"+
		"\u0093\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}