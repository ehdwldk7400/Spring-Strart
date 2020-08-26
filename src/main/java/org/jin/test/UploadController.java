package org.jin.test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

@Controller
public class UploadController {

	@Resource(name = "uploadPath")
	private String uploadPath;
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@RequestMapping(value = "uploadForm", method = RequestMethod.GET)
	public void uploadForm() {
		logger.info("파일 업로드 화면");
	}

	@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
	public void uploadForm(MultipartFile[] file, Model model) throws Exception {
		for (MultipartFile files : file) {
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File 저장 위치 : " + uploadPath);
			/*
			 * String saveName = uploadFile(files.getOriginalFilename(), files.getBytes());
			 */
			File saveFile = new File(uploadPath, files.getOriginalFilename());

			try {
				files.transferTo(saveFile);
			} catch (Exception e) {
				// TODO: handle exception
				logger.info(e.getMessage());
			}
		}

	}

	// 년/월/일 폴더 생성 메서드
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		System.out.println("오늘 날짜 : " + str);
		
		return str.replace("-", File.separator);
	}

	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("파일 업로드 ajax 화면");
	}
	
	// 이미지 파일의 판단할 수있게 하는 메서드
	private boolean checkImageType(File file) {
		
		try {
			String contentType = Files.probeContentType(file.toPath());			
			return contentType.startsWith("image");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@ResponseBody
	@RequestMapping(value = "uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file) throws Exception {
		File uploadFolder = new File(uploadPath,getFolder());
		logger.info("파일 업로드 폴더" + uploadFolder);
		
		//폴더 생성
		// exists() : 해당 경로가 존재하는지 판별
		if(uploadFolder.exists() == false) {
			uploadFolder.mkdirs();	// 경로에 폴더가 없다면 생성
		}
		for (MultipartFile files : file) {
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File 저장 위치 : " + uploadPath);
			
			String uploadFileName = files.getOriginalFilename();
			
			UUID uid = UUID.randomUUID();
			
			uploadFileName = uid.toString()+"_"+uploadFileName;
			
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				files.transferTo(saveFile);
				
				// 썸네일 만들어주는 구문
				if(checkImageType(saveFile)) {
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "s_" + uploadFileName));
					Thumbnailator.createThumbnail(files.getInputStream(), thumbnail, 100, 100);
					thumbnail.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				logger.info(e.getMessage());
			}
		}

		return new ResponseEntity<String>("Upload 성공!", HttpStatus.CREATED);
	}

//	private String uploadFile(String originaName, byte[] fileData) throws

}
