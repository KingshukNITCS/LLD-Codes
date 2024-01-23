class Node:
    def __init__(self, url):
        self.url = url
        self.prev = None
        self.next = None

class BrowserHistoryLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def add_page(self, url):
        new_node = Node(url)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            new_node.prev = self.tail
            self.tail.next = new_node
            self.tail = new_node

    def navigate_forward(self):
        if self.tail and self.tail.next:
            self.tail = self.tail.next
            return self.tail.url
        else:
            return None

    def navigate_backward(self):
        if self.tail and self.tail.prev:
            self.tail = self.tail.prev
            return self.tail.url
        else:
            return None

# Example Usage:
browser_linked_list = BrowserHistoryLinkedList()
browser_linked_list.add_page("https://www.example.com/page1")
browser_linked_list.add_page("https://www.example.com/page2")
current_page = browser_linked_list.navigate_backward()
print(f"Current Page: {current_page}")
