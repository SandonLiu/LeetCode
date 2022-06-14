package GetOffer;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class No3_findRepeatedNums {
	public static void main(String[] args) {

		// 输入数组
		int[] inputNums = new int[7];
		inputNums[0] = 1;
		inputNums[1] = 2;
		inputNums[2] = 3;
		inputNums[3] = 1;
		inputNums[4] = 5;
		inputNums[5] = 5;
		inputNums[6] = 2;

		// 算法开始
		List<Integer> outputResult = findRepeatedNums(inputNums);

		// 结果验证
		System.out.println(outputResult.toString());
	}

	/**
	 * 找到数据中的重复元素
	 * 
	 * @param nums 给定的数组
	 * @return result 重复元素的列表
	 */
	private static List<Integer> findRepeatedNums(int[] nums) {
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if (nums[nums[i]] != nums[i]) {
					exchangeElement(nums, i);
				} else {
					intList.add(nums[i]);
					break;
				}
			}
		}
		return intList;
	}

	/**
	 * 根据下标，交换元素的值 a[i] <-> a[a[i]]
	 * 
	 * @param nums 给定的数组
	 * @param i         下标
	 */
	private static void exchangeElement(int[] nums, int i) {
		int m = nums[i];
		nums[i] = nums[m];
		nums[m] = m;
	}
}
