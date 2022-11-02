package JavaFiddle;

public class RotateMatrix {
    int[][] rotateMatrix(int n, int m, int mat[][]) {
        int l=0,r=m-1,t=0,b=n-1;
        while(l<r&&t<b){
            for(int i=t;i<b;i++) {
                //swap(mat[i][l],mat[i+1][l]);
                int temp=mat[i][l];
                mat[i][l]=mat[i+1][l];
                mat[i+1][l]=temp;
            }
            for(int i=l;i<r;i++) {
                // swap(mat[b][i],mat[b][i+1], mat);
                int temp=mat[b][i];
                mat[b][i]=mat[b][i+1];
                mat[b][i+1]=temp;
            }
            for(int i=b;i>t;i--) {
                //swap(mat[i][r],mat[i-1][r], mat);
                int temp=mat[i][r];
                mat[i][r]=mat[i-1][r];
                mat[i-1][r]=temp;
            }
            for(int i=r;i>l+1;i--){
                //swap(mat[t][i],mat[t][i-1], mat);
                int temp=mat[t][i];
                mat[t][i]=mat[t][i-1];
                mat[t][i-1]=temp;
            }
            l++;t++;b--;r--;
        }
        return mat;
    }
}
