package sec01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding="utf-8";
		File currentDirPath = new File("C:\\file_repo");//업로드할 파일 경로를 지정합니다.
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);//파일 경로를 설정합니다, 임시 Directory
		factory.setSizeThreshold(1024*1024);//최대 업로드 가능한 파일 크기를 설정합니다.
		//단위는 바이트, 기본값은 10240바이트(10kb)

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);//request 객체에서 매개변수를 List로 가져옵니다.
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);//파일 업로드 창에서 업로드된 항목들을 하나씩 가져옵니다.
				
				if(fileItem.isFormField()) {
				//폼필드이면 전송된 매개변수 값을 출력합니다.
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				}else {
				//폼 필드가 아니면(File이면) 파일 업로드 기능을 수행합니다.
					System.out.println("파라미터명:" + fileItem.getFieldName());
					System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) {
					//업로드한 파일 이름을 가져옵니다.
						int idx = fileItem.getName().lastIndexOf("\\");//마지막 인덱스 찾아서 파일명 추출
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");//리눅스일떄
						}
						String fileName = fileItem.getName().substring(idx + 1);
						
						//업로드한 파일 이름으로 저장소에 파일을 업로드합니다.
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					} // end if
				}//end if
			} // end for
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandler(request,response);
	}
}
