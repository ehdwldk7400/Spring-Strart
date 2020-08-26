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
		logger.info("���� ���ε� ȭ��");
	}

	@RequestMapping(value = "uploadForm", method = RequestMethod.POST)
	public void uploadForm(MultipartFile[] file, Model model) throws Exception {
		for (MultipartFile files : file) {
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File ���� ��ġ : " + uploadPath);
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

	// ��/��/�� ���� ���� �޼���
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		
		System.out.println("���� ��¥ : " + str);
		
		return str.replace("-", File.separator);
	}

	@RequestMapping(value = "uploadAjax", method = RequestMethod.GET)
	public void uploadAjax() {
		logger.info("���� ���ε� ajax ȭ��");
	}
	
	// �̹��� ������ �Ǵ��� ���ְ� �ϴ� �޼���
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
		logger.info("���� ���ε� ����" + uploadFolder);
		
		//���� ����
		// exists() : �ش� ��ΰ� �����ϴ��� �Ǻ�
		if(uploadFolder.exists() == false) {
			uploadFolder.mkdirs();	// ��ο� ������ ���ٸ� ����
		}
		for (MultipartFile files : file) {
			logger.info("originalName : " + files.getOriginalFilename());
			logger.info("File Size : " + files.getSize());
			logger.info("ContentType : " + files.getContentType());
			logger.info("File ���� ��ġ : " + uploadPath);
			
			String uploadFileName = files.getOriginalFilename();
			
			UUID uid = UUID.randomUUID();
			
			uploadFileName = uid.toString()+"_"+uploadFileName;
			
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				files.transferTo(saveFile);
				
				// ����� ������ִ� ����
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

		return new ResponseEntity<String>("Upload ����!", HttpStatus.CREATED);
	}

//	private String uploadFile(String originaName, byte[] fileData) throws

}
