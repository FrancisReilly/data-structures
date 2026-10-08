class Link {
    String name;
    int age;
    String degree;
    int yearOfStudy;
    Link next;

    public Link(String name, int age, String degree, int yearOfStudy) {
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.yearOfStudy = yearOfStudy;
        this.next = null;

    }

    public String toString() {
        return name + ", " + age + ", " + degree + ", " + yearOfStudy;
    }
}

class LinkedList {
    private Link head;

    public LinkedList() {
        head = null;
    }

    public void add(String name, int age, String degree, int yearOfStudy) {
        Link newLink = new Link(name, age, degree, yearOfStudy);
        if (head == null) {
            head = newLink; // if list empty goes to new link
        } else {
            Link current = head; // current pointer so can traverse the list
            while (current.next != null) { // loops through list until it reaches the end ie next = null
                current = current.next; // points to the next node in list after going through loop
            }
            current.next = newLink; // creates new node for last node to point at (easier to know where the last
                                    // node is located)
        }
    }

    public void printList() {
        Link current = head;
        Link loopStart = detectLoop();
        boolean seenLoopStart = false;
        while (current != null) {
            if (current == loopStart) {
                if (seenLoopStart) {
                    System.out.println("(loops back to " + current.name + ")");
                    return;
                }
                seenLoopStart = true;
            }
            System.out.println(current);
            current = current.next;
        }
    }

    public void findAndRemove(String attribute, String value) {
        Link current = head;
        Link previous = null; // keep track of previous nodes incase you need to remove one in the middle

        while (current != null) {
            boolean match = false;
            switch (attribute.toLowerCase()) {
                case "name":
                    match = current.name.equals(value);
                    break;
                case "age":
                    match = Integer.toString(current.age).equals(value);
                    break;
                case "degree":
                    match = current.degree.equals(value);
                    break;
                case "yearofstudy":
                    match = Integer.toString(current.yearOfStudy).equals(value);
                    break;
            }

            if (match) {
                if (previous == null) { // If we are removing the first node(head)
                    head = current.next; // move head to next node
                } else {
                    previous.next = current.next; // skip over current node
                }
                return; // Exit after removing the link
            }

            previous = current; // update previous to the current node
            current = current.next; // update current to the next node
        }
    }

    public void createLoop(int position) {
        if (head == null)
            return;

        Link loopNode = null;
        Link current = head;
        int counter = 1;

        // go through the list to find the node at the given position
        while (current.next != null) {
            if (counter == position) {
                loopNode = current; // mark node where the loop starts
            }
            current = current.next;
            counter++;
        }

        // create loop by connecting the last node to the loop node
        if (loopNode != null) {
            current.next = loopNode;
        }
    }

    public Link detectLoop() {
        if (head == null)
            return null;

        Link slow = head; // sllow pointer
        Link fast = head; // fast pointer

        // detect if a loop exists
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow pointer by 1
            fast = fast.next.next; // move fast pointer by 2

            if (slow == fast) { // loop detected
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null; // No loop exists
        }

        // find the start of the loop
        slow = head; // reset slow to head
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // this is the starting node of the loop
    }

    public void printLoopStart() {
        Link loopstart = detectLoop();
        if (loopstart != null) {
            System.out.println(loopstart);
        } else {
            System.out.println("no loop detected");
        }
    }

    public void printLoop() {
        Link current = head;
        Link start = detectLoop();
        while (current != start) {
            System.out.println(current);
            current = current.next;

        }
    }

}

public class LinkedListDemo {
    public static void main(String[] args) {
        // create a new linked list
        LinkedList list = new LinkedList();

        // add links to the list
        list.add("Bunny", 26, "CSSE", 2);
        list.add("Larry", 18, "ARTS", 1);
        list.add("Steve", 32, "ComputationalThinking", 4);

        // print the entire list
        System.out.println("Initial List:");
        list.printList();

        // remove a link where age = 18
        list.findAndRemove("age", "18");
        System.out.println("\nList after removing age 18:");
        list.printList();

        // create a loop and detect where it starts
        System.out.println("\nCreating a loop:");
        list.createLoop(1);
        list.printLoopStart();
        list.printList();
    }
}
