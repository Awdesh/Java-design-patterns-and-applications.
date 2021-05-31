String
Integer
char

char[] chArr = s.toCharArray();
Integer[] intArr = new Integer[2];

HashMap<String, int>  map = new HashMap<~>();
map.put("leet", 1);

HashSet<String> set = new HashSet<~>();
set.add("leet");

String[] strArr = ip.split(" ");


String s = "leetcode"
char[] chArr = s.toCharArray();
chArr.substr(0,1); // 'l', starts from 0th index to 1st element.
chArr.substr(0,2); // 'le' starts from 0th index to 2nd element.
chArr.substr(0,3); // 'lee' starts from 0th index to 3rd element.

String To Int-:
================
'367'
num = 0;
int len = s.length()

while(i < len)
num *= 10;
num = str[i++] - '0' // 51 - 48 = 3

Int To String-:
================

367 -> '367'

char[] temp = new char[];
while(num != 0)
temp[i++] = char(num % 10 + '0')
num = num/10;


Tree-:
======

```
using System;
using System.Collections.Generic;
using System.Text;
using Tree;

namespace Practice
{
    class MaxHeight
    {
        public int FindMaxHeight(TreeNode root)
        {
            int height = 0;
            if (root == null)
            {
                return height;
            }
            root.level = 0;
            Queue<TreeNode> q = new Queue<TreeNode>();
            q.Enqueue(root);
            TreeNode curr;
            int maxHeight = 0;
            int currentHeight = 0;
            // BFS traversal.
            while (q.Count > 0)
            {
                curr = q.Dequeue();
                currentHeight = curr.level;

                if (curr.getLeft() != null)
                {
                    curr.getLeft().level = currentHeight + 1;
                    q.Enqueue(curr.getLeft());
                }
                if (curr.getRight() != null)
                {
                    curr.getRight().level = currentHeight + 1;
                    q.Enqueue(curr.getRight());
                }
                if (maxHeight < currentHeight)
                {
                    maxHeight = currentHeight;
                }
            }
            return maxHeight;
        }
    }
}
```

LinkedList-:
=============
using two pointers to traverse the list is always helpful.

Arrays-:
=========
* Traverse it from both ends.
* Instead of deleting, you can overwrite an element.

* Given 2 list of numbers and an integer k return the k smallest pair of integers from the 2 list

* Given an array of integers, find the greatest consecutive sum.  

* Different between HashTable and BST.

* Serialize and Deserialize a BST.

