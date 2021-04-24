package calculator;

class Calculation {

	double StandardWeightCalculator(double height){
		double sw = height * height * 22;
		// 小数点第二位を切り上げ
		sw = Math.ceil(sw * 10)/10;
		return sw;
	}

	double BMRCalculator(int sex,int age,double height,double weight) {
		if(sex == 1) {
			//ハリス・ベネディクト方程式（改良版） https://keisan.casio.jp/exec/system/1161228736
			double BMR = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
			return Math.ceil(BMR*100000)/100000;
		}else {
			double BMR = 9.247 * weight + 3.098 * height - 4.33 * age + 447.593;
			return Math.ceil(BMR*100000)/100000;
		}
	}
}
