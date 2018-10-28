package com.waverley.tracker.controllers;

import com.waverley.tracker.dto.HistoryDTO;
import com.waverley.tracker.service.api.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

@Controller
public class HistoryController {

    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/showHistoryAjax", method = RequestMethod.GET)
    @ResponseBody
    public List<HistoryDTO> showHistoryAjax() {
        List<HistoryDTO> eventListDTO = historyService.showAllEvant();
        return eventListDTO;
    }

    @RequestMapping(value = "/findEventAjax", method = RequestMethod.GET)
    @ResponseBody
    public  List<HistoryDTO> findEventAjax(@Valid String typeUserSearch, String typeDeviceSearch, String userInput, String deviceInput, String firstData, String lastData, String event) {
        List<HistoryDTO> eventListDTO = (List<HistoryDTO>) historyService.searchEvent(typeUserSearch, typeDeviceSearch, userInput, deviceInput, firstData, lastData, event);
        return eventListDTO;
    }
}





