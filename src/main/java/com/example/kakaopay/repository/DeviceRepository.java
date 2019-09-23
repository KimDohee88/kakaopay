package com.example.kakaopay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kakaopay.model.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

	Device findByDevicename(String device_name);
}
