/* Generated By:JJTree: Do not edit this line. ASTinputStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTinputStatement extends SimpleNode {
  public ASTinputStatement(int id) {
    super(id);
  }

  public ASTinputStatement(BasicParserGEN p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserGENVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=58f910edadce2deaba61745aee1f2073 (do not edit this line) */
