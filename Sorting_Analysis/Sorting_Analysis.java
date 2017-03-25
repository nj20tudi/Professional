import java.util.Random;
import java.util.Scanner; 
import java.util.Arrays;
/**
 * Write a description of class Sorting_Analysis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sorting_Analysis
{
    public int bs[];
    public int ss[];
    public int is[];
    public int ms[];
    public int qs[];
    public int testSize[] = {2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288};  
    public double timeResultsBubble[];
    public double timeResultsSelection[];
    public double timeResultsInsertion[];
    public double timeResultsMerge[];
    public double timeResultsQuick[];
    public static void main(String args[]){
        double bubbleTot = 0;
        double selTot = 0;
        double insTot = 0;
        double mergeTot = 0;
        double quickTot = 0;

        Scanner in = new Scanner(System.in);  
        System.out.print("Number of Trials: ");
        int trials = in.nextInt();
        System.out.print("Choose Array Type ( 1 for sorted, 2 for nearly sorted, 3 for completely random, 4 for reverse sorted): "); 
        int type = in.nextInt();
        Sorting_Analysis s = new Sorting_Analysis();
        s.timeResultsBubble = new double[trials];
        s.timeResultsSelection = new double[trials];
        s.timeResultsInsertion = new double[trials];
        s.timeResultsMerge = new double[trials];
        s.timeResultsQuick = new double[trials];
        double start = 0;
        double end = 0;
        double elapsed = 0;
        String method = "";
        int size = 0;

        for(int t = 0; t < s.testSize.length; t++){
            size = s.testSize[t];

            for(int j = 0; j < trials; j++){

                if(type == 1){
                    s.ascending(size);
                    method = "sorted";
                }
                else if(type == 2){
                    s.ascendingPartial(size);
                    method = "nearly sorted";
                }
                else if(type == 3){
                    s.random(0, Integer.MAX_VALUE - 1, size);
                    method = "completely random";
                }   
                else if(type == 4){
                    s.descending(size);
                    method = "reverse sorted";
                }

                start = System.nanoTime();
                s.bubbleSort(s.bs);
                end = System.nanoTime();
                elapsed = (end - start)/1000000;
                s.timeResultsBubble[j] = elapsed;

                if(type == 1){
                    s.ascending(size);
                    method = "sorted";
                }
                else if(type == 2){
                    s.ascendingPartial(size);
                    method = "nearly sorted";
                }
                else if(type == 3){
                    s.random(0, Integer.MAX_VALUE - 1, size);
                    method = "completely random";
                }   
                else if(type == 4){
                    s.descending(size);
                    method = "reverse sorted";
                }

                start = System.nanoTime();
                s.selectionSort(s.ss);
                end = System.nanoTime();
                elapsed = (end - start)/1000000;
                s.timeResultsSelection[j] = elapsed;

                if(type == 1){
                    s.ascending(size);
                    method = "sorted";
                }
                else if(type == 2){
                    s.ascendingPartial(size);
                    method = "nearly sorted";
                }
                else if(type == 3){
                    s.random(0, Integer.MAX_VALUE - 1, size);
                    method = "completely random";
                }   
                else if(type == 4){
                    s.descending(size);
                    method = "reverse sorted";
                }

                if(type == 1){
                    s.ascending(size);
                    method = "sorted";
                }
                else if(type == 2){
                    s.ascendingPartial(size);
                    method = "nearly sorted";
                }
                else if(type == 3){
                    s.random(0, Integer.MAX_VALUE - 1, size);
                    method = "completely random";
                }   
                else if(type == 4){
                    s.descending(size);
                    method = "reverse sorted";
                }

                start = System.nanoTime();
                s.insertionSort(s.is);
                end = System.nanoTime();
                elapsed = (end - start)/1000000;
                s.timeResultsInsertion[j] = elapsed;

                start = System.nanoTime();
                s.mergeSort(s.ms);
                end = System.nanoTime();
                elapsed = (end - start)/1000000;
                s.timeResultsMerge[j] = elapsed;

                if(type == 1){
                    s.ascending(size);
                    method = "sorted";
                }
                else if(type == 2){
                    s.ascendingPartial(size);
                    method = "nearly sorted";
                }
                else if(type == 3){
                    s.random(0, Integer.MAX_VALUE - 1, size);
                    method = "completely random";
                }   
                else if(type == 4){
                    s.descending(size);
                    method = "reverse sorted";
                }

                start = System.nanoTime();
                s.quickSort1(s.qs, 0, s.qs.length-1);
                end = System.nanoTime();
                elapsed = (end - start)/1000000;
                s.timeResultsQuick[j] = elapsed;

            }
            for(int i = 0; i < trials; i++){
                bubbleTot = bubbleTot + s.timeResultsBubble[i];
                selTot = selTot + s.timeResultsSelection[i];
                insTot = insTot + s.timeResultsInsertion[i];
                mergeTot = mergeTot + s.timeResultsMerge[i];
                quickTot = quickTot + s.timeResultsQuick[i];
            }
            double bubAvg = bubbleTot/trials;
            double selAvg = selTot/trials;
            double insAvg = insTot/trials;
            double mergeAvg = mergeTot/trials;
            double quickAvg = quickTot/trials;

            System.out.println(size + " bubble " + method + " " + bubAvg + "ms");
            System.out.println(size + " selection " + method + " " + selAvg + "ms");
            System.out.println(size + " insertion " + method + " " + insAvg + "ms");
            System.out.println(size + " merge " + method + " " + mergeAvg + "ms");
            System.out.println(size + " quick " + method + " " + quickAvg + "ms");
            System.out.println();
        }
    }

    public void random(int min, int max, int n)
    {
        int[] randArr = new int[n];
        int t = 0;
        randArr[n-1] = min-1;
        while(randArr[n-1] == min-1){
            Random rand = new Random();
            int randomNum = rand.nextInt((max - min) + 1) + min;
            randArr[t] = randomNum;
            t++;
        }
        bs = randArr;
        ss = randArr;
        is = randArr;
        ms = randArr;
        qs = randArr;
    }

    public void ascending(int n){
        int asc[] = new int[n];
        for(int i = 0; i < n; i++){
            asc[i] = i+1;
        }
        bs = asc;
        ss = asc;
        is = asc;
        ms = asc;
        qs = asc;
    }

    public void descending(int n){
        int desc[] = new int[n];
        for(int i = 0; i < n; i++){
            desc[i] = n-i;
        }
        bs = desc;
        ss = desc;
        is = desc;
        ms = desc;
        qs = desc;
    }

    public void ascendingPartial(int n){
        int asc[] = new int[n];
        for(int i = 0; i < n; i++){
            asc[i] = i+1;
        }
        Random rand = new Random();
        for(int i = 0; i < n/4; i++){
            int r = rand.nextInt((n - 2) + 1) + 1;
            int s = rand.nextInt((n - 2) + 1) + 1;
            int temp = asc[r];
            asc[r] = asc[s];
            asc[s] = temp;
        }
        bs = asc;
        ss = asc;
        is = asc;
        ms = asc;
        qs = asc;
    }

    public void bubbleSort(int bubble[]){
        for(int i = 0; i < bubble.length-1; i++){
            for(int j = 0; j < bubble.length - 1 - i; j++){
                if(bubble[j+1] < bubble[j]){
                    int temp = bubble[j+1];
                    bubble[j+1] = bubble[j];
                    bubble[j] = temp;
                }
            }
        } 
    }

    public void selectionSort(int sel[]){
        for(int i = 0; i < sel.length-1; i++){
            int min = i;
            for(int j = i + 1; j < sel.length; j++){
                if(sel[j] < sel[min]){
                    min = j;
                }
                int temp = sel[i];
                sel[i] = sel[min];
                sel[min] = temp;
            }
        } 
    }

    public void insertionSort(int inser[]){
        for(int i = 0; i < inser.length; i++){
            int v = inser[i];
            int j = i - 1;
            while(j >= 0 && inser[j] > v){
                inser[j+1] = inser[j];
                j--;
            }
            inser[j+1] = v;
        }
    }

    public void mergeSort(int arr[]){
        if(arr.length > 1){
            int[] B = new int[arr.length/2];
            int[] C = new int[arr.length - (arr.length/2)];
            for(int i = 0; i < arr.length; i++){
                if(i < arr.length/2){
                    B[i] = arr[i];
                }
                else{
                    C[i - arr.length/2] = arr[i];
                }
            }
            mergeSort(B);
            mergeSort(C);
            merge(B, C, arr);
        }
    }

    public void merge(int[] B, int[] C, int[] A){
        int count = 0;
        while( (B.length != 0) && (C.length != 0)){
            if(B[0] < C[0]){
                A[count] = B[0];
                int temp[] = new int[B.length - 1];
                if(B.length != 1){
                    for (int i = 0; i < temp.length; i++){
                        temp[i] = B[i+1];
                    }
                }
                B = temp;
                count++;
            }
            else{
                A[count] = C[0];
                int temp[] = new int[C.length - 1];
                if(C.length != 1){
                    for (int i = 0; i < temp.length; i++){
                        temp[i] = C[i+1];
                    }
                }
                C = temp;
                count++;
            }
        }
        if(B.length == 0){
            for(int i = 0; i < C.length; i++){
                A[count] = C[i];
                count++;
            }
        }
        else{
            for(int i = 0; i < B.length; i++){
                A[count] = B[i];
                count++;
            }
        }
    }

    public void quickSort1(int arr[], int left, int right){
        if(left < right){
            int s = partition(arr, left, right);
            quickSort1(arr, left, s-1);
            quickSort1(arr, s+1, right);
        }
    }

    public int partition(int arr[], int left, int right){
        int p = arr[left];
        int i = left;
        int j = right+1;
        boolean leftEqual = false;
        boolean rightEqual = false;
        boolean done = false;
        while(done == false){
            while(leftEqual == false){
                i++;
                if((i == right) || (arr[i] >= p)) leftEqual = true;
            }
            while(rightEqual == false){
                j--;
                if((j == left) || (arr[j] <= p)) rightEqual = true;
            }
            if( i >= j){
                done = true;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                leftEqual = false;
                rightEqual = false;
            }
        }
        int temp = arr[left];
        arr[left] = arr[j];
        arr[j] = temp;
        return j;
    }

}
