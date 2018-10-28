package com.waverley.tracker.controllers;

import com.waverley.tracker.dto.DeviceDTO;
import com.waverley.tracker.service.api.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/searchDeviceAjax", method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceDTO> findUserAJAX(String name) {
        List<DeviceDTO> deviceDTOList = deviceService.findDevice(name);
        return deviceDTOList;
    }

    @RequestMapping(value = "/detailDeviceInformations", method = RequestMethod.GET)
    public ModelAndView detailUserInformation(HttpServletRequest request) {
        ModelAndView modelAndView = deviceService.findetailDeviceInformations(request);
        return modelAndView;
    }

    @RequestMapping(value = "/findAllDevicesAJAX", method = RequestMethod.GET)
    @ResponseBody
    public List<DeviceDTO> findAlldeviceListAJAX() {
        List<DeviceDTO> deviceDTOList = deviceService.findAllDevice();
        return deviceDTOList;
    }
}


