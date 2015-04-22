package com.energy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.energy.model.EnergyReport;
import com.energy.service.EnergyReportService;

@Controller
@RequestMapping(value = "/energyreport")
public class EnergyReportController {

  @Autowired
  private EnergyReportService EnergyReportService;

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public ModelAndView addEnergyReportPage() {
    ModelAndView modelAndView = new ModelAndView("home");
    try {
      FileInputStream file = new FileInputStream(new File("C:\\new.xlsx"));

      // Create Workbook instance holding reference to .xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(file);

      // Get first/desired sheet from the workbook
      XSSFSheet sheet = workbook.getSheetAt(0);

      // Iterate through each rows one by one
      Iterator<Row> rowIterator = sheet.iterator();
      while (rowIterator.hasNext()) {
        EnergyReport rep = new EnergyReport();
        Row row = rowIterator.next();

        rep.setName(row.getCell(0).getStringCellValue());
        rep.setRating((int) row.getCell(1).getNumericCellValue());

        EnergyReportService.addEnergyReport(rep);

      }
      file.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    String message = "EnergyReport was successfully added.";
    modelAndView.addObject("message", message);

    return modelAndView;
  }

  @RequestMapping(value = "/list")
  public ModelAndView listOfEnergyReports() {
    ModelAndView modelAndView = new ModelAndView("list-of-energyreports");

    List<EnergyReport> EnergyReports = EnergyReportService.getEnergyReports();
    modelAndView.addObject("EnergyReports", EnergyReports);

    return modelAndView;
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public ModelAndView deleteEnergyReport(@PathVariable Integer id) {
    ModelAndView modelAndView = new ModelAndView("home");
    EnergyReportService.deleteEnergyReport(id);
    String message = "EnergyReport was successfully deleted.";
    modelAndView.addObject("message", message);
    return modelAndView;
  }

}
