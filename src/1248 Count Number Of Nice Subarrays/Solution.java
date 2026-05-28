class Solution {
    // TC-> O(n) SC-> O(n)
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] % 2 == 0) nums[i] = 0;
        }
        for(int i=1; i<n; i++) nums[i] += nums[i-1];
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 0);
        int count = 0;
        for(int i=0; i<n; i++){
            int val = nums[i] - k;
            if(nums[i] == k) count++;
            if(mp.containsKey(val)) count += mp.get(val);
            if(mp.containsKey(nums[i])) mp.put(nums[i], mp.get(nums[i]) + 1);
            else mp.put(nums[i], 1);
        }
        return count;
    }
}