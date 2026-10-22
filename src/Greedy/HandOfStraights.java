package Greedy;

import java.util.*;

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!freqMap.containsKey(hand[i])) {
                freqMap.put(hand[i], 0);
            }
            int freq = freqMap.get(hand[i]);
            freqMap.put(hand[i], freq + 1);
        }

        for (int card : hand) {
            if (freqMap.get(card) == 0)
                continue;

            for (int k = 0; k < groupSize; k++) {
                int next = card + k;
                int count = freqMap.getOrDefault(next, 0);
                if (count == 0)
                    return false;
                freqMap.put(next, count - 1);
            }
        }
        return true;
    }
}
