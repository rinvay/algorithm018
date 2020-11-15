# 第四周学习笔记

## 第 9 课 深度优先和广度优先搜索



深度优先搜索（dfs）

递归

```java
Set<TreeNode> visited = new HashSet();
public void dfs(TreeNode node, Set visited) {
  //terminator
  if (visited.contains(node)) {
    return;
  }
  visited.add(node);
  //process current node
  ...
  //drill down
  for (TreeNode child : node.childrens()) {
      dfs(child, visited);
  }
}
```

非递归（借助栈Stack来转化）

```java
public void dfs(TreeNode node) {
  Stack stack = new Stack();
  stack.push(node);
  
  while(!stack.isEmpty()) {
    TreeNode node = stack.pop();
		//process current node
    ...
    //重点：先放右子节点，后放左子节点
    if(node.right != null) {
      stack.push(node.right);
    }
    if(node.left != null) {
      stack.push(node.right);
    }
  }
}
```





广度优先搜索（bfs）

```java
public List<List<Integer>> bfs(TreeNode node) {
  List<List<Integer>> allResults = new ArrayList();
  if (node == null) {
  	return allResults;  
  }

  Queue<TreeNode> nodes = new LinkedList<>();
  nodes.add(node);
  
  while(!queue.isEmpty()) {
    int size = nodes.size();
    List<Integer> results = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      TreeNode node = nodes.poll();
      //同一层的节点
      results.add(node);
      if (node.left != null) {
        nodes.add(node.left);
      }
      if (node.right != null) {
        nodes.add(node.right);
      }
    }
    allResults.add(result);
  }
  return allResults;
}
```



## 第 10 课 贪心算法

贪心算法是一种在每一步选择中都采取当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。

和动态规划相比，贪心算法不能回退，动态规划可以。



## 第 11 课 二分查找

二分查找的前提：

1. 目标有序
2. 存在上下界
3. 能够通过索引访问

代码模版：

```python
left, right = 0, len(array)-1
while left <= right:
	mid = (left + right)/2
  if array[mid] == target:
    # find the target!!
    break or return result
  elif array[mid] < target:
    left = mid + 1
  else:
    right = mid - 1
```

