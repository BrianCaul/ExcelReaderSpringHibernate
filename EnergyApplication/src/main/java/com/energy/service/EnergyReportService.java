package com.energy.service;

import java.util.List;

import com.energy.model.EnergyReport;

public interface EnergyReportService {

  public void addEnergyReport(EnergyReport EnergyReport);

  public void updateEnergyReport(EnergyReport EnergyReport);

  public EnergyReport getEnergyReport(int id);

  public void deleteEnergyReport(int id);

  public List<EnergyReport> getEnergyReports();

}
