package web.ygdragon.thymeleafapp.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import web.ygdragon.thymeleafapp.models.Device;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class SystemRepository {
    private List<Device> devicesList;
    private Long counter;

    // constructor with initial data
    public SystemRepository() {
        counter = 1L;
        devicesList = new ArrayList<>();
        devicesList.add(new Device(counter++, "Контроллер", "800M", 3));
        devicesList.add(new Device(counter++, "Модуль", "AI833", 3));
        devicesList.add(new Device(counter++, "Барьер искрозащиты", " MTL4541", 32));
    }

    /**
     * creating new device to system repository
     *
     * @param device new device
     * @return list of repository devices
     */
    public List<Device> create(Device device) {
        device.setId(counter++);
        devicesList.add(device);
        return devicesList;
    }

    /**
     * finding device by id
     *
     * @param id device id
     * @return fined device
     */
    public Device findById(Long id) {
        return devicesList.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElse(null);
    }

    /**
     * updating data of device in repository
     *
     * @param device updatable device
     */
    public void update(Device device) {
        int index = Math.toIntExact(device.getId() - 1);
        devicesList.set(index, device);
    }

    /**
     * deleting device from system repository
     *
     * @param id ID of deletable device
     */
    public void delete(Long id) {
        devicesList.remove(findById(id));
        counter--;
        devicesList.forEach(
                d -> {
                    Long i = d.getId();
                    if (i > id) {
                        i--;
                        d.setId(i);
                    }
                });
    }
}
