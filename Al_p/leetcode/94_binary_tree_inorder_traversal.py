from collections import deque
from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        stack, cur = deque(), root
        res = []

        while stack or cur:
            if cur:
                stack.append(cur)
                cur = cur.left
            else:
                cur = stack.pop()
                res.append(cur.val)
                cur = cur.right
        return res

node1 = TreeNode(10)
node2 = TreeNode(6)
node3 = TreeNode(5)
node4 = TreeNode(8)
node5 = TreeNode(15)
node6 = TreeNode(7)
node7 = TreeNode(9)

node1.left = node2
node1.right = node5
node2.left = node3
node2.right = node4
node4.left = node6
node4.right = node7

print(Solution().inorderTraversal(node1))