package calculator;

import java.util.Scanner;

public class Main {

public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	System.out.println("身長(m)を入力してください(170cm = 1.7)");
	Scanner sc = new Scanner(System.in);
	double height = sc.nextDouble();
	double SW = Calculator(height);
	System.out.println("標準体重は" + SW + "kgです" );
	sc.close();
	}

public static double Calculator(double height){
	double sw = height * height * 22;
	// 小数点第二位を切り上げ
	sw = Math.ceil(sw * 10)/10;
	return sw;
}

}
