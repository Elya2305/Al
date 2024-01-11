# LinkedList

class BrowserHistory:
    class Page:
        def __init__(self, val: str):
            self.val = val
            self.prev = None
            self.next = None

    def __init__(self, homepage: str):
        self.cur = BrowserHistory.Page(homepage)

    def visit(self, url: str) -> None:
        page = BrowserHistory.Page(url)
        self.cur.next = page
        page.prev = self.cur
        self.cur = page

    def back(self, steps: int) -> str:
        while steps > 0 and self.cur.prev:
            self.cur = self.cur.prev
            steps -= 1
        return self.cur.val

    def forward(self, steps: int) -> str:
        while steps > 0 and self.cur.next:
            self.cur = self.cur.next
            steps -= 1
        return self.cur.val


# Array / Stack
class BrowserHistory2:
    def __init__(self, homepage: str):
        self.i = 0
        self.len = 1
        self.history = [homepage]

    def visit(self, url: str) -> None:
        new_len = self.i + 2
        if new_len <= len(self.history):
            self.history[self.i + 1] = url
        else:
            self.history.append(url)
        self.i += 1
        self.len = new_len

    def back(self, steps: int) -> str:
        self.i = max(0, self.i - steps)
        return self.history[self.i]

    def forward(self, steps: int) -> str:
        self.i = min(self.len - 1, self.i + steps)
        return self.history[self.i]
