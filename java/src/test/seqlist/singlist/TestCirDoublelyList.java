package test.seqlist.singlist;

import main.seqlist.SeqList;
import main.singlylist.CirDoublelyList;
import main.singlylist.SinglyList;

public class TestCirDoublelyList {
    public static void main(String[] args) {
//        testTestCirDoublelyList();
//        testMuti();
        testAddAll();
    }

    public static void testTestCirDoublelyList(){
        CirDoublelyList<Integer> cirDoublelyList = new CirDoublelyList<>();
        cirDoublelyList.insert(1);
        cirDoublelyList.insert(2);
        cirDoublelyList.insert(3);
        cirDoublelyList.insert(4);
        cirDoublelyList.insert(5);
        cirDoublelyList.insert(1,5);
        cirDoublelyList.insert(1,6);
        System.out.println(cirDoublelyList);
        System.out.println(cirDoublelyList.isEmpty());
        System.out.println(cirDoublelyList.remove(0));
        System.out.println(cirDoublelyList.remove(-1));
        System.out.println(cirDoublelyList);
        System.out.println(cirDoublelyList.remove(2));
        System.out.println(cirDoublelyList);
        System.out.println("================");

        Integer[] integers = {4, 54, 54, 54, 5, 454, 54, 5, 45};
        CirDoublelyList<Integer> cirDoublelyList1 = new CirDoublelyList<>(integers);
        System.out.println(cirDoublelyList1);

    }
    public static void  testMuti(){

        Integer[] integers = {4, 54, 54, 54, 5, 454, 54, 5, 45};
        SinglyList<Integer> integerSinglyList = new SinglyList<>(integers);
        SeqList<Integer> seqList = new SeqList<>();

        CirDoublelyList<Integer> cirDoublelyList1 = new CirDoublelyList<>(integerSinglyList);
        cirDoublelyList1.set(0, 0);
        cirDoublelyList1.set(1, 5);
        System.out.println(cirDoublelyList1);
        System.out.println(cirDoublelyList1.get(0));
        System.out.println(cirDoublelyList1.get(1));

    }
    public static void testAddAll(){
        Integer[] integers = {4, 54, 54, 54, 5, 454, 54, 5, 45};
        CirDoublelyList<Integer> cirDoublelyList1 = new CirDoublelyList<>(integers);
        CirDoublelyList<Integer> cirDoublelyList2 = new CirDoublelyList<>(cirDoublelyList1);

        cirDoublelyList1.addAll(cirDoublelyList1);
        System.out.println(cirDoublelyList1);

    }

}
