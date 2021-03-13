import java.util.Stack;

public class PreOrder 
{
	private TreeNode root;
	
	private class TreeNode
	{
		private TreeNode left;
		private TreeNode right;
		private int data; //generic data
		
		public TreeNode(int data)
		{
			this.data = data;
		}
	}
	
	public void createBinaryTree()
	{
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		
		root = first; // root----> first
		first.left = second;
		first.right = third; // second<--- first ---> third
		
		second.left = fourth;
	}
	
	public void preOrderRecursive(TreeNode root)
	{
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	
	public void preOrderIterative()
	{
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		System.out.println();

		while(!stack.isEmpty())
		{
			TreeNode temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}
	
	public static void main(String[] args)
	{
		PreOrder bt = new PreOrder();
		bt.createBinaryTree();
		System.out.println("Pre Order traversal of Binary Tree");
		System.out.println("Through Recursion");
		bt.preOrderRecursive(bt.root);
		System.out.println();
		System.out.println("Through Iteration");
		bt.preOrderIterative();
	}
}
