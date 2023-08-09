package uz.pdp.roomservice2.exaption;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String massage)  { super(massage);
    }
}
