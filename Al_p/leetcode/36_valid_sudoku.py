import collections
from typing import List


class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        def validate_row(i):
            arr = ["0" for _ in range(10)]

            for j in range(9):
                elem = board[i][j]
                if elem == '.':
                    continue
                if arr[int(elem)] == elem:
                    return False
                arr[int(elem)] = elem

            return True

        def validate_col(j):
            arr = ["0" for _ in range(10)]

            for i in range(9):
                elem = board[i][j]
                if elem == '.':
                    continue
                if arr[int(elem)] == elem:
                    return False
                arr[int(elem)] = elem

            return True

        def validate_cell(row, col):
            arr = ["0" for _ in range(10)]

            for i in range(row, row + 3):
                for j in range(col, col + 3):
                    elem = board[i][j]
                    if elem == '.':
                        continue
                    if arr[int(elem)] == elem:
                        return False
                    arr[int(elem)] = elem

            return True

        for row in range(9):
            if not validate_row(row):
                return False

        for col in range(9):
            if not validate_col(col):
                return False

        cells = [(0, 0), (0, 3), (0, 6), (3, 0), (3, 3), (3, 6), (6, 0), (6, 3), (6, 6)]
        for cell in cells:
            if not validate_cell(cell[0], cell[1]):
                return False

        return True


#######################################################################################


class Solution2:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Create dictionaries to keep track of numbers in rows, columns, and sub-boxes
        rows = collections.defaultdict(set)
        columns = collections.defaultdict(set)
        sub_boxes = collections.defaultdict(set)

        # Iterate through each cell in the 9x9 Sudoku board
        for row in range(9):
            for col in range(9):
                num = board[row][col]

                # Skip empty cells represented by "."
                if num == ".":
                    continue

                # Check if the current number violates Sudoku rules
                if (num in rows[row] or
                        num in columns[col] or
                        num in sub_boxes[(row // 3, col // 3)]):
                    return False

                # Update sets to keep track of encountered numbers
                rows[row].add(num)
                columns[col].add(num)
                sub_boxes[(row // 3, col // 3)].add(num)

        # If all cells satisfy Sudoku rules, the board is valid
        return True


valid_board = board = [["5", "3", ".", ".", "7", ".", ".", ".", "."],
                       ["6", ".", ".", "1", "9", "5", ".", ".", "."],
                       [".", "9", "8", ".", ".", ".", ".", "6", "."],
                       ["8", ".", ".", ".", "6", ".", ".", ".", "3"],
                       ["4", ".", ".", "8", ".", "3", ".", ".", "1"],
                       ["7", ".", ".", ".", "2", ".", ".", ".", "6"],
                       [".", "6", ".", ".", ".", ".", "2", "8", "."],
                       [".", ".", ".", "4", "1", "9", ".", ".", "5"],
                       [".", ".", ".", ".", "8", ".", ".", "7", "9"]]

invalid_board = [[".", ".", ".", "9", ".", ".", ".", ".", "."],
                 [".", ".", ".", ".", ".", ".", ".", ".", "."],
                 [".", ".", "3", ".", ".", ".", ".", ".", "1"],
                 [".", ".", ".", ".", ".", ".", ".", ".", "."],
                 ["1", ".", ".", ".", ".", ".", "3", ".", "."],
                 [".", ".", ".", ".", "2", ".", "6", ".", "."],
                 [".", "9", ".", ".", ".", ".", ".", "7", "."],
                 [".", ".", ".", ".", ".", ".", ".", ".", "."],
                 ["8", ".", ".", "8", ".", ".", ".", ".", "."]]

s = Solution2()
print(s.isValidSudoku(valid_board))
# print(s.isValidSudoku(invalid_board))
