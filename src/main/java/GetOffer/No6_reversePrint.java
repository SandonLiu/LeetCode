package GetOffer;

import java.util.Arrays;
import java.util.LinkedList;

public class No6_reversePrint {
	public static void main(String[] args) {

		// 输入链表
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(2);
		head.next = node1;
		node1.next = node2;
		node2.next = node3;

		// 从尾到头打印链表
		int[] output = reversePrint(head);

		// 结果验证
		ListNodeUtil.printByLinkedList(head);
		System.out.println(Arrays.toString(output));
	}

	/**
	 * 从尾到头打印链表
	 * 
	 * @param head 头节点
	 * @return int[] 存储的结果数组
	 */
	private static int[] reversePrint(ListNode head) {

		// 定义一个数组型链表
		LinkedList<Integer> stack = new LinkedList<Integer>();

		// 依次压栈
		while (head != null) {
			stack.add(head.val);
			head = head.next;
		}

		// 定义输出数组
		int[] output = new int[stack.size()];

		// 依次出栈
		for (int i = 0; i < output.length; i++) {
			output[i] = stack.removeLast();
		}

		return output;
	}
}
