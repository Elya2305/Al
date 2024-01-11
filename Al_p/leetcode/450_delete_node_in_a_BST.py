from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def find_smallest(node):
            if not node.left:
                return node
            return find_smallest(node.left)

        if not root:
            return None
        if root.val < key:
            root.right = self.deleteNode(root.right, key)
        elif root.val > key:
            root.left = self.deleteNode(root.left, key)
        else:
            if not root.left:
                return root.right
            elif not root.right:
                return root.left
            else:
                minVal = find_smallest(root.right)
                root.val = minVal.val
                root.right = self.deleteNode(root.right, minVal.val)

        return root

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

Solution().deleteNode(node1, 10)
print(node1)