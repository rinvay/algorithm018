# 第 9 周学习笔记

## 第 19 课 高级动态规划

### 递归，分治，回溯，动态规划复习

递归：函数自己调用自己

模版

```java
public void recur(int level, int param) {
	//终止条件
	if (level > MAX_LEVEL) {
		//或者处理 result
		return;
	}
	//处理当前层逻辑
	process(level, param);
	//进入下一层
	recur(level + 1, newParam)
	//重置当前状态，通常是回溯的时候
}
```

分治：分解成规模更小的相似的子问题，直到子问题的解能够直接得出，分治是一种思想，代码实现方式通常是递归

模版

```python
def divide_conquer(problem, param1, param2, ...):
	# 递归终止条件
	if problem is None:
		print_result
    return
  # 准备数据
  data = prepare_data(problem)
  # 分解成子问题
  subprolems = split_problem(problem, data)
  # 递归调用，解决子问题
  subresult1 = self.divide_conquer(subproblems[0], param1, ...)
  subresult2 = self.divide_conquer(subproblems[1], param1, ...)
  subresult3 = self.divide_conquer(subproblems[2], param1, ...)
  # 合并子问题的解
  result = process_result(subresult1, subresult2, subresult3, ...)
  
```

动态规划：

和普通的递归问题没有本质区别，区别是具有重复子问题和最优子结构。

解决方法从暴力递归，到通过备忘录优化重复子问题，再到从自顶向下的方式改为自底向上的方式构建 DP table





## 第 20 课 字符串算法

Rabin-Karp 算法

KMP 算法