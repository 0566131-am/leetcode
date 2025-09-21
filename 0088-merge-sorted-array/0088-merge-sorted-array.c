void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    for(int i = nums1Size - 1; i >= 0; i--) {
        if (m > 0 && n > 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[i] = nums1[m - 1];
                m--;
            } else {
                nums1[i] = nums2[n - 1];
                n--;
            }
        } else if (m > 0) {
            nums1[i] = nums1[m - 1];
            m--;
        } else {
            nums1[i] = nums2[n - 1];
            n--;
        }
    }
}