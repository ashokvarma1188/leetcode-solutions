# 49. Group Anagrams 🔤

🟡 **Medium** | 🏷️ Hash Table | String | Sorting | ✅ Beginner Friendly

🔗 [Problem Link](https://leetcode.com/problems/group-anagrams/)

---

> ✅ **IF YOU LIKE THIS SOLUTION, PLEASE ⭐ STAR THIS REPO** 😊

---

## 💡 Intuition

Group words that are **anagrams** of each other together.
Anagrams = same characters, different order.

> **Key Idea:** If we **sort** any anagram, they all produce the **same string!**
> `"eat"` → sort → `"aet"`
> `"tea"` → sort → `"aet"` ✅ same key!
> `"ate"` → sort → `"aet"` ✅ same key!

---

## 🎨 Visual Explanation

### 📥 Input
```
["eat", "tea", "tan", "ate", "nat", "bat"]
```

---

### 🔄 Step 1 — Sort each word to get the KEY

```
┌─────────┬──────────────┬─────────┐
│  Word   │   Sort it    │   Key   │
├─────────┼──────────────┼─────────┤
│  "eat"  │  e,a,t → aet │  "aet"  │
│  "tea"  │  t,e,a → aet │  "aet"  │
│  "tan"  │  t,a,n → ant │  "ant"  │
│  "ate"  │  a,t,e → aet │  "aet"  │
│  "nat"  │  n,a,t → ant │  "ant"  │
│  "bat"  │  b,a,t → abt │  "abt"  │
└─────────┴──────────────┴─────────┘
```

---

### 🗂️ Step 2 — Group by KEY in HashMap

```
HashMap<String, List<String>>

  "aet"  →  [ "eat", "tea", "ate" ]
               ↑       ↑      ↑
               all sorted to "aet"

  "ant"  →  [ "tan", "nat" ]
               ↑       ↑
               all sorted to "ant"

  "abt"  →  [ "bat" ]
               ↑
               sorted to "abt"
```

---

### 📤 Step 3 — Return all values

```
Output:
[
  ["eat", "tea", "ate"],   ← group 1 (key: "aet")
  ["tan", "nat"],          ← group 2 (key: "ant")
  ["bat"]                  ← group 3 (key: "abt")
]
```

---

### 🗺️ Full Flow Diagram

```
INPUT: ["eat","tea","tan","ate","nat","bat"]
          │
          ▼
   For each word:
   ┌─────────────────────────────┐
   │  1. Sort the word           │
   │     "eat" → "aet"           │
   │  2. Use sorted as KEY       │
   │  3. Push original to map    │
   └─────────────────────────────┘
          │
          ▼
   HashMap built:
   ┌────────────────────────────────────┐
   │  "aet" → ["eat", "tea", "ate"]    │
   │  "ant" → ["tan", "nat"]           │
   │  "abt" → ["bat"]                  │
   └────────────────────────────────────┘
          │
          ▼
   Collect all values → RETURN as result ✅
```

---

### 🔍 Iteration Walkthrough

```
i=0: word="eat" → sorted="aet" → map{"aet":["eat"]}
     ┌─────────────────────────┐
     │  aet → [ eat ]          │
     └─────────────────────────┘

i=1: word="tea" → sorted="aet" → map{"aet":["eat","tea"]}
     ┌─────────────────────────┐
     │  aet → [ eat, tea ]     │
     └─────────────────────────┘

i=2: word="tan" → sorted="ant" → map adds new key "ant"
     ┌─────────────────────────┐
     │  aet → [ eat, tea ]     │
     │  ant → [ tan ]          │
     └─────────────────────────┘

i=3: word="ate" → sorted="aet" → map{"aet":["eat","tea","ate"]}
     ┌─────────────────────────┐
     │  aet → [ eat, tea, ate ]│
     │  ant → [ tan ]          │
     └─────────────────────────┘

i=4: word="nat" → sorted="ant"
     ┌─────────────────────────┐
     │  aet → [ eat, tea, ate ]│
     │  ant → [ tan, nat ]     │
     └─────────────────────────┘

i=5: word="bat" → sorted="abt" → new key
     ┌─────────────────────────┐
     │  aet → [ eat, tea, ate ]│
     │  ant → [ tan, nat ]     │
     │  abt → [ bat ]          │
     └─────────────────────────┘

✅ DONE! Return all values.
```

---

## ⏳ Complexity Analysis

| | Complexity | Reason |
|---|---|---|
| ⏱️ Time | O(n × k log k) | n = words, k = avg word length (sorting each word) |
| 🗂️ Space | O(n × k) | storing all words in HashMap |

---

## 💻 Code Implementation

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);                    // sort the word
            String sortedWord = new String(chars); // use as key

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);         // group it
        }

        return new ArrayList<>(map.values());      // return groups
    }
}
```

```cpp
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> mp;

        for (auto x : strs) {
            string word = x;
            sort(word.begin(), word.end()); // sort → get key
            mp[word].push_back(x);          // group it
        }

        vector<vector<string>> ans;
        for (auto x : mp) {
            ans.push_back(x.second);
        }
        return ans;
    }
};
```

```python
class Solution:
    def groupAnagrams(self, strs):
        anagram_map = defaultdict(list)

        for word in strs:
            sorted_word = ''.join(sorted(word))  # sort → get key
            anagram_map[sorted_word].append(word) # group it

        return list(anagram_map.values())
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
| 6 | [Group Anagrams](https://leetcode.com/problems/group-anagrams/) | HashMap |

---

<p align="center">⭐ If this helped you, please star this repo and upvote on <a href="https://leetcode.com/u/ashokvarma5247/">LeetCode</a> 💪</p>
