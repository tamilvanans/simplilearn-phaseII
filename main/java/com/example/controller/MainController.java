package com.example.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.ClassesRepository;
import com.example.repository.StudentDetailsRepository;
import com.example.repository.StudentsRepository;
import com.example.repository.SubjectsRepository;
import com.example.repository.TeacherDetailsRepository;
import com.example.repository.TeachersRepository;
import com.example.vo.ClassVO;
import com.example.vo.StudentDetailsVO;
import com.example.vo.StudentVO;
import com.example.vo.SubjectVO; 
import com.example.vo.TeacherDetailsVO;
import com.example.vo.TeacherVO;

/**
 * This is main controller for all incoming request
 * @author Tamil
 *
 */
@Controller
public class MainController {

	@RequestMapping(value = "/Welcome")
	// @ResponseBody
	public String welcomePage() {
		return "AdminLogin";
	}

	@RequestMapping(value = "/ValidLogin")
	public String validateAdminLogin(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		if ("admin".equals(username) && "password".equals(password)) {
			return "StudStaffMenu";
		} else {
			return "InvalidLogin";
		}
	}

	@Autowired
	private TeachersRepository teachersRepo;

	@Autowired
	private StudentsRepository studentsRepo;

	@Autowired
	private ClassesRepository classesRepo;

	@Autowired
	private SubjectsRepository subjectsRepo;

	@Autowired
	private TeacherDetailsRepository staffDtlsRepo;

	@Autowired
	private StudentDetailsRepository studDtlsRepo;

	@GetMapping(value = "/maintStaffList")
	@Transactional
	public String doMastStaffMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "staffId", required = false) String staffId) {
		List<TeacherVO> teacherList = teachersRepo.findAll();
		model.addAttribute("TeacherMaster", teacherList);

		if ("AddMod".equals(operation)) {
			TeacherVO teacher = teachersRepo.findByStaffId(staffId);
			model.addAttribute("TeacherData", teacher);
			return "StaffMasterMaint";
		} else if ("Delete".equals(operation)) {
			int cnt = teachersRepo.deleteByStaffId(staffId);
			teacherList = teachersRepo.findAll();
			model.addAttribute("TeacherMaster", teacherList);
			return "StaffMasterView";
		} else {
			return "StaffMasterView";
		}
	}

	@GetMapping(value = "/maintStudList")
	@Transactional
	public String doMastStudMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "rollNo", required = false) String rollNum) {
		List<StudentVO> studentList = studentsRepo.findAll();
		model.addAttribute("StudentMaster", studentList);

		if ("AddMod".equals(operation)) {
			StudentVO student = studentsRepo.findByStudentId(rollNum);
			model.addAttribute("StudentData", student);
			return "StudMasterMaint";
		} else if ("Delete".equals(operation)) {
			int cnt = studentsRepo.deleteByStudentId(rollNum);
			studentList = studentsRepo.findAll();
			model.addAttribute("StudentMaster", studentList);
			return "StudMasterView";
		} else {
			return "StudMasterView";
		}
	}

	@GetMapping(value = "/maintClassList")
	@Transactional
	public String doMastClassMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "classId", required = false) String classId) {
		List<ClassVO> classList = classesRepo.findAll();
		model.addAttribute("ClassMaster", classList);

		if ("AddMod".equals(operation)) {
			ClassVO classes = classesRepo.findByClassId(classId);
			model.addAttribute("ClassData", classes);
			return "ClassMasterMaint";
		} else if ("Delete".equals(operation)) {
			int cnt = classesRepo.deleteByClassId(classId);
			classList = classesRepo.findAll();
			model.addAttribute("ClassMaster", classList);
			return "ClassMasterView";
		} else {
			return "ClassMasterView";
		}
	}

	@GetMapping(value = "/maintSubjectList")
	@Transactional
	public String doMastSubjMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "subjectId", required = false) String subjectId) {
		List<SubjectVO> subjectList = subjectsRepo.findAll();
		model.addAttribute("SubjectMaster", subjectList);

		if ("AddMod".equals(operation)) {
			SubjectVO subject = subjectsRepo.findBySubjectId(subjectId);
			model.addAttribute("SubjectData", subject);
			return "SubMasterMaint";
		} else if ("Delete".equals(operation)) {
			int cnt = subjectsRepo.deleteBySubjectId(subjectId);
			subjectList = subjectsRepo.findAll();
			model.addAttribute("ClassMaster", subjectList);
			return "SubMasterView";
		} else {
			return "SubMasterView";
		}
	}

	@GetMapping(value = "/mastStaffMaint")
	public String doMastStaffMaint(@RequestParam("staffId") String staffId,
			@RequestParam("staffName") String staffName) {
		TeacherVO teacherVO = new TeacherVO();
		teacherVO.setStaffId(staffId);
		teacherVO.setStaffName(staffName);
		teachersRepo.save(teacherVO);

		return "MaintSuccess";
	}

	@GetMapping(value = "/mastStudMaint")
	public String doMastStudMaint(@RequestParam("rollNo") String rollNo, @RequestParam("studName") String studName) {
		StudentVO studentVO = new StudentVO();
		studentVO.setStudentId(rollNo);
		studentVO.setStudentName(studName);
		studentsRepo.save(studentVO);
		return "MaintSuccess";
	}

	@GetMapping(value = "/mastClassMaint")
	public String doMastClassMaint(@RequestParam("classId") String classId,
			@RequestParam("classDesc") String classDesc) {
		ClassVO classVO = new ClassVO();
		classVO.setClassId(classId);
		classVO.setClassDesc(classDesc);
		classesRepo.save(classVO);

		return "MaintSuccess";
	}

	@GetMapping(value = "/mastSubMaint")
	public String doMastSubMaint(@RequestParam("subjectId") String subjectId,
			@RequestParam("subjectName") String subjectName) {
		SubjectVO subjectVO = new SubjectVO();
		subjectVO.setSubjectId(subjectId);
		subjectVO.setSubjectName(subjectName);
		subjectsRepo.save(subjectVO);

		return "MaintSuccess";
	}

	@GetMapping(value = "/doStaffMaint")
	public String doStaffMaint(Model model) {
		List<ClassVO> classList = classesRepo.findAll();
		model.addAttribute("Classes", classList);

		List<SubjectVO> subjectList = subjectsRepo.findAll();
		model.addAttribute("Subjects", subjectList);

		List<TeacherVO> teacherList = teachersRepo.findAll();
		model.addAttribute("Teachers", teacherList);

		return "StaffMaint";
	}

	@GetMapping(value = "/doStudMaint")
	public String doStudMaint(Model model) {
		List<StudentVO> studentList = studentsRepo.findAll();
		model.addAttribute("Students", studentList);

		List<ClassVO> classList = classesRepo.findAll();
		model.addAttribute("Classes", classList);

		List<SubjectVO> subjectList = subjectsRepo.findAll();
		model.addAttribute("Subjects", subjectList);

		return "StudMaint";
	}

	@PostMapping(value = "/SubmitStudent")
	public String saveStudentMaint(@RequestParam("student") String student, @RequestParam("class") String classId,
			@RequestParam("subject") String subject) {
		StudentDetailsVO studentDetailsVO = new StudentDetailsVO();

		studentDetailsVO.setId(studDtlsRepo.getNextSeriesId());
		studentDetailsVO.setRollNo(student);
		studentDetailsVO.setClassId(classId);
		studentDetailsVO.setSubjectId(subject);

		studDtlsRepo.save(studentDetailsVO);

		return "MaintSuccess";
	}

	@PostMapping(value = "/SubmitTeacher")
	public String saveTeacherMaint(@RequestParam("teacher") String teacher, @RequestParam("classId") String classId,
			@RequestParam("subject") String subject) {
		TeacherDetailsVO teacherDetailsVO = new TeacherDetailsVO();

		teacherDetailsVO.setId(staffDtlsRepo.getNextSeriesId());
		teacherDetailsVO.setEmpId(teacher);
		teacherDetailsVO.setClassId(classId);
		teacherDetailsVO.setSubjectId(subject);

		staffDtlsRepo.save(teacherDetailsVO);

		return "MaintSuccess";
	}

	@GetMapping(value = "/viewStudMaint")
	@Transactional
	public String viewStudMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "student", required = false) String Id) {
		List<StudentDetailsVO> studDtlsList = null;

		if ("AddMod".equals(operation)) {
			List<StudentVO> studentList = studentsRepo.findAll();
			model.addAttribute("Students", studentList);

			List<ClassVO> classList = classesRepo.findAll();
			model.addAttribute("Classes", classList);

			List<SubjectVO> subjectList = subjectsRepo.findAll();
			model.addAttribute("Subjects", subjectList);

			return "StudMaint";
		} else if ("Delete".equals(operation)) {
			studDtlsRepo.deleteById(new Long(Id));
			studDtlsList = (List<StudentDetailsVO>) studDtlsRepo.findAll();
			model.addAttribute("StudentDetails", studDtlsList);
			return "ViewStudMaint";
		} else {
			studDtlsList = (List<StudentDetailsVO>) studDtlsRepo.findAll();
			model.addAttribute("StudentDetails", studDtlsList);
			return "ViewStudMaint";
		}

	}

	@GetMapping(value = "/viewStaffMaint")
	@Transactional
	public String viewStaffMaint(Model model, @RequestParam(value = "action", required = false) String operation,
			@RequestParam(value = "teacher", required = false) String teacher) {
		List<TeacherDetailsVO> staffDtlsList = null;

		if ("AddMod".equals(operation)) {
			List<ClassVO> classList = classesRepo.findAll();
			model.addAttribute("Classes", classList);

			List<SubjectVO> subjectList = subjectsRepo.findAll();
			model.addAttribute("Subjects", subjectList);

			List<TeacherVO> teacherList = teachersRepo.findAll();
			model.addAttribute("Teachers", teacherList);

			return "StaffMaint";
		} else if ("Delete".equals(operation)) {
			staffDtlsRepo.deleteById(new Long(teacher));
			staffDtlsList = (List<TeacherDetailsVO>) staffDtlsRepo.findAll();
			model.addAttribute("TeacherDetails", staffDtlsList);
			return "ViewStaffMaint";
		} else {
			staffDtlsList = (List<TeacherDetailsVO>) staffDtlsRepo.findAll();
			model.addAttribute("TeacherDetails", staffDtlsList);

			return "ViewStaffMaint";
		}

	}
}
