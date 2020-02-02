package sec01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String file_repo="C:\\file_repo";
		String fileName = (String) request.getParameter("fileName");//매개변수로 전송된 파일 이름을 읽어옵니다.
		System.out.println("fileName=" + fileName);
		OutputStream out = response.getOutputStream();//response에서 OutputStream 객체를 가져옵니다.
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);
		
		//파일을 다운로드 할 수 있습니다.
		response.setHeader("Cache-Control", "no-cache");//파일 다운로드는 캐싱 안되도록 설정,default는 캐시사용
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName);
		//file download 처리 시 attachment로 설정
		//• attachment: 파일 다운로드 대상상자가 뜸 • inline: 바로 다운로드 됨
		
		FileInputStream in = new FileInputStream(f);
		
		//버퍼기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력합니다.
		byte[] buffer =new byte[1024*8];//데이터를 받을 버퍼 설정
		while (true) {
			int count = in.read(buffer);//buffer만큼 read해옴(없으면 1바이트씩)
			if (count == -1)//더이상 읽을 값이 없으면 break
				break;
			out.write(buffer, 0, count);//읽은 값을 계속 브라우저로 보냄
		}
		in.close();
		out.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

}
