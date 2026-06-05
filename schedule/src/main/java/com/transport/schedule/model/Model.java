package com.transport.schedule.model;

public class Model {

    public static class TransportSchedule {
           private Long id;

        private String busNumber;

        private String driverName;

        private int seatCapacity;

        private int availableSeats;

        private String routeName;

        private String departureTime;
    public TransportSchedule() {
        }

        public TransportSchedule(Long id,
                                 String busNumber,
                                 String driverName,
                                 int seatCapacity,
                                 int availableSeats,
                                 String routeName,
                                 String departureTime) {

            this.id = id;
            this.busNumber = busNumber;
            this.driverName = driverName;
            this.seatCapacity = seatCapacity;
            this.availableSeats = availableSeats;
            this.routeName = routeName;
            this.departureTime = departureTime;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getBusNumber() {
            return busNumber;
        }

        public void setBusNumber(String busNumber) {
            this.busNumber = busNumber;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public int getSeatCapacity() {
            return seatCapacity;
        }

        public void setSeatCapacity(int seatCapacity) {
            this.seatCapacity = seatCapacity;
        }

        public int getAvailableSeats() {
            return availableSeats;
        }

        public void setAvailableSeats(int availableSeats) {
            this.availableSeats = availableSeats;
        }

        public String getRouteName() {
            return routeName;
        }

        public void setRouteName(String routeName) {
            this.routeName = routeName;
        }

        public String getDepartureTime() {
            return departureTime;
        }

        public void setDepartureTime(String departureTime) {
            this.departureTime = departureTime;
        }

        @Override
        public String toString() {

            return "TransportSchedule{" +
                    "id=" + id +
                    ", busNumber='" + busNumber + '\'' +
                    ", driverName='" + driverName + '\'' +
                    ", seatCapacity=" + seatCapacity +
                    ", availableSeats=" + availableSeats +
                    ", routeName='" + routeName + '\'' +
                    ", departureTime='" + departureTime + '\'' +
                    '}';
        }
    }
}
