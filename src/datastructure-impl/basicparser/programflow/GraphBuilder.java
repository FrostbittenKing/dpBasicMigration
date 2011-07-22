package basicparser.programflow;
import basicparser.*;

import java.lang.Object;

public class GraphBuilder {
	public ProgramGraph build(SimpleNode root) {
		ProgramGraph graph = new ProgramGraph();

		BasicVisitor v = new BasicVisitor();
		build(root, v, graph);

		return graph;
	}

	private void build(SimpleNode node, BasicVisitor visitor, ProgramGraph graph) {
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode) node.jjtGetChild(i);
			build(child, visitor, graph);
		}
		node.jjtAccept(visitor, graph);
	}
}