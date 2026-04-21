class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort to handle duplicates
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] candidates, int index, int remaining, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (remaining < 0 || index == candidates.length) return;

        for (int i = index; i < candidates.length; i++) {
            // Skip duplicates at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) continue;

            // Prune: no point going further if current candidate already exceeds remaining
            if (candidates[i] > remaining) break;

            current.add(candidates[i]);
            backtrack(candidates, i + 1, remaining - candidates[i], current, result); // i+1: each element used once
            current.remove(current.size() - 1);
        }
    }
}
