package com.xten.op.algorithm.array;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/8/29
 */
public class Plus {


    public static void main(String[] args) {
        int[] nums = {9,10,2,4,8,5};
        int k =3;
        System.out.println(kthLargestElement(k,nums));
    }

    /*
    * @param k : description of k
    * @param nums : array of nums
    * @return: description of return
    */
    public static int kthLargestElement(int k, int[] nums) {
        // write your code here

        int[] heap = new int[k+1];

        int size = 0;

        for(int i =0 ;i < nums.length ; i++){

            if(size  < k) {
                size ++ ;
                heap[size] = nums[i];
                add(heap,size);
                if (size > k) {
                    size -- ;
                }

            }else if ( heap[1] < nums[i]){
                heap[1] = nums[i];
                addFull(heap);
            }
        }

        return heap[1];

    }

    public static void addFull(int[] heap){

        int i =1;
        while (i*2 <= heap.length){
            if (heap[i] > heap[i*2] && heap[i*2] < heap[i*2 + 1]){

                int temp = heap[i];
                heap[i] = heap[i*2];
                heap[i*2] = temp;
                i = i*2;
            }else if (heap[i] > heap[i*2 +1] && heap[i*2] > heap[i*2 + 1]) {
                int temp = heap[i];
                heap[i] = heap[i*2+1];
                heap[i*2+1] = temp;
                i = i*2+1;
            }else {
                break;
            }
        }
    }

    private static void add(int[] heap,int size){

        int offset = size;
        int p = offset / 2;
        while (heap[p] > heap[offset] && offset != 1) {

            int temp = heap[offset];
            heap[offset] = heap[p];
            heap[p] = temp;

            offset = p;
        }


    }

}
