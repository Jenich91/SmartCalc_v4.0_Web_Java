package edu.school.calc;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.*;

import org.junit.jupiter.api.Test;

@SpringBootTest
public class CalcTests {
    public double round(double value) {
        return (double)Math.round(value *1e6d) / 1e6d;
    }
    private static final double DELTA = 1e-6;
    ComputeCore model = new ComputeCore("libcalcNativeLib.dylib");

	@Test
	public void contextLoads() {
        String exp = "794+(101+110)+387";
        double res = 794+(101+110)+387;
        assertEquals(true, model.validExpression(exp, ""));
        assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

        exp = "2.0+3.32";
        res = 2.0+3.32;
        assertEquals(true, model.validExpression(exp, ""));
        assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "2.0+3.32";
       res = 2.0+3.32;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "12+0.0";
       res = 12+0.0;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-12+2.34";
       res = -12+2.34;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "100+-234.0";
       res = 100+-234.0;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "9+(8+6)+1+(3+9)";
       res = 9+(8+6)+1+(3+9);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "21892683+(+60607476)";
       res = 21892683+(+60607476);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "794+(101+110)+387";
       res = 794+(101+110)+387;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);
	}

   @Test
   void testSub() throws Exception {
       String exp = "416-434";
       double res = 416-434;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "107-(928-166-438)";
       res = 107-(928-166-438);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(399-985)-63-352";
       res = (399-985)-63-352;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "107-(928-166-438)";
       res = 107-(928-166-438);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(399-985)-63-352";
       res = (399-985)-63-352;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "317-141-(118-695)";
       res = 317-141-(118-695);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(3879294-5309583)-(3744311-2467480-4787696)-3324295";
       res = (3879294-5309583)-(3744311-2467480-4787696)-3324295;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);
   }

   @Test
   void testMul() throws Exception {
       String exp = "(-0.38227*7856.815-0.0)*(77.3*-55.96)";
       double res = (-0.38227*7856.815-0.0)*(77.3*-55.96);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "69.08*-(58.31*75.6934)*-(-32.10*4.36)";
       res = 69.08*-(58.31*75.6934)*-(-32.10*4.36);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(-816.484*5.2)*5.881*(4.3*401.94)";
       res = (-816.484*5.2)*5.881*(4.3*401.94);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(91.226*-51.9)*(7.797*85.481)";
       res = (91.226*-51.9)*(7.797*85.481);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-25.9655*-(-626.93*5.657)*(85.108*4.162)";
       res = -25.9655*-(-626.93*5.657)*(85.108*4.162);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-(-3.081*4.63)*803.928*(70.592*0.1569)*-36.1566";
       res = -(-3.081*4.63)*803.928*(70.592*0.1569)*-36.1566;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);
   }

   @Test
   void testDiv() throws Exception {
       String exp = "(432/9.57/321)/(76.4/78.0)/-35.8";
       double res = (432/9.57/321)/(76.4/78.0)/-35.8;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "43.1/(495.5/711.0)/28.7";
       res = 43.1/(495.5/711.0)/28.7;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(0.5757/23.3/704.1/-31.27)";
       res = (0.5757/23.3/704.1/-31.27);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(2451.0/43.94/-1.759)/62.72";
       res = (2451.0/43.94/-1.759)/62.72;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(1.375/930.0)/223.3/80.41";
       res = (1.375/930.0)/223.3/80.41;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "4.091/(23.04/1.075/42.8)";
       res = 4.091/(23.04/1.075/42.8);
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "(7068.0/33.59/9.13-4)/43.5";
       res = (7068.0/33.59/9.13-4)/43.5;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "97.66/(705.2/2619.0)/59.59";
       res = 97.66/(705.2/2619.0)/59.59;
       assertEquals(true, model.validExpression(exp, ""));
       assertEquals(res, Double.parseDouble(model.computeExpression(exp, "")), DELTA);
   }

  @Test
   void testPow() throws Exception {
       String expS = "8^(3^4)";
       double expD = pow(8, pow(3, 4));
       BigDecimal expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       BigDecimal observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "(2^9)^1";
       expD = pow(pow(2, 9), 1);
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "2^2^3";
       expD = (pow(2, pow(2, 3)));
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "5^(3^3)";
       expD = (pow(5, pow(3, 3)));
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "(4^10)^3";
       expD = pow(pow(4, 10), 3);
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "(8^2)^8";
       expD = pow(pow(8, 2), 8);
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);

       expS = "(4^10)^3";
       expD = pow(pow(4, 10), 3);
       expected = BigDecimal.valueOf(expD).setScale(7, RoundingMode.UP).stripTrailingZeros();
       observed = BigDecimal.valueOf(Double.parseDouble(model.computeExpression(expS, ""))).setScale(7, RoundingMode.UP).stripTrailingZeros();

       assertEquals(true, model.validExpression(expS, ""));
       assertEquals(expected, observed);
   }

   @Test
   void testMod() throws Exception {
       String exp = "(45.34mod55.23)mod79.4";
       double res = (45.34%55.23)%79.4;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "357.34mod(952.34mod712.12)";
       res = 357.3%(952.3%712.12);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "15.234mod(0.52mod0.034)";
       res =15.234%(0.52%0.034);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "499.23mod(1.8mod0.27)";
       res = 499.23%(1.8%0.27);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "22mod-x";
       double x = 20;
       res = 22%-x;
       assertEquals(true, model.validExpression(exp, Double.toString(x)) );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, Double.toString(x))), DELTA);
   }

   @Test
   void testFunc() throws Exception {
       String exp = "acos(0.1)*sin(1)";
       double res = Math.acos(0.1)*Math.sin(1);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "cos(-1.34)+tan(+2.0)";
       res = cos(-1.34)+tan(+2.0);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-(asin(+0.3465346)/2)";
       res = -(asin(+0.3465346)/2);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "+atan(1.302+0.5)-1.2";
       res = +atan(1.302+0.5)-1.2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "123modsqrt(100)";
       res = 123%sqrt(100);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "log(+123.345)";
       res = log10(+123.345);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-sin(1)";
       res = -sin(1);
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "sin1";
       assertEquals(false, model.validExpression(exp, "") );

       exp = "sims(3)+cs(1.6)";
       assertEquals(false, model.validExpression(exp, "") );

       exp = "2+3/sin()";
       assertEquals(false, model.validExpression(exp, "") );

       exp = "sin)";
       assertEquals(false, model.validExpression(exp, "") );
   }

   @Test
   void testSciNotation() throws Exception {
       String exp = "10e2";
       double res = 10e2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "10e-2";
       res = 10e-2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "10e+2";
       res = 10e+2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "10e8+10e-9";
       res = 10e8+10e-9;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "10.434e8+10.3656e-9-10";
       res = 10.434e8+10.3656e-9-10;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-3.24e-3+2.343e+2";
       res = -3.24e-3+2.343e+2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);

       exp = "-3.24+33mod2.343e-2";
       res = -3.24+33%2.343e-2;
       assertEquals(true, model.validExpression(exp, "") );
       assertEquals(round(res), Double.parseDouble(model.computeExpression(exp, "")), DELTA);
   }
}
