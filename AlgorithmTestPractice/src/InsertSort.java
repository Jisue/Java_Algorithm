public class InsertSort {
    // 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입한다.
    // 선택 정렬보다 효율적임
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7,5,9,0,3,1,6,2,4,8};

        for(int i = 0; i < n;  i++) {
            for(int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    break;
                }
            }
        }
        for(int i = 0; i < n;  i++) {
            System.out.println(arr[i]);
        }
    }
}
