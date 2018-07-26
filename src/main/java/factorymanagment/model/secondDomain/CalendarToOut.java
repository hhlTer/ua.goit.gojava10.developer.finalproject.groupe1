package factorymanagment.model.secondDomain;

import factorymanagment.model.domain.Event;
import factorymanagment.model.domain.Status;
import factorymanagment.model.domain.WorkHours;

/**
 * Calendar for out to schedule
 *
 * Fields:
 *
 * Status
 * Event
 *
 */
public class CalendarToOut {

    private Status status;

    private Event event;

    private WorkHours workHours;

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
