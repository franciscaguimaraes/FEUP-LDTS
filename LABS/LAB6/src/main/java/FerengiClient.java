public class FerengiClient extends AlienClient{
    OrderingStrategy strategy;

    @Override
    protected OrderingStrategy createOrderingStrategy() {
        strategy = new SmartStrategy();
        return strategy;
    }
}
