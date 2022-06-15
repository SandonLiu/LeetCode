package GetOffer;

public class TreeNodeUtil {

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void proOrderTraverse(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + "->");
			proOrderTraverse(root.left);
			proOrderTraverse(root.right);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inOrderTraverse(TreeNode root) {
		if (root != null) {
			inOrderTraverse(root.left);
			System.out.print(root.val + "->");
			inOrderTraverse(root.right);
		}
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void postOrderTraverse(TreeNode root) {
		if (root != null) {
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.print(root.val + "->");
		}
	}
}
