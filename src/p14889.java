import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;

    static int N;
    static int [][] S;

    static int sumOfSij[];

    static int minGap = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        sumOfSij = new int[N*N];

        String input[];

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        // Sij + Sji 를 sumOfSij에 저장
        int index = 0;
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i - 1; j++){
                sumOfSij[index++] = (S[i][j] + S[j][i]);
            }
        }

        Arrays.sort(sumOfSij);

        for(int i = 0 ; i < sumOfSij.length - 1; i++){
            if(sumOfSij[i] - sumOfSij[i + 1] < minGap){
                minGap = sumOfSij[i] - sumOfSij[i + 1];
            }
        }



        bw.flush();
        br.close();
        bw.close();
    }




}
