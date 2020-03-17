在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
class Solution {
    private int count;
    public int reversePairs(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return count;
    }
    private void mergeSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int mid=(left+right)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private void merge(int[] nums,int left,int mid,int right){
        int i=left;
        int j=mid+1;
        int len=right-left+1;
        int[] tmp=new int[len];
        int k=0;
        while(i<=mid&&j<=right){
            if(nums[i]<=nums[j]){
                tmp[k++]=nums[i++];
            }else{
                tmp[k++]=nums[j++];
                count+=(mid-i+1);
            }
        }
        while(i<=mid){
            tmp[k++]=nums[i++];
        }
        while(j<=right){
            tmp[k++]=nums[j++];
        }
        for(int n=0;n<len;n++){
            nums[left+n]=tmp[n];
        }
    }
}

    
   
