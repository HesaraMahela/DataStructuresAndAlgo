public class bigO {

    // big O = worst case
    // big omega  = best case
    // big theta = average

    static void numbers(int n){// 6c1 + 5c2
        for (int i=0 ; i<5; i++){ // c1
            System.out.println(i);// c2  // out put: 0 to 4
        }

        // (n+1) c1 + nc2
        for (int i=0 ; i<n; i++){ // c1
            System.out.println(i);// c2  // out put: 0 to n-1
        }

        for (int i=0 ; i<5; i++){ // c1  6
            // inside 5
            for (int j=0 ; j<5; j++){ // c2   // 6
                // 5
                System.out.println(i);// c3  // out put: 0 to 4 // 25
            }
        } // (n+1)c1 + n(n+1)c2 + n*n c3
        for (int i=0 ; i<n; i++){ // c1  6
            // inside 5
            for (int j=0 ; j<n; j++){ // c2   // 6
                // 5
                System.out.println(i);// c3  // out put: 0 to 4 // 25
                if(j==1){
                    break;
                }
            }

        }


        // n+1)c1 +nc2(n+1)/2 +c3) (n-1)n/2
        for (int i=0 ; i<n; i++) { // c1  6
            // inside 5
            for (int j = 0; j < i; j++) { // c2   // 6     // 0-1, 1-2, 2-3, 3-4  ''''' n
                // 5
                System.out.println(i);// c3  // out put: 0 to 4 // 25    0-0,1-1.... n-1
                if (j == 1) {
                    break;
                }
            }
        }
    }



    public static void main(String[] args) {
        for (int i=0 ; i<5; i++){ // c1  6
            // inside 5
            for (int j=0 ; j<5; j++){ // c2   // 6
                // 5
                System.out.println(i);// c3  // out put: 0 to 4 // 25
            }
        }
    }
}


