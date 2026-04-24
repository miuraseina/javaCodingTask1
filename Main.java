package javaCodingTask1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		System.out.println("料理名を入力してください：");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		if (input.length() <= 2) {
			System.out.println("メニュー名は3文字以上で入力してください");
			return;
		}



		InputStream is = Main.class
				.getClassLoader()
				.getResourceAsStream("javaCodingTask1/resources/Menu.csv");



		if (is == null) {
			throw new RuntimeException("CSVが見つかりません");
		}


		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(is, StandardCharsets.UTF_8))) {

			String line;


			List<String> menuList = new ArrayList<>();

			while ((line = br.readLine()) != null) {

				String[] menuWords = line.trim().split(" ");
				String[] inputWords = input.split(" ");
				boolean matched = false;

				for (String menu : menuWords) {
					for(String word : inputWords){
						if (menu.equals(word)) {
							matched = true;
							break;
						}
					}}

				if (matched) {
					menuList.add(line + ": Yes");
				} else {
					menuList.add(line + " ");
				}
			}

			for (String result : menuList) {
				System.out.println(result);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

