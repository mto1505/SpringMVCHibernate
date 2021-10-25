package com.mycompany.springmvchibernate.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mycompany.springmvchibernate.Config.FileUploadUtil;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.HinhAnhDTO;
import com.mycompany.springmvchibernate.DTO.JsonFileUpload;
import com.mycompany.springmvchibernate.DTO.SanPhamDTO;
import com.mycompany.springmvchibernate.Entity.BoNho;
import com.mycompany.springmvchibernate.Entity.Chip;
import com.mycompany.springmvchibernate.Entity.HinhAnhSP;
import com.mycompany.springmvchibernate.Entity.Loai;
import com.mycompany.springmvchibernate.Entity.Mau;
import com.mycompany.springmvchibernate.Entity.Ram;
import com.mycompany.springmvchibernate.Entity.SanPham;
import com.mycompany.springmvchibernate.Repositories.LoaiRepository;
import com.mycompany.springmvchibernate.Service.IBoNhoService;
import com.mycompany.springmvchibernate.Service.IChipService;
import com.mycompany.springmvchibernate.Service.IHinhAnh;
import com.mycompany.springmvchibernate.Service.IMauService;
import com.mycompany.springmvchibernate.Service.IRamService;
import com.mycompany.springmvchibernate.Service.ISanPhamService;
import com.mycompany.springmvchibernate.Service.Impl.ChipService;

@Controller
@RequestMapping(value = "/quan-tri/product")
public class SanPhamController {

	@Autowired
	ISanPhamService sanPhamService;

	@Autowired
	LoaiRepository loaiRepo;

	@Autowired
	IRamService ramService;
	@Autowired
	IChipService chipService;
	@Autowired
	IMauService mauService;
	@Autowired
	IBoNhoService boNhoService;

	@Autowired
	IHinhAnh hinhAnh;

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public ModelAndView danhSachSanPham() {

		ModelAndView mav = new ModelAndView("/admin/product/list");
		List<SanPhamDTO> listSanPham = sanPhamService.findAll();
		List<HinhAnhSP> listHinh = hinhAnh.findAll();
		// List<HinhAnhDTO> listHinhDTO = new ArrayList<>();

		for (HinhAnhSP hinhAnhSP : listHinh) {
			System.out.println("file anh " + hinhAnhSP.getPhotosImagePath());
		}
		mav.addObject("clickDDH", "true");
		mav.addObject("listHinhAnh", listHinh);
		mav.addObject("listSanPham", listSanPham);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView editAnhAddSanPham(@RequestParam(required = false) String id,
			@RequestParam(name = "type", required = true) String type) {
		ModelAndView mav;
		if (!id.isEmpty() && type.equals("edit")) {
			mav = new ModelAndView("/admin/product/edit");
			SanPhamDTO sanPhamDTO = sanPhamService.findOneById(Integer.parseInt(id));
			mav.addObject("sanPham", sanPhamDTO);
			return mav;
		} else if (type.equals("add")) {
			mav = new ModelAndView("/admin/product/addItem");
			List<Loai> loais = loaiRepo.findAll();
			List<Ram> rams = ramService.findAll();
			List<BoNho> boNhos = boNhoService.findAll();
			List<Mau> maus = mauService.findAll();
			List<Chip> chips = chipService.findAll();
			mav.addObject("listLoai", loais);
			mav.addObject("rams", rams);
			mav.addObject("boNhos", boNhos);
			mav.addObject("maus", maus);
			mav.addObject("chips", chips);
			return mav;
		}
		return new ModelAndView("/admin/product/list");

	}

	@RequestMapping(method = RequestMethod.PUT)
	public void processUpdateSanPham(@RequestParam(name = "id", required = true) String id,
			@ModelAttribute(name = "sanPhamFormData") SanPhamDTO sanPhamDTO, HttpServletRequest req,
			HttpServletResponse res) throws IOException {

		// ModelAndView mav=new ModelAndView("/admin/product/edit");
		System.out.println(sanPhamDTO.getLoai().getTen());
		SanPhamDTO sanPham = sanPhamService.update(sanPhamDTO);
		res.sendRedirect(req.getContextPath() + "/quan-tri/product/danh-sach");
		// return mav;

	}

	@RequestMapping(value = "demo", method = RequestMethod.POST)
	public @ResponseBody SanPhamDTO processAddSanPham(@ModelAttribute(name = "sanPhamDTO") SanPhamDTO sanPhamDTO,
			HttpServletRequest req, HttpServletResponse res) throws IOException {

		req.setAttribute("sanPham", sanPhamDTO);

//		System.out.println(sanPhamDTO.getHinhAnhs().get(0).toString());
//		System.out.println(sanPhamDTO.getHinhAnhs().get(1).toString());
//		System.out.println(sanPhamDTO.getHinhAnhs().get(2).toString());
		// ModelAndView mav=new ModelAndView("/admin/product/edit");

		/*
		 * System.out.println(sanPhamDTO.getLoai().getTen());
		 * System.out.println(sanPhamDTO.getChiTietSanPhams().size());
		 * System.out.println("chi tiết 0 bộ nhớ  "+sanPhamDTO.getChiTietSanPhams().get(
		 * 0).getBoNho().getDungLuong());
		 * System.out.println("chi tiết 0 chip "+sanPhamDTO.getChiTietSanPhams().get(0).
		 * getChip().getTen());
		 */

		/*
		 * System.out.println("Chi tiết 1  "+sanPhamDTO.getChiTietSanPhams().get(1).
		 * getSoLuong());
		 * System.out.println("Chi tiết 1 bộ nhớ "+sanPhamDTO.getChiTietSanPhams().get(1
		 * ).getBoNho().getDungLuong());
		 * System.out.println("chi tiết 1 chip "+sanPhamDTO.getChiTietSanPhams().get(0).
		 * getChip().getTen());
		 */
		SanPhamDTO sanPham = sanPhamDTO;
		return new ResponseEntity<SanPhamDTO>(sanPham, HttpStatus.ACCEPTED).getBody();
		// return mav;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processUploadFile(@ModelAttribute(name = "sanPhamDTO") SanPhamDTO sanPhamDTO)
			throws IOException {
		ModelAndView mav = new ModelAndView("/admin/product/list");

		String hinhAnhfileName = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(0).getOriginalFilename());
		String hinhAnhfileName1 = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(1).getOriginalFilename());
		String hinhAnhfileName2 = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(2).getOriginalFilename());
		List<HinhAnhDTO> listHinh = new ArrayList<HinhAnhDTO>();
		listHinh.add(new HinhAnhDTO(hinhAnhfileName));
		listHinh.add(new HinhAnhDTO(hinhAnhfileName1));
		listHinh.add(new HinhAnhDTO(hinhAnhfileName2));
		for (Iterator iterator = listHinh.iterator(); iterator.hasNext();) {
			HinhAnhDTO hinhAnhDTO = (HinhAnhDTO) iterator.next();
			if (!hinhAnhDTO.getHinhAnh().isEmpty()) {
				sanPhamDTO.addHinhAnh(hinhAnhDTO);
			}
		}
		List<ChiTietSanPhamDTO> chiTietSanPhamDTO = sanPhamDTO.getChiTietSanPhams();
		for (Iterator iterator = chiTietSanPhamDTO.iterator(); iterator.hasNext();) {
			ChiTietSanPhamDTO chiTietSanPham = (ChiTietSanPhamDTO) iterator.next();
			chiTietSanPham.setSanPham(sanPhamDTO);
		}
		// Lưu sản phẩm
		sanPhamService.save(sanPhamDTO);
		// FILE UPLOAD ROOT DIRECTORY
		String uploadDir = "product-photos/" + sanPhamDTO.getTen();
		int i = 0;
		for (Iterator iterator = listHinh.iterator(); iterator.hasNext();) {
			HinhAnhDTO hinhAnhDTO = (HinhAnhDTO) iterator.next();
			if (!hinhAnhDTO.getHinhAnh().isEmpty()) {
				FileUploadUtil.saveFile(uploadDir, hinhAnhDTO.getHinhAnh(), sanPhamDTO.getHinhAnhs().get(i++));
			}
		}
		/*
		 * String uploadDir="product-photos/" + sanPhamDTO.getTen();
		 * FileUploadUtil.saveFile(uploadDir,hinhAnhfileName,sanPhamDTO.getHinhAnhs().
		 * get(0)); uploadDir="product-photos/" + sanPhamDTO.getTen();
		 * FileUploadUtil.saveFile(uploadDir,hinhAnhfileName1,sanPhamDTO.getHinhAnhs().
		 * get(1));
		 */

		return mav;
	}

	@RequestMapping(value = "/testException")
	public RedirectView foundSanPhan(@RequestParam(required = true) String id) throws Exception {
		RedirectView redirectView = new RedirectView("/");
		if (id.equals("123")) {
			throw new SanPhamNotFoundException(Integer.valueOf(id));
		} else {
			return redirectView;
		}

	}
	
	@RequestMapping(value="upload_ckeditor",method=RequestMethod.POST)
	public ResponseEntity<JsonFileUpload> uploadCKEditor(@RequestParam("upload") MultipartFile upload,HttpServletRequest rq)
	{
		try {	
			
			String fileName=upload.getOriginalFilename();
			//Path uploadPath=Paths.get(FileUploadUtil.UPLOADED_FOLDER+"product-photos");
			Path uploadPath=Paths.get(rq.getSession().getServletContext().getRealPath("/WEB-INF/uploads").toString());
			if(!Files.exists(uploadPath))
			{
				//tạo mới
				Files.createDirectories(uploadPath);
			}
			try {
				InputStream inputStream=upload.getInputStream();
				Path filePath=uploadPath.resolve(fileName); //
				System.out.println(filePath.toFile().getAbsolutePath());
				Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING );
				
			}
			catch(IOException e)
			{
				   throw new IOException("Could not save image file: " + fileName, e);
			}
	
		return new ResponseEntity<>(new JsonFileUpload("/uploads/"+fileName),HttpStatus.OK);
		
		}catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			
		}
		
		
	}

	//Handle Exception
/*	@ExceptionHandler(SanPhamNotFoundException.class)
	public ModelAndView handleSanPhamNotFoundException(HttpServletRequest request,Exception ex) {
		ModelAndView mav=new ModelAndView("error");
		mav.addObject("exception", ex);
		mav.addObject("url",request.getRequestURI());
		return null;
	}*/
	
	/*@ExceptionHandler(SanPhamNotFoundException.class)
	public @ResponseBody ResponseEntity<Exception> handleSanPhamNotFoundEx(HttpServletRequest request,Exception ex) {
		return ResponseEntity.badRequest().body(ex);
	}*/
	
	
	/*
	 * RequestMapping(value="/updatePersonFailed", method=RequestMethod.GET) public
	 * String updatePersonFailed() { return "personUpdate"; }
	 * 
	 * @RequestMapping(value = "/updatePerson", method = RequestMethod.POST) public
	 * String performUpdate(@ModelAttribute Person person, RedirectAttributes ←-
	 * redirectAttributes, SessionStatus sessionStatus) { String message = null;
	 * String viewName = null; try { personService.update(person); message =
	 * "Person updated. Person id :" + person.getId(); viewName =
	 * "redirect:/mvc/listPersons"; sessionStatus.setComplete(); } catch (Exception
	 * ex) { message = "Person update failed. "; viewName =
	 * "redirect:/mvc/updatePersonFailed"; }
	 * redirectAttributes.addFlashAttribute("message", message); return viewName; }
	 */
}
