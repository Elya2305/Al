class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def inorder(node):
    if not node:
        return
    inorder(node.left)
    print(node.val)
    inorder(node.right)


def preorder(node):
    if not node:
        return
    print(node.val)
    preorder(node.left)
    preorder(node.right)


def postorder(node):
    if not node:
        return
    postorder(node.left)
    postorder(node.right)
    print(node.val)


"""
        10
        /\
       6   15
      /\   /\
     5  8 11 16
        /\
       7  9 
"""

node1 = TreeNode(10)
node2 = TreeNode(6)
node3 = TreeNode(5)
node4 = TreeNode(8)
node5 = TreeNode(15)
node6 = TreeNode(7)
node7 = TreeNode(9)
node8 = TreeNode(11)
node9 = TreeNode(16)

node1.left = node2
node1.right = node5
node2.left = node3
node2.right = node4
node4.left = node6
node4.right = node7
node5.left = node8
node5.right = node9

print(" ===INORDER=== ")
inorder(node1)
print(" ===PREORDER=== ")
preorder(node1)
print(" ===POSTORDER=== ")
postorder(node1)
