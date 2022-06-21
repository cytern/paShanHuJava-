package dam.jsoup.updatereport.updatreport.linkList;

public class TwoSearch {

    public static void main(String[] args) {
        TwoSearch twoSearch = new TwoSearch();
        int[] sources = twoSearch.getSources();
        int search = twoSearch.search(sources, 3);
        System.out.println(search);
    }

    private int[] getSources () {
      int[]  nums = new int[6];
      nums[0] = -1;
      nums[1] = 0;
      nums[2] = 3;
      nums[3] = 5;
      nums[4] = 9;
      nums[5] = 12;
      return nums;
    }


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }




}
