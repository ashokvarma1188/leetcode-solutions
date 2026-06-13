# 141. Linked List Cycle 🔄

🟢 **Easy** | 🏷️ Linked List | Two Pointers | ✅ 0ms | 🏆 Beats 100%

🔗 [Problem Link](https://leetcode.com/problems/linked-list-cycle/)

---

> ✅ **IF YOU LIKE THIS SOLUTION, PLEASE ⭐ STAR THIS REPO** 😊

---

## 💡 Intuition — Floyd's Cycle Detection Algorithm

> 🐢 **Slow pointer** moves **1 step** at a time
> 🐇 **Fast pointer** moves **2 steps** at a time
>
> If a **cycle exists** → they will **meet** inside the cycle
> If **no cycle** → fast pointer reaches `null`

This is also called **"Tortoise and Hare Algorithm"** 🐢🐇

---

## 🧠 Approach

```
1. Start both slow 🐢 and fast 🐇 at head
2. Move slow by 1 step → slow = slow.next
3. Move fast by 2 steps → fast = fast.next.next
4. If slow == fast → CYCLE DETECTED ✅ return true
5. If fast == null → NO CYCLE ❌ return false
```

---

## 🎬 Step-by-Step Visualization

### 📌 Example
```
List:  1 → 2 → 3 → 4 → 5 → 6
                    ↑           |
                    |___________|
                    (cycle back to 4)
```

---

### 🟢 Initial State

```
1 → 2 → 3 → 4 → 5 → 6
🐢                          (slow at 1)
🐇                          (fast at 1)
```

<img src="https://github.com/user-attachments/assets/beb8356f-097b-4af9-9206-363164ec440a" width="700"/>

---

### 🔵 Iteration 1

```
slow 🐢 moves → 1 step
fast 🐇 moves → 2 steps

1 → 2 → 3 → 4 → 5 → 6
    🐢  🐇
```

| Pointer | Moved To |
|---------|----------|
| 🐢 slow | Node 2 |
| 🐇 fast | Node 3 |

<img src="https://github.com/user-attachments/assets/f684958e-2832-4d8d-873e-f0ceaf86d828" width="700"/>

---

### 🟡 Iteration 2

```
slow 🐢 moves → 1 step
fast 🐇 moves → 2 steps

1 → 2 → 3 → 4 → 5 → 6
        🐢      🐇
```

| Pointer | Moved To |
|---------|----------|
| 🐢 slow | Node 3 |
| 🐇 fast | Node 5 |

<img src="https://github.com/user-attachments/assets/5b0c0a0c-70ac-43f0-a830-670d302f2333" width="700"/>

---

### 🟠 Iteration 3

```
slow 🐢 moves → 1 step
fast 🐇 loops back (cycle!) → moves 2 steps

1 → 2 → 3 → 4 → 5 → 6
        🐇 🐢
```

| Pointer | Moved To |
|---------|----------|
| 🐢 slow | Node 4 |
| 🐇 fast | Node 3 (looped back!) |

<img src="https://github.com/user-attachments/assets/37afe99a-3c0b-44fb-813a-200e84d0b4d3" width="700"/>

---

### 🔴 Iteration 4 — CYCLE DETECTED! 🎯

```
slow 🐢 moves → 1 step
fast 🐇 moves → 2 steps

1 → 2 → 3 → 4 → 5 → 6
               🐢
               🐇
```

| Pointer | Moved To |
|---------|----------|
| 🐢 slow | Node 5 |
| 🐇 fast | Node 5 |

```
🐢 == 🐇  →  CYCLE DETECTED! ✅  →  return true
```

<img src="https://github.com/user-attachments/assets/5d874013-c6dd-45a5-82b6-7312675583da" width="700"/>

---

## ⏳ Complexity Analysis

| | Complexity | Reason |
|---|---|---|
| ⏱️ Time | O(n) | At most n iterations |
| 🗂️ Space | O(1) | Only 2 pointers used |

---

## 💻 Code Implementation

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // 🐢 1 step
            fast = fast.next.next;   // 🐇 2 steps

            if (slow == fast) {
                return true;  // 🎯 Cycle Detected!
            }
        }
        return false;  // ❌ No Cycle
    }
}
```

```cpp
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;

        while (fast != nullptr && fast->next != nullptr) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) return true;
        }
        return false;
    }
};
```

```python
class Solution(object):
    def hasCycle(self, head):
        slow = head
        fast = head

        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True  # 🎯 Cycle Detected!

        return False  # ❌ No Cycle
```

---

## 🗺️ Algorithm Flow Diagram

```
        START
          │
          ▼
    slow = head
    fast = head
          │
          ▼
   ┌─────────────────────┐
   │ fast != null AND     │ ──NO──→ return FALSE ❌
   │ fast.next != null    │
   └─────────────────────┘
          │ YES
          ▼
    slow = slow.next  (🐢 +1)
    fast = fast.next.next (🐇 +2)
          │
          ▼
   ┌─────────────┐
   │ slow == fast │ ──YES──→ return TRUE ✅ (Cycle!)
   └─────────────┘
          │ NO
          └──────────────────(loop back)
```

---

## 🎯 Beginner Problem List

| # | Problem | Topic |
|---|---------|-------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Array |
| 2 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | Array |
| 3 | [Palindrome Number](https://leetcode.com/problems/palindrome-number/) | Math |
| 4 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | Linked List |
| 5 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | Linked List |
| 6 | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Array |

---

<p align="center">⭐ If this helped you, please star this repo and upvote on <a href="https://leetcode.com/u/ashokvarma5247/">LeetCode</a> 💪</p>
