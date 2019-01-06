package com.partslistM.controllers;

import com.partslistM.entity.PartsList;
import com.partslistM.repository.PartRepository;
import com.partslistM.service.PartsListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class PartsListController {
    private PartsListService partsListService;
    private String sortMethod = "ASC";
    private String stringFromSearchForm ="";

    @Autowired
    private PartRepository repository;

    @Autowired
    public void setPartsListService(PartsListService partsListService) {
        this.partsListService = partsListService;
    }

    @GetMapping("/")
    public String partsList(Model model, @RequestParam(defaultValue = "0") int page) throws IOException {
        List<PartsList> partslist = filterAndSortByName(page);

        model.addAttribute("parts", partslist);
        model.addAttribute("sort", sortMethod);
        model.addAttribute("data", repository.findAll(new PageRequest(page,10)));
        computers(model);

        return "index";
    }

    @GetMapping("/new")
    public String newPart() {
        return "operations/new";
    }

    @PostMapping("/update")
    public String save(@RequestParam int id, @RequestParam String name, @RequestParam boolean need, @RequestParam int quantity) {
        partsListService.update(id,name,need,quantity);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String update(@RequestParam String name,
                             @RequestParam boolean needs, @RequestParam int quantity ) {
        partsListService.save(new PartsList(name,needs,quantity));
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String SearchName(@RequestParam("ser") String name){
        sortMethod = "x";
        stringFromSearchForm = name;

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        this.partsListService.delete(id);

        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        PartsList part = partsListService.getPartById(id);
        model.addAttribute("part", part);

        return "operations/edit";
    }

    @GetMapping("/sort/{sortByName}")
    public String sortChoose(@PathVariable String sortByName) {
        sortMethod = sortByName;
        return "redirect:/";
    }

    @GetMapping("computers")
    public String computers(Model model) {
        List<PartsList> comps = partsListService.findAllByNeedTrueOrderByQuantityAsc();
        int assembly = comps.get(0).getQuantity();

        model.addAttribute("comps", comps);
        model.addAttribute("assembly",assembly);

        return "redirect:/";
    }

    private List<PartsList> filterAndSortByName(int page) throws IOException {
        List<PartsList> part = null;
        System.out.println(sortMethod);
        switch (sortMethod) {
            case "ASC":
                part = partsListService.findAllByOrderByNameAsc(new PageRequest(page,10));
                break;
            case "DESC":
                part = partsListService.findAllByOrderByNameDesc(new PageRequest(page,10));
                break;
            case "true":
                part = partsListService.findAllByNeedTrueOrderByNeed(new PageRequest(page,10));

                break;
            case "false":
                part = partsListService.findAllByNeedFalseOrderByNeed(new PageRequest(page,10));

                break;
            case "x":
                part = partsListService.findAllByNameContainsOrderByName(stringFromSearchForm,new PageRequest(page,10));
                sortMethod ="ASC";
                break;
            default:
                part = partsListService.findAllByOrderByNameAsc(new PageRequest(page,10));
        }
        return part;
    }



}
