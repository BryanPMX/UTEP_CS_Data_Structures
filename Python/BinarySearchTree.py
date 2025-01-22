from Node import *

class BinarySearchTree:
  def __init__(self,root = None):
    self.root = root

  def insert(self, value):
    # Kept this so I wouldnt have to pass self.root in the calls within main function every time
    self._insert(value,self.root)

  def _insert(self, value, node):
    if not node:
      return Node(value)
    else:
      if value <= node.value:
        if node.left is None:
          node.left = Node(value)
        else:
          self._insert(value, node.left)
      else:
        if node.right is None:
          node.right = Node(value)
        else:
          self._insert(value, node.right)

  def search(self, value, node):
    if not node:
      return False
    elif node.value == value:
      return True
    elif value < node.left:
      return self.search(value, node.left)
    else:
      return self.search(value, node.right)

  def delete(self, value):
    self._delete(value,self.root)

  def _delete(self, value, node):
    if not node:
      return False
    elif node.value == value:
      if not node.left and not node.right:
        node = None
        return True
      else:
        node = node.right
        return True
    elif value <= node.value:
      self._delete(value, node.left)
    else:
      self._delete(value, node.right)

  def max_node(self, node):
    while node.right is not None:
      node = node.right
    return node
  
def preOrder(node,res):
    res.append(node.value)
    if node.left:
      preOrder(node.left,res)
    if node.right:
      preOrder(node.right,res)
    return res

def postOrder(node,res):
    if node.left:
      postOrder(node.left,res)
    if node.right:
      postOrder(node.right,res)
    res.append(node.value)
    return res

def inOrder(node,res):
    if node.left:
      inOrder(node.left,res)
    res.append(node.value)
    if node.right:
      inOrder(node.right,res)
    return res

def preOrderWithStack(node,res):
    stack = [node]
    while stack:
      currNode = stack.pop()
      res.append(currNode.value)
      if currNode.right:
        stack.append(currNode.right)
      if currNode.left:
        stack.append(currNode.left)
    return res

from collections import deque
def levelOrder(node):
  # Activity 1
  res = []
  queue = deque([node])
  while queue:
    currLen = len(queue)
    for i in range(currLen):
      currNode = queue.popleft()
      res.append(currNode.value)
      if currNode.left:
        queue.append(currNode.left)
      if currNode.right:
        queue.append(currNode.right)
  return res
  
  
tree = BinarySearchTree(Node(8))
tree.insert(3)
tree.insert(10)
tree.insert(1)
tree.insert(6)
tree.insert(14)
tree.insert(4)
tree.insert(7)
tree.insert(13)

print("Pre Order: " , preOrder(tree.root,[]))
print("Pre Order with Stack: ",preOrderWithStack(tree.root,[]))
print("Post Order: ",postOrder(tree.root,[]))
print("In Order:",inOrder(tree.root,[]))
print("Level Order: ", levelOrder(tree.root))

print("------------------------------------")
tree.delete(13)
print("Deleted Node with value 5")
print("Pre Order: " , preOrder(tree.root,[]))
tree.delete(8)
print("Deleted Node with value 4 (root)")
print("Pre Order: " , preOrder(tree.root,[]))
print("Tree Root: ", tree.root.value)