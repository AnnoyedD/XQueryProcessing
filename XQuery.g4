grammar XQuery;

// xquery
xq
  : Var                                                          #xqVar
  | StringConstant			                                     #xqStringConstant
  | ap                                                           #xqAp
  | '(' xq ')'                                                   #xqParenExpr
  | left=xq ',' right=xq                                         #xqConcat
  | xq '/' rp                                       			 #xqSlash
  | xq '//' rp													 #xqSlashSlash
  | '<' open=TagName '>' '{' xq '}' '</' close=TagName '>'       #xqTagName
  | forClause letClause? whereClause? returnClause               #xqFLWR
  | letClause xq                                                 #xqLet
  ;

// For Clause: for $var1 in $someList, $var2 in $var1)
forClause
  : 'for' varBind ( ',' varBind )* 
  ;

// Let Clause: let $var1 := "superman", $var2 := "batman", ...
letClause
  : 'let' varBind ( ',' varBind )*
  ;

// Where Clause: where $var1 == $var2
whereClause
  : 'where' cond
  ;

// Return Clause: return $var1
returnClause
  : 'return' xq
  ;

// condition
cond
  : left=xq ('='|'eq')  right=xq                           #condValEqual
  | left=xq ('=='|'is') right=xq                           #condIdEqual
  | 'empty(' xq ')'                                        #condEmpty
  | 'some' varBind ( ',' varBind )* 'satisfies' cond 	   #condSomeSatis
  | '(' cond ')'                                           #condParenExpr
  | left=cond 'and' right=cond                             #condAnd
  | left=cond 'or'  right=cond                             #condOr
  | 'not ' cond                                            #condNot
  ;

//bind $var
varBind
  : Var ('in'|':=') xq				 
  ;

// Absolute path
ap
  : ('doc'|'document') '(' fileName=StringConstant ')' slash=('/'|'//') rp	#apSlash
  ;

// Relative path
rp
  : TagName							  #rpTagName
  | '*'                               #rpWildcard
  | '.'                               #rpDot
  | '..'                              #rpDotDot
  | 'text()'                          #rpText
  | '@' TagName                       #rpAttr
  | '(' rp ')'                        #rpParenExpr
  | left=rp slash=('/'|'//') right=rp #rpSlash
  | rp '[' f ']'                      #rpFilter
  | left=rp ',' right=rp              #rpConcat
  ;

// Path filter
f
  : rp                                #fRp
  | left=rp ('eq'|'=')  right=rp      #fValEqual
  | left=rp ('is'|'==') right=rp      #fIdEqual
  | '(' f ')'                         #fParen
  | left=f  'and'       right=f       #fAnd
  | left=f  'or'        right=f       #fOr
  | 'not' f                           #fNot
  ;

Var
  : '$' TagName
  ;

TagName
  : Letter LetterOrDigit*
  ;

fragment
Letter
  : [a-zA-Z_]
  ;

fragment
LetterOrDigit
  : [a-zA-Z0-9_-]
  ;

StringConstant
  :   '\"' StringCharacters? '\"'
  ;

fragment
StringCharacters :	StringCharacter+ ;

fragment
StringCharacter
  : ~[\"\\@] 
  ;

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines