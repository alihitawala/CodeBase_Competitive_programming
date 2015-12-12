package MiscTopic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by aliHitawala on 12/4/15.
 */
public class SetIntersection {
    //size n log m,
    // n < m

    public static <E> Set<E> intersection(final Set<E> one, final Set<E> two) {
        Set<E> retSet = new HashSet<>(one);
        //code
        for (E t : two) {
            if (retSet.contains(t)) {
                retSet.remove(t);
            }
        }
        for (E o : one) {
            if (retSet.contains(o)) {
                retSet.remove(o);
            }
            else
                retSet.add(o);
        }
        return retSet;
    }
}
