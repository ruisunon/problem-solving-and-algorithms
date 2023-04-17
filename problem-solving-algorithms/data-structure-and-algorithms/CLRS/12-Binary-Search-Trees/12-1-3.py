"""
12.1-3

"""

"""Import Statements"""
from collections import deque


class Node:
    """Node of the tree"""

    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


def inorderTraversal(root):
    stack = []
    res = []
    while root is not None or len(stack) > 0:
        while root is not None:
            stack.append(root)
            root = root.left
        root = stack.pop()
        res.append(root.data)
        root = root.right
    return res


if __name__ == "__main__":
    """
            1
           / \
          2   3
         / \  /
        4  5  6
    """
    root = Node(1, Node(2, Node(4), Node(5)), Node(3, Node(6)))
    res_list = []
    res_list = inorderTraversal(root)
    for i in res_list:
        print(i, end=" ")
    print()
