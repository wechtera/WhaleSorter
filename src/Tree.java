import java.util.ArrayList;

public class Tree {
	private ArrayList<Whale> whaleList;
	private ArrayList<Node> nodeList;
	private Node root;
	private ArrayList<Node> currentLevel;
	
	public Tree(ArrayList<Whale> whaleList) {
		this.whaleList = new ArrayList<Whale>();
		this.whaleList.addAll(whaleList);
		
		nodeList = new ArrayList<Node>();
		this.root = new Node("Full", null, root);
		//fill root with all whales;
		for(Whale w : whaleList)
			root.addWhale(w);
		this.currentLevel = new ArrayList<Node>();
	}
	
	public ArrayList<Whale> getWhaleList() {
		return whaleList;
	}
	
	public ArrayList<Node> getNodeList() {
		return nodeList;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void addNode(Node n) {
		nodeList.add(n);
	}

	public ArrayList<Node> getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(ArrayList<Node> currentLevel) {
		this.currentLevel.clear();
		this.currentLevel.addAll(currentLevel);
	}
	
	

}
