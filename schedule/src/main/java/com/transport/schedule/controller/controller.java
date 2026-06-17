package com.transport.schedule.controller;

import com.transport.schedule.model.Model;
import com.transport.schedule.services.Services;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
public class Controller {

    private final Services.ScheduleService scheduleService =
            new Services.ScheduleService();

    @GetMapping
    public String home() {

        return "Transport Management System Running";
    }

    @GetMapping("/api")
    public List<Model.TransportSchedule>
    getAllSchedules() {

        return scheduleService.getAllSchedules();
    }

    @PostMapping("/schedules")
    public String addSchedule(
            @RequestBody Model.TransportSchedule schedule) {

        return scheduleService.addSchedule(schedule);
    }

    @GetMapping("/search/{route}/{time}")
    public String searchBus(

            @PathVariable String route,

            @PathVariable String time) {

        return scheduleService.searchBus(route, time);
    }

    @GetMapping("/time/{time}")
    public String searchBusByTime(

            @PathVariable String time) {

        return scheduleService
                .searchBusByTime(time);
    }

    @PutMapping("/schedules/{busNumber}/{departureTime}")
    public String updateSchedule(

            @PathVariable String busNumber,

            @PathVariable String departureTime,

            @RequestBody Model.TransportSchedule updatedSchedule) {

        return scheduleService.updateSchedule(
                busNumber,
                departureTime,
                updatedSchedule
        );
    }

    @DeleteMapping("/schedules/{busNumber}/{departureTime}")
    public String deleteSchedule(

            @PathVariable String busNumber,

            @PathVariable String departureTime) {

        return scheduleService.deleteSchedule(
                busNumber,
                departureTime
        );
    }
}
