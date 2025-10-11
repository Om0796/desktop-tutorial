public class NQueen
{
// Print the solution board
static void printBoard(int[][] board, int n)
 {
for (int i = 0; i < n; i++)
 {
for (int j = 0; j < n; j++)
 {
System.out.print(board[i][j] + " ");
 }
System.out.println();
 }
System.out.println();
 }
// Check if placing queen at board[row][col] is safe
static boolean isSafe(int[][] board, int row, int col, int n)
 {
// Check column
for (int i = 0; i < row; i++)
 {
if (board[i][col] == 1)
return false;
 }
// Check upper-left diagonal
for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
 {
if (board[i][j] == 1)
return false;
 }
// Check upper-right diagonal
for (int i = row, j = col; i >= 0 && j < n; i--, j++)
 {
if (board[i][j] == 1)
return false;
 }
return true;
 }
// Recursive backtracking function
static boolean solveNQ(int[][] board, int row, int n)
 {
if (row == n)
 {
printBoard(board, n); // print one solution
return true;
 }
boolean res = false;
for (int col = 0; col < n; col++)
 {
if (isSafe(board, row, col, n))
 {
board[row][col] = 1; // place queen
res = solveNQ(board, row + 1, n) || res;
1
board[row][col] = 0; // backtrack
 }
 }
return res;
 }
public static void main(String[] args)
 {
int n = 4; // Change this for different board sizes
int[][] board = new int[n][n];
if (!solveNQ(board, 0, n))
 {
System.out.println("No solution exists");
 }
 }
}