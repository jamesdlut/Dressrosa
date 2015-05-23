/*
Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/
/*
这道题目在分布式系统中非常常见, 来自不同client的sorted list要在central server上面merge起来
SOL 1 Divide Conquer
先把k个list分成两半, 然后继续划分, 直到剩下两个list就合并起来, 合并时会用到Merge Two Sorted Lists这道题,
假设总共有k个list, 每个list的最大长度是n, 
T(k) = 2T(k / 2) + O(nk)
     = 2(2T(k / 2^2) + O(nk / 2)) + O(nk) = 4T(k / 4) + 2O(nk)
     = 4(2T(k / 2^3) + O(nk / 2^2)) + 2O(nk) = 8T(k / 2^3) + 3O(nk)
     ...
     = O(nklogk)
空间复杂度的话是递归栈的大小O(logk).
SOL 2, SOL 3,
维护一个大小为k的堆, 每次取堆顶的最小元素放到结果中, 然后读取该元素的下一个元素放入堆中, 重新维护好。因为每个链表是有序的, 每次又是去当前k个元素中最小的, 所以当所有链表都读完时结束, 这个时候所有元素按从小到大放在结果链表中。
这个算法每个元素要读取一次, 即是k*n次, 然后每次读取元素要把新元素插入堆中要logk的复杂度, 所以总时间复杂度是O(nklogk)。
空间复杂度是堆的大小, 即为O(k).
note: “空间复杂度”指占内存大小, “堆排序”每次只对一个元素操作, 是就地排序, 所用辅助空间O(1), 注意和本题区别
*/
public class mergeKListsSol {
	// SOL 1
	public static ListNode mergeKLists1(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return helper1(lists, 0, lists.size() - 1);
	}
	
	public static ListNode helper1(List<ListNode> lists, int l, int r) {
		if (l < r) {
			int mid = l + (r - 1) / 2;
			return merge(helper1(lists, l, mid), helper1(lists, mid + 1, r));
		}
		return lists.get(l);
	}
	
	public static ListNode merge(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				cur.next = n1;
				n1 = n1.next;
			} else {
				cur.next = n2;
				n2 = n2.next;
			}
			cur = cur.next;
		}
		if (n1 != null) {
			cur.next = n1;
		} else {
			cur.next = n2;
		}
		return dummy.next;
	}
	// SOL 2 min heap
	public static ListNode mergeKLists2(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		
		Queue<ListNode> heap2 = new PriorityQueue<ListNode>(lists.size(), Comparator2);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i) != null) {
				heap2.add(lists.get(i));
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap2.isEmpty()) {
			ListNode head = heap2.poll();
			tail.next = head;
			tail = head;
			if (head.next != null) {
				heap2.add(head.next);
			}
		}
		return dummy.next;
	}
	
	private static Comparator<ListNode> Comparator2 = new Comparator<ListNode>() {
		public int compare(ListNode left, ListNode right) {
			if (left == null) {
				return 1;
			} else if (right == null) {
				return -1;
			}
			return left.val - right.val;
		}
	};
	// SOL 3 min heap
	public static ListNode mergeKLists3(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		int size = lists.size();
		PriorityQueue<ListNode> heap3 = new PriorityQueue<ListNode>(size,
				new Comparator<ListNode>() {
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		
		for (ListNode node : lists) {
			if (node != null) {
				heap3.offer(node);
			}
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!heap3.isEmpty()) {
			ListNode cur = heap3.poll();
			tail.next = cur;
			tail = tail.next;
			if (cur.next != null) {
				heap3.offer(cur.next);
			}
		}
		return dummy.next;
	}
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(3);
		ListNode n8 = new ListNode(5);
		ListNode n9 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = null;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		n7.next = n8;
		n8.next = n9;
		n9.next = null;
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(n1);
		lists.add(n4);
		lists.add(n7);
		for (int i = 0; i < lists.size(); i++) {
			ListNode tmp = lists.get(i);
			while (tmp != null) {
				System.out.print(tmp.val);
				tmp = tmp.next;
			}
			System.out.print("\n");
		}
		ListNode rst1 = mergeKLists3(lists);
		while (rst1 != null) {
			System.out.print(rst1.val);
			rst1 = rst1.next;
		}
	}
}
