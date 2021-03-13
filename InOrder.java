import java.util.Stack;

public class InOrder 
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
	
	public void inOrderRecursive(TreeNode root)
	{
		if(root == null)
			return;
		
		inOrderRecursive(root.left);
		System.out.print(root.data + " ");
		inOrderRecursive(root.right);
	}
	
	public void inOrderIterative(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;
		
		while(!stack.isEmpty() || temp != null)
		{
			if(temp != null)
			{
				stack.push(temp);
				temp = temp.left;
			}
			else
			{
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	public static void main(String[] args)
	{
		InOrder bt = new InOrder();
		bt.createBinaryTree();
		System.out.println("In Order traversal of Binary Tree");
		System.out.println("Through Recursion");
		bt.inOrderRecursive(bt.root);
		System.out.println();
		System.out.println("Through Iteration");
		bt.inOrderIterative(bt.root);
	}
}
