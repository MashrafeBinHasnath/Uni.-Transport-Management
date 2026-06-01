package com.transport.schedule.services;

import com.transport.schedule.model.Model;

import java.util.ArrayList;
import java.util.List;

public class Services {
    public static class ScheduleService {
        private final List<Model.TransportSchedule>
                scheduleList = new ArrayList<>();

        private Long nextId = 1L;
        public String addSchedule(
                Model.TransportSchedule newSchedule) {

            // Check duplicate bus + same time
            for (Model.TransportSchedule schedule
                    : scheduleList) {

                boolean sameBus =
                        schedule.getBusNumber()
                                .equalsIgnoreCase(
                                        newSchedule.getBusNumber()
                                );

                boolean sameTime =
                        schedule.getDepartureTime()
                                .equalsIgnoreCase(
                                        newSchedule.getDepartureTime()
                                );

                if (sameBus && sameTime) {

                    return "Bus already exists";
                }
            }

            newSchedule.setId(nextId++);

            
            scheduleList.add(newSchedule);

            return "Schedule added successfully";
        }
        public List<Model.TransportSchedule>
        getAllSchedules() {

            return scheduleList;
        }
        public String searchBus(String routeName,
                                String departureTime) {

            StringBuilder result =
                    new StringBuilder();

            for (Model.TransportSchedule schedule
                    : scheduleList) {

                boolean sameRoute =
                        schedule.getRouteName()
                                .equalsIgnoreCase(routeName);

                boolean sameTime =
                        schedule.getDepartureTime()
                                .equalsIgnoreCase(departureTime);

                if (sameRoute && sameTime) {

                    result.append(
                            "\nBus Number: "
                                    + schedule.getBusNumber()

                                    + " | Driver: "
                                    + schedule.getDriverName()

                                    + " | Available Seats: "
                                    + schedule.getAvailableSeats()
                    );
                }
            }

            if (result.isEmpty()) {

                return "No Bus Available";
            }

            return result.toString();
        }
        public String searchBusByTime(
                String departureTime) {

            StringBuilder result =
                    new StringBuilder();

            for (Model.TransportSchedule schedule
                    : scheduleList) {

                boolean sameTime =
                        schedule.getDepartureTime()
                                .equalsIgnoreCase(departureTime);

                if (sameTime) {

                    result.append(
                            "\nBus Number: "
                                    + schedule.getBusNumber()

                                    + " | Driver: "
                                    + schedule.getDriverName()

                                    + " | Route: "
                                    + schedule.getRouteName()

                                    + " | Available Seats: "
                                    + schedule.getAvailableSeats()
                    );
                }
            }

            if (result.isEmpty()) {

                return "No Bus Available";
            }

            return result.toString();
        }
        public String updateSchedule(
                String busNumber,
                String departureTime,
                Model.TransportSchedule updatedSchedule) {

            for (Model.TransportSchedule schedule
                    : scheduleList) {

                boolean sameBus =
                        schedule.getBusNumber()
                                .equalsIgnoreCase(busNumber);

                boolean sameTime =
                        schedule.getDepartureTime()
                                .equalsIgnoreCase(departureTime);

                if (sameBus && sameTime) {

                    schedule.setDriverName(
                            updatedSchedule.getDriverName());

                    schedule.setSeatCapacity(
                            updatedSchedule.getSeatCapacity());

                    schedule.setAvailableSeats(
                            updatedSchedule.getAvailableSeats());

                    schedule.setRouteName(
                            updatedSchedule.getRouteName());

                    schedule.setDepartureTime(
                            updatedSchedule.getDepartureTime());

                    return "Schedule updated successfully";
                }
            }

            return "Schedule not found";
        }
        public String deleteSchedule(
                String busNumber,
                String departureTime) {

            for (Model.TransportSchedule schedule
                    : scheduleList) {

                boolean sameBus =
                        schedule.getBusNumber()
                                .equalsIgnoreCase(busNumber);

                boolean sameTime =
                        schedule.getDepartureTime()
                                .equalsIgnoreCase(departureTime);

                if (sameBus && sameTime) {

                    scheduleList.remove(schedule);

                    return "Schedule deleted successfully";
                }
            }

            return "Schedule not found";
        }
    }
}