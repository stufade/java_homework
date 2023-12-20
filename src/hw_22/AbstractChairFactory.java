package hw_22;

public interface AbstractChairFactory {
    public VictorianChair createVictorianChair(int age);

    public MagicChair createMagicanChair();

    public FunctionalChair createFunctionalChair();
}
