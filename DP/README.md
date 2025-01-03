## Dynamic Programming

Dynamic Programming (DP) is a method for solving complex problems by breaking them down into simpler subproblems. It is applicable when the problem can be divided into overlapping subproblems which can be solved independently. The key idea is to store the results of subproblems to avoid redundant computations.

### Key Concepts

1. **Overlapping Subproblems**: The problem can be broken down into smaller, repeating subproblems.
2. **Optimal Substructure**: The optimal solution of the problem can be constructed from the optimal solutions of its subproblems.
3. **Memoization**: Storing the results of expensive function calls and reusing them when the same inputs occur again.
4. **Space Optimization**: Space optimization is a technique used in dynamic programming to reduce the amount of memory used by the algorithm. Instead of storing the results of all subproblems, we only store the results of the most recent subproblems that are necessary to compute the current problem.

### Common DP Problems

- Fibonacci Sequence
- Knapsack Problem
- Longest Common Subsequence
- Coin Change Problem
- Matrix Chain Multiplication

### Solved Questions

Here is a list of dynamic programming problems that I have solved:

1. [Fibonacci Sequence](./src/Fibonacci.java)
2. [Knapsack Problem](./src/UnboundedKnapsack.java)
3. [Longest Common Subsequence](./src/LongestCommonSubsequence.java)
4. [Coin Change Problem](./src/CoinChange.java)
5. [Matrix Chain Multiplication](./src/)
6. [Unique Paths](./src/UniquePaths.java)
7. [Climbing Stairs](./src/)
8. [Longest Increasing Subsequence](./src/PrintLCS.java)
9. [Edit Distance](./src/EditDistance.java)
10. [Partition Equal Subset Sum](./src/)

### Example

Here is a simple example of solving the Fibonacci sequence using DP:

```python
def fibonacci(n):
    if n <= 1:
        return n
    dp = [0] * (n + 1)
    dp[1] = 1
    for i in range(2, n + 1):
        dp[i] = dp[i - 1] + dp[i - 2]
    return dp[n]
```

In this example, we use a list `dp` to store the Fibonacci numbers and build the solution iteratively.

### Conclusion

Dynamic Programming is a powerful technique that can significantly optimize the performance of algorithms by reducing redundant calculations. Understanding and applying DP can help solve a wide range of problems efficiently.
