/*Let's consider a real-life example of a weather station and weather display devices to illustrate the Observer design pattern.

```java*/
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface WeatherStation {
    void registerDisplay(DeviceDisplay display);
    void removeDisplay(DeviceDisplay display);
    void notifyDisplays();
}

// Observer interface
interface DeviceDisplay {
    void update(int temperature);
}

// Concrete subject
class WeatherMonitoringStation implements WeatherStation {
    private List<DeviceDisplay> displays = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyDisplays();
    }

    @Override
    public void registerDisplay(DeviceDisplay display) {
        displays.add(display);
    }

    @Override
    public void removeDisplay(DeviceDisplay display) {
        displays.remove(display);
    }

    @Override
    public void notifyDisplays() {
        for (DeviceDisplay display : displays) {
            display.update(temperature);
        }
    }
}

// Concrete observer
class MobileDeviceDisplay implements DeviceDisplay {
    private WeatherMonitoringStation station;

    public MobileDeviceDisplay(WeatherMonitoringStation station) {
        this.station = station;
        station.registerDisplay(this);
    }

    @Override
    public void update(int temperature) {
        System.out.println("Mobile Display: Current temperature is " + temperature + "°C");
    }
}

// Main program
class WeatherStationExample {
    public static void main(String[] args) {
        // Create weather station and displays
        WeatherMonitoringStation station = new WeatherMonitoringStation();
        MobileDeviceDisplay mobileDisplay1 = new MobileDeviceDisplay(station);
        MobileDeviceDisplay mobileDisplay2 = new MobileDeviceDisplay(station);

        // Change the temperature
        station.setTemperature(25);
        station.setTemperature(30);
    }
}
/*
```

In this example, we have a `WeatherStation` interface that defines methods for registering, removing, and notifying displays. The `DeviceDisplay` interface represents the displays that will show the weather information and it has an `update` method.

The `WeatherMonitoringStation` class implements the `WeatherStation` interface and maintains a list of displays. It has methods to register, remove, and notify the displays, as well as a `setTemperature` method to update the temperature.

The `MobileDeviceDisplay` class implements the `DeviceDisplay` interface and keeps a reference to the weather monitoring station it is associated with. It registers itself with the station in its constructor and implements the `update` method to show the updated temperature on a mobile device.

In the `main` function, we create a `WeatherMonitoringStation` object and two `MobileDeviceDisplay` objects. We then change the temperature twice, which triggers the displays' `update` method, resulting in the updated temperature being shown on the mobile devices.

This example illustrates the Observer pattern in the context of a weather station and mobile device displays, where the weather station notifies the displays whenever the temperature changes.
*/
