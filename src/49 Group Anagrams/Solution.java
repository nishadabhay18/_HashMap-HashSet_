class Solution {
    // TC-> O(n*k) SC-> O(n*k) k is length of one string
    public HashMap<Character,Integer> makeMap(String str){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch) + 1);
            else mp.put(ch, 1);
        }
        return mp;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> res = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String str = strs[i];
            HashMap<Character,Integer> mp = makeMap(str);
            if(!map.containsKey(mp)) map.put(mp, new ArrayList<>());
            map.get(mp).add(str);
        }
        for(List<String> val : map.values()) res.add(val);
        return res;
    }
}