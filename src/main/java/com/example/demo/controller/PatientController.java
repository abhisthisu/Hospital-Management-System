package com.example.demo.controller;

import com.example.demo.dao.patientDAO;
import com.example.demo.model.patient;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    private patientDAO patientDAO;

    // ── Home: show all patients ──────────────────────────────────────
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patient", new patient());
        model.addAttribute("patients", patientDAO.findAll());
        model.addAttribute("totalPatients", patientDAO.count());
        model.addAttribute("editMode", false);
        return "patient";
    }

    // ── Add patient ──────────────────────────────────────────────────
    @PostMapping("/savePatient")
    public String savePatient(@Valid @ModelAttribute("patient") patient patient,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            model.addAttribute("patients", patientDAO.findAll());
            model.addAttribute("totalPatients", patientDAO.count());
            model.addAttribute("editMode", false);
            return "patient";
        }
        patientDAO.save(patient);
        redirectAttrs.addFlashAttribute("successMsg", "Patient added successfully!");
        return "redirect:/";
    }

    // ── Delete patient ───────────────────────────────────────────────
    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        patientDAO.deleteById(id);
        redirectAttrs.addFlashAttribute("successMsg", "Patient deleted.");
        return "redirect:/";
    }

    // ── Edit: load patient into form ─────────────────────────────────
    @GetMapping("/editPatient/{id}")
    public String editPatient(@PathVariable Long id, Model model) {
        patient existing = patientDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        model.addAttribute("patient", existing);
        model.addAttribute("patients", patientDAO.findAll());
        model.addAttribute("totalPatients", patientDAO.count());
        model.addAttribute("editMode", true);
        return "patient";
    }

    // ── Update patient ───────────────────────────────────────────────
    @PostMapping("/updatePatient")
    public String updatePatient(@Valid @ModelAttribute("patient") patient patient,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            model.addAttribute("patients", patientDAO.findAll());
            model.addAttribute("totalPatients", patientDAO.count());
            model.addAttribute("editMode", true);
            return "patient";
        }
        patientDAO.save(patient);
        redirectAttrs.addFlashAttribute("successMsg", "Patient updated successfully!");
        return "redirect:/";
    }

    // ── Search patients ──────────────────────────────────────────────
    @GetMapping("/searchPatient")
    public String searchPatient(@RequestParam String name, Model model) {
        List<patient> results = patientDAO.findByNameContainingIgnoreCase(name);
        model.addAttribute("patients", results);
        model.addAttribute("patient", new patient());
        model.addAttribute("totalPatients", patientDAO.count());
        model.addAttribute("searchQuery", name);
        model.addAttribute("editMode", false);
        return "patient";
    }
}