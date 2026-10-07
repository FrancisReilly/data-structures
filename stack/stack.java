package stack;

public class stack {

	private static class Stack {
		private char[] stack;
		private int top;

		public Stack(int capacity) {
			stack = new char[capacity];
			top = -1;
		}

		public void push(char c) {
			stack[++top] = c;
		}

		public char pop() {
			return stack[top--];
		}

		public boolean isEmpty() {
			return top < 0;
		}

	}

	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		Stack stack = new Stack(s.length());
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}
		char[] reversed = new char[s.length()];
		for (int i = 0; !stack.isEmpty(); i++) {
			reversed[i] = stack.pop();
		}
		return new String(reversed).equals(s);
	}

	public static void main(String[] args) {
		String[] words = { "civic", "navan", "hello" };
		for (String word : words) {
			System.out.println(isPalindrome(word));
		}
	}

}
