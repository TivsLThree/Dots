package ai;

public class Gene {
	Connection connection;
	double innovationNumber;
	boolean enable;
	public Gene(double weight, Node inNode, Node outNode, int innovationNumber){
		this.innovationNumber = innovationNumber;
		connection = new Connection(weight, inNode, outNode);
		enable = true;
		
	}
}
