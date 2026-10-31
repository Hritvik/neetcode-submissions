class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            if (set.contains(target)) {
                continue;
            }
            set.add(target);
            int m = i + 1;
            int n = nums.length - 1;
            while (true) {
                int[] pair = twoSum(nums, m, n, target);
                if (pair[0] == -1) {
                    break;
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(-target);
                    ans.add(nums[pair[0]]);
                    ans.add(nums[pair[1]]);
                    if (!set2.contains(
                            "#" + (-target) + "#" + nums[pair[0]] + "#" + nums[pair[1]])) {
                        res.add(ans);
                        set2.add("#" + (-target) + "#" + nums[pair[0]] + "#" + nums[pair[1]]);
                    }

                    m = pair[0] + 1;
                    n = pair[1] - 1;
                }
            }
        }
        return res;
    }

    int[] twoSum(int[] nums, int i, int j, int target) {
        int p = i;
        int q = j;
        while (p <= j && q >= i && p < q) {
            int sum = nums[p] + nums[q];
            if (sum < target) {
                p++;
            } else if (sum > target) {
                q--;
            } else {
                return new int[] {p, q};
            }
        }
        return new int[] {-1};
    }
}
