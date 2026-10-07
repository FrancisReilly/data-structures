package montecarlo;

public class montecarlo {
	public static void main(String[] args) {
		int simulations = 10000;
		int winCount = 0;

		for (int i = 0; i < simulations; i++) {
			int roll1 = (int) (Math.random() * 6) + 1;
			int roll2 = (int) (Math.random() * 6) + 1;
			if (roll1 + roll2 == 7 || (roll1 + roll2 == 11)) {
				winCount++;
			}
		}
		double winAvg = (double) winCount / simulations;
		int winPercentage = (int) Math.round(winAvg * 100);
		System.out.println("Win rate (7 or 11) over " + simulations + " rolls: " + winPercentage + "%");
		System.out.println("Theoretical probability: 22.2%");

	}

}
