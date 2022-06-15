package GetOffer;

import java.util.LinkedList;

public class No9_implQueueBy2Stacks {

	// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数:
	// 队列尾部插入整数appendTail
	// 队列头部删除整数deleteHead(若队列中没有元素，deleteHead操作返回-1)

	LinkedList<Integer> saveStack, tempStack;

	public No9_implQueueBy2Stacks() {
		saveStack = new LinkedList<Integer>();
		tempStack = new LinkedList<Integer>();
	}

	/**
	 * 队列尾部插入整数
	 * 
	 * @param value 尾部新插入的元素
	 */
	public void appendTail(int value) {
		saveStack.addLast(value);
	}

	/**
	 * 队列头部删除整数
	 * 
	 * @return 头部删除的整数(若队列中没有元素，操作返回-1)
	 */
	public int deleteHead() {

		// 若队列中没有元素，操作返回-1
		if (saveStack.isEmpty()) {
			return -1;
		}

		// 这段代码非常重要！！！
		// 用于第二次删除头部元素
		if (tempStack.isEmpty()) {
			return tempStack.removeLast();
		}

		// 把saveStack中的元素出栈到tempStack中
		while (!saveStack.isEmpty()) {
			tempStack.addLast(saveStack.removeLast());
		}
		// 此时saveStack已经没有元素，让tempStack最后元素出栈
		return tempStack.removeLast();
	}

}
