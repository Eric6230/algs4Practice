import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class ThreeSumFast
{
    public static int count(int[] a)
    {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for ( int i = 0; i < N; ++ i)
            for (int j = i + 1; j < N; ++j)
               if(BinarySearch.rank(-a[i]-a[j],a) > j)
                  ++cnt;
        return cnt;
    }
    
    public static void main(String[] args)
    {
        int size = 100000;
        int[] a = new int[size];
        int N = a.length;
        int MAX = 10000;
        for(int i = 0; i < N; ++i)
            a[i] = StdRandom.uniform(-MAX,MAX);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSumFast.count(a);
        double time = timer.elapsedTime();
        StdOut.printf("cnt: %7d  time:  %5.1f\n", cnt, time);
    }
}
                                         
                                