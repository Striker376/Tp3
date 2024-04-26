package com.example.appweb3.web;



import com.example.appweb3.entities.Patient;
import com.example.appweb3.repos.patientrepos;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private patientrepos repos;
    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name="page",defaultValue = "0")int page,
                        @RequestParam(name="size",defaultValue = "3") int size,
                        @RequestParam(name="keyword",defaultValue = "") String keyword
                        ){
        Page<Patient> Pagepatient = repos.findByNomContains(keyword,PageRequest.of(page,size));
        //Page<Patient> Pagepatient = repos.findAll(PageRequest.of(page,size));
        model.addAttribute("listPatient",Pagepatient.getContent());
        model.addAttribute("pages",new int[Pagepatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patient";
    }
    @GetMapping("/delete")
    public String delete(Long Id,String keyword,int page){
        repos.deleteById(Id);
        return "redirect:/index?page="+page+"&keyword="+keyword;
    }
}
