public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    List<Integer> vals = new ArrayList<>();
    for (ListNode c = l1; c != null; c = c.next) vals.add(c.val);
    for (ListNode c = l2; c != null; c = c.next) vals.add(c.val);
    Collections.sort(vals);

    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    for (int v : vals) {
        curr.next = new ListNode(v);
        curr = curr.next;
    }
    return dummy.next;
}


// brute force 
// Brute Force: Collect values, sort, rebuild

// Idea: Dump all values into an array, sort it, then build a brand-new linked list from scratch.
// Time: O((m+n) log(m+n)) — dominated by sort. Space: O(m+n).



/*
in go   :
func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    var vals []int
    for c := l1; c != nil; c = c.Next {
        vals = append(vals, c.Val)
    }
    for c := l2; c != nil; c = c.Next {
        vals = append(vals, c.Val)
    }
    sort.Ints(vals)

    dummy := &ListNode{}
    curr := dummy
    for _, v := range vals {
        curr.Next = &ListNode{Val: v}
        curr = curr.Next
    }
    return dummy.Next
}
*/


// optimal 
// Optimal: Dummy Node + Two Pointers (splice in place)

// Idea: Walk both lists simultaneously with a dummy head. At each step, attach the smaller node to your result and advance only that list's pointer. No new nodes created — you're just re-linking existing ones.
// Time: O(m+n) — single pass. Space: O(1) (excluding output).

// Java (class Solution format):

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1: l2;
        return dummy.next; 
    }
}


/*

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
    dummy := &ListNode{}
    curr := dummy

    for l1 != nil && l2 != nil {
        if l1.Val <= l2.Val {
            curr.Next = l1
            l1 = l1.Next
        } else {
            curr.Next = l2
            l2 = l2.Next
        }
        curr = curr.Next
    }

    if l1 != nil {
        curr.Next = l1
    } else {
        curr.Next = l2
    }

    return dummy.Next
}
*/