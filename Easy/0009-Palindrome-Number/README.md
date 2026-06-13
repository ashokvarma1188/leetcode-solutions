# 9. Palindrome Number 🔁

🟢 **Easy** | 🏷️ Math | ✅ Beats 100% | ⚡ Step-by-Step Visualization

🔗 [Problem Link](https://leetcode.com/problems/palindrome-number/)

---

> ✅ **IF YOU LIKE THIS SOLUTION, PLEASE ⭐ STAR THIS REPO** 😊

---

## 💡 Intuition

A **palindrome number** reads the **same backward as forward** (e.g., 121, 1331).
To verify this, we **reverse the number** and compare it with the original.

---

## 🔑 Key Observations

| # | Observation |
|---|-------------|
| 1️⃣ | **Negative numbers** → always `false` (because of the `-` sign) |
| 2️⃣ | **Numbers ending with 0** (except 0 itself) → always `false` (reversed number can't start with 0) |

---

## 🧠 Approach

```
Step 1: If x < 0 → return false
Step 2: Copy x into num, initialize rev = 0
Step 3: While num != 0:
           → Extract last digit: num % 10
           → Build reverse: rev = rev * 10 + last digit
           → Remove last digit: num = num / 10
Step 4: If rev == x → palindrome ✅ else ❌
```

---

## 🔍 Step-by-Step Visualization (x = 121)

### **Initial Setup**

<img src="https://github.com/user-attachments/assets/714f532e-2788-4423-80af-ca5f057f840a" width="700"/>

---

### **Variables Initialized**

- `rev = 0`
- `num = 121` (copy of x)

<img src="https://github.com/user-attachments/assets/477ec4c8-df13-44e4-a5d9-915726b1e99d" width="700"/>

---

### **Iteration 1️⃣ (num = 121)**

| Action | Calculation | Result |
|--------|-------------|--------|
| Extract last digit | `121 % 10` | `1` |
| Update rev | `0 * 10 + 1` | `rev = 1` |
| Remove last digit | `121 / 10` | `num = 12` |

<img src="https://github.com/user-attachments/assets/ee319f82-608f-45ac-ae83-688fee11dbad" width="700"/>

---

### **Iteration 2️⃣ (num = 12)**

| Action | Calculation | Result |
|--------|-------------|--------|
| Extract last digit | `12 % 10` | `2` |
| Update rev | `1 * 10 + 2` | `rev = 12` |
| Remove last digit | `12 / 10` | `num = 1` |

<img src="https://github.com/user-attachments/assets/7199e918-9638-4c47-a49e-d8594d003ae3" width="700"/>

---

### **Iteration 3️⃣ (num = 1)**

| Action | Calculation | Result |
|--------|-------------|--------|
| Extract last digit | `1 % 10` | `1` |
| Update rev | `12 * 10 + 1` | `rev = 121` |
| Remove last digit | `1 / 10` | `num = 0` → loop ends |

<img src="https://github.com/user-attachments/assets/43dbe8ee-6723-46fe-95ab-6248808e16d0" width="700"/>

---

### **Final Comparison ✅**

```
rev = 121
x   = 121
121 == 121 → true ✅ It's a Palindrome!
```

<img src="https://github.com/user-attachments/assets/072a0a64-d23a-4dfe-bcab-82669b47f655" width="700"/>

---

## ⏳ Complexity Analysis

| | Complexity |
|---|---|
| ⏱️ Time | O(log n) — digits in the number |
| 🗂️ Space | O(1) |

---

## 💻 Code Implementation

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int rev = 0;
        int num = x;

        while (num != 0) {
            rev = rev * 10 + num % 10;  // build reverse
            num = num / 10;              // remove last digit
        }

        return (rev == x);
    }
}
```

```cpp
class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;

        int rev = 0;
        int num = x;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        return rev == x;
    }
};
```

```python
class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        rev = 0
        num = x

        while num != 0:
            rev = rev * 10 + num % 10
            num = num // 10

        return rev == x
```

---

## 🎯 Beginner Problem List

| # | Problem |
|---|---------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) |
| 2 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) |
| 3 | [Palindrome Number](https://leetcode.com/problems/palindrome-number/) |
| 4 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) |
| 5 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) |
| 6 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) |

---

<p align="center">⭐ If this helped you, please star this repo and upvote on <a href="https://leetcode.com/u/ashokvarma5247/">LeetCode</a> 💪</p>
