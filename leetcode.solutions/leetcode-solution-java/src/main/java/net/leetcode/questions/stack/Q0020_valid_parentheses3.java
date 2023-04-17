package net.leetcode.questions.stack;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 定义 Person 类
 *
 * @author liweiwei1419
 * @date 2019/8/23 1:14 AM
 */



public class Q0020_valid_parentheses3 {

    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        // 将 Person 类添加进 HashSet 里面
        set.add(new Person("a1", 11));
        set.add(new Person("a2", 12));
        set.add(new Person("a3", 13));
        // 定义迭代器
        Iterator<Person> it = set.iterator();
        // 开始遍历 HashSet
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p.getName() + "::" + p.getAge());
        }
    }

}
