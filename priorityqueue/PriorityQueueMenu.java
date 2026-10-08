
import java.util.Scanner;

class priorityQueue {
	private int maxSize;
	private long[] queArray;
	private int nItems;

	public priorityQueue(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}

	public boolean insert(long j) {
		if (isFull())
			return false;

		int i;
		for (i = nItems - 1; i >= 0; i--) {
			if (queArray[i] > j) {
				queArray[i + 1] = queArray[i];
			} else {
				break;
			}
		}
		queArray[i + 1] = j; // For loop made a space for new element j by checkin what numbers are bigger in
								// the array and stopped when it found the first number thats smaller
		nItems++;
		return true;
	}

	public long remove() {
		if (isEmpty()) {
			return -1;
		}
		long removedItem = queArray[0];
		// Shift all the elements one position to the left
		for (int i = 0; i < nItems - 1; i++) {
			queArray[i] = queArray[i + 1];
		}

		nItems--; // Decrease the size of the queue
		return removedItem;
	}

	public long peek() {
		if (isEmpty()) {
			return -1;
		}
		return queArray[0];
	}

	public boolean isEmpty() {
		return nItems == 0;
	}

	public boolean isFull() {
		return nItems == maxSize;
	}

	public int size() {
		return nItems;
	}

	public void printQueue() {
		for (int i = 0; i < nItems; i++) {
			System.out.print(queArray[i] + " ");
		}
		System.out.println();
	}
}

public class PriorityQueueMenu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter queue size:");
		int size = scan.nextInt();
		priorityQueue queue = new priorityQueue(size);

		while (true) {
			System.out.println("Command (INSERT n / REMOVE / PEEK / PRINT / EXIT):");
			String choice = scan.next();
			switch (choice.toUpperCase()) {
				case "INSERT":
					long item = scan.nextLong();
					if (!queue.isFull()) {
						queue.insert(item);
					}
					break;
				case "REMOVE":
					if (!queue.isEmpty()) {
						System.out.println("Removed: " + queue.remove());
					}
					break;
				case "PEEK":
					if (!queue.isEmpty()) {
						System.out.println("Front: " + queue.peek());
					}
					break;
				case "PRINT":
					if (!queue.isEmpty()) {
						queue.printQueue();
					}
					break;
				case "EXIT":
					scan.close();
					return;

				default:
					break;
			}
		}
	}

}
