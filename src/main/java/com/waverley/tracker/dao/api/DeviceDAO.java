package com.waverley.tracker.dao.api;

import com.waverley.tracker.model.Device;
import com.waverley.tracker.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface DeviceDAO extends CrudRepository <Device,Integer> {

    List<Device> findDeviceByDeviceIDOrModelNameOrSerialNumberOrTypeOSOrOSVersionOrSkreenResolutionOrScreenDiagonalOrDescriptionOrRAMOrROMOrLocation(int deviceID, String modelName, String serialNumber, String typeOS, String oSVersion, String skreenResolution, String screenDiagonal, String description, String rAM, String rOM, String location);

    @Modifying
    @Query("UPDATE Device d  SET d.user.id = NULL WHERE d.id = ?1")
    void deleteDeviceIDColumn ( Integer id);

    @Query("SELECT d FROM Device d  WHERE  d.user.id is null")
    List<Device> getFreeDevices();

    @Query("SELECT d FROM Device d  WHERE  d.user.id is NOT null ")
    List<Device> getAssignedDevices();

    @Query("SELECT d.user FROM Device d")
    Set<User> findUserId();

    List<Device> findByModelNameContaining(String modelName);
}
