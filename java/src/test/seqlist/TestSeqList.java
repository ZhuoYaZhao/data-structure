package test.seqlist;

import main.seqlist.SeqList;

public class TestSeqList {
    public static void main(String[] args) {
//        Integer[] integers = {4, 5456, 45, 46, 44, 5};
//        SeqList<Integer> seqList = new SeqList<Integer>(integers);
//        System.out.println(seqList);
//        seqList.insert(45);
//        System.out.println(seqList);
//        seqList.insert(0, 0);
//        System.out.println(seqList);
//        testUniou();
//        testSearch();
        testUnion();
    }

    public static void testUnion() {
        Integer[] integers1 = {4, 5456, 45, 46, 44, 5};
        Integer[] integers2 = {4, 5456, 45, 1, 2};
        SeqList<Integer> seqList1 = new SeqList<Integer>(integers1);
        SeqList<Integer> seqList2 = new SeqList<Integer>(integers2);
        System.out.println(seqList1.union(seqList2));

    }
    public static void testSearch() {
        Integer[] integers1 = {4, 5456, 45, 46, 44, 5};
        SeqList<Integer> seqList1 = new SeqList<Integer>(integers1);
        System.out.println(seqList1.search(4));
        System.out.println(seqList1.search(1));
    }


    }
