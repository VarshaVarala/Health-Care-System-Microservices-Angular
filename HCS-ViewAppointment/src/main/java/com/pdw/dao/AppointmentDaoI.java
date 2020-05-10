package com.pdw.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdw.entity.Appointments;
@Repository
public interface AppointmentDaoI extends JpaRepository<Appointments,String> {

}
