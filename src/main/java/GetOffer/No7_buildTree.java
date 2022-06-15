package GetOffer;

import java.util.HashMap;
import java.util.Map;

public class No7_buildTree {

	// 前序遍历 -> 根 左 右
	// 中序遍历 -> 左 根 右
	// 后序遍历 -> 左 右 根

	private static Map<Integer, Integer> inorderMap;

	/**
	 * 递归法建造二叉树
	 * 
	 * @param preorder       前序遍历结果
	 * @param inorder        中序遍历结果
	 * @param preorder_left  前序遍历左节点下标
	 * @param preorder_right 前序遍历右节点下标
	 * @param inorder_left   对应的中序遍历左节点下标
	 * @param inorder_right  对应的中序遍历右节点下标
	 * @return
	 */
	public static TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
			int inorder_left, int inorder_right) {

		if (preorder_left > preorder_right) {
			return null;
		}

		// 前序遍历中的左节点下标(第一个节点)就是前序遍历的根节点下标
		int preorder_root = preorder_left;
		// 根据前序遍历的根节点的值，在中序遍历中找到中序遍历根节点的下标
		int root_val = preorder[preorder_root];
		int inorder_root = inorderMap.get(root_val);
		// 先把根节点创建出来
		TreeNode root = new TreeNode(root_val);

		// 得到左子树中的节点数目(中序遍历中根节点的下标 - 中序遍历中左节点的下标)
		int left_subtree_size = inorder_root - inorder_left;

		// 递归地构造左子树，并连接到根节点
		// 先序遍历中下标从 （先序_左边界下标 的右边） 开始到 （先序_左边界下标 + 左子树节点数目） 的元素 对应了
		// 中序遍历中下标从 （中序_左边界下标） 开始到 （中序_根节点下标 的左边） 的元素
		root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + left_subtree_size, inorder_left,
				inorder_root - 1);

		// 递归地构造右子树，并连接到根节点
		// 先序遍历中下标从 （先序_左边界下标 + 左子树节点数目 的右边） 开始到 （先序_右边界下标） 的元素 对应了
		// 中序遍历中下标从 （中序_根节点下标 的右边） 到 （中序_右边界下标） 的元素
		root.right = myBuildTree(preorder, inorder, preorder_left + left_subtree_size + 1, preorder_right,
				inorder_root + 1, inorder_right);

		return root;
	}

	/**
	 * 重建二叉树
	 * 
	 * @param preorder 前序遍历结果
	 * @param inorder  中序遍历结果
	 * @return 二叉树
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根节点
		inorderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			inorderMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
	}

	/**
	 * 结果验证
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// 输入
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };

		// 重建二叉树
		TreeNode tree = buildTree(preorder, inorder);

		// 结果打印
		TreeNodeUtil.proOrderTraverse(tree);
		System.out.println("");
		TreeNodeUtil.inOrderTraverse(tree);

	}

}
