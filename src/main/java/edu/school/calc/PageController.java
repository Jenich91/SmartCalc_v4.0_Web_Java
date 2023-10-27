package edu.school.calc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PageController {
    ComputeCore computeCore = new ComputeCore("libcalcNativeLib.dylib");
    Graph graph = new Graph(computeCore);

    @GetMapping(value={"", "/", "calc"})
    public String home() {
            return "index";
    }

    @GetMapping("/getResult")
    public String calc(Model model, String exp, String x_value) {
        if(computeCore.validExpression(exp, x_value)) {
            model.addAttribute("result", computeCore.computeExpression(exp, x_value));
            History.addRecord(exp, x_value);
        } else {
            model.addAttribute("result", "ERROR");
        }
        return "index";
    }

    @GetMapping("/graph")
    public String graph(Model model) {
        return "graph";
    }

    @GetMapping("/history")
    public String history(Model model) {
        try {
            var historyRecords = History.getAllRecords();
            model.addAttribute("historyTable", historyRecords);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

        return "history";
    }

    @GetMapping("/clearHistory")
    public String historyClean(Model model) {
        try {
            History.clear();
            var historyRecords = History.getAllRecords();
            model.addAttribute("historyTable", historyRecords);
        } catch (Exception ex) {
            System.err.println(ex.toString());
        }

        return "history";
    }

    @GetMapping("/help")
    public String help(Model model) {
        return "help";
    }

    @GetMapping("/computeGraphValues")
    @ResponseBody
    public List<List<Double>> getGraphPoints(@RequestParam(name = "exp") String exp,
                                                       @RequestParam(defaultValue = "-10", required = false, name = "from") Double from,
                                                       @RequestParam(defaultValue = "-10", required = false, name = "to") Double to,
                                                       @RequestParam(defaultValue = "0.01", required = false, name = "step") Double step) {

        if(!computeCore.validExpression(exp, "")) return null;
        History.addRecord(exp, "\"range:("+from+" to:"+to+"), with step:"+step+"\" ");
        return graph.getPoints(exp, from, to, step);
    }

}
