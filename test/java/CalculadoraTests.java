import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTests {

	Calculadora calculadora = new Calculadora();
	
	@Test
	public void calcular_EmptyString_returnZero() {
		int resultado = calculadora.calcular("");
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcular_SingleNumber_returnTheValue() {
		int resultado = calculadora.calcular("2");
		Assert.assertEquals(2, resultado);
	}
	
	@Test
	public void calcular_TwoNumbersCommaDelimited_returnsTheSum() {
		int resultado = calculadora.calcular("2,3");
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcular_TwoNumbersNewLineDelimited_returnsTheSum() {
		int resultado = calculadora.calcular("2\n3");
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcular_ThreeNumbersEitherWayDelimited_returnsTheSum() {	
		int resultado = calculadora.calcular("2&3&4");
		Assert.assertEquals(9, resultado);
	}
	
	@Test(expected = Exception.class)
	public void calcular_NegativeNumbers_throwException() {
		int resultado = calculadora.calcular("-1,2,-3,4");		
	}
	
	@Test
	public void calcular_NumbersGreaterThan1000_areIgnored() {
		int resultado = calculadora.calcular("1001");	
		Assert.assertEquals(0, resultado);
	}
	
	@Test
	public void calcular_SingleCharDefined_firstLine() {
		int resultado = calculadora.calcular("//#1#2#2");
		Assert.assertEquals(5, resultado);
	}
	
	@Test
	public void calcular_MultCharDefined_firstLine() {
		int resultado = calculadora.calcular("//[###]3###2###2");
		Assert.assertEquals(7, resultado);
	}
	
	@Test
	public void calcular_SingleOrMultChar_canBeDefined() {
		int resultado = calculadora.calcular("//[--]2--2--2");
		Assert.assertEquals(6, resultado);
	}
}

