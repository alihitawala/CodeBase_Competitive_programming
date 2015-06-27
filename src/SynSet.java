import java.util.Set;

/**
 * Created by aliHitawala on 5/3/15.
 */
public class SynSet {
    private final int id;
    private final Set<String> nouns;
    private final String definition;

    public SynSet(int id, Set<String> nouns, String definition) {
        this.id = id;
        this.nouns = nouns;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public Set<String> getNouns() {
        return nouns;
    }

    public String getDefinition() {
        return definition;
    }

    @Override
    public String toString() {
        return "SynSet{" +
                "id=" + id +
                ", nouns=" + nouns +
                ", definition='" + definition + '\'' +
                '}';
    }
}
