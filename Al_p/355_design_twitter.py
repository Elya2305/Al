import heapq
from collections import defaultdict
from typing import List


class Twitter:

    def __init__(self):
        self.counter = 0
        self.tweets = defaultdict(list)  # user_id -> list(counter, tweet_id)
        self.followees = defaultdict(set)  # map: user_id -> set(followee_id)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets[userId].append([self.counter, tweetId])
        self.counter -= 1

    def getNewsFeed(self, userId: int) -> List[int]:  # O(n) -> O(10 * k)
        result = []
        heap = []

        tweets = self.tweets[userId]
        idx = len(tweets) - 1
        if tweets:
            heapq.heappush(heap, [tweets[idx][0], tweets[idx][1], userId, idx - 1])
        for followeeId in self.followees[userId]:
            if followeeId in self.tweets:
                tweets = self.tweets[followeeId]
                idx = len(tweets) - 1
                heapq.heappush(heap, [tweets[idx][0], tweets[idx][1], followeeId, idx - 1])

        while heap and len(result) < 10:
            cnt, tweet_id, userId, idx = heapq.heappop(heap)
            result.append(tweet_id)
            if idx >= 0:
                tweets = self.tweets[userId]
                heapq.heappush(heap, [tweets[idx][0], tweets[idx][1], userId, idx - 1])

        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followees[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId in self.followees[followerId]:
            self.followees[followerId].remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)

t = Twitter()
t.postTweet(1, 5)
t.postTweet(1, 3)
t.postTweet(1, 101)
t.postTweet(1, 13)
t.postTweet(1, 10)
t.postTweet(1, 2)
t.postTweet(1, 94)
t.postTweet(1, 505)
t.postTweet(1, 333)
t.postTweet(1, 22)
print(t.getNewsFeed(1))

# arr = [1, 2, 3]
# print(arr[::-1])



