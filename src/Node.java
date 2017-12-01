import java.util.ArrayList;

public class Node {
	
	private String trait;
	private ArrayList<Whale> whales;
	private int size;
	private Node parent;
	private ArrayList<Node> children;
	
	public Node(String trait, Whale w, Node parent) {
		this.trait = trait;
		this.whales = new ArrayList<Whale>();
		whales.add(w);
		size = 1;
		this.parent = parent;
		this.children = new ArrayList<Node>();
	}
	
	public void addWhale(Whale w) {
		whales.add(w);
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public ArrayList<Whale> getWhales() {
		return whales;
	}
	
	public String getTrait() {
		return trait;
	}
	
	public void addChild(Node n) {
		children.add(n);
	}
	
	public boolean nodeExist(String s) {
		if(children.size()!=0) {
			for(Node c : children) {
				if(c.getTrait().equals(s))
					return true;
			}
		}
		return false;
	}
	
	public Node getChild(String s) {
		for(Node c : children) {
			if(c.getTrait().equals(s))
				return c;
		}
		return null; //should never get here
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
}
