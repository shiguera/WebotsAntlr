// Generated from Mu.g4 by ANTLR 4.13.2

    package EjemploAntlr_IFWHILE;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MuLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OR=1, AND=2, EQ=3, NEQ=4, GT=5, LT=6, GTEQ=7, LTEQ=8, PLUS=9, MINUS=10, 
		MULT=11, DIV=12, MOD=13, POW=14, NOT=15, PUNTO_Y_COMA=16, ASSIGN=17, ABRE_PARENTESIS=18, 
		CIERRA_PARENTESIS=19, ABRE_LLAVE=20, CIERRA_LLAVE=21, TRUE=22, FALSE=23, 
		NIL=24, IF=25, ELSE=26, WHILE=27, LOG=28, ID=29, INT=30, FLOAT=31, STRING=32, 
		COMMENT=33, SPACE=34, OTHER=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "PUNTO_Y_COMA", "ASSIGN", "ABRE_PARENTESIS", 
			"CIERRA_PARENTESIS", "ABRE_LLAVE", "CIERRA_LLAVE", "TRUE", "FALSE", "NIL", 
			"IF", "ELSE", "WHILE", "LOG", "ID", "INT", "FLOAT", "STRING", "COMMENT", 
			"SPACE", "OTHER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'||'", "'&&'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'^'", "'!'", "';'", "'='", "'('", "')'", 
			"'{'", "'}'", "'true'", "'false'", "'nil'", "'if'", "'else'", "'while'", 
			"'log'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "OR", "AND", "EQ", "NEQ", "GT", "LT", "GTEQ", "LTEQ", "PLUS", "MINUS", 
			"MULT", "DIV", "MOD", "POW", "NOT", "PUNTO_Y_COMA", "ASSIGN", "ABRE_PARENTESIS", 
			"CIERRA_PARENTESIS", "ABRE_LLAVE", "CIERRA_LLAVE", "TRUE", "FALSE", "NIL", 
			"IF", "ELSE", "WHILE", "LOG", "ID", "INT", "FLOAT", "STRING", "COMMENT", 
			"SPACE", "OTHER"
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


	public MuLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mu.g4"; }

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
		"\u0004\u0000#\u00d2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0005\u001c\u009b\b\u001c\n\u001c"+
		"\f\u001c\u009e\t\u001c\u0001\u001d\u0004\u001d\u00a1\b\u001d\u000b\u001d"+
		"\f\u001d\u00a2\u0001\u001e\u0004\u001e\u00a6\b\u001e\u000b\u001e\f\u001e"+
		"\u00a7\u0001\u001e\u0001\u001e\u0005\u001e\u00ac\b\u001e\n\u001e\f\u001e"+
		"\u00af\t\u001e\u0001\u001e\u0001\u001e\u0004\u001e\u00b3\b\u001e\u000b"+
		"\u001e\f\u001e\u00b4\u0003\u001e\u00b7\b\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u00bd\b\u001f\n\u001f\f\u001f\u00c0"+
		"\t\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0005 \u00c6\b \n \f \u00c9"+
		"\t \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0000\u0000"+
		"#\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#\u0001"+
		"\u0000\u0006\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000009\u0003"+
		"\u0000\n\n\r\r\"\"\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u00da\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"+
		"\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"+
		"\u0001G\u0001\u0000\u0000\u0000\u0003J\u0001\u0000\u0000\u0000\u0005M"+
		"\u0001\u0000\u0000\u0000\u0007P\u0001\u0000\u0000\u0000\tS\u0001\u0000"+
		"\u0000\u0000\u000bU\u0001\u0000\u0000\u0000\rW\u0001\u0000\u0000\u0000"+
		"\u000fZ\u0001\u0000\u0000\u0000\u0011]\u0001\u0000\u0000\u0000\u0013_"+
		"\u0001\u0000\u0000\u0000\u0015a\u0001\u0000\u0000\u0000\u0017c\u0001\u0000"+
		"\u0000\u0000\u0019e\u0001\u0000\u0000\u0000\u001bg\u0001\u0000\u0000\u0000"+
		"\u001di\u0001\u0000\u0000\u0000\u001fk\u0001\u0000\u0000\u0000!m\u0001"+
		"\u0000\u0000\u0000#o\u0001\u0000\u0000\u0000%q\u0001\u0000\u0000\u0000"+
		"\'s\u0001\u0000\u0000\u0000)u\u0001\u0000\u0000\u0000+w\u0001\u0000\u0000"+
		"\u0000-|\u0001\u0000\u0000\u0000/\u0082\u0001\u0000\u0000\u00001\u0086"+
		"\u0001\u0000\u0000\u00003\u0089\u0001\u0000\u0000\u00005\u008e\u0001\u0000"+
		"\u0000\u00007\u0094\u0001\u0000\u0000\u00009\u0098\u0001\u0000\u0000\u0000"+
		";\u00a0\u0001\u0000\u0000\u0000=\u00b6\u0001\u0000\u0000\u0000?\u00b8"+
		"\u0001\u0000\u0000\u0000A\u00c3\u0001\u0000\u0000\u0000C\u00cc\u0001\u0000"+
		"\u0000\u0000E\u00d0\u0001\u0000\u0000\u0000GH\u0005|\u0000\u0000HI\u0005"+
		"|\u0000\u0000I\u0002\u0001\u0000\u0000\u0000JK\u0005&\u0000\u0000KL\u0005"+
		"&\u0000\u0000L\u0004\u0001\u0000\u0000\u0000MN\u0005=\u0000\u0000NO\u0005"+
		"=\u0000\u0000O\u0006\u0001\u0000\u0000\u0000PQ\u0005!\u0000\u0000QR\u0005"+
		"=\u0000\u0000R\b\u0001\u0000\u0000\u0000ST\u0005>\u0000\u0000T\n\u0001"+
		"\u0000\u0000\u0000UV\u0005<\u0000\u0000V\f\u0001\u0000\u0000\u0000WX\u0005"+
		">\u0000\u0000XY\u0005=\u0000\u0000Y\u000e\u0001\u0000\u0000\u0000Z[\u0005"+
		"<\u0000\u0000[\\\u0005=\u0000\u0000\\\u0010\u0001\u0000\u0000\u0000]^"+
		"\u0005+\u0000\u0000^\u0012\u0001\u0000\u0000\u0000_`\u0005-\u0000\u0000"+
		"`\u0014\u0001\u0000\u0000\u0000ab\u0005*\u0000\u0000b\u0016\u0001\u0000"+
		"\u0000\u0000cd\u0005/\u0000\u0000d\u0018\u0001\u0000\u0000\u0000ef\u0005"+
		"%\u0000\u0000f\u001a\u0001\u0000\u0000\u0000gh\u0005^\u0000\u0000h\u001c"+
		"\u0001\u0000\u0000\u0000ij\u0005!\u0000\u0000j\u001e\u0001\u0000\u0000"+
		"\u0000kl\u0005;\u0000\u0000l \u0001\u0000\u0000\u0000mn\u0005=\u0000\u0000"+
		"n\"\u0001\u0000\u0000\u0000op\u0005(\u0000\u0000p$\u0001\u0000\u0000\u0000"+
		"qr\u0005)\u0000\u0000r&\u0001\u0000\u0000\u0000st\u0005{\u0000\u0000t"+
		"(\u0001\u0000\u0000\u0000uv\u0005}\u0000\u0000v*\u0001\u0000\u0000\u0000"+
		"wx\u0005t\u0000\u0000xy\u0005r\u0000\u0000yz\u0005u\u0000\u0000z{\u0005"+
		"e\u0000\u0000{,\u0001\u0000\u0000\u0000|}\u0005f\u0000\u0000}~\u0005a"+
		"\u0000\u0000~\u007f\u0005l\u0000\u0000\u007f\u0080\u0005s\u0000\u0000"+
		"\u0080\u0081\u0005e\u0000\u0000\u0081.\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005n\u0000\u0000\u0083\u0084\u0005i\u0000\u0000\u0084\u0085\u0005l"+
		"\u0000\u0000\u00850\u0001\u0000\u0000\u0000\u0086\u0087\u0005i\u0000\u0000"+
		"\u0087\u0088\u0005f\u0000\u0000\u00882\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005e\u0000\u0000\u008a\u008b\u0005l\u0000\u0000\u008b\u008c\u0005s"+
		"\u0000\u0000\u008c\u008d\u0005e\u0000\u0000\u008d4\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0005w\u0000\u0000\u008f\u0090\u0005h\u0000\u0000\u0090\u0091"+
		"\u0005i\u0000\u0000\u0091\u0092\u0005l\u0000\u0000\u0092\u0093\u0005e"+
		"\u0000\u0000\u00936\u0001\u0000\u0000\u0000\u0094\u0095\u0005l\u0000\u0000"+
		"\u0095\u0096\u0005o\u0000\u0000\u0096\u0097\u0005g\u0000\u0000\u00978"+
		"\u0001\u0000\u0000\u0000\u0098\u009c\u0007\u0000\u0000\u0000\u0099\u009b"+
		"\u0007\u0001\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d:\u0001\u0000\u0000\u0000\u009e\u009c\u0001"+
		"\u0000\u0000\u0000\u009f\u00a1\u0007\u0002\u0000\u0000\u00a0\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3<\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u0007\u0002\u0000\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00ad\u0005.\u0000\u0000\u00aa\u00ac\u0007\u0002\u0000"+
		"\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000"+
		"\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ae\u00b7\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b2\u0005.\u0000\u0000\u00b1\u00b3\u0007\u0002\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00a5\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b0\u0001\u0000\u0000\u0000\u00b7>\u0001\u0000\u0000\u0000\u00b8"+
		"\u00be\u0005\"\u0000\u0000\u00b9\u00bd\b\u0003\u0000\u0000\u00ba\u00bb"+
		"\u0005\"\u0000\u0000\u00bb\u00bd\u0005\"\u0000\u0000\u00bc\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001"+
		"\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0005\"\u0000\u0000\u00c2@\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c7\u0005#\u0000\u0000\u00c4\u00c6\b\u0004\u0000"+
		"\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c9\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000"+
		"\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0006 \u0000\u0000\u00cbB\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0007\u0005\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0006!\u0000\u0000\u00cfD\u0001\u0000\u0000\u0000\u00d0\u00d1\t"+
		"\u0000\u0000\u0000\u00d1F\u0001\u0000\u0000\u0000\n\u0000\u009c\u00a2"+
		"\u00a7\u00ad\u00b4\u00b6\u00bc\u00be\u00c7\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}