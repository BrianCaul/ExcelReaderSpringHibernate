package com.energy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.energy.model.EnergyReport;

@Repository
public class EnergyReportDAOImpl implements EnergyReportDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public void addEnergyReport(EnergyReport EnergyReport) {
    getCurrentSession().save(EnergyReport);
  }

  public void updateEnergyReport(EnergyReport EnergyReport) {
    EnergyReport EnergyReportToUpdate = getEnergyReport(EnergyReport.getId());
    EnergyReportToUpdate.setName(EnergyReport.getName());
    EnergyReportToUpdate.setRating(EnergyReport.getRating());
    getCurrentSession().update(EnergyReportToUpdate);

  }

  public EnergyReport getEnergyReport(int id) {
    EnergyReport EnergyReport = (EnergyReport) getCurrentSession().get(EnergyReport.class, id);
    return EnergyReport;
  }

  public void deleteEnergyReport(int id) {
    EnergyReport EnergyReport = getEnergyReport(id);
    if (EnergyReport != null)
      getCurrentSession().delete(EnergyReport);
  }

  @SuppressWarnings("unchecked")
  public List<EnergyReport> getEnergyReports() {
    return getCurrentSession().createQuery("from EnergyReport").list();
  }

}
