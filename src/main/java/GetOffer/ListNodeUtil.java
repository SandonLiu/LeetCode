package GetOffer;

import java.util.LinkedList;
import java.util.List;

public class ListNodeUtil {
	private ListNodeUtil() {
	}

	public static void printByLinkedList(ListNode head) {
		List<Integer> inputList = new LinkedList<Integer>();
		while (head != null) {
			inputList.add(head.val);
			head = head.next;
		}
		System.out.println(inputList);
	}
}
