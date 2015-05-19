/*
Partition Array
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.
Example
If nums=[3,2,2,1] and k=2, a valid answer is 1.
Note
You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
If all elements in nums are smaller than k, then return nums.length
Challenge
Can you partition the array in-place and in O(n)?
*/
public class partitionArraySol {
	public static int partitionArray1(int[] nums, int k) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		ArrayList<Integer> rst = new ArrayList<Integer>();
		int len = nums.length;
		int ans = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] < k) {
				ans++;
				l.add(nums[i]);
			} else {
				r.add(nums[i]);
			}
		}
		len = l.size();
		for (int i = 0; i < len; i++) {
			rst.add(l.get(i));
		}
		len = r.size();
		for (int i = 0; i < len; i++) {
			rst.add(r.get(i));
		}
		return ans;
	}
	
	public static int partitionArray2(int[] nums, int k) {
		int i = 0;
		int j = nums.length - 1;
		while (i <= j) {
			while (i <= j && nums[i] < k) {
				i++;
			}
			while (i <= j && nums[j] >= k) {
				j--;
			}
			if (i <= j) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int[] test = {3, 2, 2, 1};
		System.out.print(partitionArray1(test, 2));
		System.out.print("\n");
		System.out.print(partitionArray2(test, 2));
	}
}
/*
 * outputs:
 * 1
 * 1
 */
