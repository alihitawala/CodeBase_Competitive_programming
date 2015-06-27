import java.util.*;

/**
 * Created by aliHitawala on 5/2/15.
 */
public class WordNet {
    private final Map<Integer, SynSet> idToSynset = new HashMap<Integer, SynSet>();
    private final Digraph digraph;
    private final Map<String, Integer> reverseMap = new HashMap<String, Integer>();

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        this.createSynsetMap(synsets);
        digraph = new Digraph(idToSynset.keySet().size());
        this.createDigraphForHypernym(hypernyms);
    }

    // do unit testing of this class
    public static void main(String[] args) {
        WordNet w = new WordNet("synsets.txt", "hypernyms.txt");
    }

    private void createDigraphForHypernym(String hypernyms) {
        In in = new In(hypernyms);
        while (in.hasNextLine()) {
            String line = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            int v = Integer.parseInt(tokenizer.nextToken());
            while (tokenizer.hasMoreTokens()) {
                int w = Integer.parseInt(tokenizer.nextToken());
                digraph.addEdge(v,w);
            }
        }
    }

    private void createSynsetMap(String synsets) {
        In in = new In(synsets);
        while (in.hasNextLine()) {
            String line = in.readLine();
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            int id = Integer.parseInt(tokenizer.nextToken());
            String nounString = tokenizer.nextToken();
            Set<String> nounSet = new HashSet<String>();
            StringTokenizer nounTokenizer = new StringTokenizer(nounString, " ");
            while (nounTokenizer.hasMoreTokens()) {
                String n = nounTokenizer.nextToken();
                nounSet.add(n);
                reverseMap.put(n, id);
            }
            String definition = tokenizer.nextToken();
            idToSynset.put(id, new SynSet(id, nounSet, definition));
        }
    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return reverseMap.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return reverseMap.containsKey(word);
    }

    // distance between nounA and nounB (defined below)
    public int distance(String nounA, String nounB) {
        if (nounA == null || nounB == null)
        {
            throw new NullPointerException();
        }
        if (!isNoun(nounA) || !isNoun(nounB))
        {
            throw new IllegalArgumentException();
        }
        int idNounA = reverseMap.get(nounA);
        int idNounB = reverseMap.get(nounB);
        SAP sap = new SAP(this.digraph);
        return sap.length(idNounA, idNounB);
    }

    // a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
    // in a shortest ancestral path (defined below)
    public String sap(String nounA, String nounB) {
        if (nounA == null || nounB == null)
        {
            throw new NullPointerException();
        }
        if (!isNoun(nounA) || !isNoun(nounB))
        {
            throw new IllegalArgumentException();
        }
        int idNounA = reverseMap.get(nounA);
        int idNounB = reverseMap.get(nounB);
        SAP sap = new SAP(this.digraph);
        int ancestor = sap.ancestor(idNounA, idNounB);
        SynSet synSet = this.idToSynset.get(ancestor);
        String result = "";
        for(String s : synSet.getNouns()) {
            result += s + " ";
        }
        return result;
    }
}

