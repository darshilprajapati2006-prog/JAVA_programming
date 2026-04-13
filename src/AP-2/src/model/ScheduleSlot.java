package model;

public class ScheduleSlot {
    private String day;
    private String startTime;
    private String endTime;
    private String room;
    private String slotLabel;

    public ScheduleSlot(String day, String startTime, String endTime, String room, String slotLabel) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.slotLabel = slotLabel;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getSlotLabel() {
        return slotLabel;
    }

    public void setSlotLabel(String slotLabel) {
        this.slotLabel = slotLabel;
    }

    public String toDisplayString() {
        return day + " " + startTime + " - " + endTime + " | " + room + " | Slot: " + slotLabel;
    }
}
