public class SortExs {
    public static int[] arr;
    public static int N;
    public static void main(String[] args) {
        arr = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        N = 10;
        quickSort(0,N-1);

        for(int i = 0; i< N;i++) {
            System.out.println(arr[i]);
        }
    }
    public static void quickSort(int start, int end) {
        // 원소가 1개면 종료
        if(start >= end) {
            return;
        }
        // 첫번째 인수를 피봇으로 설정
        int pivot = start;
        int left = start+1;
        int right = end;

        // 위치가 엇갈리지 않을 때까지 정렬
        while(true) {
            // 피벗보다 큰 데이터를 찾을때까지 반복
            while(left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            while(right > start && arr[right] > arr[pivot]) {
                right--;
            }
            int temp;
            // 엇갈린 상황!!
            if(left > right) {
                // 가장 작은 값과 피봇을 변경해줌
                temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
                break;
            } else {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        quickSort(start,right - 1);
        quickSort(right + 1,end);
    }
}
