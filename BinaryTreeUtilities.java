import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinaryTreeUtilities {
	
	public class java {

	}

	/**
	 * This method reads a binary tree represented as text in standard input, builds the
	 * corresponding binary tree, and returns its root.
	 * 
	 * @return The root of the binary tree read from standard input
	 */
	public static BinaryTreeNode readBinaryTreeFromText()
	{
		Scanner scanner = new Scanner(System.in);
		int numNodes = scanner.nextInt();
		scanner.nextLine();	//Advance the scanner to the next line
		
		// Map that will help with connecting the nodes of the tree
		Map<String, BinaryTreeNode<Integer>> nodesMap = new HashMap<>();
		
		// An array that will store each line of the input
		String[] lines = new String[numNodes];
		
		// A reference to the root node of the tree
		BinaryTreeNode<Integer> root;
		
		// Go through input, store it in the lines array, create a new node for each line,
		// and store that node in the nodesMap using the node's name as a key for later retrieval
		for (int i = 0; i < numNodes; i++)
		{
			lines[i] = scanner.nextLine();
			String[] lineTokens = lines[i].split(" ");
			BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(Integer.parseInt(lineTokens[1]));
			nodesMap.put(lineTokens[0], node);
		}
		
		// The root node is the node that was created from the first node line in the input (which is the
		// second line of the input) and stored in the nodesMap based on its name (which is the first
		// token in the input line corresponding to the root node
		root = nodesMap.get(lines[0].split(" ")[0]);
		
		
		// Now that the nodes have been created for each line, connect the nodes based on the
		// child information stored in the input lines corresponding to each node
		for (String line: lines)
		{
			String[] lineTokens = line.split(" ");
			BinaryTreeNode<Integer> node = nodesMap.get(lineTokens[0]);
			if (!lineTokens[2].equals("NONE"))
				node.setLeftChild(nodesMap.get(lineTokens[2]));
			if (!lineTokens[3].equals("NONE"))
				node.setRightChild(nodesMap.get(lineTokens[3]));
		}
		
		return root;
				
	}
	
}
