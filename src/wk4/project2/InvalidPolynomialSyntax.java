package wk4.project2;

public class InvalidPolynomialSyntax extends RuntimeException {
    InvalidPolynomialSyntax(){
        super();
    }
    InvalidPolynomialSyntax(String msg){
        super(msg);
    }
}
