package basicparser.programflow;

import basicparser.*;
import basicparser.programflow.Assignment;
import basicparser.programflow.Construct;
import basicparser.programflow.Return;

import java.lang.*;
import java.lang.Character;
import java.lang.Integer;
import java.lang.System;
import java.lang.Thread;
import java.lang.Throwable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphBuilder {
	public ProgramGraph build(SimpleNode root) {
		ProgramGraph graph = new ProgramGraph();
		HashMap<Integer, LinkedList<Construct>> goTargets = new HashMap<Integer, LinkedList<Construct>>();
		LinkedList<Integer> returnTargets = new LinkedList<Integer>();

		BasicVisitor v = new BasicVisitor(graph, goTargets, returnTargets);
		build(root, v);
		graph.finalize();
		initializeReturns(graph, returnTargets);
		initializeGos(graph, goTargets);

		return graph;
	}

	private void build(SimpleNode node, BasicVisitor visitor) {
		node.jjtAccept(visitor, null);
		for(int i = 0; i < node.jjtGetNumChildren(); i++) {
			SimpleNode child = (SimpleNode) node.jjtGetChild(i);
			build(child, visitor);
		}
	}

	/**
	 * relinks the gotos accordingly to their targets and initializes function heads
	 * @param graph
	 * @param gotoTargets
	 */
	private void initializeGos(ProgramGraph graph, HashMap<Integer, LinkedList<Construct>> goTargets) {
		//first gather all the targets of the gotos
		HashMap<Integer, Construct> targetConstructs = new HashMap<Integer, Construct>();
		for(Integer label : goTargets.keySet()) {
			if(!targetConstructs.containsKey(label)) {
				targetConstructs.put(label, graph.getConstructByLabel(label));
			}
		}
		//than change the linking of the graph so the gotos have the according next statements
		for(Map.Entry<Integer, LinkedList<Construct>> goEntry : goTargets.entrySet()) {
			Construct target = targetConstructs.get(goEntry.getKey());
			if(!graph.getHeads().contains(target)) {
				graph.getHeads().add(target);
			}
			for(Construct go : goEntry.getValue()) {
				go.setNext(target);
			}
		}
	}

	/**
	 * builds return methos starting with statements immediately after a goto (here called return targets)
	 * @param graph
	 * @param returnTargets
	 */
	private void initializeReturns(ProgramGraph graph, LinkedList<Integer> returnTargets) {
		//gather all the targets of the returns
		for(Integer label : returnTargets) {
			graph.getReturnHeads().add(graph.getConstructByLabel(label));
		}
	}
}