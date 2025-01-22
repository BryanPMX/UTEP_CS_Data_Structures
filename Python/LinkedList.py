from Node import *
class LinkedList():
    def __init__(self):
        # linked list will always be initialized empty
        self.head = None

    def append(self, value):
        # convert value to Node 
        new_node = Node(value)

        # check if head is present
        if not self.head:
            # if not, the new node becomes the head
            self.head = new_node
            return 
        
        # head is present
        head = self.head
        # traverse till the end, (appending new values at the end)
        while head.next:
            head = head.next

        # once in the last node, append the new node 
        head.next = new_node

    def prepend(self, value):
        # convert value to Node 
        new_node = Node(value)
        # link the new node to the linkedlist
        new_node.next = self.head
        # make the new node the new head
        self.head = new_node

    def delete(self, value):
        # temporary variable that holds the head
        current  = self.head

        # if the head is the looking value to delete
        if current and current.value == value:
            # delete by assigning it to an empty node
            self.head = current.next
            return
        
        # traverse the linkedlist while keeping track of the previous node
        prev = None
        while current and current.value != value:
            prev = current
            current = current.next
        
        # if the key was not presented in the list
        if current is None:
            return
        
        # unlink the node from the linked list
        prev.next = current.next

    def search(self, value):
        # temporary variable that holds the head
        current = self.head
        # traverse the linkedlist
        while current:
            # if the head is the value
            if current.value == value:
                return current
            # traversing.....
            current = current.next
        print("Not found!")
        return None
    
    def display(self):
        current = self.head
        while current:
            print(current.value, end = " -> ")
            current = current.next
        print("Empty")