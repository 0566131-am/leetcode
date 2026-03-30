class Solution {
    public boolean checkStrings(String s1, String s2) {
  int [] freq=new int[52];
  for(int i=0;i<s1.length();i++){
    int a=(i&1)*26;
    freq[s1.charAt(i)-'a'+a]++;
    freq[s2.charAt(i)-'a'+a]--;
  }                                                                                                         for(int i=0;i<52;i++){
  if(freq[i]!=0) return false;
  }
  return true;                                                                   
}
}