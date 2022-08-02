
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
 * 학생관리 프로그램
 * - 기능 
 *  1. 평균 계산   
 * 
 */
public class StudentManagement {

    public static void main(String[] args) {

        System.out.println("txt file read");

        Reader reader = null;
        try {
            reader = new FileReader("C:/Work/StudentData.txt", StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.getMessage();
            System.out.println("file reader 오류");
            return;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("알수없는 Exception 오류");
            return;
        }

        System.out.println("Parse to JSON");

        JSONParser parser = new JSONParser();

        System.out.println("3. parse와 동시에 JSONArray로 변환");
        JSONArray jsonArr2 = null;
        try {
            jsonArr2 = (JSONArray) parser.parse(reader);

            for (int i = 0; i < jsonArr2.size(); i++) {
                if (i == 0) {
                    System.out.println(jsonArr2.get(i));
                } else if (i == 1) {
                    System.out.println(jsonArr2.get(i));
                }
            }

        } catch (IOException e) {
            e.getMessage();
            System.out.println("parse IO 오류1");
        } catch (ParseException e) {
            e.getMessage();
            System.out.println("parse Exception1");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("during parsing 알 수 없는 Exception 오류 발생1");
        }

        System.out.println("2. JSONObject로 변환");
        JSONObject jsonObj2 = null;
        JSONArray jsonArr = null;
        for (int i = 0; i < jsonArr2.size(); i++) {
            jsonObj2 = (JSONObject) jsonArr2.get(i);
            if (i == 0) {
                System.out.println(jsonObj2.get("인적사항"));

                System.out.println("1. 인적사항 JSONArray로 변환");
                jsonArr = (JSONArray) jsonObj2.get("인적사항");
                for (int j = 0; j < jsonArr.size(); j++) {

                    System.out.println(jsonArr.get(j));
                }

            } else if (i == 1) {
                System.out.println(jsonObj2.get("성적기록부"));

                System.out.println("1. 성적기록부 JSONArray로 변환");
                jsonArr = (JSONArray) jsonObj2.get("성적기록부");
                for (int k = 0; k < jsonArr.size(); k++) {

                    System.out.println(jsonArr.get(k));
                }
            }
        }
       
        System.out.println("0. JSONObject로 변환");
        JSONObject lastObj = null;
        for(int i=0; i<jsonArr.size(); i++) {
            lastObj = (JSONObject)jsonArr.get(i);
            if(i == 0) {
                System.out.println(lastObj.get("OS"));
            }else if(i == 1) {
                System.out.println(lastObj.get("Network"));
            }else if(i == 2) {
                System.out.println(lastObj.get("DataBase"));
            }else if(i == 3 ) {
                System.out.println(lastObj.get("AI"));
            }
        }

    }
}