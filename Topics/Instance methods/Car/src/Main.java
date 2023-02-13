class Car {

    int yearModel;
    String make;
    int speed;
    final int delta = 5;

    public void accelerate() {
        this.speed += delta;
    }

    public void brake() {
        this.speed -= Math.min(this.speed, delta);
    }
}