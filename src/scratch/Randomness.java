package scratch;

import java.security.SecureRandom;

public class Randomness {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();
		System.out.println(random.nextLong());
		System.out.println(random.nextDouble());
		System.out.println(random.getAlgorithm());

	}

}
