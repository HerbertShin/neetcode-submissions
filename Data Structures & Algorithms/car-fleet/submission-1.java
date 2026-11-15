class Solution {
    private record Car(int position, int speed) {}
    
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            cars.add(new Car(position[i], speed[i]));
        }

        cars.sort(Comparator.comparingInt(Car::position).reversed());

        int fleets = 1;
        double prevTime = (double) (target - cars.get(0).position) / cars.get(0).speed;

        for (int i = 1; i < n; i ++) {
            double currTime = (double) (target - cars.get(i).position) / cars.get(i).speed;

            if (currTime > prevTime) {
                fleets ++;
                prevTime = currTime;
            }
        }

        return fleets;
    }
}
