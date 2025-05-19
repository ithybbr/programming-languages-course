package expressions;

import java.util.Map;

import mini_splat.RunException;

public class IntegerConstant extends Expression{
    private int value;
    public IntegerConstant(int val){
        value = val;
    }
    public int computeValue(Map<String, Integer> varMap) throws RunException{
        return value;
    }
      public String toString(){
        return Integer.toString(value);
    }
}
