import java.util.ArrayList;
import java.util.Scanner;

import com.Ostermiller.util.CSVParser;
import com.Ostermiller.util.LabeledCSVParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Main {
	
	public static void main(String [] args) {
		//import csv here into whale elements
		ArrayList<Whale> whales = new ArrayList<Whale>();
		
		try {
		
			CSVParser reader = new CSVParser(new FileReader("whales.csv"));
			String[] record = null;
			//make whales like discovery channel
				while((record = reader.getLine()) != null) {
					Whale w = new Whale();
					w.setId(record[0]);
					w.setSex(record[1]);
					w.setDorsalCondition(record[2]);
					w.setNumUpNick(record[3]);
					w.setNumMidNick(record[4]);
					w.setNumLowNick(record[5]);
					w.setNumTotNick(record[6]);
					w.setLocLargest(record[7]);
					w.setBlkPattern(record[8]);
					w.setWhtPattern(record[9]);
					w.setOpenSaddle(record[10]);
					w.setBackMaleCurve(record[11]);
					whales.add(w);	
				}
			reader.close();
		} catch(FileNotFoundException e ) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

		
		
		Tree t = new Tree(whales);
		t = doGender(t);
		t = doDorsalCondition(t);
		t = doNumUpNick(t);
		t = doNumMidNick(t);
		t = doNumLowNick(t);
		t = doNumTotNick(t);
		t = doLocLargest(t);
		t = doBlkPattern(t);
		t = doWhtPattern(t);
		t = doOpenSaddle(t);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("@@@@@@@@@@@@@ ~~~ THESE ARE ALL UNIQUE WHALE TYPES BELOW ~~~ @@@@@@@@@@@@@@@@@");

		t = doBackMaleCurve(t);
		System.out.println("Number of unique cases " + t.getCurrentLevel().size() );
		
		//print csv of it
		printCSV(t);
		
		
		System.out.println("Done");
		
		//
		
		
		
	}
	
	public static void printCSV(Tree t) {
		//get unique classes
		ArrayList<String> l = new ArrayList<String>();
		l.add("Back of male dorsal fin curve,Open Saddle,White Scar Pattern,Black Scar Pattern,Location of Largest,Total Nicks,Low Nicks,Mid Nicks,Upper Nicks,Fin Condition,Sex,Number of Whales,Whale ID List");
		for(Node n : t.getCurrentLevel()) {
			String name = n.getTrait() + ",";
			Node p = n.getParent();
			if(!p.getTrait().equals("Full")) {
				while(!p.getParent().getTrait().equals("Full")) {
					name += p.getTrait() + ",";
					p = p.getParent();
				}
			}
			name += p.getTrait() + ",";
			
			String ws = ",";
			for(Whale w : n.getWhales())
				ws += w.getId() + " "; 
			
			l.add(name+n.getWhales().size()+ws);

			
		}
		for(String s : l)
			System.out.println(s);
	}
	
	public static void printNodeInfo(Node n) {
		System.out.println("==================== New Node ====================");
		String name = n.getTrait() + " | ";
		Node p = n.getParent();
		if(!p.getTrait().equals("Full")) {
			while(!p.getParent().getTrait().equals("Full")) {
				name += p.getTrait() + " | ";
				p = p.getParent();
			}
		}
		name += p.getTrait();
		System.out.println("Node Name: " + name);
		System.out.println("Num of whales: " + n.getSize());
		System.out.println("Whales in category: \n");
		for(Whale w : n.getWhales()) {
			System.out.print(w.getId() + ", ");
		}
		System.out.println("\n=================================================");
			
	}
	
	public static void printNodeLevel(ArrayList<Node> nodes) {
		for(Node n : nodes)
			printNodeInfo(n);
	}
	
	public static Tree doGender(Tree t) {
		//do Gender
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Whale w : t.getWhaleList()) {
			if(!t.getRoot().nodeExist(w.getSex())) { //if doesnt exist make it
				Node n = new Node(w.getSex(), w, t.getRoot());
				t.getRoot().addChild(n);
				t.addNode(n);
				nodeLevel.add(n);
			}
			else {
				Node m = t.getRoot().getChild(w.getSex());
				m.addWhale(w);
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doNumUpNick(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getNumUpNick())) { //if doesnt exist make it
					Node n = new Node(w.getNumUpNick(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
					System.out.println("Made a new node: " + n.getTrait() +" for whale: " + w.getId()+ " , parent: " + n.getParent().getTrait());
				}
				else {
					Node m = x.getChild(w.getNumUpNick());
					m.addWhale(w);
				}
			}
		}

		
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doDorsalCondition(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getDorsalCondition())) { //if doesnt exist make it
					Node n = new Node(w.getDorsalCondition(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
					System.out.println("Made a new node: " + n.getTrait() +" for whale: " + w.getId()+ " , parent: " + n.getParent().getTrait());
				}
				else {
					Node m = x.getChild(w.getDorsalCondition());
					m.addWhale(w);
				}
			}
		}

		
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doNumMidNick(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getNumMidNick())) { //if doesnt exist make it
					Node n = new Node(w.getNumMidNick(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getNumMidNick());
					m.addWhale(w);
				}
			}
		}
		//printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doNumLowNick(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getNumLowNick())) { //if doesnt exist make it
					Node n = new Node(w.getNumLowNick(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getNumLowNick());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doNumTotNick(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getNumTotNick())) { //if doesnt exist make it
					Node n = new Node(w.getNumTotNick(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getNumTotNick());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}

	public static Tree doLocLargest(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getLocLargest())) { //if doesnt exist make it
					Node n = new Node(w.getLocLargest(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getLocLargest());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}

	public static Tree doBlkPattern(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getBlkPattern())) { //if doesnt exist make it
					Node n = new Node(w.getBlkPattern(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getBlkPattern());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doWhtPattern(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getWhtPattern())) { //if doesnt exist make it
					Node n = new Node(w.getWhtPattern(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getWhtPattern());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}
	
	public static Tree doOpenSaddle(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getOpenSaddle())) { //if doesnt exist make it
					Node n = new Node(w.getOpenSaddle(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getOpenSaddle());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}

	public static Tree doBackMaleCurve(Tree t) {
		ArrayList<Node> nodeLevel = new ArrayList<Node>();
		for(Node x : t.getCurrentLevel()) {
			for(Whale w : x.getWhales()) {
				if(!x.nodeExist(w.getBackMaleCurve())) { //if doesnt exist make it
					Node n = new Node(w.getBackMaleCurve(), w, x);
					x.addChild(n);
					t.addNode(n);
					nodeLevel.add(n);
				}
				else {
					Node m = x.getChild(w.getBackMaleCurve());
					m.addWhale(w);
				}
			}
		}
		printNodeLevel(nodeLevel);
		t.setCurrentLevel(nodeLevel);
		return t;
	}

	
	
}
