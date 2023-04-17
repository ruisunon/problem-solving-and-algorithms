package net.leetcode.questions.disjoint_set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * A disjoint set is a generic data structure that represents a collection of
 * sets that are assumed to be disjoint (no object exists in more than
 * one set).
 */
public class DisjointSet {
  /**
   * A node in the disjoint set forest.  Each tree in the forest is
   * a disjoint set, where the root of the tree is the set representative.
   */
  private static class Node {
    /** The node rank used for union by rank optimization */
    int rank;
    /** The parent of this node in the tree. */
    Object parent;

    Node(Object parent, int rank) {
      this.parent = parent;
      this.rank = rank;
    }
  }

  /**
   * Map of Object -> Node, where each key is an object in the
   * disjoint set, and the Node represents its position and rank
   * within the set.
   */
  private final HashMap objectsToNodes = new HashMap();

  /**
   * Returns the set token for the given object, or null if the
   * object does not belong to any set.  All object
   * in the same set have an identical set token.
   */
  public Object findSet(Object obj) {
    DisjointSet.Node node = (DisjointSet.Node) objectsToNodes.get(obj);
    if (node == null)
      return null;
    if (obj != node.parent)
      node.parent = findSet(node.parent);
    return node.parent;
  }

  public void makeSet(Object obj) {
    objectsToNodes.put(obj, new Node(obj, 0));
  }

  /**
   * Removes all elements belonging to the set of the given object.
   */
  public void removeSet(Object o) {
    Object set = findSet(o);
    if (set == null)
      return;
    for (Iterator it = objectsToNodes.keySet().iterator(); it.hasNext();) {
      Object next = it.next();
      //remove the set representative last, otherwise findSet will fail
      if (next != set && findSet(next) == set)
        it.remove();
    }
    objectsToNodes.remove(set);
  }

  /**
   * Copies all objects in the disjoint set to the provided list
   */
  public void toList(List list) {
    list.addAll(objectsToNodes.keySet());
  }

  /**
   * Unions the set represented by token x with the set represented by
   * token y. Has no effect if either x or y is not in the disjoint set, or
   * if they already belong to the same set.
   * @param x The first set to union
   * @param y The second set to union
   */
  public void union(Object x, Object y) {
    Object setX = findSet(x);
    Object setY = findSet(y);
    if (setX == null || setY == null || setX == setY)
      return;
    DisjointSet.Node nodeX = (DisjointSet.Node) objectsToNodes.get(setX);
    DisjointSet.Node nodeY = (DisjointSet.Node) objectsToNodes.get(setY);
    //join the two sets by pointing the root of one at the root of the other
    if (nodeX.rank > nodeY.rank) {
      nodeY.parent = x;
    } else {
      nodeX.parent = y;
      if (nodeX.rank == nodeY.rank)
        nodeY.rank++;
    }
  }
}