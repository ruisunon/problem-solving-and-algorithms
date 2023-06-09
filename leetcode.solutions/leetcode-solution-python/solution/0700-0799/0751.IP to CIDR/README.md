# [751. IP 到 CIDR](https://leetcode-cn.com/problems/ip-to-cidr)

[English Version](/solution/0700-0799/0751.IP%20to%20CIDR/README_EN.md)

## 题目描述
<!-- 这里写题目描述 -->
<p>给定一个起始 IP 地址 <code>ip</code> 和一个我们需要包含的 IP 的数量 <code>n</code>，返回用列表（最小可能的长度）表示的 CIDR块的范围。 </p>

<p>CIDR 块是包含 IP 的字符串，后接斜杠和固定长度。例如：“123.45.67.89/20”。固定长度 “20” 表示在特定的范围中公共前缀位的长度。</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>ip = "255.0.0.7", n = 10
<strong>输出：</strong>["255.0.0.7/32","255.0.0.8/29","255.0.0.16/32"]
<strong>解释：
</strong>转换为二进制时，初始IP地址如下所示（为清晰起见添加了空格）：
255.0.0.7 -> 11111111 00000000 00000000 00000111
地址 "255.0.0.7/32" 表示与给定地址有相同的 32 位前缀的所有地址，
在这里只有这一个地址。

地址 "255.0.0.8/29" 表示与给定地址有相同的 29 位前缀的所有地址：
255.0.0.8 -> 11111111 00000000 00000000 00001000
有相同的 29 位前缀的地址如下：
11111111 00000000 00000000 00001000
11111111 00000000 00000000 00001001
11111111 00000000 00000000 00001010
11111111 00000000 00000000 00001011
11111111 00000000 00000000 00001100
11111111 00000000 00000000 00001101
11111111 00000000 00000000 00001110
11111111 00000000 00000000 00001111

地址 "255.0.0.16/32" 表示与给定地址有相同的 32 位前缀的所有地址，
这里只有 11111111 00000000 00000000 00010000。

总之，答案指定了从 255.0.0.7 开始的 10 个 IP 的范围。

有一些其他的表示方法，例如：
["255.0.0.7/32","255.0.0.8/30", "255.0.0.12/30", "255.0.0.16/32"],
但是我们的答案是最短可能的答案。

另外请注意以 "255.0.0.7/30" 开始的表示不正确，
因为其包括了 255.0.0.4 = 11111111 00000000 00000000 00000100 这样的地址，
超出了需要表示的范围。
</pre>

<p> </p>

<p><strong>注：</strong></p>

<ol>
	<li><code>ip</code> 是有效的 IPv4 地址。</li>
	<li>每一个隐含地址 <code>ip + x</code> (其中 <code>x < n</code>) 都是有效的 IPv4 地址。</li>
	<li><code>n</code> 为整数，范围为 <code>[1, 1000]</code>。</li>
</ol>

<p> </p>



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