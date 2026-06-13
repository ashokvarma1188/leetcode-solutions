# 206. Reverse Linked List 🔁

🟢 **Easy** | 🏷️ Linked List | ✅ Beats 100% | ⚡ 0ms

🔗 [Problem Link](https://leetcode.com/problems/reverse-linked-list/)

---

> ✅ **IF YOU LIKE THIS SOLUTION, PLEASE ⭐ STAR THIS REPO** 😊

---

## 💡 Intuition

### **Iterative Approach:**
- Use two pointers: `prev` (starts as `null`) and `curr` (starts at `head`).
- At each step:
  1. Store `curr.next` in `temp`.
  2. Reverse `curr.next` to point to `prev`.
  3. Move `prev` to `curr` and `curr` to `temp`.
- Repeat until `curr` is `null`.
- `prev` becomes the new head of the reversed list.

### **Visualization:**
- Original list : `1 -> 2 -> 3 -> 4 -> 5 -> null`
- Reversed list : `5 -> 4 -> 3 -> 2 -> 1 -> null`

---

## 🔍 Approach & Step-by-Step Visualization

<img src="https://github.com/user-attachments/assets/49fdcbd1-b153-41c9-b0c9-829da512d9ec" width="480"/>

> Here Assume `(next = temp)`

**`prev = null`** → prev starts as null because there's no node before the head.

**`curr = head`** → curr points to the first node (head) of the list.

<img src="https://github.com/user-attachments/assets/e524eef1-5fdb-4672-be0a-4f8d76395685" width="700"/>

---

## **Step 1: Save the Next Node**
**Code:** `ListNode temp = curr.next;`

**Action:** Save the next node of curr in a temporary variable temp.

```
curr -> 1
temp -> 2
```

<img src="https://github.com/user-attachments/assets/d2a3dc5a-fee5-48bb-a10c-6b73217f84b0" width="700"/>

---

## **Step 2: Reverse the Link**
**Code:** `curr.next = prev;`

**Action:** Reverse the link of curr to point to prev.

```
null <- 1    2 -> 3 -> 4 -> 5 -> null
```

<img src="https://github.com/user-attachments/assets/9de84f6d-5690-4ece-b1bd-2d0e413e1210" width="700"/>

---

## **Step 3: Move `prev` to `curr`**
**Code:** `prev = curr;`

**Action:** Move `prev` to the current node (`curr`).

```
prev -> 1
curr -> 1
temp -> 2
```

<img src="https://github.com/user-attachments/assets/b513b5cd-71d7-46db-850e-e6a478b641ab" width="700"/>

---

## **Step 4: Move `curr` to `temp`**
**Code:** `curr = temp;`

**Action:** Move `curr` to the next node (saved in `temp`).

```
prev -> 1
curr -> 2
temp -> 2
```

<img src="https://github.com/user-attachments/assets/cfed15ce-b6c6-426c-9832-0706e1a43360" width="700"/>

---

## **Step 5: Next Iteration - Save Next Node**
**Code:** `ListNode temp = curr.next;`

**Action:** Save the next node of `curr` in `temp` for the next reversal step.

```
curr -> 2
temp -> 3
prev -> 1
```

<img src="https://github.com/user-attachments/assets/968717a0-e42f-4712-a8f5-09202653df6c" width="700"/>

---

## **Step 6: Reverse the Link**
**Code:** `curr.next = prev;`

**Action:** Reverse the link of `curr` to point to `prev`.

```
null <- 1 <- 2    3 -> 4 -> 5 -> null
```

<img src="https://github.com/user-attachments/assets/d13895ae-351d-438c-86c5-aefcebae177d" width="700"/>

---

## **Final State (After All Iterations)**
**Code:** `return prev;`

**Action:** Return `prev`, which is now the new head of the reversed list.

```
Reversed Linked List: 5 -> 4 -> 3 -> 2 -> 1 -> null
```

<img src="https://github.com/user-attachments/assets/40ef5fc7-f611-40f0-9b27-988f62b6f81a" width="700"/>

**Result:** The original `list 1 -> 2 -> 3 -> 4 -> 5 -> null` is now reversed to `5 -> 4 -> 3 -> 2 -> 1 -> null` ✅

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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;   // step1
            curr.next = prev;            // step2
            prev = curr;                 // step3
            curr = temp;                 // step4
        }
        return prev;
    }
}
```

```cpp
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr != nullptr) {
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
};
```

```python
class Solution(object):
    def reverseList(self, head):
        prev = None
        curr = head
        while curr:
            temp = curr.next
            curr.next = prev
            prev = curr
            curr = temp
        return prev
```

---

## 🎯 If you are a beginner, solve these problems to build strong concepts:

| # | Problem |
|---|---------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) |
| 2 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) |
| 3 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) |
| 4 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) |
| 5 | [Sum of All Subset XOR Totals](https://leetcode.com/problems/sum-of-all-subset-xor-totals/) |

---

<p align="center">⭐ If this helped you, please star this repo and upvote on <a href="https://leetcode.com/u/ashokvarma5247/">LeetCode</a> 💪</p>
