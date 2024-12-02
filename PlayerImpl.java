public class PlayerImpl implements Player {
    private String name;

    @Override
    public void enterName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}