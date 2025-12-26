package hashmap_exercises;

import org.junit.jupiter.api.Test;


import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

    @Test
    void exampleGivenInProblemStatement() {
        GroupAnagrams solver = new GroupAnagrams();
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = solver.groupAnagrams(input);

        // Normalize both expected and actual to compare ignoring group order and item order
        Set<Set<String>> expected = new HashSet<>();
        expected.add(new HashSet<>(List.of("eat", "tea", "ate")));
        expected.add(new HashSet<>(List.of("tan", "nat")));
        expected.add(new HashSet<>(List.of("bat")));

        Set<Set<String>> actual = normalize(result);

        assertEquals(expected, actual,
                "Grouped anagrams should match expected sets (order doesn't matter)");
    }

    @Test
    void singleWord() {
        GroupAnagrams solver = new GroupAnagrams();
        String[] input = {"hello"};
        List<List<String>> result = solver.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(Set.of("hello"), new HashSet<>(result.get(0)));
    }

    @Test
    void emptyArray() {
        GroupAnagrams solver = new GroupAnagrams();
        String[] input = {};
        List<List<String>> result = solver.groupAnagrams(input);

        assertNotNull(result);
        assertTrue(result.isEmpty(), "Empty input should produce empty list of groups.");
    }

    @Test
    void repeatedSameWord() {
        GroupAnagrams solver = new GroupAnagrams();
        String[] input = {"aa", "aa", "aa"};
        List<List<String>> result = solver.groupAnagrams(input);

        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
        assertEquals(Set.of("aa"), new HashSet<>(result.get(0)));
    }

    /**
     * Helper to convert List<List<String>> into Set<Set<String>> to compare
     * ignoring order of groups and order within groups.
     */
    private Set<Set<String>> normalize(List<List<String>> groups) {
        if (groups == null) {
            return Collections.emptySet();
        }
        return groups.stream()
                .map(HashSet::new) // each group -> Set<String>
                .collect(Collectors.toSet());
    }
}

