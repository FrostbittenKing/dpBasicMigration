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
		HashMap<Integer, LinkedList<Goto>> gotoTargets = new HashMap<Integer, LinkedList<Goto>>();
		LinkedList<Integer> gosubTargets = new LinkedList<Integer>();

		BasicVisitor v = new BasicVisitor(graph, gotoTargets, gosubTargets);
		build(root, v);
		graph.finalize();
		initializeGotos(graph, gotoTargets);
		initializeSubs(graph, gosubTargets);

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
	private void initializeGotos(ProgramGraph graph, HashMap<Integer, LinkedList<Goto>> gotoTargets) {
		//first gather all the targets of the gotos
		HashMap<Integer, Construct> targetConstructs = new HashMap<Integer, Construct>();
		for(Integer label : gotoTargets.keySet()) {
			if(!targetConstructs.containsKey(label)) {
				targetConstructs.put(label, graph.getConstructByLabel(label));
			}
		}
		//the first construct is always a head - the head construct of the main method
		graph.getHeads().add(graph.getFirst());
		//than change the linking of the graph so the gotos have the according next statements
		for(Map.Entry<Integer, LinkedList<Goto>> gotoEntry : gotoTargets.entrySet()) {
			Construct target = targetConstructs.get(gotoEntry.getKey());
			if(!graph.getHeads().contains(target)) {
				graph.getHeads().add(target);
			}
			for(Goto aGoto : gotoEntry.getValue()) {
				aGoto.setNext(target);
			}
		}
	}

	/**
	 * builds subs from gosub targets until return statements
	 * @param graph
	 * @param gosubTargets
	 */
	private void initializeSubs(ProgramGraph graph, LinkedList<Integer> gosubTargets) {
		//first gather all the targets of the gosubs
		LinkedList<Construct> targetConstructs = new LinkedList<Construct>();
		for(Integer label : gosubTargets) {
			targetConstructs.add(graph.getConstructByLabel(label));
		}
		//build the subs
		for(Construct targetConstruct : targetConstructs) {
			Sub sub = new Sub();
			sub.push(targetConstruct);
			graph.getSubs().add(sub);
		}
	}
}