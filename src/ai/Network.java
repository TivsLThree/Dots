package ai;

import java.util.ArrayList;


public class Network {
	ArrayList<Node> inputs;
	ArrayList<Node> outputs;
	ArrayList<Node> allputs;
	String name;
	int networkID;
	int nodeCount;
	int connectionCount;

	public Network(ArrayList<Node> inputs, ArrayList<Node> outputs) {
		this.inputs = inputs;
		this.outputs = outputs;

	}
}
