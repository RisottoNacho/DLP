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
		LINE_COMMENT=1, COMMENT=2, WHITESPACE=3, INT_CONSTANT=4, ID=5, CHAR_CONSTANT=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LINE_COMMENT", "COMMENT", "WHITESPACE", "DIGIT", "LETTER", "INT_CONSTANT", 
		"ID", "CHAR_CONSTANT"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LINE_COMMENT", "COMMENT", "WHITESPACE", "INT_CONSTANT", "ID", "CHAR_CONSTANT"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bd\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\5\2\34\n\2\3\2\5\2\37\n\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\6\4\64"+
		"\n\4\r\4\16\4\65\3\4\3\4\3\5\3\5\3\6\3\6\3\7\6\7?\n\7\r\7\16\7@\3\b\3"+
		"\b\5\bE\n\b\3\b\3\b\3\b\7\bJ\n\b\f\b\16\bM\13\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\6\tU\n\t\r\t\16\tV\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tc\n\t"+
		"\4\27)\2\n\3\3\5\4\7\5\t\2\13\2\r\6\17\7\21\b\3\2\6\3\3\f\f\5\2\13\f\17"+
		"\17\"\"\3\2\62;\4\2C\\c|\2n\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\23\3\2\2\2\5\"\3\2\2\2\7\63\3\2\2\2"+
		"\t9\3\2\2\2\13;\3\2\2\2\r>\3\2\2\2\17D\3\2\2\2\21b\3\2\2\2\23\27\7%\2"+
		"\2\24\26\13\2\2\2\25\24\3\2\2\2\26\31\3\2\2\2\27\30\3\2\2\2\27\25\3\2"+
		"\2\2\30\33\3\2\2\2\31\27\3\2\2\2\32\34\7\17\2\2\33\32\3\2\2\2\33\34\3"+
		"\2\2\2\34\36\3\2\2\2\35\37\t\2\2\2\36\35\3\2\2\2\37 \3\2\2\2 !\b\2\2\2"+
		"!\4\3\2\2\2\"#\7$\2\2#$\7$\2\2$%\7$\2\2%)\3\2\2\2&(\13\2\2\2\'&\3\2\2"+
		"\2(+\3\2\2\2)*\3\2\2\2)\'\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7$\2\2-.\7$\2"+
		"\2./\7$\2\2/\60\3\2\2\2\60\61\b\3\2\2\61\6\3\2\2\2\62\64\t\3\2\2\63\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\b"+
		"\4\2\28\b\3\2\2\29:\t\4\2\2:\n\3\2\2\2;<\t\5\2\2<\f\3\2\2\2=?\t\4\2\2"+
		">=\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\16\3\2\2\2BE\7a\2\2CE\5\13\6"+
		"\2DB\3\2\2\2DC\3\2\2\2EK\3\2\2\2FJ\5\13\6\2GJ\5\t\5\2HJ\7a\2\2IF\3\2\2"+
		"\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\20\3\2\2\2MK\3\2"+
		"\2\2NO\7)\2\2OP\13\2\2\2Pc\7)\2\2QR\7)\2\2RT\7^\2\2SU\5\t\5\2TS\3\2\2"+
		"\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\7)\2\2Yc\3\2\2\2Z[\7)\2\2"+
		"[\\\7^\2\2\\]\7p\2\2]c\7)\2\2^_\7)\2\2_`\7^\2\2`a\7v\2\2ac\7)\2\2bN\3"+
		"\2\2\2bQ\3\2\2\2bZ\3\2\2\2b^\3\2\2\2c\22\3\2\2\2\16\2\27\33\36)\65@DI"+
		"KVb\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}