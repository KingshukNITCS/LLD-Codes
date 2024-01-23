class BrowserHistoryStack:
    def __init__(self):
        self.history_stack = []

    def push(self, url):
        self.history_stack.append(url)

    def pop(self):
        if not self.is_empty():
            return self.history_stack.pop()
        else:
            return None

    def is_empty(self):
        return len(self.history_stack) == 0

    def peek(self):
        if not self.is_empty():
            return self.history_stack[-1]
        else:
            return None

# Example Usage:
browser_stack = BrowserHistoryStack()
browser_stack.push("https://www.example.com/page1")
browser_stack.push("https://www.example.com/page2")
current_page = browser_stack.pop()
print(f"Current Page: {current_page}")
