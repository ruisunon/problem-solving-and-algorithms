# [1152. 用户网站访问行为分析](https://leetcode-cn.com/problems/analyze-user-website-visit-pattern)

[English Version](/solution/1100-1199/1152.Analyze%20User%20Website%20Visit%20Pattern/README_EN.md)

## 题目描述
<!-- 这里写题目描述 -->
<p>为了评估某网站的用户转化率，我们需要对用户的访问行为进行分析，并建立用户行为模型。日志文件中已经记录了用户名、访问时间 以及 页面路径。</p>

<p>为了方便分析，日志文件中的 <code>N</code> 条记录已经被解析成三个长度相同且长度都为 <code>N</code> 的数组，分别是：用户名 <code>username</code>，访问时间 <code>timestamp</code> 和 页面路径 <code>website</code>。第 <code>i</code> 条记录意味着用户名是 <code>username[i]</code> 的用户在 <code>timestamp[i]</code> 的时候访问了路径为 <code>website[i]</code> 的页面。</p>

<p>我们需要找到用户访问网站时的 『共性行为路径』，也就是有最多的用户都 <strong>至少按某种次序访问过一次</strong> 的三个页面路径。需要注意的是，用户 <strong>可能不是连续访问</strong> 这三个路径的。</p>

<p>『共性行为路径』是一个 <strong>长度为 3</strong> 的页面路径列表，列表中的路径 <strong>不必不同</strong>，并且按照访问时间的先后升序排列。</p>

<p>如果有多个满足要求的答案，那么就请返回按字典序排列最小的那个。（页面路径列表 <code>X</code> 按字典序小于 <code>Y</code> 的前提条件是：<code>X[0] < Y[0]</code> 或 <code>X[0] == Y[0] 且 (X[1] < Y[1] 或 X[1] == Y[1] 且 X[2] < Y[2])</code>）</p>

<p>题目保证一个用户会至少访问 3 个路径一致的页面，并且一个用户不会在同一时间访问两个路径不同的页面。</p>

<p> </p>

<p><strong>示例：</strong></p>

<pre><strong>输入：</strong>username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
<strong>输出：</strong>["home","about","career"]
<strong>解释：</strong>
由示例输入得到的记录如下：
["joe", 1, "home"]
["joe", 2, "about"]
["joe", 3, "career"]
["james", 4, "home"]
["james", 5, "cart"]
["james", 6, "maps"]
["james", 7, "home"]
["mary", 8, "home"]
["mary", 9, "about"]
["mary", 10, "career"]
有 <strong>2</strong> 个用户至少访问过一次 ("home", "about", "career")。
有 <strong>1</strong> 个用户至少访问过一次 ("home", "cart", "maps")。
有 <strong>1</strong> 个用户至少访问过一次 ("home", "cart", "home")。
有 <strong>1</strong> 个用户至少访问过一次 ("home", "maps", "home")。
有 <strong>1</strong> 个用户至少访问过一次 ("cart", "maps", "home")。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ol>
	<li><code>3 <= N = username.length = timestamp.length = website.length <= 50</code></li>
	<li><code>1 <= username[i].length <= 10</code></li>
	<li><code>0 <= timestamp[i] <= 10^9</code></li>
	<li><code>1 <= website[i].length <= 10</code></li>
	<li><code>username[i]</code> 和 <code>website[i]</code> 都只含小写字符</li>
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