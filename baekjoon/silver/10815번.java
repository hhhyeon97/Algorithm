
// https://www.acmicpc.net/problem/10815
// 숫자 카드

// before : 316732KB	2276ms

// 상근이가 특정 숫자를 가지고 있는지 빠르게 확인하려면 ?
// ㄴ> 이분 탐색 (Binary Search) 활용 
/*
 * 상근이가 가진 카드(arr)의 개수가 최대 500,000개일 수 있기 때문에,
 * 모든 숫자 카드에 대해 하나씩 비교하는 방식(브루트포스)은 비효율적
 * 대신 이분 탐색을 사용하면 효율적으로 숫자가 있는지 확인할 수 있다.

1. 상근이가 가진 숫자 카드 배열 arr을 정렬한다.
2. arr2의 각 숫자에 대해 arr 배열에서 이분 탐색을 진행하여 숫자가 존재하는지 확인한다.
 */
import java.util.*;

public class 10815번 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 상근이가 가진 숫자 카드의 개수 N
        int N = sc.nextInt();
        int[] arr = new int[N];

        // 상근이의 카드 배열 입력
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 이분 탐색하려면 정렬되어 있어야 함 !! 
        // 숫자 카드 배열을 정렬
        Arrays.sort(arr);

        // 확인해야 할 숫자의 개수 M
        int M = sc.nextInt();
        int[] arr2 = new int[M];

        // 확인해야 할 숫자 입력
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // arr2의 각 숫자에 대해 이분 탐색으로 존재 여부 확인
        StringBuilder sb = new StringBuilder();
        for (int num : arr2) {
            // 이분 탐색을 통해 숫자가 있는지 확인
            if (binarySearch(arr, num)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());

        sc.close();
    }    

     // 이분 탐색 메서드
     public static boolean binarySearch(int[] arr, int key) {
        int low = 0; //인덱스 : 배열의 요소는 0부터 시작
        int high = arr.length - 1; //인덱스 : 배열의 요소는 0부터 시작하므로 N-1을 해준다.

        while (low <= high) { //left가 rigth보다 큰 경우는 이진 탐색 규칙에 어긋나므로 반복문 돌리지 X
            int mid = (low + high) / 2; //중간 인덱스는 왼쪽 오른쪽의 더한 값에 나누기 2

            if (arr[mid] == key) { //중간 인덱스에 해당되는 값 => 이 값으로 비교한다.
                return true; // key를 찾음
            } else if (arr[mid] < key) {
                low = mid + 1; // key가 더 큰 경우, 오른쪽 탐색
            } else {
                high = mid - 1; // key가 더 작은 경우, 왼쪽 탐색
            }
        }

        return false; // key를 찾지 못함
    }
}

/*
 * 입력 받기:

arr: 상근이가 가진 숫자 카드 배열.
arr2: 확인해야 할 숫자 배열.
정렬:

Arrays.sort(arr)로 arr 배열을 정렬해서 이분 탐색이 가능하도록 한다.
이분 탐색:

binarySearch 함수에서 이분 탐색을 사용해 arr에 num이 존재하는지 확인한다.
숫자가 존재하면 1, 존재하지 않으면 0을 결과에 저장.
결과 출력:

StringBuilder를 사용해서 결과를 효율적으로 문자열로 연결한 후, 최종적으로 출력한다.
시간 복잡도:
정렬: O(N log N)
이분 탐색: 각 숫자에 대해 O(log N) (총 M개의 숫자에 대해 이분 탐색하므로 O(M log N))
따라서 전체 시간 복잡도는 O(N log N + M log N)이 된다.
 */
//=============================================================
/*
 * Scanner 대신 BufferedReader와 BufferedWriter를 사용하면 
 * 입출력 속도를 향상시킬 수 있음
 * 특히 입력과 출력이 많을 때는 BufferedReader가 효율적 !
 */

// after : 105620KB	 1192ms

// import java.io.*;
// import java.util.*;

// public class Main {
//     public static void main(String[] args) throws IOException {
//         // BufferedReader와 BufferedWriter 선언
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
//         // 상근이가 가진 숫자 카드의 개수 N
//         int N = Integer.parseInt(br.readLine());
//         int[] arr = new int[N];

//         // 상근이의 카드 배열 입력 (한 줄로 입력을 받음)
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < N; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         // 숫자 카드 배열을 정렬
//         Arrays.sort(arr);

//         // 확인해야 할 숫자의 개수 M
//         int M = Integer.parseInt(br.readLine());
        
//         // 확인해야 할 숫자 입력 (한 줄로 입력을 받음)
//         st = new StringTokenizer(br.readLine());
        
//         // arr2의 각 숫자에 대해 이분 탐색으로 존재 여부 확인
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < M; i++) {
//             int num = Integer.parseInt(st.nextToken());
            
//             // 이분 탐색을 통해 숫자가 있는지 확인
//             if (binarySearch(arr, num)) {
//                 sb.append(1).append(" ");
//             } else {
//                 sb.append(0).append(" ");
//             }
//         }

//         // 결과를 BufferedWriter로 출력
//         bw.write(sb.toString());
//         bw.flush();  // BufferedWriter를 닫기 전에 flush로 출력 강제
//         bw.close();
//         br.close();
//     }

//     // 이분 탐색 메서드
//     public static boolean binarySearch(int[] arr, int key) {
//         int low = 0;
//         int high = arr.length - 1;

//         while (low <= high) {
//             int mid = (low + high) / 2;

//             if (arr[mid] == key) {
//                 return true; // key를 찾음
//             } else if (arr[mid] < key) {
//                 low = mid + 1; // key가 더 큰 경우, 오른쪽 탐색
//             } else {
//                 high = mid - 1; // key가 더 작은 경우, 왼쪽 탐색
//             }
//         }

//         return false; // key를 찾지 못함
//     }
// }