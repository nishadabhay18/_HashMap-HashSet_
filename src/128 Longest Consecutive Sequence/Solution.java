class Solution {
    // TC-> O(nlogn)
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int len = 0;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1] + 1) len++;
        }
        return len+1;
    }

    // TC-> O(n) checks only when element is starting element
    public int longestConsecutive(int[] nums){
        int n=nums.length;
        if(n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(nums[i]);
        int longestStreak = 0;
        for(int i=0; i<n; i++){
            // valid start
            if(!set.contains(nums[i]-1)){
                int currNum = nums[i];
                int currStreak = 1;
                while(set.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }
        return longestStreak;
    }
}