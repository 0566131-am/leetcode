class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int f = flowers.length, p = people.length,
            st[] = new int[f], en[] = new int[f];
        for(int i=0; i<f; i++){
            st[i] = flowers[i][0] << 1;
            en[i] = flowers[i][1] << 1;
        }
        Arrays.sort(st); Arrays.sort(en);

        int ans[] = new int[p];
        for(int i=0; i<p; i++){
            int add = -Arrays.binarySearch(st, (people[i]<<1) + 1) -1;
            int sub = -Arrays.binarySearch(en, (people[i]<<1) - 1) -1;
            ans[i] = add - sub;
        }
        return ans;
    }
}