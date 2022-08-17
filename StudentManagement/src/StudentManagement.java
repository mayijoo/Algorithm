
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/***
 * 
 * @author mayijoo
 * @since 2022-07-15
 * 
 *        리팩토링 문제 확인 1. 변수명 - 데이터의 목적으로 사용되는지 알 수 없음 2. Magic Number - 제어문에 0 ,
 *        1, 2... 과 같은 Number가 쓰였는데, 왜 저 Number를 써야했는지 파악하기 어려움. 3. 주석의 부재 4. 중복
 *        코드 5. 추상화가 되어 있지 않음. 5-1. 하나의 함수(main())안에 여러가지 기능이 포함되어 있음 - main 함수에
 *        절차지향으로 code가 작성되어 있음. code작성자 외에 개발자가 내용을 파악하려면 code를 읽고 데이터가 어떻게
 *        변화하는지 파악해야함.
 */
public class StudentManagement {
	public static void main(String[] args) {
		// 1. file read
		final String filePath = "C:/Work/StudentData.txt";
		Reader reader = readJsonFile(filePath);

		System.out.println("Parse to JSON");
		// 2. parse file to Object 
		Object jsonObject = parseFiletoJsonObject(reader);

		System.out.println("3. parse�� ���ÿ� JSONArray�� ��ȯ");
		JSONArray jsonArr2 = (JSONArray) jsonObject;

		for (int i = 0; i < jsonArr2.size(); i++) {
			if (i == 0) {
				System.out.println(jsonArr2.get(i));
			} else if (i == 1) {
				System.out.println(jsonArr2.get(i));
			}
		}

		System.out.println("2. JSONObject�� ��ȯ");
		JSONObject jsonObj2 = null;
		JSONArray jsonArr = null;

		for (int i = 0; i < jsonArr2.size(); i++) {

			jsonObj2 = (JSONObject) jsonArr2.get(i);

			if (i == 0) {
				System.out.println(jsonObj2.get("��������"));

				System.out.println("1. �������� JSONArray�� ��ȯ");

				jsonArr = (JSONArray) jsonObj2.get("��������");

				printArray(jsonArr);

			} else if (i == 1) {
				System.out.println(jsonObj2.get("������Ϻ�"));

				System.out.println("1. ������Ϻ� JSONArray�� ��ȯ");

				jsonArr = (JSONArray) jsonObj2.get("������Ϻ�");

				printArray(jsonArr);
			}
		}

		System.out.println("0. JSONObject�� ��ȯ");
		JSONObject lastObj = null;

		for (int i = 0; i < jsonArr.size(); i++) {
			lastObj = (JSONObject) jsonArr.get(i);

			if (i == 0) {
				System.out.println(lastObj.get("OS"));
			} else if (i == 1) {
				System.out.println(lastObj.get("Network"));
			} else if (i == 2) {
				System.out.println(lastObj.get("DataBase"));
			} else if (i == 3) {
				System.out.println(lastObj.get("AI"));
			}
		}
	}

	private static Object parseFiletoJsonObject(Reader reader) {
		Object jsonObject = null;

		try {
			JSONParser parser = new JSONParser();
			jsonObject = parser.parse(reader);
		} catch (IOException e) {
			System.out.println("IOException to parse");
		} catch (ParseException e) {
			System.out.println("ParseException");
		} catch (Exception e) {
			System.out.println("during parsing Exception");
		}

		return jsonObject;
	}

	private static Reader readJsonFile(final String filePath) {
		Reader reader = null;
		try {
			reader = new FileReader(filePath, StandardCharsets.UTF_8);
		} catch (FileNotFoundException e) {
			e.getMessage();
			System.out.println("file not found : " + filePath);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("readJsonFile - Exception");
		}

		return reader;
	}

	private static void printArray(JSONArray jsonArr) {
		int arraySize = jsonArr.size();

		for (int k = 0; k < arraySize; k++) {
			System.out.println(jsonArr.get(k));
		}
	}
}