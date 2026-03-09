class Solution {
    int MOD = 1_000_000_007;
    Integer[][][][] memo;
    int limit;

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        memo = new Integer[zero + 1][one + 1][2][limit + 1];

        int res = 0;

        if (zero > 0)
            res = (res + dfs(zero - 1, one, 0, 1)) % MOD;

        if (one > 0)
            res = (res + dfs(zero, one - 1, 1, 1)) % MOD;

        return res;
    }

    private int dfs(int z, int o, int last, int len) {
        if (z == 0 && o == 0)
            return 1;

        if (memo[z][o][last][len] != null)
            return memo[z][o][last][len];

        long ans = 0;

        if (last == 0) {
            if (z > 0 && len < limit)
                ans += dfs(z - 1, o, 0, len + 1);

            if (o > 0)
                ans += dfs(z, o - 1, 1, 1);
        } else {
            if (o > 0 && len < limit)
                ans += dfs(z, o - 1, 1, len + 1);

            if (z > 0)
                ans += dfs(z - 1, o, 0, 1);
        }

        return memo[z][o][last][len] = (int)(ans % MOD);
    }
}