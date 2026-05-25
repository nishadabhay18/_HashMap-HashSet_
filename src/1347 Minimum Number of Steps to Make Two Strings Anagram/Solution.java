class Solution {
    // TC-> O(n) SC-> O(1)
    public HashMap<Character,Integer> makeMap(String str){
        int n=str.length();
        HashMap<Character, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(mp.containsKey(ch)) mp.put(ch, mp.get(ch)+1);
            else mp.put(ch,1);
        }
        return mp;
    }
    public int minSteps(String s, String t) {
        int n1=s.length(), n2=t.length();
        HashMap<Character, Integer> mp=makeMap(s);
        int count=0;
        for(int i=0;i<n2;i++){
            char ch=t.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch)-1);
                if(mp.get(ch)==0) mp.remove(ch);
            }else count++;
        }
        return count;
    }
}