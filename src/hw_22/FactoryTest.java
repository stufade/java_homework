package hw_22;

public class FactoryTest {
    public static void main(String[] args) {
        Client me = new Client();

        FunctionalChair funcChair = new ChairFactory().createFunctionalChair();
        MagicChair magChair = new ChairFactory().createMagicanChair();
        VictorianChair vikChair = new ChairFactory().createVictorianChair(22);

        System.out.println(funcChair.sum(1, 2));
        magChair.doMagic();
        System.out.println(vikChair.getAge());

        me.setChair(funcChair);
        me.sit();
    }
}