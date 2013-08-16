package com.bhatt.repeat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Period {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				getPeriod(line);
			}
		} catch (Exception ex) {
			System.out.println("ERROR " + ex.getMessage());
		}

	}

	public static void getPeriod(String inputa) {

		char[] input = inputa.toCharArray();
		if (input.length > 0) {

			if (input.length == 1) {
				System.out.println(1);
				return;
			}

			boolean next = true;
			int i;
			for (i = 1; i < ((input.length) / 2) + 1; i++) {
				next = false;
				for (int j = i; j < input.length && !next;) {
					for (int k = 0; k < i; k++) {
						if (input[k] != input[j++]) {
							next = true;
							break;
						}
					}
				}
				if (!next) {
					System.out.println(i);

					break;
				}

			}
			if (next) {
				System.out.println(input.length);
			}
		}

	}

}
