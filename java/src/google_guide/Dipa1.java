package google_guide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class Dipa1 {

	private static TreeMap<Double, Double> positionList = new TreeMap<Double, Double>();
	private static Random rand = new Random();
	private static double n = 29.0;
	private static int count = 0;

	public static void main(String... arg) {

		dataPreparation();
		HashMap<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>> neighborList = createNeighborList(positionList);
		Iterator<Entry<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>>> it = neighborList
				.entrySet().iterator();
		while (it.hasNext()) {
			Entry<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>> entry = it
					.next();
			HashMap<Double, Double> key = entry.getKey();
			ArrayList<HashMap<Double, Double>> value = entry.getValue();
			System.out.println(key);
			System.out.println(" = " + value);
		}
		System.out.println(count + " : " + positionList.size());
	}

	private static HashMap<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>> createNeighborList(
			TreeMap<Double, Double> positionList) {
		HashMap<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>> neighborList = new HashMap<HashMap<Double, Double>, ArrayList<HashMap<Double, Double>>>();

		Iterator<Entry<Double, Double>> iterator = positionList.entrySet()
				.iterator();
		Iterator<Entry<Double, Double>> it = positionList.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Double, Double> entry = iterator.next();
			double latitude1 = entry.getKey();
			double longitude1 = entry.getValue();
			HashMap<Double, Double> thisPosition = new HashMap<Double, Double>();
			ArrayList<HashMap<Double, Double>> neighboringPosition = new ArrayList<HashMap<Double, Double>>();
			thisPosition.put(latitude1, longitude1);
			while (it.hasNext()
					&& Math.abs((latitude1 - it.next().getKey())) <= n) {
				count++;
				Entry<Double, Double> entry2 = it.next();
				double latitude2 = entry2.getKey();
				double longitude2 = entry2.getValue();
				HashMap<Double, Double> thisNeighbor = new HashMap<Double, Double>();
				double distance = Math.sqrt(Math
						.pow((latitude1 - latitude2), 2)
						+ Math.pow((longitude1 - longitude2), 2));
				if (distance <= n) {
					thisNeighbor.put(latitude2, longitude2);
				}
				if (!thisNeighbor.isEmpty()) {
					neighboringPosition.add(thisNeighbor);
				}

			}
			if (!thisPosition.isEmpty() && !neighboringPosition.isEmpty()) {
				neighborList.put(thisPosition, neighboringPosition);
			}

		}

		return neighborList;
	}

	private static void dataPreparation() {
		for (int i = 0; i < 35; i++) {
			positionList.put(rand.nextDouble() * 50, rand.nextDouble() * 50);
		}
	}
}
