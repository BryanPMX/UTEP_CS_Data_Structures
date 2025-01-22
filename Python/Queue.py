class Queue:
    """
    A simple implementation of a queue with basic operations:
    enqueue, dequeue, peek, is_empty, and size.
    """

    def __init__(self):
        """
        Initializes an empty queue.
        """
        self.items = []

    def enqueue(self, item):
        """
        Add an item to the end of the queue.
        
        :param item: The item to be added to the queue.
        """
        self.items.append(item)

    def dequeue(self):
        """
        Remove the item from the front of the queue and return it.
        
        :return: The item at the front of the queue.
        :raises IndexError: If the queue is empty.
        """
        if not self.is_empty():
            return self.items.pop(0)
        else:
            raise IndexError("Can't dequeue from empty queue")

    def peek(self):
        """
        Get the item at the front of the queue without removing it.
        
        :return: The item at the front of the queue.
        :raises IndexError: If the queue is empty.
        """
        if not self.is_empty():
            return self.items[0]
        else:
            raise IndexError("Can't peek from empty queue")

    def is_empty(self):
        """
        Check if the queue is empty.
        
        :return: True if the queue is empty, else False.
        """
        return len(self.items) == 0

    def size(self):
        """
        Return the number of items in the queue.
        
        :return: The size of the queue.
        """
        return len(self.items)

# Main method to test the Queue class
if __name__ == "__main__":
    queue = Queue()

    print("Enqueuing items onto queue: 10, 20, 30")
    queue.enqueue(10)
    queue.enqueue(20)
    queue.enqueue(30)

    print(f"Current front of the queue (peek): {queue.peek()}")  # Should print 10
    print(f"Queue size before dequeuing: {queue.size()}")        # Should print 3

    print("Dequeuing items from queue:")
    print(queue.dequeue())  # Should print 10
    print(queue.dequeue())  # Should print 20
    print(queue.dequeue())  # Should print 30

    print("Trying to dequeue from an empty queue:")
    try:
        queue.dequeue()
    except IndexError as e:
        print(e)  # Expected error message

    print("Trying to peek into an empty queue:")
    try:
        print(queue.peek())
    except IndexError as e:
        print(e)  # Expected error message
