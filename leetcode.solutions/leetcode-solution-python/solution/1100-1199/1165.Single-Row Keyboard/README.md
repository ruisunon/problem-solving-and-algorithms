# [1165. 单行键盘](https://leetcode-cn.com/problems/single-row-keyboard)

[English Version](/solution/1100-1199/1165.Single-Row%20Keyboard/README_EN.md)

## 题目描述
<!-- 这里写题目描述 -->
<p>我们定制了一款特殊的力扣键盘，所有的键都排列在一行上。</p>

<p>我们可以按从左到右的顺序，用一个长度为 26 的字符串 <code>keyboard</code> （索引从 0 开始，到 25 结束）来表示该键盘的键位布局。</p>

<p>现在需要测试这个键盘是否能够有效工作，那么我们就需要个机械手来测试这个键盘。</p>

<p>最初的时候，机械手位于左边起第一个键（也就是索引为 0 的键）的上方。当机械手移动到某一字符所在的键位时，就会在终端上输出该字符。</p>

<p>机械手从索引 <code>i</code> 移动到索引 <code>j</code> 所需要的时间是 <code>|i - j|</code>。</p>

<p>当前测试需要你使用机械手输出指定的单词 <code>word</code>，请你编写一个函数来计算机械手输出该单词所需的时间。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
<strong>输出：</strong>4
<strong>解释：
</strong>机械手从 0 号键移动到 2 号键来输出 'c'，又移动到 1 号键来输出 'b'，接着移动到 0 号键来输出 'a'。
总用时 = 2 + 1 + 1 = 4. 
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
<strong>输出：</strong>73
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>keyboard.length == 26</code></li>
	<li><code>keyboard</code> 按某种特定顺序排列，并包含每个小写英文字母一次。</li>
	<li><code>1 <= word.length <= 10^4</code></li>
	<li><code>word[i]</code> 是一个小写英文字母</li>
</ul>



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