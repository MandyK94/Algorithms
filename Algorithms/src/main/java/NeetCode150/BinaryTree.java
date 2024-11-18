package NeetCode150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree {

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
	
	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
        if(root.left==null && root.right==null) {
			return 1;
		} 
        
		return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
		
	}
	
	private int dfsDiameter(TreeNode root, int res[]) {
		if(root==null) {
			return 0;
		}
		int left = dfsDiameter(root.left, res);
		int right = dfsDiameter(root.right, res);
		res[0] = Math.max(res[0], right+left);
		return Math.max(left, right)+1;
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		int[] res = new int[1];
		dfsDiameter(root,res);
		return res[0];
	}
	
	private int dfsBalanced(TreeNode root, boolean[] res) {
		if(res[0]==false || root==null) {
			return 0;
		}
		int left = dfsBalanced(root.left, res);
		int right = dfsBalanced(root.right, res);
		if(Math.abs(right-left) >1) {
			res[0]=false;
		} 
		return Math.max(left, right)+1;
	}
	
	public boolean isBalanced(TreeNode root) {
		boolean[] res = new boolean[] {true};
		dfsBalanced(root, res);
		return res[0];
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null && q==null ) {
			return true;
		}
		
		if(p!=null && q!=null && p.val==q.val) {
			return (isSameTree(p.left, q.left)&&isSameTree(p.right, q.right));
		}
		return false;
	}
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(root==null) {
			return false;
		} 
		if(subRoot == null) {
			return false;
		}
		
		if(isSameTree(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null) {
    		return null;
    	}
    	
    	while(root!=null) {
    		if(root.val==p.val || root.val==q.val) {
    			return root;
    		} 
    		if(p.val<root.val && q.val<root.val) {
    			root = root.left;
    		} else if(p.val>root.val && q.val>root.val) {
    			root = root.right;
    		} else {
    			return root;
    		}
    	}
    	return root;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
    	
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while(!q.isEmpty()) {
    		List<Integer> level = new ArrayList<Integer>();
    		for(int i=q.size();i>0;i--) {
    			TreeNode n = q.poll();
    			if(n!=null) {
	    			level.add(n.val);
	    			q.add(n.left);
	    			q.add(n.right);
	    		}
    		}
    		if(level.size()>0) {
    			list.add(level);
    		}
    	}
    	return list;
    }
    
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Queue<TreeNode> q = new LinkedList<BinaryTree.TreeNode>();
    	q.add(root);
    	
    	while(!q.isEmpty()) {
    		TreeNode rightNode = null;
    		for(int i=q.size();i>0;i--) {
    			TreeNode node = q.poll();
    			if(node!=null) {
    				rightNode = node;
    				System.out.println(node.val);
    				q.add(node.left);
    				q.add(node.right);
    			}
    		}
    		if(rightNode!=null) {
    			list.add(rightNode.val);
    		}
    	}
    	
    	return list;
    }
    
    public static void main(String[] args) {
    	BinaryTree tree = new BinaryTree();
		TreeNode root = tree.new TreeNode(1);
		TreeNode node1 = tree.new TreeNode(2);
		TreeNode node2 = tree.new TreeNode(3);
		root.left = node1;
		root.right = node2;
		System.out.println(tree.rightSideView(root));
	}
}
