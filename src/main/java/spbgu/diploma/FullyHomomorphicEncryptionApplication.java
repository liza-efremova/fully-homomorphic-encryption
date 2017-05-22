package spbgu.diploma;

import beans.Polynomial;
import beans.SecretKey;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static utils.HomomorphicEncryptionUtils.*;

@SpringBootApplication
@RestController
public class FullyHomomorphicEncryptionApplication {

	@RequestMapping(value = "/encode", method = RequestMethod.GET)
	public Map<String, Object> encode(@RequestParam(value = "opendata1") Integer opendata1,
										  @RequestParam(value = "opendata2") Integer opendata2) {
		Map<String, Object> model = new HashMap<>();
		int base = getRandomBase(opendata1, opendata2);
		SecretKey secretKey = getRandomPolynomial(6, base);

		Polynomial polynomFromOpenData1 = getPolynomialFromIntWithBase(opendata1, base);
		Polynomial encodedOpenData1 = polynomFromOpenData1.mapWith(secretKey.getMappingPolynomial());

		Polynomial polynomFromOpenData2 = getPolynomialFromIntWithBase(opendata2, base);
		Polynomial encodedOpenData2 = polynomFromOpenData2.mapWith(secretKey.getMappingPolynomial());


		model.put("opendata1", encodedOpenData1.toString());
		model.put("opendata2", encodedOpenData2.toString());
		model.put("base", "" + base);
		model.put("mappingPolynomial", secretKey.getMappingPolynomial().toString());
		return model;
	}

	@RequestMapping(value = "/perform", method = RequestMethod.GET)
	public Map<String, Object> perform(@RequestParam(value = "opendata1") String opendata1,
									  @RequestParam(value = "opendata2") String opendata2,
									   @RequestParam(value = "operation") String operation) {
		Map<String, Object> model = new HashMap<>();
		Polynomial polynomialFromOpendata1 = Polynomial.valueOf(opendata1);
		Polynomial polynomialFromOpendata2 = Polynomial.valueOf(opendata2);
		Polynomial encodedResult = new Polynomial();
		Polynomial decodedResult = new Polynomial();

		switch (operation){
			case "+":
				encodedResult = polynomialFromOpendata1.add(polynomialFromOpendata2);
				break;
			case "-":
				encodedResult = polynomialFromOpendata1.subtract(polynomialFromOpendata2);
				break;
			case "*":
				encodedResult = polynomialFromOpendata1.multiply(polynomialFromOpendata2);
				break;
			case "/":
				//encodedResult = polynomialFromOpendata1.divide(polynomialFromOpendata2);
				break;
			default:
				throw new IllegalStateException("Неправильная операция: " + operation);
		}


		model.put("encodedResult", encodedResult.toString());
		model.put("decodedResult", decodedResult.toString());
		return model;
	}

	public static void main(String[] args) {
		SpringApplication.run(FullyHomomorphicEncryptionApplication.class, args);
	}
}
