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
3. 当maxHeap比minHeap多2个值, 直接移动一个值到maxHeap即可.
4. 当maxHeap比minHeap多1个值, 比较顶端的2个值, 如果maxHeap的最大值大于minHeap的最小值, 交换2个值即可.
5. 当maxHeap较大时, 中值是maxHeap的顶值, 否则取2者的顶值的中间值.
*/
