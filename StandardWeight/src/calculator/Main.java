package calculator;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

	Scanner sc = new Scanner(System.in);

	System.out.println("基礎代謝計算：1を入力\n標準体重計算：2を入力");
	int mode = sc.nextInt();
	// 数字以外を入れた場合のエラー処理が必要
	if(mode == 1) {

	System.out.println("性別を選択\n男：1\n女：2");
	int sex = sc.nextInt();

	System.out.println("年齢を入力してください");
	int year = sc.nextInt();

	System.out.println("身長を入力してください（cm）");
	double height = sc.nextDouble();

	System.out.println("体重を入力してください（ｋｇ）");
	double weight = sc.nextDouble();

	double BMR = Calculator1(sex, year, height, weight);
	System.out.println("基礎代謝は" +BMR+ "kcalです");

	sc.close();
	}else {

	System.out.println("標準体重計算\n身長(m)を入力してください(170cm = 1.7)");
	double height = sc.nextDouble();

	double SW = Calculator2(height);
	System.out.println("標準体重は" + SW + "kgです" );
	sc.close();

	}

	}

public static double Calculator2(double height){
	double sw = height * height * 22;
	// 小数点第二位を切り上げ
	sw = Math.ceil(sw * 10)/10;
	return sw;
}

public static double Calculator1(int sex,int year,double height,double weight) {
	if(sex == 1) {
		//ハリス・ベネディクト方程式（改良版） https://keisan.casio.jp/exec/system/1161228736
		double BMR = 13.397 * weight + 4.799 * height - 5.677 * year + 88.362;
		return Math.ceil(BMR*100000)/100000;
	}else {
		double BMR = 9.247 * weight + 3.098 * height - 4.33 * year + 447.593;
		return Math.ceil(BMR*100000)/100000;
	}
}

}
