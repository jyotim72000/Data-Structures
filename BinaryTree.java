public class BinaryTree 
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
		TreeNode third = new TreeNode(8);
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
	
	public int findMax() 
	{
		return findMax(root);
	}
	
	public int findMax(TreeNode root)
	{
		if(root ==  null)
			return Integer.MIN_VALUE;
		int result = root.data;
		int left = findMax(root.left);
		int right = findMax(root.right);
		if(left > result)
			result = left;
		if(right > result)
			result = right;
		return result;
	}
	
	public static void main(String[] args)
	{
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree();
		System.out.print("Maximum value of the given binary tree is: " + bt.findMax());
	}
}
