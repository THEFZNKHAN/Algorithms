# Weekly Assessment Set 2

---

## Problem 1: Split Array into Three Equal Sums

### Problem Statement
Given an integer array `arr[]`, divide the array into three non-empty contiguous segments with equal sum. Return an index pair `[i, j]` such that:
- `sum(arr[0…i]) = sum(arr[i+1…j]) = sum(arr[j+1…n-1])`.

If it is impossible to divide the array into three such segments, return `[-1, -1]`.

### Examples
#### Example 1:
**Input:**  
`arr[] = [1, 3, 4, 0, 4]`  
**Output:**  
`[1, 2]`  
**Explanation:**  
Three equal sum segments are:  
- `arr[0…1] = [1, 3]`  
- `arr[2…2] = [4]`  
- `arr[3…4] = [0, 4]`  
Each segment has a sum of `4`.

#### Example 2:
**Input:**  
`arr[] = [2, 3, 4]`  
**Output:**  
`[-1, -1]`  
**Explanation:**  
No three segments exist with equal sum.

#### Example 3:
**Input:**  
`arr[] = [1, -1, 1, -1, 1, -1, 1, -1]`  
**Output:**  
`[1, 3]`  
**Explanation:**  
Three equal sum segments are:  
- `arr[0…1] = [1, -1]`  
- `arr[2…3] = [1, -1]`  
- `arr[4…7] = [1, -1]`  
Each segment has a sum of `0`.

---

## Problem 2: Rotate Each Row of a Matrix K Times

### Problem Statement
Given a matrix of size `N x M` and a number `K`, rotate each row of the matrix clockwise (to the right) `K` times.

### Examples
#### Example 1:
**Input:**  
```
N = 3, M = 3, K = 2  
Matrix:  
12 23 34  
45 56 67  
78 89 91  
```
**Output:**  
```
23 34 12  
56 67 45  
89 91 78  
```

#### Example 2:
**Input:**  
```
N = 2, M = 2, K = 2  
Matrix:  
1 2  
3 4  
```
**Output:**  
```
1 2  
3 4  
```

---

## Problem 3: Smallest Window in a String Containing All Characters of Another String

### Problem Statement
Given two strings `S` (length `m`) and `P` (length `n`), find the smallest substring in `S` that contains all characters of `P`, including duplicates. If no such substring exists, return `"-1"`. If multiple substrings of the same length are found, return the one with the smallest starting index.

### Examples
#### Example 1:
**Input:**  
`S = "timetopractice", P = "toc"`  
**Output:**  
`toprac`  
**Explanation:**  
`"toprac"` is the smallest substring in which `"toc"` can be found.

#### Example 2:
**Input:**  
`S = "zoomlazapzo", P = "oza"`  
**Output:**  
`apzo`  
**Explanation:**  
`"apzo"` is the smallest substring in which `"oza"` can be found.
