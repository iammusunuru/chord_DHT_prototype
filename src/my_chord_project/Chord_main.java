package my_chord_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chord_main {
	/*
	 * this method is used to generate active nodes randomly
	 */
	ArrayList<Chord_node> active_nodes = new ArrayList<Chord_node>();
	int total_nodes;
	public void generate_active_nodes(int a,int c,int total_number_nodes)
	{
		
		int x=1;
		total_nodes = total_number_nodes;
		ArrayList<Integer> numbers= new ArrayList<Integer>();
		x = ((a*x)+c)%total_number_nodes;
		numbers.add(x);	
		while(true)
		{
			System.out.println(x);
			x = ((a*x)+c)%total_number_nodes;		
			if(numbers.contains(x))
			{
				break;
			}
			numbers.add(x);			
		}
		Chord_node temp;
		for(int i=0;i<numbers.size();i++)
		{
			temp = new Chord_node();
			temp.node = x;	
			active_nodes.add(temp);
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		System.out.println("\nEnter m value:");
		int m = s.nextInt();
		int total_number_nodes = (int)Math.pow(2, m);
		System.out.println("\nNumber of nodes in: "+total_number_nodes);
		System.out.println("\nEnter a value:");
		int a = s.nextInt();
		System.out.println("\nEnter c value:");
		int c = s.nextInt();
		Chord_main cm = new Chord_main();
		cm.generate_active_nodes(a, c, total_number_nodes);
		
		
	}
	

}
