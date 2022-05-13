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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
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

import com.mycompany.springmvchibernate.AnnotationValidator.UploadFileImageMaxSize;
import com.mycompany.springmvchibernate.Config.FileUploadUtil;
import com.mycompany.springmvchibernate.DTO.ChiTietSanPhamDTO;
import com.mycompany.springmvchibernate.DTO.FileImageUploadForm;
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
import com.mycompany.springmvchibernate.Service.Convert.SanPhamConvert;
import com.mycompany.springmvchibernate.Service.Impl.ChipService;
import com.mycompany.springmvchibernate.SpringValidator.FileValidator;
import com.mycompany.springmvchibernate.ValidationGroups.LoaiCheck;
import com.mycompany.springmvchibernate.ValidationGroups.SanPhamCheck;

@Controller
@RequestMapping(value = "/quan-tri/product")
//@PropertySource("classpath:hibernate-config.properties") //main/resource/hibernate-config.properties

@PropertySources(value = { @PropertySource("classpath:application.properties"),
		@PropertySource("classpath:env/application-${spring.profiles.active}.properties") })
public class SanPhamController {

	@Value("${log.file.location}")
	private String stratehy;
	@Value("${email}")
	private String active;
	@Value("${spring.profiles.active}")
	private String profile;

	@Value("${successMessage}")
	private String successMessage;

	@Value("${failedMessage}")
	private String failedMessage;
	@Autowired
	Environment env;

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

	/*
	 * @Autowired FileValidator fileValidator;
	 * 
	 * @InitBinder("multipartFile") protected void
	 * initBinderFileBucket(WebDataBinder binder) {
	 * binder.setValidator(fileValidator); }
	 */

	@RequestMapping(value = "/danh-sach", method = RequestMethod.GET)
	public ModelAndView danhSachSanPham(@RequestParam(name = "message", required = false) String message) {

		ModelAndView mav = new ModelAndView("/admin/product/list");
		List<SanPhamDTO> listSanPham = sanPhamService.findAll();
		List<HinhAnhSP> listHinh = hinhAnh.findAll();
		// List<HinhAnhDTO> listHinhDTO = new ArrayList<>();

		for (HinhAnhSP hinhAnhSP : listHinh) {
			System.out.println("file anh " + hinhAnhSP.getPhotosImagePath());
		}
		if (message != null) {
			if (message.equals("")) {
			}
		}
		mav.addObject("clickDDH", "true");
		mav.addObject("listHinhAnh", listHinh);
		mav.addObject("listSanPham", listSanPham);
		System.out.println(
				"active active active active active active active active active active active active active active active"
						+ active + "    " + profile + "    " + stratehy);
		return mav;

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPageUpdateOrInsert(@RequestParam(required = false) String id,
			@RequestParam(name = "type", required = true) String type,
			@RequestParam(name = "message", required = false) String message) {
		ModelAndView mav;
		if (message != null) {
			if (message.equals(successMessage)) {
				message = "Thành công";
			} else {
				message = "Thất bại";
			}
		}

		if (id != null && type.equals("edit")) {
			SanPhamDTO sanPhamDTO = sanPhamService.findOneById(Integer.parseInt(id));
			if (sanPhamDTO != null) {
				mav = new ModelAndView("/admin/product/edit");
				mav.addObject("message", message);
				List<Loai> loais = loaiRepo.findAll();
				mav.addObject("sanPham", sanPhamDTO);
				mav.addObject("listLoai", loais);
				mav.addObject("sanPhamFormData", sanPhamDTO);
				return mav;
			}
		} else if (type.equals("add")) {
			mav = new ModelAndView("/admin/product/addItem");
			mav.addObject("message", message);
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

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String processUpdateSanPham(@RequestParam(name = "id", required = true) Integer id,
			@ModelAttribute(name = "sanPham") @Validated({ SanPhamCheck.class, Default.class }) SanPhamDTO sanPhamDTO,
			BindingResult result, HttpServletRequest req, HttpServletResponse res, Model model)
			throws SanPhamNotFoundException {

		if (result.hasErrors()) {
			List<Loai> loais = loaiRepo.findAll();
			// model.addAttribute("sanPham", sanPhamDTO);
			model.addAttribute("listLoai", loais);
			return "admin/product/edit";
		}
		if (sanPhamService.findOneById(id) == null) {
			throw new SanPhamNotFoundException(id);
		}
		System.out.println(sanPhamDTO.getLoai().getTen());
		SanPhamDTO sanPham = sanPhamService.update(sanPhamDTO);
		// res.sendRedirect(req.getContextPath() + "/quan-tri/product/danh-sach");
		// return mav;
		return "redirect:/quan-tri/product?id=" + id + "&type=edit" + "&message=" + successMessage;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String processDeleteSanPham(@RequestParam(name = "sanPhamIDs") Integer[] ids) {

		sanPhamService.delete(ids);
		// sanPhamService.delete(ids[0]);
		return "redirect:/quan-tri/product/danh-sach";

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
	public String addProduct(@ModelAttribute(name = "sanPhamDTO") SanPhamDTO sanPhamDTO) throws IOException {

		String fileName = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(0).getOriginalFilename());
		String fileName1 = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(1).getOriginalFilename());
		String fileName2 = StringUtils.cleanPath(sanPhamDTO.getHinhAnhs().get(2).getOriginalFilename());
		List<HinhAnhDTO> listHinh = new ArrayList<HinhAnhDTO>();
		listHinh.add(new HinhAnhDTO(fileName));
		listHinh.add(new HinhAnhDTO(fileName1));
		listHinh.add(new HinhAnhDTO(fileName2));
		for (Iterator<HinhAnhDTO> iterator = listHinh.iterator(); iterator.hasNext();) {
			HinhAnhDTO hinhAnhDTO = (HinhAnhDTO) iterator.next();
			if (!hinhAnhDTO.getHinhAnh().isEmpty()) {
				sanPhamDTO.addHinhAnh(hinhAnhDTO);
			}
		}
		List<ChiTietSanPhamDTO> chiTietSanPhamDTO = sanPhamDTO.getChiTietSanPhams();
		for (Iterator<ChiTietSanPhamDTO> iterator = chiTietSanPhamDTO.iterator(); iterator.hasNext();) {
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
		 * FileUploadUtil.saveFile(uploadDir,fileName,sanPhamDTO.getHinhAnhs(). get(0));
		 * uploadDir="product-photos/" + sanPhamDTO.getTen();
		 * FileUploadUtil.saveFile(uploadDir,fileName1,sanPhamDTO.getHinhAnhs().
		 * get(1));
		 */

		return "redirect:/quan-tri/product/danh-sach?page=1&limit=10";
	}

	@RequestMapping(value = "upload_ckeditor", method = RequestMethod.POST)
	public ResponseEntity<JsonFileUpload> uploadCKEditor(@RequestParam("upload") MultipartFile upload,
			HttpServletRequest rq) {
		try {

			String fileName = upload.getOriginalFilename();
			// Path uploadPath=Paths.get(FileUploadUtil.UPLOADED_FOLDER+"product-photos");
			Path uploadPath = Paths.get(rq.getSession().getServletContext().getRealPath("/WEB-INF/uploads").toString());
			if (!Files.exists(uploadPath)) {
				// tạo mới
				Files.createDirectories(uploadPath);
			}
			try {
				InputStream inputStream = upload.getInputStream();
				Path filePath = uploadPath.resolve(fileName); //
				System.out.println(filePath.toFile().getAbsolutePath());
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

			} catch (IOException e) {
				throw new IOException("Could not save image file: " + fileName, e);
			}

			return new ResponseEntity<>(new JsonFileUpload("/uploads/" + fileName), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@RequestMapping(value = "/image", method = RequestMethod.POST)
	public String processUploadImage(@ModelAttribute("hinhAnh") @Validated FileImageUploadForm image,
			BindingResult result, @RequestParam(value = "id", required = false) Integer id,
			@RequestParam("type") String type, @RequestParam("idSanPham") Integer idSanPham, Model model) {
		if (result.hasErrors()) {
			HinhAnhSP hinhAnhDTO = hinhAnh.findById(id);
			model.addAttribute("hinh",hinhAnhDTO);
			model.addAttribute("idSanPham", idSanPham);
			if (type.equals("edit")) {
				model.addAttribute("type", "edit");

			} else if (type.equals("add")) {
				model.addAttribute("type", "add");
			}
			return "admin/product/editImage";
		
		}
		// return "quan-tri/product/image/edit?id=4106&type=edit
		// edit?id=4106&type=edit";

		MultipartFile multipartFile = image.getMultipartFile();
		String nameFile = image.getMultipartFile().getOriginalFilename();

		if (type.equals("edit") && id != null) {
			HinhAnhSP hinhAnhDTO = hinhAnh.findById(id);
			String nameProduct = hinhAnhDTO.getSanPham().getTen();
			String uploadDir = "/product-photos/" + nameProduct;
			String nameFileOld = hinhAnhDTO.getHinhAnh();
			System.out.println("name file " + nameFile);
			try {
				FileUploadUtil.deleteFile(uploadDir, nameFileOld);
				FileUploadUtil.saveFile(uploadDir, nameFile, multipartFile);
				hinhAnhDTO.setHinhAnh(nameFile);
				HinhAnhSP hinhAnhDTOnew = hinhAnh.update(hinhAnhDTO);
				System.out.println("hinh anh name:" + hinhAnhDTOnew.getHinhAnh());
				System.out.println("hinh anh name:" + hinhAnhDTOnew.getId());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (type.equals("add")) {
			try {
				HinhAnhDTO hinhAnhNew = new HinhAnhDTO();
				SanPhamDTO sanPhamDTO = sanPhamService.findOneById(idSanPham);

				String uploadDir = "/product-photos/" + sanPhamDTO.getTen();
				if (sanPhamDTO != null) {
					hinhAnhNew.setHinhAnh(nameFile);
					sanPhamDTO.addHinhAnh(hinhAnhNew);
					FileUploadUtil.saveFile(uploadDir, nameFile, multipartFile);
					sanPhamService.update(sanPhamDTO);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/quan-tri/trang-chu";
	}

	@RequestMapping(value = "/image/edit", method = RequestMethod.GET)
	public ModelAndView showImageEditPage(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "idSanPham", required = false) Integer idSanPham,
			@RequestParam(value = "type") String type) {

		ModelAndView mav = new ModelAndView("admin/product/editImage");
		mav.addObject("hinhAnh", new FileImageUploadForm());
		if (id != null) {
			HinhAnhSP hinhAnhDTO = hinhAnh.findById(id);
			mav.addObject("hinh", hinhAnhDTO);
		}

		mav.addObject("type", type);
		mav.addObject("idSanPham", idSanPham);

		return mav;

	}
	// Handle Exception

	/*
	 * @ExceptionHandler(SanPhamNotFoundException.class) public ModelAndView
	 * handleSanPhamNotFoundException(HttpServletRequest request,Exception ex) {
	 * ModelAndView mav=new ModelAndView("error"); mav.addObject("exception", ex);
	 * mav.addObject("url",request.getRequestURI()); return null; }
	 */

	/*
	 * @ExceptionHandler(SanPhamNotFoundException.class) public @ResponseBody
	 * ResponseEntity<Exception> handleSanPhamNotFoundEx(HttpServletRequest
	 * request,Exception ex) { return ResponseEntity.badRequest().body(ex); }
	 */

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
