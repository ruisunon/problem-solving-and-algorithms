# [1151. 最少交换次数来组合所有的 1](https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together)

[English Version](/solution/1100-1199/1151.Minimum%20Swaps%20to%20Group%20All%201's%20Together/README_EN.md)

## 题目描述
<!-- 这里写题目描述 -->
<p>给出一个二进制数组 <code>data</code>，你需要通过交换位置，将数组中 <strong>任何位置</strong> 上的 1 组合到一起，并返回所有可能中所需 <strong>最少的交换次数</strong>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>[1,0,1,0,1]
<strong>输出：</strong>1
<strong>解释： </strong>
有三种可能的方法可以把所有的 1 组合在一起：
[1,1,1,0,0]，交换 1 次；
[0,1,1,1,0]，交换 2 次；
[0,0,1,1,1]，交换 1 次。
所以最少的交换次数为 1。
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>[0,0,0,1,0]
<strong>输出：</strong>0
<strong>解释： </strong>
由于数组中只有一个 1，所以不需要交换。
</pre>

<p><strong>示例 3：</strong></p>

<pre><strong>输入：</strong>[1,0,1,0,1,0,0,1,1,0,1]
<strong>输出：</strong>3
<strong>解释：</strong>
交换 3 次，一种可行的只用 3 次交换的解决方案是 [0,0,0,0,0,1,1,1,1,1,1]。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>1 <= data.length <= 10^5</code></li>
	<li><code>0 <= data[i] <= 1</code></li>
</ol>



## 解法
<!-- 这里可写通用的实现逻辑 -->


<!-- tabs:start -->

### **Python3**
<!-- 这里可写当前语言的特殊实现逻辑 -->

```python

```

### **Java**
<!-- 这里可写当前语言的特殊实现逻辑 -->

```java

```

### **...**
```

```

<!-- tabs:end -->