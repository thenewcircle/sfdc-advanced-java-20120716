package calculator.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import calculator.Calculator;
import calculator.Expression;

@Path("/calculator")
public class CalculatorResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Expression parse(@FormParam("expression") String expression) {
		return Calculator.parse(expression);
	}

}
