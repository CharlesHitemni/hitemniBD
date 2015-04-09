/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hitemni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hitemni.dao.UtilisateurPersonnaliteI;
import com.hitemni.model.UtilisateurPersonnalite;

@Controller
@RequestMapping(value = "/")
public class UtilisateurPersonnaliteController {
    @Autowired
    private UtilisateurPersonnaliteI UtilisateurPersonnalite;

    @RequestMapping(method = RequestMethod.GET)
    public String displaySortedUtilisateurPersonnalites(Model model) {
        model.addAttribute("newUtilisateurPersonnalite", new UtilisateurPersonnalite());
        model.addAttribute("UtilisateurPersonnalites", UtilisateurPersonnalite.listeUtilisateurPersonnalite());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String registerNewUtilisateurPersonnalite(@ModelAttribute("newUtilisateurPersonnalite") UtilisateurPersonnalite newUtilisateurPersonnalite, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            try {
                UtilisateurPersonnalite.creerUtilisateurPersonnalite(newUtilisateurPersonnalite);
                return "redirect:/";
            } catch (UnexpectedRollbackException e) {
                model.addAttribute("UtilisateurPersonnalites", UtilisateurPersonnalite.listeUtilisateurPersonnalite());
                model.addAttribute("error", e.getCause().getCause());
                return "index";
            }
        } else {
            model.addAttribute("UtilisateurPersonnalites", UtilisateurPersonnalite.listeUtilisateurPersonnalite());
            return "index";
        }
    }
}
