from typing import List


class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        size = len(nums)
        left = 1
        right = size - 1

        while left < right:
            mid = (left + right + 1) >> 1

            cnt = 0
            for num in nums:
                if num < mid:
                    cnt += 1
            # 根据抽屉原理，严格小于 4 的数的个数如果大于等于 4 个，
            # 此时重复元素一定出现在 [1, 3] 区间里

            if cnt >= mid:
                # 重复的元素一定出现在 [left, mid - 1] 区间里
                # 那么重复的数一定位于 1、2、3
                right = mid - 1
            else:
                # if 分析正确了以后，else 搜索的区间就是 if 的反面
                # [mid, right]
                # 注意：此时需要调整中位数的取法为上取整
                left = mid
        return left
