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
	int [][] finger_tabel;
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
		return finger_tabel;
	}
	public void setFinger_tabel(int[][] finger_tabel) {
		this.finger_tabel = finger_tabel;
	}
	
	

}
