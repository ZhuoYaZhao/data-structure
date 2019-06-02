package main.Sorted;

import main.utils.RunTime;
import main.utils.TimerUtil;

import java.util.Random;

public class Sort<T extends Comparable<? super T>> {
    @RunTime
    public T[] bubbleSort(T[] values) {
        int len = values.length - 1;
        for (int i = 0; i < len; i++) {//表示趟数，一共values.length-1次。
            for (int j = len; j > i; j--) {
                if (values[j].compareTo(values[j - 1]) < 0) {
                    T t = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = t;
                }
            }
        }

        return values;
    }

    @RunTime
    public T[] bubbleSort1(T[] values) { //优化后的算法
        int len = values.length - 1;
        boolean flag;//是否交换的标志
        for (int i = 0; i < len; i++) {//表示趟数，一共values.length-1次。
            flag = false;
            for (int j = len; j > i; j--) {
                if (values[j].compareTo(values[j - 1]) < 0) {
                    T t = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = t;
                    flag = true;
                }
            }
            if (!flag) break;
        }

        return values;
    }

    @RunTime
    public T[] selectSort(T[] values) {

        int length = values.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (values[j].compareTo(values[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T t = values[i];
                values[i] = values[minIndex];
                values[minIndex] = t;
            }
        }
        return values;

    }

    @RunTime
    public T[] insertSort(T[] values) {
        T t;
        int length = values.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (values[j].compareTo(values[j - 1]) < 0) {
                    t = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = t;
                }
            }
        }
        return values;
    }

    @RunTime
    public T[] shellSort(T[] values) {
        T temp;
        int incre = values.length;
        int length = values.length;
        while (true) {
            incre = incre / 2;

            for (int k = 0; k < incre; k++) {    //根据增量分为若干子序列

                for (int i = k + incre; i < length; i += incre) {

                    for (int j = i; j > k; j -= incre) {
                        if (values[j].compareTo(values[j - incre]) > 0) {
                            temp = values[j - incre];
                            values[j - incre] = values[j];
                            values[j] = temp;
                        } else {
                            break;
                        }
                    }
                }
            }

            if (incre == 1) {
                break;
            }
        }

        return values;
    }


    public static void main(String[] args) {
        Random random = new Random();

        Double[] doubles = new Double[10000];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = random.nextGaussian();
        }
//        Double[] doubles1 = {1.2, 45., 45.54, 45., 11.0, 8.2, 86., .3, 4.};
        TimerUtil timerUtil = new TimerUtil();
        timerUtil.getTime((Object) doubles);

    }

}
