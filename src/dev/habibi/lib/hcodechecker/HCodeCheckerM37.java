package dev.habibi.lib.hcodechecker;

// ALGORITMO HABIBI DE CÓDIGO VERIFICADOR MÓDULO 37.
// RETORNA UM CÓDIGO VERIFICADOR COM DOIS CARACTERES:
// "00,01,02,03,04,05,06,07,08,09,"
// "10,11,12,13,14,15,16,17,18,19,"
// "20,21,22,23,24,25,26,27,28,29,"
// "30,31,32,33,34,35,36".

public class HCodeCheckerM37 {

	public static String getFor(String number) {
		return calculate(number);
	}



	public static String getFor(Long number) {
		if (!(number instanceof Long))
			throw new NumberFormatException(
					"The number whose verification code is being checked must be an integer/long.");

		String rtn = String.valueOf(number);
		return calculate(rtn);
	}



	public static String getCompleteFor(String number) {
		return number + "-" + calculate(number);
	}



	public static String getCompleteFor(Long number) {
		if (!(number instanceof Long))
			throw new NumberFormatException(
					"The number whose verification code is being checked must be an integer/long.");

		String rtn = String.valueOf(number);
		return number + "-" + calculate(rtn);
	}



	private static String calculate(String number) {
		try {
			Long.parseLong(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(
					"The number whose verification code is being checked must be an integer/long.");
		}

		String rtn = "";
		int weight = 2;
		int weightedSum = 0;

		for (int i = number.length() - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(number.charAt(i));
			int weightedDigit = digit * weight;
			weightedSum += weightedDigit;
			weight = (weight == 2) ? 1 : 2;
		}

		int remainder = weightedSum % 37;
		int verifier = 37 - remainder;
		if (verifier == 37)
			verifier = 0;

		rtn = String.valueOf(verifier);
		if (rtn.length() == 1)
			rtn = "0".concat(rtn);

		return rtn;
	}
}