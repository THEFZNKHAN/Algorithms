## Prefix Sum

### Introduction
The prefix sum is a common algorithmic technique used to preprocess an array of numbers to answer range sum queries efficiently. It is widely used in competitive programming and various algorithmic problems.

### How It Works
The prefix sum array is constructed such that each element at index `i` contains the sum of the elements from the start of the array up to index `i`.

### Example
Given an array `arr = [1, 2, 3, 4, 5]`, the prefix sum array `prefix_sum` would be `[1, 3, 6, 10, 15]`.

### Applications
- Range sum queries
- Finding subarray sums
- Solving problems involving cumulative sums

### Implementation
Here is a simple implementation in Python:

```java
public class PrefixSum {
    public static int[] prefixSum(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        
        return prefixSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = prefixSum(arr);
        for (int sum : result) {
            System.out.print(sum + " ");
        }
        // Output: 1 3 6 10 15
    }
}
```

### Conclusion
The prefix sum technique is a powerful tool for optimizing range sum queries and solving various algorithmic problems efficiently. Understanding and implementing this technique can significantly improve your problem-solving skills in competitive programming and coding interviews.

