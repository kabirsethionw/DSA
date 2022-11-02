package JavaFiddle;

import java.io.*;
import java.util.*;
class GoodStrings {
    static int MAXN = 100000;
    static int MAXK = 20;
    static int MOD = 1000000007;
    static int[][] dp = new int[MAXN+1][MAXK+1];

    public static void main(String args[] ) throws Exception {
        FasterIO fio = new FasterIO();
        int t,n,k,diff;
        String str;
        t = fio.nextInt();
        while(t-- != 0) {
            n = fio.nextInt();
            k = fio.nextInt();
            str = fio.readLine();
            for(int i=0;i<=n;i++) {
                for(int j =0;j<=k;j++){
                    dp[i][j] = 0;
                }
            }
            dp[0][0]=1;
            for(int i=0;i<n;i++) {
                diff = str.charAt(i) - 'a';
                dp[i][0] =1;
                for(int j =0;j<k;j++){
                    if(j!=0)
                        diff = 25;
                    dp[i+1][j+1] += ((dp[i][j] * (long)diff)%MOD + dp[i][j+1])%MOD;
                    System.out.println(dp[i+1][j+1]+" "+dp[i][j] * diff);
                }
            }
            fio.print(dp[n][k]);
            fio.println();
        }
        fio.close();
    }
    static class FasterIO implements AutoCloseable {
        final private int BUFFER_SIZE = 1 << 16;
        private BufferedReader in;
        private BufferedWriter out;
        private byte[] temp = new byte[20];
        private int tempPtr;

        public FasterIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public FasterIO(String inputFileName) throws IOException {
            in = new BufferedReader(new FileReader(inputFileName));
            out = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public String readLine() throws IOException {
            return in.readLine();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private byte read() throws IOException {
            return (byte) in.read();
        }

        public void print(long i) throws IOException {
            if(i==0) {
                out.write('0');
                return;
            }
            if(i < 0){
                out.write('-');
                i = -i;
            }
            tempPtr = temp.length;
            while (i!=0){
                temp[--tempPtr] = (byte)((i%10) + '0');
                i/=10;
            }
            while (tempPtr < temp.length)
                out.write(temp[tempPtr++]);
        }
        public void print(int i) throws IOException {
            if(i==0) {
                out.write('0');
                return;
            }
            if(i < 0){
                out.write('-');
                i = -i;
            }
            tempPtr = temp.length;
            while (i!=0){
                temp[--tempPtr] = (byte)((i%10) + '0');
                i/=10;
            }
            while (tempPtr < temp.length)
                out.write(temp[tempPtr++]);
        }

        public void print(double d) throws IOException {
            print(String.valueOf(d));
        }

        public void print(String s) throws IOException {
            out.write(s,0,s.length());
        }

        public void printSpace() throws IOException {
            out.write(' ');
        }

        public void println() throws IOException {
            out.newLine();
        }

        public void close() throws IOException {
            if (in != null)
                in.close();
            if(out != null) {
                out.flush();
                out.close();
            }
        }
    }
}