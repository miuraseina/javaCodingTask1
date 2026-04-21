package javaCodingTask1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//java.io.IOException何らかの入出力例外の発生を通知するシグナルを発生させます。 
//このクラスは、入出力処理の失敗、または割り込みの発生によって生成される例外の汎用クラスです。 

public class Main {


	public static void main(String[] args) {


		try (/*
				正規表現を使用してプリミティブ型および文字列の構文解析が可能な、単純なテキスト・スキャナ
				Scannerは、区切り文字のパターンを使用して入力をトークンに分割します。
				デフォルトでは区切り文字は空白文字です。
				public static final InputStream in
				「標準」入力ストリームです。 このストリームはすでに開いていて、
				入力データの供給が可能です。
		 * */
				Scanner sc = new Scanner(System.in)) {

			String csvFile = "C:\\sadopj_workspace\\javaCodingTask1\\javaCodingTask1\\src\\javaCodingTask1\\Menu.csv";

			System.out.println("「あなたの食べたい料理名を入力してください:」");
			//String nextLine()
			/*スキャナを現在行の先に進めて、スキップした入力を返します。 
			 *このメソッドは、最後の行区切り文字を除く、現在行の残りを返します。
			 * 位置は、次の行の最初に設定されます。*/
			//String trim()
			/*値がこの文字列で、先頭と末尾のすべてのスペースが削除され、
			コード・ポイントが'U+0020' (空白文字)以下の文字でスペースが定義されている文字列を返します
			*/
			String input = sc.nextLine().trim();
			String[] inputDishes = input.split(" ");

			List<String> menuList = new ArrayList<>();

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
				String line;

				while ((line = br.readLine()) != null) {

					String[] menuWords = line.trim().split(" ");

					for (String word : menuWords) {
						for (String dish : inputDishes) {

							
							if (word.equals(dish)) {

								menuList.add(line + ": Yes");
								break;

							}
						}
					}

				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
				return;
			}




			if( input.length() <= 2 ){

				System.out.println("「メニュー名は3文字以上で入力してください。」");}



			for (String menu : menuList) {
				System.out.println(menu);
			}









			//[入力]料理名がメニューCSVに含まれていれば
			//『メニューリスト』に{menu}: Yesを追加する
			//[入力]料理名がメニューCSVに含まれていなければ何もしない











		}


	}
}