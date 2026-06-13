# 26. Remove Duplicates from Sorted Array 🧹

🟢 **Easy** | 🏷️ Array | ✅ Beginner Friendly | ⚡ Step-by-Step Visualization

🔗 [Problem Link](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

---

> ✅ **IF YOU LIKE THIS SOLUTION, PLEASE ⭐ STAR THIS REPO** 😊

---

## 💡 Intuition

Given a **sorted** array `nums`, remove the duplicates **in-place** such that each unique element appears only **once**. Return the **new length** of the array after removal.

---

## 🔍 Approach & Step-by-Step Visualization

1. **Initialize** `j = 0` (first unique element is already at `nums[0]`).
2. **Loop** from `i = 1` to end:
   - If `nums[i] != nums[i-1]` → new unique element found → store at `nums[j]` → increment `j`
3. Return `j` (number of unique elements).

<img src="https://github.com/user-attachments/assets/4b98f7f0-13ea-47a4-a04b-c35580d748b6" width="700"/>

---

### **Initial Setup**

**Array:** `[1,1,2,2,3,4,4]`  
**Pointers:** `j = 0` | `i = 1`

<img src="https://github.com/user-attachments/assets/5b092ed0-af77-4817-aaa2-99c868b66ff7" width="700"/>

---

### **Iteration 1 (i=1):** Duplicate ❌

- `nums[0]=1` vs `nums[1]=1` → **Duplicate** → Skip

<img src="https://github.com/user-attachments/assets/f40129ee-c043-4a96-9fc1-bbcf066802c8" width="700"/>

---

### **Iteration 2 (i=2):** Unique ✅

- `nums[0]=1` vs `nums[2]=2` → **Unique** → `j=1`, copy 2 to `nums[1]`
- Array: `[1, 2, 2, 2, 3, 4, 4]`

<img src="https://github.com/user-attachments/assets/19e8257b-2838-4967-a398-bc42aa6d1457" width="700"/>

---

### **Iteration 3 (i=3):** Duplicate ❌

- `nums[1]=2` vs `nums[3]=2` → **Duplicate** → Skip

<img src="https://github.com/user-attachments/assets/f13805da-ed10-436a-80c8-0f97c7b40d43" width="700"/>

---

### **Iteration 4 (i=4):** Unique ✅

- `nums[1]=2` vs `nums[4]=3` → **Unique** → `j=2`, copy 3 to `nums[2]`

<img src="https://github.com/user-attachments/assets/81233e8f-e136-4e43-8246-973e2951211f" width="700"/>

---

### **Iteration 5 (i=5):** Unique ✅

- `nums[2]=3` vs `nums[5]=4` → **Unique** → `j=3`, copy 4 to `nums[3]`
- Array: `[1, 2, 3, 4, 3, 4, 4]`

<img src="https://github.com/user-attachments/assets/00681df3-0ba6-48c4-9797-3adedf48acd6" width="700"/>

---

### **Iteration 6 (i=6):** Duplicate ❌

- `nums[3]=4` vs `nums[6]=4` → **Duplicate** → Skip

<img src="https://github.com/user-attachments/assets/ea96d294-ba36-4be6-931f-63be15a9d136" width="700"/>

---

### **Final Result** 🎉

- Array: `[1, 2, 3, 4, _, _, _]`
- Return: `j + 1 = 4`

<img src="https://github.com/user-attachments/assets/7272dd6b-1d4c-47fe-93f4-162f613afd69" width="700"/>

---

## ⏳ Complexity Analysis

| | Complexity |
|---|---|
| ⏱️ Time | O(n) |
| 🗂️ Space | O(1) |

---

## 💻 Code Implementation

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }
}
```

```cpp
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int j = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
};
```

```python
class Solution:
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        j = 0
        for i in range(1, len(nums)):
            if nums[j] != nums[i]:
                j += 1
                nums[j] = nums[i]
        return j + 1
```

---

## 🎯 Beginner Problem List

| # | Problem |
|---|---------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) |
| 2 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) |
| 3 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) |
| 4 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) |
| 5 | [Sum of All Subset XOR Totals](https://leetcode.com/problems/sum-of-all-subset-xor-totals/) |

---

<p align="center">⭐ If this helped you, please star this repo and upvote on <a href="https://leetcode.com/u/ashokvarma5247/">LeetCode</a> 💪</p>
