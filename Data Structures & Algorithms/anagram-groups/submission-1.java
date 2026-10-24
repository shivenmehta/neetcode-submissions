class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<HashMap<Character, Integer>> dictionary = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        for (String str: strs) {
            HashMap<Character, Integer> wordMap = new HashMap<>();
            for (Character letter: str.toCharArray()) {
                if (wordMap.containsKey(letter)) {
                    wordMap.put(letter, wordMap.get(letter) + 1);
                } else {
                    wordMap.put(letter, 1);
                }
            }

            //Make sure that the result ArrayList is the Same Size as the Dictionary
            // while (result.size() < dictionary.size()) {
            //     result.add(new ArrayList<String>());
            // }

            boolean anagramFound = false;
            for (int i = 0; i < dictionary.size(); i++) {
                if (dictionary.get(i).equals(wordMap)) {
                    result.get(i).add(str);
                    anagramFound = true;
                    break;
                }
            }

            if (!anagramFound) {
                dictionary.add(wordMap);
                result.add(new ArrayList<String>(List.of(str)));
            }
        }

        // System.out.println(result);

        return result;

    }
}
