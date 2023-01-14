import java.util.Scanner;

import static java.lang.Math.round;

public class GaussPodstawowy {

    public static void algorytm(){int wybor;
        Scanner wyborX = new Scanner(System.in);
        System.out.println("Wprowadz 1 any uzyc gotowych danych , 2 aby wprowadzic wlasne dane");
        wybor=wyborX.nextInt();
        if(wybor==2) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Wprowadz liczbe rownan: ");
        int n = scanner.nextInt();

        double[][] A = new double[n][n];
        double[] b = new double[n];

        System.out.println("Wprowadz wspolczynniki rownan:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Wprowadz wspolczynnik " + (j + 1) + " rowanania " + (i + 1) + ":");
                A[i][j] = scanner.nextDouble();
            }
        }

        System.out.println("Wprowadz wyrazy wolne:");
        for (int i = 0; i < n; i++) {
            System.out.println("Wprowadz wyraz wolny rownania " + (i + 1) + " :");
            b[i] = scanner.nextDouble();
        }

        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double wspolczynnik = A[i][k] / A[k][k];
                b[i] -= wspolczynnik * b[k];
                for (int j = k; j < n; j++) {
                    A[i][j] -= wspolczynnik * A[k][j];
                }
            }
        }

        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * X[j];
            }
            X[i] = (b[i] - sum) / A[i][i];
        }

        System.out.println("Rozwiazaniem ukladu jest wektor x=");
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if(i!=n-1)
                System.out.print(round(X[i])+",");
            else
                System.out.print(round(X[i]));
        }
        System.out.print("]^T");

        scanner.close();
    }
    if(wybor==1)
    {
        int n = 4;

        double[][] A = new double[n][n];
        double[] b = new double[n];

        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=-1;
        A[0][3]=2;

        A[1][0]=1;
        A[1][1]=0;
        A[1][2]=-2;
        A[1][3]=4;

        A[2][0]=0;
        A[2][1]=-3;
        A[2][2]=1.5;
        A[2][3]=7;

        A[3][0]=0;
        A[3][1]=-1;
        A[3][2]=1;
        A[3][3]=6;


        b[0]=0;
        b[1]=4;
        b[2]=0;
        b[3]=-1;


        for (int k = 0; k < n - 1; k++) {
            for (int i = k + 1; i < n; i++) {
                double wspolczynnik = A[i][k] / A[k][k];
                b[i] -= wspolczynnik * b[k];
                for (int j = k; j < n; j++) {
                    A[i][j] -= wspolczynnik * A[k][j];
                }
            }
        }

        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * X[j];
            }
            X[i] = (b[i] - sum) / A[i][i];
        }

        System.out.println("Rozwiazaniem ukladu jest wektor x=");
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if(i!=n-1)
                System.out.print(round(X[i])+",");
            else
                System.out.print(round(X[i]));
        }
        System.out.print("]^T");

    }
    }
}