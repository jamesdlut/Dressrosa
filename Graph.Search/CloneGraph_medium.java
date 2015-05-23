/*
Clone Graph
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/*
SOL 1
图的遍历有两种方式, BFS和DFS,
BFS来解本题, BFS需要使用queue来保存neighbors. 使用Map的主要意义在于充当BFS中Visited数组, 它也可以去环问题, 例如A--B有条边, 当处理完A的邻居node, 然后处理B节点邻居node时发现A已经处理过了. 处理就结束, 不会出现死循环. queue中放置的节点都是未处理neighbors的节点.
SOL 2
递归DFS来解决此题, 思路与上图一致, 但为了避免重复运算产生死循环. 当进入DFS时, 如果发现map中已经有了拷贝过的值, 直接退出即可.
题目虽然简单，但考虑递归的特性使程序简洁. 比如: 我们拷贝只拷贝根节点, 而子节点的拷贝由recursion来完成, 这样可以使程序更加简洁.
注意: 要先加入到map, 再调用rec, 否则会造成不断地反复拷贝而死循环.
*/
