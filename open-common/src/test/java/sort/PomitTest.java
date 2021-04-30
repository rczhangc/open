package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序：先对数组中数字的最小位进行排序，然后依次根据其他位的大小进行排序，直到最高位
 * 插入排序：数组中的元素依次跟前面已排序好的元素做比较，如果选择的元素比已排序的元素小，则进行交换，直到全部元素都比较过为止
 *
 * @author barnak
 */
public class PomitTest {
    public static void main(String[] args) {
        int[] arr = { 33, 65, 791, 32, 55, 47, 89, 11 };

        // 基数排序，目前方法仅支持正数
//        radixSort(arr);
        // 插入排序
        insertSort(arr);
        System.out.println(Arrays.toString(arr)); // [11, 32, 33, 47, 55, 65, 89, 791]
    }

    public static void radixSort(int arr[]) {
        // 循环获取数组中最大的数
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        // 获取最大数的位数
        int figures = 0;
        while (max > 0) {
            max /= 10;
            figures ++;
        }
        // 初始化排序容器
        List<List<Integer>> bucketList = new ArrayList<>(10);
        for (int i=0 ; i < 10; i++) {
            bucketList.add(new ArrayList<>());
        }
        // 取位排序，从最低位开始排序，直到最高位，有多少位外层循环就执行多少次
        for (int i = 0, divisor = 1; i < figures; i++, divisor *= 10) {
            for (int value : arr) {
                // 取当前位的数字为排序容器的位置
                int bucketIndex = value / divisor % 10;
                bucketList.get(bucketIndex).add(value);
            }
            int arrayIndex = 0;
            for (int j = bucketList.size() - 1 ; j >= 0; j--) {
                List<Integer> bucket = bucketList.get(j);
                while (bucket.size() > 0) {
                    arr[arrayIndex] = bucket.get(0);
                    bucket.remove(0);
                    arrayIndex ++;
                }
            }
        }
    }

    /**
     * 直接插入排序，升序
     *
     * @param arr
     */
    public static void insertSort(int arr[]) {
        for (int i=1 ; i< arr.length ; i++) {
            int cur = arr[i];
            int index = i;
            for (int j=i-1; j >= 0; j--) {
                if (arr[j] > cur) {
                    arr[j+1] = arr[j];
                    index = j;
                }
            }
            arr[index] = cur;
        }
    }
}
