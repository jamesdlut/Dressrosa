/*
Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
The replacement must be in-place, do not allocate extra memory.
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
/*
用来计算排列组合的函数, 对序列{a, b, c}, 每一个元素都比后面的小, 按照字典序列, 固定a之后, a比bc都小, c比b大, 它的下一个序列即为{a, c, b}, 而{a, c, b}的上一个序列即为{a, b, c}, 
同理可以推出所有的六个序列为: {a, b, c}, {a, c, b}, {b, a, c}, {b, c, a}, {c, a, b}, {c, b, a}, 其中{a, b, c}没有上一个元素, {c, b, a}没有下一个元素,
*/
public class NextPermutationSol {
	public static void nextPermutation1(int[] nums) {
		if (nums == null) {
			return;
		}
		
		int len = nums.length;
		int dropIndex = -1;
		for (int i = len - 1; i >= 0; i--) {
			if (i != len - 1 && nums[i] < nums[i + 1]) {
				dropIndex = i;
				break;
			}
		}
		
		if (dropIndex != -1) {
			for (int i = len - 1; i >= 0; i--) {
				if (nums[i] > nums[dropIndex]) {
					swap(nums, dropIndex, i);
					break;
				}
			}
		}
		
		int l = dropIndex + 1;
		int r = len - 1;
		while (l < r) {
			swap(nums, l, r);
			l++;
			r--;
		}
	}
	
	public static void swap(int[] nums, int l, int r) {
		int tmp = nums[l];
		nums[l] = nums[r];
		nums[r] = tmp;
	}
	
	public static void main(String[] args) {
		int[] test = {1, 2, 4, 3, 2, 1};
		nextPermutation1(test);
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i] + " ");
		}
	}
}
/*
 * outputs:
 * 1 3 1 2 2 4 
 */
