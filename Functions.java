import java.lang.Math.*;
public class Functions {

	/* Iterative mergesort function to sor
	t arr[0...n-1] */
	static void mergeSort(int arr[], int n)
	{
		
		// For current size of subarrays to
		// be merged curr_size varies from
		// 1 to n/2
		int curr_size;
					
		// For picking starting index of
		// left subarray to be merged
		int left_start;
						
		
		// Merge subarrays in bottom up
		// manner. First merge subarrays
		// of size 1 to create sorted
		// subarrays of size 2, then merge
		// subarrays of size 2 to create
		// sorted subarrays of size 4, and
		// so on.
		for (curr_size = 1; curr_size <= n-1;
					curr_size = 2*curr_size)
		{
			
			// Pick starting point of different
			// subarrays of current size
			for (left_start = 0; left_start < n-1;
						left_start += 2*curr_size)
			{
				// Find ending point of left
				// subarray. mid+1 is starting
				// point of right
				int mid = Math.min(left_start + curr_size - 1, n-1);
		
				int right_end = Math.min(left_start
							+ 2*curr_size - 1, n-1);
		
				// Merge Subarrays arr[left_start...mid]
				// & arr[mid+1...right_end]
				merge(arr, left_start, mid, right_end);
			}
		}
	}
	
	/* Function to merge the two haves arr[l..m] and
	arr[m+1..r] of array arr[] */
	static void merge(int arr[], int l, int m, int r)
	{
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;
	
		/* create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];
	
		/* Copy data to temp arrays L[]
		and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1+ j];
	
		/* Merge the temp arrays back into
		arr[l..r]*/
		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}
	
		/* Copy the remaining elements of
		L[], if there are any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}
	
		/* Copy the remaining elements of
		R[], if there are any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	/* Function to print an array */
	static void printArray(int A[], int size)
	{
		int i;
		for (i=0; i < size; i++)
			System.out.printf("%d ", A[i]);
		System.out.printf("\n");
	}
	
// This code is contributed by Smitha

	
    static void insertionSort(int arr[], int n)
    {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;

            /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;  
        for(int i=0; i < n; i++){  
                for(int j=1; j < (n-i); j++){  
                        if(arr[j-1] > arr[j]){  
                                //swap elements  
                                temp = arr[j-1];  
                                arr[j-1] = arr[j];  
                                arr[j] = temp;  
                }       
            }  
        }  
    }


	static void selectionSort(int arr[])
	{
		int n = arr.length;
	
		// One by one move boundary of unsorted subarray
		for (int i = 0; i < n-1; i++)
		{
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i+1; j < n; j++)
				if (arr[j] < arr[min_idx])
					min_idx = j;
	
			// Swap the found minimum element with the first
			// element
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

    static void printMatrix(int M[][],int rowSize, int colSize)
	{
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < colSize; j++)
				System.out.print(M[i][j] + " ");

			System.out.println();
		}
	}

	// Function to multiply
	// two matrices A[][] and B[][]
	static void multiplyMatrix(int row1, int col1, int A[][],
		                        int row2, int col2, int B[][])
	{
		int i, j, k, flag = 0;

		// Print the matrices A and B
		// System.out.println("\nMatrix A:");
		// printMatrix(A, row1, col1);
		// System.out.println("\nMatrix B:");
		// printMatrix(B, row2, col2);

		// Check if multiplication is Possible
		if (row2 != col1) {

			System.out.println(
				"\nMultiplication Not Possible");
			return;
		}

		// Matrix to store the result
		// The product matrix will
		// be of size row1 x col2
		int C[][] = new int[row1][col2];

		// Multiply the two matrices
		for (i = 0; i < row1; i++) {
			for (j = 0; j < col2; j++) {
				for (k = 0; k < row2; k++){
					flag = 1;
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		// Print the result
		if(flag == 1){
			System.out.println("\nResultant Matrix:");
			printMatrix(C, row1, col2);
		}
		else{
			System.out.println("\nUnsuccesful");
		}
	}

	static void transpose(int A[][], int N)
    {
       for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
    }

	static void rotatematrix(int m,
                    int n, int mat[][], int R, int C)
    {
        int row = 0, col = 0;
        int prev, curr;
 
        /*
        row - Starting row index
        m - ending row index
        col - starting column index
        n - ending column index
        i - iterator
        */
        while (row < m && col < n)
        {
     
            if (row + 1 == m || col + 1 == n)
                break;
     
            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];
     
            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < n; i++)
            {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;
     
            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < m; i++)
            {
                curr = mat[i][n-1];
                mat[i][n-1] = prev;
                prev = curr;
            }
            n--;
     
            // Move elements of last row
            // from the remaining rows
            if (row < m)
            {
                for (int i = n-1; i >= col; i--)
                {
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;
     
            // Move elements of first column
            // from the remaining rows
            if (col < n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
 
		// Print rotated matrix
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			System.out.print( mat[i][j] + " ");
			System.out.print("\n");
		}
    }

	static void zigZagMatrix(int arr[][], int n, int m) {
		int row = 0, col = 0;
		
		// Boolean variable that will true if we
		// need to increment 'row' value otherwise
		// false- if increment 'col' value
		boolean row_inc = false;
		
		// Print matrix of lower half zig-zag pattern
		int mn = Math.min(m, n);
		for (int len = 1; len <= mn; ++len) {
			for (int i = 0; i < len; ++i) {
			System.out.print(arr[row][col] + " ");
		
			if (i + 1 == len)
				break;
			// If row_increment value is true
			// increment row and decrement col
			// else decrement row and increment
			// col
			if (row_inc) {
				++row;
				--col;
			} 
			else {
				--row;
				++col;
			}
			}
		
			if (len == mn)
			break;
		
			// Update row or col value according
			// to the last increment
			if (row_inc) {
			++row;
			row_inc = false;
			} 
			else {
			++col;
			row_inc = true;
			}
		}
		
		// Update the indexes of row and col variable
		if (row == 0) {
			if (col == m - 1)
			++row;
			else
			++col;
			row_inc = true;
		} else {
			if (row == n - 1)
			++col;
			else
			++row;
			row_inc = false;
		}
		
		// Print the next half zig-zag pattern
		int MAX = Math.max(m, n) - 1;
		for (int len, diag = MAX; diag > 0; --diag) {
		
			if (diag > mn)
			len = mn;
			else
			len = diag;
		
			for (int i = 0; i < len; ++i) {
			System.out.print(arr[row][col] + " ");
		
			if (i + 1 == len)
				break;
		
			// Update row or col value according
			// to the last increment
			if (row_inc) {
				++row;
				--col;
			} else {
				++col;
				--row;
			}
			}
		
			// Update the indexes of row and col variable
			if (row == 0 || col == m - 1) {
			if (col == m - 1)
				++row;
			else
				++col;
		
			row_inc = true;
			}
		
			else if (col == 0 || row == n - 1) {
			if (row == n - 1)
				++col;
			else
				++row;
		
			row_inc = false;
			}
		}
	}
}

// This code is contributed by Smitha
