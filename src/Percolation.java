import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class Percolation
{
  private boolean[][] grid;
  private int numOfOpenSites;
  private int n;

  public Percolation(int n)
  {
    if (n <= 0)
    {
      throw new IllegalArgumentException("The grid size must be greater than 0");
    }
    this.n = n;
    this.grid = new boolean[n][n];
    this.numOfOpenSites = 0;
  }

  public void open(int row, int col)
  {
    if (row > n || row < 1 || col > 1 || col < 1)
    {
      throw new IllegalArgumentException(String.format("Row and column numbers must be in range:[1,%s]", n));
    }

    if (!isOpen(row, col))
    {
      grid[row-1][col-1] = true;
      numOfOpenSites++;
    }
  }

  public boolean isOpen(int row, int col)
  {
    if (row > n || row < 1 || col > 1 || col < 1)
    {
      throw new IllegalArgumentException(String.format("Row and column numbers must be in range:[1,%s]", n));
    }
    return grid[row-1][col-1];
  }

  public boolean isFull(int row, int col)
  {
    if (row > n || row < 1 || col > 1 || col < 1)
    {
      throw new IllegalArgumentException(String.format("Row and column numbers must be in range:[1,%s]", n));
    }
    //TODO: impement this
    return false;
  }

  public int numberOfOpenSites()
  {
    return numOfOpenSites;
  }

  public boolean percolates()
  {
    //TODO: implement this
    return false;
  }
}
