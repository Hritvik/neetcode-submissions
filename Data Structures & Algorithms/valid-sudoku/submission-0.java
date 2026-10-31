class Solution {
    Map<Integer, Set<Integer>> rows;
    Map<Integer, Set<Integer>> columns;
    Map<String, Set<Integer>> subGrids;
    public boolean isValidSudoku(char[][] board) {
        rows = new HashMap<>();
        columns = new HashMap<>();
        subGrids = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    boolean flag = check(i, j, Integer.valueOf(board[i][j]));
                    if (!flag) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean check(int i, int j, int v) {
        boolean a = rows.computeIfAbsent(i, k -> new HashSet<>()).add(v);
        boolean b = columns.computeIfAbsent(j, k -> new HashSet<>()).add(v);
        boolean c = putInSubGrid(i, j, v);

        return a && b && c;
    }
    boolean putInSubGrid(int i, int j, int v) {
        if (i < 3 && j < 3) {
            boolean a = subGrids.computeIfAbsent("ul", k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i < 3 && j >= 3 && j < 6) {
            boolean a = subGrids.computeIfAbsent("cl", k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i < 3 && j >= 6) {
            boolean a = subGrids.computeIfAbsent("bl",k ->  new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 3 && i < 6 && j < 3) {
            boolean a = subGrids.computeIfAbsent("cu", k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 3 && i < 6 && j >= 3 && j < 6) {
            boolean a = subGrids.computeIfAbsent("cc", k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 3 && i < 6 && j >= 6) {
            boolean a = subGrids.computeIfAbsent("cb", k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 6 && j < 3) {
            boolean a = subGrids.computeIfAbsent("ru",k ->  new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 6 && j >= 3 && j < 6) {
            boolean a = subGrids.computeIfAbsent("rc",k ->  new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        } else if (i >= 6 && j >= 6) {
            boolean a = subGrids.computeIfAbsent("rb",k -> new HashSet<>()).add(v);
            if (!a) {
                return a;
            }
        }
        return true;
    }
    
}
