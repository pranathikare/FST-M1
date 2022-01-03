package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<String>();
    }

    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }

    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		

        Plane plane = new Plane(10);

        plane.onboard("abc");
        plane.onboard("def");
        plane.onboard("ghi");
        plane.onboard("jkl");
        plane.onboard("mno");
        plane.onboard("pqr");
        
        System.out.println("Plane took off at: " + plane.takeOff());

        System.out.println("People on the plane: " + plane.getPassengers());

        Thread.sleep(5000);

        plane.land();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    

	}

}
