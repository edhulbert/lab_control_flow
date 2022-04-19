package org.example.day4._4_arrays;

import java.util.Arrays;

public class ArraysExercises {

    /*
        TODO 15

        firstLast0([0, 1, 2])   -> true
        firstLast0([0, 0, 0, 0] -> true
        firstLast0([5, 66, 0]   -> true
        firstLast0([7, 8])      -> false
        firstLast0([])          -> false
     */
    boolean firstLast0(int[] array) {
        int len = array.length;
        if (len>0) {
            if (array[0] == 0 || array[len - 1] == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*
        TODO 16

        Arrays with 3 args only!

        middleInts([5, 26, 19], [1, 34, 22])        -> [26, 34]
        middleInts([11, 99, 5], [100, 20, 14]       -> [99, 20]
        middleInts([7, 7, 7], [44, 17, 56]          -> [7, 17]
     */
    int[] middleInts(int[] a, int[] b) {

        int midA = a[1];
        int midB = b[1];

        return new int[]{midA, midB};
    }


    /*
       TODO 17

       Write a program that reverses an array of Strings
       reverse({"you", "are", "how", "hello"})  ->  {"hello", "how", "are", "you"}
       reverse({"", null, "me"})                ->  {"me", null, ""}
     */

    String[] reverse(String[] baseArray) {

        for (int i = 0; i < baseArray.length/2; i++) {
            String temp = baseArray[i];
            baseArray[i] = baseArray[baseArray.length-1-i];
            baseArray[baseArray.length-1-i] = temp;
        }
        return baseArray;
    }

    /*

        TODO 18

        sum([3, 4, 8])    -> 15
        sum([12, 80])     -> 92
        sum([3, 3, 5, 5]) -> 16
        sum([4])          -> 4
        sum([])           -> 0
     */
    int sum(int[] nums) {
        int numSum = 0;
        int len = nums.length;
        for (int i =0; i < len; i++) {
            numSum += nums[i];
        }

        return numSum;
    }

    /*
        TODO 19

        Given a non-empty array, return true if there is a place to split the array so that
        the sum of the numbers on one side is equal to the sum of the numbers on the other side

        isBalanced([1, 3, 2, 2])     -> true
        isBalanced([5, 5])           -> true
        isBalanced([8, 0, 2, -2, 8]  -> true
        isBalanced([30])             -> false
        isBalanced([2, 3, 4, 1, 2]]) -> false
     */
    boolean isBalanced(int[] array) {

        int len = array.length;
        int leftSide = 0;
        int total = 0;

        //calculate total
        for (int i =0; i < len; i++) {
            total += array[i];
        }

        for (int i = 0; i < len; i++) {
            //sum leftside up until index i
            for (int leftIndex = 0; leftIndex < i; leftIndex++) {
                leftSide += array[leftIndex];
            }
            if (leftSide == total / 2) {
                return true;
            }
            leftSide = 0;
        }
        return false;
    }

    /*
        TODO 20

        Return difference between max value and min value

        diff([10, 5, 8, 1, 4]) -> 9
        diff([5, 4, 6, 7])     -> 3
        diff([6, 6])           -> 0
        diff([-5, 3, 9])       ->14
     */
    int diff(int[] array) {
        int len = array.length;
        int tempHigh = array[0];
        int tempLow = array[0];

        for (int i = 1; i < len; i++) {
            if (array[i] > tempHigh) {
                tempHigh = array[i];
            } else if (array[i] < tempLow) {
                tempLow = array[i];
            }
        }
        return tempHigh-tempLow;

    }

    /*
        TODO 21

        A group is at least two adjacent elements of the same value. Count the number of groups.

        countGroups([1, 2, 2, 3, 4, 4]) -> 2
        countGroups([3, 3, 6, 3, 3])    -> 2
        countGroups([5, 5, 5, 5, 5])    -> 1
        countGroups([])                 -> 0
        countGroups([5, 3, 6, 2, 4])    -> 0
     */
    int countGroups(int[] array) {
        int numGroups = 0;
        int len = array.length;

        if (len <= 1) {
            numGroups = 0;
        } else {
            int temp = array[0];
            for (int i = 1; i < len; i++) {
                if (array[i] == temp) {
                    if (i >= 2) {
                        if (array[i] != array[i-2]){
                            numGroups++;
                        }
                    } else {
                        numGroups++;
                    }
                }
                temp=array[i];
            }
        }

        return numGroups;
    }

    /*
        TODO 22

        innerInside([5, 6, 7, 4, 3, 3], [6, 4]) -> true
        innerInside([3, 3, 5, 5, 6, 6], [5, 3]) -> true
        innerInside([-1, 2, 3, 2], [3])         -> true
        innerInside([2, 5], [2, 5])             -> true
        innerInside([5, 4, 6, 32, 5], [4, 8])   -> false
        innerInside([], [5])                    -> false
     */
    boolean innerInside(int[] outer, int[] inner) {
        int lenInner = inner.length;
        int lenOuter = outer.length;

        int innerTest[] = new int[lenInner];



        if (lenInner > 0 && lenOuter > 0) {
            for (int n = 0; n < lenInner; n++) {
                for (int m = 0; m < lenOuter; m++) {
                    if (outer[m] == inner[n]) {
                        innerTest[n] = inner[n];
                        break;
                    }
                }
            }
        } else {
            return false;
        }
        if (Arrays.equals(inner, innerTest)) {
            return true;
        } else {
            return false;
        }
    }
}