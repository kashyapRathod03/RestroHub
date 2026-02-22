package com.restrohub.qrmenu.admin.dashboard.controller;

import com.restrohub.qrmenu.admin.dashboard.dto.DashboardStatDTO;
import com.restrohub.qrmenu.admin.dashboard.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
@CrossOrigin(origins = "*") // adjust for production
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public List<DashboardStatDTO> getStats() {
        return dashboardService.getDashboardStats();
    }
}