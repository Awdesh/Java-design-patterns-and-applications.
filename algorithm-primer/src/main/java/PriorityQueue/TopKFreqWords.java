import java.util.*;

public class TopKFreqWords {

    public List<String> findWords(List<String> words, int k) {
        Map<String, Element> wordsMap = new HashMap<>();
        PriorityQueue<Element> maxHeap = new PriorityQueue<>();
        for (String word: words) {
            if(!wordsMap.containsKey(word)) {
                wordsMap.put(word, new Element(word, 1));
            } else {
                wordsMap.get(word).count += 1;
            }
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Element> entry : wordsMap.entrySet()) {
            maxHeap.add(entry.getValue());

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        for (int i = 0; i < k; i++) {
            list.add(Objects.requireNonNull(maxHeap.poll()).word);
        }

        return list;
    }

    private static class Element implements Comparable<Element> {
        String word;
        int count;

        public Element(String word, int count) {
            this.word = word;
            this.count = count;
        }

        public int compareTo(Element e) {
            if(this.count == e.count)
                return e.word.compareTo(this.word);
            else
                return Integer.compare(this.count, e.count);
        }

        public static void main(String[] args) {
            List<String> l = new ArrayList<>();
//            "i", "love", "leetcode", "i", "love", "coding"
            l.add("i");
            l.add("love");
            l.add("leetcode");
            l.add("i");
            l.add("love");
            l.add("coding");
            TopKFreqWords top = new TopKFreqWords();
            List<String> ll = top.findWords(l, 2);
            for (String w: ll) {
                System.out.println("Word is-: " + w);
            }
        }
    }
}
