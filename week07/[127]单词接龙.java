//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 661 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //把 wordlist 放到 hashset 中，方便后面判断节点和路径
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        //辅助 bfs 的数据结构
        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        //bfs
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curWord = queue.poll();
                //修改一个字母，看是否是endword，或者是在字典中，做为下一层
                if(changeOneLetterOfWord(curWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    private boolean changeOneLetterOfWord(String beginWord, String endWord,
                                          Queue<String> queue, Set<String> visited, Set<String> wordSet) {
        char [] chars = beginWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //保存要替换位置的字母
            char originChar = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if(ch == originChar) {
                    continue;
                }
                chars[i] = ch;
                //构造新词
                String nextWord = new String(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    //加入下一层
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }

            }
            chars[i] = originChar;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
