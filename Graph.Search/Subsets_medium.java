/*
Subsets
Given a set of distinct integers, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
/*
Basically our algorithm can't be faster than O(2^n) since we need to go through all possible combinations.
SOL 1 Recurstion
SOL 3 The idea is that all the numbers from 0 to 2^n are represented by unique bit strings of n bit width that can be translated into a subset.
e.g.
Nr Bits Combination
0  000  {}
1  001  {1}
2  010  {2}
3  011  {1, 2}
4  100  {3}
5  101  {1, 3}
6  110  {2, 3}
7  111  {1, 2, 3]
int numberOfTrailingZeros(int i) 给定一个int类型数据, 返回这个数据的二进制串中从最右边算起连续的“0”的总数量, 因为int类型的数据长度为32所以高位不足的地方会以“0”填充.
1的二进制表示为: 1最右边开始数起连续的0的个数为: 0  
2的二进制表示为: 10最右边开始数起连续的0的个数为: 1
*/
public class SubsetsSol {
	public static List<List<Integer>> subsets1(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null) {
			return rst; 
		}
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<Integer>(), rst);
		return rst;
	}
	
	public static void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> rst) {
		// 先加一个空集合进去
		rst.add(new ArrayList<Integer>(list));
		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			dfs(nums, i + 1, list, rst);
			list.remove(list.size() - 1);
		}
	}
	
	public static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null) {
			return rst;
		}
		Arrays.sort(nums);
		return dfs2(nums, 0, new HashMap<Integer, List<List<Integer>>>());
	}
	
	public static List<List<Integer>> dfs2(int[] nums, int index, HashMap<Integer, List<List<Integer>>> map) {
		int len = nums.length;
		if (map.containsKey(index)) {
			return map.get(index);
		}
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		List<Integer> pathTmp = new ArrayList<Integer>();
		rst.add(pathTmp);
		for (int i = index; i < len; i++) {
			List<List<Integer>> left = dfs2(nums, i + 1, map);
			for (List<Integer> list : left) {
				pathTmp = new ArrayList<Integer>();
				pathTmp.add(nums[i]);
				pathTmp.addAll(list);
				rst.add(pathTmp);
			}
		}
		map.put(index, rst);
		return rst;
	}
	
	public static List<List<Integer>> subsets3(int[] nums) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return rst;
		}
		int len = nums.length;
		Arrays.sort(nums);
		long numOfSet = (long)Math.pow(2, len);
		for (int i = 0; i < numOfSet; i++) {
			long tmp = i;
			ArrayList<Integer> list = new ArrayList<Integer>();
			while (tmp != 0) {
				int indexOfLast1 = Long.numberOfTrailingZeros(tmp);
				list.add(nums[indexOfLast1]);
				tmp ^= (1 << indexOfLast1);
			}
			rst.add(list);
		}
		return rst;
	}
	
	public static void main(String[] args) {
		int[] test = {1, 2, 3};
		System.out.print(subsets3(test));
	}
}
