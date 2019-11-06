package cellState;

public class EmptyCell implements State {

    @Override
    public Boolean isEmpty() {
        return true;
    }

    @Override
    public void setUnit(){
        System.out.println("ASD");
    }
}
