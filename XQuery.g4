grammar XQuery;

@header {
package edu.ucsd.antlrtutorial.antlrtutorial;
}

// XQuery
XQ
  : Var                                                          //#xqVar
  | StringConstant                                               //#xqStringConstant
  | ap                                                           //#xqAp
  | '(' XQ ')'                                                   //#xqParenExpr
  | left=XQ ',' right=XQ                                         //#xqConcat
  | XQ slash=('/'|'//') rp                                       //#xqSlash
  | '<' open=tagName '>' '{' XQ '}' '</' close=tagName '>'       //#xqTagName
  | forClause letClause? whereClause? returnClause               //#xqFLWR
  | letClause XQ                                                 //#xqLet
  ;

// For Clause: for $var1 in $someList, $var2 in $var1)
forClause
  : 'for' Var 'in' XQ (',' Var 'in' XQ)*
  ;

// Let Clause: let $var1 := "superman", $var2 := "batman", ...
letClause
  : 'let' Var ':=' XQ (',' Var ':=' XQ)*
  ;

// Where Clause: where $var1 == $var2
whereClause
  : 'where' Cond
  ;

// Return Clause: return $var1
returnClause
  : 'return' XQ
  ;

// Condition
Cond
  : left=XQ ('='|'eq')  right=XQ                           //#condValEqual
  | left=XQ ('=='|'is') right=XQ                           //#condIdEqual
  | 'empty(' XQ ')'                                        //#condEmpty
  | 'some' Var 'in' XQ (',' Var 'in' XQ)* 'satisfies' Cond //#condSomeSatis
  | '(' Cond ')'                                           //#condParenExpr
  | left=Cond 'and' right=Cond                             //#condAnd
  | left=Cond 'or'  right=Cond                             //#condOr
  | 'not ' Cond                                            //#condNot
  ;


// Absolute path
ap
  : 'doc(' fileName=StringConstant ')' slash=('/'|'//') rp
  ;

// Relative path
rp
  : tagName							  //#rpTagName
  | '*'                               //#rpWildcard
  | '.'                               //#rpDot
  | '..'                              //#rpDotDot
  | 'text()'                          //#rpText
  | '@' attName                       //#rpAttr
  | '(' rp ')'                        //#rpParenExpr
  | left=rp slash=('/'|'//') right=rp //#rpSlash
  | rp '[' f ']'                      //#rpFilter
  | left=rp ',' right=rp              //#rpConcat
  ;

// Path filter
f
  : rp                                //#fRp
  | left=rp ('eq'|'=')  right=rp      //#fValEqual
  | left=rp ('is'|'==') right=rp      //#fIdEqual
  | '(' f ')'                         //#fParen
  | left=f  'and'       right=f       //#fAnd
  | left=f  'or'        right=f       //#fOr
  | 'not ' f                          //#fNot
  ;

Var
  : '$' tagName
  ;

tagName
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