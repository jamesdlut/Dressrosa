/*
by eamon
Find median with min heap and max heap in Java
股市上一个股票的价格从开市开始是不停的变化的, 需要开发一个系统, 给定一个股票, 它能实时显示从开市到当前时间的这个股票的价格的中位数(中值)
*/
/*
SOL 1
1. 维持两个heap, 一个是最小堆, 一个是最大堆.
2. 一直使maxHeap的size大于minHeap.
3. 当两边size相同时, 比较新插入的value, 如果它大于minHeap的最大值, 把它插入到minHeap. 并且把minHeap的最小值移动到maxHeap.
SOL 2
maxHeap保存较小的半边数据, minHeap保存较大的半边数据.
1. 无论如何, 直接把新值插入到maxHeap.
2. 当minHeap为空, 直接退出.
3. 当maxHeap比minHeap多2个值, 直接移动一个值到minHeap即可.
4. 当maxHeap比minHeap多1个值, 比较顶端的2个值, 如果maxHeap的最大值大于minHeap的最小值, 交换2个值即可.
5. 当maxHeap较大时, 中值是maxHeap的顶值, 否则取2者的顶值的中间值.
*/
public class FindMedianSol {
	private static PriorityQueue<Integer> maxHeap, minHeap;
	
	public static void main(String[] args) {
		// Style 1
		/*
		Comparator<Integer> revCmp = new Comparator<Integer>() {
			@Override
			public int compare(Integer left, Integer right) {
				return right.compareTo(left);
			}
		};
		
		maxHeap = new PriorityQueue<Integer>(20, revCmp);
		minHeap = new PriorityQueue<Integer>(20);
		*/
		// Style 2
		maxHeap = new PriorityQueue<Integer>(20, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		minHeap = new PriorityQueue<Integer>(20);
		
		addNumber2(6);
		addNumber2(4);
		addNumber2(3);
		addNumber2(10);
		addNumber2(12);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());
		addNumber2(5);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());
		addNumber2(7);
		addNumber2(8);
		System.out.println(minHeap);
		System.out.println(maxHeap);
		System.out.println(getMedian());
	}
	/*
	public static void addNumber1(int value) {
		if (maxHeap.size() == minHeap.size()) {
			if (minHeap.peek() != null && value > minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(value);
			} else {
				maxHeap.offer(value);
			}
		} else {
			if (value < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(value);
			} else {
				minHeap.offer(value);
			}
		}
	}
	*/
	public static void addNumber2(int value) {
		maxHeap.offer(value);
		if (maxHeap.size() - minHeap.size() == 2) {
			minHeap.offer(maxHeap.poll());
		} else {
			if (minHeap.isEmpty()) {
				return;
			}
			if (minHeap.peek() < maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(minHeap.poll());
			}
		}
	}
	
	public static double getMedian() {
		if (maxHeap.isEmpty()) {
			return -1;
		}
		
		if (maxHeap.size() > minHeap.size()) {
			return maxHeap.peek();
		} else {
			return (double)(minHeap.peek() + maxHeap.peek()) / 2;
		}
	}
}
/*
 * outputs:
 * [10, 12]
 * [6, 3, 4]
 * 6.0
 * [6, 12, 10]
 * [5, 3, 4]
 * 5.5
 * [7, 8, 10, 12]
 * [6, 5, 4, 3]
 * 6.5
 */
