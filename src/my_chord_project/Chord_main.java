package my_chord_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Chord_main {
	/*
	 * this method is used to generate active nodes randomly
	 */
	ArrayList<Chord_node> active_nodes = new ArrayList<Chord_node>();
	int total_nodes;
	public ArrayList<Integer> numbers;
	public void generate_active_nodes(int a,int c,int total_number_nodes)
	{
		
		int x=3;
		total_nodes = total_number_nodes;
		numbers= new ArrayList<Integer>();
		x = ((a*x)+c)%total_number_nodes;
		numbers.add(x);	
		while(true)
		{
			x = ((a*x)+c)%total_number_nodes;		
			if(numbers.contains(x))
			{
				break;
			}
			numbers.add(x);			
		}
		Chord_node temp;
		Collections.sort(numbers);
		for(int i=0;i<numbers.size();i++)
		{
			temp = new Chord_node();
			temp.node = numbers.get(i);	
			if(i==0)
			{
				temp.sucessor = numbers.get(i+1);
				temp.predecessor = numbers.get(numbers.size()-1);
			}
			else if(i==numbers.size()-1)
			{
				temp.sucessor = numbers.get(0);
				temp.predecessor = numbers.get(i-1);
			}
			else
			{
				temp.sucessor = numbers.get(i+1);
				temp.predecessor = numbers.get(i-1);
			}
			
			active_nodes.add(temp);
		}
		
	}
	
	//iterates over all nodes to cluculate finger tables
	public void generate_finger_nodes(int m)
	{
		for(int i=0;i<active_nodes.size();i++)
		{
			calucaulate_finger_table(active_nodes.get(i), m);
		}	
	}
	
	//atomic method to caluculate finger table
	public Chord_node calucaulate_finger_table(Chord_node c, int m)
	{
		int finger_table[][] = new int[m][2];
		for(int i=0;i<m;i++)
		{
			int num = (c.node + (int)Math.pow(2, i))%total_nodes;
			finger_table[i][0] = num;
			finger_table[i][1] = get_successor(num);
		}
		c.setFinger_tabel(finger_table);
		return c;
	}
	
	
	//get sucessor node for a given random node from "numbers" information
	public int get_successor(int node)
	{
		for(int i=0; i<numbers.size(); i++)
		{
			if (node <= numbers.get(i))
			{
				return numbers.get(i);
			}
			
		}
		return numbers.get(0);
	}
	
	//takes active node number and returns Chord_node object as reference
	public Chord_node get_active_node_reference(int node)
	{
		for(Chord_node cn : active_nodes)
		{
			if(cn.getNode() == node)
			{
				return cn;
			}
		}
		return null;
	}
	
	//search for a succesor to a given random node
	public Chord_node lookup(int search_node, int key_node)
	{
		Chord_node search_node_obj = get_active_node_reference(search_node);
		print_info("\n##############Search##############", 1);
		print_info("\nStarted searching for node "+key_node, 1);
		while(! (search_node_obj.getNode() <= key_node && search_node_obj.sucessor >= key_node))
		{
			int[][] finger_tabel = search_node_obj.getFinger_tabel();
			int i;
			for(i=0;i<finger_tabel.length;i++)
			{
				if(finger_tabel[i][0] > key_node)
				{
					print_info("\nNearest predeseesor is "+finger_tabel[i-1][0], 1);
					break;
				}
			}
			if((finger_tabel[i-1][0]<=key_node)&&(finger_tabel[i-1][1]>=key_node))
			{
				print_info("\nNode "+key_node+" lies between "+finger_tabel[i-1][0]+"and"+finger_tabel[i-1][1], 1);
				return get_active_node_reference(finger_tabel[i-1][1]);
			}
			else
			{
				print_info("\nNode "+key_node+"doesn't lies between "+finger_tabel[i-1][0]+" and it's sucessor"+finger_tabel[i-1][1], 1);
				print_info("\nGoing to search in node "+finger_tabel[i-1][1], 1);
				search_node_obj = get_active_node_reference(finger_tabel[i-1][1]);
			}
		}
		return null;
	}
	
	public void print_info(String msg, int window)
	{
		if(window==1)
		{
			System.out.println(msg);
		}
	}
	
	
	//display all nodes informtion
	public void display_node_info()
	{
		for(int i=0;i<active_nodes.size();i++)
		{
			active_nodes.get(i).print_object();
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
		
		
		
		for(int i=0;i<cm.active_nodes.size();i++)
		{
			System.out.print(cm.active_nodes.get(i).getNode()+" ");
		}
		
		cm.generate_finger_nodes(m);
		cm.display_node_info();
		
		System.out.println("\nEnter node to search");
		Chord_node cn = cm.lookup(cm.numbers.get(0), s.nextInt());
		System.out.println("------->"+cn.getNode());
	}
	

}
