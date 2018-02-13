
// My solution to the HackerRank.com problem "ACM-ICPC Team."
// https://www.hackerrank.com/challenges/acm-icpc-team/problem

import java.util.ArrayList;
import java.util.Scanner;

public class ACMICPCteamApp {
	static int[] acmTeam(String[] topic, int m) {
		int[] result = new int[2];
		ArrayList<Integer> tempArray1 = new ArrayList<>();
		int knownTopics = 0;

		for (int idx1 = 0; idx1 < (topic.length - 1); idx1++) {
			for (int idx2 = (idx1 + 1); idx2 < topic.length; idx2++) {
				knownTopics = 0;
				for (int idx3 = 0; idx3 < m; idx3++) {
					if (topic[idx1].charAt(idx3) == '1') {
						knownTopics++;
					} else if (topic[idx2].charAt(idx3) == '1') {
						knownTopics++;
					}
				}
				tempArray1.add(knownTopics);
			}
		}
		System.out.println("Temp Array 1 = " + tempArray1.toString());
		int maxTopics = 0;
		for (int idx4 = 0; idx4 < tempArray1.size(); idx4++) {
			maxTopics = Math.max(maxTopics, tempArray1.get(idx4));
		}

		int maxTopicsTeams = 0;
		for (int idx5 = 0; idx5 < tempArray1.size(); idx5++) {
			if (tempArray1.get(idx5) == maxTopics) {
				maxTopicsTeams++;
			}
		}

		result[0] = maxTopics;
		result[1] = maxTopicsTeams;

		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of people at conference, n (integer 2-500): ");
		int n = in.nextInt();
		System.out.print("Enter the number of topics, m (integer 1-500): ");
		int m = in.nextInt();
		String[] topic = new String[n];
		for (int topic_i = 0; topic_i < n; topic_i++) {
			System.out.print("Enter a string of '0's or '1's (" + m + " units long) to show which of the " + m
					+ " topics person #" + (topic_i + 1) + " knows: ");
			topic[topic_i] = in.next();
		}
		int[] result = acmTeam(topic, m);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

		in.close();
	}
}
