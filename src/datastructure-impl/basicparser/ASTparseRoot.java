/* Generated By:JJTree: Do not edit this line. ASTparseRoot.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTparseRoot extends SimpleNode {
  public ASTparseRoot(int id) {
    super(id);
  }

  public ASTparseRoot(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=bd2fbcb45c86aa0ef1b21bd18ec0f636 (do not edit this line) */
