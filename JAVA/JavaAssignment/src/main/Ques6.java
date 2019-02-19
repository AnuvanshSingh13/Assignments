package main;

public class Ques6 {
    //There is an array with every element repeated twice except one. Find that element
    public static void main(String[] args) {
        int[]arr={5,6,5,6,8,9,8};
        System.out.println("The element that occurs once is: "+single(arr)+"");
    }

    private static int single(int[] a) {
        int res=a[0];
        for (int i=1;i<a.length;i++){
            res ^=a[i];
        }

        return res;
    }
}
