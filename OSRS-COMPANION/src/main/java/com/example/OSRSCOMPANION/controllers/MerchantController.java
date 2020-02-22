package com.example.OSRSCOMPANION.controllers;

import com.example.OSRSCOMPANION.models.merchantHelp.data.MarginLogDao;
import com.example.OSRSCOMPANION.models.merchantHelp.data.ProfitLogDao;
import com.example.OSRSCOMPANION.models.merchantHelp.itemMarginLog.marginLog;
import com.example.OSRSCOMPANION.models.merchantHelp.profitLog.profitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "merchant")
public class MerchantController {

    @Autowired
    private ProfitLogDao profitLogDao;

    @Autowired
    private MarginLogDao marginLogDao;

    //|||DIRECTOR|||

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

    //|||PROFIT LOG|||

    @RequestMapping(value = "profit/logs")
    public String displayProfitLogs(Model model){
        model.addAttribute("title","Merchant Logs");

        return "merchants/merchant_profit_logs";
    }

    @RequestMapping(value = "profit/log")
    public String displayProfitLog(Model model){
        model.addAttribute("title","PLACEHOLDER WILL PUT PLAYER NAME");

        return "merchants/merchant_profit_log";
    }

    //Create Profit Log

    @RequestMapping(value = "profit/create", method = RequestMethod.GET)
    public String displayCreateProfitLogForm(Model model){
        model.addAttribute("title", "Create New Log");
        model.addAttribute(new profitLog());

        return "merchants/createProfitLog";
    }

    @RequestMapping(value = "profit/create", method = RequestMethod.POST)
    public String displayCreateProfitLogForm(Model model, @ModelAttribute @Valid profitLog profitLog,Errors errors){

        if (errors.hasErrors()){
            model.addAttribute("title","Create Log");
            return "merchants/createProfitLog";
        }

        profitLogDao.save(profitLog);

        return "redirect:log?logId=" + profitLog.getId();

    }

    //|||MARGIN LOG|||

    @RequestMapping(value = "margin/logs")
    public String displayItemMarginLogs(Model model){
        model.addAttribute("title", "Margin Logs");

        return "merchants/merchant_margin_logs";
    }

    @RequestMapping(value = "margin/log")
    public String displayMarginLog(Model model){
        model.addAttribute("title","Margin Log");

        return "merchants/merchant_margin_log";
    }

    //Create Margin Log

    @RequestMapping(value = "margin/create", method = RequestMethod.GET)
    public String displayCreateMarginLogForm(Model model){
        model.addAttribute("title", "Create New Log");
        model.addAttribute(new marginLog());

        return "merchants/createMarginLog";
    }
}
