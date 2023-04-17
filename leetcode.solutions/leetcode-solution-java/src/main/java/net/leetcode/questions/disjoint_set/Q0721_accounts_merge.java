package net.leetcode.questions.disjoint_set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q0721_accounts_merge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        UnionFind unionFind = new UnionFind(len);
        // 邮箱：用户的编号
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 拿到这个用户的名字和邮箱列表
            List<String> account = accounts.get(i);
            int currentSize = account.size();

            for (int j = 1; j < currentSize; j++) {
                String email = account.get(j);
                Integer personId = hashMap.get(email);
                if (personId == null) {
                    hashMap.put(email, i);
                } else {
                    unionFind.union(i, personId);
                }
            }
        }

        // 用户编号：邮件列表
        Map<Integer, List<String>> emailList = new HashMap<>(len);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {

            String email = entry.getKey();
            Integer personId = entry.getValue();

            // 找到这个人的代表元
            int rootPerson = unionFind.find(personId);
            List<String> rootEmailList = emailList.get(rootPerson);

            if (rootEmailList == null) {
                List<String> temp = new ArrayList<>();
                temp.add(email);
                emailList.put(rootPerson, temp);
            } else {
                rootEmailList.add(email);
            }
        }

        for (int personId : emailList.keySet()) {
            List<String> temp = emailList.get(personId);
            Collections.sort(temp);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(personId).get(0));
            account.addAll(temp);
            res.add(account);
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        List<String> account1 = new ArrayList<>();
        account1.add("John");
        account1.add("johnsmith@mail.com");
        account1.add("john00@mail.com");

        List<String> account2 = new ArrayList<>();
        account2.add("John");
        account2.add("johnnybravo@mail.com");

        List<String> account3 = new ArrayList<>();
        account3.add("John");
        account3.add("johnsmith@mail.com");
        account3.add("john_newyork@mail.com");

        List<String> account4 = new ArrayList<>();
        account4.add("Mary");
        account4.add("mary@mail.com");

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);

        Q0721_accounts_merge solution = new Q0721_accounts_merge();
        List<List<String>> res = solution.accountsMerge(accounts);
        System.out.println(res);
    }
}
