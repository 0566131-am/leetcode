class Solution {
    public int reverseBits(int n) {
        String str=Integer.toBinaryString(n);
        StringBuilder s=new StringBuilder(str);
        while(s.length()<32){
            s.insert(0,"0");
        }
        int res=Integer.parseInt(s.reverse().toString(),2);
        return res;
    }
}