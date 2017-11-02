public class MovieSeats {

    static int[][] seats = new int[3][6];
	static String centerTextInConsole = "\t\t\t\t\t\t\t";

    public static void main(String[] args) {

        seats[0][0] = 0;
        seats[0][1] = 1;
        seats[0][2] = 1;
        seats[0][3] = 0;
        seats[0][4] = 0;
        seats[0][5] = 0;

        seats[1][0] = 0;
        seats[1][1] = 0;
        seats[1][2] = 0;
        seats[1][3] = 0;
        seats[1][4] = 1;
        seats[1][5] = 1;

        seats[2][0] = 1;
        seats[2][1] = 0;
        seats[2][2] = 0;
        seats[2][3] = 1;
        seats[2][4] = 0;
        seats[2][5] = 0;

        System.out.println("\n\n\n\n\n " + centerTextInConsole + "This " + (isAisleSeat(2, 4) ? "is" : "is not") + " an isle seat");
        System.out.println(centerTextInConsole + "There " + (twoTogether() == true ? "are" : "aren't") + " adjacent seats");
        System.out.println(centerTextInConsole + "There " + (findAdjacent(1, 4)  == -1? "aren't" : "are") + " enough seats\n\n\n\n\n");
    }

    public static boolean isAisleSeat(int row, int seatNumber) {
        return seatNumber == 0 || seatNumber == seats[row].length ? true : false;
    }

    public static boolean twoTogether() {
        for(int row = 0; row < seats.length; row++)
            for(int occupied = 0; occupied < seats[row].length; occupied++)
                if((occupied < seats[row].length - 1) && (seats[row][occupied] == 0 && seats[row][occupied + 1] == 0))
                    return true;
        return false;
    }

    public static boolean twoTogether(int row) {
        for(int column = 0; column < seats.length - 1; column++)
            if(seats[row][column] == 0 && seats[row][column + 1] == 0)
                return true;
        return false;
    }

    public static int findAdjacent(int row, int seatsNeeded) {
		int freeSeats = 0, tempCount = 0;
		for(int column = 0; column < seats[row].length; column++)
			if(seats[row][column] == 0)
				tempCount++;
			else if(tempCount > freeSeats) {
				freeSeats = tempCount;
				tempCount = 0;
			}
		return freeSeats < seatsNeeded ? -1 : freeSeats;
    }

}
