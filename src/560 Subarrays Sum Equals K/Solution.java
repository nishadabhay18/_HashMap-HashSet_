class Solution {
    // TC-> O(n) SC-> O(n)
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        for(int i=1; i<n; i++) arr[i] += arr[i-1];
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<n; i++){
            int ele = arr[i];
            if(ele == k) count++;
            int rem = ele - k;
            if(mp.containsKey(rem)) count += mp.get(rem);
            if(!mp.containsKey(ele)) mp.put(arr[i], 1);
            else mp.put(arr[i], mp.get(ele) + 1);
        }
        return count;
    }
}