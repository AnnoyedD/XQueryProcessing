// Generated from yili_yu/edu/ucsd/yili_yu/XQuery.g4 by ANTLR 4.3
package yili_yu.edu.ucsd.yili_yu;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__33=1, T__32=2, T__31=3, T__30=4, T__29=5, T__28=6, T__27=7, T__26=8, 
		T__25=9, T__24=10, T__23=11, T__22=12, T__21=13, T__20=14, T__19=15, T__18=16, 
		T__17=17, T__16=18, T__15=19, T__14=20, T__13=21, T__12=22, T__11=23, 
		T__10=24, T__9=25, T__8=26, T__7=27, T__6=28, T__5=29, T__4=30, T__3=31, 
		T__2=32, T__1=33, T__0=34, Var=35, TagName=36, StringConstant=37, WS=38;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'"
	};
	public static final String[] ruleNames = {
		"T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", 
		"T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", 
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "Var", "TagName", "Letter", "LetterOrDigit", "StringConstant", 
		"StringCharacters", "StringCharacter", "WS"
	};


	public XQueryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2(\u00f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3"+
		"\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\7%\u00d4\n%\f%\16%\u00d7\13"+
		"%\3&\3&\3\'\3\'\3(\3(\5(\u00df\n(\3(\3(\3)\6)\u00e4\n)\r)\16)\u00e5\3"+
		"*\3*\3+\6+\u00eb\n+\r+\16+\u00ec\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2O\'Q\2"+
		"S\2U(\3\2\6\5\2C\\aac|\7\2//\62;C\\aac|\5\2$$BB^^\5\2\13\f\17\17\"\"\u00ef"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2O\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y\3\2\2\2\7^\3\2\2\2\t"+
		"e\3\2\2\2\13l\3\2\2\2\rn\3\2\2\2\17q\3\2\2\2\21v\3\2\2\2\23x\3\2\2\2\25"+
		"z\3\2\2\2\27~\3\2\2\2\31\u0081\3\2\2\2\33\u008b\3\2\2\2\35\u008e\3\2\2"+
		"\2\37\u0090\3\2\2\2!\u0093\3\2\2\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099"+
		"\3\2\2\2)\u009c\3\2\2\2+\u00a1\3\2\2\2-\u00a3\3\2\2\2/\u00a6\3\2\2\2\61"+
		"\u00a8\3\2\2\2\63\u00ab\3\2\2\2\65\u00ad\3\2\2\2\67\u00af\3\2\2\29\u00b1"+
		"\3\2\2\2;\u00b4\3\2\2\2=\u00ba\3\2\2\2?\u00be\3\2\2\2A\u00c1\3\2\2\2C"+
		"\u00c3\3\2\2\2E\u00c7\3\2\2\2G\u00ce\3\2\2\2I\u00d1\3\2\2\2K\u00d8\3\2"+
		"\2\2M\u00da\3\2\2\2O\u00dc\3\2\2\2Q\u00e3\3\2\2\2S\u00e7\3\2\2\2U\u00ea"+
		"\3\2\2\2WX\7\61\2\2X\4\3\2\2\2YZ\7u\2\2Z[\7q\2\2[\\\7o\2\2\\]\7g\2\2]"+
		"\6\3\2\2\2^_\7v\2\2_`\7g\2\2`a\7z\2\2ab\7v\2\2bc\7*\2\2cd\7+\2\2d\b\3"+
		"\2\2\2ef\7t\2\2fg\7g\2\2gh\7v\2\2hi\7w\2\2ij\7t\2\2jk\7p\2\2k\n\3\2\2"+
		"\2lm\7}\2\2m\f\3\2\2\2no\7\60\2\2op\7\60\2\2p\16\3\2\2\2qr\7f\2\2rs\7"+
		"q\2\2st\7e\2\2tu\7*\2\2u\20\3\2\2\2vw\7?\2\2w\22\3\2\2\2xy\7\177\2\2y"+
		"\24\3\2\2\2z{\7h\2\2{|\7q\2\2|}\7t\2\2}\26\3\2\2\2~\177\7<\2\2\177\u0080"+
		"\7?\2\2\u0080\30\3\2\2\2\u0081\u0082\7u\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7k\2\2\u0085\u0086\7u\2\2\u0086\u0087\7h\2\2\u0087"+
		"\u0088\7k\2\2\u0088\u0089\7g\2\2\u0089\u008a\7u\2\2\u008a\32\3\2\2\2\u008b"+
		"\u008c\7g\2\2\u008c\u008d\7s\2\2\u008d\34\3\2\2\2\u008e\u008f\7*\2\2\u008f"+
		"\36\3\2\2\2\u0090\u0091\7k\2\2\u0091\u0092\7u\2\2\u0092 \3\2\2\2\u0093"+
		"\u0094\7,\2\2\u0094\"\3\2\2\2\u0095\u0096\7.\2\2\u0096$\3\2\2\2\u0097"+
		"\u0098\7\60\2\2\u0098&\3\2\2\2\u0099\u009a\7>\2\2\u009a\u009b\7\61\2\2"+
		"\u009b(\3\2\2\2\u009c\u009d\7p\2\2\u009d\u009e\7q\2\2\u009e\u009f\7v\2"+
		"\2\u009f\u00a0\7\"\2\2\u00a0*\3\2\2\2\u00a1\u00a2\7]\2\2\u00a2,\3\2\2"+
		"\2\u00a3\u00a4\7?\2\2\u00a4\u00a5\7?\2\2\u00a5.\3\2\2\2\u00a6\u00a7\7"+
		">\2\2\u00a7\60\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00aa\7\61\2\2\u00aa"+
		"\62\3\2\2\2\u00ab\u00ac\7_\2\2\u00ac\64\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae"+
		"\66\3\2\2\2\u00af\u00b0\7B\2\2\u00b08\3\2\2\2\u00b1\u00b2\7q\2\2\u00b2"+
		"\u00b3\7t\2\2\u00b3:\3\2\2\2\u00b4\u00b5\7y\2\2\u00b5\u00b6\7j\2\2\u00b6"+
		"\u00b7\7g\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9<\3\2\2\2\u00ba"+
		"\u00bb\7n\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7v\2\2\u00bd>\3\2\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0@\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2"+
		"B\3\2\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7f\2\2\u00c6"+
		"D\3\2\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7o\2\2\u00c9\u00ca\7r\2\2\u00ca"+
		"\u00cb\7v\2\2\u00cb\u00cc\7{\2\2\u00cc\u00cd\7*\2\2\u00cdF\3\2\2\2\u00ce"+
		"\u00cf\7&\2\2\u00cf\u00d0\5I%\2\u00d0H\3\2\2\2\u00d1\u00d5\5K&\2\u00d2"+
		"\u00d4\5M\'\2\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6J\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9"+
		"\t\2\2\2\u00d9L\3\2\2\2\u00da\u00db\t\3\2\2\u00dbN\3\2\2\2\u00dc\u00de"+
		"\7$\2\2\u00dd\u00df\5Q)\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1P\3\2\2\2\u00e2\u00e4\5S*\2\u00e3"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6R\3\2\2\2\u00e7\u00e8\n\4\2\2\u00e8T\3\2\2\2\u00e9\u00eb\t\5"+
		"\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef\b+\2\2\u00efV\3\2\2\2\7"+
		"\2\u00d5\u00de\u00e5\u00ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}