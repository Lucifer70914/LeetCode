class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            if (current.child != null) {
                // If next exists, push it to the stack to connect later
                if (current.next != null) {
                    stack.push(current.next);
                }

                // Connect current with child
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }

            // If no next node and stack is not empty, pop and connect
            if (current.next == null && !stack.isEmpty()) {
                Node nextNode = stack.pop();
                current.next = nextNode;
                nextNode.prev = current;
            }

            current = current.next;
        }

        return head;
    }
}
