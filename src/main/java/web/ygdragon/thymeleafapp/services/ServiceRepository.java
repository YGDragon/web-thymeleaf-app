package web.ygdragon.thymeleafapp.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import web.ygdragon.thymeleafapp.models.Device;
import web.ygdragon.thymeleafapp.repository.SystemRepository;

@Service
@Data
@AllArgsConstructor
public class ServiceRepository {
    private SystemRepository systemRepository;

    /**
     * adding new device to system repository
     * @param device new device
     */
    public void addDevice(Device device) {
        systemRepository.create(device);
    }

    /**
     * updating data of device in system repository
     * @param device updatable device
     */
    public void updateDevice(Device device) {
        systemRepository.update(device);
    }

    /**
     * deleting device from repository
     * @param id id of deletable device
     */
    public void deleteDevice(Long id) {
        systemRepository.delete(id);
    }
}
