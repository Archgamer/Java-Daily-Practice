import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        Arrays.sort(candidates); 
        
        backtrack(candidates, target, 0, path, res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start, List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 如果当前数字已经大于剩余目标值，由于数组已排序，后面的数字肯定也大，直接 break
            if (remain < candidates[i]) break;

            // --- 修改 3：树层去重（防止结果集重复） ---
            // i > start 说明我们不是在处理当前层的第一个分叉
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; 
            }

            path.add(candidates[i]);

            backtrack(candidates, remain - candidates[i], i + 1, path, res);

            path.remove(path.size() - 1);
        }
    }
}