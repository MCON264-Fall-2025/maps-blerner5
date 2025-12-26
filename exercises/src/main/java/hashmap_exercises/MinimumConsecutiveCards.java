package hashmap_exercises;
import java.util.HashMap;
import java.util.Map;



public class MinimumConsecutiveCards {

    /**
     * @param cards array of card values
     * @return minimum length of a contiguous subarray containing two equal cards,
     *         or -1 if no such subarray exists
     */
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            int card = cards[i];
            if (lastSeen.containsKey(card)) {
                int j = lastSeen.get(card);
                minLength = Math.min(minLength, i - j + 1);
            }
            lastSeen.put(card, i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}
        // TODO: implement using a Map<Integer, Integer> to track last seen indices
        // High-level hint:
        // - Keep a map from cardValue -> lastIndexSeen
        // - For each index i:
        //     if cardValue was seen at j, update answer with (i - j + 1)
        //     then update lastIndexSeen for this cardValue to i
        // - If you never update the answer, return -1]]]
    
