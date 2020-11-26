
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
 READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
 the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name:
Student Number:
Course Section:
*/

package Assignment1;

import java.util.*;

/**
 * 
 * @author EECS2030 Team
 *
 */

public class Map {
	boolean[][] map;
	private int rows; //rows
	private int cols; //columns

	/**
	 * This is the constructor that constructs the city map, which is a grid of row
	 * by column.
	 * 
	 * @param row    is the number of east-west streets of the city
	 * @param column is the number of north-south streets of the city
	 */
	public Map(int rows, int cols) {
		// Please implement the constructor

		this.rows = rows;
		this.cols = cols; 
		
		

	}

	/**
	 * This method checks the correctness of the input parameters. If the
	 * preconditions are not met an exception is thrown, otherwise depending to the
	 * direction, it calls one of the four recursive functions of goSouthWest,
	 * goSouthEast, goNorthWest and goNorthEast.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre the integer parameters should be in the range of the city grid.(i.e. [0,
	 *      N) if N is the number of east-west streets and [0, M) if M is the number
	 *      of north-south streets.)
	 * @exception IllegalArgumentException if any of the precondition did not meet.
	 */
	public String getPath(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		if (this.rows < startRow || this.cols < destCol)
			throw new IllegalArgumentException();

		//Wait you should also include the case where destRow is great than this.rows and startCol is greater than this.cols
		if ((startRow > destRow) && (startCol > destCol)) { // 1st west,2nd south
			return goSouthWest(startRow, startCol, destRow, destCol, path);
		} else if ((startRow > destRow) && (startCol < destCol)) {// 1st east, 2nd south
			return goSouthEast(startRow, startCol, destRow, destCol, path);
		} else if ((startRow > destRow) && (startCol > destCol)) {// 1st west,2nd north
			return goNorthWest(startRow, startCol, destRow, destCol, path);
		} else if ((startRow < destRow) && (startCol < destCol)) { // 1st east, 2nd south
			return goNorthEast(startRow, startCol, destRow, destCol, path);
		}

		return null;

	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */

	private String goSouthWest(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		if (startRow != destRow)
			startRow--; // move south first
		else if (startCol != destCol)
			startCol--; // move west if south position is correct
		else
			return path; // final destination is correct

		path += String.format("(%d,%d) ", startRow, startCol);
		return goSouthWest(startRow, startCol, destRow, destCol, path);

		// return null;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goSouthEast(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		if (startRow != destRow)
			startRow--; // move south first
		else if (startCol != destCol)
			startCol++; // move east if south position is correct
		else
			return path; // final destination is correct

		path += String.format("(%d,%d) ", startRow, startCol);
		return goSouthEast(startRow, startCol, destRow, destCol, path);
		// return null;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow <= destRow </code> and
	 *      <code> startCol >= destCol </code>
	 */
	private String goNorthEast(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		if (startRow != destRow)
			startRow++; // move North first
		else if (startCol != destCol)
			startCol++; // move east if north position is correct
		else
			return path; // final destination is correct

		path += String.format("(%d,%d) ", startRow, startCol);
		return goSouthEast(startRow, startCol, destRow, destCol, path);
		// return null;
	}

	/**
	 * This method returns a path from the source (startRow, startCol) to the
	 * destination (destRow, destCol). Please note that the returning path does not
	 * include the starting point.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @param destRow  is the destination row
	 * @param destCol  is the destination column
	 * @param path     is the path that is constructed while the recursive method is
	 *                 called. In first round, it will be "".
	 * @return returns a string representing the path to the destination. The format
	 *         of the output is (x1,y1) (x2,y2) (x3,y3)...
	 * @pre <code> startRow >= destRow </code> and
	 *      <code> startCol <= destCol </code>
	 */
	private String goNorthWest(int startRow, int startCol, int destRow, int destCol, String path) {
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
		if (startRow != destRow)
			startRow++; // move North first
		else if (startCol != destCol)
			startCol--; // move West if north position is correct
		else
			return path; // final destination is correct

		path += String.format("(%d,%d) ", startRow, startCol);
		return goSouthEast(startRow, startCol, destRow, destCol, path);
		// return null;
	}

	/**
	 * This method find a path from (startRow, startCol) to a border point of the
	 * city. Please note that the starting point should be included in the path.
	 * 
	 * @param startRow is the starting row of the path
	 * @param startCol is the starting column of the path
	 * @return is a path from (starting row, staring col) to a border point of the
	 *         city. The format of the output is (x1,y1) (x2,y2) (x3,y3)...
	 *         
	 */
	private String helper(int startRow, int startCol, int x, int y, String route)
	{
		String x_s = Integer.toString(startRow);
		String y_s = Integer.toString(startCol); 
		if (x>this.cols || y>this.rows)
		{
			return route;
		}
		else if (route.contains("(" + x_s + "," + y_s + ")"))
		{
			findPath(startRow, startCol);
		}
		
		else 
		{
			route = route + "(" + x_s + "," + y_s + ")";
			return helper(startRow, startCol, (int)(x+Math.random()* 2) + -1, (int)(y+Math.random()*2) + -1, route);
		}
		return null;

	}
	
	public String findPath(int startRow, int startCol) {
		
		{
			// Please complete this method
			// you should decide on what should be returned. This return statement is here
			// to avoid compiler error.
			String x_s = Integer.toString(startRow);
			String y_s = Integer.toString(startCol);
			String route = "(" + x_s + "," + y_s + ")";
			return helper(startRow, startCol, startRow, startCol,route);

		}
	}
		
		public static void main(String[] args) { //tester to see if task 4 works, using sample input given in instructions
			Map map=new Map(5,5);
			System.out.println(map.getPath(5, 5, 4, 1, ""));
			
		}
	}
		// Please complete this method
		// you should decide on what should be returned. This return statement is here
		// to avoid compiler error.
	