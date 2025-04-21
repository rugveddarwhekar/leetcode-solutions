class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if len(trust) < n - 1:
            return -1
        
        incoming_trust = [0] * (n + 1)
        outgoing_trust = [0] * (n + 1)

        for a, b in trust:
            incoming_trust[b] += 1
            outgoing_trust[a] += 1
        
        for i in range(1, n+1):
            if (incoming_trust[i] == n-1 and outgoing_trust[i] == 0):
                return i
        
        return -1