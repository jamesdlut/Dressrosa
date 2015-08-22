/*
Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
*/
/*
SOL 1
For deal with the duplicate solution, we should sort it.
递归以及回溯
SOL 2
使用一个pre来记录。只取第一个可以取的位置
只取第一个可取的位置，因为别的位置取到的也没有区别
*/
/*
SOL 1
dfs()
   visit[0] = true
   list.add(1)
   dfs()
      visit[2] = true
      list.add(2)
      dfs()
      list.remove(2 - 1)
      visit[2] = false
    list.remove(0)
    visit[0] = false

    visit[1] = true
    list.add(1)
    dfs()
       visit[0] = true
       list.add(1)
       dfs()
          visit[2] = true
          list.add(2)
          dfs()
             rst.add(list) [[1, 1, 2]]
          list.remove(2)
          visit[2] = false
       list.remove(1)
       visit[0] = false
       visit[2] = true
       list.add(2)
       dfs()
          visit[0] = true
          list.add(1)
          dfs()
             rst.add(list) [[1, 1, 2] [1, 2, 1]]
     list.remove(0)
     visit[1] = false
     
     visit[2] = true
     list.add(2)
     dfs()
        visit[0] = true
        list.add(1)
        dfs()
        list.remove(2 - 1)
        visit[0] = false
        visit[1] = true
        list.add(1)
        dfs()
           visit[0] = true
           list.add(1)
           dfs()
              rst.add(list) [[1, 1, 2] [1, 2, 1] [2, 1, 1]]
           ...
        ...
      ...
*/
public class permuteUniqueSol {
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null) {
			return null;
		}
		
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] visit = new boolean[nums.length];
		Arrays.sort(nums);
		// SOL 1
		dfs1(nums, list, rst, visit);
		// SOL 2
		// dfs2(nums, list, rst, visit);
		return rst;
	}
	
	public static void dfs1(int[] nums, List<Integer> list, List<List<Integer>> rst, boolean[] visit) {
		if (list.size() == nums.length) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (visit[i] || (i != 0 && visit[i - 1] && nums[i] == nums[i - 1])) {
				continue;
			}
			
			visit[i] = true;
			list.add(nums[i]);
			dfs1(nums, list, rst, visit);
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}
	
	public static void dfs2(int[] nums, List<Integer> list, List<List<Integer>> rst, boolean[] visit) {
		if (list.size() == nums.length) {
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		
		long pre = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int value = nums[i];
			if (visit[i] || pre == value) {
				continue;
			}
			pre = value;
			visit[i] = true;
			list.add(value);
			dfs2(nums, list, rst, visit);
			list.remove(list.size() - 1);
			visit[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		System.out.print(permuteUnique(nums));
	}
}
