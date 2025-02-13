import java.io.*;
/**
 * This program calculates the Oddonacci sequence using both multiple recursion
 * and linear recursion. It then records execution times to compare performance.
 * 
 * Date: February 16th,2024
 *
 * @author Bishoy Abdelmalik
 * @version 1
*/
public class oddonacciSequence {
	/**
	 * Computes the k-th Oddonacci number using multiple recursion.
	 * 
	 * The Oddonacci sequence is defined as:
	 * O(n) = O(n-1) + O(n-2) + O(n-3), with O(1) = O(2) = O(3) = 1.
	 * 
	 * This method has exponential time complexity: O(2^n).
	 * 
	 * @param  k  an integer index for the sequence.
	 * @return    the k-th Oddonacci number.
	 */
	public static long multipleOddonacci(int k) {
		if (k < 0) {
			System.out.println("You must enter an integer larger than 0. Method will return -1");
			return -1;
		}
		if (k <= 3) {
			return 1;
		}
		return multipleOddonacci(k - 1) + multipleOddonacci(k - 2) + multipleOddonacci(k - 3);
	}

	/**
	 * Computes the k-th Oddonacci number using linear recursion.
	 * 
	 * This approach significantly improves performance with O(n) time complexity.
	 * 
	 * @param k  the index in the sequence.
	 * @param a  the first element (1).
	 * @param b  the second element (1).
	 * @param c  the third element (1).
	 * @return   the k-th Oddonacci number.
	 */
	public static long linearOddonacci(int k, long a, long b, long c) {
		if (k < 0) {
			System.out.println("You must enter an integer larger than 0. Method will return -1");
			return -1;
		}
		if (k == 1) return a;
		if (k == 2) return b;
		if (k == 3) return c;
		return linearOddonacci(k - 1, b, c, a + b + c);
	}

	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("OddoOut.txt");
			long output;

			// Measuring runtime for multipleOddonacci (inefficient)
			for (int i = 5; i <= 40; i += 5) {
				long startTime = System.currentTimeMillis();
				output = multipleOddonacci(i);
				long endTime = System.currentTimeMillis();
				long duration = endTime - startTime;
				writer.write("Multiple Oddonacci(" + i + ") = " + output + ", elapsed time: " + duration + " ms\n");
			}

			writer.write("\n");

			// Measuring runtime for linearOddonacci (efficient)
			for (int i = 5; i <= 200; i += 5) {
				long startTime = System.nanoTime();
				output = linearOddonacci(i, 1, 1, 1);
				long endTime = System.nanoTime();
				long duration = endTime - startTime;
				writer.write("Linear Oddonacci(" + i + ") = " + output + ", elapsed time: " + duration + " ns\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
