package calculator;

class Result {

	void BMRResultView(UserStatus user) {
		Calculation calculation = new Calculation();
		double BMR = calculation.BMRCalculator(user.getSex(), user.getAge(), user.getHeight(), user.getWeight());
		System.out.println("基礎代謝は" +BMR+ "kcalです");
	}

	void StandardWeightResultView(UserStatus user) {
		Calculation calculation = new Calculation();
		double SW = calculation.StandardWeightCalculator(user.getHeight());
		System.out.println("標準体重は" + SW + "kgです" );
	}

}
