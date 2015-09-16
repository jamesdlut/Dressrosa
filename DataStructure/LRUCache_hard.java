/*
LRU Cache
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
/*
SOL 1
使用HashMap + 双向链表实现:
1. 如果需要移除老的节点, 我们从头节点移除.
2. 如果某个节点被访问(SET/GET), 将其移除并挂在双向链表的结尾.
3. 链表满了后, 我们删除头节点.
4. 最近访问的节点在链尾, 最久被访问的节点在链头.
addTail is to add new node in front of the tail
SOL 2
1. OverRide removeEldestEntry 函数, 在Size达到最大值, 删除最长时间未访问的节点
2. 在Get/ Set的时候, 都更新节点, 即删除之, 再添加之, 这样它会作为最新的节点加到双向链表中
*/
public class LRUSol {
	public static class LRUCache1 {
		private class DLink {
			DLink pre;
			DLink next;
			int val;
			int key;
			DLink(int key, int val) {
				this.val = val;
				this.key = key;
				pre = null;
				next = null;
			}
		}
		
		HashMap<Integer, DLink> map;
		DLink head;
		DLink tail;
		int capacity;
		
		public void removeFirst() {
			removeNode(head.next);
		}
		public void removeNode(DLink node) {
			node.pre.next = node.next;
			node.next.pre = node.pre;
		}
		public void addToTail(DLink node) {
			tail.pre.next = node;
			node.pre = tail.pre;
			node.next = tail;
			tail.pre = node;
		}
		
		public LRUCache1(int capacity) {
			map = new HashMap<Integer, DLink>();
			head = new DLink(-1, -1);
			tail = new DLink(-1, -1);
			head.next = tail;
			tail.pre = head;
			this.capacity = capacity;
		}
		
		public int get(int key) {
			if (map.get(key) == null) {
				return -1;
			}
			DLink node = map.get(key);
			removeNode(node);
			addToTail(node);
			return node.val;
		}
		
		public void set(int key, int value) {
			DLink node = map.get(key);
			if (node == null) {
				node = new DLink(key, value);
				map.put(key, node);
			} else {
				node.val = value;
				removeNode(node);
			}
			addToTail(node);
			if (map.size() > capacity) {
				map.remove(head.next.key);
				removeFirst();
			}
		}
	}
	
	public static class LRUCache2 {
		LinkedHashMap<Integer, Integer> map;
		int capacity;
		
		public LRUCache2(final int capacity) {
			map = new LinkedHashMap<Integer, Integer>(capacity) {
				private static final long serialVersionUID = 1L;
				protected boolean removeEldestEntry(Map.Entry eldest) {
					return size() > capacity;
				}
			};
			this.capacity = capacity;
		}
		
		public int get(int key) {
			Integer ret = map.get(key);
			if (ret == null) {
				return -1;
			} else {
				map.remove(key);
				map.put(key, ret);
			}
			return ret;
		}
		
		public void set(int key, int value) {
			map.remove(key);
			map.put(key, value);
		}
	}
	
	public static void main(String[] args) {
		LRUCache1 lrc2 = new LRUCache1(2);
		lrc2.set(1, 3);
		lrc2.set(2, 2);
		lrc2.set(1, 4);
		lrc2.set(4, 2);
		System.out.print(lrc2.get(1));
	}
}
