To master **Binary Search** on LeetCode, you’ll need to tackle problems that cover classic search patterns, rotated arrays, answer-space binary search, and non-obvious applications. Below’s a curated list categorized by problem type and difficulty, designed to help you solve all variations of binary search questions:

---

### **Classic Binary Search**
1. **[704. Binary Search (Easy)](https://leetcode.com/problems/binary-search)**  
   *Basic template for finding a target in a sorted array.*  
2. **[35. Search Insert Position (Easy)](https://leetcode.com/problems/search-insert-position)**  
   *Find insertion index if target is missing (edge cases for left/right bounds).*  
3. **[34. Find First and Last Position of Element in Sorted Array (Medium)](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array)**  
   *Use binary search to find the first and last occurrence of a target.*  

---

### **Rotated Sorted Arrays**  
4. **[33. Search in Rotated Sorted Array (Medium)](https://leetcode.com/problems/search-in-rotated-sorted-array)**  
   *Find a target in a rotated sorted array (pivot detection).*  
5. **[81. Search in Rotated Sorted Array II (Medium)](https://leetcode.com/problems/search-in-rotated-sorted-array-ii)**  
   *Handle duplicates in rotated arrays (worst-case O(n)).*  
6. **[153. Find Minimum in Rotated Sorted Array (Medium)](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array)**  
   *Locate the pivot (smallest element) in a rotated array.*  
7. **[154. Find Minimum in Rotated Sorted Array II (Hard)](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii)**  
   *Extension of 153 with duplicates (edge cases galore!).*  

---

### **Binary Search on Answer Space**  
8. **[875. Koko Eating Bananas (Medium)](https://leetcode.com/problems/koko-eating-bananas)**  
   *Find the minimum eating speed to finish bananas in `h` hours.*  
9. **[410. Split Array Largest Sum (Hard)](https://leetcode.com/problems/split-array-largest-sum)**  
   *Minimize the largest sum when splitting into `m` subarrays.*  
10. **[1011. Capacity To Ship Packages Within D Days (Medium)](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days)**  
    *Similar to Koko’s problem but for shipping weights.*  
11. **[1482. Minimum Number of Days to Make m Bouquets (Medium)](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets)**  
    *Binary search over possible days to satisfy constraints.*  

---

### **Matrix and 2D Binary Search**  
12. **[74. Search a 2D Matrix (Medium)](https://leetcode.com/problems/search-a-2d-matrix)**  
    *Treat a sorted 2D matrix as a 1D array for binary search.*  
13. **[240. Search a 2D Matrix II (Medium)](https://leetcode.com/problems/search-a-2d-matrix-ii)**  
    *Optimized search in a matrix with sorted rows and columns (start from top-right).*  
14. **[378. Kth Smallest Element in a Sorted Matrix (Medium)](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix)**  
    *Binary search on value range, not indices.*  

---

### **Peaks, Valleys, and Mountain Arrays**  
15. **[162. Find Peak Element (Medium)](https://leetcode.com/problems/find-peak-element)**  
    *Find any peak in an array (logarithmic time without sorting).*  
16. **[852. Peak Index in a Mountain Array (Easy)](https://leetcode.com/problems/peak-index-in-a-mountain-array)**  
    *Simplified version of 162 with strictly increasing/decreasing slopes.*  
17. **[1095. Find in Mountain Array (Hard)](https://leetcode.com/problems/find-in-mountain-array)**  
    *Combination of peak finding and binary search on both sides of the peak.*  

---

### **Advanced Applications**  
18. **[4. Median of Two Sorted Arrays (Hard)](https://leetcode.com/problems/median-of-two-sorted-arrays)**  
    *Merge two sorted arrays conceptually using binary search.*  
19. **[668. Kth Smallest Number in Multiplication Table (Hard)](https://leetcode.com/problems/kth-smallest-number-in-multiplication-table)**  
    *Binary search over the value range with count validation.*  
20. **[528. Random Pick with Weight (Medium)](https://leetcode.com/problems/random-pick-with-weight)**  
    *Use prefix sums and binary search to sample weighted indices.*  
21. **[981. Time Based Key-Value Store (Medium)](https://leetcode.com/problems/time-based-key-value-store)**  
    *Binary search on timestamps to retrieve values.*  

---

### **Non-Obvious Binary Search**  
22. **[287. Find the Duplicate Number (Medium)](https://leetcode.com/problems/find-the-duplicate-number)**  
    *Binary search on value range (not indices) for the repeated number.*  
23. **[719. Find K-th Smallest Pair Distance (Hard)](https://leetcode.com/problems/find-k-th-smallest-pair-distance)**  
    *Binary search on possible distances and count pairs.*  
24. **[1060. Missing Element in Sorted Array (Medium)](https://leetcode.com/problems/missing-element-in-sorted-array)**  
    *Find the kth missing number in a sorted array using binary search.*  

---

### **Key Concepts to Master**  
- **Answer-space binary search**: When the problem asks for a **minimum/maximum valid value** (e.g., Koko’s bananas, ship packages).  
- **Pivot detection**: For rotated arrays (problems 33, 153).  
- **Range reduction**: Binary search on possible values, not indices (problems 378, 668).  
- **Template variations**:  
  - **Leftmost insertion**: `while (left < right)` with `mid = left + (right - left) // 2`.  
  - **Conditional checks**: `nums[mid] >= target` vs. `nums[mid] > target` for first/last occurrence.  

---

### **Workflow Recommendation**  
1. **Basics**: Start with 704, 35, 34.  
2. **Rotated arrays**: 33, 153, 154.  
3. **Answer-space**: 875, 410, 1482.  
4. **Matrix search**: 74, 240, 378.  
5. **Advanced**: 4 (median of arrays), 719 (pair distance).  
6. **Edge cases**: 81 (duplicates in rotated arrays), 154 (duplicates in min search).  

---

### **Common Pitfalls**  
- Infinite loops: Ensure loop termination with `left = mid + 1` or `right = mid`.  
- Off-by-one errors: Test edge cases like single-element arrays or targets outside the range.  
- Misapplying binary search: Not all problems with sorted arrays require binary search (e.g., some use two pointers).  

By solving these problems, you’ll develop an intuition for when and how to apply binary search, even in non-traditional scenarios! 🚀