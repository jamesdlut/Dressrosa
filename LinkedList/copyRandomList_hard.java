/*
Copy List with Random Pointer 
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
*/
/*
SOL 2
head1 -> newNode1 -> head2 -> newNode2 -> head3 -> newNode3 -> ... -> Random1 -> Random1Copy -> ...
before copyNext, due to "newNode.random = head.random", so head1.random points to Random1 and newNode1.random points to Random1, 
after copyNext, we need head1.random points to Random1, newNode1 points to Random1Copy, notice that Random1.next = Random1Copy, so "head.next.random = head.random.next".
*/
public class copyRandomListSol {
	// SOL 1
	public static RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null) {
			return null;
		}
		
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy;
		RandomListNode newNode;
		while (head != null) {
			if (map.containsKey(head)) {
				newNode = map.get(head);
			} else {
				newNode = new RandomListNode(head.label);
				map.put(head, newNode);
			}
			
			pre.next = newNode;
			
			if (head.random != null) {
				if (map.containsKey(head.random)) {
					newNode.random = map.get(head.random);
				} else {
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}
			
			pre = newNode;
			head = head.next;
		}
		return dummy.next;
	}
	// SOL 2
	public static RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) {
			return null;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}
	
	private static void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.random = head.random;
			newNode.next = head.next;
			head.next = newNode;
			head = head.next.next;
		}
	}
	
	private static void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}
	
	private static RandomListNode splitList(RandomListNode head) {
		RandomListNode newHead = head.next;
		while (head != null) {
			RandomListNode tmp = head.next;
			head.next = tmp.next;
		    head = head.next;
		    if (tmp.next != null) {
		    	tmp.next = tmp.next.next;
		    }
		}
		return newHead;
	}
	
	public static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {
			this.label = x;
		}
	}
	
	public static void main(String[] args) {
		RandomListNode node = new RandomListNode(-1);
		RandomListNode copy = copyRandomList1(node);
	}
}
