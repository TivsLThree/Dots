package ai;

import java.util.ArrayList;

public class Genome {
	Network phenotype;
	public int genomeID;
	ArrayList<Gene> genes;
	public Genome(int genomeID,ArrayList<Gene> genes ){
		this.genomeID = genomeID;
		this.genes = genes;
	}
}
