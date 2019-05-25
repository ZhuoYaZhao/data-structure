package test.seqlist;

import main.seqlist.SeqList;
import main.seqlist.SortedSeqList;

public class TestSortedSeqList {
    public static void main(String[] args) {
//        Integer[] integers = {1, 56, 456, 46, 465464, 454, 6545, 54, 645};
//        SeqList<Integer> integerSeqList = new SeqList<>(integers);
//        System.out.println("integerSeqList:" + integerSeqList);
//        SortedSeqList<Integer> integerSortedSeqList = new SortedSeqList<>(integers);
//        System.out.println("integerSortedSeqList: "+integerSortedSeqList);
//        SeqList<Integer> list = new SortedSeqList<>(integers);
//        System.out.println(list);
        testUnion();
    }

    public static void testUnion() {
        Integer[] integers1 = {4, 5456, 45, 46, 44, 5};
        Integer[] integers2 = {4, 5456, 45, 1, 2};
        SortedSeqList<Integer> seqList1 = new SortedSeqList<Integer>(integers1);
        SortedSeqList<Integer> seqList2 = new SortedSeqList<Integer>(integers2);
        System.out.println(seqList1.union(seqList2));

    }
}
