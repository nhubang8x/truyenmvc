package com.apt.truyenmvc.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Huy Thang
 *
 */
public class ImageUtils {

	public static String uploadFile(MultipartFile multipartFile, HttpServletRequest request) {
		try {
//			String path = request.getServletContext().getRealPath(ConstantsUtils.UPLOAD_FOLDER);
//			System.out.println(path);
//			File folder = new File(path);
//			if (!folder.exists()) {
//				folder.mkdirs();
//			}
//			String fileName = multipartFile.getOriginalFilename();
//			String newFile = FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "."
//					+ FilenameUtils.getExtension(fileName);
//
//			File file = new File(folder, newFile);
//			multipartFile.transferTo(file);
//			System.out.println(newFile);
//			return newFile;
            return null;
		} catch (Exception e) {
			System.out.println("Có lỗi: " + e.getMessage());
			return null;
		}
	}

	public static boolean deleteFile(String fileName, HttpServletRequest request) {
//		String path = request.getServletContext().getRealPath(ConstantsUtils.UPLOAD_FOLDER);
//		File file = new File(path + "\\" + fileName);
//		if (file.delete()) {
//			return true;
//		}
		return false;

	}

}
