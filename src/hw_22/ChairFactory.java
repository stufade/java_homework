package hw_22;

public class ChairFactory implements AbstractChairFactory {
    public VictorianChair createVictorianChair(int age) {
        return new VictorianChair(age);
    }

    public MagicChair createMagicanChair() {
        return new MagicChair();
    }

    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}