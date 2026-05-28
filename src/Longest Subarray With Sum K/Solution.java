class Solution {
    // TC-> O(n) SC-> O(n)
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        for(int i=1; i<n; i++) arr[i] += arr[i-1];
        int maxLen = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for(int i=0; i<n; i++){
            int val = arr[i] - k;
            if(mp.containsKey(val)){
                int len = i - mp.get(val);
                maxLen = Math.max(maxLen, len);
            }
            if(!mp.containsKey(arr[i])) mp.put(arr[i], i);
        }
        return maxLen;
    }
}
