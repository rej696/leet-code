class Solution {
  
  // Taken from https://redquark.org/leetcode/0001-two-sum/
  // Initialise a map of {key: (target - nums[i]) value: nums[j]}
  // loop over array
  // check if value of current index is an index on the map (i.e. equals nums[j] = target - nums[i])
  // otherwise, add key value pair to map
  private int[] twoSumEvenFaster(int[] nums, int target) {
    int[] retval = {0, 0};
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for (int i = 0; i < nums.length; ++i) {
      if (map.containsKey(nums[i])) {
        retval[0] = i;
        retval[1] = map.get(nums[i]);
        break;
      } else {
        map.put(target - nums[i], i);
      }
    }
    
    return retval;
  }
  
  // loop indicies over array
  // inner loop starts at i + 1 to prevent duplication of combinations
  // break when target equals sum
  private int[] twoSumFast(int[] nums, int target) {
    int[] retval = {0, 0};
    
    for (int i = 0; i < nums.length; ++i) {
      for (int j = i + 1; j < nums.length; ++j) {
        if ((nums[i] + nums[j]) == target) {
          retval[0] = i;
          retval[1] = j;
          break;
        }
      }
    }
    
    return retval;
  }
  
  // Loop indicies over array
  // break when target equals sum
  private int[] twoSumSlow(int[] nums, int target) {
    int[] retval = {0, 0};
    
    for (int i = 0; i < nums.length; ++i) {
      for (int j = 0; j < nums.length; ++j) {
        if (i == j) {
          continue;
        } else if ((nums[i] + nums[j]) == target) {
          retval[0] = i;
          retval[1] = j;
          break;
        }
      }
    }
    
    return retval;
  }
  
  public int[] twoSum(int[] nums, int target) {
    // return twoSumFast(nums, target);
    return twoSumEvenFaster(nums, target);
  }
}