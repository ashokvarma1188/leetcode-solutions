✅**IF YOU LIKE THIS SOLUTION, PLEASE UPVOTE AT THE END**😊 ✅
# Intuition💡:
### **Iterative Approach:**
- Use two pointers: ```prev``` (starts as ```null```) and ```curr``` (starts at ```head```).
- At each step:
    1 . Store ```curr.next``` in ```temp```.
    2 . Reverse ```curr.next``` to point to ```prev```.
    3 . Move ```prev``` to ```curr``` and ```curr``` to ```temp```.
- Repeat until ```curr``` is ```null```.
- ```prev``` becomes the new head of the reversed list.

### **Visualization:**
   - Original list :  ```1 -> 2 -> 3 -> 4 -> 5 ->null```
   - Reversed list :  ```5 -> 4 -> 3 -> 2 -> 1 -> null```

___
   

# Approach &  Step-by-Step Visualization🔍:
<!-- Describe your approach to solving the problem. -->
![giphy.gif](https://assets.leetcode.com/users/images/88001cde-da6d-4c9b-b071-dab8ff72c737_1746460191.785913.gif)

- Here Assume `(next = temp)`

1 . ```prev = null```:
- prev starts as null because there’s no node before the head.

2 . ```curr = head```:
- curr points to the first node (head) of the list.

![image.png](https://assets.leetcode.com/users/images/a042459e-2a0a-4f4e-90b5-54431a37fcb6_1742277024.3267157.png)
___
## **Step 1: Save the Next Node**
- **Code:**
```ListNode temp = curr.next;```
- **Action:** Save the next node of curr in a temporary variable temp.

- **Visualization:**
```
curr -> 1
temp -> 2
```
![image.png](https://assets.leetcode.com/users/images/02bdf1af-933d-45ac-accd-5a5345d379d2_1742277208.9818907.png)
___
## **Step 2: Reverse the Link**
- **Code:** ```curr.next = prev;```
- **Action:** Reverse the link of curr to point to prev.
- **Visualization:**
```null <- 1    2 -> 3 -> 4 -> 5 -> null```

![Screenshot 2025-03-18 112749.png](https://assets.leetcode.com/users/images/fd9d3869-a909-4cd1-809a-a62307149e02_1742277545.876817.png)
___
### **Step 3: Move** ```prev``` **to** ```curr```
- **Code:** ```prev = curr```;
- **Action:** Move ```prev``` to the current node (```curr```).
- **Visualization:**
```
prev -> 1
curr -> 1
temp -> 2
```
![image.png](https://assets.leetcode.com/users/images/a1d9fcf0-419a-4bc5-a36a-030ebad78ad3_1742277725.5548484.png)
___
## **Step 4: Move** ```curr``` **to** ```temp```
- **Code:** ```curr = temp;```
- **Action:** Move ```curr``` to the next node (saved in ```temp```).
- **Visualization:**
```
prev -> 1
curr -> 2
temp -> 2
```
![image.png](https://assets.leetcode.com/users/images/92720154-3377-478a-ac16-fa01131f2d46_1742277960.6540473.png)
___
## **Step 5: Next Iteration - Save Next Node**
- **Code:** ```ListNode temp = curr.next;```
- **Action:** Save the next node of ```curr``` in ```temp``` for the next reversal step.
- **Visualization:**
```
curr -> 2
temp -> 3
prev -> 1
```

![image.png](https://assets.leetcode.com/users/images/597018ad-2d5d-461b-a917-43b90d25d17d_1742278135.0936155.png)
___
## **Step 6: Reverse the Link**
- **Code:** ```curr.next = prev;```
- **Action**: Reverse the link of ```curr``` to point to ```prev```.
- **Visualization:**
```
null <- 1 <- 2    3 -> 4 -> 5 -> null
```
![image.png](https://assets.leetcode.com/users/images/9bce19ef-dae6-4f28-8478-f0ac2331b7e4_1742278274.6449509.png)

___
## **Final State (After All Iterations)**
- **Code:** ```return prev;```
- **Action:** Return ```prev```, which is now the new head of the reversed list.
- **Visualization:**
``` 
Reversed Linked List: 5 -> 4 -> 3 -> 2 -> 1 -> null
```

![image.png](https://assets.leetcode.com/users/images/12dc8bdd-6aed-4493-b112-5911e399903a_1742278403.5573204.png)

- **Result:** The original ```list 1 -> 2 -> 3 -> 4 -> 5 -> null``` is now reversed to ```5 -> 4 -> 3 -> 2 -> 1 -> null```.

___
# ⏳Complexity Analysis
- Time complexity: $$O(n)$$ (linear time).
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:$$O(1)$$ (constant space).
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
___

# 💻Code Implementation
```java []
class Solution {
    public ListNode reverseList(ListNode head) {
    ListNode prev=null;
    ListNode curr=head;
    while(curr!=null){
        ListNode  temp=curr.next;    //step1
        curr.next=prev;              //step2
         prev = curr;                //step3
        curr=temp;                   //step4
    }
    return prev;
    }
}
```
```c++ []
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev = nullptr;
        ListNode* curr = head;
        while (curr != nullptr) {
            ListNode* temp = curr->next; // Store the next node
            curr->next = prev;            // Reverse the current node's pointer
            prev = curr;                  // Move prev to current node
            curr = temp;                  // Move to the next node
        }
        return prev; // New head of the reversed list
    }
};
```
```python []
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def reverseList(self, head):
        prev = None  # Initialize prev as None
        curr = head  # Start with curr at the head of the list

        while curr:
            temp = curr.next  # Store the next node
            curr.next = prev  # Reverse the pointer
            prev = curr       # Move prev forward
            curr = temp      # Move curr forward

        return prev  # prev is the new head of the reversed list
```
**If you found my solution helpful, I would greatly appreciate your upvote, as it would motivate me to continue sharing more solutions.**

🔼 **Please Upvote**
```
                              ✨ AN UPVOTE WILL BE APPRECIATED ^_~ ✨
```


**🎯If you are a beginner solve these problem which makes concepts clear for future  coding :**

$$1$$ . [1. Two Sum](https://leetcode.com/problems/two-sum/solutions/6611819/step-by-step-visualization-beginner-frei-5ch1/)
$$2$$ . [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/solutions/6608214/beginner-freindlyvisualizationjavacpytho-5lil/)
$$3$$ . [141 . Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/solutions/6556606/0ms-100-step-by-step-explained-with-visu-fpe6/)
$$4$$ . [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/solutions/6550282/java-0ms-100-step-by-step-explained-with-kgvz/) 
$$5$$ . [1863. Sum of All Subset XOR Totals (Bit Manipulation)](https://leetcode.com/problems/sum-of-all-subset-xor-totals/solutions/6616852/step-by-step-visualization-beginner-frei-5qev/)
$$6$$ . [2529. Maximum Count of Positive Integer and Negative Integer (Binary Search)](https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/solutions/6526081/binary-search-beginner-freindlyvisualiza-smsf/)


![cat.gif](https://assets.leetcode.com/users/images/b7500767-6c4e-4f25-aff3-26a1782dc036_1740447008.7373548.gif)





