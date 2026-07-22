import java.util.*;

class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }

        // Decompose string s into contiguous segments
        List<int[]> segs = new ArrayList<>(); // {type (0 or 1), L, R, len}
        int[] segIdx = new int[n];
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int type = s.charAt(i) - '0';
            int L = i, R = j - 1, len = R - L + 1;
            int idx = segs.size();
            segs.add(new int[]{type, L, R, len});
            for (int k = L; k <= R; k++) {
                segIdx[k] = idx;
            }
            i = j;
        }

        int m = segs.size();
        int[] V = new int[m];

        for (int j = 0; j < m; j++) {
            if (segs.get(j)[0] == 1) {
                if (j - 1 >= 0 && j + 1 < m) {
                    V[j] = segs.get(j - 1)[3] + segs.get(j + 1)[3];
                }
            }
        }

        // Build Sparse Table for Range Maximum Queries
        int maxLog = 0;
        while ((1 << maxLog) <= m) maxLog++;
        int[][] st = new int[maxLog + 1][m];
        for (int i = 0; i < m; i++) {
            st[0][i] = V[i];
        }
        for (int k = 1; k <= maxLog; k++) {
            int len = 1 << (k - 1);
            for (int i = 0; i + (1 << k) <= m; i++) {
                st[k][i] = Math.max(st[k - 1][i], st[k - 1][i + len]);
            }
        }

        int[] logTable = new int[m + 1];
        for (int i = 2; i <= m; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        List<Integer> ans = new ArrayList<>(queries.length);

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            int idL = segIdx[l];
            int idR = segIdx[r];

            int maxGain = 0;

            if (idR - idL >= 2) {
                // 1. Fully internal segments: j in [idL + 2, idR - 2]
                int ql = idL + 2;
                int qr = idR - 2;
                if (ql <= qr) {
                    int k = logTable[qr - ql + 1];
                    int rmqVal = Math.max(st[k][ql], st[k][qr - (1 << k) + 1]);
                    maxGain = Math.max(maxGain, rmqVal);
                }

                // 2. Left boundary segment: j = idL + 1
                int jLeft = idL + 1;
                if (segs.get(jLeft)[0] == 1 && segs.get(jLeft)[2] <= r) {
                    int lenL = segs.get(idL)[2] - l + 1;
                    int lenR = (jLeft + 1 == idR) ? (r - segs.get(idR)[1] + 1) : segs.get(jLeft + 1)[3];
                    maxGain = Math.max(maxGain, lenL + lenR);
                }

                // 3. Right boundary segment: j = idR - 1
                int jRight = idR - 1;
                if (segs.get(jRight)[0] == 1 && segs.get(jRight)[1] >= l) {
                    int lenR = r - segs.get(idR)[1] + 1;
                    int lenL = (jRight - 1 == idL) ? (segs.get(idL)[2] - l + 1) : segs.get(jRight - 1)[3];
                    maxGain = Math.max(maxGain, lenL + lenR);
                }
            }

            ans.add(totalOnes + maxGain);
        }

        return ans;
    }
}