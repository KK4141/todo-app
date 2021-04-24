package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UserStatus user = new UserStatus();
		Result result = new Result();
		Scanner sc = new Scanner(System.in);
		System.out.println("基礎代謝計算：1を入力\n標準体重計算：2を入力");
		try {
		int mode = sc.nextInt();
		// 数字以外を入れた場合のエラー処理が必要
		if(mode == 1) {
			System.out.println("性別を選択\n男：1\n女：2");
			user.setSex(sc.nextInt());
			System.out.println("年齢を入力してください");
			user.setAge(sc.nextInt());
			System.out.println("身長を入力してください（cm）");
			user.setHeight(sc.nextDouble());
			System.out.println("体重を入力してください（ｋｇ）");
			user.setWeight(sc.nextDouble());
			result.BMRResultView(user);
			sc.close();
		}else {
			System.out.println("標準体重計算\n身長(m)を入力してください(170cm = 1.7)");
			user.setHeight(sc.nextDouble());
			result.StandardWeightResultView(user);
			sc.close();
		}
		}catch(InputMismatchException e){
			System.out.println("不正な値です。");
		}finally {
			sc.close();
		}
	}
}