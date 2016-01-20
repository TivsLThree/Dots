package ai;

public class Connection {
	double weight;
	Node inNode;
	Node outNode;
	public Connection(double weight, Node inNode, Node outNode){
		this.weight = weight;
		this.inNode = inNode;
		this.outNode = outNode;
		
	}
}
