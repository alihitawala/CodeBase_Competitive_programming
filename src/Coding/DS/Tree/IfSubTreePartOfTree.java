package Coding.DS.Tree;

/**
 * Created by aliHitawala on 8/4/15.
 */
public class IfSubTreePartOfTree {
    private static boolean ifSubtreeRefSame(Tree mainTree, Tree subTree) {
        if (subTree == null)
            return true;
        if (mainTree == null)
            return false;
        return mainTree == subTree
                || ifSubtreeRefSame(mainTree.getLeft(), subTree)
                || ifSubtreeRefSame(mainTree.getRight(), subTree);
    }

    private static boolean ifSubtreeSameByValue(Tree mainTree, Tree subTree) {
        if (subTree == null)
            return true;
        return mainTree != null
                && ((mainTree.getData().equals(subTree.getData())
                    && ifSubtreeSameByValue(mainTree.getRight(), subTree.getRight())
                    && ifSubtreeSameByValue(mainTree.getLeft(), subTree.getLeft()))
                || ifSubtreeSameByValue(mainTree.getLeft(), subTree)
                || ifSubtreeSameByValue(mainTree.getRight(), subTree));
    }
}
