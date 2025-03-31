// Generated from Webots.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class WebotsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, VALUE=7, INT=8, FLOAT=9, 
		WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "VALUE", "INT", "FLOAT", 
			"DIGIT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'AVANZA'", "'('", "','", "')'", "'\\n'", "'GIRA'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "VALUE", "INT", "FLOAT", "WS"
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


	public WebotsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Webots.g4"; }

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
		"\u0004\u0000\nW\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006.\b\u0006\u0001\u0007"+
		"\u0004\u00071\b\u0007\u000b\u0007\f\u00072\u0001\b\u0003\b6\b\b\u0001"+
		"\b\u0004\b9\b\b\u000b\b\f\b:\u0001\b\u0001\b\u0005\b?\b\b\n\b\f\bB\t\b"+
		"\u0001\b\u0003\bE\b\b\u0001\b\u0001\b\u0004\bI\b\b\u000b\b\f\bJ\u0003"+
		"\bM\b\b\u0001\t\u0001\t\u0001\n\u0004\nR\b\n\u000b\n\f\nS\u0001\n\u0001"+
		"\n\u0000\u0000\u000b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\u0000\u0015\n\u0001\u0000"+
		"\u0002\u0001\u000009\u0003\u0000\t\n\r\r  ^\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0001\u0017\u0001\u0000\u0000\u0000\u0003"+
		"\u001e\u0001\u0000\u0000\u0000\u0005 \u0001\u0000\u0000\u0000\u0007\""+
		"\u0001\u0000\u0000\u0000\t$\u0001\u0000\u0000\u0000\u000b&\u0001\u0000"+
		"\u0000\u0000\r-\u0001\u0000\u0000\u0000\u000f0\u0001\u0000\u0000\u0000"+
		"\u0011L\u0001\u0000\u0000\u0000\u0013N\u0001\u0000\u0000\u0000\u0015Q"+
		"\u0001\u0000\u0000\u0000\u0017\u0018\u0005A\u0000\u0000\u0018\u0019\u0005"+
		"V\u0000\u0000\u0019\u001a\u0005A\u0000\u0000\u001a\u001b\u0005N\u0000"+
		"\u0000\u001b\u001c\u0005Z\u0000\u0000\u001c\u001d\u0005A\u0000\u0000\u001d"+
		"\u0002\u0001\u0000\u0000\u0000\u001e\u001f\u0005(\u0000\u0000\u001f\u0004"+
		"\u0001\u0000\u0000\u0000 !\u0005,\u0000\u0000!\u0006\u0001\u0000\u0000"+
		"\u0000\"#\u0005)\u0000\u0000#\b\u0001\u0000\u0000\u0000$%\u0005\n\u0000"+
		"\u0000%\n\u0001\u0000\u0000\u0000&\'\u0005G\u0000\u0000\'(\u0005I\u0000"+
		"\u0000()\u0005R\u0000\u0000)*\u0005A\u0000\u0000*\f\u0001\u0000\u0000"+
		"\u0000+.\u0003\u000f\u0007\u0000,.\u0003\u0011\b\u0000-+\u0001\u0000\u0000"+
		"\u0000-,\u0001\u0000\u0000\u0000.\u000e\u0001\u0000\u0000\u0000/1\u0003"+
		"\u0013\t\u00000/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000023\u0001\u0000\u0000\u00003\u0010\u0001\u0000\u0000"+
		"\u000046\u0005-\u0000\u000054\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0001\u0000\u0000\u000079\u0003\u0013\t\u000087\u0001\u0000\u0000"+
		"\u00009:\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000"+
		"\u0000\u0000;<\u0001\u0000\u0000\u0000<@\u0005.\u0000\u0000=?\u0003\u0013"+
		"\t\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AM\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000CE\u0005-\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0005.\u0000\u0000GI\u0003"+
		"\u0013\t\u0000HG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"L5\u0001\u0000\u0000\u0000LD\u0001\u0000\u0000\u0000M\u0012\u0001\u0000"+
		"\u0000\u0000NO\u0007\u0000\u0000\u0000O\u0014\u0001\u0000\u0000\u0000"+
		"PR\u0007\u0001\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UV\u0006\n\u0000\u0000V\u0016\u0001\u0000\u0000\u0000\n\u0000"+
		"-25:@DJLS\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}