from collections import defaultdict
from typing import List


def findRedundantConnection(edges: List[List[int]]) -> List[int]:
    # variable to keep track of graph constructed so far
    graph_so_far = defaultdict(lambda: [])

    # dfs function to check if path exists between nodes u and v
    def path_exists(u, v):
        # we reached to v from u
        if u == v:
            return True

        # mark u as visited
        visited.add(u)

        # iterate through all the neighbors of u and if they are not visited call dfs on them
        for neighbor in graph_so_far[u]:
            if neighbor not in visited:
                if path_exists(neighbor, v):
                    return True

        return False

    # iterate through all the pairs of edges
    for u, v in edges:
        # we make a fresh visited because we call dfs for every pair of edges
        visited = set()
        # if path exists between u and v return that's the answer
        if path_exists(u, v):
            return [u, v]
        else:
            # if path does not exist we add edges to graph
            graph_so_far[u].append(v)
            graph_so_far[v].append(u)

    return None


# print(findRedundantConnection(edges=[[1, 2], [1, 3], [2, 3]]))
# print(findRedundantConnection(edges=[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]]))


def findRedundantConnectionUnionFind(edges: List[List[int]]) -> List[int]:
    par = [i for i in range(len(edges) + 1)]
    rank = [1] * (len(edges) + 1)

    def find(n):
        p = par[n]
        while p != par[p]:
            par[p] = par[par[p]]
            p = par[p]
        return p

    def union(n1, n2):
        p1, p2 = find(n1), find(n2)
        if p1 == p2:
            return False
        if rank[p1] > rank[p2]:
            par[p2] = p1
            rank[p1] += rank[p2]
        else:
            par[p1] = p2
            rank[p2] += rank[p1]
        return True

    for n1, n2 in edges:
        if not union(n1, n2):
            return [n1, n2]
    return []


# print(findRedundantConnectionUnionFind(edges=[[1, 2], [1, 3], [2, 3]]))
print(findRedundantConnectionUnionFind(edges=[[1, 2], [2, 3], [3, 4], [1, 4], [1, 5]]))

# class Solution:
#     def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
#         nodes = defaultdict(set)
#         for e1, e2 in edges:
#             nodes[e1].add(e2)
#             nodes[e2].add(e1)
#
#         def isTree(node, visited):
#             if node in visited:
#                 return False
#             visited.add(node)
#
#             for nei in nodes[node]:
#                 nodes[nei].remove(node)
#                 if not isTree(nei, visited):
#                     nodes[nei].add(node)
#                     return False
#                 nodes[nei].add(node)
#
#             return True
#
#         def allVisited(visited):
#             for node in nodes.keys():
#                 if node not in visited:
#                     return False
#             return True
#
#         for e1, e2 in edges[::-1]:
#             nodes[e1].remove(e2)
#             nodes[e2].remove(e1)
#             visited = set()
#             if isTree(1, visited) and allVisited(visited):
#                 return [e1, e2]
#             nodes[e1].add(e2)
#             nodes[e2].add(e1)
#
#         return []
