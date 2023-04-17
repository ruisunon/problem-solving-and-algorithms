'''
# 	Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
# 	Example 1:
# 	Input: "babad"
# 	Output: "bab"
# 	Note: "aba" is also a valid answer.
# 	Example 2:
# 	Input: "cbbd"
# 	Output: "bb"
#
'''
class Solution2(object):
    def longestPalindrome(self, s):
        """
        :param s:
        :return:
        """

        left, right = 0, 0;
        maxstr = "";
        listarr=[];
        for i in range(len(s)):
            for k in range(2):

                left = i;
                right = i + k;
                while left > -1 and right < len(s) and s[left] == s[right]:
                    left -= 1;
                    right += 1;
                if (right - left - 1) > len(maxstr):
                    listarr=[];
                    maxstr=s[left+1:right];
                    listarr.append(maxstr);
                elif (right-left-1) ==len(maxstr):
                    listarr.append(s[left+1:right]);

        return listarr;

if __name__ == '__main__':
    # begin
    sol = Solution2();
    print (sol.longestPalindrome("babae"));
