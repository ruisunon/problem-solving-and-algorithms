# [1229. 安排会议日程](https://leetcode-cn.com/problems/meeting-scheduler)

[English Version](/solution/1200-1299/1229.Meeting%20Scheduler/README_EN.md)

## 题目描述
<!-- 这里写题目描述 -->
<p>你是一名行政助理，手里有两位客户的空闲时间表：<code>slots1</code> 和 <code>slots2</code>，以及会议的预计持续时间 <code>duration</code>，请你为他们安排合适的会议时间。</p>

<p>「会议时间」是两位客户都有空参加，并且持续时间能够满足预计时间 <code>duration</code> 的 <strong>最早的时间间隔</strong>。</p>

<p>如果没有满足要求的会议时间，就请返回一个 <strong>空数组</strong>。</p>

<p> </p>

<p>「空闲时间」的格式是 <code>[start, end]</code>，由开始时间 <code>start</code> 和结束时间 <code>end</code> 组成，表示从 <code>start</code> 开始，到 <code>end</code> 结束。 </p>

<p>题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 <code>[start1, end1]</code> 和 <code>[start2, end2]</code>，要么 <code>start1 > end2</code>，要么 <code>start2 > end1</code>。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
<strong>输出：</strong>[60,68]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
<strong>输出：</strong>[]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= slots1.length, slots2.length <= 10^4</code></li>
	<li><code>slots1[i].length, slots2[i].length == 2</code></li>
	<li><code>slots1[i][0] < slots1[i][1]</code></li>
	<li><code>slots2[i][0] < slots2[i][1]</code></li>
	<li><code>0 <= slots1[i][j], slots2[i][j] <= 10^9</code></li>
	<li><code>1 <= duration <= 10^6 </code></li>
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