public class RomulanClient extends AlienClient{
    OrderingStrategy strategy;

    @Override
    protected OrderingStrategy createOrderingStrategy() {
        strategy = new ImpatientStrategy();
        return strategy;
    }
}
