package com.izzy.ninja_gold_game.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @RequestMapping("/")
  public String index(
      HttpSession session,
      // Need to check values below using @RequestParam
      @RequestParam(value = "farm", required = false) String farm,
      @RequestParam(value = "cave", required = false) String cave,
      @RequestParam(value = "house", required = false) String house,
      @RequestParam(value = "quest", required = false) String quest) {

    int gold = 0;

    ArrayList<String> activities = new ArrayList<String>();
    // activities.add("test 1");
    // activities.add("test 2");

    // vvvvvvvvvvv====== TO ADD A DATE STAMP ======vvvvvvvvvvvvv
    SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d Y h:mm a");

    // Use SESSION to save
    // session.setAttribute("gold", gold);
    // Need to check first if gold is saved in session
    if (session.getAttribute("gold") == null) {// <-- if null
      session.setAttribute("gold", gold); // <-- set to 0
      session.setAttribute("activities", activities);
    } else {
      gold = (int) session.getAttribute("gold");
      // ^^^ convert to (int) - we do not want the Object
      activities = (ArrayList<String>) session.getAttribute("activities");
      // ^^^ just a warning - unchecked cast from Object to ArrayList (ok to leave)
    }

    if (farm != null) {
      // vvvvvv===== TO GENERATE A RANDOM INTEGER from 10-20 =====vvvvvvvv
      int amount = new Random().nextInt(10, 21);
      gold += amount;
      activities.add(0, "You entered a farm and earned " + amount + " gold. (" + simpleFormat.format(new Date()) + ")");
      // assign index 0 ^^^ so the most recent activity shows up on top
      session.setAttribute("activities", activities);
      session.setAttribute("gold", gold);
      return "redirect:/";
    }

    if (cave != null) {
      // vvvvvv===== TO GENERATE A RANDOM INTEGER from 5-10 =====vvvvvvvv
      int amount = new Random().nextInt(5, 11);
      gold += amount;
      activities.add(0, "You entered a cave and earned " + amount + " gold. (" + simpleFormat.format(new Date()) + ")");
      // assign index 0 ^^^ so the most recent activity shows up on top
      session.setAttribute("activities", activities);
      session.setAttribute("gold", gold);
      return "redirect:/";
    }

    if (house != null) {
      // vvvvvv===== TO GENERATE A RANDOM INTEGER from 2-5 =====vvvvvvvv
      int amount = new Random().nextInt(2, 6);
      gold += amount;
      activities.add(0,
          "You entered a house and earned " + amount + " gold. (" + simpleFormat.format(new Date()) + ")");
      // assign index 0 ^^^ so the most recent activity shows up on top
      session.setAttribute("activities", activities);
      session.setAttribute("gold", gold);
      return "redirect:/";
    }

    if (quest != null) {
      // vvvvvv===== TO GENERATE A RANDOM INTEGER from -50 to 50 =====vvvvvvvv
      int amount = new Random().nextInt(-50, 51);
      gold += amount;
      // Need an if/else statement to display appropriate message
      if (amount > 0) {
        activities.add(0,
            "You completed a quest and earned " + amount + " gold. (" + simpleFormat.format(new Date()) + ")");
      } else {
        activities.add(0, "You failed a quest and lost " + (amount*-1) + " gold. (" + simpleFormat.format(new Date()) + ")");
      }
      session.setAttribute("activities", activities);
      session.setAttribute("gold", gold);
      return "redirect:/";
    }

    return "index.jsp";
  }

}
