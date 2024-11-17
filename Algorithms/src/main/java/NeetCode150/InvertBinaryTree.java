package NeetCode150;

public class InvertBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode node = root.right;
		root.right = root.left;
		root.left = node;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
	
}
