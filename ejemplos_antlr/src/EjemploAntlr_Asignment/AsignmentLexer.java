// Generated from Asignment.g4 by ANTLR 4.13.2

    package EjemploAntlr_Asignment;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AsignmentLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUNTO_Y_COMA=1, ASSIGN=2, ID=3, INT=4, FLOAT=5, STRING=6, SPACE=7, OTHER=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUNTO_Y_COMA", "ASSIGN", "ID", "INT", "FLOAT", "STRING", "SPACE", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUNTO_Y_COMA", "ASSIGN", "ID", "INT", "FLOAT", "STRING", "SPACE", 
			"OTHER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public AsignmentLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Asignment.g4"; }

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
		"\u0004\u0000\bF\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0018\b\u0002\n\u0002\f\u0002\u001b\t\u0002\u0001"+
		"\u0003\u0004\u0003\u001e\b\u0003\u000b\u0003\f\u0003\u001f\u0001\u0004"+
		"\u0004\u0004#\b\u0004\u000b\u0004\f\u0004$\u0001\u0004\u0001\u0004\u0005"+
		"\u0004)\b\u0004\n\u0004\f\u0004,\t\u0004\u0001\u0004\u0001\u0004\u0004"+
		"\u00040\b\u0004\u000b\u0004\f\u00041\u0003\u00044\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005:\b\u0005\n\u0005\f\u0005"+
		"=\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0000\u0000\b\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0001\u0000"+
		"\u0005\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003\u0000"+
		"\n\n\r\r\"\"\u0003\u0000\t\n\r\r  M\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0001\u0011\u0001\u0000\u0000\u0000\u0003\u0013"+
		"\u0001\u0000\u0000\u0000\u0005\u0015\u0001\u0000\u0000\u0000\u0007\u001d"+
		"\u0001\u0000\u0000\u0000\t3\u0001\u0000\u0000\u0000\u000b5\u0001\u0000"+
		"\u0000\u0000\r@\u0001\u0000\u0000\u0000\u000fD\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0005;\u0000\u0000\u0012\u0002\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0005=\u0000\u0000\u0014\u0004\u0001\u0000\u0000\u0000\u0015\u0019"+
		"\u0007\u0000\u0000\u0000\u0016\u0018\u0007\u0001\u0000\u0000\u0017\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017"+
		"\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0006"+
		"\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001e"+
		"\u0007\u0002\u0000\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e\u001f"+
		"\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \b\u0001\u0000\u0000\u0000!#\u0007\u0002\u0000\u0000"+
		"\"!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&*\u0005.\u0000"+
		"\u0000\')\u0007\u0002\u0000\u0000(\'\u0001\u0000\u0000\u0000),\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+4\u0001"+
		"\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-/\u0005.\u0000\u0000.0\u0007"+
		"\u0002\u0000\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000"+
		"\u00003\"\u0001\u0000\u0000\u00003-\u0001\u0000\u0000\u00004\n\u0001\u0000"+
		"\u0000\u00005;\u0005\"\u0000\u00006:\b\u0003\u0000\u000078\u0005\"\u0000"+
		"\u00008:\u0005\"\u0000\u000096\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000"+
		"\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005"+
		"\"\u0000\u0000?\f\u0001\u0000\u0000\u0000@A\u0007\u0004\u0000\u0000AB"+
		"\u0001\u0000\u0000\u0000BC\u0006\u0006\u0000\u0000C\u000e\u0001\u0000"+
		"\u0000\u0000DE\t\u0000\u0000\u0000E\u0010\u0001\u0000\u0000\u0000\t\u0000"+
		"\u0019\u001f$*139;\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}