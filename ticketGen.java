package TicketGen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ticketGen {

	public static void main(String[] args) {

		ArrayList<Integer> mapCoordinates = new ArrayList<Integer>();
		ArrayList<Integer> mapValues = new ArrayList<Integer>();
		ticketGen tG = new ticketGen();
		boolean mapRight = false;
		for (int i = 0; !mapRight; i++) {
			mapCoordinates = tG.mapMaker();
			if (mapCoordinates.subList(27, mapCoordinates.size()).contains(0)) {
				mapRight = false;
				System.out.println("Map Co-ordinates BAD");
				continue;
			} else {
				
				System.out.println("Map co-ordinates are :\n\t\t\t" + mapCoordinates.subList(0, 9) + "\n\t\t\t"
						+ mapCoordinates.subList(9, 18) + "\n\t\t\t" + mapCoordinates.subList(18, 27)
						+ "\nAnd the sum array is:\n\t\t\t" + mapCoordinates.subList(27, mapCoordinates.size()));
				break;
			}
		}
		tG.mapGenerator(mapCoordinates);
		tG.mapFiller(mapCoordinates,mapValues);
	}

	private static ArrayList<Integer> mapMaker() {
		ArrayList<Integer> r1f = new ArrayList<Integer>();
		ArrayList<Integer> r2f = new ArrayList<Integer>();
		ArrayList<Integer> r3f = new ArrayList<Integer>();
		ArrayList<Integer> sumarray = new ArrayList<Integer>();
		ArrayList<Integer> returnval = new ArrayList<Integer>();
		boolean r1 = false, r2 = false, r3 = false, all3 = false, rule1 = false, zerothere = false, mappingdone = true;
		int sum, i, sumall = 0;
		int s1, s2, s3;
		for (int z = 0; !zerothere && mappingdone; z++) {
			for (int k = 0; sumall != 15; k++) {
				for (i = 0; !all3 && !rule1; i++) {
					sum = 0;
					s1 = 0;
					s2 = 0;
					s3 = 0;
					ArrayList<Integer> row1 = new ArrayList<Integer>();
					ArrayList<Integer> row2 = new ArrayList<Integer>();
					ArrayList<Integer> row3 = new ArrayList<Integer>();

					for (int j = 0; j < 9; j++) {
						int n = (int) Math.floor(Math.random() * 2);
						// System.out.print(n+"\t");
						row1.add(n);
					}
					for (Integer d : row1)
						s1 += d;
					if (s1 == 5) {
						// System.out.println("Row 1 is\t" + row1 + "\t" + sum);
						r1 = true;
						s1 = 0;
						r1f = row1;
					}

					for (int j = 0; j < 9; j++) {
						int n = (int) Math.floor(Math.random() * 2);
						// System.out.print(n+"\t");
						row2.add(n);
					}
					for (Integer d : row2)
						s2 += d;
					if (s2 == 5) {
						// System.out.println("Row 2 is\t" + row2 + "\t" + sum);
						r2 = true;
						s2 = 0;
						r2f = row2;
					}

					for (int j = 0; j < 9; j++) {
						int n = (int) Math.floor(Math.random() * 2);
						// System.out.print(n+"\t");
						row3.add(n);
					}
					for (Integer d : row3)
						s3 += d;
					if (s3 == 5) {
						// System.out.println("Row 3 is\t" + row3 + "\t" + sum);
						r3 = true;
						s3 = 0;
						r3f = row3;
					}

					if (r1 == true && r2 == true && r3 == true)
						all3 = true;

					if (all3 == true) {
						for (Integer f : r1f)
							sumall += f;
						for (Integer f : r2f)
							sumall += f;
						for (Integer f : r3f)
							sumall += f;
						if (sumall == 15) {
							for (int r = 0, rc = 0; r < 9; r++) {
								// System.out.println(r1f + "\n" + r2f + "\n" + r3f);
								rc = r1f.get(r) + r2f.get(r) + r3f.get(r);
								sumarray.add(rc);
								if (rc == 0) {
									// rule1 = true;
									// all3 = false;
								}
							}
						}

						if (sumall != 15) {
							// System.out.println("Made a mistake");
							// System.out.println(r1f + "\n" + r2f + "\n" + r3f);
							all3 = false;
							sum = 0;
							break;
						}
					}
				}

				// if (all3 = true && sumall != 15) {
				// System.out.println("Made a mistake");
				// System.out.println(r1f + "\n" + r2f + "\n" + r3f+"\t"+sumall);
				// all3 = false;
				// continue;
				// }
				// System.out.println("Completed in " + i + " tries");
			}
			for (Integer f : sumarray) {
				if (f == 0) {
					// System.out.println("Zero is at " + sumarray.indexOf(f));
					zerothere = true;
				}
			}
			for (Integer f : sumarray) {
				if (f != 0) {
					mappingdone = false;
					continue;
				}
			}
			// System.out.println(r1f + "\n" + r2f + "\n" + r3f + "\t" + sumarray);

		}
		returnval.addAll(r1f);
		returnval.addAll(r2f);
		returnval.addAll(r3f);
		returnval.addAll(sumarray);
		return returnval;
	}

	private ArrayList<Integer> mapGenerator(ArrayList<Integer> mapCoordinates) {


		ArrayList<Integer> col_data = new ArrayList<Integer>();
		ArrayList<Integer> mapPoints = new ArrayList<Integer>();
		int[] a = new int[] { 1, 10, 20, 30, 40, 50, 60, 70, 80 };
		int[] b = new int[] { 9, 19, 29, 39, 49, 59, 69, 79, 90 };
		int randomer;
		// for (int i = 0; i < 10; i++) {
		// int n = (int) Math.floor(Math.random() * 91);
		// System.out.println(n);
		// if (!col_data.contains(n) && n >= 1)// && n >= 0 && n < 10
		// col_data.add(n);

		for (Integer d : mapCoordinates.subList(27, mapCoordinates.size())) {
			mapPoints.add(d);
		}
		try {
			for (int j = 0, k = 0; j <= mapPoints.get(k); j++) {
				if (j == mapPoints.get(k)) {
					// System.out.println("J = " + j + " is equaling D = " + mapPoints.get(k) + " so
					// negating");
					j = -1;
					if (k != mapPoints.size())
						k++;
					continue;
				} else {
					randomer = getRandomNumberInRange(a[k], b[k]);
					// System.out.println("Array so far is " + col_data);
					// System.out.println("Adding random number " + randomer + " that's between " +
					// a[k] + " & " + b[k]
					// + " when D = " + mapPoints.get(k) + ", K = " + k + " & J = " + j);
					if (!col_data.contains(randomer))
						col_data.add(randomer);
					else {
						randomer = getRandomNumberInRange(a[k], b[k]);
						if (!col_data.contains(randomer))
							col_data.add(randomer);
						else {
							randomer = getRandomNumberInRange(a[k], b[k]);
							col_data.add(randomer);
						}
					}
				}
			}
		} catch (Exception e) {
		}
		// System.out.println(d);

		// boolean rdone = true;
		// for (int i = 0; i < 9 && rdone; i++) {
		// int rand = (int) Math.floor(Math.random() * b[i]);
		// if (rand >= a[i] && rand <= b[i]) {
		// System.out.println(rand);
		// rdone = false;
		// continue;
		// } else
		// rdone = true;
		// }

		// }
		Collections.sort(col_data);
		System.out.println(col_data.toString() + " has " + col_data.size());
		return col_data;
	}

	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max is lesser than Min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	private void mapFiller(ArrayList<Integer> mapCoordinates,ArrayList<Integer> mapValues) {
		System.out.println("Map co-ordinates are :\n\t\t\t" + mapCoordinates.subList(0, 9) + "\n\t\t\t"
				+ mapCoordinates.subList(9, 18) + "\n\t\t\t" + mapCoordinates.subList(18, 27)
				+ "\nAnd the sum array is:\n\t\t\t" + mapCoordinates.subList(27, mapCoordinates.size()));
	}

}
