package com.arizon.statisticalWebClient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import model.StatisticalEntityJson;

@Controller
public class dataViewController {

    URL dataUrl;
    public dataViewController() {}

    @RequestMapping(value = "/dataview", method = RequestMethod.GET)
    public String getData(HttpServletRequest request, Model model, @RequestParam(value="caller")String caller) {
        try {
            dataUrl = new URL("http://localhost:8080/getAllEntities?caller="+caller);
            URLConnection conn = dataUrl.openConnection();
            conn.connect();
            List<StatisticalEntityJson> jsonEntities = (List<StatisticalEntityJson>) conn.getContent();


        } catch (Exception e) {
            //
        }

        return "dataView";
    }


}
