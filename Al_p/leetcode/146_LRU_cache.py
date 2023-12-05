import collections


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.recently_used = collections.deque()

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        self._move_key_to_end(key)
        return self.cache[key]

    def _move_key_to_end(self, key: int):  # O(n)...
        self.recently_used.remove(key)
        self.recently_used.append(key)

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key] = value
            self._move_key_to_end(key)
        else:
            if len(self.cache) == self.capacity:
                old_key = self.recently_used.popleft()
                self.cache.pop(old_key)
            self.cache[key] = value
            self.recently_used.append(key)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)


class LRUCacheO1:
    class ListNode:
        def __init__(self, val=-1, next=None, prev=None):
            self.val = val
            self.next = next
            self.prev = prev

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.recently_used = None

        self.left = None
        self.right = None

    def get(self, key: int) -> int:

        pass

    def put(self, key: int, value: int) -> None:
        if key in self.recently_used:
            node = self.recently_used[key]
            node.val = value

