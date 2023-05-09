package com.balkiss.produits.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.balkiss.produits.entities.Marque;
import com.balkiss.produits.service.MarqueService;

@Controller
public class MarqueController {
@Autowired
MarqueService marqueService;
@RequestMapping("/showCreateMarque")
public String showCreate()
{
return "createMarque";
}
@RequestMapping("/saveMarque")
public String saveMarque(@ModelAttribute("marque") Marque marque, 
 @RequestParam("date") String date,
 ModelMap modelMap) throws
ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 marque.setDateCreation(dateCreation);
 
Marque saveMarque = marqueService.saveMarque(marque);
String msg ="marque enregistrée avec Id "+saveMarque.getIdMarque();
modelMap.addAttribute("msg", msg);
return "createMarque";
}
@RequestMapping("/ListeMarques")
public String listeMarques(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "4") int size)
{
Page<Marque> marqs = marqueService.getAllMarquesParPage(page, size);
modelMap.addAttribute("marques", marqs);
 modelMap.addAttribute("pages", new int[marqs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeMarques";


}
@RequestMapping("/supprimerMarque")
public String supprimerMarque(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "2") int size)
{
marqueService.deleteMarqueById(id);
Page<Marque> marqs = marqueService.getAllMarquesParPage(page, 
size);
modelMap.addAttribute("marques", marqs);
modelMap.addAttribute("pages", new int[marqs.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeMarques";
}
@RequestMapping("/modifierMarque")
public String editerMarque(@RequestParam("id") Long id,ModelMap modelMap)
{
	
Marque m= marqueService.getMarque(id);
modelMap.addAttribute("marque", m);
return "editerMarque";
}
@RequestMapping("/updateMarque")
public String updateMarque(@ModelAttribute("marque") Marque marque,
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 marque.setDateCreation(dateCreation);
 
 marqueService.updateMarque(marque);
 List<Marque> marqs = marqueService.getAllMarques();
 modelMap.addAttribute("marques", marqs);
return "listeMarques";
}


}


