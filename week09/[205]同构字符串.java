//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。 
//
// 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。 
//
// 示例 1: 
//
// 输入: s = "egg", t = "add"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "foo", t = "bar"
//输出: false 
//
// 示例 3: 
//
// 输入: s = "paper", t = "title"
//输出: true 
//
// 说明: 
//你可以假设 s 和 t 具有相同的长度。 
// Related Topics 哈希表 
// 👍 278 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap();
        int [] struct = new int[s.length()]; //用一个数组来表示字符串的结构，egg = 011
        int dif_char = 0;  //多一个不同的字符就 +1

        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = map.getOrDefault(chars[i], -1);
            if (value == -1) {
                //不在map中，是不同的字符
                value = dif_char;
                map.put(chars[i], value);
                dif_char++;
            }
            struct[i] = value;
        }

        map.clear();
        dif_char = 0;
        chars = t.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = map.getOrDefault(chars[i], -1);
            if (value == -1) {
                value = dif_char;
                map.put(chars[i], value);
                dif_char++;
            }
            if (value != struct[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
