package net.leetcode.questions.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q0071_simplify_path {

    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String p : paths) {
            if (!stack.isEmpty() && "..".equals(p)) {
                stack.removeLast();
            }
            if (!"".equals(p) && !".".equals(p) && !"..".equals(p)) {
                stack.addLast(p);
            }
        }

        // 输出路径字符串
        StringBuilder s = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            s.insert(0, "/" + stack.removeLast());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        // String s = "/a/.////b/../../c/";
        String s = "/../";
        String simplifyPath = new Q0027_remove_element().simplifyPath(s);
        System.out.println(simplifyPath);
    }
}