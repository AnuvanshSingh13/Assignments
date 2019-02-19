package main;

public class Ques5 {
    public static void main(String[] args) {
        int[]arr1={1,4,9,45,16,78,5,6};
        int[]arr2={5,6,7,8,9,10,11,4};
        for (int i=0;i<arr1.length;i++){
            for (int j=0;j<arr1.length;j++){
                if(arr1[i]==arr2[j]){
                    System.out.println(arr1[i]);//printing all the common element with their occurance
                }
            }
        }
    }
}
