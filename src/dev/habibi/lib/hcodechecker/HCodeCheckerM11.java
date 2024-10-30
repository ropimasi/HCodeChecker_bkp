package dev.habibi.lib.hcodechecker;

// ALGORITMO HABIBI DE CÓDIGO VERIFICADOR MÓDULO 11.
// RETORNA UM CÓDIGO VERIFICADOR COM APENAS UM CARACTER: "0,1,2,3,4,5,6,7,8,9,X".

public class HCodeCheckerM11 {

	public static String getFor(String number) {
		return calculate(number);
	}



	public static String getFor(Long number) {
		if (!(number instanceof Long))
			throw new NumberFormatException("The number whose verification code is being checked must be an integer.");

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
		int weightSum = 0;
		int weight = 2;

		for (int i = number.length() - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(number.charAt(i));
			weightSum += digit * weight;
			weight++;

			if (weight == 10)
				weight = 2;
		}

		int verifier = 11 - (weightSum % 11);

		if (verifier >= 10)
			rtn = "X";
		else
			rtn = String.valueOf(verifier);

		return rtn;
	}
}