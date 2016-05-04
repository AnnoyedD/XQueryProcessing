// Generated from xqueryprocessor\yili_yu\XQuery.g4 by ANTLR 4.3
package xqueryprocessor.yili_yu;
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
		RULE_returnClause = 4, RULE_cond = 5, RULE_varBind = 6, RULE_ap = 7, RULE_rp = 8, 
		RULE_f = 9;
	public static final String[] ruleNames = {
		"xq", "forClause", "letClause", "whereClause", "returnClause", "cond", 
		"varBind", "ap", "rp", "f"
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
			setState(50);
			switch (_input.LA(1)) {
			case T__7:
				{
				_localctx = new XqLetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(21); letClause();
				setState(22); xq(1);
				}
				break;
			case Var:
				{
				_localctx = new XqVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24); match(Var);
				}
				break;
			case StringConstant:
				{
				_localctx = new XqStringConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25); match(StringConstant);
				}
				break;
			case T__6:
			case T__1:
				{
				_localctx = new XqApContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26); ap();
				}
				break;
			case T__23:
				{
				_localctx = new XqParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27); match(T__23);
				setState(28); xq(0);
				setState(29); match(T__4);
				}
				break;
			case T__14:
				{
				_localctx = new XqTagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31); match(T__14);
				setState(32); ((XqTagNameContext)_localctx).open = match(TagName);
				setState(33); match(T__11);
				setState(34); match(T__31);
				setState(35); xq(0);
				setState(36); match(T__28);
				setState(37); match(T__18);
				setState(38); ((XqTagNameContext)_localctx).close = match(TagName);
				setState(39); match(T__11);
				}
				break;
			case T__27:
				{
				_localctx = new XqFLWRContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41); forClause();
				setState(43);
				_la = _input.LA(1);
				if (_la==T__7) {
					{
					setState(42); letClause();
					}
				}

				setState(46);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(45); whereClause();
					}
				}

				setState(48); returnClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(61);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new XqConcatContext(new XqContext(_parentctx, _parentState));
						((XqConcatContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(52);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(53); match(T__20);
						setState(54); ((XqConcatContext)_localctx).right = xq(7);
						}
						break;

					case 2:
						{
						_localctx = new XqSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(55);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(56); match(T__35);
						setState(57); rp(0);
						}
						break;

					case 3:
						{
						_localctx = new XqSlashSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(58);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(59); match(T__13);
						setState(60); rp(0);
						}
						break;
					}
					} 
				}
				setState(65);
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
		public VarBindContext varBind(int i) {
			return getRuleContext(VarBindContext.class,i);
		}
		public List<VarBindContext> varBind() {
			return getRuleContexts(VarBindContext.class);
		}
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
			setState(66); match(T__27);
			setState(67); varBind();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(68); match(T__20);
				setState(69); varBind();
				}
				}
				setState(74);
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
		public VarBindContext varBind(int i) {
			return getRuleContext(VarBindContext.class,i);
		}
		public List<VarBindContext> varBind() {
			return getRuleContexts(VarBindContext.class);
		}
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
			setState(75); match(T__7);
			setState(76); varBind();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(77); match(T__20);
				setState(78); varBind();
				}
				}
				setState(83);
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
			setState(84); match(T__8);
			setState(85); cond(0);
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
			setState(87); match(T__32);
			setState(88); xq(0);
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
		public VarBindContext varBind(int i) {
			return getRuleContext(VarBindContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<VarBindContext> varBind() {
			return getRuleContexts(VarBindContext.class);
		}
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
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new CondSomeSatisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(91); match(T__34);
				setState(92); varBind();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__20) {
					{
					{
					setState(93); match(T__20);
					setState(94); varBind();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100); match(T__25);
				setState(101); cond(5);
				}
				break;

			case 2:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103); match(T__17);
				setState(104); cond(1);
				}
				break;

			case 3:
				{
				_localctx = new CondValEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105); ((CondValEqualContext)_localctx).left = xq(0);
				setState(106);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(107); ((CondValEqualContext)_localctx).right = xq(0);
				}
				break;

			case 4:
				{
				_localctx = new CondIdEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); ((CondIdEqualContext)_localctx).left = xq(0);
				setState(110);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(111); ((CondIdEqualContext)_localctx).right = xq(0);
				}
				break;

			case 5:
				{
				_localctx = new CondEmptyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113); match(T__0);
				setState(114); xq(0);
				setState(115); match(T__4);
				}
				break;

			case 6:
				{
				_localctx = new CondParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117); match(T__23);
				setState(118); cond(0);
				setState(119); match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(129);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new CondContext(_parentctx, _parentState));
						((CondAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(123);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(124); match(T__3);
						setState(125); ((CondAndContext)_localctx).right = cond(4);
						}
						break;

					case 2:
						{
						_localctx = new CondOrContext(new CondContext(_parentctx, _parentState));
						((CondOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(126);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(127); match(T__9);
						setState(128); ((CondOrContext)_localctx).right = cond(3);
						}
						break;
					}
					} 
				}
				setState(133);
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

	public static class VarBindContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode Var() { return getToken(XQueryParser.Var, 0); }
		public VarBindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterVarBind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitVarBind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQueryVisitor ) return ((XQueryVisitor<? extends T>)visitor).visitVarBind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarBindContext varBind() throws RecognitionException {
		VarBindContext _localctx = new VarBindContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varBind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(Var);
			setState(135);
			_la = _input.LA(1);
			if ( !(_la==T__26 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(136); xq(0);
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
		enterRule(_localctx, 14, RULE_ap);
		int _la;
		try {
			_localctx = new ApSlashContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(139); match(T__23);
			setState(140); ((ApSlashContext)_localctx).fileName = match(StringConstant);
			setState(141); match(T__4);
			setState(142);
			((ApSlashContext)_localctx).slash = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__13) ) {
				((ApSlashContext)_localctx).slash = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(143); rp(0);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			switch (_input.LA(1)) {
			case TagName:
				{
				_localctx = new RpTagNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(146); match(TagName);
				}
				break;
			case T__21:
				{
				_localctx = new RpWildcardContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147); match(T__21);
				}
				break;
			case T__19:
				{
				_localctx = new RpDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148); match(T__19);
				}
				break;
			case T__30:
				{
				_localctx = new RpDotDotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149); match(T__30);
				}
				break;
			case T__33:
				{
				_localctx = new RpTextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150); match(T__33);
				}
				break;
			case T__10:
				{
				_localctx = new RpAttrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151); match(T__10);
				setState(152); match(TagName);
				}
				break;
			case T__23:
				{
				_localctx = new RpParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153); match(T__23);
				setState(154); rp(0);
				setState(155); match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(170);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new RpSlashContext(new RpContext(_parentctx, _parentState));
						((RpSlashContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(159);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(160);
						((RpSlashContext)_localctx).slash = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__13) ) {
							((RpSlashContext)_localctx).slash = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(161); ((RpSlashContext)_localctx).right = rp(4);
						}
						break;

					case 2:
						{
						_localctx = new RpConcatContext(new RpContext(_parentctx, _parentState));
						((RpConcatContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(162);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(163); match(T__20);
						setState(164); ((RpConcatContext)_localctx).right = rp(2);
						}
						break;

					case 3:
						{
						_localctx = new RpFilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(165);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(166); match(T__16);
						setState(167); f(0);
						setState(168); match(T__12);
						}
						break;
					}
					} 
				}
				setState(174);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new FNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(176); match(T__2);
				setState(177); f(1);
				}
				break;

			case 2:
				{
				_localctx = new FRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178); rp(0);
				}
				break;

			case 3:
				{
				_localctx = new FValEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); ((FValEqualContext)_localctx).left = rp(0);
				setState(180);
				_la = _input.LA(1);
				if ( !(_la==T__29 || _la==T__24) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(181); ((FValEqualContext)_localctx).right = rp(0);
				}
				break;

			case 4:
				{
				_localctx = new FIdEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183); ((FIdEqualContext)_localctx).left = rp(0);
				setState(184);
				_la = _input.LA(1);
				if ( !(_la==T__22 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(185); ((FIdEqualContext)_localctx).right = rp(0);
				}
				break;

			case 5:
				{
				_localctx = new FParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(187); match(T__23);
				setState(188); f(0);
				setState(189); match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(201);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(199);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new FAndContext(new FContext(_parentctx, _parentState));
						((FAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(193);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(194); match(T__3);
						setState(195); ((FAndContext)_localctx).right = f(4);
						}
						break;

					case 2:
						{
						_localctx = new FOrContext(new FContext(_parentctx, _parentState));
						((FOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(196);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(197); match(T__9);
						setState(198); ((FOrContext)_localctx).right = f(3);
						}
						break;
					}
					} 
				}
				setState(203);
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

		case 8: return rp_sempred((RpContext)_localctx, predIndex);

		case 9: return f_sempred((FContext)_localctx, predIndex);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00cf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2.\n\2\3\2\5\2\61\n\2\3\2\3\2\5\2\65\n\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2@\n\2\f\2\16\2C\13\2\3\3\3\3\3"+
		"\3\3\3\7\3I\n\3\f\3\16\3L\13\3\3\4\3\4\3\4\3\4\7\4R\n\4\f\4\16\4U\13\4"+
		"\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7|\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0084\n\7\f\7\16\7\u0087"+
		"\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00a0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u00ad\n\n\f\n\16\n\u00b0\13\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c2"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00ca\n\13\f\13\16\13\u00cd\13"+
		"\13\3\13\2\6\2\f\22\24\f\2\4\6\b\n\f\16\20\22\24\2\7\4\2\t\t\16\16\4\2"+
		"\20\20\27\27\4\2\f\f!!\4\2  %%\4\2\3\3\31\31\u00e8\2\64\3\2\2\2\4D\3\2"+
		"\2\2\6M\3\2\2\2\bV\3\2\2\2\nY\3\2\2\2\f{\3\2\2\2\16\u0088\3\2\2\2\20\u008c"+
		"\3\2\2\2\22\u009f\3\2\2\2\24\u00c1\3\2\2\2\26\27\b\2\1\2\27\30\5\6\4\2"+
		"\30\31\5\2\2\3\31\65\3\2\2\2\32\65\7\'\2\2\33\65\7)\2\2\34\65\5\20\t\2"+
		"\35\36\7\17\2\2\36\37\5\2\2\2\37 \7\"\2\2 \65\3\2\2\2!\"\7\30\2\2\"#\7"+
		"(\2\2#$\7\33\2\2$%\7\7\2\2%&\5\2\2\2&\'\7\n\2\2\'(\7\24\2\2()\7(\2\2)"+
		"*\7\33\2\2*\65\3\2\2\2+-\5\4\3\2,.\5\6\4\2-,\3\2\2\2-.\3\2\2\2.\60\3\2"+
		"\2\2/\61\5\b\5\2\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\5\n\6\2"+
		"\63\65\3\2\2\2\64\26\3\2\2\2\64\32\3\2\2\2\64\33\3\2\2\2\64\34\3\2\2\2"+
		"\64\35\3\2\2\2\64!\3\2\2\2\64+\3\2\2\2\65A\3\2\2\2\66\67\f\b\2\2\678\7"+
		"\22\2\28@\5\2\2\t9:\f\7\2\2:;\7\3\2\2;@\5\22\n\2<=\f\6\2\2=>\7\31\2\2"+
		">@\5\22\n\2?\66\3\2\2\2?9\3\2\2\2?<\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2"+
		"\2\2B\3\3\2\2\2CA\3\2\2\2DE\7\13\2\2EJ\5\16\b\2FG\7\22\2\2GI\5\16\b\2"+
		"HF\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\5\3\2\2\2LJ\3\2\2\2MN\7\37\2"+
		"\2NS\5\16\b\2OP\7\22\2\2PR\5\16\b\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3"+
		"\2\2\2T\7\3\2\2\2US\3\2\2\2VW\7\36\2\2WX\5\f\7\2X\t\3\2\2\2YZ\7\6\2\2"+
		"Z[\5\2\2\2[\13\3\2\2\2\\]\b\7\1\2]^\7\4\2\2^c\5\16\b\2_`\7\22\2\2`b\5"+
		"\16\b\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg"+
		"\7\r\2\2gh\5\f\7\7h|\3\2\2\2ij\7\25\2\2j|\5\f\7\3kl\5\2\2\2lm\t\2\2\2"+
		"mn\5\2\2\2n|\3\2\2\2op\5\2\2\2pq\t\3\2\2qr\5\2\2\2r|\3\2\2\2st\7&\2\2"+
		"tu\5\2\2\2uv\7\"\2\2v|\3\2\2\2wx\7\17\2\2xy\5\f\7\2yz\7\"\2\2z|\3\2\2"+
		"\2{\\\3\2\2\2{i\3\2\2\2{k\3\2\2\2{o\3\2\2\2{s\3\2\2\2{w\3\2\2\2|\u0085"+
		"\3\2\2\2}~\f\5\2\2~\177\7#\2\2\177\u0084\5\f\7\6\u0080\u0081\f\4\2\2\u0081"+
		"\u0082\7\35\2\2\u0082\u0084\5\f\7\5\u0083}\3\2\2\2\u0083\u0080\3\2\2\2"+
		"\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\r\3"+
		"\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\7\'\2\2\u0089\u008a\t\4\2\2\u008a"+
		"\u008b\5\2\2\2\u008b\17\3\2\2\2\u008c\u008d\t\5\2\2\u008d\u008e\7\17\2"+
		"\2\u008e\u008f\7)\2\2\u008f\u0090\7\"\2\2\u0090\u0091\t\6\2\2\u0091\u0092"+
		"\5\22\n\2\u0092\21\3\2\2\2\u0093\u0094\b\n\1\2\u0094\u00a0\7(\2\2\u0095"+
		"\u00a0\7\21\2\2\u0096\u00a0\7\23\2\2\u0097\u00a0\7\b\2\2\u0098\u00a0\7"+
		"\5\2\2\u0099\u009a\7\34\2\2\u009a\u00a0\7(\2\2\u009b\u009c\7\17\2\2\u009c"+
		"\u009d\5\22\n\2\u009d\u009e\7\"\2\2\u009e\u00a0\3\2\2\2\u009f\u0093\3"+
		"\2\2\2\u009f\u0095\3\2\2\2\u009f\u0096\3\2\2\2\u009f\u0097\3\2\2\2\u009f"+
		"\u0098\3\2\2\2\u009f\u0099\3\2\2\2\u009f\u009b\3\2\2\2\u00a0\u00ae\3\2"+
		"\2\2\u00a1\u00a2\f\5\2\2\u00a2\u00a3\t\6\2\2\u00a3\u00ad\5\22\n\6\u00a4"+
		"\u00a5\f\3\2\2\u00a5\u00a6\7\22\2\2\u00a6\u00ad\5\22\n\4\u00a7\u00a8\f"+
		"\4\2\2\u00a8\u00a9\7\26\2\2\u00a9\u00aa\5\24\13\2\u00aa\u00ab\7\32\2\2"+
		"\u00ab\u00ad\3\2\2\2\u00ac\u00a1\3\2\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\23\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\b\13\1\2\u00b2\u00b3\7$\2"+
		"\2\u00b3\u00c2\5\24\13\3\u00b4\u00c2\5\22\n\2\u00b5\u00b6\5\22\n\2\u00b6"+
		"\u00b7\t\2\2\2\u00b7\u00b8\5\22\n\2\u00b8\u00c2\3\2\2\2\u00b9\u00ba\5"+
		"\22\n\2\u00ba\u00bb\t\3\2\2\u00bb\u00bc\5\22\n\2\u00bc\u00c2\3\2\2\2\u00bd"+
		"\u00be\7\17\2\2\u00be\u00bf\5\24\13\2\u00bf\u00c0\7\"\2\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00b1\3\2\2\2\u00c1\u00b4\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1"+
		"\u00b9\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c2\u00cb\3\2\2\2\u00c3\u00c4\f\5"+
		"\2\2\u00c4\u00c5\7#\2\2\u00c5\u00ca\5\24\13\6\u00c6\u00c7\f\4\2\2\u00c7"+
		"\u00c8\7\35\2\2\u00c8\u00ca\5\24\13\5\u00c9\u00c3\3\2\2\2\u00c9\u00c6"+
		"\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\25\3\2\2\2\u00cd\u00cb\3\2\2\2\23-\60\64?AJSc{\u0083\u0085\u009f\u00ac"+
		"\u00ae\u00c1\u00c9\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}