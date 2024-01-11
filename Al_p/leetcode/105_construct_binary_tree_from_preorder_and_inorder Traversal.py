from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder or not inorder:
            return None
        node = TreeNode(preorder[0])
        mid = inorder.index(preorder[0])
        node.left = self.buildTree(preorder[1:mid + 1], inorder[0:mid])
        node.right = self.buildTree(preorder[mid + 1:], inorder[mid + 1:])
        return node


s = Solution()
tree = s.buildTree(preorder=[3, 1, 2, 4], inorder=[1, 2, 3, 4])
print(tree)
