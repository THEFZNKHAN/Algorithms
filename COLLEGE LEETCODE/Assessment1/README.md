# Weekly Assessment Set 1

## 1. Maximum Rectangle Score

**Submissions:** 2K+  
**Points:** 10  
**Accuracy:** 9.1%  

### Problem Statement

You are given a grid of size `n x m` containing integer values. Your task is to determine the **maximum score** of a valid rectangle that can be formed within the grid.

#### Definition of a Valid Rectangle:
1. All the values inside the rectangle must be **identical**.
2. Each side length of the rectangle should be at least **2 units**.

The **score** of a valid rectangle is the sum of the values of the cells inside it. The goal is to find the valid rectangle with the **highest possible score**.  
If there is no valid rectangle, return `0`.

---

### Examples

#### Example 1:
**Input:**  
`arr = [[1]]`  
**Output:**  
`0`

#### Example 2:
**Input:**  
`arr = [[1, 2, 2], [2, 2, 3], [2, 2, 2]]`  
**Output:**  
`5`

#### Example 3:
**Input:**  
`arr = [[1]]`  
**Output:**  
`0`

---

### Constraints:
- `1 <= n, m <= 500`
- `1 <= arr[i][j] <= 100`

---

## 2. Generate a Matrix with Each Row and Column of Given Sum

**Submissions:** 1K+  
**Points:** 10  
**Accuracy:** 43.99%  

### Problem Statement

Given two integer arrays `rowSum[]` of size `n` and `colSum[]` of size `m`, the task is to construct a 2D matrix of size `n x m` such that:
- The sum of matrix elements in the `i-th` row is `rowSum[i]`.
- The sum of matrix elements in the `j-th` column is `colSum[j]`.

**Note:** Since multiple answers are possible, return any one of them. Arrays are generated such that an answer is always possible. The driver code will print `true` if the output matrix is correct, otherwise it will print `false`.

---

### Examples

#### Example 1:
**Input:**  
`rowSum[] = [5, 7, 10]`  
`colSum[] = [8, 6, 8]`  
**Output:**  
`true`  
**Explanation:**  
For the matrix `[[5, 0, 0], [6, 1, 0], [2, 0, 8]]`, we have:  
- Row 1 with sum equal to `5` and column 1 with sum equal to `8`.  
- Row 2 with sum equal to `7` and column 2 with sum equal to `6`.  
- Row 3 with sum equal to `10` and column 3 with sum equal to `8`.

#### Example 2:
**Input:**  
`rowSum[] = [1, 0]`  
`colSum[] = [1]`  
**Output:**  
`true`  
**Explanation:**  
For the matrix `[[1], [0]]`, we have:  
- Row 1 with sum equal to `1` and column 1 with sum equal to `1`.  
- Row 2 with sum equal to `0`.

---

### Constraints:
- `1 <= n, m <= 10^3`
- `1 <= rowSum[i] <= 10^3`
- `1 <= colSum[i] <= 10^3`

---

## 3. Minimum Length of Subarray with Positive Sum

**Submissions:** 2K+  
**Points:** 30  
**Accuracy:** 10.26%  

### Problem Statement

Geek has an array `A` having `n` elements. You need to determine the minimum length of a subarray starting from index `i`, such that the sum of the subarray is strictly greater than `0`. You need to calculate the length for all `i` in the range `1` to `n`. If no such subarray exists, return `0`.

---

### Examples

#### Example 1:
**Input:**  
`A = [1, -2, 3]`  
**Output:**  
`[3, 1, 1]`  
**Explanation:**  
- For index `0`, we need to take the whole array for the sum to be positive.  
- For the other two indices, taking only a single element makes the sum positive.

#### Example 2:
**Input:**  
`A = [-1, 2, -3, -4, 5]`  
**Output:**  
`[0, 2, 1, 0, 1]`  
**Explanation:**  
- For index `0` and `3`, no subarray with positive sum exists.  

---

### Your Task

This is a function problem. The input is already taken care of by the driver code. You only need to complete the function `findAnswer()` that takes the array `A` as an input argument. The driver code takes care of the printing.

---

### Constraints:
- `1 <= n <= 10^5`
- `-10^9 <= A[i] <= 10^9`