import java.util.Arrays;

public class Assignment2 {

	// Task 1
	public static boolean isSquareMatrix(boolean[][] matrix){
		boolean isSqure = true;
		if (matrix==null){
			//the input is illegal
			isSqure = false;
		}
		else	for (int i=0;i<matrix.length&isSqure;i=i+1){
					if (matrix[i]==null)
					//the input is illegal
						isSqure=false;
					else if (matrix[i].length!=matrix.length)
					//check if every cell in the array has the same length as the whole array
						isSqure=false;
		}
		return isSqure;
	}
	
	// Task 2	
	public static boolean isSymmetricMatrix(boolean[][] matrix){
		boolean isSymetric = true;
		for (int i=0;i<matrix.length;i=i+1){
			for (int j=0;j<matrix.length;j=j+1){
				if(i<j&matrix[i][j]!=matrix[j][i])
					//the condition for a Symetric matrix
					isSymetric = false;
			}
		}
		return isSymetric;	
	}
	
	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
		boolean isAntiReflexive = true;
		for(int i=0;i<matrix.length;i=i+1){
			if(matrix[i][i]==true)
				//the condition for a anti reflexive matrix
				isAntiReflexive = false;
		}
		return isAntiReflexive;
	}
	
	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix){
		boolean isLegal = true;
		isLegal = isSquareMatrix(matrix);
		if(isLegal)
			//if matrix is null this condition is false
			if (!isSymmetricMatrix(matrix)|!isAntiReflexiveMatrix(matrix))
				//if at least one of the conditions is false it is not a legal instance 
				isLegal = false;
		return isLegal;
	}
	
	// Task 5
	public static boolean isPermutation(int[] array){
		boolean isPermutation = true ; 
		//create a new zeroed array with the same length
		int [] counter = new int [array.length];
		for (int i=0;i<counter.length;i=i+1){
			counter [i] = 0;
		}
		//for each value in the original array, find the suitable index in the new array and add +1 for every appearance 
		for(int i=0;i<array.length&isPermutation;i=i+1){
			if(array[i]>=array.length|array[i]<0)
				isPermutation = false;
			else {
					counter[array[i]]=counter[array[i]]+1;
					//check if there is more than 1 appearance 
					if (counter[array[i]]>1)
						isPermutation = false;
			}
		}
		return isPermutation;
	}
	
	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
		boolean hasLegal = true ; 
		for (int i =1; i<tour.length&hasLegal;i=i+1){
			// check if there is a flight from two destinations
			if(flights[tour[i-1]][tour[i]]==false)
				hasLegal=false;
		}
		// check if there is a flight from the last destination to the starting point
		if(tour.length>1&&flights[tour[tour.length-1]][tour[0]]==false)
			hasLegal = false;
		return hasLegal;
	}
	
	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour){
		boolean isSolution = true;
		if (tour==null||tour.length!=flights.length)
			// the input is illegal
			throw new IllegalArgumentException();
		// check if each city appears once and if the route is possible and if the starting point is 0
		if(!isPermutation(tour)||!hasLegalSteps(flights,tour)|tour[0]!=0)
			isSolution = false;
		return isSolution;
	}
	// Task 8
	public static int[][] atLeastOne(int[] vars) {
		int [] [] cnf = new int [1] [vars.length];
			for (int i=0;i<vars.length;i=i+1) {
					cnf[0][i]=vars[i];
		}
		return cnf;
	}
	
		// Task 9
	public static int[][] atMostOne(int[] vars) {
			
			int [][] cnf = new int [0][0];
			//insert in a new array all the possible pairs from vars
			for (int i=0;i<vars.length-1;i=i+1) {
				for (int j = i+1;j<vars.length;j=j+1) {
					int [][] temp = new int [1][2];
					temp[0][0]=-1*vars[i];
					temp[0][1]=-1*vars[j];
					//insert the negative pairs to the return array
					cnf = combineArrays(cnf,temp);
				}
			}
			return cnf;
		}
	
		// Task 10
		public static int[][] exactlyOne(int[] vars) {
			
			int [] [] cnf1 =  atMostOne(vars);
			int [] [] cnf2 = atLeastOne(vars);
			//combine the two arrays
			int [] [] cnf3 = combineArrays(cnf1,cnf2);
			return cnf3;
			
		}
		
	// Task 11
	public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {
		int maxValue=0;
		//search for the max abs value in varSets in order to initialize the SAT Solver correctly		
		for (int i=0;i<varSets.length;i=i+1) {
			for(int j=0;j<varSets[i].length;i=i+1) {
				if(varSets[i][j]<0) {
					if(-1*varSets[i][j]>maxValue) 
						maxValue = -1*varSets[i][j];
				}
				if (varSets[i][j]>maxValue)
					maxValue = varSets[i][j];
			}
		}
		//initialize the SAT Solver
		SATSolver.init(maxValue);
		//turns every cell of varSets into the cnf formula and then to the SAT solver
		for(int i=0;i<varSets.length;i=i+1) {
			int [] [] cnf1=exactlyOne(varSets[i]);
			SATSolver.addClauses(cnf1);
		}
		boolean[] assignment = SATSolver.getSolution();
		if (assignment == null)
			throw new RuntimeException("timeout");
		return assignment;
	}
	
	// Task 12
	public static int[][] createVarsMap(int n) {
		int [] [] map = new int[n][n];
		for(int i=0;i<n;i=i+1)
			for(int j=0;j<n;j=j+1)
				 map[i][j]=i*n+j+1;
		return map;
	}
	
	// Task 13
	public static int[][] oneCityInEachStep(int[][] map) {
		//initialize a two dimensional which will be the cnf formula
		int [] [] cnf = new int [0][0];
		for (int i=0;i<map.length;i=i+1) {
			//for every cell in the map array, create a new array with suitable clause 
			int [] [] combine = exactlyOne(map[i]);
			cnf= combineArrays(cnf,combine);
			}
		return cnf;
	}
	
	// Task 14
	public static int[][] fixSourceCity(int[][] map) {
		int[][] fixSourceCity = {{1}};
		return fixSourceCity;
		}
	
	// Task 15
	public static int[][] eachCityIsVisitedOnce(int[][] map) {
		//initialize a two dimensional array and turns the rows and collums of the input array
		int [] [] oppositeMap = new int [map.length][map.length];
		for(int i=0;i<map.length;i=i+1) {
			for(int j=0;j<map[i].length;j=j+1) {
				oppositeMap[i][j]=map[j][i];
			}
		}
		//make the same process as "oneCityInEachStep" just with the opposite map array
		int [] [] cnf = oneCityInEachStep(oppositeMap);
		return cnf;
	}

	// Task 16
	public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {
		
		int [] [] cnf = new int [0][0];
		for (int j=0;j<flights.length;j=j+1) {
			for (int k=j+1;k<flights.length;k=k+1) {
				//check if there is no flight between two cities
				if(flights[j][k]==false) {
					//add to the cnf formula at most one of the cities is true mean there is no connection between the cities
					for(int i=0;i<map.length-1;i=i+1) {
						int [] [] atMostOne = {{-map[i+1][k],-map[i][j]},{-map[i+1][j],-map[i][k]}};
						cnf = combineArrays(cnf,atMostOne);
						}
					}
				//check if there is no flight from a city to the start, means it can't be the last destination
				if(flights[0][k]==false) {
					int [] [] temp={{-map[map.length-1][k]}};
					cnf = combineArrays(cnf,temp);
				}
			}
		}
		
		return cnf;
	}
	
	// Task 17
	public static void encode(boolean[][] flights, int[][] map) {
		if(flights==null||map==null||!isLegalInstance(flights)|!IsLegalMap(flights,map))
			throw new IllegalArgumentException("illegal input");
		SATSolver.init(map.length*map.length);
		SATSolver.addClauses(oneCityInEachStep(map));
		SATSolver.addClauses(fixSourceCity(map));
		SATSolver.addClauses(eachCityIsVisitedOnce(map));
		SATSolver.addClauses(noIllegalSteps(flights,map));
		
	}
	
	// Task 18
	public static int[] decode(boolean[] assignment, int[][] map) {
		if(assignment.length!=map.length*map.length+1)
			throw new RuntimeException("unsat");
		int [] decode = new int [map.length];
		//check where are the 'true' values in the boolean array
		for (int k=1;k<assignment.length;k=k+1) {
			while(assignment[k]) {
				//when you find the 'true' value find the suitable cell in map 
				for(int i=0;i<map.length&assignment[k];i=i+1) {
					for(int j=0;j<map[i].length&assignment[k];j=j+1) {
						if(map[i][j]==k) {
							//set the correct value in the output array and continue to the next 'true' value
							decode [i]=j;
							assignment[k]=false;
						}
							
					}
				}
			}
		}
		return decode;
	}
	
	// Task 19
	public static int[] solve(boolean[][] flights) {
		//check if flights array is legal
		if(flights==null|| !isLegalInstance(flights))
			throw new IllegalArgumentException("illegal flights array");
		int[]s=new int [0];
		//initialize map 
		int [] [] map = createVarsMap(flights.length);
		//initialize SAT solver
		SATSolver.init(map.length*map.length);
		//add the cnf to the SAT solver
		encode(flights,map);
		//get a solution for the problem
		boolean[] assignment = SATSolver.getSolution();
		//if there is a timeout problem throw exception 
		if(assignment == null)
			throw new IllegalArgumentException("timeout");
		//check if the solution is legal or not
		if (assignment.length==map.length*map.length+1) {
			int [] tour = decode(assignment,map);
			if(isSolution(flights,tour))
				s=tour;	
			else throw new IllegalArgumentException("not legal solution");
		}
		//if there is no solution for the problem
		else {
			s=null;
		}
		return s;
	}
			
			
		
	// Task 20
	public static boolean solve2(boolean[][] flights) {
		boolean isTwoSolutions=false;
		//save the first solution
		int [] firstTour = solve(flights);
		//if the solution might be correct
		if(firstTour!=null) {
			//initialize map 
			int [] [] map = createVarsMap(flights.length);
			//initialize SAT solver
			SATSolver.init(map.length*map.length);
			//add the cnf to the SAT solver
			encode(flights,map);
			//add the negative clauses of the first solution to the cnf 
			for(int i=1;i<firstTour.length;i=i+1) {
				int [] clause = {-map[i][firstTour[i]]};
				SATSolver.addClause(clause);
			}
			//check if there is another solution
			boolean[] assignment = SATSolver.getSolution();
			//if there is a timeout problem throw exception 
			if(assignment == null)
				throw new IllegalArgumentException("timeout");
			//check if the solution is legal or not
			if (assignment.length==map.length*map.length+1) {
				int [] tour = decode(assignment,map);
				if(isSolution(flights,tour))
					isTwoSolutions=true;
				else throw new IllegalArgumentException("not legal solution");
			}
		}
		return isTwoSolutions;
	}
	//combine two arrays into one
	public static int [] [] combineArrays (int [] [] arr1, int [] [] arr2){
		int [] [] combine = new int [arr1.length+arr2.length] [];
		//insert the first array into the output array
		for(int i=0;i<arr1.length;i=i+1) {
			combine[i]=arr1[i];
		}
		//insert the second array into the output array
		for(int i=arr1.length;i<arr1.length+arr2.length;i=i+1) {
			combine[i]=arr2[i-arr1.length];
		}
		return combine;
	}
	public static boolean IsLegalMap(boolean [] [] flights, int [] [] map) {
		boolean isLegal = true;
		int [] [] mapTest = createVarsMap(flights.length);
		if(map==null||mapTest.length!=map.length)
			isLegal=false;
		for(int i=0;i<map.length&isLegal;i=i+1) {
			if(map[i]==null||map[i].length!=mapTest[i].length)
				isLegal=false;
				for(int j=0;isLegal&&j<map[i].length;j=j+1)
					if(map[i][j]!=mapTest[i][j])
						isLegal=false;			
		}
		return isLegal;
	}
	
	

}

