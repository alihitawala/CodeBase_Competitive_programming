/**
 * Created by aliHitawala on 5/3/15.
 */
public class Outcast {
    private WordNet wordNet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordNet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        int maxDistance = 0;
        String maxDistanceNoun = nouns[0];
        for (String source : nouns) {
            int tempDistance = 0;
            for (String destination : nouns) {
                tempDistance += wordNet.distance(source, destination);
            }
            if (tempDistance > maxDistance) {
                maxDistance = tempDistance;
                maxDistanceNoun = source;
            }
        }
        return maxDistanceNoun;
    }

    // see test client below
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        for (int t = 2; t < args.length; t++) {
            In in = new In(args[t]);
            String[] nouns = in.readAllStrings();
            StdOut.println(args[t] + ": " + outcast.outcast(nouns));
        }
    }
}
