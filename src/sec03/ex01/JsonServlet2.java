package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@SuppressWarnings("unchecked")
	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		JSONObject totalObject = new JSONObject();	// 최종 껍데기용 JSON Obejct
		JSONObject memberInfo = new JSONObject();	// Key : Value 용 JSON Object
		
		JSONArray membersArray = new JSONArray();	// Value에 사용한 JSON Array
		

		memberInfo.put("name", "하북이");
		memberInfo.put("age", "unknown");
		memberInfo.put("gender", "중성화");
		memberInfo.put("nickname", "HaBook");
        //  �迭�� �Է�
		membersArray.add(memberInfo);

		memberInfo = new JSONObject();	// 다시 쌔거줭
		memberInfo.put("name", "키북이");
		memberInfo.put("age", "unknown");
		memberInfo.put("gender", "수컷");
		memberInfo.put("nickname", "도베르만");
		membersArray.add(memberInfo);

		totalObject.put("members", membersArray);	// key : [ { ... } ] 형식으로 다시 만들고

		String jsonInfo = totalObject.toJSONString();
		
		System.out.print(jsonInfo);
		
		writer.print(jsonInfo);
		
	}

}
