package com.balkiss.produits.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balkiss.produits.entities.Marque;
import com.balkiss.produits.entities.Pc;
import com.balkiss.produits.service.MarqueService;
import com.balkiss.produits.service.PcService;

@Controller
public class PcController {
@Autowired
PcService pcService;
@Autowired
MarqueService marqueService;

@RequestMapping("/showCreatePC")
public String showCreate(ModelMap modelMap)
{
List<Marque> marqs =	marqueService.getAllMarques();

modelMap.addAttribute("pc", new Pc());
modelMap.addAttribute("marqs", marqs);
return "createPc";
}


@RequestMapping("/savePc")
public String savePc(@Valid Pc pc,
 BindingResult bindingResult, ModelMap modelMap)
{
if (bindingResult.hasErrors()) return "createPc";

pcService.savePc(pc);
Page<Pc> pcs=this.pcService.getAllPcsParPage(0, 2);
modelMap.addAttribute("pcs", pcs);
modelMap.addAttribute("pages", new int[pcs.getTotalPages()]);
return "createPc";
}

@RequestMapping("/ListePcs")
public String listePcs(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "4") int size)
{
Page<Pc> ppcs = pcService.getAllPcsParPage(page, size);
modelMap.addAttribute("pcs", ppcs);
 modelMap.addAttribute("pages", new int[ppcs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listePcs";
}
@RequestMapping("/supprimerPc")
public String supprimerPc(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
pcService.deletePcById(id);
Page<Pc> ppcs = pcService.getAllPcsParPage(page, 
size);
modelMap.addAttribute("pcs", ppcs);
modelMap.addAttribute("pages", new int[ppcs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listePcs";
}
@RequestMapping("/modifierPc")
public String editerPc(@RequestParam("id") Long id,ModelMap modelMap)
{
	List<Marque> marqs =	marqueService.getAllMarques();

	modelMap.addAttribute("marqs", marqs);
Pc p= pcService.getPc(id);
modelMap.addAttribute("pc", p);
return "editerPc";
}
@RequestMapping("/updatePc")
public String updatePc(@ModelAttribute("pc") Pc pc,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size) throws ParseException
{
	

 
 pcService.updatePc(pc);
 Page<Pc> ppcs = pcService.getAllPcsParPage(page, size);
 modelMap.addAttribute("pcs", ppcs);
  modelMap.addAttribute("pages", new int[ppcs.getTotalPages()]);
return "listePcs";
}


}


