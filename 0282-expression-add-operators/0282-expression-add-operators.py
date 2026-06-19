class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        results = []   
        def backtrack(index, current_val, prev_term, path_segments):
            if index == len(num):
                if current_val == target:
                    results.append("".join(path_segments))
                return
            for i in range(index, len(num)):
                if i > index and num[index] == '0':
                    break
                part_str = num[index:i+1]
                part_val = int(part_str)
                if index == 0:
                    path_segments.append(part_str)
                    backtrack(i + 1, part_val, part_val, path_segments)
                    path_segments.pop() 
                else:
                    path_segments.append('+' + part_str)
                    backtrack(i + 1, current_val + part_val, part_val, path_segments)
                    path_segments.pop()
                    path_segments.append('-' + part_str)
                    backtrack(i + 1, current_val - part_val, -part_val, path_segments)
                    path_segments.pop()
                    path_segments.append('*' + part_str)
                    backtrack(
                        i + 1, 
                        current_val - prev_term + (prev_term * part_val), 
                        prev_term * part_val, 
                        path_segments
                    )
                    path_segments.pop()

        backtrack(0, 0, 0, [])
        return results