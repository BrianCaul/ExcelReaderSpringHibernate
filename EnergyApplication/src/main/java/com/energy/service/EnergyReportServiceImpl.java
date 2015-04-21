package com.energy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.energy.dao.EnergyReportDAO;
import com.energy.model.EnergyReport;

@Service
@Transactional
public class EnergyReportServiceImpl implements EnergyReportService {

  @Autowired
  private EnergyReportDAO EnergyReportDAO;

  public void addEnergyReport(EnergyReport EnergyReport) {
    EnergyReportDAO.addEnergyReport(EnergyReport);
  }

  public void updateEnergyReport(EnergyReport EnergyReport) {
    EnergyReportDAO.updateEnergyReport(EnergyReport);
  }

  public EnergyReport getEnergyReport(int id) {
    return EnergyReportDAO.getEnergyReport(id);
  }

  public void deleteEnergyReport(int id) {
    EnergyReportDAO.deleteEnergyReport(id);
  }

  public List<EnergyReport> getEnergyReports() {
    return EnergyReportDAO.getEnergyReports();
  }

}
