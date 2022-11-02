package JavaFiddle;

public class AllocateMinimumNumberOfPages {
    public static int getMaxPages(int[] books, int students, int n){
        int start = 0, end = 0, mid = 0, maxPages = 0;
        for(int pages: books) end += pages;
        while(start < end){
            mid = (start + end)/2;
            if(isValid(books, mid, students, n)){
                maxPages = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return maxPages;
    }

    private static boolean isValid(int[] books, int target, int students, int n){
        int partitions = 1, pages = 0;
        for(int i = 0; i < n; i++){
            pages += books[i];
            if(pages > target) {
                partitions++;
                pages = books[i];
                if (partitions > students) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int testBook[] = {10, 20, 30, 40}, students = 2, n = testBook.length;
        System.out.println(getMaxPages(testBook, students, n));
    }
}
