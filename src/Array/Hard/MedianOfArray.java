package Array.Hard;

public class MedianOfArray {

    public double getMedian(int[] arr1, int[] arr2){
        if(arr1.length < arr2.length) getMedian(arr2, arr1);

        int len1 = arr1.length;
        int len2 = arr2.length;
        int low, high;

        low =0; high = len1;

        while (low<= high){

            int cut1 = (low+high)/2;
            int cut2 = (len1+len2+1)/2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];

            int r1 = cut1 == len1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == len2 ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if( (len1+len2) % 2 ==0 ) return (Math.max(l1, l2) + Math.min(r1, r2)) /2 ;
                else Math.max(l1, l2);
            }
            else if (l1 > r2) high = cut1-1;
            else low = cut1+1;

            return 0.00;
        }
    }
}
