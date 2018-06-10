import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats
{
  private double[] results;
  private int n;
  private int trials;

  public PercolationStats(int n, int trials)
  {
    if(n <= 0 || trials <= 0)
    {
      throw new IllegalArgumentException();
    }
    this.results = new double[trials];
    this.n = n;
    this.trials = trials;

    for (int i = 0; i < trials; i++)
    {
      Percolation percolation = new Percolation(n);
      while(!percolation.percolates())
      {
        percolation.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
      }
      double percolationThreshold = percolation.numberOfOpenSites() / (n * n);
      results[i] = percolationThreshold;
    }
  }

  public double mean()
  {
    return StdStats.mean(results);
  }

  public double stddev()
  {
    return StdStats.stddev(results);
  }

  public double confidenceLo()
  {
    return mean() - 1.96 * stddev() / Math.sqrt(trials);
  }

  public double confidenceHi()
  {
    return mean() + 1.96 * stddev() / Math.sqrt(trials);
  }

  public static void main(String[] args)
  {
    int n = Integer.parseInt(args[0]);
    int t = Integer.parseInt(args[1]);

    PercolationStats stats = new PercolationStats(n, t);
    System.out.println(String.format("mean \t= %s", stats.mean()));
    System.out.println(String.format("stddev \t= %s", stats.stddev()));
    System.out
        .println(String.format("95%% confidence interval \t= [%s,%s]", stats.confidenceLo(), stats.confidenceHi()));
  }
}
