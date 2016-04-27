// Generated from yili_yu/edu/ucsd/yili_yu/XQuery.g4 by ANTLR 4.3
package yili_yu.edu.ucsd.yili_yu;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__35=1, T__34=2, T__33=3, T__32=4, T__31=5, T__30=6, T__29=7, T__28=8, 
		T__27=9, T__26=10, T__25=11, T__24=12, T__23=13, T__22=14, T__21=15, T__20=16, 
		T__19=17, T__18=18, T__17=19, T__16=20, T__15=21, T__14=22, T__13=23, 
		T__12=24, T__11=25, T__10=26, T__9=27, T__8=28, T__7=29, T__6=30, T__5=31, 
		T__4=32, T__3=33, T__2=34, T__1=35, T__0=36, Var=37, TagName=38, StringConstant=39, 
		WS=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'some'", "'text()'", "'return'", "'{'", "'..'", "'='", 
		"'}'", "'for'", "':='", "'satisfies'", "'eq'", "'('", "'is'", "'*'", "','", 
		"'.'", "'</'", "'not '", "'['", "'=='", "'<'", "'//'", "']'", "'>'", "'@'", 
		"'or'", "'where'", "'let'", "'document'", "'in'", "')'", "'and'", "'not'", 
		"'doc'", "'empty('", "Var", "TagName", "StringConstant", "WS"
	};
	public static final int
		RULE_xq = 0, RULE_forClause = 1, RULE_letClause = 2, RULE_whereClause = 3, 
		RULE_returnClause = 4, RULE_cond = 5, RULE_ap = 6, RULE_rp = 7, RULE_f = 8;
	public static final String[] ruleNames = {
		"xq", "forClause", "letClause", "whereClause", "returnClause", "cond", 
		"ap", "rp", "f"
	};

	@Override
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqApContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XqApContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqAp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqVarContext extends XqContext {
		public TerminalNode Var() { return getToken(XQueryParser.Var, 0); }
		public XqVarContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqParenExprContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqParenExprContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqFLWRContext extends XqContext {
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqFLWRContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqFLWR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqFLWR(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqFLWR(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqTagNameContext extends XqContext {
		public Token open;
		public Token close;
		public TerminalNode TagName(int i) {
			return getToken(XQueryParser.TagName, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public List<TerminalNode> TagName() { return getTokens(XQueryParser.TagName); }
		public XqTagNameContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSlashContext extends XqContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqSlashContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSlashSlashContext extends XqContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqSlashSlashContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqSlashSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqSlashSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqSlashSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqConcatContext extends XqContext {
		public XqContext left;
		public XqContext right;
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqConcatContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqLetContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqLetContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqStringConstantContext extends XqContext {
		public TerminalNode StringConstant() { return getToken(XQueryParser.StringConstant, 0); }
		public XqStringConstantContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXqStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXqStringConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitXqStringConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			switch (_input.LA(1)) {
			case T__7:
				{
				_localctx = new XqLetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(19); letClause();
				setState(20); xq(1);
				}
				break;
			case Var:
				{
				_localctx = new XqVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22); match(Var);
				}
				break;
			case StringConstant:
				{
				_localctx = new XqStringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23); match(StringConstant);
				}
				break;
			case T__6:
			case T__1:
				{
				_localctx = new XqApContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24); ap();
				}
				break;
			case T__23:
				{
				_localctx = new XqParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25); match(T__23);
				setState(26); xq(0);
				setState(27); match(T__4);
				}
				break;
			case T__14:
				{
				_localctx = new XqTagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(29); match(T__14);
				setState(30); ((XqTagNameContext)_localctx).open = match(TagName);
				setState(31); match(T__11);
				setState(32); match(T__31);
				setState(33); xq(0);
				setState(34); match(T__28);
				setState(35); match(T__18);
				setState(36); ((XqTagNameContext)_localctx).close = match(TagName);
				setState(37); match(T__11);
				}
				break;
			case T__27:
				{
				_localctx = new XqFLWRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39); forClause();
				setState(41);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(40); letClause();
					}
				}

				setState(44);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(43); whereClause();
					}
				}

				setState(46); returnClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(59);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqConcatContext(new XqContext(_parentctx, _parentState));
						((XqConcatContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(50);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(51); match(T__20);
						setState(52); ((XqConcatContext)_localctx).right = xq(7);
						}
						break;

					case 2:
						{
						_localctx = new XqSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(53);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(54); match(T__35);
						setState(55); rp(0);
						}
						break;

					case 3:
						{
						_localctx = new XqSlashSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(56);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(57); match(T__13);
						setState(58); rp(0);
						}
						break;
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class ForClauseContext extends ParserRuleContext {
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode Var(int i) {
			return getToken(XQueryParser.Var, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public List<TerminalNode> Var() { return getTokens(XQueryParser.Var); }
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(T__27);
			setState(65); match(Var);
			setState(66); match(T__5);
			setState(67); xq(0);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(68); match(T__20);
				setState(69); match(Var);
				setState(70); match(T__5);
				setState(71); xq(0);
				}
				}
				setState(76);
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

	public static class LetClauseContext extends ParserRuleContext {
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode Var(int i) {
			return getToken(XQueryParser.Var, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public List<TerminalNode> Var() { return getTokens(XQueryParser.Var); }
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77); match(T__7);
			setState(78); match(Var);
			setState(79); match(T__26);
			setState(80); xq(0);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(81); match(T__20);
				setState(82); match(Var);
				setState(83); match(T__26);
				setState(84); xq(0);
				}
				}
				setState(89);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); match(T__8);
			setState(91); cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(T__32);
			setState(94); xq(0);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondEmptyContext extends CondContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public CondEmptyContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondValEqualContext extends CondContext {
		public XqContext left;
		public XqContext right;
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public CondValEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondValEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondValEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondValEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondSomeSatisContext extends CondContext {
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode Var(int i) {
			return getToken(XQueryParser.Var, i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<TerminalNode> Var() { return getTokens(XQueryParser.Var); }
		public CondSomeSatisContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondSomeSatis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondSomeSatis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondSomeSatis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondIdEqualContext extends CondContext {
		public XqContext left;
		public XqContext right;
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public CondIdEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondIdEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondIdEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondIdEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondParenExprContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondParenExprContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondAndContext extends CondContext {
		public CondContext left;
		public CondContext right;
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondAndContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondOrContext extends CondContext {
		public CondContext left;
		public CondContext right;
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondOrContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondNotContext extends CondContext {
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondNotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCondNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCondNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitCondNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new CondSomeSatisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(97); match(T__34);
				setState(98); match(Var);
				setState(99); match(T__5);
				setState(100); xq(0);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(101); match(T__20);
					setState(102); match(Var);
					setState(103); match(T__5);
					setState(104); xq(0);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110); match(T__25);
				setState(111); cond(5);
				}
				break;

			case 2:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); match(T__17);
				setState(114); cond(1);
				}
				break;

			case 3:
				{
				_localctx = new CondValEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115); ((CondValEqualContext)_localctx).left = xq(0);
				setState(116);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(117); ((CondValEqualContext)_localctx).right = xq(0);
				}
				break;

			case 4:
				{
				_localctx = new CondIdEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119); ((CondIdEqualContext)_localctx).left = xq(0);
				setState(120);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(121); ((CondIdEqualContext)_localctx).right = xq(0);
				}
				break;

			case 5:
				{
				_localctx = new CondEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123); match(T__0);
				setState(124); xq(0);
				setState(125); match(T__4);
				}
				break;

			case 6:
				{
				_localctx = new CondParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127); match(T__23);
				setState(128); cond(0);
				setState(129); match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(141);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(139);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new CondContext(_parentctx, _parentState));
						((CondAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(133);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(134); match(T__3);
						setState(135); ((CondAndContext)_localctx).right = cond(4);
						}
						break;

					case 2:
						{
						_localctx = new CondOrContext(new CondContext(_parentctx, _parentState));
						((CondOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(136);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(137); match(T__9);
						setState(138); ((CondOrContext)_localctx).right = cond(3);
						}
						break;
					}
					} 
				}
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApSlashContext extends ApContext {
		public Token fileName;
		public Token slash;
		public TerminalNode StringConstant() { return getToken(XQueryParser.StringConstant, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ApSlashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterApSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitApSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitApSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ap);
		int _la;
		try {
			_localctx = new ApSlashContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(145); match(T__23);
			setState(146); ((ApSlashContext)_localctx).fileName = match(StringConstant);
			setState(147); match(T__4);
			setState(148);
			((ApSlashContext)_localctx).slash = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__13) ) {
				((ApSlashContext)_localctx).slash = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(149); rp(0);
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RpDotContext extends RpContext {
		public RpDotContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpTextContext extends RpContext {
		public RpTextContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpDotDotContext extends RpContext {
		public RpDotDotContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpDotDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpDotDot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpDotDot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpSlashContext extends RpContext {
		public RpContext left;
		public Token slash;
		public RpContext right;
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpSlashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpConcatContext extends RpContext {
		public RpContext left;
		public RpContext right;
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpConcatContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpTagNameContext extends RpContext {
		public TerminalNode TagName() { return getToken(XQueryParser.TagName, 0); }
		public RpTagNameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpTagName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpFilterContext extends RpContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpWildcardContext extends RpContext {
		public RpWildcardContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpWildcard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpWildcard(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpAttrContext extends RpContext {
		public TerminalNode TagName() { return getToken(XQueryParser.TagName, 0); }
		public RpAttrContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpParenExprContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpParenExprContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitRpParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_rp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			switch (_input.LA(1)) {
			case TagName:
				{
				_localctx = new RpTagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(152); match(TagName);
				}
				break;
			case T__21:
				{
				_localctx = new RpWildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153); match(T__21);
				}
				break;
			case T__19:
				{
				_localctx = new RpDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(154); match(T__19);
				}
				break;
			case T__30:
				{
				_localctx = new RpDotDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(155); match(T__30);
				}
				break;
			case T__33:
				{
				_localctx = new RpTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156); match(T__33);
				}
				break;
			case T__10:
				{
				_localctx = new RpAttrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(157); match(T__10);
				setState(158); match(TagName);
				}
				break;
			case T__23:
				{
				_localctx = new RpParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159); match(T__23);
				setState(160); rp(0);
				setState(161); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new RpSlashContext(new RpContext(_parentctx, _parentState));
						((RpSlashContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(165);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(166);
						((RpSlashContext)_localctx).slash = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__13) ) {
							((RpSlashContext)_localctx).slash = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(167); ((RpSlashContext)_localctx).right = rp(4);
						}
						break;

					case 2:
						{
						_localctx = new RpConcatContext(new RpContext(_parentctx, _parentState));
						((RpConcatContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(168);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(169); match(T__20);
						setState(170); ((RpConcatContext)_localctx).right = rp(2);
						}
						break;

					case 3:
						{
						_localctx = new RpFilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(171);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(172); match(T__16);
						setState(173); f(0);
						setState(174); match(T__12);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FNotContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FNotContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FRpContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FRpContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FIdEqualContext extends FContext {
		public RpContext left;
		public RpContext right;
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public FIdEqualContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFIdEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFIdEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFIdEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FParenContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FParenContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FOrContext extends FContext {
		public FContext left;
		public FContext right;
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FOrContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FValEqualContext extends FContext {
		public RpContext left;
		public RpContext right;
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public FValEqualContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFValEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFValEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFValEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FAndContext extends FContext {
		public FContext left;
		public FContext right;
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public FAndContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitFAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new FNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(182); match(T__2);
				setState(183); f(1);
				}
				break;

			case 2:
				{
				_localctx = new FRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184); rp(0);
				}
				break;

			case 3:
				{
				_localctx = new FValEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185); ((FValEqualContext)_localctx).left = rp(0);
				setState(186);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(187); ((FValEqualContext)_localctx).right = rp(0);
				}
				break;

			case 4:
				{
				_localctx = new FIdEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(189); ((FIdEqualContext)_localctx).left = rp(0);
				setState(190);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(191); ((FIdEqualContext)_localctx).right = rp(0);
				}
				break;

			case 5:
				{
				_localctx = new FParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193); match(T__23);
				setState(194); f(0);
				setState(195); match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(205);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new FAndContext(new FContext(_parentctx, _parentState));
						((FAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(199);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(200); match(T__3);
						setState(201); ((FAndContext)_localctx).right = f(4);
						}
						break;

					case 2:
						{
						_localctx = new FOrContext(new FContext(_parentctx, _parentState));
						((FOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(202);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(203); match(T__9);
						setState(204); ((FOrContext)_localctx).right = f(3);
						}
						break;
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 0: return xq_sempred((XqContext)_localctx, predIndex);

		case 5: return cond_sempred((CondContext)_localctx, predIndex);

		case 7: return rp_sempred((RpContext)_localctx, predIndex);

		case 8: return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 3);

		case 9: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 6);

		case 1: return precpred(_ctx, 5);

		case 2: return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 3);

		case 4: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return precpred(_ctx, 3);

		case 6: return precpred(_ctx, 1);

		case 7: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00d5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\5\2,\n\2\3\2\5\2/\n\2\3\2\3\2\5\2\63\n\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A\13\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3K\n\3\f\3\16\3N\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4X"+
		"\n\4\f\4\16\4[\13\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0086\n\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u008e\n\7\f\7\16\7\u0091\13\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a6\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00b3\n\t\f\t\16\t\u00b6"+
		"\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00c8\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00d0\n\n\f\n\16\n\u00d3\13"+
		"\n\3\n\2\6\2\f\20\22\13\2\4\6\b\n\f\16\20\22\2\6\4\2\t\t\16\16\4\2\20"+
		"\20\27\27\4\2  %%\4\2\3\3\31\31\u00ef\2\62\3\2\2\2\4B\3\2\2\2\6O\3\2\2"+
		"\2\b\\\3\2\2\2\n_\3\2\2\2\f\u0085\3\2\2\2\16\u0092\3\2\2\2\20\u00a5\3"+
		"\2\2\2\22\u00c7\3\2\2\2\24\25\b\2\1\2\25\26\5\6\4\2\26\27\5\2\2\3\27\63"+
		"\3\2\2\2\30\63\7\'\2\2\31\63\7)\2\2\32\63\5\16\b\2\33\34\7\17\2\2\34\35"+
		"\5\2\2\2\35\36\7\"\2\2\36\63\3\2\2\2\37 \7\30\2\2 !\7(\2\2!\"\7\33\2\2"+
		"\"#\7\7\2\2#$\5\2\2\2$%\7\n\2\2%&\7\24\2\2&\'\7(\2\2\'(\7\33\2\2(\63\3"+
		"\2\2\2)+\5\4\3\2*,\5\6\4\2+*\3\2\2\2+,\3\2\2\2,.\3\2\2\2-/\5\b\5\2.-\3"+
		"\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\5\n\6\2\61\63\3\2\2\2\62\24\3\2\2\2"+
		"\62\30\3\2\2\2\62\31\3\2\2\2\62\32\3\2\2\2\62\33\3\2\2\2\62\37\3\2\2\2"+
		"\62)\3\2\2\2\63?\3\2\2\2\64\65\f\b\2\2\65\66\7\22\2\2\66>\5\2\2\t\678"+
		"\f\7\2\289\7\3\2\29>\5\20\t\2:;\f\6\2\2;<\7\31\2\2<>\5\20\t\2=\64\3\2"+
		"\2\2=\67\3\2\2\2=:\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2A?"+
		"\3\2\2\2BC\7\13\2\2CD\7\'\2\2DE\7!\2\2EL\5\2\2\2FG\7\22\2\2GH\7\'\2\2"+
		"HI\7!\2\2IK\5\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\5\3\2\2\2"+
		"NL\3\2\2\2OP\7\37\2\2PQ\7\'\2\2QR\7\f\2\2RY\5\2\2\2ST\7\22\2\2TU\7\'\2"+
		"\2UV\7\f\2\2VX\5\2\2\2WS\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\7\3\2"+
		"\2\2[Y\3\2\2\2\\]\7\36\2\2]^\5\f\7\2^\t\3\2\2\2_`\7\6\2\2`a\5\2\2\2a\13"+
		"\3\2\2\2bc\b\7\1\2cd\7\4\2\2de\7\'\2\2ef\7!\2\2fm\5\2\2\2gh\7\22\2\2h"+
		"i\7\'\2\2ij\7!\2\2jl\5\2\2\2kg\3\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2n"+
		"p\3\2\2\2om\3\2\2\2pq\7\r\2\2qr\5\f\7\7r\u0086\3\2\2\2st\7\25\2\2t\u0086"+
		"\5\f\7\3uv\5\2\2\2vw\t\2\2\2wx\5\2\2\2x\u0086\3\2\2\2yz\5\2\2\2z{\t\3"+
		"\2\2{|\5\2\2\2|\u0086\3\2\2\2}~\7&\2\2~\177\5\2\2\2\177\u0080\7\"\2\2"+
		"\u0080\u0086\3\2\2\2\u0081\u0082\7\17\2\2\u0082\u0083\5\f\7\2\u0083\u0084"+
		"\7\"\2\2\u0084\u0086\3\2\2\2\u0085b\3\2\2\2\u0085s\3\2\2\2\u0085u\3\2"+
		"\2\2\u0085y\3\2\2\2\u0085}\3\2\2\2\u0085\u0081\3\2\2\2\u0086\u008f\3\2"+
		"\2\2\u0087\u0088\f\5\2\2\u0088\u0089\7#\2\2\u0089\u008e\5\f\7\6\u008a"+
		"\u008b\f\4\2\2\u008b\u008c\7\35\2\2\u008c\u008e\5\f\7\5\u008d\u0087\3"+
		"\2\2\2\u008d\u008a\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\r\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\t\4\2\2"+
		"\u0093\u0094\7\17\2\2\u0094\u0095\7)\2\2\u0095\u0096\7\"\2\2\u0096\u0097"+
		"\t\5\2\2\u0097\u0098\5\20\t\2\u0098\17\3\2\2\2\u0099\u009a\b\t\1\2\u009a"+
		"\u00a6\7(\2\2\u009b\u00a6\7\21\2\2\u009c\u00a6\7\23\2\2\u009d\u00a6\7"+
		"\b\2\2\u009e\u00a6\7\5\2\2\u009f\u00a0\7\34\2\2\u00a0\u00a6\7(\2\2\u00a1"+
		"\u00a2\7\17\2\2\u00a2\u00a3\5\20\t\2\u00a3\u00a4\7\"\2\2\u00a4\u00a6\3"+
		"\2\2\2\u00a5\u0099\3\2\2\2\u00a5\u009b\3\2\2\2\u00a5\u009c\3\2\2\2\u00a5"+
		"\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u009f\3\2\2\2\u00a5\u00a1\3\2"+
		"\2\2\u00a6\u00b4\3\2\2\2\u00a7\u00a8\f\5\2\2\u00a8\u00a9\t\5\2\2\u00a9"+
		"\u00b3\5\20\t\6\u00aa\u00ab\f\3\2\2\u00ab\u00ac\7\22\2\2\u00ac\u00b3\5"+
		"\20\t\4\u00ad\u00ae\f\4\2\2\u00ae\u00af\7\26\2\2\u00af\u00b0\5\22\n\2"+
		"\u00b0\u00b1\7\32\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00a7\3\2\2\2\u00b2\u00aa"+
		"\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\21\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\b\n\1"+
		"\2\u00b8\u00b9\7$\2\2\u00b9\u00c8\5\22\n\3\u00ba\u00c8\5\20\t\2\u00bb"+
		"\u00bc\5\20\t\2\u00bc\u00bd\t\2\2\2\u00bd\u00be\5\20\t\2\u00be\u00c8\3"+
		"\2\2\2\u00bf\u00c0\5\20\t\2\u00c0\u00c1\t\3\2\2\u00c1\u00c2\5\20\t\2\u00c2"+
		"\u00c8\3\2\2\2\u00c3\u00c4\7\17\2\2\u00c4\u00c5\5\22\n\2\u00c5\u00c6\7"+
		"\"\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00b7\3\2\2\2\u00c7\u00ba\3\2\2\2\u00c7"+
		"\u00bb\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\u00d1\3\2"+
		"\2\2\u00c9\u00ca\f\5\2\2\u00ca\u00cb\7#\2\2\u00cb\u00d0\5\22\n\6\u00cc"+
		"\u00cd\f\4\2\2\u00cd\u00ce\7\35\2\2\u00ce\u00d0\5\22\n\5\u00cf\u00c9\3"+
		"\2\2\2\u00cf\u00cc\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\23\3\2\2\2\u00d3\u00d1\3\2\2\2\23+.\62=?LYm\u0085"+
		"\u008d\u008f\u00a5\u00b2\u00b4\u00c7\u00cf\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}