# [1229. Meeting Scheduler](https://leetcode.com/problems/meeting-scheduler)

[中文文档](/solution/1200-1299/1229.Meeting%20Scheduler/README.md)

## Description
<p>Given the availability time slots arrays <code>slots1</code> and <code>slots2</code> of two people and a meeting duration <code>duration</code>, return the <strong>earliest time slot</strong> that works for both of them and is of duration <code>duration</code>.</p>

<p>If there is no common time slot that satisfies the requirements, return an <strong>empty array</strong>.</p>

<p>The format of a time slot is an array of two elements <code>[start, end]</code> representing an inclusive time range from <code>start</code> to <code>end</code>.  </p>

<p>It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots <code>[start1, end1]</code> and <code>[start2, end2]</code> of the same person, either <code>start1 > end2</code> or <code>start2 > end1</code>.</p>

<p> </p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
<strong>Output:</strong> [60,68]
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
<strong>Output:</strong> []
</pre>

<p> </p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 <= slots1.length, slots2.length <= 10^4</code></li>
	<li><code>slots1[i].length, slots2[i].length == 2</code></li>
	<li><code>slots1[i][0] < slots1[i][1]</code></li>
	<li><code>slots2[i][0] < slots2[i][1]</code></li>
	<li><code>0 <= slots1[i][j], slots2[i][j] <= 10^9</code></li>
	<li><code>1 <= duration <= 10^6 </code></li>
</ul>



## Solutions


<!-- tabs:start -->

### **Python3**

```python

```

### **Java**

```java

```

### **...**
```

```

<!-- tabs:end -->