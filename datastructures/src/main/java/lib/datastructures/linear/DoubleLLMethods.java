package lib.datastructures.linear;

import lib.datastructures.nodes.NodeD;

public interface DoubleLLMethods {
    void insertHead(NodeD node);

    void insertTail(NodeD node);

    void insert(NodeD node, int index);

    void sortedInsert(NodeD node);

    void deleteHead();

    void deleteTail();
 

    void delete(NodeD node);

    void sort();

    void clear();

    void print();

    NodeD search(NodeD node);
}
