/* Generated By:JJTree: Do not edit this line. ASTVariableLengthParameter.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=BaseNode,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package basicparser;

public
class ASTVariableLengthParameter extends SimpleNode {
  public ASTVariableLengthParameter(int id) {
    super(id);
  }

  public ASTVariableLengthParameter(BasicParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(BasicParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=45676efcb7132016804b1d15b49d7df7 (do not edit this line) */
