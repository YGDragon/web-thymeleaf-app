package web.ygdragon.thymeleafapp.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.ygdragon.thymeleafapp.models.Device;
import web.ygdragon.thymeleafapp.services.ServiceRepository;

@Controller
@Data
@AllArgsConstructor
public class TemplateController {
    private ServiceRepository serviceRepository;

    /**
     * view all system devices from database
     * @param model Thymeleaf model
     * @return HTML view "/system"
     */
    @GetMapping("/system")
    public String viewSystem(Model model) {
        model.addAttribute(
                "devices",
                serviceRepository.getSystemRepository().getDevicesList());
        return "system";
    }

    /**
     * transition to form.html
     * @return HTML view "/form"
     */
    @GetMapping("/form")
    public String viewForm() {
        return "form";
    }

    /**
     * adding new system device to database
     * @param device new device
     * @return HTML view "/system"
     */
    @PostMapping("/form")
    public String addDevice(Device device) {
        serviceRepository.addDevice(device);
        return "redirect:/system";
    }

    /**
     * transition to update.html
     * @return HTML view "/update"
     */
    @GetMapping("/update/{id}")
    public String redirectUpdate(Model model, @PathVariable Long id) {
        model.addAttribute("device", new Device());
        model.addAttribute("ID", id);
        return "update";
    }

    /**
     * update data of device in system repository
     * @return HTML view "/system"
     */
    @PostMapping("/update/{id}")
    public String updateDevice(Device device, @PathVariable Long id) {
        device.setId(id);
        serviceRepository.updateDevice(device);
        return "redirect:/system";
    }

    /**
     * deleting device from system repository
     * @param id id deletable of device
     * @return HTML view "/system"
     */
    @GetMapping("/delete/{id}")
    public String deleteByID(@PathVariable Long id) {
        serviceRepository.deleteDevice(id);
        return "redirect:/system";
    }
}
