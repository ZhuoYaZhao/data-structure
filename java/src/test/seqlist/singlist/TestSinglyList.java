package test.seqlist.singlist;

import main.singlylist.SinglyList;

public class TestSinglyList {
    public static void main(String[] args) {
        testSingList();
    }

    public static void testSingList() {
        Integer[] integers = {1,2,3,4,5,6};
        SinglyList<Integer> integerSinglyList = new SinglyList<>(integers);
        System.out.println(integerSinglyList);
        System.out.println("size:" + integerSinglyList.size());
//        integerSinglyList.set(5, 0);
//        System.out.println(integerSinglyList);
//        integerSinglyList.remove(1);
//        System.out.println(integerSinglyList);
//        integerSinglyList.remove(5);
//        System.out.println(integerSinglyList);
//        integerSinglyList.remove(new Integer(454));
//        System.out.println(integerSinglyList);
        System.out.println("reverse:"+ integerSinglyList.reverse());

    }
}
