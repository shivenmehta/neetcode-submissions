class ParkingSystem {

    public static int numBigCars;
    public static int numMediumCars;
    public static int numSmallCars;


    public ParkingSystem(int big, int medium, int small) {
        numBigCars = big;
        numMediumCars = medium;
        numSmallCars = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) { //Big Car
            if (numBigCars > 0) {
                numBigCars = numBigCars - 1;
                return true;
            } else {
                return false;
            }
        } else if (carType == 2) { //Medium Car
            if (numMediumCars > 0) {
                numMediumCars = numMediumCars - 1;
                return true;
            } else {
                return false;
            }
        } else if (carType == 3) { //Small Car
            if (numSmallCars > 0) {
                numSmallCars = numSmallCars - 1;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
