//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 265 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        long x = (long)n;
        return x <= 0 ? false : (x & -x) == x; // x & -x 获取最低位的 1

       // return x <= 0 ? false : (x & (x-1) == 0); // x & (x-1) 将最低位的 1 设为 0

    }
}
//leetcode submit region end(Prohibit modification and deletion)
