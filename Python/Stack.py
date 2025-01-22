class Stack:
    """
    A simple implementation of a stack with basic operations:
    push, pop, and peek.
    """

    def __init__(self):
        """
        Initializes an empty stack.
        """
        self.items = []

    def push(self, item):
        """
        Add an item to the top of the stack.
        
        :param item: The item to be added to the stack.
        """
        self.items.append(item)

    def pop(self):
        """
        Remove the item at the top of the stack and return it.
        
        :return: The item at the top of the stack.
        :raises IndexError: If the stack is empty.
        """
        if not self.is_empty():
            return self.items.pop()
        else:
            raise IndexError("Can't pop from empty stack")

    def peek(self):
        """
        Get the item at the top of the stack without removing it.
        
        :return: The item at the top of the stack.
        :raises IndexError: If the stack is empty.
        """
        if not self.is_empty():
            return self.items[-1]
        else:
            raise IndexError("Can't peek from empty stack")

    def is_empty(self):
        """
        Check if the stack is empty.
        
        :return: True if the stack is empty, else False.
        """
        return len(self.items) == 0

    def size(self):
        """
        Return the number of items in the stack.
        
        :return: The size of the stack.
        """
        return len(self.items)

# Main method to test the Stack class
if __name__ == "__main__":
    stack = Stack()

    print("Pushing items onto stack: 10, 20, 30")
    stack.push(10)
    stack.push(20)
    stack.push(30)

    print(f"Current top of the stack (peek): {stack.peek()}")  # Should print 30
    print(f"Stack size before popping: {stack.size()}")        # Should print 3

    print("Popping items from stack:")
    print(stack.pop())  # Should print 30
    print(stack.pop())  # Should print 20
    print(stack.pop())  # Should print 10

    print("Trying to pop from an empty stack:")
    try:
        stack.pop()
    except IndexError as e:
        print(e)  # Expected error message

    print("Trying to peek into an empty stack:")
    try:
        print(stack.peek())
    except IndexError as e:
        print(e)  # Expected error message
