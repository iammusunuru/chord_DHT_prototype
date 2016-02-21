package my_chord_project;

/*
 * This class is a data structure for Chord node
 */
public class Chord_node {
	
	int predecessor;
	int sucessor;
	int node;
	public int getNode() {
		return node;
	}
	public void setNode(int node) {
		this.node = node;
	}
	int [][] finger_table;
	public int getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(int predecessor) {
		this.predecessor = predecessor;
	}
	public int getSucessor() {
		return sucessor;
	}
	public void setSucessor(int sucessor) {
		this.sucessor = sucessor;
	}
	public int[][] getFinger_tabel() {
		return finger_table;
	}
	public void setFinger_tabel(int[][] finger_table) {
		this.finger_table = finger_table;
	}
	
	public void print_object()
	{
		System.out.println("\nNode name is"+node);
		System.out.println("\nSucessor is"+sucessor);
		System.out.println("\nPredecessor is"+predecessor);
		for(int i=0;i<finger_table.length;i++)
		{
			System.out.println(finger_table[i][0]+"----->"+finger_table[i][1]);
		}
	}
	
	

}
