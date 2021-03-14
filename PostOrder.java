import java.util.Stack;

public class PostOrder 
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
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode fourth = new TreeNode(4);
		TreeNode fifth = new TreeNode(5);
		TreeNode sixth = new TreeNode(6);
		TreeNode seventh = new TreeNode(7);
		
		root = first; // root----> first
		first.left = second;
		first.right = third; // second<--- first ---> third
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;
	}
	
	public void postOrderRecursive(TreeNode root)
	{
		if(root == null)
			return;
		
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postOrderIterative()
	{
		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while(current != null || !stack.isEmpty())
		{
			if(current != null)
			{
				stack.push(current);
				current = current.left;
;			}
			else
			{
				TreeNode temp = stack.peek().right;
				if(temp == null)
				{
					temp = stack.pop();
					System.out.print(temp.data + " ");
					while(!stack.isEmpty() && temp == stack.peek().right)
					{
						temp = stack.pop();
						System.out.print(temp.data + " ");
					}
				}
				else
				{
					current = temp;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		PostOrder bt = new PostOrder();
		bt.createBinaryTree();
		System.out.println("Post Order traversal of Binary Tree");
		System.out.println("Through Recursion");
		bt.postOrderRecursive(bt.root);
		System.out.println();
		System.out.println("Through Iteration");
		bt.postOrderIterative();
	}
}
