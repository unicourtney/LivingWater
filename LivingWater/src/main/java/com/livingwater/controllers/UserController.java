package com.livingwater.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController{

    //----------------------Navigation

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping(value = "/inventory/bottles", method = RequestMethod.GET)
    public ModelAndView inventoryBottlesPage() {
        ModelAndView view = new ModelAndView("inventory-bottles");
        return view;
    }

    @RequestMapping(value = "/inventory/batch", method = RequestMethod.GET)
    public ModelAndView inventoryBatchPage() {
        ModelAndView view = new ModelAndView("inventory-batch");
        return view;
    }

    @RequestMapping(value = "/inventory/supplies", method = RequestMethod.GET)
    public ModelAndView inventorySuppliesPage() {
        ModelAndView view = new ModelAndView("inventory-supplies");
        return view;
    }

    @RequestMapping(value = "/profiles/customers", method = RequestMethod.GET)
    public ModelAndView customerProfilesPage() {
        ModelAndView view = new ModelAndView("customer-profiles");
        return view;
    }

    @RequestMapping(value = "/profiles/delivery-teams", method = RequestMethod.GET)
    public ModelAndView deliveryTeamProfilesPage() {
        ModelAndView view = new ModelAndView("delivery-team-profiles");
        return view;
    }

    @RequestMapping(value = "/profiles/employees", method = RequestMethod.GET)
    public ModelAndView employeeProfilesPage() {
        ModelAndView view = new ModelAndView("employee-profiles");
        return view;
    }

    @RequestMapping(value = "/sales/delivery", method = RequestMethod.GET)
    public ModelAndView salesDeliveryPage() {
        ModelAndView view = new ModelAndView("sales-delivery");
        return view;
    }

    @RequestMapping(value = "/sales/refilling", method = RequestMethod.GET)
    public ModelAndView salesRefillingPage() {
        ModelAndView view = new ModelAndView("sales-refilling");
        return view;
    }

    @RequestMapping(value = "/sales/dispensers", method = RequestMethod.GET)
    public ModelAndView salesDispensersPage() {
        ModelAndView view = new ModelAndView("sales-dispensers");
        return view;
    }

    @RequestMapping(value = "/profiles/customers/info", method = RequestMethod.GET)
    public ModelAndView customerInfoPage() {
        ModelAndView view = new ModelAndView("customer-info");
        return view;
    }

    @RequestMapping(value = "/profiles/delivery-teams/info", method = RequestMethod.GET)
    public ModelAndView deliveryTeamInfoPage() {
        ModelAndView view = new ModelAndView("delivery-team-info");
        return view;
    }

    @RequestMapping(value = "/profiles/employees/info", method = RequestMethod.GET)
    public ModelAndView employeeInfoPage() {
        ModelAndView view = new ModelAndView("employee-info");
        return view;
    }

    @RequestMapping(value = "/inventory/supplies/info", method = RequestMethod.GET)
    public ModelAndView supplyInfoPage() {
        ModelAndView view = new ModelAndView("supply-info");
        return view;
    }

    @RequestMapping(value = "/profiles/customers/delivery", method = RequestMethod.GET)
    public ModelAndView deliveryPage() {
        ModelAndView view = new ModelAndView("customer-delivery");
        return view;
    }

    @RequestMapping(value = "/profiles/customers/rent-dispenser", method = RequestMethod.GET)
    public ModelAndView rentDispenserPage() {
        ModelAndView view = new ModelAndView("customer-dispensers");
        return view;
    }
    //----------------------Login

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        ModelAndView view = new ModelAndView("inventory-bottles");

        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");

        System.out.println("USER ID: " + user_id + "\nPASSWORD: " + password);
        return view;
    }

    //----------------------Add

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        ModelAndView view = new ModelAndView("employee-profiles");
        String user_name = request.getParameter("user_name");
        String username = request.getParameter("username");
        String password = DigestUtils.md5DigestAsHex(request.getParameter("user_password").getBytes());
        String user_role = request.getParameter("user_role");

        System.out.println("NAME: " + user_name
                + "\nUSERNAME: " + username
                + "\nPASSWORD: " + password
                + "\nROLE: " + user_role);

        return view;
    }

    //----------------------Delete
}
