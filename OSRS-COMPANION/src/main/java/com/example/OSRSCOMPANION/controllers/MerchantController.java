package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.merchantHelp.data.ProfitLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController {

    @Autowired
    private ProfitLogDao profitLogDao;

    @RequestMapping(value="")
    public String indexRedirection(Model model,@RequestParam String logType){
        if (logType.equals("profit")){
            return displayProfitLogs(model);
        } else if (logType.equals("margin")){
            return displayItemMarginLogs(model);
        } else {
            model.addAttribute("Title","Uknown Log Type");
            return "merchants/merchant_margin_logs";
        }
    }

    @RequestMapping(value = "profit/logs")
    public String displayProfitLogs(Model model){
        model.addAttribute("title","Merchant Logs");

        return "merchants/merchant_profit_logs";
    }

    @RequestMapping(value = "profit/profitLog")
    public String displayLog(Model model){
        model.addAttribute("title","PLACEHOLDER WILL PUT PLAYER NAME");

        return "merchants/merchant_profit_log";
    }

    @RequestMapping(value = "profit/profitLog/create")
    public String displayCreateLogForm(Model model){
        model.addAttribute("title", "Create New Log");

        return "merchants/create_log";
    }

    /*
    @RequestMapping(value = "profitLog/create")
    public void processCreateLog(Model model, @RequestParam String logName, @RequestParam long gold){
        model.addAttribute("title", logName);

        displayLog(model);
    }
    */

    @RequestMapping(value = "margin/logs")
    public String displayItemMarginLogs(Model model){
        model.addAttribute("title", "Margin Logs");

        return "merchants/merchant_margin_logs";
    }
}
