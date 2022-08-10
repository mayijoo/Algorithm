
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
 * �л����� ���α׷�
 * - ��� 
 *  1. ��� ���   
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
            System.out.println("file reader ����");
            return;
        } catch (Exception e) {
            e.getMessage();
            System.out.println("�˼����� Exception ����");
            return;
        }

        System.out.println("Parse to JSON");

        JSONParser parser = new JSONParser();

        System.out.println("3. parse�� ���ÿ� JSONArray�� ��ȯ");
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
            System.out.println("parse IO ����1");
        } catch (ParseException e) {
            e.getMessage();
            System.out.println("parse Exception1");
        } catch (Exception e) {
            e.getMessage();
            System.out.println("during parsing �� �� ���� Exception ���� �߻�1");
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
                for (int j = 0; j < jsonArr.size(); j++) {

                    System.out.println(jsonArr.get(j));
                }

            } else if (i == 1) {
                System.out.println(jsonObj2.get("������Ϻ�"));

                System.out.println("1. ������Ϻ� JSONArray�� ��ȯ");
                jsonArr = (JSONArray) jsonObj2.get("������Ϻ�");
                for (int k = 0; k < jsonArr.size(); k++) {

                    System.out.println(jsonArr.get(k));
                }
            }
        }
       
        System.out.println("0. JSONObject�� ��ȯ");
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
        
        System.out.println("join Minchul....testing");
        System.out.println("join Minchul....testing10");
        System.out.println("join Minchul....testing100");
        System.out.println("join Minchul....testing1000");

        JSONObject lastObj0 = null;
        for(int i=0; i<jsonArr.size(); i++) {
            lastObj0 = (JSONObject)jsonArr.get(i);
            if(i == 0) {
                System.out.println(lastObj0.get("OS"));
            }else if(i == 1) {
                System.out.println(lastObj0.get("Network"));
            }else if(i == 2) {
                System.out.println(lastObj0.get("DataBase"));
            }else if(i == 3 ) {
                System.out.println(lastObj0.get("AI"));
            }
        }

    }
}