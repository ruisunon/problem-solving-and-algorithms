package net.leetcode.questions.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0316_remove_duplicate_letters_a {

    public String removeDuplicateLetters(String s) {
        int len = s.length();
        // 预处理，我把一个字符出现的最后一个位置记录下来
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), i);
        }

        // 保存已经出现过的
        Set<Character> set = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {

            Character curChar = s.charAt(i);
            if (set.contains(curChar)) {
                continue;
            }

            // 注意：这里条件判断语句很长，map.get(stack.peek()) 不要写成了 map.get(curChar)
            while (!stack.isEmpty() && map.get(stack.peek()) > i && curChar < stack.peek()) {
                // 出栈的同时，也要从哈希表中移除
                set.remove(stack.pop());
            }

            stack.push(curChar);
            set.add(curChar);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q0027_remove_element solution = new Q0027_remove_element();
        String res = solution.removeDuplicateLetters("cbacdcbc");
        System.out.println(res);
    }
}